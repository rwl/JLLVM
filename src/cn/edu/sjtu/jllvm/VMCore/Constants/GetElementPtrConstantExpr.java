package cn.edu.sjtu.jllvm.VMCore.Constants;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Operators.Operator;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class GetElementPtrConstantExpr extends ConstantExpr {
	private boolean inbounds;
	private Type type;
	private List<Integer> indices;
	
	public GetElementPtrConstantExpr(boolean inbounds, Type type, Constant subExpr, List<Integer> indices){
		this.inbounds = inbounds;
		this.type = type;
		this.operands = new ArrayList<Constant>();
		this.operands.add(subExpr);
		this.indices = indices;
		this.opcode = Operator.getElementPtr;
	}

	public boolean isInbounds() {
		return inbounds;
	}

	@Override
	public Type getType() {
		return type;
	}

	public List<Integer> getIndices() {
		return indices;
	}

	@Override
	public String toString(){
		String value = "getelementptr ";
		if(inbounds)
			value += "inbounds ";
		
		value += "(" + type.toString()+" "+getOperand(0).toString();
		
		for(int i:indices){
			value += ", " + i;
		}
		value += ")";
		
		return value;
	}
}
