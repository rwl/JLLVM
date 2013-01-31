package cn.edu.sjtu.jllvm.VMCore.Constants;

import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class GlobalAlias extends GlobalValue{
	private String name;
	private String linkage;
	private String visibility;
	private String gVarName;
	//aliases_variable :
    //GLOBAL_VARIABLE '=' 'alias' LINKAGE? VISIBILITY? derived_type {Type type = $derived_type.type; VMUtil.debug("alias_variable:"+type.toString());} GLOBAL_VARIABLE ; 
	public GlobalAlias(String name, String linkage, String visibility, Type type, String gVarName){
		this.name = name;
		this.linkage = linkage;
		this.visibility = visibility;
		this.type = type;
		this.gVarName = gVarName;
	}
	
	public String getName() {
		return name;
	}

	public String getLinkage() {
		return linkage;
	}

	public String getVisibility() {
		return visibility;
	}

	@Override
	public Type getType() {
		return type;
	}

	public String getgVarName() {
		return gVarName;
	}

	@Override
	public String toString(){
//		String value="@"+name+"=alias ";
//		if(linkage!=null){
//			value+=linkage+" ";
//		}
//		if(visibility!=null){
//			value+=visibility+" ";
//		}
//		value+=type.toString() +" @"+gVarName;
//		
//		return value;
		return getName();
	}
}
