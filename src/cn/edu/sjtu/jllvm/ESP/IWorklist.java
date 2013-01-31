package cn.edu.sjtu.jllvm.ESP;

/**
 * @author liuhao 2011-12-19
 * A workList is a set of <Location, State>
 */
public interface IWorklist {
	/**
	 * @return: true if the list is empty, otherwise return false.
	 */
	public boolean isEmpty();
	
	/**
	 * remove a node and return it.
	 * @return: the node in list. if no next node, return null
	 */
	public WorkPair remove();
	
	public void removeAll();
	
	/**
	 * add a node in list
	 * @param loc: location 
	 * @param state: changed state of the location
	 */
	public void add(ILocation loc, IState state);
}
