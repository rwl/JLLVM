package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class InstFactory {
	public Instruction createSimpleInst(Constant dest, int opcode, List<Constant> operands, List<Type> types){
		switch(opcode){
			case InstType.selectInst:
				return new SelectInst(dest, opcode, operands, types);
			case InstType.allocaInst:
				return new AllocaInst(dest, opcode, operands, types);
			case InstType.phiInst:
				return new PHIInst(dest, opcode, operands, types);
			case InstType.retInst:
			case InstType.unwindInst:
			case InstType.brInst:
			case InstType.switchInst:
			case InstType.invokeInst:
			case InstType.indirectBrInst:
			case InstType.unreachableInst:
				return new TerminatorInst(dest, opcode, operands, types);
			default:
				return new Instruction(dest, opcode, operands, types);
		}
	}
	
	public Instruction createCallInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			boolean tail, String cconv, List<String> pAttributes, List<String> fAttributes){
		return new CallInst(dest, opcode, operands, types, tail, cconv, pAttributes, fAttributes);
	}
	
	public Instruction createCmpInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String cond){
		return new CmpInst(dest, opcode, operands, types, cond);
	}
	
	public Instruction createLoadStoreInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			boolean isVolatile){
		if(opcode == InstType.loadInst)
			return new LoadInst(dest, opcode, operands, types, isVolatile);
		else if(opcode == InstType.storeInst)
			return new StoreInst(dest, opcode, operands, types, isVolatile);
		return null;
	}
	
	public Instruction createOperationInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String op){
		return new OperationInst(dest, opcode, operands, types, op);
	}
	
	public Instruction createBinaryInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, 
			String op, String nuw, String nsw, String exact){
		return new BinaryInst(dest, opcode, operands, types, op, nuw, nsw, exact);
	}
	
	public Instruction createGetElePtrInst(Constant dest, int opcode, List<Constant> operands, List<Type> types, boolean inbounds){
		return new GetElePtrInst(dest, opcode, operands, types, inbounds);
	}
}