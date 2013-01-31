package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.List;

public class PackedStructType extends StructType {

	public PackedStructType(List<Type> subTys){
		super(subTys);
		typeString = "<"+typeString+">";
		setTypeID(Type.PackedStructTyID);
	}
	
	public static PackedStructType create(List<Type> subTys){
		return new PackedStructType(subTys);
	}
}
