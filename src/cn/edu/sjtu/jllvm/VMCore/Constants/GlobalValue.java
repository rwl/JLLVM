package cn.edu.sjtu.jllvm.VMCore.Constants;

/**
 * @author liuhao 2011-12-21
 *	Global values (GlobalVariables or Functions) are the only LLVM values that are visible in the bodies of all Functions. 
 *	Because they are visible at global scope, 
 *	they are also subject to linking with other globals defined in different translation units.
 */
public class GlobalValue extends Constant{
	public GlobalValue(){
		super();
	}
	
	public GlobalValue(String value){
		this.constantID = Constant.globalVar;
		this.value = value;
	}
}
