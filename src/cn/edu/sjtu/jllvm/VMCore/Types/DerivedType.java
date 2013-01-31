package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.List;

public abstract class DerivedType extends Type {
	protected List<Type> subTypes;	//sub types
	protected Type subType;
	
	public DerivedType(){
		super();
	}
	
	public DerivedType(int typeID){
		super(typeID);
	}
	
	@Override
	public Type getSubType(){
		return subType;
	}
}
