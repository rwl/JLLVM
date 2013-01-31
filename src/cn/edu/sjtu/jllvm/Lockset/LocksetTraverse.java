package cn.edu.sjtu.jllvm.Lockset;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;

public class LocksetTraverse {
	private Hashtable<String, FunctionCache> functionCache;
	private Module cfg;
	
	boolean INTERPROCEDURAL = false;
	
	public Hashtable<String, FunctionCache> getFunctionCache(){
		return functionCache;
	}
	
	public void traverse_cfg(Module cfg){
		this.cfg = cfg;
		List<Function> functions = cfg.getFunctions();
		Function main = cfg.getMain();
		
		functionCache = new Hashtable<String, FunctionCache>();
		for(Function fn: functions){
			functionCache.put(fn.getFunctionName(), new FunctionCache());
		}
		
		//traverse_fn(main, new Lockset());
		for(Function fn: functions){
			traverse_fn(fn, new Lockset());
		}
/*		List<String> keys = new ArrayList<String>(functionCache.keySet());
		for(String key:keys){
			FunctionCache cache = functionCache.get(key);
			System.out.println(key+":\n"+cache.toString());
		}*/
	}
	
	public List<Lockset> traverse_fn(Function fn, Lockset ls){
		FunctionCache cache = functionCache.get(fn.getFunctionName());
		List<Lockset> locksets = cache.getLockSets(ls);
		if(locksets != null)
			return locksets;
		
		if(cache.onStack())
			return new ArrayList<Lockset>();
		
		cache.setOnStack();
		
		Edge edge = new Edge(ls);
		List<Lockset> exitSets = traverse_blocks(fn, fn.getEntry(), ls, ls.copy());	//exitSets mustn't be null
		edge.setExit_locksets(exitSets);
		
		cache.setOffStack();
		
		cache.addLocksets(edge);
		
		return exitSets;
	}
	
	//Use BasicBlock instead of stmt, this can save cache space.
	//And this will not wrong, because BasicBlock is the basic unit of a CFG.
	public List<Lockset> traverse_blocks(Function fn, BasicBlock bb, Lockset entry_ls, Lockset ls){
		FunctionCache cache = functionCache.get(fn.getFunctionName());
		//cache
		LocksetPair pair = new LocksetPair(entry_ls, ls);
		if(cache.containsLocksetPair(bb.getBlockID(), pair)){
			return new ArrayList<Lockset>();	//{}
		}
		cache.addLocksetPair(bb.getBlockID(), pair);
		
		List<Instruction> instructions = bb.getInstructions();
		
		List<Lockset> worklist = new ArrayList<Lockset>();	
		worklist.add(ls);
		
		//traverse each instruction
		for(Instruction inst: instructions){
			switch(inst.getOpcode()){
				case InstType.callInst:	//lock , unlock, other calls
					if(isLock(inst)){	//lock
						cache.relateToLock();
						
						Constant expr = inst.getOperand(1);
						
						String lockName = null;						
						if(expr.isGlobalVariable()){
							lockName = "@"+expr.toString()+":"+inst.getType(1).toString();
						}else if(expr.isLocalVariable()){
							int instIndex = instructions.indexOf(inst);
							lockName = getLockType(fn, bb, expr.toString(), instIndex-1);	//inst.getType(1).toString();	//parese instructions reversely
						}

						if(lockName!=null){
							Lock lock = new Lock(lockName);
							ls.addLock(lock);
						}
					}else if(isUnlock(inst)){	//unlock
						cache.relateToLock();
						
						Constant expr = inst.getOperand(1);
						
						String lockName = null;						
						if(expr.isGlobalVariable()){
							lockName = "@"+expr.toString()+":"+inst.getType(1).toString();
						}else if(expr.isLocalVariable()){
							int instIndex = instructions.indexOf(inst);
							lockName = getLockType(fn, bb, expr.toString(), instIndex-1); 	//+inst.getType(1).toString();	//parese instructions reversely
						}
						
						if(lockName!=null){
							Lock lock = new Lock(lockName);
							ls.removeLock(lock);
						}
					}else{		//other calls, if not interprocedural, ignore.
						if(INTERPROCEDURAL){
							String name = inst.getOperand(0).toString();
							Function next_f = cfg.getFunction(name);
							if(next_f == null)//this function is unsolved, ignore it.
								continue;	
							
							//function pointer is unsolved
							
							List<Lockset> tempList = new ArrayList<Lockset>();
							for(Lockset lockset: worklist){
								tempList.addAll(traverse_fn(next_f, lockset.copy()));
							}
							
							mergeLocksetList(worklist, tempList);
						}
					}
				default:
					if(inst.isTerminator()){	//end of a BasicBlock: br switch ret...
						if(bb.hasSuccessor()){
							List<BasicBlock> successors = bb.getSuccessors();
							
							List<Lockset> tempList2 = new ArrayList<Lockset>();
							for(BasicBlock nextBb: successors){
								for(Lockset lockset: worklist){
									tempList2.addAll(traverse_blocks(fn, nextBb, lockset, lockset.copy()));
								}
							}
							
							mergeLocksetList(worklist, tempList2);
						}else{
							return worklist;
						}
					}
			}
		}
		
		return worklist;
	}
	
