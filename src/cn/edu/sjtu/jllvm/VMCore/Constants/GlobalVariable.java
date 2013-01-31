package cn.edu.sjtu.jllvm.VMCore.Constants;

import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class GlobalVariable extends GlobalValue {
	
	private String name = null;
	private String linkage = null;
	private boolean isThreadLocal = false;
	private boolean isConstant = false;
	private Constant initializer = null;
	private String section = null;
	private int align = -1;	

	public GlobalVariable(String name, String linkage, boolean isThreadLocal, boolean isConstant, Type type, 
			Constant initializer, String section, int align){
		this.name = name;
		this.linkage = linkage;
		this.isThreadLocal = isThreadLocal;
		this.isConstant = isConstant;
		this.type = type;
		this.initializer = initializer;
		this.section = section;
		this.align = align;
	}
	
	public String getName() {
		return name;
	}

	public String getLinkage() {
		return linkage;
	}

	public boolean isThreadLocal() {
		return isThreadLocal;
	}

	public boolean isConstant() {
		return isConstant;
	}

	@Override
	public Type getType() {
		return type;
	}

	public boolean hasInitializer(){
		return initializer != null;
	}
	
	public Constant getInitializer() {
		return initializer;
	}

	public String getSection() {
		return section;
	}

	public int getAlign() {
		return align;
	}

	@Override
	public String toString(){
//		String value = "@"+name+"=";
//		if(linkage != null){
//			value += linkage+" ";
//		}
//		if(isThreadLocal){
//			value += "thread_local ";
//		}
//		if(isConstant){
//			value += "constant ";
//		}else{
//			value += "global ";
//		}
//		value += type.toString()+" ";
//		if(initializer!=null){
//			value += initializer;
//			if(section!=null){
//				value += ", "+section;
//			}
//			if(align>0){
//				value += ", align "+align;
//			}
//		}
//		
//		return value;
		return getName();
	}
}
