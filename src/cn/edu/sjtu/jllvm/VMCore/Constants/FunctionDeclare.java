package cn.edu.sjtu.jllvm.VMCore.Constants;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Argument;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

public class FunctionDeclare extends GlobalValue{
	private String linkage;
	private String visibility;
	private String cconv;
	private List<String> parameterAttributes;
	private Type returnType;
	private String name;
	private List<Argument> arguments;
	boolean isVararg;
	private List<String> functionAttributes;
	
	public FunctionDeclare(String linkage, String visibility, String cconv,
			List<String> pAttributes, 
			boolean isVararg,
			Type type, String name,
			List<Argument> arguments,
			List<String> fAttributes
			){
		this.linkage = linkage;
		this.visibility = visibility;
		this.cconv = cconv;
		this.parameterAttributes = pAttributes;
		this.isVararg = isVararg;
		this.returnType = type;
		this.name = name;
		this.arguments = arguments;
		this.functionAttributes = fAttributes;
		
		List<Type> tyList = new ArrayList<Type>();
		tyList.add(returnType);
		for(Argument arg: arguments){
			tyList.add(arg.getType());
		}
		setType(TypeFactory.getFunctionType(tyList, isVararg));
	}
	
	public String getLinkage() {
		return linkage;
	}

	public String getVisibility() {
		return visibility;
	}

	public String getCconv() {
		return cconv;
	}

	public List<String> getParameterAttributes() {
		return parameterAttributes;
	}

	public Type getReturnType() {
		return returnType;
	}

	public String getName() {
		return name;
	}

	public List<Argument> getArguments() {
		return arguments;
	}

	public boolean isVararg() {
		return isVararg;
	}

	public List<String> getFunctionAttributes() {
		return functionAttributes;
	}

	public int getNumArgument() {
		return arguments.size();
	}
	public Type getArgumentType(int num) {
		if(num <= getNumArgument())
			return arguments.get(num).getType();
		else
			return null;
	}
	
	
	@Override
	public String toString(){
		String value = "";
		if(linkage != null){
			value += linkage;
		}
		if(visibility != null){
			value += " " + visibility;
		}
		if(cconv != null){
			value += " " + cconv;
		}
		for(String pa:parameterAttributes){
			value += " " + pa;
		}
		value += " " + type.toString() + name;
		value += "(";
		boolean first = true;
		for(Argument ar: arguments){
			if(first){
				value += ar.toString();
				first = false;
			}else{
				value += ", "+ar.toString();
			}	
		}
		value += ")";
		for(String fa: functionAttributes){
			value += " "+fa;
		}
		
		return value;
	}
}
