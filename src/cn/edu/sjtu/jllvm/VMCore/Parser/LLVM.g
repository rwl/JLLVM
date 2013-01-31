grammar LLVM;

@header {
package cn.edu.sjtu.jllvm.VMCore.Parser;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.*;
import cn.edu.sjtu.jllvm.VMCore.Types.*;
import cn.edu.sjtu.jllvm.VMCore.Instructions.*;
import cn.edu.sjtu.jllvm.VMCore.Constants.*;
import cn.edu.sjtu.jllvm.VMCore.Operators.*;
}
 
@lexer::header {
package cn.edu.sjtu.jllvm.VMCore.Parser;
}

@members {
TypeFactory typeFactory = new TypeFactory();
ValueFactory valueFactory = new ValueFactory();
InstFactory instFactory = new InstFactory();
}
   
program returns [Module program]
@init{
List<GlobalVariable> globalVariables = new ArrayList<GlobalVariable>();
List<GlobalAlias> globalAlias = new ArrayList<GlobalAlias>();
List<FunctionDeclare> functionDeclares = new ArrayList<FunctionDeclare>();
List<Function> functions = new ArrayList<Function>();
}
@after{ 
program = valueFactory.createModule(globalVariables, globalAlias, functionDeclares, functions, typeFactory.getNamedTypeTable());
}
        : target*
          named_type* 
          (global_variable {globalVariables.add($global_variable.globalVariable);})* 
          (aliases_variable {globalAlias.add($aliases_variable.globalAlias);})*
          (function_declaration {functionDeclares.add($function_declaration.functionDeclare);}
            | 
           function_definition {functions.add($function_definition.function);})+
          EOF
          ;

target : 'target' ('datalayout' | 'triple') '=' STRING;

named_type 
    : LOCAL_VARIABLE '=' 'type' 
      (derived_type {String idTypeName = $LOCAL_VARIABLE.text; Type type = $derived_type.type; typeFactory.addIDType(idTypeName, type); } ) 
    ;

global_variable returns [GlobalVariable globalVariable]
@init{
String name;
String linkage = null;
boolean isThreadLocal = false;
boolean isConstant = false;
Type type = null; 
Constant initializer = null;
String section = null;
int align = -1;
}
@after{
globalVariable = valueFactory.createGlobalVariable(name, linkage, isThreadLocal, isConstant, type, 
                                  initializer, section, align);
}
    : 
    GLOBAL_VARIABLE {name = $GLOBAL_VARIABLE.text; name = name.substring(1, name.length());} 
    '=' (LINKAGE {linkage = $LINKAGE.text;})? 
    ('thread_local' {isThreadLocal= true;})? 
    ('global' | 'constant' {isConstant = true;}) 
    derived_type {type = $derived_type.type;}
    (initializer {initializer = $initializer.constant;} 
      (',' section {section = $section.section;}
      )? 
      (',' align {align = $align.align;})?
    )? ;

aliases_variable returns [GlobalAlias globalAlias]
@init{
String name;
String linkage = null;
String visibility = null;
Type type;
String gVarName;
}
@after{
globalAlias = valueFactory.createGlobalAlias(name, linkage, visibility, type, gVarName);
}
    : 
    g1 = GLOBAL_VARIABLE {name = $g1.text; name = name.substring(1, name.length());}  
    '=' 'alias' (LINKAGE {linkage = $LINKAGE.text;})?  
    (VISIBILITY {visibility = $VISIBILITY.text;})? 
    derived_type {type = $derived_type.type;} 
    g2 = GLOBAL_VARIABLE {gVarName = $g2.text; gVarName = gVarName.substring(1, gVarName.length());}; 

function_declaration returns [FunctionDeclare functionDeclare]
@init{
String linkage = null;
String visibility = null;
String cconv = null;
List<String> pAttributes = new ArrayList<String>();
boolean isVararg = false;
Type type;
String name;
List<Argument> argList = new ArrayList<Argument>();
List<String> fAttributes = new ArrayList<String>();
}
@after{
functionDeclare = valueFactory.createFunctionDeclare(linkage, visibility, cconv, pAttributes, isVararg, type, name, argList, fAttributes);
}    
    : 
      'declare' (LINKAGE {linkage = $LINKAGE.text;})? 
      (VISIBILITY {visibility = $VISIBILITY.text;})? 
      (CCONV {cconv = $CCONV.text;})? 
      (PARAMETER_ATTRIBUTES {pAttributes.add($PARAMETER_ATTRIBUTES.text);})*
      return_type {type = $return_type.type;} 
      GLOBAL_VARIABLE {name = $GLOBAL_VARIABLE.text; name = name.substring(1, name.length());}
      '(' argument_list[argList] {isVararg = $argument_list.isVarargFunction;}')' 
      (FUNCTION_ATTRIBUTES {fAttributes.add($FUNCTION_ATTRIBUTES.text);})*
    ;

