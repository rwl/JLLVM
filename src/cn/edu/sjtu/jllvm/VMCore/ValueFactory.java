package cn.edu.sjtu.jllvm.VMCore;

import java.util.Hashtable;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.BinaryConstantExpr;
import cn.edu.sjtu.jllvm.VMCore.Constants.CompareConstantExpr;
import cn.edu.sjtu.jllvm.VMCore.Constants.ComplexConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.ConvertConstantExpr;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Constants.FunctionDeclare;
import cn.edu.sjtu.jllvm.VMCore.Constants.GetElementPtrConstantExpr;
import cn.edu.sjtu.jllvm.VMCore.Constants.GlobalAlias;
import cn.edu.sjtu.jllvm.VMCore.Constants.GlobalValue;
import cn.edu.sjtu.jllvm.VMCore.Constants.GlobalVariable;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Constants.UndefValue;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class ValueFactory {
	//program
	public Module createModule(List<GlobalVariable> globalVariables, List<GlobalAlias> globalAlias, 
			List<FunctionDeclare> functionDeclares, List<Function> functions, Hashtable<String, Type> namedTypeTable){
		return new Module(globalVariables, globalAlias, functionDeclares, functions, namedTypeTable);
	}
	
	//global value
	public GlobalVariable createGlobalVariable(String name, String linkage, boolean isThreadLocal, boolean isConstant, Type type, 
			Constant initializer, String section, int align){
		return new GlobalVariable(name, linkage, isThreadLocal, isConstant, type, 
				initializer, section, align);
	}
	
	public GlobalAlias createGlobalAlias(String name, String linkage, String visibility, Type type, String gVarName){
		return new GlobalAlias(name, linkage, visibility, type, gVarName);
	}
	
	//function
	public Function createFunction(String linkage, String visibility, String cconv,
			List<String> pAttributes, 
			Type type, String name,
			List<Argument> arguments,
			boolean isVararg,
			List<String> fAttributes,
			int align,
			List<BasicBlock> basicBlocks
			){
		return new Function(linkage, visibility, cconv, pAttributes, type, name, arguments, isVararg,fAttributes, align, basicBlocks);
	}
	
	public FunctionDeclare createFunctionDeclare(String linkage, String visibility, String cconv,
			List<String> pAttributes, 
			boolean isVararg,
			Type type, String name,
			List<Argument> arguments,
			List<String> fAttributes
			){
		return new FunctionDeclare(linkage, visibility, cconv, pAttributes, isVararg, type, name, arguments, fAttributes);
	}
	
	//basic block
	public BasicBlock createBasicBlock(String basicID, List<Instruction> instructions){
		return new BasicBlock(basicID, instructions);
	}
	
	//conatant
	public Constant createConstantValue(int id, String value){
		if(id<=SimpleConstantValue.voidConst)
			return new SimpleConstantValue(id, value);
		else 
			return new ComplexConstantValue(id, value);
	}
	
	//Expression
	public Constant createVariable(String variable){
		if(variable.startsWith("@")){
			return new GlobalValue(variable.substring(1));
		}else if(variable.startsWith("%")){
			return new LocalVariable(variable.substring(1));
		}else if(variable.startsWith("undef")){
			return new UndefValue(variable);
		}
		return null;
	}

	public Constant createGetEleExpression(boolean inbounds, Type type, Constant subExpr, List<Integer> indices){
		return new GetElementPtrConstantExpr(inbounds, type, subExpr, indices);
	}
	
	public Constant createConversionExpression(String op, Type type1, Constant subExpr, Type type2){
		return new ConvertConstantExpr(op, type1, subExpr, type2);
	}
	
	public Constant createBinaryExpression(String op, String nuw, String nsw, String exact, Type type1, Constant expr1, Type type2, Constant expr2){
		return new BinaryConstantExpr(op, nuw, nsw, exact, type1, expr1, type2, expr2);
	}
	
	public Constant createCmpExpression(boolean isICmp, String cond, Type type1, Constant expr1, Type type2, Constant expr2){
		return new CompareConstantExpr(isICmp, cond, type1, expr1, type2, expr2);
	}
	
	
	//Argument
	public Argument createArgument(Type type, List<String> pAttributes, int align, Constant expr){
		return new Argument(type, pAttributes, align, expr);
	}
}
