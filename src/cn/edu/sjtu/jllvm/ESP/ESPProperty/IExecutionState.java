package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import stp.Expr;

public interface IExecutionState {
	
	/**
	 * add a constraint to current state. if this state is unsatisfied, set it to bottom
	 * @param constraint:
	 */
	public void addConstraint(String constraint);
	
	public void addConstraint(Expr constraints);
	
	public Clause getConstraints();
	
	/**
	 * if this state less equal than a state
	 * @param in: the state to be compare in right hand 
	 * @return: true if this state is less equal than target state.
	 */
	public boolean belongTo(IExecutionState in);
	
	/**
	 * Union this state to src state
	 * @param src
	 */
	public void union(IExecutionState src);
	
	public IExecutionState copy();
	
	public boolean isTop();
	
	public boolean isBottom();
	
	public void setTop();
	
	public void setBottom();
	
	@Override
	public String toString();
}
