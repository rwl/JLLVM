package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import java.util.Hashtable;
import java.util.Set;

import stp.Expr;

import cn.edu.sjtu.jllvm.ESP.IState;


/**
 * @author liuhao 2011-12-30
 * This class is used to store multi target id's SymbolicState.
 * For exmaple, the Symbolicstates of lock1 and lock2 are stored in info.
 */
public class ESPState implements IState{
	Hashtable<String, ISymbolicState> info;
	
	@Override
	public boolean belongTo(IState in) {
		ISymbolicState ss = getSymbolicState();
		ISymbolicState ss_in = ((ESPState)in).getSymbolicState();

		return ss.belongTo(ss_in);
	}

	@Override
	public void union(IState in) {
		
		ISymbolicState ss = getSymbolicState();
		ISymbolicState ss_in = ((ESPState)in).getSymbolicState();
		
		ss.union(ss_in);
	}

	@Override
	public boolean isBottom() {
		if(info == null)
			return true;
		
		return getSymbolicState().isBottom();
	}
	
	/**
	 * add a constraint to current state. if this state is unsatisfied, set it to bottom
	 * @param constraint:
	 */
	public void addConstraint(String constraint){
		ISymbolicState ss = info.get(ESPTransitionSystem.currentStateId);

		ss.addConstraint(constraint);
	}
	
	/**
	 * add a constraint to current state. if this state is unsatisfied, set it to bottom
	 * @param constraint:
	 */
	public void addConstraint(Expr constraint){
		ISymbolicState ss = info.get(ESPTransitionSystem.currentStateId);

		ss.addConstraint(constraint);
	}
	
	/**
	 * set info
	 * @param info
	 */
	public void setInfo(Hashtable<String, ISymbolicState> info){
		this.info = info;
	}
	
	/**
	 * get current symbolic state. 
	 * if current symbolic state is null, return a bottom symbolic state
	 * @return
	 */
	public ISymbolicState getSymbolicState(){
		String curId = ESPTransitionSystem.currentStateId;
		ISymbolicState ss = info.get(curId);
		
		if(ss==null){
			ss = ESPStateFactory.createBottomSymbolicState();
			info.put(curId, ss);
		}
		return ss;
	}
	
	/**
	 * set current symbolic state
	 * @param ss
	 */
	public void setSymbolicState(ISymbolicState ss){
		info.put(ESPTransitionSystem.currentStateId, ss);
	}
	
	/**
	 * handle state change
	 * @param fName: function that is going to change current state
	 */
	public void transit(String fName){
		String curId = ESPTransitionSystem.currentStateId;
		ISymbolicState ss = info.get(curId);
		
		ss.transit(fName);
	}
	
	@Override
	public IState copy(){
		ESPState temp = new ESPState();
		Hashtable<String, ISymbolicState> temp_info = new Hashtable<String, ISymbolicState>();

		String currentId = ESPTransitionSystem.currentStateId;
		ISymbolicState ss = info.get(currentId);
		if(ss == null)
			return temp;
		
		ISymbolicState temp_ss= ss.copy();
		
		temp_info.put(currentId, temp_ss);
		temp.setInfo(temp_info);
		
		return temp;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer();
		Set<String> keys = info.keySet();
		if(keys.size() == 0){
			buf.append(" & ");
		}
		
		for(String key: keys){
			buf.append(key+" : \n");
			buf.append(getStateString(key));
		}
		
		return buf.toString();
	}
	
	public String getStateString(String stateId){
		String re = "";
		ISymbolicState ss = info.get(stateId);
		if(ss==null){
			re+=" & ";
		}else{
			if(ss.isBottom())
				re+=" & ";
			else
				re+=ss.toString();
		}
		return re;
	}
}
