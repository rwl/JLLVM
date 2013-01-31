package cn.edu.sjtu.jllvm.VMCore;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

/**
 * @author liuhao 2011-12-21
 *	This class represents a single entry single exit section of the code, 
 *	commonly known as a basic block by the compiler community. 
 *	The BasicBlock class maintains a list of Instructions, 
 *	which form the body of the block. Matching the language definition, 
 *	the last element of this list of instructions is always a terminator instruction (a subclass of the TerminatorInst class).
 */
public class BasicBlock extends Value{
	private String blockID;
	private List<Instruction> instructions;
	private List<BasicBlock> successors;
	private List<BasicBlock> predecessors;
	private Function parent;
	
	public static boolean CONTACT = true;
	
	public BasicBlock(String basicID, List<Instruction> instructions){
		this.blockID = basicID;
		this.instructions = instructions;
		int size = instructions.size();
		
		Instruction preInst = null, nextInst = null;
		for(int i = 0; i<size; i++){
			Instruction inst = instructions.get(i);
			if(i+1<size){
				nextInst = instructions.get(i+1);
			}else{
				nextInst = null;
			}
			
			inst.setPreInst(preInst);
			inst.setNextInst(nextInst);
			inst.setParent(this);
		}
	
		successors = new ArrayList<BasicBlock>();
		predecessors = new ArrayList<BasicBlock>();
		
		setType(TypeFactory.getLabelType());
	}
	
	public void parse(Hashtable<String, BasicBlock> bbBlocks){
		if(hasSuccessor())
			return;
		Instruction terminator = instructions.get(instructions.size()-1);
		int numOperands = terminator.getNumOperands();
		switch(terminator.getOpcode()){
			case InstType.brInst:
				//  br i1 <cond>, label <iftrue>, label <iffalse>
				//  br label <dest>          ; Unconditional branch
				if(numOperands==1){	//unconditional br
					BasicBlock s = bbBlocks.get(terminator.getOperand(0).toString());
					successors.add(s);
					s.addPredecessor(this);
					s.parse(bbBlocks);
				}else{	//conditional br
					BasicBlock s = bbBlocks.get(terminator.getOperand(1).toString());
					BasicBlock s2 = bbBlocks.get(terminator.getOperand(2).toString());
					successors.add(s);
					s.addPredecessor(this);
					successors.add(s2);
					s2.addPredecessor(this);
					s.parse(bbBlocks);
					s2.parse(bbBlocks);
				}
				break;
			case InstType.switchInst:
				//  switch <intty> <value>, label <defaultdest> [ <intty> <val>, label <dest> ... ]

				for(int i=1; i<numOperands; ){
					BasicBlock s = bbBlocks.get(terminator.getOperand(i).toString());
					successors.add(s);
					s.addPredecessor(this);
					s.parse(bbBlocks);
					i+=2;
				}
				break;
			default:
				//ret, unreachable;  unhandled: indirectbr, invoke, unwind
				break;
		}
	}
	
	public int syntaxAnalysis(Hashtable<String, Integer> globalVarTable, Hashtable<String, Integer> localVarTable,
				int index, List<Cell> localList){
		
		for(Instruction inst: instructions){	
			Constant dest = inst.getDest();
			if(dest!=null){
				inst.setNumeralDest(index);
				
				localVarTable.put(dest.toString(), index);
				Cell destCell = new Cell();
				destCell.setSrcInst(inst);
				localList.add(destCell);   //need to be rewrite; add valueFlow to Cell
				
				index++;
			}else{
				inst.setNumeralDest(0);		//no dest
			}

			List<Integer> numeralOperands = new ArrayList<Integer>();
			
//			for(Constant expr: inst.getOperands()){
//				if(expr.isLocalVariable()){
//					Integer in = localVarTable.get(expr.toString());
//					if(in!=null){
//						numeralOperands.add(in);
//					}else{
//						numeralOperands.add(0);
//					}
//				}else if(expr.isGlobalVariable()){
//					Integer in = globalVarTable.get(expr.toString());
//					if(in!=null){
//						numeralOperands.add(new Integer(-in));
//					}else{
//						numeralOperands.add(0);
//					}
//				}
//			}
			
			List<Constant> operands = inst.getOperands();
			for(int i = 0; i < operands.size(); i++){
				Constant expr = operands.get(i);
				String exprStr = expr.toString();
				
				if(expr.isLocalVariable()){
					Integer in = localVarTable.get(expr.toString());
					if(in!=null){
						numeralOperands.add(in);
					}else{
						numeralOperands.add(0);
					}
					
					if(CONTACT){
						Constant c = getParent().getLocalVarTable().get(exprStr);
						if(c!=null){
							operands.remove(i);
							operands.add(i, c);
						}
					}

				}else if(expr.isGlobalVariable()){
					Integer in = globalVarTable.get(expr.toString());
					if(in!=null){
						numeralOperands.add(new Integer(-in));
					}else{
						numeralOperands.add(0);
					}
					
					if(CONTACT){
						Constant c = getParent().getParent().getGlobalTable().get(exprStr);
						if(c!=null){
							operands.remove(i);
							operands.add(i, c);
						}
					}
					
				}
			}
			
			inst.setNumeralOperands(numeralOperands);
		}
		
		return index;
	}
	
	public Function getParent() {
		return parent;
	}

	public void setParent(Function parent) {
		this.parent = parent;
	}

	public int getNumPredecessor(){
		return predecessors.size();
	}
	
	public void addPredecessor(BasicBlock bb){
		if(predecessors.contains(bb))
			return;
		predecessors.add(bb);
	}
	
	public List<BasicBlock> getPredecessors() {
		return predecessors;
	}
	
	public BasicBlock getPredecessor(int index) {
		return predecessors.get(index);
	}
	
	public List<BasicBlock> getSuccessors() {
		return successors;
	}
	
	public int getNumSuccessor(){
		return successors.size();
	}
	
	public BasicBlock getSuccessor(int index){
		return successors.get(index);
	}
	
	public Instruction getFirst(){
		return instructions.get(0);
	}
	
	public Instruction getTerminator(){
		return instructions.get(instructions.size()-1);
	}

	public Instruction getInstruction(int index){
		return instructions.get(index);
	}
	
	public Instruction getPreInstruction(Instruction inst){
		int index = instructions.indexOf(inst);
		if(index>=0){
			return instructions.get(index-1);
		}
		
		return null;
	}
	
	public int getNumInst(){
		return instructions.size();
	}
	
	public boolean hasSuccessor(){
		return successors.size()!=0;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}
	
	public String getBlockID() {
		return blockID;
	}
	
	@Override
	public String toString(){
		String value = "";
		value += " "+blockID+":\n";
		
		value+= "  predecessor: ";
		for(BasicBlock bb: predecessors){
			value+=bb.getBlockID()+", ";
		}
		
		value+= "  successor: ";
		for(BasicBlock bb: successors){
			value+=bb.getBlockID()+", ";
		}
		
		return value;
	}
}
