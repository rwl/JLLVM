package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.List;

public class UnionType extends StructType {
	
	public UnionType(List<Type> subTys){
		super(subTys);
		
		setTypeID(Type.UnionID);
	}
	
	public static UnionType create(List<Type> subTys){
		return new UnionType(subTys);
	}
}
