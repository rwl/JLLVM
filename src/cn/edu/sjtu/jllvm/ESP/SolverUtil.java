package cn.edu.sjtu.jllvm.ESP;


import java.util.Hashtable;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;

import stp.Expr;
import stp.VC;

public class SolverUtil {
	public static VC vc = new VC();
	public static Hashtable<String, Expr> exprTable = new Hashtable<String, Expr>();
	public static Expr NULL = vc.varExpr("null", vc.bv32Type());
	public static Expr TRUE = vc.varExpr("true", vc.bv32Type());
	public static Expr FALSE = vc.varExpr("false", vc.bv32Type());
	public static Expr UNDEF = vc.varExpr("undef", vc.bv32Type());
	
	public static final int EQUAL = 1, LESSEQUAL = 2, GREATEQUAL = 3, NOT = 4, NOTCONTAIN = 5;
	
	public SolverUtil(){
		
	}
	
	public static Expr getExprOfVariable(String name){
		if(name == null){
			return UNDEF;
		}
		
		Expr expr = exprTable.get(name);
		if(expr == null){
			expr = vc.varExpr(name, vc.bv32Type());
			exprTable.put(name, expr);
		}
		
		return expr;
	}
	
	public static Expr getExprOfSimpleValue(SimpleConstantValue value){
		Expr expr = null;
		
		if(value.isInt()){
			try{
				expr = vc.bv32ConstExprFromInt(Integer.parseInt(value.toString()));
			}catch (Exception e) {
				expr = vc.bv32ConstExprFromInt(Integer.parseInt(value.toString().substring(6)));
			}
		}else if(value.isNullValue()){
			expr = SolverUtil.NULL;
		}else if(value.isBoolean()){
			if(value.toString().equals("true"))
				expr = SolverUtil.TRUE;
			else
				expr = SolverUtil.FALSE;
		}else{
			System.out.println("Unhandled constant value");
			expr = SolverUtil.UNDEF;
		}
		
		return expr;
	}
	
	public static Expr createExprOfVariable(String name){
		Expr expr = vc.varExpr("nresp1", vc.bv32Type());
		exprTable.put(name, expr);
		
		return expr;
	}
	
	public static boolean sameExpr(Expr e1, Expr e2){
		if(e1.toString().equals(e2.toString()))
			return true;
		
		int count = 0;
		vc.push();
		vc.assertFormula(e1);
		if(vc.query(e2) == 1){
			count++;
		}
		vc.pop();
		
		vc.push();
		vc.assertFormula(e2);
		if(vc.query(e1) == 1){
			count++;
		}
		vc.pop();
		
		if(count == 2)
			return true;
		else 
			return false;
	}
	
	/**
	 * 
	 * @param e1
	 * @param e2
	 * @return 1 e1 == e2; 2 e1 > e2; 3 e1 < e2; 4 other
	 */
	public static int compare(Expr e1, Expr e2){
		boolean e1_le_e2 = false;
		boolean e2_le_e1 = false;
		vc.push();
		vc.assertFormula(e1);
		if(vc.query(e2)==1){
			//e1<=e2
			e1_le_e2 = true;
		}
		vc.pop();
		
		vc.push();
		vc.assertFormula(e2);
		if(vc.query(e1)==1){
			//e2<=e1
			e2_le_e1 = true;
		}
		vc.pop();
		
		if(e1_le_e2){
			if(e2_le_e1){
				return SolverUtil.EQUAL;
			}else{
				return SolverUtil.LESSEQUAL;
			}
		}else{
			if(e2_le_e1){
				return SolverUtil.GREATEQUAL;
			}else{
				Expr not_e1 = vc.notExpr(e1);
				int count = 0;
				vc.push();
				vc.assertFormula(not_e1);
				if(vc.query(e2)==1){
					count++;
				}
				vc.pop();
				vc.push();
				vc.assertFormula(e2);
				if(vc.query(not_e1)==1){
					count++;
				}
				vc.pop();
				if(count == 2){	// not_e1 == e2
					return SolverUtil.NOT;
				}else{
					return SolverUtil.NOTCONTAIN;
				}
			}
		}
	}
	
	public static Expr andExprN(List<Expr> clauses){
		return vc.andExprN((Expr[])clauses.toArray());
	}
	
	public static boolean andTrue(Expr e1, Expr e2){
		vc.push();
		vc.assertFormula(e1);
		int result = vc.query(e2);
		vc.pop();
		
		if(result == 1)
			return true;
		
		vc.push();
		vc.assertFormula(e2);
		result = vc.query(e1);
		vc.pop();
		
		if(result == 1)
			return true;
		
		return false;
	}
}
