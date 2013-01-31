

package cn.edu.sjtu.jllvm.VMCore.Types;

public class IDType extends DerivedType {
	@Override
	public Type getSubType() {
		return subType;
	}

	public void setSubType(Type subType) {
		this.subType = subType;
	}
	
	public IDType(String id, Type subTy){
		typeID = Type.IdTyID;
		
		subType = subTy;
		typeString = id;
	}
	
	public static IDType create(String id, Type subTy){
		return new IDType(id, subTy);
	}
}