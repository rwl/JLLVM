package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class SelectInst extends Instruction{
	public SelectInst(Constant dest, int opcode, List<Constant> operands, List<Type> types){
		super(dest, opcode, operands, types);
		
		if(types.size()>1){
			setType(types.get(1));
		}
	}
}
