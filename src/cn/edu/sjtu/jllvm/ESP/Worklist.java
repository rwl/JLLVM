package cn.edu.sjtu.jllvm.ESP;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;

public class Worklist implements IWorklist {
	List<Instruction> nodes;
	List<IState> states;
	
	public Worklist(){
		nodes = new ArrayList<Instruction>();
		states = new ArrayList<IState>();
	}
	
	@Override
	public boolean isEmpty() {
		return nodes.size()==0;
	}

	@Override
	public WorkPair remove() {
		if(isEmpty())
			return null;
		return new WorkPair(nodes.remove(0),states.remove(0));
	}

	@Override
	public void add(ILocation loc, IState state) {
		if(nodes.contains(loc)){
			int i = nodes.indexOf(loc);
			IState is = states.get(i);
			
			is.union(state);
		}else{
			nodes.add((Instruction)loc);
			states.add(state);
		}
	}

	@Override
	public void removeAll(){
		nodes.clear();
		states.clear();
	}

	public List<Instruction> getNodes() {
		return nodes;
	}
	
	public List<IState> getStates() {
		return states;
	}
}
