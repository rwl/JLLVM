package cn.edu.sjtu.jllvm.VMCore.Types;

public class Type {
	protected final static int
	    // PrimitiveTypes
	    VoidTyID = 0,    	 ///<  0: type with no size
	    FloatTyID = 1,       ///<  1: 32 bit floating point type
	    DoubleTyID = 2,      ///<  2: 64 bit floating point type
	    X86_FP80TyID = 3,    ///<  3: 80 bit floating point type (X87)
	    FP128TyID = 4 ,       ///<  4: 128 bit floating point type (112-bit mantissa)
	    PPC_FP128TyID = 5,   ///<  5: 128 bit floating point type (two 64-bits)
	    LabelTyID = 6,       ///<  6: Labels
	    MetadataTyID = 7,    ///<  7: Metadata
	    IntegerTyID = 8,     ///<  8: Arbitrary bit width integers
	    
	    //extra primitive type

	    // Derived types
	    // Make sure FirstDerivedTyID stays up to date!!!
	    FunctionTyID = 9,    ///<  9: Functions
	    StructTyID = 10,      ///< 10: Structures
	    ArrayTyID = 11,       ///< 11: Arrays
	    PointerTyID = 12,     ///< 12: Pointers
	    OpaqueTyID = 13,      ///< 13: Opaque: type with unknown structure
	    VectorTyID = 14,      ///< 14: SIMD 'packed' format, or other vector type

	    //extra derived types 
	    IdTyID = 15,
		UnionID = 16,
		PackedStructTyID = 17,
		
		//other types
		WrongTyID = 18,
		
		lastPrimitive = IntegerTyID;
	
	protected int typeID;
	protected String typeString;
	
	public Type(){
		typeID = 0;
	}
	
	public Type(int typeID){
		this.typeID = typeID; 
		
		switch(typeID){
			case VoidTyID:
				typeString = "void";
				break;
			case FloatTyID:
			case DoubleTyID:
			case X86_FP80TyID:
			case FP128TyID:
			case PPC_FP128TyID:
				typeString = "float";
				break;
			case LabelTyID:
				typeString = "label";
				break;
			case MetadataTyID:
				typeString = "metadata";
				break;
			case WrongTyID:
				typeString = "wrong";
			default:
				typeString = "derived";	
		}
	}
	
	public Type(int typeID, String name){
		this(typeID);
	}

	public int getTypeID() {
		return typeID;
	}
	
	public void setTypeID(int tyID) {
		typeID = tyID;
	}
	
	public boolean equals(Type type){
		if(this == type)
			return true;
		if(this.toString().equals(type.toString()))
			return true;
		
		return false;
	}
	
	public boolean isSingleValueType(){
		if(typeID==Type.IntegerTyID|| typeID==Type.FloatTyID ||typeID==Type.PointerTyID ||typeID == Type.VectorTyID ||typeID == Type.LabelTyID || typeID == Type.MetadataTyID)
			return true;
		
		return false;
	}
	
	public boolean isPrimType(){
		if(typeID <= Type.lastPrimitive)
			return true;
		
		return false;
	}
	
	public boolean isStructType(){
		if(typeID == Type.StructTyID || typeID == Type.PackedStructTyID || typeID == Type.UnionID)
			return true;
		return false;
	}
	
	public boolean isFunctionType(){
		if(typeID == Type.FunctionTyID)
			return true;
		return false;
	}
	
	public boolean isPointerType(){
		return typeID == Type.PointerTyID;
	}
	
	public Type getSubType(){
		return null;
	}
	
	public boolean isWrongType(){
		return typeID == Type.WrongTyID;
	}
	
	public String getTypeString(){
		return typeString;
	}
	
	@Override
	public String toString(){
		return typeString;
	}
}
