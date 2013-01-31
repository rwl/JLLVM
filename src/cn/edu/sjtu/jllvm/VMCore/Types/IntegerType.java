package cn.edu.sjtu.jllvm.VMCore.Types;

public class IntegerType extends Type {
	private int bits;
	
	public IntegerType(int bits){
		typeID = Type.IntegerTyID;
		this.bits = bits;
		typeString = "i"+bits;
	}
	
	public static Type create(int n){
		return new IntegerType(n);
	}
	
	@Override
	public String toString(){
		return typeString;
	}
}
