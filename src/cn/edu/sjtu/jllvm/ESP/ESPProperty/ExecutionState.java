package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import stp.Expr;

public class ExecutionState implements IExecutionState {
	Clause constraints;
	
	public ExecutionState(){
		constraints = new Clause();
	}
	
	public void setConstraints(Clause constraints) {
		this.constraints = constraints;
	}

	public void addConstraint(Literal lit) {
		constraints.addConstraint(lit);
	}

	@Override
	public void addConstraint(String c) {
		if(this.isBottom())
			return;
		
		Literal lit = null;
		if(c.startsWith("!")){
			lit = new Literal(c.substring(1), Literal.NOT);
		}else{
			lit = new Literal(c, Literal.IS);
		}
		
		addConstraint(lit);
	}

	@Override
	public Clause getConstraints() {
		return constraints;
	}

	@Override
	public void union(IExecutionState in) {
		this.constraints.union(in.getConstraints());
	}

	@Override
	public boolean belongTo(IExecutionState in){
		return this.constraints.belongTo(in.getConstraints());
	}
	
	@Override
	public IExecutionState copy() {
		ExecutionState re = new ExecutionState();
		
		re.setConstraints(constraints.copy());
		
		return re;
	}

	public boolean equals(IExecutionState src) {
		return constraints.equals(src.getConstraints());
	}

	@Override
	public String toString() {
		String buffer = "[ ";
		
		buffer+=constraints.toString();
		return buffer+" ]";
	}

	@Override
	public boolean isTop() {
		return constraints.isTop();
	}

	@Override
	public boolean isBottom() {
		return constraints.isBottom();
	}
	
	@Override
	public void setBottom() {
		constraints.setBottom();
	}
	
	@Override
	public void setTop() {
		constraints.setTop();
	}

	@Override
	public void addConstraint(Expr constraint) {
		// TODO Auto-generated method stub
		
	}
}
