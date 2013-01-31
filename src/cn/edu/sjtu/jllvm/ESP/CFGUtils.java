package cn.edu.sjtu.jllvm.ESP;

import java.util.ArrayList;
import java.util.List;

import stp.Expr;
import stp.VC;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Instructions.BinaryInst;
import cn.edu.sjtu.jllvm.VMCore.Instructions.CmpInst;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.CompareCondition;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;

public class CFGUtils {
	
	public static String parseVariableString(Instruction inst, int index){
		if(inst == null)
			return "";

		StringBuffer buffer = new StringBuffer("");
		
		if(index>=0 && index<inst.getNumOperands()){
//			if(index>=inst.getNumNumeralOperand()){
//				Constant expr = inst.getOperand(index);
//				if(expr.isGlobalVariable()){
//					return "@"+expr.toString();
//				}else{
//					//inst = inst.getFunction().getLocal(operand).getSrcInst();
//					String exprStr = expr.toString();
//					inst = inst.getPreInst();
//					while(inst!=null && !inst.getDest().toString().equals(exprStr)){
//						inst = inst.getPreInst();
//					}
//					if(inst==null)
//						return "";
//				}
//			}else{
//				int operand = inst.getNumeralOperand(index);
//				Constant expr = inst.getOperand(index);
//				if(expr.isGlobalVariable()){
//					return "@"+expr.toString();
//				}else{
//					inst = inst.getFunction().getLocal(operand).getSrcInst();
//					if(inst==null)
//						return "";
//				}
//			}
			int operand = inst.getNumeralOperand(index);
			Constant expr = inst.getOperand(index);
			if(expr.isGlobalVariable()){
				return "@"+expr.toString();
			}else{
				inst = inst.getFunction().getLocal(operand).getSrcInst();
				if(inst==null)
					return "";
			}
		}
		
		switch(inst.getOpcode()){
			case InstType.icmpInst:
				buffer.append("("); 
				int operand = inst.getNumeralOperand(0);
				
				if(operand != 0){	//not a constant
					Instruction inst0 = inst.getFunction().getLocal(operand).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
				}else{	//constant
					buffer.append(inst.getOperand(0).toString());
				}
				
				CmpInst cmpInst;
				//if(inst instanceof CmpInst){
				cmpInst = (CmpInst)inst;
				//}
				buffer.append(CompareCondition.getCondIcon(cmpInst.getCond()));
				
				buffer.append(inst.getOperand(1).toString());
				
				buffer.append(")");
				
				break;
			case InstType.loadInst:{
				Constant expr = inst.getOperand(0);
				
				if(expr.isGlobalVariable()){	//end and return
					buffer.append("@"+expr.toString()+":"+inst.getType(0).toString()+".") ;
				}else if(expr.isLocalVariable()){
					int exprIndex = inst.getNumeralOperand(0);
					Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
					buffer.append(inst.getType(0).toString()+".");
				}
				
				break;
			}
			case InstType.getElePtrInst:{
				Constant expr = inst.getOperand(0);
				
				if(expr.isGlobalVariable()){
					buffer.append("@"+expr.toString()+":"+inst.getType(0).toString()+".");
				}else if(expr.isLocalVariable()){
					int exprIndex = inst.getNumeralOperand(0);
					Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
					buffer.append(inst.getType(0).toString()+".");
				}
				
				break;
			}
			case InstType.callInst:{
				Constant callFunction = inst.getOperand(0);
				buffer.append("call@"+callFunction.toString()+":"+inst.getType(0).toString()+".");
				break;
			}
			case InstType.allocaInst:{
				Constant dest = inst.getDest();
				buffer.append("%"+dest.toString()+":");
				
				break;
			}
			case InstType.binaryInst:{
				String opStr = ((BinaryInst)inst).getOpStr();
				Constant arg0 = inst.getOperand(0);
				Constant arg1 = inst.getOperand(1);
				
				if(arg0.isGlobalVariable()){
					buffer.append("@"+arg0.toString()+":"+inst.getType(0).toString()+".");
				}else if(arg0.isLocalVariable()){
					int exprIndex = inst.getNumeralOperand(0);
					Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
					buffer.append(inst.getType(0).toString()+".");
				}else{
					buffer.append(arg0.toString());
				}
				
				buffer.append(" "+ opStr +" ");
				
				if(arg1.isGlobalVariable()){
					buffer.append("@"+arg0.toString()+":"+inst.getType(0).toString()+".");
				}else if(arg1.isLocalVariable()){
					int exprIndex = inst.getNumeralOperand(1);
					Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
					buffer.append(inst.getType(0).toString()+".");
				}else{
					buffer.append(arg0.toString());
				}
				
				break;
			}
			case InstType.phiInst:{
				Constant phi0 = inst.getOperand(0);
				if(phi0.isGlobalVariable()){	//end and return
					buffer.append("@"+phi0.toString()+":"+inst.getType(0).toString()+".") ;
				}else if(phi0.isLocalVariable()){
					int exprIndex = inst.getNumeralOperand(0);
					Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
					buffer.append(inst.getType(0).toString()+".");
				}else{
					buffer.append(phi0.toString());
				}
				break;
			}
			case InstType.selectInst:{
				Constant select1 = inst.getOperand(1);
				if(select1.isGlobalVariable()){	//end and return
					buffer.append("@"+select1.toString()+":"+inst.getType(0).toString()+".") ;
				}else if(select1.isLocalVariable()){
					int exprIndex = inst.getNumeralOperand(1);
					Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
					buffer.append(parseVariableString(inst0, -1));
					buffer.append(inst.getType(0).toString()+".");
				}else{
					buffer.append(select1.toString());
				}
				break;
			}
			default:
				if(inst.isCastInst()){
					Constant arg0 = inst.getOperand(0);
					
					if(arg0.isGlobalVariable()){
						buffer.append("@"+arg0.toString()+":"+inst.getType(0).toString()+".");
					}else if(arg0.isLocalVariable()){
						int exprIndex = inst.getNumeralOperand(0);
						Instruction inst0 = inst.getFunction().getLocal(exprIndex).getSrcInst();
						buffer.append(parseVariableString(inst0, -1));
						buffer.append(inst.getType(0).toString()+".");
					}else{
						buffer.append(arg0.toString());
					}
				}
				break;
		}
		
		return buffer.toString();
	}

