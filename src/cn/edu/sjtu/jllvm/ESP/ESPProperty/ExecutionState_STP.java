package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sjtu.jllvm.ESP.SolverUtil;
import stp.Expr;
import stp.VC;

public class ExecutionState_STP implements IExecutionState {
	//OR relationship between each clause, AND relationship in clause.
	List<Expr> clauses;
	VC vc = SolverUtil.vc;
	
	public ExecutionState_STP(){
//		clauses = new ArrayList<Expr>();
//		setBottom();
	}
	
	@Override
	public void addConstraint(String constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public Clause getConstraints() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean belongTo(IExecutionState in) {
		if(in.isTop())
			return true;
		if(in.isBottom()){
			if(this.isBottom())
				return true;
			return false;
		}
		ExecutionState_STP in_stp = (ExecutionState_STP)in;
		
		vc.push();
		vc.assertFormula(getTotalExpr());
		int result = vc.query(in_stp.getTotalExpr());
		vc.pop();
		
		return result == 1;
	}
	
	public void setClauses(List<Expr> clauses){
		this.clauses = clauses;
	}
	
	public List<Expr> getClauses(){
		return clauses;
	}

	public Expr getTotalExpr(){
		if(isTop())
			return vc.trueExpr();
		if(isBottom())
			return vc.falseExpr();
		
		if(clauses.size()==1){
			return clauses.get(0);
		}
		
		Expr[] exprArray = new Expr[clauses.size()];
		clauses.toArray(exprArray);
		Expr total = vc.andExprN(exprArray);
		
		return total;
	}
	
	@Override
	public void union(IExecutionState src) {
		if(src.isBottom()){
			return;
		}
		
		if(src.isTop()){
			setTop();
			return;
		}
		
		if(isBottom()){
			setClauses(((ExecutionState_STP)src.copy()).getClauses());
			return;
		}
		
		if(isTop()){
			return;
		}
		
		ExecutionState_STP src_stp = (ExecutionState_STP)src;
		Expr expr1 = getTotalExpr();
		Expr expr2 = src_stp.getTotalExpr();
		
		int compare = SolverUtil.compare(expr1, expr2);
		if(compare == SolverUtil.EQUAL){
			return;
		}else if(compare == SolverUtil.LESSEQUAL){
			setClauses(src_stp.getClauses());
		}else if(compare == SolverUtil.GREATEQUAL){
		    return;
		}else if(compare == SolverUtil.NOT){
			setTop();
		}else{
			List<Expr> o_clauses = src_stp.getClauses();
			for(int i=0; i<o_clauses.size();i++){
				Expr o_literal = o_clauses.get(i);
				boolean isbreak = false;
				for(int j=0; j<clauses.size();j++){
					Expr literal = clauses.get(j);
					int compare2 = SolverUtil.compare(literal, o_literal);
					if(compare2 == SolverUtil.EQUAL || compare2 == SolverUtil.GREATEQUAL){
						isbreak = true;
						break;
					}else if (compare2 == SolverUtil.LESSEQUAL) {
						clauses.remove(j);
						clauses.add(j, o_literal);
						isbreak = true;
						break;
					}else if(compare2 == SolverUtil.NOT){
						clauses.remove(j);
						isbreak = true;
						break;
					}
					
				}
				
				if(!isbreak){
					clauses.add(o_literal);
				}
			}
		}
	}
	
	public void unionClause(List<Expr> clause, List<Expr> o_clause){
		for(int i=0; i<o_clause.size(); i++){
			Expr tarExpr = o_clause.get(i);
			boolean isbreak = false;
			for(int j=0; j<clause.size(); j++){
				Expr literal = clause.get(j);
				int compare = SolverUtil.compare(literal, tarExpr);
				if(compare == SolverUtil.EQUAL || compare == SolverUtil.GREATEQUAL){
					isbreak = true;
					break;
				}else if (compare == SolverUtil.LESSEQUAL) {
					clause.remove(j);
					clause.add(j, tarExpr);
					isbreak = true;
					break;
				}else if(compare == SolverUtil.NOT){
					clause.remove(j);
					isbreak = true;
					break;
				}
			}
			
			if(!isbreak){
				clause.add(tarExpr);
			}
		}
	}
	
	@Override
	public IExecutionState copy() {
		ExecutionState_STP re = new ExecutionState_STP();
		
		if(isTop()){
			re.setTop();
		}else if(isBottom()){
			re.setBottom();
		}else {
			List<Expr> cs = new ArrayList<Expr>();
			for(Expr expr: clauses){
				cs.add(expr);
			}
			
			re.setClauses(cs);
		}
		
		return re;
	}
	
	public void setConstraints(List<Expr> clauses){
//		THIS.CLAUSES = CLAUSES;
	}
	
	@Override
	public boolean isTop() {
		if(clauses!=null && clauses.isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean isBottom() {
		if(clauses == null)
			return true;
		return false;
	}

	@Override
	public void setTop() {
		clauses = new ArrayList<Expr>();
	}

	@Override
	public void setBottom() {
		clauses = null;
	}

	@Override
	public void addConstraint(Expr expr) {
		if(expr == null){
			return;
		}
		
		if(isBottom())
			return;
		if(isTop()){
			clauses.add(expr);
			return;
		}
		
		boolean isbreak = false;
		for(int i = 0; i<clauses.size(); i++){
			Expr literal = clauses.get(i);
			
			int compare = SolverUtil.compare(literal, expr);
			if(compare == SolverUtil.EQUAL||compare == SolverUtil.LESSEQUAL){
				isbreak = true;
				break;
			}else if (compare == SolverUtil.GREATEQUAL) {
				clauses.remove(i);
				clauses.add(expr);
				isbreak = true;
				break;
			}else if (compare == SolverUtil.NOT){
				setBottom();
				isbreak = true;
				break;
			}else{
				continue;
			}
		}
		
		if(!isbreak){
			clauses.add(expr);
		}
	}

	@Override
	public String toString(){
		return getTotalExpr().toString();
	}
}
