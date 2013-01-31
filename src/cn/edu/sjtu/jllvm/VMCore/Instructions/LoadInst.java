package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class LoadInst extends Instruction {
	private boolean isVolatile;
	public LoadInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			boolean isVolatile){
		super(dest, opcode, operands, types);
		this.isVolatile = isVolatile;
		
		if(opcode == InstType.loadInst){
			setType(types.get(0).getSubType());
		}
	}
	public boolean isVolatile() {
		return isVolatile;
	}
}
