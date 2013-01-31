package cn.edu.sjtu.jllvm.VMCore;

import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * @author liuhao 2011-12-21
 *	The Value class is the most important class in the LLVM Source base. 
 *	It represents a typed value that may be used (among other things) as an operand to an instruction. 
 *	There are many different types of Values, such as Constants,Arguments. 
 *	Even Instructions and Functions are Values.
 */
public class Value {
	protected String value;
	protected Type type;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Value(){
		
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean isNullValue(){			
		return false;
	}

	@Override
	public String toString(){
		return value;
	}
}
