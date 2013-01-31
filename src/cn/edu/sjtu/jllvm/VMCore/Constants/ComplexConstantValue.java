package cn.edu.sjtu.jllvm.VMCore.Constants;

public class ComplexConstantValue extends Constant{
	public final static int 
		structure = 7,
		array = 8,
		vector = 10;
	
	protected int valueID;
	
	public ComplexConstantValue(int id, String value){
		this.valueID = id;
			
		this.value = value;
		//value=value.substring(1,value.length()-2);
	}

	public int getValueID() {
		return valueID;
	}

	@Override
	public boolean isNullValue() {
		// TODO Auto-generated method stub
		return value.length()==2;
	}
	
	
}
