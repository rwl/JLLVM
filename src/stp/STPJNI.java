/**
The MIT License

Copyright (c) 2007 Adam Kiezun

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package stp;

/**
 * This class provides raw access to STP.
 * You can use this class or the STPObject class hierarchy (which provides more object-oriented access and is almost always preferable).   
 */
public final class STPJNI {
    static {
        System.loadLibrary("STPJNI");
    }

  // o  : optimizations
  // c  : check counterexample
  // p  : print counterexample
  // h  : help
  // s  : stats
  // v  : print nodes
  public native static void vc_setFlags(char c);
  
  //! Flags can be NULL
  public native static int/*VC*/ vc_createValidityChecker();
  
  // Basic types
  public native static int/*Type*/ vc_boolType(int/*VC*/ vc);
  
  //! Create an array type
  public native static int/*Type*/ vc_arrayType(int/*VC*/ vc, int/*Type*/ typeIndex, int/*Type*/ typeData);

  /////////////////////////////////////////////////////////////////////////////
  // Expr manipulation methods                                               //
  /////////////////////////////////////////////////////////////////////////////

  //! Create a variable with a given name and type 
  /*! The type cannot be a function type. The var name can contain
    only variables, numerals and underscore. If you use any other
    symbol, you will get a segfault. */  
  public native static int/*Expr*/ vc_varExpr(int/*VC*/ vc, String name, int/*Type*/ type);

  //The var name can contain only variables, numerals and
  //underscore. If you use any other symbol, you will get a segfault.
  public native static int/*Expr*/ vc_varExpr1(int/*VC*/ vc, String name, int indexwidth, int valuewidth);

  //! Get the expression and type associated with a name.
  /*!  If there is no such Expr, a NULL Expr is returned. */
  //int/*Expr*/ vc_lookupVar(int/*VC*/ vc, char* name, int/*Type*/* type);
  
  //! Get the type of the Expr.
  public native static int/*Type*/ vc_getType(int/*VC*/ vc, int/*Expr*/ e);
  
  public native static int vc_getBVLength(int/*VC*/ vc, int/*Expr*/ e);

  //! Create an equality expression.  The two children must have the same type.
  public native static int/*Expr*/ vc_eqExpr(int/*VC*/ vc, int/*Expr*/ child0, int/*Expr*/ child1);
  
  // Boolean expressions
  
  // The following functions create Boolean expressions.  The children
  // provided as arguments must be of type Boolean (except for the
  // function vc_iteExpr(). In the case of vc_iteExpr() the
  // conditional must always be Boolean, but the ifthenpart
  // (resp. elsepart) can be bit-vector or Boolean type. But, the
  // ifthenpart and elsepart must be both of the same type)
  public native static int/*Expr*/ vc_trueExpr(int/*VC*/ vc);
  public native static int/*Expr*/ vc_falseExpr(int/*VC*/ vc);
  public native static int/*Expr*/ vc_notExpr(int/*VC*/ vc, int/*Expr*/ child);
  public native static int/*Expr*/ vc_andExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_andExprN(int/*VC*/ vc, int/*Expr*/[] children, int numOfChildNodes);
  public native static int/*Expr*/ vc_orExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_orExprN(int/*VC*/ vc, int/*Expr*/[] children, int numOfChildNodes);
  public native static int/*Expr*/ vc_impliesExpr(int/*VC*/ vc, int/*Expr*/ hyp, int/*Expr*/ conc);
  public native static int/*Expr*/ vc_iffExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  //The output type of vc_iteExpr can be Boolean (formula-level ite)
  //or bit-vector (word-level ite)
  public native static int/*Expr*/ vc_iteExpr(int/*VC*/ vc, int/*Expr*/ conditional, int/*Expr*/ ifthenpart, int/*Expr*/ elsepart);
  
  //Boolean to single bit BV Expression
  public native static int/*Expr*/ vc_boolToBVExpr(int/*VC*/ vc, int/*Expr*/ form);

  // Arrays
  
  //! Create an expression for the value of array at the given index
  public native static int/*Expr*/ vc_readExpr(int/*VC*/ vc, int/*Expr*/ array, int/*Expr*/ index);

  //! Array update; equivalent to "array WITH [index] := newValue"
  public native static int/*Expr*/ vc_writeExpr(int/*VC*/ vc, int/*Expr*/ array, int/*Expr*/ index, int/*Expr*/ newValue);
  
  // Expr I/O
  //! int/*Expr*/ vc_parseExpr(int/*VC*/ vc, char* s);

  //! Prints 'e' to stdout.
  public native static void vc_printExpr(int/*VC*/ vc, int/*Expr*/ e);

  //! Prints 'e' into an open file descriptor 'fd'
  public native static void vc_printExprFile(int/*VC*/ vc, int/*Expr*/ e, int fd);

  //! Prints 'e' to malloc'd buffer '*buf'.  Sets '*len' to the length of 
  //  the buffer. It is the responsibility of the caller to free the buffer.
  //TODO
  //public native static void vc_printExprToBuffer(int/*VC*/ vc, int/*Expr*/ e, char **buf, unsigned long * len);