function_definition returns [Function function]
@init{
String linkage = null;
String visibility = null;
String cconv = null;
List<String> pAttributes=new ArrayList<String>();
Type type;
String name;
List<Argument> argList=new ArrayList<Argument>();
boolean isVararg = false;
List<String> fAttributes=new ArrayList<String>();
int align = -1;
List<BasicBlock> basicBlocks = new ArrayList<BasicBlock>();
}
@after{
function = valueFactory.createFunction(linkage, visibility, cconv, pAttributes, type, name, argList, isVararg, fAttributes, align, basicBlocks);  
}
    :
      'define' 
      (LINKAGE {linkage = $LINKAGE.text;})? 
      (VISIBILITY {visibility = $VISIBILITY.text;})? 
      (CCONV {cconv = $CCONV.text;})? 
      (PARAMETER_ATTRIBUTES {pAttributes.add($PARAMETER_ATTRIBUTES.text);})*
      return_type {type = $return_type.type;}
      GLOBAL_VARIABLE {name = $GLOBAL_VARIABLE.text; name = name.substring(1, name.length());}
      '(' argument_list[argList] {isVararg = $argument_list.isVarargFunction;}')' 
      (FUNCTION_ATTRIBUTES {fAttributes.add($FUNCTION_ATTRIBUTES.text);})* 
      (align {align = $align.align;})?
      '{' 
      ( basic_block {basicBlocks.add($basic_block.basicBlock);
      })+ 
      '}'
    ;

basic_block returns [BasicBlock basicBlock]
@init{
String blockID = null;
List<Instruction> instructions = new ArrayList<Instruction>();
}
@after{
basicBlock = valueFactory.createBasicBlock(blockID, instructions);
}
    : (BLOCK_ID {String bid = $BLOCK_ID.text; bid = bid.trim(); bid = bid.substring(0, bid.length()-1); blockID = bid.trim();})? 
      (phi_op {Instruction inst1=$phi_op.inst; inst1.setValue($phi_op.text); instructions.add(inst1);})* 
      (operator {Instruction inst2=$operator.inst; inst2.setValue($operator.text); instructions.add(inst2);})* 
      terminator {Instruction inst3=$terminator.inst; inst3.setValue($terminator.text); instructions.add(inst3);}
    ;



/////////////////////////////////////////////////////////////
//  INSTRUCTIONS
/////////////////////////////////////////////////////////////
align returns [int align]
    : ALIGN INTEGER {align = Integer.parseInt($INTEGER.text);};

section returns [String section]
    : SECTION STRING {section = $STRING.text;};

// Terminator Instructions
terminator returns [Instruction inst]
@init{
Constant dest = null;
int opcode=0;
List<Constant> operands = new ArrayList<Constant>();
List<Type> types = new ArrayList<Type>();

String cconv = null;
List<String> pAttributes = new ArrayList<String>();
List<String> fAttributes = new ArrayList<String>();
}
@after{
if(opcode == InstType.invokeInst){
  $inst = instFactory.createCallInst(dest, opcode, operands, types, false, cconv, pAttributes, fAttributes);
}else{
  $inst = instFactory.createSimpleInst(dest, opcode, operands, types);
}
}
    : 
    ('ret' {opcode = InstType.retInst;} (VOID {operands.add(valueFactory.createConstantValue(SimpleConstantValue.voidConst, $VOID.text));} 
      | return_type e1=expression {types.add($return_type.type); operands.add($e1.expr);}) 
      | UNWIND {opcode = InstType.unwindInst;})
    | (t='br' {opcode = InstType.brInst;}
             (b0=block_label  {operands.add($b0.expr);}
             | BOOLEAN_TYPE e2=expression ',' b1=block_label ',' b2=block_label  
             {types.add(typeFactory.getIntNType(1)); operands.add($e2.expr);
             operands.add($b1.expr); operands.add($b2.expr);})
    | t='switch' it1=INTEGER_TYPE e3=expression ',' b3=block_label 
      {opcode = InstType.switchInst; 
       String n = $it1.text; n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); 
       operands.add($e3.expr); operands.add($b3.expr);}
            '[' (it2=INTEGER_TYPE INTEGER ',' b4=block_label  
            {n = $it2.text; n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
             operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, $INTEGER.text));
             operands.add($b4.expr);})* ']'
      
    | t='indirectbr' pointer_type e4=expression ',' '[' b5=block_label 
      {opcode = InstType.indirectBrInst; types.add($pointer_type.type); operands.add($e4.expr); operands.add($b5.expr);}
             (',' b6=block_label {operands.add($b6.expr);})* ']'
    | (variable '=' {dest = $variable.expr;})? 
      t='invoke' function_call[cconv, pAttributes, types, operands, fAttributes]
            TO b7=block_label UNWIND b8=block_label
      {opcode = InstType.invokeInst; operands.add($b7.expr); operands.add($b8.expr);}
    | t='unreachable' {opcode = InstType.unreachableInst;})
    ;    

block_label returns [Constant expr]: LABEL LOCAL_VARIABLE {expr = valueFactory.createVariable($LOCAL_VARIABLE.text);};

/////////////////////////////////////////////////////////////
// Operators
operator returns [Instruction inst]
@after{
$inst = $t.inst;
}
    : t=binary_op 
    | t=vector_op
    | t=aggregate_op
    | t=memory_op
    | t=conversion_op
    | t=icmp_op 
    | t=fcmp_op 
    | t=select_op 
    | t=call_op
    ;

