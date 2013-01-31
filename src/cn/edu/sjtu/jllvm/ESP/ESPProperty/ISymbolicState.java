package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import stp.Expr;

public interface ISymbolicState {
	
	/**
	 * Union this SymbolicState with ss
	 * @param ss
	 */
	public void union(ISymbolicState ss);
	
	/**
	 * if this state less equal than a state
	 * @param in: the state to be compare in right hand 
	 * @return: true if this state is less equal than target state.
	 */
	public boolean belongTo(ISymbolicState ss);
	
	/**
	 * handle state change
	 * @param fName: function that is going to change current state
	 */
	public void transit(String fName);
	
	/**
	 * add a constraint to current state. if this state is unsatisfied, set it to bottom
	 * @param constraint:
	 */
	public void addConstraint(String constraint);
	
	/**
	 * add a constraint to current state. if this state is unsatisfied, set it to bottom
	 * @param constraint:
	 */
	public void addConstraint(Expr constraint);
	
	/**
	 * Because the symbolic is divided into several abstractstates and their executionstates.
	 * Getting a total exectuionstate is to return the unioned executionstate of every abstractstates.
	 * @return: unioned executionstate of every abstractstates.
	 */
	public IExecutionState getTotalExecutionState();
	
	public void setExecutionState(IExecutionState[]es);
	
	public IExecutionState getExecutionState(int index);
	
	public ISymbolicState copy();

	public boolean isBottom();
	
	@Override
	public String toString();
	
}
