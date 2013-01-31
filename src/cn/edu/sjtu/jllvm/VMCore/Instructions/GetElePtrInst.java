package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class GetElePtrInst extends Instruction {
	private boolean inbounds;
	
	public GetElePtrInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, boolean inbounds){
		super(dest, opcode, operands, types);
		this.inbounds = inbounds;
		
		setType(types.get(0));
	}
	
	public static GetElePtrInst create(Constant dest, int opcode, List<Constant> operands, List<Type> types, boolean inbounds){
		return new GetElePtrInst(dest, opcode, operands, types, inbounds);
	}
}
