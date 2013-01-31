package cn.edu.sjtu.jllvm.VMCore.Operators;

public class InstType {
	public static final int
		//#BINARY_OP : 'add' | 'fadd' | 'sub' | 'fsub' | 'mul' | 'fmul' | 'udiv' | 'sdiv' | 'fdiv' | 'urem' | 'srem' | 'frem' | 'shl' | 'lshr' | 'ashr' | 'and' | 'or' | 'xor';
		//BinaryInst
		binaryInst = 1,		
		
		//#vector op
		//SimpleInst
		extractEleInst = 2,
		insertEleInst = 3,
		shuffleVecInst = 4,
		
		//#aggregate
		//SimpleInst
		extractValInst = 5,
		insertValInst = 6,
		
		//#memory operation
		//GetElePtrInst
		getElePtrInst = 7,
		
		//SimpleInst
		allocaInst = 8,
		
		//LoadStoreInst
		loadInst = 9,
		storeInst = 10,
		
		//OperationInst
		converInst = 11,
		
		//CmpInst
		icmpInst = 12,
		fcmpInst = 13,
		
		//SimpleInst
		selectInst = 14,
		
		//CallInst
		callInst = 15,
		
		//SimpleInst
		phiInst = 16,
		
		/// TerminatorInst - Subclasses of this class are all able to terminate a basic
		/// block.  Thus, these are all the flow control type of operations.
		///		
		//SimpleInst
		retInst = 17,
		unwindInst = 18,
		brInst = 19,
		switchInst = 20,
		indirectBrInst = 21,
		
		//CallInst
		invokeInst = 22,
		
		//SimpleInst
		unreachableInst = 23;
	
	public static boolean isTerminator(int opcode){
		if(opcode>16 && opcode<24){
			return true;
		}
		
		return false;
	}
}
