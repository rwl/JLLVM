package cn.edu.sjtu.jllvm.ESP;

/**
 * @author liuhao 2011-12-19
 * new an Object and return
 */
public interface IStateFactory {
	
	/**
	 * @return: an empty worklist
	 */
	public IWorklist createWorklist();
	
	/**
	 * @return: a bottom state
	 */
	public IState createInitBottomState();
	
	/**
	 * @return: an initial top state
	 */
	public IState createInitTopState();
}
