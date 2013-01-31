package cn.edu.sjtu.jllvm.VMCore.Types;

import java.util.Hashtable;
import java.util.List;

public class TypeFactory {
	private static Type  
		voidType = new Type(Type.VoidTyID),
		floatType = new Type(Type.FloatTyID),
		doubleType = new Type(Type.DoubleTyID),
		fp80Type = new Type(Type.X86_FP80TyID),
		fp128Type = new Type(Type.FP128TyID),
		ppc_fp128Type = new Type(Type.PPC_FP128TyID),
		labelType = new Type(Type.LabelTyID),
		metadataType = new Type(Type.MetadataTyID),
		Int1Type = new IntegerType(1),
		Int8Type = new IntegerType(8),
		Int16Type = new IntegerType(16),
		Int32Type = new IntegerType(32),
		Int64Type = new IntegerType(64);
	
	private static Hashtable<String, Type> namedTypeTable = new Hashtable<String, Type>();

	private static Hashtable<String, Type> typeTable = new Hashtable<String ,Type>();
	
	public TypeFactory(){
		typeTable.put("i1", Int1Type);
		typeTable.put("i8", Int8Type);
		typeTable.put("i16", Int16Type);
		typeTable.put("i32", Int32Type);
		typeTable.put("i64", Int64Type);
		typeTable.put("void", voidType);
		typeTable.put("label", labelType);
	}
	
	public static Hashtable<String, Type> getNamedTypeTable() {
		return namedTypeTable;
	}
	
	public static void addIDType(String idTypeName, Type type){
		Type idType = IDType.create(idTypeName, type);
		namedTypeTable.put(idType.toString(), idType);
	}
	
	public static Type getIDType(String idTypeName){
		Type idType = namedTypeTable.get(idTypeName);
		if(idType == null)
			idType = IDType.create(idTypeName, null);
		return idType;
	}
	
	public static Type getType(String typeString){
		return namedTypeTable.get(typeString);
	}
	
	public static Type getArrayType(int length, Type eleType){
		Type type = ArrayType.create(length, eleType);
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getFunctionType(List<Type> subTys){
		boolean isVararg = false;
		if(subTys.size()>0){
			int lastIndex = subTys.size()-1;
			if(subTys.get(lastIndex).isWrongType()){
				isVararg = true;
				
				subTys.remove(lastIndex);
			}
		}
		
		return getFunctionType(subTys, isVararg);
	}
	
	public static Type getFunctionType(List<Type> subTys, boolean isVararg){	
		Type type = new FunctionType(subTys, isVararg);
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getOpaqueType(){
		Type type = OpaqueType.create();
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getPointerType(Type type){
		Type type1 = PointerType.create(type);
		Type t = typeTable.get(type1.toString());
		if(t==null){
			typeTable.put(type1.toString(), type1);
			return type1;
		}else{
			return t;
		}
	}
	
	public static Type getStructType(List<Type> subTys){
		Type type = StructType.create(subTys);
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getPackedStructType(List<Type> subTys){
		Type type = PackedStructType.create(subTys);
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getVectorType(int length, Type eleType){
		Type type = VectorType.create(length, eleType);
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getUnionType(List<Type> subTys){
		Type type = UnionType.create(subTys);
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}
	
	public static Type getVoidType() {
		Type type = voidType;
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}

	public static Type getFloatType() {
		Type type = floatType;
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}

	public static Type getDoubleType() {
		Type type = doubleType;
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}

	public static Type getFp80Type() {
		Type type = fp80Type;
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}

	public static Type getFp128Type() {
		Type type = fp128Type;
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}

	public static Type getPpc_fp128Type() {
		Type type = ppc_fp128Type;
		Type t = typeTable.get(type.toString());
		if(t==null){
			typeTable.put(type.toString(), type);
			return type;
		}else{
			return t;
		}
	}

	public static Type getLabelType() {
		return labelType;
	}

	public static Type getMetadataType() {
		return metadataType;
	}
	
	public static Type getIntNType(int n){
		switch(n){
			case 1:
				return getInt1Type();
			case 8:
				return getInt8Type();
			case 16:
				return getInt16Type();
			case 32:
				return getInt32Type();
			case 64:
				return getInt64Type();
			default:
				Type type = IntegerType.create(n);
				Type t = typeTable.get(type.toString());
				if(t==null){
					typeTable.put(type.toString(), type);
					return type;
				}else{
					return t;
				}
		}
	}
	
	public static Type getInt1Type() {
		return Int1Type;
	}

	public static Type getInt8Type() {
		return Int8Type;
	}

	public static Type getInt16Type() {
		return Int16Type;
	}

	public static Type getInt32Type() {
		return Int32Type;
	}

	public static Type getInt64Type() {
		return Int64Type;
	}
	
	public static Type getWrongType() {
		return new Type(Type.WrongTyID);
	}
}
