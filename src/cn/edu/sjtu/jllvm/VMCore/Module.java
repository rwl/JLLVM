package cn.edu.sjtu.jllvm.VMCore;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Constants.FunctionDeclare;
import cn.edu.sjtu.jllvm.VMCore.Constants.GlobalAlias;
import cn.edu.sjtu.jllvm.VMCore.Constants.GlobalVariable;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * @author liuhao 2011-12-21
 *	The Module class represents the top level structure present in LLVM programs. 
 *	An LLVM module is effectively either a translation unit of the original program or a combination of several translation units merged by the linker. 
 *	The Module class keeps track of a list of Functions, a list of GlobalVariables, a FunctionTable...
 */
public class Module{
	private Hashtable<String, GlobalVariable> globalVarTable;
	private Hashtable<String, GlobalAlias> globalAliasTable;
	private Hashtable<String, Constant> globalTable;

	private Hashtable<String, Type> namedTypeTable;

	private List<Function> functions;
	private Hashtable<String, Function> functionTable;
	
	private List<FunctionDeclare> functionDeclares;
	
	List<GlobalVariable> globalVariables;
	List<GlobalAlias> globalAlias;
	
	private Cell[] globals;
	
	boolean COMPLEX = true;
	
	public Module(List<GlobalVariable> globalVariables, List<GlobalAlias> globalAlias, List<FunctionDeclare> functionDeclares, 
			List<Function> functions, Hashtable<String, Type> namedTypeTable){
		this.globalVariables = globalVariables;
		globalVarTable = new Hashtable<String, GlobalVariable>();
		globalTable = new Hashtable<String, Constant>();
		
		for(GlobalVariable gv: globalVariables){
			globalVarTable.put(gv.getName(), gv);
			globalTable.put(gv.getName(), gv);
		}
		
		this.globalAlias = globalAlias;
		globalAliasTable = new Hashtable<String, GlobalAlias>();
		for(GlobalAlias ga: globalAlias){
			globalAliasTable.put(ga.getName(), ga);
			globalTable.put(ga.getName(), ga);
		}
		
		this.functionDeclares = functionDeclares;
		
		this.functions = functions;
		functionTable = new Hashtable<String, Function>();
		for(Function f:functions){
			functionTable.put(f.getFunctionName(), f);
			f.setParent(this);
		}
		
		this.namedTypeTable = namedTypeTable;
		
		if(COMPLEX){
			syntaxAnalysis();
		}
	}
	
	/**
	 * 
	 */
	public void syntaxAnalysis(){
		Hashtable<String, Integer> numeralGlobalVars = new Hashtable<String, Integer> ();
		
		Integer index = 1;	//index = 0 means variable not exists, so we start from 1
		
		List<String> globalVarNameList = new ArrayList<String>(globalVarTable.keySet());
		//globalNameList.addAll(globalAliasTable.keySet());
		
		for(String varName: globalVarNameList){
			numeralGlobalVars.put(varName, index++);
		}
		
		List<String> globalVarNameList2 = new ArrayList<String>(globalAliasTable.keySet());
		for(String varName: globalVarNameList2){
			numeralGlobalVars.put(varName, index++);
		}
		
		globals = new Cell[index];	//need to initialize
		
		for(Function f: functions){
			f.syntaxAnalysis(numeralGlobalVars);
		}
		
	}
	
	public Function getFunction(String name){
		return functionTable.get(name);
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public Hashtable<String, Type> getNamedTypeTable() {
		return namedTypeTable;
	}

	public Hashtable<String, GlobalAlias> getGlobalAliasTable() {
		return globalAliasTable;
	}

	public List<GlobalVariable> getGlobalVariablesList() {
		return globalVariables;
	}
	
	public Function getMain() {
		return functionTable.get("main");
	}
	
	public Hashtable<String, Constant> getGlobalTable() {
		return globalTable;
	}

	@Override
	public String toString(){
		String value = "";
		for(Function f: functions){
			value+=f.toString()+"\n";
		}
		
		return value;
	}
}
