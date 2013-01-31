package cn.edu.sjtu.jllvm.Lockset;

public class Lock {
	private String name;
	
	/*state: 0 means lockstate is unchanged, also each lock's state is initialized by 0
			 1 means lock one time
			 2 means lock more than one time and this state will never change
			 -1 means unlock one time, if the lockstate is -1 and also want to lock it, the state will stay -1.
			 -2 means unlock more than one time and this state will never change
	*/		
	private int state;	
	
	public Lock(String name){
		this.name = name;
		state = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Lock lock){
		return name.equals(lock.name) && state == lock.state;
	}
	
	public void lock(){
		if(state == 2 || state < 0){
			return;
		}else {	//0 or 1
			state++;
		}
	}
	
	public void unlock(){
		if(state == 2 || state == -2){
			return;
		}else {
			state--;
		}	
	}
	
	public Lock copy(){
		Lock newLock = new Lock(this.name);
		newLock.state = state;
		return newLock;
	}
	
	@Override
	public String toString(){
		return name+" "+state;
	}
}
