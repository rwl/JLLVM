package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.CompareCondition;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

public class CmpInst extends Instruction{
	private int cond;
	public CmpInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String cond){
		super(dest, opcode, operands, types);
		this.cond = CompareCondition.getCond(cond);
		
		setType(TypeFactory.getInt1Type());
	}

	public int getCond() {
		return cond;
	}
	
	public void setCond(int cond) {
		this.cond = cond;
	}

	public static CmpInst create(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String cond){
		return new CmpInst(dest, opcode, operands, types, cond);
	}
}
