package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

public class AllocaInst extends Instruction {
	public AllocaInst(Constant dest, int opcode, List<Constant> operands, List<Type> types){
		super(dest, opcode, operands, types);
		
		setType(TypeFactory.getPointerType(types.get(0)));
	}
}