  //! Prints counterexample to stdout.
  public native static void vc_printCounterExample(int/*VC*/ vc);

  //! Prints variable declarations to stdout.
  public native static void vc_printVarDecls(int/*VC*/ vc);

  //! Prints asserts to stdout. The flag simplify_print must be set to
  //"1" if you wish simplification to occur dring printing. It must be
  //set to "0" otherwise
  public native static void vc_printAsserts(int/*VC*/ vc, int simplify_print);

  //! Prints the state of the query to malloc'd buffer '*buf' and
  //stores ! the length of the buffer to '*len'.  It is the
  //responsibility of the caller to free the buffer. The flag
  //simplify_print must be set to "1" if you wish simplification to
  //occur dring printing. It must be set to "0" otherwise
  //TODO
  //public native static void vc_printQueryStateToBuffer(int/*VC*/ vc, int/*Expr*/ e, char **buf, unsigned long *len, int simplify_print);

  //! Similar to vc_printQueryStateToBuffer()
  //TODO
  //public native static void vc_printCounterExampleToBuffer(int/*VC*/ vc, char **buf,unsigned long *len);

  //! Prints query to stdout.
  public native static void vc_printQuery(int/*VC*/ vc);

  /////////////////////////////////////////////////////////////////////////////
  // Context-related methods                                                 //
  /////////////////////////////////////////////////////////////////////////////
  
  //! Assert a new formula in the current context.  
  /*! The formula must have Boolean type. */
  public native static void vc_assertFormula(int/*VC*/ vc, int/*Expr*/ e);
  
  //! Simplify e with respect to the current context
  public native static int/*Expr*/ vc_simplify(int/*VC*/ vc, int/*Expr*/ e);

  //! Check validity of e in the current context. e must be a FORMULA
  //
  //if returned 0 then input is INVALID. 
  //
  //if returned 1 then input is VALID
  //
  //if returned 2 then ERROR
  public native static int vc_query(int/*VC*/ vc, int/*Expr*/ e);
  
  //! Return the counterexample after a failed query.
  public native static int/*Expr*/ vc_getCounterExample(int/*VC*/ vc, int/*Expr*/ e);

  //! get size of counterexample, i.e. the number of variables/array
  //locations in the counterexample.
  public native static int vc_counterexample_size(int/*VC*/ vc);
  
  //! Checkpoint the current context and increase the scope level
  public native static void vc_push(int/*VC*/ vc);
  
  //! Restore the current context to its state at the last checkpoint
  public native static void vc_pop(int/*VC*/ vc);
  
  //! Return an int from a constant bitvector expression
  public native static int getBVInt(int/*Expr*/ e);
  //! Return an unsigned int from a constant bitvector expression
  //TODO
  public native static long getBVUnsigned(int/*Expr*/ e);
  //! Return an unsigned long long int from a constant bitvector expressions
  //TODO
  //public native static unsigned long long int getBVUnsignedLongLong(int/*Expr*/ e);
  
  /**************************/
  /* BIT VECTOR OPERATIONS  */
  /**************************/
  public native static int/*Type*/ vc_bvType(int/*VC*/ vc, int no_bits);
  public native static int/*Type*/ vc_bv32Type(int/*VC*/ vc);
  
  public native static int/*Expr*/ vc_bvConstExprFromStr(int/*VC*/ vc, String binary_repr);
  public native static int/*Expr*/ vc_bvConstExprFromInt(int/*VC*/ vc, int n_bits, long value);
  //TODO public native static int/*Expr*/ vc_bvConstExprFromLL(int/*VC*/ vc, int n_bits, unsigned long long value);
  public native static int/*Expr*/ vc_bv32ConstExprFromInt(int/*VC*/ vc, long value);
  
  public native static int/*Expr*/ vc_bvConcatExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvPlusExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bv32PlusExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvMinusExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bv32MinusExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvMultExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bv32MultExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  // left divided by right i.e. left/right
  public native static int/*Expr*/ vc_bvDivExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  // left modulo right i.e. left%right
  public native static int/*Expr*/ vc_bvModExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  // signed left divided by right i.e. left/right
  public native static int/*Expr*/ vc_sbvDivExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  // signed left modulo right i.e. left%right
  public native static int/*Expr*/ vc_sbvModExpr(int/*VC*/ vc, int n_bits, int/*Expr*/ left, int/*Expr*/ right);
  
  public native static int/*Expr*/ vc_bvLtExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvLeExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvGtExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvGeExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  
  public native static int/*Expr*/ vc_sbvLtExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_sbvLeExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_sbvGtExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_sbvGeExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  
  public native static int/*Expr*/ vc_bvUMinusExpr(int/*VC*/ vc, int/*Expr*/ child);

