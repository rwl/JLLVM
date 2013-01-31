package cn.edu.sjtu.jllvm.VMCore.Constants;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Argument;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Cell;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

public class Function extends GlobalValue{
	private Type returnType;
	private String functionName;
	private List<BasicBlock> blockList;
	private Hashtable<String, BasicBlock> blockTable;
	
	private Hashtable<String, Constant> localVarTable;
	private List<Argument> arguments;
	private List<Constant> argExprs;
	private List<Type> argTypes;
	boolean isVararg;
	private Module parent;

	private Cell[] locals;
	
	public Function(String linkage, String visibility, String cconv,
			List<String> pAttributes, 
			Type returnType, String name,
			List<Argument> arguments,
			boolean isVarargFunction,
			List<String> fAttributes,
			int align,
			List<BasicBlock> basicBlocks
			){
		this.returnType = returnType;
		this.functionName = name;
		
		this.blockList = basicBlocks;
		blockTable = new Hashtable<String, BasicBlock>();
		boolean first=true;
		BasicBlock entry = null;
		for(BasicBlock bb: basicBlocks){
			bb.setParent(this);
			blockTable.put(bb.getBlockID(), bb);
			if(first){
				entry = bb;
				first =false;
			}
		}
		entry.parse(blockTable);
		
		localVarTable = new Hashtable<String, Constant>();
		
		argExprs = new ArrayList<Constant>();
		argTypes = new ArrayList<Type>();
		
		this.arguments = arguments;
		for(Argument arg: arguments){
			arg.setParent(this);
			Constant constant = arg.getExpr();
			argExprs.add(constant);
			argTypes.add(arg.getType());
			
			localVarTable.put(constant.toString(), constant);
		}
		
		for(BasicBlock bb: basicBlocks){
			for(Instruction inst: bb.getInstructions()){
				Constant c = inst.getDest();
				if(c!=null){
					localVarTable.put(c.toString(), c);
				}
			}
		}
		
		isVararg = isVarargFunction;
		
		List<Type> funList = new ArrayList<Type>();
		funList.add(returnType);
		funList.addAll(argTypes);
		setType(TypeFactory.getFunctionType(funList, isVararg));
	}
	
	public void syntaxAnalysis(Hashtable<String, Integer> globalVarTable){
		Hashtable<String, Integer> localVarIntTable = new Hashtable<String, Integer> ();
		
		List<Cell> localList = new ArrayList<Cell>();
		localList.add(new Cell());	
		
		int index = 1;	
		
		for(Constant arg: argExprs){
			localList.add(new Cell());
			localVarIntTable.put(arg.toString(), index);
			index++;
		}
		
		for(BasicBlock bb: blockList){	//let all local variables be digit 
//			index = bb.syntaxAnalysis(globalVarTable, localVarIntTable, index, localList);
			index = bb.syntaxAnalysis(globalVarTable, localVarIntTable, index, localList);
		}
		
		locals = localList.toArray(new Cell[localList.size()]);
		
		for(BasicBlock bb: blockList){
			for(Instruction inst: bb.getInstructions()){
				Constant dest = inst.getDest();
				if(dest!=null){
					dest.setType(inst.getType());
				}
			}
		}
	}
	
	public List<Instruction> getUseDefChain(Constant c){
		List<Instruction> chain = new ArrayList<Instruction>();
		boolean global = false;
		String varStr = c.toString();
		
		if(!c.isLocalVariable()){
			if(c.isGlobalVariable()) {
				global = true;
			}
			else {
				return chain;
			}
		}
		
		for(BasicBlock bb: blockList){
			for(Instruction inst: bb.getInstructions()){
				
				if(!global){
					Constant dest = inst.getDest();
					
					if(dest!=null){
						if(dest.toString().equals(c.toString())){
							chain.add(inst);
							continue;
						}
					}
				}
				
				for(Constant var: inst.getOperands()){
					if(var.isGlobalVariable()){
						if(global){
							if(var.toString().equals(varStr)){
								chain.add(inst);
								break;
							}
						}
					}else if(var.isLocalVariable()){
						if(!global){
							if(var.toString().equals(varStr)){
								chain.add(inst);
								break;
							}
						}
					}
				}
			}
		}
		
		return chain;
	}
	
	public Cell getLocal(int index){
		if(index<0 || index>locals.length-1)
			return null;
		return locals[index];
	}
	
	public Cell[] getLocals(){
		return locals;
	}
	
	public int getNumArgument(){
		return argExprs.size();
	}
	
	public List<Argument> getArguments() {
		return arguments;
	}

	public Constant getArgumentExpression(int index){
		return argExprs.get(index);
	}
	
	public Type getArgumentType(int index){
		return argTypes.get(index);
	}
	
	public Type getReturnType() {
		return returnType;
	}

	public String getFunctionName() {
		return functionName;
	}
	
	public BasicBlock getPreBasicBlock(BasicBlock bb){
		int index = blockList.indexOf(bb);
		if(index>0)
			return blockList.get(index - 1);
		return null;
	}

	public BasicBlock getBasicBlock(int index){
		return blockList.get(index);
	}
	
	public List<BasicBlock> getBasicBlocks() {
		return blockList;
	}

	public Hashtable<String, BasicBlock> getBlockTable() {
		return blockTable;
	}

	public BasicBlock getEntry() {
		return blockList.get(0);
	}

	public boolean isVarArg() {
		return false;
	}
	public boolean isDeclaration() {
		return blockList.isEmpty();
	}
	
	public Hashtable<String, Constant> getLocalVarTable() {
		return localVarTable;
	}
	
	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString(){
		String value="function:" +functionName+"\n";
		for(BasicBlock bb: blockList){
			value+=bb.toString()+"\n\n";
		}
		return value;
	}
}
