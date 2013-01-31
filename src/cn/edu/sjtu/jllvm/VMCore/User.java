package cn.edu.sjtu.jllvm.VMCore;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;

/**
 * @author liuhao 2011-12-21
 *	The User class is the common base class of all LLVM nodes that may refer to Values. 
 *	It exposes a list of "Operands" that are all of the Values that the User is referring to. 
 *	The User class itself is a subclass of Value.
 */
public class User extends Value {
	protected List<Constant> operands;
	
	public Constant getOperand(int index){
		if(index>=getNumOperands())
			return null;
		return operands.get(index);
	}
	
	public int getNumOperands(){
		if(operands == null)
			return 0;
		return operands.size();
	}
}
