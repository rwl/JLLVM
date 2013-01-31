package cn.edu.sjtu.jllvm.VMCore.Constants;

public class SimpleConstantValue extends Constant{
	public static final int 
	intConst = 1,
	hexConst = 2,
	boolConst = 3,
	floatConst = 4,
	stringConst = 5,
	nullConst = 6,
	voidConst = 7;

	protected int valueID;
	
	public SimpleConstantValue(int id, String value){
		this.valueID = id;
		this.value = value;
		this.constantID = Constant.simpleConstantValue;
	}

	public int getValueID() {
		return valueID;
	}
	
	public boolean isInt() {
		return valueID == intConst;
	}
	
	public boolean isString() {
		return valueID == stringConst;
	}
	
	public boolean isFloat() {
		return valueID == floatConst;
	}

	public boolean isNull() {
		return valueID == nullConst;
	}
	
	public boolean isBoolean(){
		return valueID == boolConst;
	}
	
	@Override
	public boolean isNullValue() {
		return value.equals("0") || this.valueID==SimpleConstantValue.nullConst;
	}
	
	
}
