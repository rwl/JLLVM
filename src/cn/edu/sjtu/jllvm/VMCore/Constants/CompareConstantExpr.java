package cn.edu.sjtu.jllvm.VMCore.Constants;

import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.Operators.CompareCondition;
import cn.edu.sjtu.jllvm.VMCore.Operators.Operator;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class CompareConstantExpr extends ConstantExpr {
	private int cond;
	private Type type1, type2;
	
	public CompareConstantExpr(boolean isICmp, String cond, Type type1, Constant expr1, Type type2, Constant expr2){
		if(isICmp){
			this.opcode = Operator.icmp;
		}else{
			this.opcode = Operator.fcmp;
		}
		
		this.cond = CompareCondition.getCond(cond);
		this.type1 = type1;
		this.type2 = type2;
		
		this.operands = new ArrayList<Constant>();
		operands.add(expr1);
		operands.add(expr2);
	}
	
	public static CompareConstantExpr create(boolean isICmp, String cond, Type type1, Constant expr1, Type type2, Constant expr2){
		return new CompareConstantExpr(isICmp, cond, type1, expr1, type2, expr2);
	}
	
	@Override
	public String toString(){
		String value = "";
		value += Operator.getOpStr(opcode);
		
		value+= " "+cond+" "+type1.toString()+" "+getOperand(0).toString()+","+type2.toString()+getOperand(1).toString(); 
		return value;
	}
}