// Binary Operations
binary_op returns [Instruction inst]
@init{
Constant dest;
int opcode=InstType.binaryInst;
String op;
String nuw = null;
String nsw = null;
String exact = null;
List<Constant> operands= new ArrayList<Constant>();
List<Type> types = new ArrayList<Type>();
}
@after{
inst = instFactory.createBinaryInst(dest, opcode, operands, types, op, nuw, nsw, exact);
}
    : 
      variable {dest = $variable.expr;}
      '=' BINARY_OP {op = $BINARY_OP.text;}
      ('nuw' {nuw = "nuw";})? ('nsw' {nsw = "nsw";})? ('exact' {exact = "exact";})? 
      (element_type {types.add($element_type.type);}| vector_type {types.add($element_type.type);}) 
      e1 = expression {operands.add($e1.expr);}',' e2 = expression {operands.add($e2.expr);};

// Vector Operations
vector_op returns [Instruction inst]
@init{
int opcode=0;
Constant dest;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createSimpleInst(dest, opcode, operands, types);
}
    : v0 = variable {dest = $v0.expr;}'=' 
     ('extractelement' vt1=vector_type v1=variable ',' it1=INTEGER_TYPE e1=expression 
        {opcode = InstType.extractEleInst; 
        types.add($vt1.type); operands.add($v1.expr); 
        String n = $it1.text; n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); operands.add($e1.expr);}
    | 'insertelement' vt2=vector_type v2=variable ',' et1=element_type e2=expression ',' it2=INTEGER_TYPE e3=expression
        {opcode = InstType.insertEleInst; 
        types.add($vt2.type); operands.add($v2.expr); 
        types.add($et1.type); operands.add($e2.expr);
        String n = $it2.text; n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); operands.add($e3.expr);}
    | 'shufflevector' vt3=vector_type v3=variable ',' vt4=vector_type v4=variable ',' vt5=vector_type 
        {opcode = InstType.shuffleVecInst;
        types.add($vt3.type); operands.add($v3.expr);
        types.add($vt4.type); operands.add($v4.expr);
        types.add($vt5.type);}
       '<' it3=INTEGER_TYPE i1=INTEGER 
        {String n = $it3.text; n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
        operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, $i1.text));}
       (',' it4=INTEGER_TYPE i2=INTEGER
        {String n2 = $it4.text; n2=n2.substring(1,n2.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n2)));
        operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, $i2.text));}
       )* '>' 
    );

// Aggregate Operation
aggregate_op returns [Instruction inst]
@init{
int opcode=0;
Constant dest;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createSimpleInst(dest, opcode, operands, types);
}
    : v0=variable {dest = $v0.expr;}'=' 
     ('extractvalue' at1=aggregate_type v1=variable ',' i1=index 
     {opcode = InstType.extractValInst; types.add($at1.type); operands.add($v1.expr); operands.add($i1.expr);}
     (',' i2=index {operands.add($i2.expr);})*
    | 'insertvalue' at2=aggregate_type v2=variable ',' dt1=derived_type e1=expression ',' i3=index
     {opcode = InstType.insertValInst; types.add($at2.type); operands.add($v2.expr); types.add($dt1.type); operands.add($e1.expr); operands.add($i3.expr);}
    ); 

// Memory operation
memory_op returns [Instruction inst]
    : getelementptr_op {inst = $getelementptr_op.inst;}
    | alloca_op {inst = $alloca_op.inst;}
    | load_op {inst = $load_op.inst;}
    | store_op {inst = $store_op.inst;};

alloca_op returns [Instruction inst]
@init{
Constant dest;
int opcode=0;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createSimpleInst(dest, opcode, operands, types);
}
    :  variable '=' 'alloca' t1=derived_type 
      {dest = $variable.expr; opcode = InstType.allocaInst; types.add($t1.type);}
    (',' t2=derived_type index {types.add($t2.type); operands.add($index.expr);})? 
    (',' align {operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, $align.align + ""));})?
    ;

load_op returns [Instruction inst]
@init{
Constant dest;
int opcode;
boolean isVolatile = false;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createLoadStoreInst(dest, opcode, operands, types, isVolatile);
}
    : variable '=' {dest = $variable.expr; opcode = InstType.loadInst;}
      (VOLATILE {isVolatile = true;})? 'load' 
      pointer_type expression 
      {types.add($pointer_type.type); operands.add($expression.expr);}
      (',' align {operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, $align.align + ""));})? 
    ;

store_op returns [Instruction inst]
@init{
Constant dest = null;
int opcode;
boolean isVolatile = false;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createLoadStoreInst(dest, opcode, operands, types, isVolatile);
}
    : (VOLATILE {isVolatile=true;})? 'store' 
    {opcode = InstType.storeInst;}
    t1=first_class_type e1=expression {types.add($t1.type); operands.add($e1.expr);}',' 
    t2=pointer_type e2=expression {types.add($t2.type); operands.add($e2.expr);}
    (',' align {operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, $align.align + ""));})?
    ;

getelementptr_op returns [Instruction inst]
@init{
Constant dest;
int opcode = InstType.getElePtrInst;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
boolean inbounds = false;
}
@after{
inst = instFactory.createGetElePtrInst(dest, opcode, operands, types, inbounds);
}
    : variable '=' 'getelementptr' {dest = $variable.expr;}
    ('inbounds' {inbounds = true;})? 
    pointer_type expression {types.add($pointer_type.type); operands.add($expression.expr);}
    (',' INTEGER_TYPE index 
    {String n = $INTEGER_TYPE.text; n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
    operands.add($index.expr);}
    )+        
    ;

