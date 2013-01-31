package cn.edu.sjtu.jllvm.VMCore.Constants;

import cn.edu.sjtu.jllvm.VMCore.User;

/**
 * @author liuhao 2011-12-21
 *	a constant that is initialized with an expression using other constants.
 */
public class Constant extends User {
	public static final int
		simpleConstantValue = 1,
		getEleExpr = 2,
		converExpr = 3,
		binaryExpr = 4,
		cmpExpr = 5,
		globalVar = 6,
		localVar = 7,
		undef = 8;

	public int constantID;
	
	public Constant(){
		constantID = Constant.undef;
	}
	
	public boolean isGlobalVariable(){
		return constantID == globalVar;
	}
	
	public boolean isLocalVariable(){
		return constantID == localVar;
	}
	
	public boolean isSimpleConstantValue(){
		return constantID == simpleConstantValue;
	}
}
