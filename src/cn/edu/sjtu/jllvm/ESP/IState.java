package cn.edu.sjtu.jllvm.ESP;


/**
 * @author liuhao 2011-12-19
 *	A state may has three condition: กอ,other,T.
 *  กอ:  always be false in bottom of a lattice(no condition, impossible), 
 *  T:  always be true in top of a lattice(possible at all condition, no constraint), 
 *  other:  condition between กอ and T (has some constraint that mean be true or be false) 
 */
public interface IState {
	/**
	 * if this state less equal than a state
	 * @param in: the state to be compare in right hand 
	 * @return: true if this state is less equal than target state.
	 */
	public boolean belongTo(IState in);
	
	/**
	 * Add the input state to this state
	 * @param in
	 */
	public void union(IState in);
	
	/**
	 * @return: true if this state is false.
	 */
	public boolean isBottom();
	
	public IState copy();
	
	@Override
	public String toString();
}