// Conversion operation
conversion_op returns [Instruction inst]
@init{
Constant dest;
String converOp;
int opcode = InstType.converInst;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createOperationInst(dest, opcode, operands, types, converOp);
}
    : variable '=' CONVERSION_OP t1=scalar_type expression TO t2=scalar_type
      {dest = $variable.expr; converOp=$CONVERSION_OP.text; types.add($t1.type); types.add($t2.type); operands.add($expression.expr);}
    ;

// Other operations
// TODO va_arg
icmp_op returns [Instruction inst]
@init{
Constant dest;
int opcode = InstType.icmpInst;
String cond=null;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createCmpInst(dest, opcode, operands, types, cond);
}
    : variable '=' 'icmp' 
      {dest = $variable.expr;}
      (ICMP_COND {cond = $ICMP_COND.text;}| CMP_COND {cond = $CMP_COND.text;}) 
      (scalar_type {types.add($scalar_type.type);}| vector_type {types.add($vector_type.type);}) 
      e1 = expression ',' e2 = expression {operands.add($e1.expr); operands.add($e2.expr);};

fcmp_op returns [Instruction inst]
@init{
Constant dest;
int opcode = InstType.fcmpInst;
String cond=null;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createCmpInst(dest, opcode, operands, types, cond);
}
    : variable '=' 'fcmp' 
      {dest = $variable.expr;}
      (FCMP_COND {cond = $FCMP_COND.text;}| CMP_COND {cond = $CMP_COND.text;}| BOOLEAN {cond = $BOOLEAN.text;}) 
      (scalar_type {types.add($scalar_type.type);}| vector_type {types.add($vector_type.type);}) 
      e1 = expression ',' e2 = expression {operands.add($e1.expr); operands.add($e2.expr);};

phi_op returns [Instruction inst]
@init{
Constant dest;
int opcode = InstType.phiInst;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
$inst = instFactory.createSimpleInst(dest, opcode, operands, types);
}
    : variable {dest = $variable.expr;}
      '=' 'phi' 
      first_class_type {types.add($first_class_type.type);}
      '[' e1 = expression {operands.add($e1.expr);}
      ',' lv1 = LOCAL_VARIABLE {operands.add(valueFactory.createVariable($lv1.text));}']' 
      (',' '[' e2=expression ',' lv2=LOCAL_VARIABLE {operands.add($e2.expr); operands.add(valueFactory.createVariable($lv2.text));}']')*;

select_op returns [Instruction inst] 
@init{
Constant dest;
int opcode = InstType.selectInst;
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
}
@after{
inst = instFactory.createSimpleInst(dest, opcode, operands, types);
}
    : variable '=' 'select' BOOLEAN_TYPE e1=expression ',' fc1=first_class_type e2=expression ',' fc2=first_class_type e3=expression
    {dest = $variable.expr; 
    types.add(typeFactory.getIntNType(1));
    operands.add($e1.expr);
    types.add($fc1.type); operands.add($e2.expr);
    types.add($fc2.type); operands.add($e3.expr);};

call_op returns [Instruction inst]
@init{
Constant dest = null;
boolean tail = false;
int opcode = InstType.callInst;
String cconv = null;
List<String> pAttributes = new ArrayList<String>();
List<Type> types = new ArrayList<Type>();
List<Constant> operands = new ArrayList<Constant>();
List<String> fAttributes = new ArrayList<String>();
}
@after{
inst = instFactory.createCallInst(dest, opcode, operands, types, false, cconv, pAttributes, fAttributes);
}
    : (variable '=' {dest = $variable.expr;})? ('tail' {tail = true;})? 'call' 
    function_call[cconv, pAttributes, types, operands, fAttributes];

function_call [String cconv, List<String> pAttributes, List<Type> types, List<Constant> operands, List<String> fAttributes] returns [boolean isVarargFunction]
@init{
List<Argument> arguments = new ArrayList<Argument>();
boolean isVararg = false;
}
@after{
for(Argument arg:arguments){
  types.add(arg.getType());
  operands.add(arg.getExpr());
}

isVarargFunction = isVararg;
}
    : (CCONV {cconv = $CCONV.text;})? 
      (PARAMETER_ATTRIBUTES {pAttributes.add($PARAMETER_ATTRIBUTES.text);})*
      return_type function_name {types.add($return_type.type); operands.add($function_name.expr);}
      '(' argument_list [arguments] ')' {isVarargFunction = $argument_list.isVarargFunction;}
      (FUNCTION_ATTRIBUTES {fAttributes.add($FUNCTION_ATTRIBUTES.text);})*
    ;

