package cn.edu.sjtu.jllvm.ESP;

import java.util.Date;
import java.util.Hashtable;

import java.util.List;

import cn.edu.sjtu.jllvm.ESP.ESPProperty.ESPStateFactory;
import cn.edu.sjtu.jllvm.ESP.ESPProperty.ESPTransitionSystem;

/**
 * using model checking algorithm to solve a worklist 
 * @author liuhao 2011-12-19
 */
public class ESPChecking {
	private IStateFactory factory;
	private ITransitionSystem system;
	private Hashtable<ILocation, IState> reach;
	
	private int TIME_OUT = ESPTransitionSystem.USE_SOLVER?120000:20000;	//20s
	private boolean DEBUG = false;
	
	public ESPChecking(){
		factory = new ESPStateFactory();
	}
	
	/**
	 * solve a system, the system can return several entry node.
	 * @param system: a system usually is a CFG
	 * */
	public void solve(ITransitionSystem system){
		this.system = system;
		
		system.setAllLocationStateBottom();		//for all location, let reach(l) = BottomState
		reach = system.getAllLocationStates();		
		
		IWorklist worklist = factory.createWorklist();	//empty worklist
		system.setWorklist(worklist);
		
		while(system.hasEntry()){
			ILocation loc = system.nextEntry();
			if(loc==null)
				break;
			
			IState initState = factory.createInitTopState();
			
			worklist.add(loc, initState);	//worklist = {(entryNode, TopState)}
			
			solve(worklist);
		}
	}
	
	/**
	 * using worklist algorithm to solve a worklist until it is empty 
	 * @param worklist: initially only has one node.
	 */
	public void solve(IWorklist worklist){
		Date stateTime = new Date();
		
		while(!worklist.isEmpty()){
			if(!DEBUG){
				Date now = new Date();
				if(now.getTime() - stateTime.getTime() > TIME_OUT){
					worklist.removeAll();
					System.out.println("TIME_OUT");
					return;
				}
			}
			
			WorkPair workNode = worklist.remove();		//worklist.remvoe();
			ILocation loc = workNode.getLocation();
			IState state = workNode.getState();
			
			IState reach_state = reach.get(loc);	//reach(l)
			
			boolean isBelongTo = state.belongTo(reach_state);
			if(!isBelongTo){		//!(state<=raach_state)  that is: state > reach_state
				IState temp_state = reach_state.copy();
				reach_state.union(state);
				
				List<ILocation> dsts = system.getSuccessors(loc);
				for(ILocation next: dsts){
					IState post = system.getPost(loc, next);
					
					if(post != null){
						worklist.add(next, post);
					}else{
						reach_state = temp_state;
						reach.put(loc, reach_state);
						worklist.add(loc, state);
						
						break;
					}
				}
			}
		}
	}
	
	/**
	 * print out debug info
	 */
	public void print(){
		system.print();
	}
	
	public String getInfo(){
		return system.getInfo();
	}
}
