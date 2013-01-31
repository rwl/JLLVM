package cn.edu.sjtu.jllvm.VMCore.Instructions;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.Operator;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class OperationInst extends Instruction{
	protected int op;
	public OperationInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String opStr){
		super(dest, opcode, operands, types);
		this.op = Operator.getOpcode(opStr);
		
		if(dest!=null){
			if(types.size()>0){
				if(Operator.isConvert(op)){
					setType(types.get(types.size()-1));
				}
			}
		}
	}
	
	@Override
	public boolean isBitcast(){
		return op == Operator.bitcast;
	}
	
	@Override
	public boolean isCastInst(){
		return (op>=Operator.trunc && op<=Operator.bitcast);

	}
	
	public String getOpStr(){
		return Operator.getOpStr(op);
	}
	
	public static OperationInst create(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String op){
		return new OperationInst(dest, opcode, operands, types, op);
	}
}