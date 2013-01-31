package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.Operator;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class BinaryInst extends OperationInst{
	private String nuw;
	private String nsw;
	private String exact;
	public BinaryInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String opStr, String nuw, String nsw, String exact){
		super(dest, opcode, operands, types, opStr);
		this.nuw = nuw;
		this.nsw = nsw;
		this.exact = exact;
	}
	
	public static BinaryInst create(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String op, String nuw, String nsw, String exact){
		return new BinaryInst(dest, opcode, operands, types, op, nuw, nsw, exact);
	}

	public int getOp() {
		return op;
	}

	@Override
	public String getOpStr() {
		return Operator.getOpStr(op);
	}
	
	public String getNuw() {
		return nuw;
	}

	public String getNsw() {
		return nsw;
	}

	public String getExact() {
		return exact;
	}
	
	
}
