package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.ArrayList;

public class ArrayType extends DerivedType {
	private int length;
	
	public ArrayType(int length, Type eleType){
		typeID = Type.ArrayTyID;
		this.length = length;
		this.subTypes = new ArrayList<Type>();
		this.subTypes.add(eleType);
		typeString = "["+length+"x"+eleType.toString()+"]";
	}
	
	public static ArrayType create(int length, Type eleType){
		return new ArrayType(length, eleType);
	}
}
