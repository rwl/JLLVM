package cn.edu.sjtu.jllvm.VMCore.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * @author liuhao 2011-12-21
 *	retInst,unwindInst,brInst,switchInst,indirectBrInst,invokeInst,unreachableInst;
 */
public class TerminatorInst extends Instruction {
	public TerminatorInst(Constant dest, int opcode, List<Constant> operands, List<Type> types){
		super(dest, opcode, operands, types);
	}
}