argument_list [List<Argument> alist] returns[boolean isVarargFunction]
@init{
Type type;
List<String> pAttributes = new ArrayList<String>(); 
int align = -1;
Constant expr = null;
boolean isVararg = false;
}
@after{
isVarargFunction = isVararg;
}
    : '...' {isVararg = true;}
    | (fct1 = first_class_type {type = $fct1.type;} 
       (pa1 = PARAMETER_ATTRIBUTES {pAttributes.add($pa1.text);})* 
       (a1 = align {align = $a1.align;})? 
       (e1=expression {expr = $e1.expr;})?  
          {alist.add(valueFactory.createArgument(type, pAttributes, align, expr));
           pAttributes = new ArrayList<String>();
           align = -1;
           expr = null;
           }
      (',' 
        fct2 = first_class_type {type = $fct2.type;} 
        (pa2 = PARAMETER_ATTRIBUTES {pAttributes.add($pa2.text);})*  
        (a2 = align {align = $a2.align;})?  
        (e2=expression {expr = $e2.expr;})?
          {alist.add(valueFactory.createArgument(type, pAttributes, align, expr));
           pAttributes = new ArrayList<String>();
           align = -1;
           expr = null;
          }
      )* (',' '...' {isVararg = true;})?
     )?
    ;

/////////////////////////////////////////////////////////////
//  EXPR
/////////////////////////////////////////////////////////////
variable returns [Constant expr]
    : GLOBAL_VARIABLE {expr = valueFactory.createVariable($GLOBAL_VARIABLE.text);}
    | LOCAL_VARIABLE {expr = valueFactory.createVariable($LOCAL_VARIABLE.text);}
    | UNDEF {expr = valueFactory.createVariable($UNDEF.text);};

expression returns [Constant expr]
    : simple_constant {expr = $simple_constant.constant;}
    | getelementptr_expr {expr = $getelementptr_expr.expr;}
    | conversion_expr {expr = $conversion_expr.expr;}
    | binary_expr {expr = $binary_expr.expr;}
    | cmp_expr {expr = $cmp_expr.expr;}
    | variable {expr = $variable.expr;}
    ;

getelementptr_expr returns [Constant expr]
@init{
boolean inbounds = false;
Type type;
Constant subExpr;
List<Integer> indices = new ArrayList<Integer>();
}
@after{
expr = valueFactory.createGetEleExpression(inbounds, type, subExpr, indices);
}
    : 'getelementptr' ('inbounds' {inbounds = true;})? 
      '(' pointer_type {type = $pointer_type.type;} 
      expression {subExpr = $expression.expr;} 
      (',' INTEGER_TYPE INTEGER {indices.add(Integer.parseInt($INTEGER.text));} )+ 
      ')'
    ;

conversion_expr returns [Constant expr]
    : CONVERSION_OP '(' st1=scalar_type expression TO st2=scalar_type ')'
      {String op = $CONVERSION_OP.text;
       Type type1 = $st1.type;
       Constant subExpr = $expression.expr;
       Type type2 = $st2.type;
       expr = valueFactory.createConversionExpression(op, type1, subExpr, type2);
      }
    ;

binary_expr returns [Constant expr]
@init{
String op;
String nuw = null;
String nsw = null;
String exact = null;
Type type1 = null;
Constant expr1;
Type type2 = null;
Constant expr2;
}
@after{
expr = valueFactory.createBinaryExpression(op, nuw, nsw, exact, type1, expr1, type2, expr2);
}
    : BINARY_OP {op = $BINARY_OP.text;}
      ('nuw' {nuw = "nuw";})? 
      ('nsw' {nsw = "nsw";})? 
      ('exact' {exact = "exact";})? 
      '(' 
      ((et1 = element_type {type1 = $et1.type;} )|(vt1 = vector_type ) {type1 = $vt1.type;}) 
      ex1 = expression {expr1 = $ex1.expr;}',' 
      ((et2 = element_type {type2 = $et2.type;} )|(vt2 = vector_type ) {type2 = $vt2.type;}) 
      ex2 = expression {expr2 = $ex2.expr;} 
      ')';

cmp_expr returns [Constant expr]
@init{
boolean isICmp=true;
String cond=null;
Type type1=null, type2=null;
Constant expr1=null, expr2=null;
}
@after{
expr = valueFactory.createCmpExpression(isICmp, cond, type1, expr1, type2, expr2);
}
    : ('icmp' 
      (ICMP_COND {cond = $ICMP_COND.text;}| cc1 = CMP_COND {cond = $cc1.text;}) 
        | 'fcmp' {isICmp = false;}(FCMP_COND {cond = $FCMP_COND.text;}| cc2 = CMP_COND {cond = $cc2.text;}| BOOLEAN {cond = $BOOLEAN.text;})
      )
      '(' (sct1 = scalar_type {type1 = $sct1.type;} | vt1 = vector_type {type1 = $vt1.type;}) 
      e1 = expression {expr1 = $e1.expr;} 
        ',' 
       ( sct2 = scalar_type {type2 = $sct2.type; } | vt2 = vector_type {type2 = $vt2.type;}) 
      e2 = expression {expr2 = $e2.expr;} 
      ')';
          
/////////////////////////////////////////////////////////////
//  TYPE
/////////////////////////////////////////////////////////////
id_type returns [Type type]
    : LOCAL_VARIABLE {type = typeFactory.getIDType($LOCAL_VARIABLE.text);};

