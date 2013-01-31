package cn.edu.sjtu.jllvm.VMCore;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class Argument extends Value {
	private List<String> pAttributes;
	private int align;
	private Constant expr;	//expr will be null in FunctionDeclare.
	
	private Function parent;
	
	public Argument(Type type, List<String> pAttributes, int align, Constant expr){
		setType(type);
		this.pAttributes = pAttributes;
		this.align = align;
		this.expr = expr;
		if(expr!=null){
			expr.setType(type);
		}
	}

	public Constant getExpr() {
		return expr;
	}

	@Override
	public String toString(){
		String value;
		if(type == null){
			return null;
		}
		value = type.toString();
		for(String str:pAttributes){
			value+= " " +str;
		}
		if(align>0){
			value+=" align "+align;
		}
		
		if(expr!=null){
			value+= " " + expr.toString();
		}
		
		return value;
	}
	
	public Function getParent() {
		return parent;
	}

	public void setParent(Function parent) {
		this.parent = parent;
	}

	public static Argument create(Type type, List<String> pAttributes, int align, Constant expr){
		return new Argument(type, pAttributes, align, expr);
	}
}
