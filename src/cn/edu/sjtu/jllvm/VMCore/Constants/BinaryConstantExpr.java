package cn.edu.sjtu.jllvm.VMCore.Constants;

import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.Operators.Operator;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class BinaryConstantExpr extends ConstantExpr {
	private String nuw, nsw, exact;
	private Type type1, type2;
	
	public BinaryConstantExpr(String op, String nuw, String nsw, String exact, Type type1, Constant expr1, Type type2, Constant expr2){
		this.opcode = Operator.getOpcode(op);
		this.nuw = nuw;
		this.nsw = nsw;
		this.exact = exact;
		this.type1 = type1;
		this.type2 = type2;
		
		this.operands = new ArrayList<Constant>();
		operands.add(expr1);
		operands.add(expr2);
	}
	
	public static BinaryConstantExpr create(String op, String nuw, String nsw, String exact, Type type1, Constant expr1, Type type2, Constant expr2){
		return new BinaryConstantExpr(op, nuw, nsw, exact, type1, expr1, type2, expr2);
	}
	
	@Override
	public String toString(){
		String value = Operator.getOpStr(opcode);
		if(nuw!=null){
			value += " nuw";
		}
		if(nsw!=null){
			value += " nsw";
		}
		if(exact!=null){
			value += " exact";
		}
		
		value += " "+type1.toString() + " " + getOperand(0).toString() + ", "+type2.toString()+" "+ getOperand(1).toString();
		
		return value;
	}
}