element_type returns [Type type]
    : BOOLEAN_TYPE {type = typeFactory.getInt1Type();}
    | INTEGER_TYPE {String is = $INTEGER_TYPE.text; is = is.substring(1, is.length());int i =Integer.parseInt(is);
                        if(i == 8){
                          type = typeFactory.getInt8Type();
                        }else if(i == 16){
                          type = typeFactory.getInt16Type();
                        }else if(i == 32){
                          type = typeFactory.getInt32Type();
                        }else if(i == 64){
                          type = typeFactory.getInt64Type();
                        }else{
                          type = typeFactory.getIntNType(i);
                        }
                   }
    | FLOATING_POINT_TYPE {type = typeFactory.getFloatType();}
    | id_type {type = $id_type.type;}; 


scalar_type returns [Type type]
    : element_type {type = $element_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);} )* 
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | structure_type {type = $structure_type.type;}
      (
        ('*' {type = typeFactory.getPointerType(type);})+ 
        (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )* 
        | 
        (ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )+ 
      )
    | union_type {type = $union_type.type;}
      (
        ('*' {type = typeFactory.getPointerType(type);})+ 
        (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )* 
        | 
        (ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )+ 
      )
    | packed_structure_type {type = $packed_structure_type.type;}  
      ('*' {type = typeFactory.getPointerType(type);} )+ 
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | array_type {type = $array_type.type;}
      ('*' {type = typeFactory.getPointerType(type);} )+ 
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | vector_type {type = $vector_type.type;}
      ('*' {type = typeFactory.getPointerType(type);} )+ 
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | VOID {type = typeFactory.getVoidType();}
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )+
    ;
/*
scalar_type returns [Type type]
    : element_type '*'* (parameter_type_list '*'+)*
    | structure_type ('*'+ (parameter_type_list '*'+)* | (parameter_type_list '*'+)+) 
    | union_type ('*'+ (parameter_type_list '*'+)* | (parameter_type_list '*'+)+)
    | packed_structure_type '*'+ (parameter_type_list '*'+)*
    | array_type '*'+ (parameter_type_list '*'+)*
    | vector_type '*'+ (parameter_type_list '*'+)*
    | VOID (parameter_type_list '*'+)+
    ;    */

primitive_type returns [Type type]
    : VOID  {type = typeFactory.getVoidType();}
    | LABEL {type = typeFactory.getLabelType();}
    | METADATA  {type = typeFactory.getMetadataType();}
    | element_type  {type = $element_type.type;}
    ; 

first_class_type returns [Type type]
    : element_type {type = $element_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})* 
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | structure_type {type = $structure_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})*  
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | union_type {type = $union_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})*   
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | packed_structure_type {type = $packed_structure_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})+ 
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )*
    | array_type {type = $array_type.type;}
      (
        ('*' {type = typeFactory.getPointerType(type);})+  
        (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
        )*
      )?
    | vector_type {type = $vector_type.type;}
      (
        ('*' {type = typeFactory.getPointerType(type);})+  
        (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
        )*
      )?
    | VOID {type = typeFactory.getVoidType();}
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);} ('*' {type = typeFactory.getPointerType(type);})+
      )+
    | LABEL {type = typeFactory.getLabelType();}
    | METADATA  {type = typeFactory.getMetadataType();}
    ;

derived_type  returns [Type type]
    : element_type {type = $element_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})*  
      (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )* 
        ('*' {type = typeFactory.getPointerType(type);})*  
      )?
    | structure_type {type = $structure_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})* 
      (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
        ('*' {type = typeFactory.getPointerType(type);})*  
      )?
    | union_type {type = $union_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})* 
      (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
        ('*' {type = typeFactory.getPointerType(type);})*  
      )?
    | packed_structure_type {type = $packed_structure_type.type;} 
      (('*' {type = typeFactory.getPointerType(type);})+ 
      (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
        ('*' {type = typeFactory.getPointerType(type);})*  
      )?)?
    | array_type {type = $array_type.type;} 
      (('*' {type = typeFactory.getPointerType(type);})+ 
      (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
        ('*' {type = typeFactory.getPointerType(type);})*  
      )?)?
    | vector_type {type = $vector_type.type;}
      (('*' {type = typeFactory.getPointerType(type);})+ 
      (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
        ('*' {type = typeFactory.getPointerType(type);})*  
      )?)?
    | VOID {type = typeFactory.getVoidType();} 
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
      ('*' {type = typeFactory.getPointerType(type);})*  
    | LABEL {type = typeFactory.getLabelType();}
    | METADATA  {type = typeFactory.getMetadataType();}
    | OPAQUE  {type = typeFactory.getOpaqueType();}
    ;

aggregate_type returns [Type type]
    : array_type {type = $array_type.type;}
    | structure_type {type = $structure_type.type;}
    | union_type {type = $union_type.type;}
    | id_type {type = $id_type.type;}
    ;

pointer_type returns [Type type]
   : 
   (
      element_type {type = $element_type.type;}  
      ( ('*' {type = typeFactory.getPointerType(type);})*  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
      )?
    | structure_type {type = $structure_type.type;}  
      ( ('*' {type = typeFactory.getPointerType(type);})*  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
      )?
    | union_type {type = $union_type.type;} 
      ( ('*' {type = typeFactory.getPointerType(type);})*  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
      )?
    | packed_structure_type {type = $packed_structure_type.type;}  
      ( ('*' {type = typeFactory.getPointerType(type);})*  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
      )?
    | array_type {type = $array_type.type;}  
      ( ('*' {type = typeFactory.getPointerType(type);})*  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
      )?
    | vector_type {type = $vector_type.type;} 
      ( ('*' {type = typeFactory.getPointerType(type);})*  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
      )?    
    | VOID {type = typeFactory.getVoidType();}  
        ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        (('*' {type = typeFactory.getPointerType(type);})+  
        ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        )*
   ) ('*' {type = typeFactory.getPointerType(type);})+;

