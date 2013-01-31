package cn.edu.sjtu.jllvm.Lockset;

import java.util.ArrayList;
import java.util.List;

public class Lockset {
	private List<Lock> lockList;
	
	public Lockset(){
		lockList = new ArrayList<Lock>();
	}
	
	public boolean isEmpty(){
		return lockList.size()==0;
	}
	
	public boolean equals(Lockset ls){
		if(lockList.size() != ls.lockList.size())
			return false;
		if(lockList.size() == 0)
			return true;
		
		for(Lock lock: lockList){
			boolean exist = false;
			for(Lock lock2: ls.lockList){
				if(lock.equals(lock2)){
					exist = true;
					break;
				}
			}
			if(!exist)
				return false;
		}
		
		return true;
	}
	
	public void addLock(Lock lock){
		Lock lo = getLockInSet(lock);
		if(lo==null){
			lockList.add(lock);
			lock.lock();
		}else{
			lo.lock();
		}
	}
	
	public void removeLock(Lock lock){
		Lock lo = getLockInSet(lock);
		if(lo==null){
			lock.unlock();
			
			lockList.add(lock);
		}else{
			lo.unlock();
		}
	}
	
	public Lock getLockInSet(Lock lock){
		for(Lock lo:lockList){
			if(lo.getName().equals(lock.getName()))
				return lo;
		}
		return null;
	}
	
	public Lockset copy(){
		Lockset newLockset = new Lockset();
		List<Lock> list = new ArrayList<Lock>();
		for(int i = 0; i<lockList.size(); i++){
			list.add(lockList.get(i).copy());
		}
		newLockset.setLockList(list);
		return newLockset;
	}
	
	public void setLockList(List<Lock> lockList){
		this.lockList = lockList;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer();
		if(lockList.size()==0){
			buf.append("{}");
		}else{
			boolean first = true;
			for(Lock lock:lockList){
				if(first){
					buf.append("{"+lock.toString());
					first = false;
				}else{
					buf.append(", "+lock.toString());
				}
			}
			buf.append("}");
		}
		
		return buf.toString();
	}
}
