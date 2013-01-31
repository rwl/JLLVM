package cn.edu.sjtu.jllvm.Lockset;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FunctionCache {
	private List<Edge> edges;
	private boolean on_stack_p;
	private Hashtable<String, List<LocksetPair>> blockLocksetPairs;	//store each block's locksetPair, index by blockID
	
	private boolean isRelateToLock;	//record whecher this function has lock, used in intraprocedural; 
	
	public FunctionCache(){
		edges = new ArrayList<Edge>();
		on_stack_p = false;
		blockLocksetPairs = new Hashtable<String, List<LocksetPair>>();
		isRelateToLock = false;
	}
	
	public boolean isRelateToLock(){
		return isRelateToLock;
	}
	
	public void relateToLock(){
		isRelateToLock = true;
	}
	
	public void addLocksets(Edge edge){
		edges.add(edge);
	}
	
	public List<Lockset> getLockSets(Lockset ls){
		for(Edge edge: edges){
			if(edge.getEntry_lockset().equals(ls))
				return edge.getExit_locksets();
		}
		
		return null;
	}
	
	public boolean containsLocksetPair(String blockID, LocksetPair lp){
		List<LocksetPair> pairs = blockLocksetPairs.get(blockID);
		if(pairs==null){
			pairs = new ArrayList<LocksetPair>();
			blockLocksetPairs.put(blockID, pairs);
			return false;
		}
		for(LocksetPair pair: pairs){
			if(pair.equals(lp))
				return true;
		}
		
		return false;
	}
	
	public void addLocksetPair(String blockID, LocksetPair lp){
		List<LocksetPair> pairs = blockLocksetPairs.get(blockID);
		if(pairs==null){
			pairs = new ArrayList<LocksetPair>();
			blockLocksetPairs.put(blockID, pairs);
		}
		pairs.add(lp);
	}
	
	public boolean onStack(){
		return on_stack_p;
	}
	
	public void setOnStack(){
		on_stack_p = true;
	}
	
	public void setOffStack(){
		on_stack_p = false;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer();
		for(Edge edge:edges){
			buf.append(edge.toString()+"\n");
		}
		return buf.toString();
	}
}