structure_type returns [Type type]
@init{
  List<Type> typeList = null;
}  
    : '{' (type_list {typeList = $type_list.typeList;}  )? '}' 
    {type = typeFactory.getStructType(typeList);};

packed_structure_type returns [Type type]
@init{
  List<Type> typeList = null;
}    
    : '<' '{' (type_list {typeList = $type_list.typeList;} )? '}' '>' 
    {type = typeFactory.getPackedStructType(typeList);};

union_type returns [Type type]
@init{
  List<Type> typeList = null;
}
    : 'union' '{' (type_list {typeList = $type_list.typeList;} )? '}' 
    {type = typeFactory.getUnionType(typeList);};

type_list returns [List<Type> typeList]
@init{
  typeList = new ArrayList<Type>();
}
    : dt = derived_type {typeList.add($dt.type);} (',' dt2 = derived_type {typeList.add($dt2.type);})*;

array_type returns [Type type]
    : '[' INTEGER 'x' derived_type ']' {type = typeFactory.getArrayType(Integer.parseInt($INTEGER.text), $derived_type.type);};

vector_type returns [Type type]
    : '<' INTEGER 'x' element_type '>' {type = typeFactory.getVectorType(Integer.parseInt($INTEGER.text), $element_type.type);};

return_type returns [Type type]
    : element_type {type = $element_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})*  
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      ('*' {type = typeFactory.getPointerType(type);})+  
      )*
    | structure_type {type = $structure_type.type;}
      (
        ('*' {type = typeFactory.getPointerType(type);})+ 
        (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )* 
        | 
        (ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )+ 
      )?
    | union_type {type = $union_type.type;}
      (
        ('*' {type = typeFactory.getPointerType(type);})+ 
        (ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )* 
        | 
        (ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
        ('*' {type = typeFactory.getPointerType(type);})+
        )+ 
      )?
    | packed_structure_type {type = $packed_structure_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})+  
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      ('*' {type = typeFactory.getPointerType(type);})+  
      )*
    | array_type {type = $array_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})+  
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      ('*' {type = typeFactory.getPointerType(type);})+  
      )*
    | vector_type {type = $vector_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})+  
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      ('*' {type = typeFactory.getPointerType(type);})+  
      )*
    | VOID {type = typeFactory.getVoidType();}
      (parameter_type_list {List<Type> typeList = $parameter_type_list.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      ('*' {type = typeFactory.getPointerType(type);})+  
      )* 
    ;

function_type returns [Type type]
    : element_type {type = $element_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})*  
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    | structure_type {type = $structure_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})*  
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    | union_type {type = $union_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})*  
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    | packed_structure_type {type = $packed_structure_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})+  
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    | array_type {type = $array_type.type;} 
      ('*' {type = typeFactory.getPointerType(type);})+  
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    | vector_type {type = $vector_type.type;}
      ('*' {type = typeFactory.getPointerType(type);})+  
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    | VOID {type = typeFactory.getVoidType();}
      ptl1 = parameter_type_list {List<Type> typeList = $ptl1.typeList; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);}
      (('*' {type = typeFactory.getPointerType(type);})+  
      ptl2 = parameter_type_list {List<Type> typeList2 = $ptl2.typeList; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);}
      )*
    ;

parameter_type_list returns [List<Type> typeList]
@init{
  typeList = new ArrayList<Type>();
}
    : '(' ( '...' {typeList.add(typeFactory.getWrongType());}
    | fct1 = first_class_type {typeList.add($fct1.type);}
      (',' fct2 = first_class_type {typeList.add($fct2.type);} )* (',' '...' {typeList.add(typeFactory.getWrongType());})?)? ')';

/////////////////////////////////////////////////////////////
//  CONSTANT
/////////////////////////////////////////////////////////////

initializer returns [Constant constant] 
    : 'zeroinitializer' {constant = valueFactory.createConstantValue(SimpleConstantValue.nullConst, "null");}
    | 'c' STRING {constant = valueFactory.createConstantValue(SimpleConstantValue.nullConst, $STRING.text);}
    | constant {constant = $constant.constant;}
    | GLOBAL_VARIABLE  {constant = valueFactory.createVariable($GLOBAL_VARIABLE.text);};

index returns [Constant expr]
    : INTEGER {expr = valueFactory.createConstantValue(SimpleConstantValue.intConst, $INTEGER.text);}
    | variable {expr = $variable.expr;};

constant returns [Constant constant]
    : getelementptr_expr {constant = $getelementptr_expr.expr;} 
    | conversion_expr {constant = $conversion_expr.expr;}
    | binary_expr {constant = $binary_expr.expr;}
    | cmp_expr {constant = $cmp_expr.expr;}
    | complex_constant {constant = $complex_constant.constant;}
    | simple_constant {constant = $simple_constant.constant;};

