package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends DerivedType {
	// isVararg means whether this function has changeable Arguments;
	boolean isVararg;
	
	public FunctionType(List<Type> subTys, boolean isVararg){
		typeID = Type.FunctionTyID;
		subTypes = new ArrayList<Type>();
		typeString = "";
		int index = 0;
		this.isVararg = isVararg;
		
		if(subTys!=null){
			for(Type subType: subTys){
				subTypes.add(subType);
				
				if(index == 0){	//return type
					typeString+=subType.toString();
					index++;
					continue;
				}
				if(index == 1){
					typeString+="(";
					index++;
				}else{
					typeString+=",";
				}
				typeString+=subType.toString();
			}
			if(isVararg){
				if(subTys.size()>1){
					typeString+=","+"...";
				}else{
					typeString+="...";
				}
			}
			
			typeString+=")";
		}
		
		
	}
}
