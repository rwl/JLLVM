package cn.edu.sjtu.jllvm.VMCore.Operators;

public class CompareCondition {
	public static final int
		eq = 1,
		ne = 2,
		sgt = 3,
		sge = 4,
		slt = 5,
		sle = 6,
		
		ugt = 7,
		uge = 8,
		ult = 9,
		ule = 10,
		
		oeq = 11,
		ogt = 12,
		oge = 13,
		olt = 14,
		ole = 15,
		one = 16,
		ord = 17,
		ueq = 18,
		une = 19,
		uno = 20,
		true_cond = 21,
		false_cond = 22
		;
	
	public static int getCond(String condStr){
		if(condStr.equals("eq")){
			return eq;
		}
		if(condStr.equals("ne")){
			return ne;
		}
		if(condStr.equals("sgt")){
			return sgt;
		}
		if(condStr.equals("sge")){
			return sge;
		}
		if(condStr.equals("slt")){
			return slt;
		}
		if(condStr.equals("sle")){
			return sle;
		}
		
		
		if(condStr.equals("ugt")){
			return ugt;
		}
		if(condStr.equals("uge")){
			return uge;
		}
		if(condStr.equals("ult")){
			return ult;
		}
		if(condStr.equals("ule")){
			return ule;
		}
		
		
		if(condStr.equals("oeq")){
			return oeq;
		}
		if(condStr.equals("ogt")){
			return ogt;
		}
		if(condStr.equals("oge")){
			return oge;
		}
		if(condStr.equals("olt")){
			return olt;
		}
		if(condStr.equals("ole")){
			return ole;
		}
		if(condStr.equals("one")){
			return one;
		}
		if(condStr.equals("ord")){
			return ord;
		}
		if(condStr.equals("ueq")){
			return ueq;
		}
		if(condStr.equals("une")){
			return une;
		}
		if(condStr.equals("uno")){
			return uno;
		}
		
		if(condStr.equals("true")){
			return true_cond;
		}
		if(condStr.equals("false")){
			return false_cond;
		}
		
		return 0;
	}
	
	public static String getCondStr(int cond){
		if(cond == eq){
			return "eq";
		}
		if(cond == ne){
			return "ne";
		}
		if(cond == sgt){
			return "sgt";
		}
		if(cond == sge){
			return "sge";
		}
		if(cond == slt){
			return "slt";
		}
		if(cond == sle){
			return "sle";
		}
		
		
		if(cond == ugt){
			return "ugt";
		}
		if(cond == uge){
			return "uge";
		}
		if(cond == ult){
			return "ult";
		}
		if(cond == ule){
			return "ule";
		}
		
		
		if(cond == oeq){
			return "oeq";
		}
		if(cond == ogt){
			return "ogt";
		}
		if(cond == oge){
			return "oge";
		}
		if(cond == olt){
			return "olt";
		}
		if(cond == ole){
			return "ole";
		}
		if(cond == one){
			return "one";
		}
		if(cond == ord){
			return "ord";
		}
		if(cond == ueq){
			return "ueq";
		}
		if(cond == une){
			return "une";
		}
		if(cond == uno){
			return "uno";
		}
		
		if(cond == true_cond){
			return "true";
		}
		if(cond == false_cond){
			return "false";
		}
		
		return null;
	}
	
	public static String getCondIcon(int cond){
		if(cond == eq){
			return "==";
		}
		if(cond == ne){
			return "!=";
		}
		
		return getCondStr(cond);
	}
}
