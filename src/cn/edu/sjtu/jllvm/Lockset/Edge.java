package cn.edu.sjtu.jllvm.Lockset;

import java.util.ArrayList;
import java.util.List;

public class Edge {
	private Lockset entry_lockset;
	private List<Lockset> exit_locksets;
	
	public Edge(Lockset entry){
		entry_lockset = entry;
		exit_locksets = new ArrayList<Lockset>();
	}
	
	public Lockset getEntry_lockset() {
		return entry_lockset;
	}
	public void setEntry_lockset(Lockset entry_lockset) {
		this.entry_lockset = entry_lockset;
	}
	public List<Lockset> getExit_locksets() {
		return exit_locksets;
	}
	public void setExit_locksets(List<Lockset> exit_locksets) {
		this.exit_locksets = exit_locksets;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer();
		if(exit_locksets.size()==0)
			buf.append(entry_lockset.toString()+"->"+"{}");
		else{
			for(Lockset ls:exit_locksets){
				buf.append(entry_lockset.toString()+"->"+ls.toString()+"\n");
			}
		}
		
		return buf.toString();
	}
}
