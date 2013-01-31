package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import java.util.Hashtable;

import cn.edu.sjtu.jllvm.ESP.IStateFactory;
import cn.edu.sjtu.jllvm.ESP.IState;
import cn.edu.sjtu.jllvm.ESP.IWorklist;
import cn.edu.sjtu.jllvm.ESP.Worklist;


public class ESPStateFactory implements IStateFactory{
	
	public static ISymbolicState createBottomSymbolicState(){
		return new SymbolicState();
	}
	
	public static ESPState createTopState(){
		Hashtable<String, ISymbolicState> info = new Hashtable<String, ISymbolicState>();
		ISymbolicState ss = new SymbolicState();
		ss.getExecutionState(0).setTop();
		info.put(ESPTransitionSystem.currentStateId, ss);
		
		ESPState state=new ESPState(); 
		state.setInfo(info);
		
		return state;
	}
	
	public static ESPState createBottomState(){
		Hashtable<String, ISymbolicState> info = new Hashtable<String, ISymbolicState>();
		ISymbolicState ss = new SymbolicState();
		info.put(ESPTransitionSystem.currentStateId, ss);
		
		ESPState state=new ESPState(); 
		state.setInfo(info);
		
		return state;
	}

	@Override
	public IWorklist createWorklist() {
		return new Worklist();
	}

	@Override
	public IState createInitBottomState() {
		return ESPStateFactory.createBottomState();
	}

	@Override
	public IState createInitTopState() {
		return ESPStateFactory.createTopState();
	}
}
