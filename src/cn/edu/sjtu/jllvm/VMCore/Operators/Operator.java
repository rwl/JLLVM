package cn.edu.sjtu.jllvm.VMCore.Operators;

public class Operator {
	//'add' | 'fadd' | 'sub' | 'fsub' | 'mul' | 'fmul' | 'udiv' | 'sdiv' | 'fdiv' | 'urem' | 'srem' | 'frem' | 'shl' | 'lshr' | 'ashr' | 'and' | 'or' | 'xor'
	//binary_op 
	public static final int 
		add = 1,
		fadd = 2,
		sub = 3,
		fsub = 4,
		mul = 5,
		fmul = 6,
		udiv = 7,
		sdiv = 8,
		fdiv = 9,
		urem = 10,
		frem = 11,
		shl = 12,
		lshr = 13,
		ashr = 14,
		and = 15,
		or = 16,
		xor = 17;
		
	//public static String[] 
	
	//'trunc' | 'zext' | 'sext' | 'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' | 'ptrtoint' | 'inttoptr' | 'bitcast'
	//conversion_op
	public static final int 
		trunc = 18,
		zext  = 19,
		sext = 20,
		fptrunc = 21,
		fpext = 22,
		fptoui = 23,
		fptosi = 24,
		uitofp = 25,
		sitofp = 26,
		ptrtoint = 27,
		inttoptr = 28,
		bitcast = 29,
	
	//compare_op getElementPtr
		icmp = 30,
		fcmp = 31,
		getElementPtr = 32;
	
	public static boolean isConvert(int opcode){
		return opcode>Operator.xor;
	}
	
	public static int getOpcode(String op){
		if(op.equals("add")){
			return Operator.add;
		}
		if(op.equals("fadd")){
			return Operator.fadd;
		}
		if(op.equals("sub")){
			return Operator.sub;
		}
		if(op.equals("fsub")){
			return Operator.fsub;
		}
		if(op.equals("mul")){
			return Operator.mul;
		}
		if(op.equals("fmul")){
			return Operator.fmul;
		}
		if(op.equals("udiv")){
			return Operator.udiv;
		}
		if(op.equals("sdiv")){
			return Operator.sdiv;
		}
		if(op.equals("fdiv")){
			return Operator.fdiv;
		}
		if(op.equals("urem")){
			return Operator.urem;
		}
		if(op.equals("frem")){
			return Operator.frem;
		}
		if(op.equals("shl")){
			return Operator.shl;
		}
		if(op.equals("lshr")){
			return Operator.lshr;
		}
		if(op.equals("ashr")){
			return Operator.ashr;
		}
		if(op.equals("and")){
			return Operator.and;
		}
		if(op.equals("or")){
			return Operator.or;
		}
		if(op.equals("xor")){
			return Operator.xor;
		}
		
		
		if(op.equals("trunc")){
			return Operator.trunc;
		}
		if(op.equals("zext")){
			return Operator.zext;
		}
		if(op.equals("sext")){
			return Operator.sext;
		}
		if(op.equals("fptrunc")){
			return Operator.fptrunc;
		}
		if(op.equals("fpext")){
			return Operator.fpext;
		}
		if(op.equals("fptoui")){
			return Operator.fptoui;
		}
		if(op.equals("fptosi")){
			return Operator.fptosi;
		}
		if(op.equals("uitofp")){
			return Operator.uitofp;
		}
		if(op.equals("sitofp")){
			return Operator.sitofp;
		}
		if(op.equals("ptrtoint")){
			return Operator.ptrtoint;
		}
		if(op.equals("inttoptr")){
			return Operator.inttoptr;
		}
		if(op.equals("bitcast")){
			return Operator.bitcast;
		}
		
		if(op.equals("icmp")){
			return Operator.icmp;
		}
		if(op.equals("fcmp")){
			return Operator.fcmp;
		}
		if(op.equals("getElementPtr")){
			return Operator.getElementPtr;
		}
		
		return 0;
	}
	
	public static String getOpStr(int op){
		switch(op){
			case Operator.add:
				return "add";				
			case Operator.fadd:
				return "fadd";
			case Operator.sub:
				return "sub";
			case Operator.fsub:
				return "fsub";
			case Operator.mul:
				return "mul";
			case Operator.fmul:
				return "fmul";
			case Operator.udiv:
				return "udiv";
			case Operator.sdiv:
				return "sdiv";
			case Operator.urem:
				return "urem";
			case Operator.frem:
				return "frem";
			case Operator.shl:
				return "shl";
			case Operator.lshr:
				return "lshr";
			case Operator.ashr:
				return "ashr";
			case Operator.and:
				return "and";
			case Operator.or:
				return "or";
			case Operator.xor:
				return "xor";
				
			case Operator.trunc:
				return "trunc";
			case Operator.zext:
				return "zext";
			case Operator.sext:
				return "sext";
			case Operator.fptrunc:
				return "fptrunc";
			case Operator.fpext:
				return "fpext";
			case Operator.fptoui:
				return "fptoui";
			case Operator.fptosi:
				return "fptosi";
			case Operator.uitofp:
				return "uitofp";
			case Operator.sitofp:
				return "sitofp";
			case Operator.ptrtoint:
				return "ptrtoint";
			case Operator.inttoptr:
				return "inttoptr";
			case Operator.bitcast:
				return "bitcast";
			case Operator.icmp:
				return "icmp";
			case Operator.fcmp:
				return "fcmp";
			case Operator.getElementPtr:
				return "getElementPtr";
			default:
				return "op";
		}
	}
}