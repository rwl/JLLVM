package cn.edu.sjtu.jllvm.ESP;

import java.util.Hashtable;
import java.util.List;


/**
 * @author liuhao 2011-12-19
 * A system is the target program we need to solve with model checking algorithm.
 * Usually a CFG, or a Function.
 */
public interface ITransitionSystem {
	
	/**
	 * add ModelChecking's worklist to this system
	 * @param worklist: a list need to be solved.
	 */
	public void setWorklist(IWorklist worklist);
	
	/**
	 * set all locations in this system to be bottom state, 
	 * which means all locations is initially unreachable.
	 */
	public void setAllLocationStateBottom();
	
	/**
	 * get all locations' state information
	 * @return: the information of all locaitons in system.
	 */
	public Hashtable<ILocation, IState> getAllLocationStates();
	
	/**
	 * @return: true if has next entry node, otherwise false.
	 */
	public boolean hasEntry();
	
	/**
	 * get an entry node which is to be added in worklist
	 * @return: next entry node in this system, if no next node, return null
	 */
	public ILocation nextEntry();
	
	/**
	 * @param loc
	 * @return loc's successors. if no successor, return an empty List;
	 */
	public List<ILocation> getSuccessors(ILocation loc);
	
	/**
	 * return the changed state need to be added to dest location.
	 * @param src: the entry node of an edge.
	 * @param dest: the dest node of an edge.
	 * @return: the changed state need to be update in dest node.
	 */
	public IState getPost(ILocation src, ILocation dest);
	
	/**
	 * print out debug info in console or output file
	 */
	public void print();
	
	public String getInfo();
}
