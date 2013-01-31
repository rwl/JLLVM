package cn.edu.sjtu.jllvm.VMCore.Constants;

public class UndefValue extends Constant {
	public UndefValue(String value){
		this.constantID = Constant.undef;
		this.value = value;
	}
}