	public void mergeLocksetList(List<Lockset> locklist, List<Lockset> target){
		if(target.size()==0)
			return;
		for(Lockset tar: target){
			boolean contains = false;
			for(Lockset lockset:locklist){
				if(tar.equals(lockset)){
					contains = true;
					break;
				}
			}
			
			if(!contains){
				locklist.add(tar);
			}
		}
	}
	
	
	/**
	 * @param fn	function
	 * @param bb	basic block
	 * @param var	id
	 * @param instIndex		block's instruction index
	 * @return		reversely visit block's instructions and find all info about lock id.
	 */
	public static String getLockType(Function fn, BasicBlock bb, String var, int instIndex){
		String returnStr = "";
		
		List<Instruction> instructions = bb.getInstructions();
		for(int i=instIndex; i>=0; i--){
			Instruction inst = instructions.get(i);
			if(inst.isLoad()){
				String dest = inst.getDest().toString();
				if(dest.equals(var)){
					returnStr=inst.getType(0).toString()+"."+returnStr;
					Constant expr = inst.getOperand(0);
					
					if(expr.isGlobalVariable()){	//end and return
						returnStr = "@"+expr.toString()+":"+returnStr;
						return returnStr;
					}else if(expr.isLocalVariable()){
						var = expr.toString();
					}else{
						return returnStr;
					}
				}
			}else if(inst.isGetElePtr()){
				String dest = inst.getDest().toString();
				if(dest.equals(var)){
					returnStr = inst.getType(0).toString()+"."+returnStr;
					Constant expr = inst.getOperand(0);
					
					if(expr.isGlobalVariable()){
						returnStr = "@"+expr.toString()+":"+returnStr;
						return returnStr;
					}else if(expr.isLocalVariable()){
						var = expr.toString();
					}else{
						return returnStr;
					}
				}
			}else if(inst.isBitcast()){
				String dest = inst.getDest().toString();
				if(dest.equals(var)){
					var = inst.getOperand(0).toString();
				}
			}
		}
		
		BasicBlock nextBb = fn.getPreBasicBlock(bb);
		if(nextBb!=null){
			returnStr = getLockType(fn, nextBb, var, nextBb.getNumInst()-2) +returnStr;	//next basicblock's terminator inst is ignored
		}else{	// get function argument info
			int argNum = fn.getNumArgument();
			for(int i=0; i<argNum; i++){
				String arg = fn.getArgumentExpression(i).toString();
				if(arg.equals(var)){
					returnStr = "%"+arg+":"+fn.getArgumentType(i).toString()+"."+returnStr;
					break;
				}
			}
		}
		
		return returnStr;
	}
	
	private static boolean isLock(Instruction inst){
		String name = inst.getOperand(0).toString();
		if(name.equals("pthread_mutex_lock"))
			return true;
		
		return false;
	}
	
	private static boolean isUnlock(Instruction inst){
		String name = inst.getOperand(0).toString();
		if(name.equals("pthread_mutex_unlock"))
			return true;
		
		return false;
	}
}