simple_constant returns [Constant constant]
    : INTEGER {constant = valueFactory.createConstantValue(SimpleConstantValue.intConst, $INTEGER.text);}
    | HEX {constant = valueFactory.createConstantValue(SimpleConstantValue.hexConst, $HEX.text);}
    | BOOLEAN {constant = valueFactory.createConstantValue(SimpleConstantValue.boolConst, $BOOLEAN.text);}
    | FLOATING_POINT {constant = valueFactory.createConstantValue(SimpleConstantValue.floatConst, $FLOATING_POINT.text);}
    | NULL {constant = valueFactory.createConstantValue(SimpleConstantValue.nullConst, $NULL.text);};

complex_constant returns [Constant constant]
    : structure_constant {constant = valueFactory.createConstantValue(ComplexConstantValue.structure, $structure_constant.text);}
    | array_constant {constant = valueFactory.createConstantValue(ComplexConstantValue.array, $array_constant.text);}
    | vector_constant{constant = valueFactory.createConstantValue(ComplexConstantValue.vector, $vector_constant.text);};

constant_list : derived_type initializer (',' derived_type initializer)*;

structure_constant : '{' constant_list '}';

array_constant : '[' constant_list ']';

vector_constant : '<' constant_list '>';

function_name returns [Constant expr]
@init{
String name=null;
}
@after{
expr = valueFactory.createVariable(name);
}    
    : GLOBAL_VARIABLE {name = $GLOBAL_VARIABLE.text;}| LOCAL_VARIABLE {name = $LOCAL_VARIABLE.text;}| assembly_expr {name = $assembly_expr.text;};

assembly_expr : 'asm' 'sideeffect'? 'alignstack'? STRING ',' STRING;

/////////////////////////////////////////////////////////////
//  LEXER
/////////////////////////////////////////////////////////////
BLOCK_ID : IDENTIFIER ':';
 
BOOLEAN_TYPE : 'i1';

INTEGER_TYPE : 'i' INTEGER;

LOCAL_VARIABLE : '%' (INTEGER | IDENTIFIER | STRING);

GLOBAL_VARIABLE : '@' (INTEGER | IDENTIFIER | STRING);

INTEGER : '-'?('0' | '1'..'9' '0'..'9'*);

BOOLEAN : 'true' | 'false';

FLOATING_POINT 
    : '-'?('0'..'9')+ '.' ('0'..'9')* Exponent? 
    |   '-'?'.' ('0'..'9')+ Exponent? 
    |   '-'?('0'..'9')+ Exponent 
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

HEX : '0' ('x'|'X') HexDigit+;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

BINARY_OP : 'add' | 'fadd' | 'sub' | 'fsub' | 'mul' | 'fmul' | 'udiv' | 'sdiv' | 'fdiv' | 'urem' | 'srem' | 'frem' | 'shl' | 'lshr' | 'ashr' | 'and' | 'or' | 'xor';

CONVERSION_OP : 'trunc' | 'zext' | 'sext' | 'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' | 'ptrtoint' | 'inttoptr' | 'bitcast';

CMP_COND : 'ugt' | 'uge' | 'ult' | 'ule';

ICMP_COND : 'eq' | 'ne' | 'sgt' | 'sge' | 'slt' | 'sle';

FCMP_COND : 'oeq' | 'ogt' | 'oge' | 'olt' | 'ole' | 'one' | 'ord' | 'ueq' | 'une' | 'uno' ;

VOLATILE : 'volatile';

VOID : 'void';

OPAQUE : 'opaque';

METADATA : 'metadata';

SECTION : 'section';

ALIGN : 'align';

LABEL : 'label';

TO : 'to';

UNWIND : 'unwind';

FLOATING_POINT_TYPE : 'float' | 'double' | 'fp128' | 'x86_fp80' | 'ppc_fp128' ;

STRING : '"' (~'"')* '"';

NULL : 'null';

UNDEF : 'undef';

LINKAGE
    : 'private'
    | 'linker_private'
    | 'linker_private_weak'
    | 'internal'
    | 'available_externally'
    | 'linkonce'
    | 'weak'
    | 'common'
    | 'appending'
    | 'extern_weak'
    | 'linkonce_odr'
    | 'weak_odr'
    | 'externally visible'
    | 'external'
    ;

VISIBILITY
    : 'default'
    | 'hidden'
    | 'protected'
    ;

CCONV
    : 'ccc'
    | 'fastcc'
    | 'coldcc'
    | 'cc' INTEGER
    ;

PARAMETER_ATTRIBUTES
    : 'zeroext'
    | 'signext'
    | 'inreg'
    | 'byval'
    | 'sret'
    | 'noalias'
    | 'nocapture'
    | 'nest'
    ;

FUNCTION_ATTRIBUTES
    : 'alignstack' '(' INTEGER ')'
    | 'alwaysinline'
    | 'inlinehint'
    | 'naked'
    | 'noimplicitfloat'
    | 'noinline'
    | 'noredzone'
    | 'noreturn'
    | 'nounwind'
    | 'optsize'
    | 'readnone'
    | 'readonly'
    | 'ssp'
    | 'sspreq'
    ;


IDENTIFIER 
    : ('a'..'z' | 'A'..'Z' | '_' | '.') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9' | '.' | '-')*;

//RET : '\n';

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : ';' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