  // bitwise operations: these are terms not formulas  
  public native static int/*Expr*/ vc_bvAndExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvOrExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvXorExpr(int/*VC*/ vc, int/*Expr*/ left, int/*Expr*/ right);
  public native static int/*Expr*/ vc_bvNotExpr(int/*VC*/ vc, int/*Expr*/ child);
  
  public native static int/*Expr*/ vc_bvLeftShiftExpr(int/*VC*/ vc, int sh_amt, int/*Expr*/ child);
  public native static int/*Expr*/ vc_bvRightShiftExpr(int/*VC*/ vc, int sh_amt, int/*Expr*/ child);
  /* Same as vc_bvLeftShift only that the answer in 32 bits long */
  public native static int/*Expr*/ vc_bv32LeftShiftExpr(int/*VC*/ vc, int sh_amt, int/*Expr*/ child);
  /* Same as vc_bvRightShift only that the answer in 32 bits long */
  public native static int/*Expr*/ vc_bv32RightShiftExpr(int/*VC*/ vc, int sh_amt, int/*Expr*/ child);
  public native static int/*Expr*/ vc_bvVar32LeftShiftExpr(int/*VC*/ vc, int/*Expr*/ sh_amt, int/*Expr*/ child);
  public native static int/*Expr*/ vc_bvVar32RightShiftExpr(int/*VC*/ vc, int/*Expr*/ sh_amt, int/*Expr*/ child);
  public native static int/*Expr*/ vc_bvVar32DivByPowOfTwoExpr(int/*VC*/ vc, int/*Expr*/ child, int/*Expr*/ rhs);

  public native static int/*Expr*/ vc_bvExtract(int/*VC*/ vc, int/*Expr*/ child, int high_bit_no, int low_bit_no);
  
  //accepts a bitvector and position, and returns a boolean
  //corresponding to that position. More precisely, it return the
  //equation (x[bit_no:bit_no] = 0)
  //FIXME  = 1 ?
  public native static int/*Expr*/ vc_bvBoolExtract(int/*VC*/ vc, int/*Expr*/ x, int bit_no);  
  public native static int/*Expr*/ vc_bvSignExtend(int/*VC*/ vc, int/*Expr*/ child, int nbits);
  
  /*C pointer support:  C interface to support C memory arrays in CVCL */
  public native static int/*Expr*/ vc_bvCreateMemoryArray(int/*VC*/ vc, String arrayName);
  public native static int/*Expr*/ vc_bvReadMemoryArray(int/*VC*/ vc, int/*Expr*/ array, int/*Expr*/ byteIndex, int numOfBytes);
  public native static int/*Expr*/ vc_bvWriteToMemoryArray(int/*VC*/ vc, int/*Expr*/ array, int/*Expr*/  byteIndex, int/*Expr*/ element, int numOfBytes);
  
  // return a string representation of the int/*Expr*/ e. The caller is responsible
  // for deallocating the string with free()
  public native static String exprString(int/*Expr*/ e);
  
  // return a string representation of the Type t. The caller is responsible
  // for deallocating the string with free()
  public native static String typeString(int/*Type*/ t);

  public native static int/*Expr*/ getChild(int/*Expr*/ e, int i);

  //1.if input expr is TRUE then the function returns 1;
  //
  //2.if input expr is FALSE then function returns 0;
  //
  //3.otherwise the function returns -1
  public native static int vc_isBool(int/*Expr*/ e);

  /* Register the given error handler to be called for each fatal error.*/
  //TODO
  //public native static void vc_registerErrorHandler(void (*error_hdlr)(const char* err_msg));

  public native static int vc_getHashQueryStateToBuffer(int/*VC*/ vc, int/*Expr*/ query);

  //destroys the STP instance, and removes all the created expressions
  public native static void vc_Destroy(int/*VC*/ vc);

  //deletes the expression e
  public native static void vc_DeleteExpr(int/*Expr*/ e);

  //Get the whole counterexample from the current context
  public native static int/*WholeCounterExample*/ vc_getWholeCounterExample(int/*VC*/ vc);

  //Get the value of a term expression from the CounterExample
  public native static int/*Expr*/ vc_getTermFromCounterExample(int/*VC*/ vc, int/*Expr*/ e, int/*WholeCounterExample*/ c);

  // get the kind of the expression
  public native static int getExprKind (int/*Expr*/ e);

  // get the number of children nodes
  public native static int getDegree (int/*Expr*/ e);

  // get the bv length
  public native static int getBVLength(int/*Expr*/ e);

  // get expression type
  public native static int getType (int/*Expr*/ e);

  // get value bit width
  public native static int getVWidth (int/*Expr*/ e);

  // get index bit width
  public native static int getIWidth (int/*Expr*/ e);

  // Prints counterexample to an open file descriptor 'fd'
  public native static void vc_printCounterExampleFile(int/*VC*/ vc, int fd);

  // get name of expression. must be a variable.
  public native static String exprName(int/*Expr*/ e);
  
  // get the node ID of an Expr.
  public native static int getExprID (int/*Expr*/ ex);

}
