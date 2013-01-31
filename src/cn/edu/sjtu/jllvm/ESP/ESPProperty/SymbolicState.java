package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import stp.Expr;

/**
 * @author liuhao 2012-1-3
 * Lock's SymbolicState of ESP. 3 AbstractState: Uinit, Locked, Error, which each has 
 * a certainly ExecutionState stored in a array es.
 */
public class SymbolicState implements ISymbolicState {
	private String[] as = {"UNINIT", "LOCKED", "ERROR"};
	private IExecutionState[] es;
	
	public SymbolicState(){
		es = new IExecutionState[as.length];
		for(int i=0; i<es.length; i++){
			if(ESPTransitionSystem.USE_SOLVER){
				es[i] = new ExecutionState_STP();
			}else{
				es[i] = new ExecutionState();
			}
		}
	}

	@Override
	public void transit(String fName) {
		if(fName.endsWith("unlock")){
			es[2].union(es[0]);		//uinit -> error;
			
			es[0].setBottom();
			es[0].union(es[1]);		//locked -> uinit;
			es[1].setBottom();
		}else{
			es[2].union(es[1]);		//locked -> error;
			
			es[1].setBottom();
			es[1].union(es[0]);		//unit -> locked;
			es[0].setBottom();
		}
	}

	@Override
	public ISymbolicState copy() {
		SymbolicState copy = new SymbolicState();
		
		IExecutionState[] temp_es = new IExecutionState[es.length];
		for(int i=0; i<es.length; i++){
			temp_es[i] = es[i].copy();
		}
		copy.setExecutionState(temp_es);
		
		return copy;
	}

	@Override
	public void setExecutionState(IExecutionState[] es) {
		this.es = es;
	}

	@Override
	public IExecutionState getExecutionState(int index) {
		return es[index];
	}

	@Override
	public boolean isBottom() {
		for(int i=0; i<es.length; i++){
			if(!es[i].isBottom())
				return false;
		}
		return true;
	}

	@Override
	public void addConstraint(String constraint) {
		for(int i=0; i<es.length; i++){
			es[i].addConstraint(constraint);
		}
	}

	@Override
	public void addConstraint(Expr constraint) {
		for(int i=0; i<es.length; i++){
			es[i].addConstraint(constraint);
		}
	}
	
	@Override
	public void union(ISymbolicState ss) {
		for(int i=0; i<as.length; i++){
			es[i].union(ss.getExecutionState(i));
		}
	}

	@Override
	public boolean belongTo(ISymbolicState ss) {		
		return getTotalExecutionState().belongTo(ss.getTotalExecutionState());
	}
	
	@Override
	public IExecutionState getTotalExecutionState(){
		if(ESPTransitionSystem.USE_SOLVER){
			IExecutionState re_es = es[0].copy();
			re_es.union(es[1]);
			re_es.union(es[2]);
			
			return re_es;
		}else{
			IExecutionState re_es = es[0].copy();
			re_es.union(es[1]);
			re_es.union(es[2]);
			
			return re_es;
		}
	}

	public boolean equals(SymbolicState sls){
		for(int i=0; i<es.length; i++){
			if(!sls.getExecutionState(i).equals(es[i]))
				return false;
		}
		
		return true;
	}

	@Override
	public String toString(){
		String str = "";
		for(int i=0; i<es.length; i++){
			if(es[i].isBottom())
				continue;
			str += "["+as[i].toString()+"], ";
			if(ESPTransitionSystem.DEBUG_INFO==ESPTransitionSystem.ALL_INFO){
				str += "\n"+es[i].toString()+"\n";
			}else if(ESPTransitionSystem.DEBUG_INFO==ESPTransitionSystem.NOT_EXECUTIONSTATE){
				str += "\n";
			}
		}
		
		return str;
	}
}