	/**
	 * parse the target inst to get solver's Expr
	 * @param inst: current inst
	 * @param operandIndex: the operand in current inst. -1 means the operand is dst at the left of an inst.
	 * @return
	 */
	public static List<Expr> parseSTPExprs(Instruction inst){
		List<Expr> exprList = new ArrayList<Expr>();
		if(inst == null){
			return exprList;
		}
		
		String func_name = inst.getFunction().getFunctionName();
		
		VC vc = SolverUtil.vc;
		Expr expr = null;
		
		switch(inst.getOpcode()){
			case InstType.brInst:
				if(inst.isConditionalBranch()){
					Instruction srcInst = inst.getFunction().getLocal(inst.getNumeralOperand(0)).getSrcInst();
					
					exprList = parseSTPExprs(srcInst);
				}
				
				break;
			case InstType.switchInst:
				Instruction srcInst = inst.getFunction().getLocal(inst.getNumeralOperand(0)).getSrcInst();
				exprList = parseSTPExprs(srcInst);
				
				break;
			case InstType.icmpInst:
				Expr arg0 = getOperandExpr(inst, 0, exprList);
				Expr arg1 = getOperandExpr(inst, 1, exprList);			
				CmpInst cmpInst;
				cmpInst = (CmpInst)inst;
				String condStr = CompareCondition.getCondStr(cmpInst.getCond());
				
				if(condStr.equals("eq")){
					expr = vc.eqExpr(arg0, arg1);
				}
				if(condStr.equals("ne")){
					expr = vc.notExpr(vc.eqExpr(arg0, arg1));
				}
				if(condStr.equals("sgt")){
					expr = vc.sbvGtExpr(arg0, arg1);
				}
				if(condStr.equals("sge")){
					expr = vc.sbvGeExpr(arg0, arg1);
				}
				if(condStr.equals("slt")){
					expr = vc.sbvLtExpr(arg0, arg1);
				}
				if(condStr.equals("sle")){
					expr = vc.sbvLeExpr(arg0, arg1);
				}
				
				if(condStr.equals("ugt")){
					expr = vc.bvGtExpr(arg0, arg1);
				}
				if(condStr.equals("uge")){
					expr = vc.bvGeExpr(arg0, arg1);
				}
				if(condStr.equals("ult")){
					expr = vc.bvLtExpr(arg0, arg1);
				}
				if(condStr.equals("ule")){
					expr = vc.bvLeExpr(arg0, arg1);
				}
				
				break;
			case InstType.loadInst:{
				Expr dest = getOperandExpr(inst, -1, exprList);
				Expr arg = getOperandExpr(inst, 0, exprList);
				
				expr = vc.eqExpr(dest, arg);
				
				break;
			}
			case InstType.getElePtrInst:{
				Constant tar = inst.getOperand(0);
				String arg_name = "";
				if(tar.isGlobalVariable()){
					arg_name = func_name+"_@";
				}else{
					arg_name = func_name+"_%";
				}
				arg_name+=tar.toString();
				
				int num = inst.getNumOperands();
				for(int i = 1; i < num; i++){
					arg_name+="_"+inst.getOperand(i).toString();
				}
				
				Expr dest = getOperandExpr(inst, -1, exprList);
				Expr arg = SolverUtil.getExprOfVariable(arg_name);
				
				expr = vc.eqExpr(dest, arg);
				
				break;
			}
			case InstType.allocaInst:{
//				Constant dest = inst.getDest();
//				String arg_name = func_name+"_%"+dest.toString();
//				
//				Expr arg = SolverUtil.getExprOfVariable(arg_name);
//				expr = vc.eqExpr(arg, arg);
				
				break;
			}
			case InstType.binaryInst:{
				String opStr = ((BinaryInst)inst).getOpStr();
				Expr argleft = getOperandExpr(inst, 0, exprList);
				Expr argright = getOperandExpr(inst, 1, exprList);
				Expr argdest = getOperandExpr(inst, -1, exprList);
				
				if(opStr.equals("add")||opStr.equals("fadd")){
					expr = vc.eqExpr(argdest, vc.bv32PlusExpr(argleft, argright));
				}
				if(opStr.equals("sub")||opStr.equals("fsub")){
					expr = vc.eqExpr(argdest, vc.bv32MinusExpr(argleft, argright));
				}
				if(opStr.equals("mul")||opStr.equals("fmul")){
					expr = vc.eqExpr(argdest, vc.bv32MultExpr(argleft, argright));
				}
				if(opStr.equals("udiv")||opStr.equals("sdiv")||opStr.equals("fdiv")){
					expr = vc.eqExpr(argdest, vc.bvDivExpr(32, argleft, argright));
				}
				if(opStr.equals("urem")||opStr.equals("frem")){
					expr = vc.eqExpr(argdest, vc.bvModExpr(32, argleft, argright));
				}
				if(opStr.equals("shl")){
					expr = vc.eqExpr(argdest, vc.bv32LeftShiftExpr(Integer.parseInt(inst.getOperand(1).toString()), argleft));
				}
				if(opStr.equals("lshr")||opStr.equals("ashr")){
					expr = vc.eqExpr(argdest, vc.bv32RightShiftExpr(Integer.parseInt(inst.getOperand(1).toString()), argleft));
				}
				if(opStr.equals("and")){
					expr = vc.eqExpr(argdest, vc.bvAndExpr(argleft, argright));
				}
				if(opStr.equals("or")){
					expr = vc.eqExpr(argdest, vc.bvOrExpr(argleft, argright));
				}
				if(opStr.equals("xor")){
					expr = vc.eqExpr(argdest, vc.bvXorExpr(argleft, argright));
				}
				
				break;
			}
			case InstType.callInst:{
				Expr dest = getOperandExpr(inst, -1, exprList);
				Expr arg = SolverUtil.getExprOfVariable("call_@"+inst.getOperand(0).toString());
				expr = vc.eqExpr(dest, arg);
				break;
			}
			case InstType.phiInst:{
				Expr destphi = getOperandExpr(inst, -1, exprList);
				Expr arg0phi = getOperandExpr(inst, 0, exprList);
				expr = vc.eqExpr(destphi, arg0phi);
				break;
			}
			case InstType.selectInst:{
				Expr destselect = getOperandExpr(inst, -1, exprList);
				Expr arg1select = getOperandExpr(inst, 1, exprList);
				expr = vc.eqExpr(destselect, arg1select);
				break;
			}
			default:
				if(inst.isCastInst()){
					Expr dest = getOperandExpr(inst, -1, exprList);
					Expr arg = getOperandExpr(inst, 0, exprList);
					expr = vc.eqExpr(dest, arg);
				}else{	//unhandled instructions: phi select.
					//System.out.println("Unhandled instructions: "+inst.toString());
				}
				break;
		}
		
		if(expr!=null){
			exprList.add(expr);
		}
		
		return exprList;
	}
	
