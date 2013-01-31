package cn.edu.sjtu.jllvm.VMCore;

import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;


/**
 * @author Administrator
 *
 * A memory cell to Store local and global variables' info in Function and Module
 */
public class Cell {
	private String value;

	private Instruction srcInst;
	
	public Cell(){
		
	}
	
	public Cell(String va){
		value = va;
	}
	
	public Instruction getSrcInst() {
		return srcInst;
	}

	public void setSrcInst(Instruction srcInst) {
		this.srcInst = srcInst;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		if(srcInst!=null){
			return srcInst.toString();
		}else{
			return "unKnown_inst";
		}
	}
}
