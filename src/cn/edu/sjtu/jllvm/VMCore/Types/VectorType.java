package cn.edu.sjtu.jllvm.VMCore.Types;

public class VectorType extends DerivedType {
	private int length;
	
	public VectorType(int l, Type eleTy){
		typeID = Type.VectorTyID;
		length = l;
		subType = eleTy;
		typeString = "<"+length+"x"+subType.toString()+">";
	}
	
	public static VectorType create(int length, Type eleType){
		return new VectorType(length, eleType);
	}
}
