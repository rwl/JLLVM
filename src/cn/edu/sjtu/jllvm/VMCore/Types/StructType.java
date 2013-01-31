package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.ArrayList;
import java.util.List;

public class StructType extends DerivedType {
	private int numElements;
	
	public StructType(List<Type> subTys){
		typeID = Type.StructTyID;
		subTypes = new ArrayList<Type>();
		
		if(subTys!=null){
		
			for(Type eleType: subTys){
				subTypes.add(eleType);
			}
		}
		numElements = subTypes.size();
		
		typeString = "{";
		boolean notfirst = false;
		for(Type subTy: subTypes){
			if(notfirst){
				typeString+=",";
			}
			typeString+=subTy.toString();
		}
		typeString+="}";
	}
	
	public static StructType create(List<Type> subTys){
		return new StructType(subTys);
	}
}
