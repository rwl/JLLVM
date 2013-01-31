package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class CallInst extends Instruction {
	private boolean tail;
	private String cconv;
	private List<String> pAttributes;
	private List<String> fAttributes;
	public CallInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, boolean tail, String cconv, List<String> pAttributes, List<String> fAttributes){
		super(dest, opcode, operands, types);
		this.tail = tail;
		this.cconv = cconv;
		this.pAttributes = pAttributes;
		this.fAttributes = fAttributes;
	}
	public boolean isTail() {
		return tail;
	}
	public String getCconv() {
		return cconv;
	}
	public List<String> getpAttributes() {
		return pAttributes;
	}
	public List<String> getfAttributes() {
		return fAttributes;
	}
	
	
}
