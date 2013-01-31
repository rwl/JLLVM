package cn.edu.sjtu.jllvm.VMCore.Constants;

public class LocalVariable extends Constant{
	public LocalVariable(String value){
		this.constantID = Constant.localVar;
		this.value = value;
	}
}
