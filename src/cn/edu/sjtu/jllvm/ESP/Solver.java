package cn.edu.sjtu.jllvm.ESP;
import stp.*;

/**
 * 
 * @author tm
 * The interface of STP solver
 */
public interface Solver {
	//boolean expressions
	public Expr andExpr(Expr t1, Expr t2);
	public Expr orExpr(Expr t1, Expr t2);
	public Expr notExpr(Expr t1);
	
	//bit vector operations
	public Expr plusExpr(Expr t1, Expr t2);
	public Expr multExpr(Expr t1, Expr t2);
	public Expr subExpr(Expr t1, Expr t2);
	public Expr minusExpr(Expr t1, Expr t2);
	public Expr divExpr(Expr t1, Expr t2);
	public Expr modExpr(Expr t1, Expr t2);

	//equality
	public Expr eqExpr(Expr t1);
	//less than
	public Expr ltExpr(Expr t1);
	//greater than
	public Expr gtExpr(Expr t1);
	//less than or equal to
	public Expr leExpr(Expr t1);
	//greater than or equal to
	
	public Expr bvAndExpr(Expr t1, Expr t2);
	public Expr bvOrExpr(Expr t1, Expr t2);
	public Expr bvNotExpr(Expr t1);
}
