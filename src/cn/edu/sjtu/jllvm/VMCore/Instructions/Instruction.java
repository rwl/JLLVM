package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.ESP.ILocation;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.User;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * @author liuhao 2011-12-21
 *	The Instruction class is the common base class for all LLVM instructions. 
 *	It provides only a few methods, but is a very commonly used class. 
 *	The primary data tracked by the Instruction class itself is the opcode 
 *	and the parent BasicBlock the Instruction is embedded into. 
 *	To represent a specific type of instruction, one of many subclasses of Instruction are used.
 */
public class Instruction extends User implements ILocation{
	protected int opcode;
	protected Constant dest;
	protected List<Type> types;
	
	protected Instruction preInst;	//CFG
	protected Instruction nextInst;	//CFG
	protected BasicBlock parent;	//CFG
	
	protected List<Integer> numeralOperands; //CFG
	protected int numeralDest;	//CFG
	
	public Instruction(Constant dest, int opcode, List<Constant> operands, List<Type> types){
		this.opcode = opcode;
		this.dest = dest;
		this.operands = operands;
		this.types = types;
		
		if(dest!=null){
			if(types.size()!=0){
				setType(types.get(0));
			}
		}
	}
	
	public boolean isTerminator(){
		return opcode>=InstType.retInst && opcode<=InstType.unreachableInst;
	}
	
	public boolean isRet(){
		return opcode == InstType.retInst;
	}
	
	public boolean isUnreachable(){
		return opcode == InstType.unreachableInst;
	}
	
	public boolean isCall(){
		return opcode == InstType.callInst;
	}
	
	public boolean isLoad(){
		return opcode == InstType.loadInst;
	}
	
	public boolean isStore(){
		return opcode == InstType.storeInst;
	}
	
	public boolean isGetElePtr(){
		return opcode == InstType.getElePtrInst;
	}
	
	public boolean isBranch(){
		return opcode == InstType.brInst;
	}
	
	public boolean isConditionalBranch(){
		if(isBranch()){
			if(this.getNumOperands()>1)
				return true;
		}
		return false;
	}
	
	public boolean isSwitch(){
		return opcode == InstType.switchInst;
	}
	
	public boolean isIcmp(){
		return opcode == InstType.icmpInst;
	}
	
	public boolean isAllocation(){
		return opcode == InstType.allocaInst;
	}
	
	public boolean isBitcast(){
		//see in OperationInst
		
		return false;
	}
	
	public boolean isCastInst(){
		//see in OperationInst
		
		return false;
	}
	
	public boolean isPHINode() {
		return opcode == InstType.phiInst;
	}
	
	public boolean isConverInst() {
		return opcode == InstType.converInst;
	}
	
	public boolean isSelectIns() {
		return opcode == InstType.selectInst;
	}
	
	/**
	 * @param inst
	 * @return: true, if the inst has more than one predecessors.
	 */
	public boolean isMerge(){	
		BasicBlock parent = getParent();
		if(this==parent.getFirst()){
			if(parent.getNumPredecessor()>1)	//more than one predecessor
				return true;
		}	
		
		return false;
	}
	
	public Instruction getPreInst() {
		return preInst;
	}

	public void setPreInst(Instruction preInst) {
		this.preInst = preInst;
	}

	public Instruction getNextInst() {
		return nextInst;
	}

	public void setNextInst(Instruction nextInst) {
		this.nextInst = nextInst;
	}

	public Function getFunction() {
		return parent.getParent();
	}
	
	public BasicBlock getParent() {
		return parent;
	}

	public void setParent(BasicBlock parent) {
		this.parent = parent;
	}

	public List<Integer> getNumeralOperands() {
		return numeralOperands;
	}

	public int getNumeralOperand(int index){
		return numeralOperands.get(index);
	}
	
	public int getNumNumeralOperand(){
		return numeralOperands.size();
	}
	
	public void setNumeralOperands(List<Integer> numeralOperands) {
		this.numeralOperands = numeralOperands;
	}

	public int getNumeralDest() {
		return numeralDest;
	}

	public void setNumeralDest(int numeralDest) {
		this.numeralDest = numeralDest;
	}

	public int getNumTypes(){
		if(types==null)
			return 0;
		return types.size();
	}
	public Type getType(int index){
		if(index>=getNumTypes())
			return null;
		return types.get(index);
	}
	public int getOpcode() {
		return opcode;
	}
	public Constant getDest() {
		return dest;
	}
	public List<Constant> getOperands() {
		return operands;
	}
	public List<Type> getTypes() {
		return types;
	}	
}
