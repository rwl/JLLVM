package cn.edu.sjtu.jllvm.VMCore.Types;

public class OpaqueType extends DerivedType {

	public OpaqueType() {
		typeID = Type.OpaqueTyID;
		typeString = "Opaque";
	}
	
	public static OpaqueType create(){
		return new OpaqueType();
	}
}
