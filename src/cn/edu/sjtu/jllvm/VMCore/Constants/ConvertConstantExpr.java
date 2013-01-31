package cn.edu.sjtu.jllvm.VMCore.Constants;

import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.Operators.Operator;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class ConvertConstantExpr extends ConstantExpr {
	private Type fType;
	private Type tType;
	
	public ConvertConstantExpr(String op, Type type1, Constant subExpr, Type type2){
		this.opcode = Operator.getOpcode(op);
		fType = type1;
		this.operands = new ArrayList<Constant>();
		operands.add(subExpr);
		tType = type2;		
	}
	
	public static ConvertConstantExpr create(String op, Type type1, Constant subExpr, Type type2){
		return new ConvertConstantExpr(op, type1, subExpr, type2);
	}
	
	@Override
	public String toString(){
		String value = opcode + " (" + fType.toString() + " " + getOperand(0).toString() + " to "+ tType.toString()+")";
		return value;
	}

	public Type getfType() {
		return fType;
	}

	public Type gettType() {
		return tType;
	}
	
}