	public static Expr getOperandExpr(Instruction inst, int index, List<Expr> exprList){		
		Expr expr = SolverUtil.UNDEF;
		String func_name = inst.getFunction().getFunctionName();
		
		//dest is always local variable
		if(index == -1){
			Constant operand = inst.getDest();
			expr = SolverUtil.getExprOfVariable(func_name+"_%"+operand.toString());
		}else{
			Constant operand = inst.getOperand(index);
			
			if(operand.isGlobalVariable()){
				expr = SolverUtil.getExprOfVariable(func_name+"_@"+operand.toString());
			}else if(operand.isLocalVariable()){
				Instruction srcInst = inst.getFunction().getLocal(inst.getNumeralOperand(index)).getSrcInst();
				if(srcInst==null){//variable is an argument
					
				}else{
					exprList.addAll(parseSTPExprs(srcInst));
				}
				
				expr = SolverUtil.getExprOfVariable(func_name+"_%"+operand.toString());
			}else if(operand.isSimpleConstantValue()){
				expr = SolverUtil.getExprOfSimpleValue((SimpleConstantValue)operand);
			}
		}
	
		return expr;
	}
	
	public static Expr getOperandExpr(Instruction inst, int index){
		Expr expr = SolverUtil.UNDEF;
		String func_name = inst.getFunction().getFunctionName();
		
		if(index == -1){
			Constant operand = inst.getDest();
			expr = SolverUtil.getExprOfVariable(func_name+"_%"+operand.toString());
		}else{
			Constant operand = inst.getOperand(index);
			
			if(operand.isGlobalVariable()){
				expr = SolverUtil.getExprOfVariable(func_name+"_@"+operand.toString());
			}else if(operand.isLocalVariable()){
				expr = SolverUtil.getExprOfVariable(func_name+"_%"+operand.toString());
			}else if(operand.isSimpleConstantValue()){
				expr = SolverUtil.getExprOfSimpleValue((SimpleConstantValue)operand);
			}
		}
	
		return expr;
	}
}
