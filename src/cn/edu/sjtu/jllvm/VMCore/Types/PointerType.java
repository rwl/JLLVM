package cn.edu.sjtu.jllvm.VMCore.Types;

public class PointerType extends DerivedType {
	
	public PointerType(Type subTy) {
		super(Type.PointerTyID);
		subType = subTy;
		
		typeString = subType.toString()+"*";
	}
	
	public static PointerType create(Type subType){
		return new PointerType(subType);
	}
}
