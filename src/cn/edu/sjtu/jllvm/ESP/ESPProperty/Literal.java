package cn.edu.sjtu.jllvm.ESP.ESPProperty;

/**
 * @author liuhao 2011-12-30
 * an atomic constraint
 */
public class Literal {
	public final static int
		IS = 0,
		NOT = 1;
	
	String id;
	int op;
	
	public Literal(String value, int op){
		this.id = value;
		this.op = op;
	}
	
	public boolean isIdEquals(Literal lit){
		return id.equals(lit.getId());
	}
	
	public boolean equals(Literal lit){
		return id.equals(lit.getId()) && op == lit.getOp();
	}

	public boolean inField(Literal lit){
		return op == lit.getOp();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOp() {
		return op;
	}
	
	public Literal copy(){
		return new Literal(id, op);
	}
	
	@Override
	public String toString(){
		return ((op==Literal.NOT)?"!":"") + id;
	}
}
