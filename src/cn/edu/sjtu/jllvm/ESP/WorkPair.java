package cn.edu.sjtu.jllvm.ESP;

/**
 * @author liuhao 2011-12-30
 *	This class is used to store a node in worklist. It contains a location and a state of that location.
 */
public class WorkPair {
	private ILocation location;
	private IState state;
	
	public WorkPair(ILocation loc, IState s){
		location = loc;
		state = s;
	}
	
	public ILocation getLocation(){
		return location;
	}
	
	public IState getState(){
		return state;
	}
}
