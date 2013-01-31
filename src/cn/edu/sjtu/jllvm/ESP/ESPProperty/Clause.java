package cn.edu.sjtu.jllvm.ESP.ESPProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhao 2011-12-30
 * Core of execution state. Handle union and addconstraint.
 * A clause is made up of several literals. Literals are intersected.
 */
public class Clause {
	//if this clause is bottom, the list is null.
	//if this clause is top, the list size is 0.
	private List<Literal> literals;
	
	/**
	 * Union another clause
	 * @param in_clause
	 */
	public void union(Clause in_clause){
		if(in_clause.isBottom())
			return;
		
		if(isBottom()){
			literals = in_clause.copyLiterals();
			return;
		}
		
		if(in_clause.isTop() || this.isTop()){
			this.setTop();
			return;
		}
		
		for(int i = 0; i < literals.size(); i++){
			boolean contains = false;
			Literal lit = literals.get(i);
			
			for(Literal in_lit: in_clause.getLiterals()){
				if(lit.isIdEquals(in_lit)){
					contains = true;
				}
			}
			
			if(!contains){
				literals.remove(i);
				i--;
			}
		}
		
		for(Literal in_lit: in_clause.getLiterals()){
			union(in_lit);
		}
	}
	
	/**
	 * Union a literal
	 * @param in
	 */
	public void union(Literal in){
		if(isBottom()){
			literals = new ArrayList<Literal>();
			literals.add(in);
			
			return ;
		}
		
		for(Literal lit: literals){
			if(in.isIdEquals(lit)){
				if(!in.inField(lit)){	//not the same contraint
					literals.remove(lit);	//!a UNION a = TRUE
					return;
				}
				
				return;	//the same
			}
		}
		
		literals.add(in);
	}

	/**
	 * Add constraint. If this clause is bottom, do nothing.
	 * If the added constraint is violate current clause, this clause is set to be bottom.
	 * @param in
	 */
	public void addConstraint(Literal in){
		if(isBottom()){
			return;
		}
		
		for(Literal lit: literals){
			if(in.isIdEquals(lit)){
				if(!in.inField(lit)){
					setBottom();	//the clause is unsatisfied, set bottom
					return;
				}
				
				return;		//else, if contains this constraint, return.
			}
		}
		
		literals.add(in);
	}

	/**
	 * @param in
	 * @return: True, if this clause is less equal than the input clause.
	 */
	public boolean belongTo(Clause in) {
		if(in.isBottom() || isBottom()){
			if(isBottom())
				return true;
			return false;
		}
		
		List<Literal> in_literals = in.getLiterals();
		
		for(Literal in_lit: in_literals){
			boolean contains = false;
			for(Literal lit: literals){
				if(in_lit.isIdEquals(lit)){
					if(in_lit.equals(lit)){
						contains = true;
						break;
					}else{
						return false;
					}
				}
			}
			if(!contains)
				return false;
		}
		
		return true;
	}

	public List<Literal> getLiterals() {
		return literals;
	}
	
	public void setLiterals(List<Literal> literals) {
		this.literals = literals;
	}

	public List<Literal> copyLiterals(){
		if(isBottom())
			return null;
		
		List<Literal> re_literals = new ArrayList<Literal>();
		for(Literal lit: literals){
			re_literals.add(lit.copy());
		}
		
		return re_literals;
	}
	
	public Clause copy(){
		Clause re = new Clause();
		re.setLiterals(copyLiterals());
		
		return re;
	}

	public void setTop(){
		if(literals == null){
			literals = new ArrayList<Literal>();
		}else{
			literals.clear();
		}
	}
	
	public void setBottom(){
		literals = null;
	}
	
	public boolean isTop(){
		if(literals==null)
			return false;
		return literals.size()==0;
	}
	
	public boolean isBottom(){
		return literals==null;
	}
	
	@Override
	public String toString() {
		if(isTop())
			return "T";
		if(isBottom())
			return "NULL";
		
		String buffer = "";
		for(Literal lit: literals){
			buffer+=lit.toString()+" & ";
		}
		int endIndex = buffer.length()-3;
		
		buffer = buffer.substring(0, endIndex);
		
		return buffer;
	}
}
