// $ANTLR 3.4 D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g 2012-10-07 17:09:51

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LLVMParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALIGN", "BINARY_OP", "BLOCK_ID", "BOOLEAN", "BOOLEAN_TYPE", "CCONV", "CMP_COND", "CONVERSION_OP", "Exponent", "FCMP_COND", "FLOATING_POINT", "FLOATING_POINT_TYPE", "FUNCTION_ATTRIBUTES", "GLOBAL_VARIABLE", "HEX", "HexDigit", "ICMP_COND", "IDENTIFIER", "INTEGER", "INTEGER_TYPE", "LABEL", "LINE_COMMENT", "LINKAGE", "LOCAL_VARIABLE", "METADATA", "NULL", "OPAQUE", "PARAMETER_ATTRIBUTES", "SECTION", "STRING", "TO", "UNDEF", "UNWIND", "VISIBILITY", "VOID", "VOLATILE", "WS", "'('", "')'", "'*'", "','", "'...'", "'<'", "'='", "'>'", "'['", "']'", "'alias'", "'alignstack'", "'alloca'", "'asm'", "'br'", "'c'", "'call'", "'constant'", "'datalayout'", "'declare'", "'define'", "'exact'", "'extractelement'", "'extractvalue'", "'fcmp'", "'getelementptr'", "'global'", "'icmp'", "'inbounds'", "'indirectbr'", "'insertelement'", "'insertvalue'", "'invoke'", "'load'", "'nsw'", "'nuw'", "'phi'", "'ret'", "'select'", "'shufflevector'", "'sideeffect'", "'store'", "'switch'", "'tail'", "'target'", "'thread_local'", "'triple'", "'type'", "'union'", "'unreachable'", "'x'", "'zeroinitializer'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int ALIGN=4;
    public static final int BINARY_OP=5;
    public static final int BLOCK_ID=6;
    public static final int BOOLEAN=7;
    public static final int BOOLEAN_TYPE=8;
    public static final int CCONV=9;
    public static final int CMP_COND=10;
    public static final int CONVERSION_OP=11;
    public static final int Exponent=12;
    public static final int FCMP_COND=13;
    public static final int FLOATING_POINT=14;
    public static final int FLOATING_POINT_TYPE=15;
    public static final int FUNCTION_ATTRIBUTES=16;
    public static final int GLOBAL_VARIABLE=17;
    public static final int HEX=18;
    public static final int HexDigit=19;
    public static final int ICMP_COND=20;
    public static final int IDENTIFIER=21;
    public static final int INTEGER=22;
    public static final int INTEGER_TYPE=23;
    public static final int LABEL=24;
    public static final int LINE_COMMENT=25;
    public static final int LINKAGE=26;
    public static final int LOCAL_VARIABLE=27;
    public static final int METADATA=28;
    public static final int NULL=29;
    public static final int OPAQUE=30;
    public static final int PARAMETER_ATTRIBUTES=31;
    public static final int SECTION=32;
    public static final int STRING=33;
    public static final int TO=34;
    public static final int UNDEF=35;
    public static final int UNWIND=36;
    public static final int VISIBILITY=37;
    public static final int VOID=38;
    public static final int VOLATILE=39;
    public static final int WS=40;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public LLVMParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public LLVMParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return LLVMParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g"; }


    TypeFactory typeFactory = new TypeFactory();
    ValueFactory valueFactory = new ValueFactory();
    InstFactory instFactory = new InstFactory();



    // $ANTLR start "program"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:28:1: program returns [Module program] : ( target )* ( named_type )* ( global_variable )* ( aliases_variable )* ( function_declaration | function_definition )+ EOF ;
    public final Module program() throws RecognitionException {
        Module program = null;


        GlobalVariable global_variable1 =null;

        GlobalAlias aliases_variable2 =null;

        FunctionDeclare function_declaration3 =null;

        Function function_definition4 =null;



        List<GlobalVariable> globalVariables = new ArrayList<GlobalVariable>();
        List<GlobalAlias> globalAlias = new ArrayList<GlobalAlias>();
        List<FunctionDeclare> functionDeclares = new ArrayList<FunctionDeclare>();
        List<Function> functions = new ArrayList<Function>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:38:9: ( ( target )* ( named_type )* ( global_variable )* ( aliases_variable )* ( function_declaration | function_definition )+ EOF )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:38:11: ( target )* ( named_type )* ( global_variable )* ( aliases_variable )* ( function_declaration | function_definition )+ EOF
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:38:11: ( target )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==85) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:38:11: target
            	    {
            	    pushFollow(FOLLOW_target_in_program55);
            	    target();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:39:11: ( named_type )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==LOCAL_VARIABLE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:39:11: named_type
            	    {
            	    pushFollow(FOLLOW_named_type_in_program68);
            	    named_type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:40:11: ( global_variable )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==GLOBAL_VARIABLE) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==47) ) {
                        int LA3_3 = input.LA(3);

                        if ( (LA3_3==LINKAGE||LA3_3==58||LA3_3==67||LA3_3==86) ) {
                            alt3=1;
                        }


                    }


                }


                switch (alt3) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:40:12: global_variable
            	    {
            	    pushFollow(FOLLOW_global_variable_in_program83);
            	    global_variable1=global_variable();

            	    state._fsp--;


            	    globalVariables.add(global_variable1);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:41:11: ( aliases_variable )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==GLOBAL_VARIABLE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:41:12: aliases_variable
            	    {
            	    pushFollow(FOLLOW_aliases_variable_in_program101);
            	    aliases_variable2=aliases_variable();

            	    state._fsp--;


            	    globalAlias.add(aliases_variable2);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:42:11: ( function_declaration | function_definition )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==60) ) {
                    alt5=1;
                }
                else if ( (LA5_0==61) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:42:12: function_declaration
            	    {
            	    pushFollow(FOLLOW_function_declaration_in_program118);
            	    function_declaration3=function_declaration();

            	    state._fsp--;


            	    functionDeclares.add(function_declaration3);

            	    }
            	    break;
            	case 2 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:44:12: function_definition
            	    {
            	    pushFollow(FOLLOW_function_definition_in_program148);
            	    function_definition4=function_definition();

            	    state._fsp--;


            	    functions.add(function_definition4);

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input,EOF,FOLLOW_EOF_in_program164); 

            }

             
            program = valueFactory.createModule(globalVariables, globalAlias, functionDeclares, functions, typeFactory.getNamedTypeTable());

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return program;
    }
    // $ANTLR end "program"



    // $ANTLR start "target"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:48:1: target : 'target' ( 'datalayout' | 'triple' ) '=' STRING ;
    public final void target() throws RecognitionException {
        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:48:8: ( 'target' ( 'datalayout' | 'triple' ) '=' STRING )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:48:10: 'target' ( 'datalayout' | 'triple' ) '=' STRING
            {
            match(input,85,FOLLOW_85_in_target183); 

            if ( input.LA(1)==59||input.LA(1)==87 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,47,FOLLOW_47_in_target193); 

            match(input,STRING,FOLLOW_STRING_in_target195); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "target"



    // $ANTLR start "named_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:50:1: named_type : LOCAL_VARIABLE '=' 'type' ( derived_type ) ;
    public final void named_type() throws RecognitionException {
        Token LOCAL_VARIABLE5=null;
        Type derived_type6 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:51:5: ( LOCAL_VARIABLE '=' 'type' ( derived_type ) )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:51:7: LOCAL_VARIABLE '=' 'type' ( derived_type )
            {
            LOCAL_VARIABLE5=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_named_type208); 

            match(input,47,FOLLOW_47_in_named_type210); 

            match(input,88,FOLLOW_88_in_named_type212); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:52:7: ( derived_type )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:52:8: derived_type
            {
            pushFollow(FOLLOW_derived_type_in_named_type222);
            derived_type6=derived_type();

            state._fsp--;


            String idTypeName = (LOCAL_VARIABLE5!=null?LOCAL_VARIABLE5.getText():null); Type type = derived_type6; typeFactory.addIDType(idTypeName, type); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "named_type"



    // $ANTLR start "global_variable"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:55:1: global_variable returns [GlobalVariable globalVariable] : GLOBAL_VARIABLE '=' ( LINKAGE )? ( 'thread_local' )? ( 'global' | 'constant' ) derived_type ( initializer ( ',' section )? ( ',' align )? )? ;
    public final GlobalVariable global_variable() throws RecognitionException {
        GlobalVariable globalVariable = null;


        Token GLOBAL_VARIABLE7=null;
        Token LINKAGE8=null;
        Type derived_type9 =null;

        Constant initializer10 =null;

        String section11 =null;

        int align12 =0;



        String name;
        String linkage = null;
        boolean isThreadLocal = false;
        boolean isConstant = false;
        Type type = null; 
        Constant initializer = null;
        String section = null;
        int align = -1;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:70:5: ( GLOBAL_VARIABLE '=' ( LINKAGE )? ( 'thread_local' )? ( 'global' | 'constant' ) derived_type ( initializer ( ',' section )? ( ',' align )? )? )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:71:5: GLOBAL_VARIABLE '=' ( LINKAGE )? ( 'thread_local' )? ( 'global' | 'constant' ) derived_type ( initializer ( ',' section )? ( ',' align )? )?
            {
            GLOBAL_VARIABLE7=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_global_variable261); 

            name = (GLOBAL_VARIABLE7!=null?GLOBAL_VARIABLE7.getText():null); name = name.substring(1, name.length());

            match(input,47,FOLLOW_47_in_global_variable270); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:72:9: ( LINKAGE )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LINKAGE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:72:10: LINKAGE
                    {
                    LINKAGE8=(Token)match(input,LINKAGE,FOLLOW_LINKAGE_in_global_variable273); 

                    linkage = (LINKAGE8!=null?LINKAGE8.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:73:5: ( 'thread_local' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==86) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:73:6: 'thread_local'
                    {
                    match(input,86,FOLLOW_86_in_global_variable285); 

                    isThreadLocal= true;

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:74:5: ( 'global' | 'constant' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==67) ) {
                alt8=1;
            }
            else if ( (LA8_0==58) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:74:6: 'global'
                    {
                    match(input,67,FOLLOW_67_in_global_variable297); 

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:74:17: 'constant'
                    {
                    match(input,58,FOLLOW_58_in_global_variable301); 

                    isConstant = true;

                    }
                    break;

            }


            pushFollow(FOLLOW_derived_type_in_global_variable311);
            derived_type9=derived_type();

            state._fsp--;


            type = derived_type9;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:76:5: ( initializer ( ',' section )? ( ',' align )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==BINARY_OP||LA11_0==BOOLEAN||LA11_0==CONVERSION_OP||LA11_0==FLOATING_POINT||LA11_0==HEX||LA11_0==INTEGER||LA11_0==NULL||LA11_0==46||LA11_0==49||LA11_0==56||(LA11_0 >= 65 && LA11_0 <= 66)||LA11_0==68||(LA11_0 >= 92 && LA11_0 <= 93)) ) {
                alt11=1;
            }
            else if ( (LA11_0==GLOBAL_VARIABLE) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==GLOBAL_VARIABLE||LA11_2==44||(LA11_2 >= 60 && LA11_2 <= 61)) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:76:6: initializer ( ',' section )? ( ',' align )?
                    {
                    pushFollow(FOLLOW_initializer_in_global_variable320);
                    initializer10=initializer();

                    state._fsp--;


                    initializer = initializer10;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:77:7: ( ',' section )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==44) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==SECTION) ) {
                            alt9=1;
                        }
                    }
                    switch (alt9) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:77:8: ',' section
                            {
                            match(input,44,FOLLOW_44_in_global_variable332); 

                            pushFollow(FOLLOW_section_in_global_variable334);
                            section11=section();

                            state._fsp--;


                            section = section11;

                            }
                            break;

                    }


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:79:7: ( ',' align )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==44) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:79:8: ',' align
                            {
                            match(input,44,FOLLOW_44_in_global_variable355); 

                            pushFollow(FOLLOW_align_in_global_variable357);
                            align12=align();

                            state._fsp--;


                            align = align12;

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            globalVariable = valueFactory.createGlobalVariable(name, linkage, isThreadLocal, isConstant, type, 
                                              initializer, section, align);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return globalVariable;
    }
    // $ANTLR end "global_variable"



    // $ANTLR start "aliases_variable"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:82:1: aliases_variable returns [GlobalAlias globalAlias] : g1= GLOBAL_VARIABLE '=' 'alias' ( LINKAGE )? ( VISIBILITY )? derived_type g2= GLOBAL_VARIABLE ;
    public final GlobalAlias aliases_variable() throws RecognitionException {
        GlobalAlias globalAlias = null;


        Token g1=null;
        Token g2=null;
        Token LINKAGE13=null;
        Token VISIBILITY14=null;
        Type derived_type15 =null;



        String name;
        String linkage = null;
        String visibility = null;
        Type type;
        String gVarName;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:93:5: (g1= GLOBAL_VARIABLE '=' 'alias' ( LINKAGE )? ( VISIBILITY )? derived_type g2= GLOBAL_VARIABLE )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:94:5: g1= GLOBAL_VARIABLE '=' 'alias' ( LINKAGE )? ( VISIBILITY )? derived_type g2= GLOBAL_VARIABLE
            {
            g1=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_aliases_variable402); 

            name = (g1!=null?g1.getText():null); name = name.substring(1, name.length());

            match(input,47,FOLLOW_47_in_aliases_variable412); 

            match(input,51,FOLLOW_51_in_aliases_variable414); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:95:17: ( LINKAGE )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LINKAGE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:95:18: LINKAGE
                    {
                    LINKAGE13=(Token)match(input,LINKAGE,FOLLOW_LINKAGE_in_aliases_variable417); 

                    linkage = (LINKAGE13!=null?LINKAGE13.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:96:5: ( VISIBILITY )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==VISIBILITY) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:96:6: VISIBILITY
                    {
                    VISIBILITY14=(Token)match(input,VISIBILITY,FOLLOW_VISIBILITY_in_aliases_variable430); 

                    visibility = (VISIBILITY14!=null?VISIBILITY14.getText():null);

                    }
                    break;

            }


            pushFollow(FOLLOW_derived_type_in_aliases_variable441);
            derived_type15=derived_type();

            state._fsp--;


            type = derived_type15;

            g2=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_aliases_variable454); 

            gVarName = (g2!=null?g2.getText():null); gVarName = gVarName.substring(1, gVarName.length());

            }


            globalAlias = valueFactory.createGlobalAlias(name, linkage, visibility, type, gVarName);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return globalAlias;
    }
    // $ANTLR end "aliases_variable"



    // $ANTLR start "function_declaration"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:100:1: function_declaration returns [FunctionDeclare functionDeclare] : 'declare' ( LINKAGE )? ( VISIBILITY )? ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type GLOBAL_VARIABLE '(' argument_list[argList] ')' ( FUNCTION_ATTRIBUTES )* ;
    public final FunctionDeclare function_declaration() throws RecognitionException {
        FunctionDeclare functionDeclare = null;


        Token LINKAGE16=null;
        Token VISIBILITY17=null;
        Token CCONV18=null;
        Token PARAMETER_ATTRIBUTES19=null;
        Token GLOBAL_VARIABLE21=null;
        Token FUNCTION_ATTRIBUTES23=null;
        Type return_type20 =null;

        boolean argument_list22 =false;



        String linkage = null;
        String visibility = null;
        String cconv = null;
        List<String> pAttributes = new ArrayList<String>();
        boolean isVararg = false;
        Type type;
        String name;
        List<Argument> argList = new ArrayList<Argument>();
        List<String> fAttributes = new ArrayList<String>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:115:5: ( 'declare' ( LINKAGE )? ( VISIBILITY )? ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type GLOBAL_VARIABLE '(' argument_list[argList] ')' ( FUNCTION_ATTRIBUTES )* )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:116:7: 'declare' ( LINKAGE )? ( VISIBILITY )? ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type GLOBAL_VARIABLE '(' argument_list[argList] ')' ( FUNCTION_ATTRIBUTES )*
            {
            match(input,60,FOLLOW_60_in_function_declaration492); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:116:17: ( LINKAGE )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LINKAGE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:116:18: LINKAGE
                    {
                    LINKAGE16=(Token)match(input,LINKAGE,FOLLOW_LINKAGE_in_function_declaration495); 

                    linkage = (LINKAGE16!=null?LINKAGE16.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:117:7: ( VISIBILITY )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==VISIBILITY) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:117:8: VISIBILITY
                    {
                    VISIBILITY17=(Token)match(input,VISIBILITY,FOLLOW_VISIBILITY_in_function_declaration509); 

                    visibility = (VISIBILITY17!=null?VISIBILITY17.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:118:7: ( CCONV )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==CCONV) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:118:8: CCONV
                    {
                    CCONV18=(Token)match(input,CCONV,FOLLOW_CCONV_in_function_declaration523); 

                    cconv = (CCONV18!=null?CCONV18.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:119:7: ( PARAMETER_ATTRIBUTES )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==PARAMETER_ATTRIBUTES) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:119:8: PARAMETER_ATTRIBUTES
            	    {
            	    PARAMETER_ATTRIBUTES19=(Token)match(input,PARAMETER_ATTRIBUTES,FOLLOW_PARAMETER_ATTRIBUTES_in_function_declaration537); 

            	    pAttributes.add((PARAMETER_ATTRIBUTES19!=null?PARAMETER_ATTRIBUTES19.getText():null));

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            pushFollow(FOLLOW_return_type_in_function_declaration549);
            return_type20=return_type();

            state._fsp--;


            type = return_type20;

            GLOBAL_VARIABLE21=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_function_declaration560); 

            name = (GLOBAL_VARIABLE21!=null?GLOBAL_VARIABLE21.getText():null); name = name.substring(1, name.length());

            match(input,41,FOLLOW_41_in_function_declaration570); 

            pushFollow(FOLLOW_argument_list_in_function_declaration572);
            argument_list22=argument_list(argList);

            state._fsp--;


            isVararg = argument_list22;

            match(input,42,FOLLOW_42_in_function_declaration576); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:123:7: ( FUNCTION_ATTRIBUTES )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==FUNCTION_ATTRIBUTES) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:123:8: FUNCTION_ATTRIBUTES
            	    {
            	    FUNCTION_ATTRIBUTES23=(Token)match(input,FUNCTION_ATTRIBUTES,FOLLOW_FUNCTION_ATTRIBUTES_in_function_declaration586); 

            	    fAttributes.add((FUNCTION_ATTRIBUTES23!=null?FUNCTION_ATTRIBUTES23.getText():null));

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            functionDeclare = valueFactory.createFunctionDeclare(linkage, visibility, cconv, pAttributes, isVararg, type, name, argList, fAttributes);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return functionDeclare;
    }
    // $ANTLR end "function_declaration"



    // $ANTLR start "function_definition"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:126:1: function_definition returns [Function function] : 'define' ( LINKAGE )? ( VISIBILITY )? ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type GLOBAL_VARIABLE '(' argument_list[argList] ')' ( FUNCTION_ATTRIBUTES )* ( align )? '{' ( basic_block )+ '}' ;
    public final Function function_definition() throws RecognitionException {
        Function function = null;


        Token LINKAGE24=null;
        Token VISIBILITY25=null;
        Token CCONV26=null;
        Token PARAMETER_ATTRIBUTES27=null;
        Token GLOBAL_VARIABLE29=null;
        Token FUNCTION_ATTRIBUTES31=null;
        Type return_type28 =null;

        boolean argument_list30 =false;

        int align32 =0;

        BasicBlock basic_block33 =null;



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

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:143:5: ( 'define' ( LINKAGE )? ( VISIBILITY )? ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type GLOBAL_VARIABLE '(' argument_list[argList] ')' ( FUNCTION_ATTRIBUTES )* ( align )? '{' ( basic_block )+ '}' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:144:7: 'define' ( LINKAGE )? ( VISIBILITY )? ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type GLOBAL_VARIABLE '(' argument_list[argList] ')' ( FUNCTION_ATTRIBUTES )* ( align )? '{' ( basic_block )+ '}'
            {
            match(input,61,FOLLOW_61_in_function_definition625); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:145:7: ( LINKAGE )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LINKAGE) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:145:8: LINKAGE
                    {
                    LINKAGE24=(Token)match(input,LINKAGE,FOLLOW_LINKAGE_in_function_definition635); 

                    linkage = (LINKAGE24!=null?LINKAGE24.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:146:7: ( VISIBILITY )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==VISIBILITY) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:146:8: VISIBILITY
                    {
                    VISIBILITY25=(Token)match(input,VISIBILITY,FOLLOW_VISIBILITY_in_function_definition649); 

                    visibility = (VISIBILITY25!=null?VISIBILITY25.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:147:7: ( CCONV )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==CCONV) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:147:8: CCONV
                    {
                    CCONV26=(Token)match(input,CCONV,FOLLOW_CCONV_in_function_definition663); 

                    cconv = (CCONV26!=null?CCONV26.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:148:7: ( PARAMETER_ATTRIBUTES )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==PARAMETER_ATTRIBUTES) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:148:8: PARAMETER_ATTRIBUTES
            	    {
            	    PARAMETER_ATTRIBUTES27=(Token)match(input,PARAMETER_ATTRIBUTES,FOLLOW_PARAMETER_ATTRIBUTES_in_function_definition677); 

            	    pAttributes.add((PARAMETER_ATTRIBUTES27!=null?PARAMETER_ATTRIBUTES27.getText():null));

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            pushFollow(FOLLOW_return_type_in_function_definition689);
            return_type28=return_type();

            state._fsp--;


            type = return_type28;

            GLOBAL_VARIABLE29=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_function_definition699); 

            name = (GLOBAL_VARIABLE29!=null?GLOBAL_VARIABLE29.getText():null); name = name.substring(1, name.length());

            match(input,41,FOLLOW_41_in_function_definition709); 

            pushFollow(FOLLOW_argument_list_in_function_definition711);
            argument_list30=argument_list(argList);

            state._fsp--;


            isVararg = argument_list30;

            match(input,42,FOLLOW_42_in_function_definition715); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:152:7: ( FUNCTION_ATTRIBUTES )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==FUNCTION_ATTRIBUTES) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:152:8: FUNCTION_ATTRIBUTES
            	    {
            	    FUNCTION_ATTRIBUTES31=(Token)match(input,FUNCTION_ATTRIBUTES,FOLLOW_FUNCTION_ATTRIBUTES_in_function_definition725); 

            	    fAttributes.add((FUNCTION_ATTRIBUTES31!=null?FUNCTION_ATTRIBUTES31.getText():null));

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:153:7: ( align )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ALIGN) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:153:8: align
                    {
                    pushFollow(FOLLOW_align_in_function_definition739);
                    align32=align();

                    state._fsp--;


                    align = align32;

                    }
                    break;

            }


            match(input,93,FOLLOW_93_in_function_definition751); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:155:7: ( basic_block )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==BLOCK_ID||LA25_0==GLOBAL_VARIABLE||LA25_0==LOCAL_VARIABLE||(LA25_0 >= UNDEF && LA25_0 <= UNWIND)||LA25_0==VOLATILE||LA25_0==55||LA25_0==57||LA25_0==70||LA25_0==73||LA25_0==78||(LA25_0 >= 82 && LA25_0 <= 84)||LA25_0==90) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:155:9: basic_block
            	    {
            	    pushFollow(FOLLOW_basic_block_in_function_definition762);
            	    basic_block33=basic_block();

            	    state._fsp--;


            	    basicBlocks.add(basic_block33);
            	          

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            match(input,94,FOLLOW_94_in_function_definition775); 

            }


            function = valueFactory.createFunction(linkage, visibility, cconv, pAttributes, type, name, argList, isVararg, fAttributes, align, basicBlocks);  

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return function;
    }
    // $ANTLR end "function_definition"



    // $ANTLR start "basic_block"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:160:1: basic_block returns [BasicBlock basicBlock] : ( BLOCK_ID )? ( phi_op )* ( operator )* terminator ;
    public final BasicBlock basic_block() throws RecognitionException {
        BasicBlock basicBlock = null;


        Token BLOCK_ID34=null;
        LLVMParser.phi_op_return phi_op35 =null;

        LLVMParser.operator_return operator36 =null;

        LLVMParser.terminator_return terminator37 =null;



        String blockID = null;
        List<Instruction> instructions = new ArrayList<Instruction>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:168:5: ( ( BLOCK_ID )? ( phi_op )* ( operator )* terminator )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:168:7: ( BLOCK_ID )? ( phi_op )* ( operator )* terminator
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:168:7: ( BLOCK_ID )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==BLOCK_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:168:8: BLOCK_ID
                    {
                    BLOCK_ID34=(Token)match(input,BLOCK_ID,FOLLOW_BLOCK_ID_in_basic_block805); 

                    String bid = (BLOCK_ID34!=null?BLOCK_ID34.getText():null); bid = bid.trim(); bid = bid.substring(0, bid.length()-1); blockID = bid.trim();

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:169:7: ( phi_op )*
            loop27:
            do {
                int alt27=2;
                switch ( input.LA(1) ) {
                case GLOBAL_VARIABLE:
                    {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==47) ) {
                        int LA27_5 = input.LA(3);

                        if ( (LA27_5==77) ) {
                            alt27=1;
                        }


                    }


                    }
                    break;
                case LOCAL_VARIABLE:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==47) ) {
                        int LA27_5 = input.LA(3);

                        if ( (LA27_5==77) ) {
                            alt27=1;
                        }


                    }


                    }
                    break;
                case UNDEF:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (LA27_3==47) ) {
                        int LA27_5 = input.LA(3);

                        if ( (LA27_5==77) ) {
                            alt27=1;
                        }


                    }


                    }
                    break;

                }

                switch (alt27) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:169:8: phi_op
            	    {
            	    pushFollow(FOLLOW_phi_op_in_basic_block819);
            	    phi_op35=phi_op();

            	    state._fsp--;


            	    Instruction inst1=(phi_op35!=null?phi_op35.inst:null); inst1.setValue((phi_op35!=null?input.toString(phi_op35.start,phi_op35.stop):null)); instructions.add(inst1);

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:170:7: ( operator )*
            loop28:
            do {
                int alt28=2;
                switch ( input.LA(1) ) {
                case GLOBAL_VARIABLE:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==47) ) {
                        int LA28_6 = input.LA(3);

                        if ( (LA28_6==BINARY_OP||LA28_6==CONVERSION_OP||LA28_6==VOLATILE||LA28_6==53||LA28_6==57||(LA28_6 >= 63 && LA28_6 <= 66)||LA28_6==68||(LA28_6 >= 71 && LA28_6 <= 72)||LA28_6==74||(LA28_6 >= 79 && LA28_6 <= 80)||LA28_6==84) ) {
                            alt28=1;
                        }


                    }


                    }
                    break;
                case LOCAL_VARIABLE:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (LA28_3==47) ) {
                        int LA28_6 = input.LA(3);

                        if ( (LA28_6==BINARY_OP||LA28_6==CONVERSION_OP||LA28_6==VOLATILE||LA28_6==53||LA28_6==57||(LA28_6 >= 63 && LA28_6 <= 66)||LA28_6==68||(LA28_6 >= 71 && LA28_6 <= 72)||LA28_6==74||(LA28_6 >= 79 && LA28_6 <= 80)||LA28_6==84) ) {
                            alt28=1;
                        }


                    }


                    }
                    break;
                case UNDEF:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (LA28_4==47) ) {
                        int LA28_6 = input.LA(3);

                        if ( (LA28_6==BINARY_OP||LA28_6==CONVERSION_OP||LA28_6==VOLATILE||LA28_6==53||LA28_6==57||(LA28_6 >= 63 && LA28_6 <= 66)||LA28_6==68||(LA28_6 >= 71 && LA28_6 <= 72)||LA28_6==74||(LA28_6 >= 79 && LA28_6 <= 80)||LA28_6==84) ) {
                            alt28=1;
                        }


                    }


                    }
                    break;
                case VOLATILE:
                case 57:
                case 82:
                case 84:
                    {
                    alt28=1;
                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:170:8: operator
            	    {
            	    pushFollow(FOLLOW_operator_in_basic_block833);
            	    operator36=operator();

            	    state._fsp--;


            	    Instruction inst2=(operator36!=null?operator36.inst:null); inst2.setValue((operator36!=null?input.toString(operator36.start,operator36.stop):null)); instructions.add(inst2);

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            pushFollow(FOLLOW_terminator_in_basic_block846);
            terminator37=terminator();

            state._fsp--;


            Instruction inst3=(terminator37!=null?terminator37.inst:null); inst3.setValue((terminator37!=null?input.toString(terminator37.start,terminator37.stop):null)); instructions.add(inst3);

            }


            basicBlock = valueFactory.createBasicBlock(blockID, instructions);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return basicBlock;
    }
    // $ANTLR end "basic_block"



    // $ANTLR start "align"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:179:1: align returns [int align] : ALIGN INTEGER ;
    public final int align() throws RecognitionException {
        int align = 0;


        Token INTEGER38=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:180:5: ( ALIGN INTEGER )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:180:7: ALIGN INTEGER
            {
            match(input,ALIGN,FOLLOW_ALIGN_in_align874); 

            INTEGER38=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_align876); 

            align = Integer.parseInt((INTEGER38!=null?INTEGER38.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return align;
    }
    // $ANTLR end "align"



    // $ANTLR start "section"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:182:1: section returns [String section] : SECTION STRING ;
    public final String section() throws RecognitionException {
        String section = null;


        Token STRING39=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:183:5: ( SECTION STRING )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:183:7: SECTION STRING
            {
            match(input,SECTION,FOLLOW_SECTION_in_section894); 

            STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_section896); 

            section = (STRING39!=null?STRING39.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return section;
    }
    // $ANTLR end "section"


    public static class terminator_return extends ParserRuleReturnScope {
        public Instruction inst;
    };


    // $ANTLR start "terminator"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:186:1: terminator returns [Instruction inst] : ( ( 'ret' ( VOID | return_type e1= expression ) | UNWIND ) | (t= 'br' (b0= block_label | BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label ) |t= 'switch' it1= INTEGER_TYPE e3= expression ',' b3= block_label '[' (it2= INTEGER_TYPE INTEGER ',' b4= block_label )* ']' |t= 'indirectbr' pointer_type e4= expression ',' '[' b5= block_label ( ',' b6= block_label )* ']' | ( variable '=' )? t= 'invoke' function_call[cconv, pAttributes, types, operands, fAttributes] TO b7= block_label UNWIND b8= block_label |t= 'unreachable' ) );
    public final LLVMParser.terminator_return terminator() throws RecognitionException {
        LLVMParser.terminator_return retval = new LLVMParser.terminator_return();
        retval.start = input.LT(1);


        Token t=null;
        Token it1=null;
        Token it2=null;
        Token VOID40=null;
        Token INTEGER42=null;
        Constant e1 =null;

        Constant b0 =null;

        Constant e2 =null;

        Constant b1 =null;

        Constant b2 =null;

        Constant e3 =null;

        Constant b3 =null;

        Constant b4 =null;

        Constant e4 =null;

        Constant b5 =null;

        Constant b6 =null;

        Constant b7 =null;

        Constant b8 =null;

        Type return_type41 =null;

        Type pointer_type43 =null;

        Constant variable44 =null;



        Constant dest = null;
        int opcode=0;
        List<Constant> operands = new ArrayList<Constant>();
        List<Type> types = new ArrayList<Type>();

        String cconv = null;
        List<String> pAttributes = new ArrayList<String>();
        List<String> fAttributes = new ArrayList<String>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:204:5: ( ( 'ret' ( VOID | return_type e1= expression ) | UNWIND ) | (t= 'br' (b0= block_label | BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label ) |t= 'switch' it1= INTEGER_TYPE e3= expression ',' b3= block_label '[' (it2= INTEGER_TYPE INTEGER ',' b4= block_label )* ']' |t= 'indirectbr' pointer_type e4= expression ',' '[' b5= block_label ( ',' b6= block_label )* ']' | ( variable '=' )? t= 'invoke' function_call[cconv, pAttributes, types, operands, fAttributes] TO b7= block_label UNWIND b8= block_label |t= 'unreachable' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==UNWIND||LA36_0==78) ) {
                alt36=1;
            }
            else if ( (LA36_0==GLOBAL_VARIABLE||LA36_0==LOCAL_VARIABLE||LA36_0==UNDEF||LA36_0==55||LA36_0==70||LA36_0==73||LA36_0==83||LA36_0==90) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:205:5: ( 'ret' ( VOID | return_type e1= expression ) | UNWIND )
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:205:5: ( 'ret' ( VOID | return_type e1= expression ) | UNWIND )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==78) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==UNWIND) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;

                    }
                    switch (alt30) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:205:6: 'ret' ( VOID | return_type e1= expression )
                            {
                            match(input,78,FOLLOW_78_in_terminator929); 

                            opcode = InstType.retInst;

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:205:41: ( VOID | return_type e1= expression )
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( (LA29_0==VOID) ) {
                                switch ( input.LA(2) ) {
                                case BLOCK_ID:
                                case UNWIND:
                                case VOLATILE:
                                case 55:
                                case 57:
                                case 70:
                                case 73:
                                case 78:
                                case 82:
                                case 83:
                                case 84:
                                case 90:
                                case 94:
                                    {
                                    alt29=1;
                                    }
                                    break;
                                case GLOBAL_VARIABLE:
                                    {
                                    int LA29_4 = input.LA(3);

                                    if ( (LA29_4==47) ) {
                                        alt29=1;
                                    }
                                    else if ( (LA29_4==BLOCK_ID||LA29_4==GLOBAL_VARIABLE||LA29_4==LOCAL_VARIABLE||(LA29_4 >= UNDEF && LA29_4 <= UNWIND)||LA29_4==VOLATILE||LA29_4==55||LA29_4==57||LA29_4==70||LA29_4==73||LA29_4==78||(LA29_4 >= 82 && LA29_4 <= 84)||LA29_4==90||LA29_4==94) ) {
                                        alt29=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 29, 4, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                case LOCAL_VARIABLE:
                                    {
                                    int LA29_5 = input.LA(3);

                                    if ( (LA29_5==47) ) {
                                        alt29=1;
                                    }
                                    else if ( (LA29_5==BLOCK_ID||LA29_5==GLOBAL_VARIABLE||LA29_5==LOCAL_VARIABLE||(LA29_5 >= UNDEF && LA29_5 <= UNWIND)||LA29_5==VOLATILE||LA29_5==55||LA29_5==57||LA29_5==70||LA29_5==73||LA29_5==78||(LA29_5 >= 82 && LA29_5 <= 84)||LA29_5==90||LA29_5==94) ) {
                                        alt29=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 29, 5, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                case UNDEF:
                                    {
                                    int LA29_6 = input.LA(3);

                                    if ( (LA29_6==47) ) {
                                        alt29=1;
                                    }
                                    else if ( (LA29_6==BLOCK_ID||LA29_6==GLOBAL_VARIABLE||LA29_6==LOCAL_VARIABLE||(LA29_6 >= UNDEF && LA29_6 <= UNWIND)||LA29_6==VOLATILE||LA29_6==55||LA29_6==57||LA29_6==70||LA29_6==73||LA29_6==78||(LA29_6 >= 82 && LA29_6 <= 84)||LA29_6==90||LA29_6==94) ) {
                                        alt29=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 29, 6, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                case BINARY_OP:
                                case BOOLEAN:
                                case CONVERSION_OP:
                                case FLOATING_POINT:
                                case HEX:
                                case INTEGER:
                                case NULL:
                                case 41:
                                case 65:
                                case 66:
                                case 68:
                                    {
                                    alt29=2;
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 29, 1, input);

                                    throw nvae;

                                }

                            }
                            else if ( (LA29_0==BOOLEAN_TYPE||LA29_0==FLOATING_POINT_TYPE||LA29_0==INTEGER_TYPE||LA29_0==LOCAL_VARIABLE||LA29_0==46||LA29_0==49||LA29_0==89||LA29_0==93) ) {
                                alt29=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 29, 0, input);

                                throw nvae;

                            }
                            switch (alt29) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:205:42: VOID
                                    {
                                    VOID40=(Token)match(input,VOID,FOLLOW_VOID_in_terminator934); 

                                    operands.add(valueFactory.createConstantValue(SimpleConstantValue.voidConst, (VOID40!=null?VOID40.getText():null)));

                                    }
                                    break;
                                case 2 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:206:9: return_type e1= expression
                                    {
                                    pushFollow(FOLLOW_return_type_in_terminator947);
                                    return_type41=return_type();

                                    state._fsp--;


                                    pushFollow(FOLLOW_expression_in_terminator951);
                                    e1=expression();

                                    state._fsp--;


                                    types.add(return_type41); operands.add(e1);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:207:9: UNWIND
                            {
                            match(input,UNWIND,FOLLOW_UNWIND_in_terminator965); 

                            opcode = InstType.unwindInst;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:208:7: (t= 'br' (b0= block_label | BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label ) |t= 'switch' it1= INTEGER_TYPE e3= expression ',' b3= block_label '[' (it2= INTEGER_TYPE INTEGER ',' b4= block_label )* ']' |t= 'indirectbr' pointer_type e4= expression ',' '[' b5= block_label ( ',' b6= block_label )* ']' | ( variable '=' )? t= 'invoke' function_call[cconv, pAttributes, types, operands, fAttributes] TO b7= block_label UNWIND b8= block_label |t= 'unreachable' )
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:208:7: (t= 'br' (b0= block_label | BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label ) |t= 'switch' it1= INTEGER_TYPE e3= expression ',' b3= block_label '[' (it2= INTEGER_TYPE INTEGER ',' b4= block_label )* ']' |t= 'indirectbr' pointer_type e4= expression ',' '[' b5= block_label ( ',' b6= block_label )* ']' | ( variable '=' )? t= 'invoke' function_call[cconv, pAttributes, types, operands, fAttributes] TO b7= block_label UNWIND b8= block_label |t= 'unreachable' )
                    int alt35=5;
                    switch ( input.LA(1) ) {
                    case 55:
                        {
                        alt35=1;
                        }
                        break;
                    case 83:
                        {
                        alt35=2;
                        }
                        break;
                    case 70:
                        {
                        alt35=3;
                        }
                        break;
                    case GLOBAL_VARIABLE:
                    case LOCAL_VARIABLE:
                    case UNDEF:
                    case 73:
                        {
                        alt35=4;
                        }
                        break;
                    case 90:
                        {
                        alt35=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;

                    }

                    switch (alt35) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:208:8: t= 'br' (b0= block_label | BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label )
                            {
                            t=(Token)match(input,55,FOLLOW_55_in_terminator979); 

                            opcode = InstType.brInst;

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:209:14: (b0= block_label | BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label )
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==LABEL) ) {
                                alt31=1;
                            }
                            else if ( (LA31_0==BOOLEAN_TYPE) ) {
                                alt31=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 31, 0, input);

                                throw nvae;

                            }
                            switch (alt31) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:209:15: b0= block_label
                                    {
                                    pushFollow(FOLLOW_block_label_in_terminator999);
                                    b0=block_label();

                                    state._fsp--;


                                    operands.add(b0);

                                    }
                                    break;
                                case 2 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:210:16: BOOLEAN_TYPE e2= expression ',' b1= block_label ',' b2= block_label
                                    {
                                    match(input,BOOLEAN_TYPE,FOLLOW_BOOLEAN_TYPE_in_terminator1019); 

                                    pushFollow(FOLLOW_expression_in_terminator1023);
                                    e2=expression();

                                    state._fsp--;


                                    match(input,44,FOLLOW_44_in_terminator1025); 

                                    pushFollow(FOLLOW_block_label_in_terminator1029);
                                    b1=block_label();

                                    state._fsp--;


                                    match(input,44,FOLLOW_44_in_terminator1031); 

                                    pushFollow(FOLLOW_block_label_in_terminator1035);
                                    b2=block_label();

                                    state._fsp--;


                                    types.add(typeFactory.getIntNType(1)); operands.add(e2);
                                                 operands.add(b1); operands.add(b2);

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:213:7: t= 'switch' it1= INTEGER_TYPE e3= expression ',' b3= block_label '[' (it2= INTEGER_TYPE INTEGER ',' b4= block_label )* ']'
                            {
                            t=(Token)match(input,83,FOLLOW_83_in_terminator1063); 

                            it1=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_terminator1067); 

                            pushFollow(FOLLOW_expression_in_terminator1071);
                            e3=expression();

                            state._fsp--;


                            match(input,44,FOLLOW_44_in_terminator1073); 

                            pushFollow(FOLLOW_block_label_in_terminator1077);
                            b3=block_label();

                            state._fsp--;


                            opcode = InstType.switchInst; 
                                   String n = (it1!=null?it1.getText():null); n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); 
                                   operands.add(e3); operands.add(b3);

                            match(input,49,FOLLOW_49_in_terminator1100); 

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:217:17: (it2= INTEGER_TYPE INTEGER ',' b4= block_label )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==INTEGER_TYPE) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:217:18: it2= INTEGER_TYPE INTEGER ',' b4= block_label
                            	    {
                            	    it2=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_terminator1105); 

                            	    INTEGER42=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_terminator1107); 

                            	    match(input,44,FOLLOW_44_in_terminator1109); 

                            	    pushFollow(FOLLOW_block_label_in_terminator1113);
                            	    b4=block_label();

                            	    state._fsp--;


                            	    n = (it2!=null?it2.getText():null); n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
                            	                 operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, (INTEGER42!=null?INTEGER42.getText():null)));
                            	                 operands.add(b4);

                            	    }
                            	    break;

                            	default :
                            	    break loop32;
                                }
                            } while (true);


                            match(input,50,FOLLOW_50_in_terminator1133); 

                            }
                            break;
                        case 3 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:222:7: t= 'indirectbr' pointer_type e4= expression ',' '[' b5= block_label ( ',' b6= block_label )* ']'
                            {
                            t=(Token)match(input,70,FOLLOW_70_in_terminator1150); 

                            pushFollow(FOLLOW_pointer_type_in_terminator1152);
                            pointer_type43=pointer_type();

                            state._fsp--;


                            pushFollow(FOLLOW_expression_in_terminator1156);
                            e4=expression();

                            state._fsp--;


                            match(input,44,FOLLOW_44_in_terminator1158); 

                            match(input,49,FOLLOW_49_in_terminator1160); 

                            pushFollow(FOLLOW_block_label_in_terminator1164);
                            b5=block_label();

                            state._fsp--;


                            opcode = InstType.indirectBrInst; types.add(pointer_type43); operands.add(e4); operands.add(b5);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:224:14: ( ',' b6= block_label )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==44) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:224:15: ',' b6= block_label
                            	    {
                            	    match(input,44,FOLLOW_44_in_terminator1189); 

                            	    pushFollow(FOLLOW_block_label_in_terminator1193);
                            	    b6=block_label();

                            	    state._fsp--;


                            	    operands.add(b6);

                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);


                            match(input,50,FOLLOW_50_in_terminator1199); 

                            }
                            break;
                        case 4 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:225:7: ( variable '=' )? t= 'invoke' function_call[cconv, pAttributes, types, operands, fAttributes] TO b7= block_label UNWIND b8= block_label
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:225:7: ( variable '=' )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==GLOBAL_VARIABLE||LA34_0==LOCAL_VARIABLE||LA34_0==UNDEF) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:225:8: variable '='
                                    {
                                    pushFollow(FOLLOW_variable_in_terminator1208);
                                    variable44=variable();

                                    state._fsp--;


                                    match(input,47,FOLLOW_47_in_terminator1210); 

                                    dest = variable44;

                                    }
                                    break;

                            }


                            t=(Token)match(input,73,FOLLOW_73_in_terminator1225); 

                            pushFollow(FOLLOW_function_call_in_terminator1227);
                            function_call(cconv, pAttributes, types, operands, fAttributes);

                            state._fsp--;


                            match(input,TO,FOLLOW_TO_in_terminator1242); 

                            pushFollow(FOLLOW_block_label_in_terminator1246);
                            b7=block_label();

                            state._fsp--;


                            match(input,UNWIND,FOLLOW_UNWIND_in_terminator1248); 

                            pushFollow(FOLLOW_block_label_in_terminator1252);
                            b8=block_label();

                            state._fsp--;


                            opcode = InstType.invokeInst; operands.add(b7); operands.add(b8);

                            }
                            break;
                        case 5 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:229:7: t= 'unreachable'
                            {
                            t=(Token)match(input,90,FOLLOW_90_in_terminator1270); 

                            opcode = InstType.unreachableInst;

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);



            if(opcode == InstType.invokeInst){
              retval.inst = instFactory.createCallInst(dest, opcode, operands, types, false, cconv, pAttributes, fAttributes);
            }else{
              retval.inst = instFactory.createSimpleInst(dest, opcode, operands, types);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "terminator"



    // $ANTLR start "block_label"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:232:1: block_label returns [Constant expr] : LABEL LOCAL_VARIABLE ;
    public final Constant block_label() throws RecognitionException {
        Constant expr = null;


        Token LOCAL_VARIABLE45=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:232:36: ( LABEL LOCAL_VARIABLE )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:232:38: LABEL LOCAL_VARIABLE
            {
            match(input,LABEL,FOLLOW_LABEL_in_block_label1293); 

            LOCAL_VARIABLE45=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_block_label1295); 

            expr = valueFactory.createVariable((LOCAL_VARIABLE45!=null?LOCAL_VARIABLE45.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "block_label"


    public static class operator_return extends ParserRuleReturnScope {
        public Instruction inst;
    };


    // $ANTLR start "operator"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:236:1: operator returns [Instruction inst] : (t= binary_op |t= vector_op |t= aggregate_op |t= memory_op |t= conversion_op |t= icmp_op |t= fcmp_op |t= select_op |t= call_op );
    public final LLVMParser.operator_return operator() throws RecognitionException {
        LLVMParser.operator_return retval = new LLVMParser.operator_return();
        retval.start = input.LT(1);


        Instruction t =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:240:5: (t= binary_op |t= vector_op |t= aggregate_op |t= memory_op |t= conversion_op |t= icmp_op |t= fcmp_op |t= select_op |t= call_op )
            int alt37=9;
            switch ( input.LA(1) ) {
            case GLOBAL_VARIABLE:
                {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==47) ) {
                    switch ( input.LA(3) ) {
                    case BINARY_OP:
                        {
                        alt37=1;
                        }
                        break;
                    case VOLATILE:
                    case 53:
                    case 66:
                    case 74:
                        {
                        alt37=4;
                        }
                        break;
                    case CONVERSION_OP:
                        {
                        alt37=5;
                        }
                        break;
                    case 68:
                        {
                        alt37=6;
                        }
                        break;
                    case 65:
                        {
                        alt37=7;
                        }
                        break;
                    case 79:
                        {
                        alt37=8;
                        }
                        break;
                    case 63:
                    case 71:
                    case 80:
                        {
                        alt37=2;
                        }
                        break;
                    case 64:
                    case 72:
                        {
                        alt37=3;
                        }
                        break;
                    case 57:
                    case 84:
                        {
                        alt37=9;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 6, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;

                }
                }
                break;
            case LOCAL_VARIABLE:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==47) ) {
                    switch ( input.LA(3) ) {
                    case BINARY_OP:
                        {
                        alt37=1;
                        }
                        break;
                    case VOLATILE:
                    case 53:
                    case 66:
                    case 74:
                        {
                        alt37=4;
                        }
                        break;
                    case CONVERSION_OP:
                        {
                        alt37=5;
                        }
                        break;
                    case 68:
                        {
                        alt37=6;
                        }
                        break;
                    case 65:
                        {
                        alt37=7;
                        }
                        break;
                    case 79:
                        {
                        alt37=8;
                        }
                        break;
                    case 63:
                    case 71:
                    case 80:
                        {
                        alt37=2;
                        }
                        break;
                    case 64:
                    case 72:
                        {
                        alt37=3;
                        }
                        break;
                    case 57:
                    case 84:
                        {
                        alt37=9;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 6, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;

                }
                }
                break;
            case UNDEF:
                {
                int LA37_3 = input.LA(2);

                if ( (LA37_3==47) ) {
                    switch ( input.LA(3) ) {
                    case BINARY_OP:
                        {
                        alt37=1;
                        }
                        break;
                    case VOLATILE:
                    case 53:
                    case 66:
                    case 74:
                        {
                        alt37=4;
                        }
                        break;
                    case CONVERSION_OP:
                        {
                        alt37=5;
                        }
                        break;
                    case 68:
                        {
                        alt37=6;
                        }
                        break;
                    case 65:
                        {
                        alt37=7;
                        }
                        break;
                    case 79:
                        {
                        alt37=8;
                        }
                        break;
                    case 63:
                    case 71:
                    case 80:
                        {
                        alt37=2;
                        }
                        break;
                    case 64:
                    case 72:
                        {
                        alt37=3;
                        }
                        break;
                    case 57:
                    case 84:
                        {
                        alt37=9;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 6, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 3, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
            case 82:
                {
                alt37=4;
                }
                break;
            case 57:
            case 84:
                {
                alt37=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:240:7: t= binary_op
                    {
                    pushFollow(FOLLOW_binary_op_in_operator1321);
                    t=binary_op();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:241:7: t= vector_op
                    {
                    pushFollow(FOLLOW_vector_op_in_operator1332);
                    t=vector_op();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:242:7: t= aggregate_op
                    {
                    pushFollow(FOLLOW_aggregate_op_in_operator1342);
                    t=aggregate_op();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:243:7: t= memory_op
                    {
                    pushFollow(FOLLOW_memory_op_in_operator1352);
                    t=memory_op();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:244:7: t= conversion_op
                    {
                    pushFollow(FOLLOW_conversion_op_in_operator1362);
                    t=conversion_op();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:245:7: t= icmp_op
                    {
                    pushFollow(FOLLOW_icmp_op_in_operator1372);
                    t=icmp_op();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:246:7: t= fcmp_op
                    {
                    pushFollow(FOLLOW_fcmp_op_in_operator1383);
                    t=fcmp_op();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:247:7: t= select_op
                    {
                    pushFollow(FOLLOW_select_op_in_operator1394);
                    t=select_op();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:248:7: t= call_op
                    {
                    pushFollow(FOLLOW_call_op_in_operator1405);
                    t=call_op();

                    state._fsp--;


                    }
                    break;

            }
            retval.stop = input.LT(-1);



            retval.inst = t;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operator"



    // $ANTLR start "binary_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:252:1: binary_op returns [Instruction inst] : variable '=' BINARY_OP ( 'nuw' )? ( 'nsw' )? ( 'exact' )? ( element_type | vector_type ) e1= expression ',' e2= expression ;
    public final Instruction binary_op() throws RecognitionException {
        Instruction inst = null;


        Token BINARY_OP47=null;
        Constant e1 =null;

        Constant e2 =null;

        Constant variable46 =null;

        Type element_type48 =null;



        Constant dest;
        int opcode=InstType.binaryInst;
        String op;
        String nuw = null;
        String nsw = null;
        String exact = null;
        List<Constant> operands= new ArrayList<Constant>();
        List<Type> types = new ArrayList<Type>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:266:5: ( variable '=' BINARY_OP ( 'nuw' )? ( 'nsw' )? ( 'exact' )? ( element_type | vector_type ) e1= expression ',' e2= expression )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:267:7: variable '=' BINARY_OP ( 'nuw' )? ( 'nsw' )? ( 'exact' )? ( element_type | vector_type ) e1= expression ',' e2= expression
            {
            pushFollow(FOLLOW_variable_in_binary_op1442);
            variable46=variable();

            state._fsp--;


            dest = variable46;

            match(input,47,FOLLOW_47_in_binary_op1452); 

            BINARY_OP47=(Token)match(input,BINARY_OP,FOLLOW_BINARY_OP_in_binary_op1454); 

            op = (BINARY_OP47!=null?BINARY_OP47.getText():null);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:269:7: ( 'nuw' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==76) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:269:8: 'nuw'
                    {
                    match(input,76,FOLLOW_76_in_binary_op1465); 

                    nuw = "nuw";

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:269:31: ( 'nsw' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==75) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:269:32: 'nsw'
                    {
                    match(input,75,FOLLOW_75_in_binary_op1472); 

                    nsw = "nsw";

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:269:55: ( 'exact' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==62) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:269:56: 'exact'
                    {
                    match(input,62,FOLLOW_62_in_binary_op1479); 

                    exact = "exact";

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:270:7: ( element_type | vector_type )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==BOOLEAN_TYPE||LA41_0==FLOATING_POINT_TYPE||LA41_0==INTEGER_TYPE||LA41_0==LOCAL_VARIABLE) ) {
                alt41=1;
            }
            else if ( (LA41_0==46) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:270:8: element_type
                    {
                    pushFollow(FOLLOW_element_type_in_binary_op1493);
                    element_type48=element_type();

                    state._fsp--;


                    types.add(element_type48);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:270:55: vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_binary_op1498);
                    vector_type();

                    state._fsp--;


                    types.add(element_type48);

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_binary_op1514);
            e1=expression();

            state._fsp--;


            operands.add(e1);

            match(input,44,FOLLOW_44_in_binary_op1517); 

            pushFollow(FOLLOW_expression_in_binary_op1523);
            e2=expression();

            state._fsp--;


            operands.add(e2);

            }


            inst = instFactory.createBinaryInst(dest, opcode, operands, types, op, nuw, nsw, exact);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "binary_op"



    // $ANTLR start "vector_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:274:1: vector_op returns [Instruction inst] : v0= variable '=' ( 'extractelement' vt1= vector_type v1= variable ',' it1= INTEGER_TYPE e1= expression | 'insertelement' vt2= vector_type v2= variable ',' et1= element_type e2= expression ',' it2= INTEGER_TYPE e3= expression | 'shufflevector' vt3= vector_type v3= variable ',' vt4= vector_type v4= variable ',' vt5= vector_type '<' it3= INTEGER_TYPE i1= INTEGER ( ',' it4= INTEGER_TYPE i2= INTEGER )* '>' ) ;
    public final Instruction vector_op() throws RecognitionException {
        Instruction inst = null;


        Token it1=null;
        Token it2=null;
        Token it3=null;
        Token i1=null;
        Token it4=null;
        Token i2=null;
        Constant v0 =null;

        Type vt1 =null;

        Constant v1 =null;

        Constant e1 =null;

        Type vt2 =null;

        Constant v2 =null;

        Type et1 =null;

        Constant e2 =null;

        Constant e3 =null;

        Type vt3 =null;

        Constant v3 =null;

        Type vt4 =null;

        Constant v4 =null;

        Type vt5 =null;



        int opcode=0;
        Constant dest;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:284:5: (v0= variable '=' ( 'extractelement' vt1= vector_type v1= variable ',' it1= INTEGER_TYPE e1= expression | 'insertelement' vt2= vector_type v2= variable ',' et1= element_type e2= expression ',' it2= INTEGER_TYPE e3= expression | 'shufflevector' vt3= vector_type v3= variable ',' vt4= vector_type v4= variable ',' vt5= vector_type '<' it3= INTEGER_TYPE i1= INTEGER ( ',' it4= INTEGER_TYPE i2= INTEGER )* '>' ) )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:284:7: v0= variable '=' ( 'extractelement' vt1= vector_type v1= variable ',' it1= INTEGER_TYPE e1= expression | 'insertelement' vt2= vector_type v2= variable ',' et1= element_type e2= expression ',' it2= INTEGER_TYPE e3= expression | 'shufflevector' vt3= vector_type v3= variable ',' vt4= vector_type v4= variable ',' vt5= vector_type '<' it3= INTEGER_TYPE i1= INTEGER ( ',' it4= INTEGER_TYPE i2= INTEGER )* '>' )
            {
            pushFollow(FOLLOW_variable_in_vector_op1554);
            v0=variable();

            state._fsp--;


            dest = v0;

            match(input,47,FOLLOW_47_in_vector_op1557); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:285:6: ( 'extractelement' vt1= vector_type v1= variable ',' it1= INTEGER_TYPE e1= expression | 'insertelement' vt2= vector_type v2= variable ',' et1= element_type e2= expression ',' it2= INTEGER_TYPE e3= expression | 'shufflevector' vt3= vector_type v3= variable ',' vt4= vector_type v4= variable ',' vt5= vector_type '<' it3= INTEGER_TYPE i1= INTEGER ( ',' it4= INTEGER_TYPE i2= INTEGER )* '>' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt43=1;
                }
                break;
            case 71:
                {
                alt43=2;
                }
                break;
            case 80:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:285:7: 'extractelement' vt1= vector_type v1= variable ',' it1= INTEGER_TYPE e1= expression
                    {
                    match(input,63,FOLLOW_63_in_vector_op1566); 

                    pushFollow(FOLLOW_vector_type_in_vector_op1570);
                    vt1=vector_type();

                    state._fsp--;


                    pushFollow(FOLLOW_variable_in_vector_op1574);
                    v1=variable();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_vector_op1576); 

                    it1=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_vector_op1580); 

                    pushFollow(FOLLOW_expression_in_vector_op1584);
                    e1=expression();

                    state._fsp--;


                    opcode = InstType.extractEleInst; 
                            types.add(vt1); operands.add(v1); 
                            String n = (it1!=null?it1.getText():null); n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); operands.add(e1);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:289:7: 'insertelement' vt2= vector_type v2= variable ',' et1= element_type e2= expression ',' it2= INTEGER_TYPE e3= expression
                    {
                    match(input,71,FOLLOW_71_in_vector_op1603); 

                    pushFollow(FOLLOW_vector_type_in_vector_op1607);
                    vt2=vector_type();

                    state._fsp--;


                    pushFollow(FOLLOW_variable_in_vector_op1611);
                    v2=variable();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_vector_op1613); 

                    pushFollow(FOLLOW_element_type_in_vector_op1617);
                    et1=element_type();

                    state._fsp--;


                    pushFollow(FOLLOW_expression_in_vector_op1621);
                    e2=expression();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_vector_op1623); 

                    it2=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_vector_op1627); 

                    pushFollow(FOLLOW_expression_in_vector_op1631);
                    e3=expression();

                    state._fsp--;


                    opcode = InstType.insertEleInst; 
                            types.add(vt2); operands.add(v2); 
                            types.add(et1); operands.add(e2);
                            String n = (it2!=null?it2.getText():null); n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); operands.add(e3);

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:294:7: 'shufflevector' vt3= vector_type v3= variable ',' vt4= vector_type v4= variable ',' vt5= vector_type '<' it3= INTEGER_TYPE i1= INTEGER ( ',' it4= INTEGER_TYPE i2= INTEGER )* '>'
                    {
                    match(input,80,FOLLOW_80_in_vector_op1649); 

                    pushFollow(FOLLOW_vector_type_in_vector_op1653);
                    vt3=vector_type();

                    state._fsp--;


                    pushFollow(FOLLOW_variable_in_vector_op1657);
                    v3=variable();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_vector_op1659); 

                    pushFollow(FOLLOW_vector_type_in_vector_op1663);
                    vt4=vector_type();

                    state._fsp--;


                    pushFollow(FOLLOW_variable_in_vector_op1667);
                    v4=variable();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_vector_op1669); 

                    pushFollow(FOLLOW_vector_type_in_vector_op1673);
                    vt5=vector_type();

                    state._fsp--;


                    opcode = InstType.shuffleVecInst;
                            types.add(vt3); operands.add(v3);
                            types.add(vt4); operands.add(v4);
                            types.add(vt5);

                    match(input,46,FOLLOW_46_in_vector_op1693); 

                    it3=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_vector_op1697); 

                    i1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_vector_op1701); 

                    String n = (it3!=null?it3.getText():null); n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
                            operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, (i1!=null?i1.getText():null)));

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:302:8: ( ',' it4= INTEGER_TYPE i2= INTEGER )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==44) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:302:9: ',' it4= INTEGER_TYPE i2= INTEGER
                    	    {
                    	    match(input,44,FOLLOW_44_in_vector_op1722); 

                    	    it4=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_vector_op1726); 

                    	    i2=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_vector_op1730); 

                    	    String n2 = (it4!=null?it4.getText():null); n2=n2.substring(1,n2.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n2)));
                    	            operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, (i2!=null?i2.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    match(input,48,FOLLOW_48_in_vector_op1752); 

                    }
                    break;

            }


            }


            inst = instFactory.createSimpleInst(dest, opcode, operands, types);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "vector_op"



    // $ANTLR start "aggregate_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:309:1: aggregate_op returns [Instruction inst] : v0= variable '=' ( 'extractvalue' at1= aggregate_type v1= variable ',' i1= index ( ',' i2= index )* | 'insertvalue' at2= aggregate_type v2= variable ',' dt1= derived_type e1= expression ',' i3= index ) ;
    public final Instruction aggregate_op() throws RecognitionException {
        Instruction inst = null;


        Constant v0 =null;

        Type at1 =null;

        Constant v1 =null;

        Constant i1 =null;

        Constant i2 =null;

        Type at2 =null;

        Constant v2 =null;

        Type dt1 =null;

        Constant e1 =null;

        Constant i3 =null;



        int opcode=0;
        Constant dest;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:319:5: (v0= variable '=' ( 'extractvalue' at1= aggregate_type v1= variable ',' i1= index ( ',' i2= index )* | 'insertvalue' at2= aggregate_type v2= variable ',' dt1= derived_type e1= expression ',' i3= index ) )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:319:7: v0= variable '=' ( 'extractvalue' at1= aggregate_type v1= variable ',' i1= index ( ',' i2= index )* | 'insertvalue' at2= aggregate_type v2= variable ',' dt1= derived_type e1= expression ',' i3= index )
            {
            pushFollow(FOLLOW_variable_in_aggregate_op1786);
            v0=variable();

            state._fsp--;


            dest = v0;

            match(input,47,FOLLOW_47_in_aggregate_op1789); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:320:6: ( 'extractvalue' at1= aggregate_type v1= variable ',' i1= index ( ',' i2= index )* | 'insertvalue' at2= aggregate_type v2= variable ',' dt1= derived_type e1= expression ',' i3= index )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==64) ) {
                alt45=1;
            }
            else if ( (LA45_0==72) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:320:7: 'extractvalue' at1= aggregate_type v1= variable ',' i1= index ( ',' i2= index )*
                    {
                    match(input,64,FOLLOW_64_in_aggregate_op1798); 

                    pushFollow(FOLLOW_aggregate_type_in_aggregate_op1802);
                    at1=aggregate_type();

                    state._fsp--;


                    pushFollow(FOLLOW_variable_in_aggregate_op1806);
                    v1=variable();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_aggregate_op1808); 

                    pushFollow(FOLLOW_index_in_aggregate_op1812);
                    i1=index();

                    state._fsp--;


                    opcode = InstType.extractValInst; types.add(at1); operands.add(v1); operands.add(i1);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:322:6: ( ',' i2= index )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==44) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:322:7: ',' i2= index
                    	    {
                    	    match(input,44,FOLLOW_44_in_aggregate_op1828); 

                    	    pushFollow(FOLLOW_index_in_aggregate_op1832);
                    	    i2=index();

                    	    state._fsp--;


                    	    operands.add(i2);

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:323:7: 'insertvalue' at2= aggregate_type v2= variable ',' dt1= derived_type e1= expression ',' i3= index
                    {
                    match(input,72,FOLLOW_72_in_aggregate_op1844); 

                    pushFollow(FOLLOW_aggregate_type_in_aggregate_op1848);
                    at2=aggregate_type();

                    state._fsp--;


                    pushFollow(FOLLOW_variable_in_aggregate_op1852);
                    v2=variable();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_aggregate_op1854); 

                    pushFollow(FOLLOW_derived_type_in_aggregate_op1858);
                    dt1=derived_type();

                    state._fsp--;


                    pushFollow(FOLLOW_expression_in_aggregate_op1862);
                    e1=expression();

                    state._fsp--;


                    match(input,44,FOLLOW_44_in_aggregate_op1864); 

                    pushFollow(FOLLOW_index_in_aggregate_op1868);
                    i3=index();

                    state._fsp--;


                    opcode = InstType.insertValInst; types.add(at2); operands.add(v2); types.add(dt1); operands.add(e1); operands.add(i3);

                    }
                    break;

            }


            }


            inst = instFactory.createSimpleInst(dest, opcode, operands, types);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "aggregate_op"



    // $ANTLR start "memory_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:328:1: memory_op returns [Instruction inst] : ( getelementptr_op | alloca_op | load_op | store_op );
    public final Instruction memory_op() throws RecognitionException {
        Instruction inst = null;


        Instruction getelementptr_op49 =null;

        Instruction alloca_op50 =null;

        Instruction load_op51 =null;

        Instruction store_op52 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:329:5: ( getelementptr_op | alloca_op | load_op | store_op )
            int alt46=4;
            switch ( input.LA(1) ) {
            case GLOBAL_VARIABLE:
                {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==47) ) {
                    switch ( input.LA(3) ) {
                    case 66:
                        {
                        alt46=1;
                        }
                        break;
                    case 53:
                        {
                        alt46=2;
                        }
                        break;
                    case VOLATILE:
                    case 74:
                        {
                        alt46=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 5, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;

                }
                }
                break;
            case LOCAL_VARIABLE:
                {
                int LA46_2 = input.LA(2);

                if ( (LA46_2==47) ) {
                    switch ( input.LA(3) ) {
                    case 66:
                        {
                        alt46=1;
                        }
                        break;
                    case 53:
                        {
                        alt46=2;
                        }
                        break;
                    case VOLATILE:
                    case 74:
                        {
                        alt46=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 5, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;

                }
                }
                break;
            case UNDEF:
                {
                int LA46_3 = input.LA(2);

                if ( (LA46_3==47) ) {
                    switch ( input.LA(3) ) {
                    case 66:
                        {
                        alt46=1;
                        }
                        break;
                    case 53:
                        {
                        alt46=2;
                        }
                        break;
                    case VOLATILE:
                    case 74:
                        {
                        alt46=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 5, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 3, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
            case 82:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:329:7: getelementptr_op
                    {
                    pushFollow(FOLLOW_getelementptr_op_in_memory_op1899);
                    getelementptr_op49=getelementptr_op();

                    state._fsp--;


                    inst = getelementptr_op49;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:330:7: alloca_op
                    {
                    pushFollow(FOLLOW_alloca_op_in_memory_op1909);
                    alloca_op50=alloca_op();

                    state._fsp--;


                    inst = alloca_op50;

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:331:7: load_op
                    {
                    pushFollow(FOLLOW_load_op_in_memory_op1919);
                    load_op51=load_op();

                    state._fsp--;


                    inst = load_op51;

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:332:7: store_op
                    {
                    pushFollow(FOLLOW_store_op_in_memory_op1929);
                    store_op52=store_op();

                    state._fsp--;


                    inst = store_op52;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "memory_op"



    // $ANTLR start "alloca_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:334:1: alloca_op returns [Instruction inst] : variable '=' 'alloca' t1= derived_type ( ',' t2= derived_type index )? ( ',' align )? ;
    public final Instruction alloca_op() throws RecognitionException {
        Instruction inst = null;


        Type t1 =null;

        Type t2 =null;

        Constant variable53 =null;

        Constant index54 =null;

        int align55 =0;



        Constant dest;
        int opcode=0;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:344:5: ( variable '=' 'alloca' t1= derived_type ( ',' t2= derived_type index )? ( ',' align )? )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:344:8: variable '=' 'alloca' t1= derived_type ( ',' t2= derived_type index )? ( ',' align )?
            {
            pushFollow(FOLLOW_variable_in_alloca_op1956);
            variable53=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_alloca_op1958); 

            match(input,53,FOLLOW_53_in_alloca_op1960); 

            pushFollow(FOLLOW_derived_type_in_alloca_op1964);
            t1=derived_type();

            state._fsp--;


            dest = variable53; opcode = InstType.allocaInst; types.add(t1);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:346:5: ( ',' t2= derived_type index )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==44) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==BOOLEAN_TYPE||LA47_1==FLOATING_POINT_TYPE||(LA47_1 >= INTEGER_TYPE && LA47_1 <= LABEL)||(LA47_1 >= LOCAL_VARIABLE && LA47_1 <= METADATA)||LA47_1==OPAQUE||LA47_1==VOID||LA47_1==46||LA47_1==49||LA47_1==89||LA47_1==93) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:346:6: ',' t2= derived_type index
                    {
                    match(input,44,FOLLOW_44_in_alloca_op1980); 

                    pushFollow(FOLLOW_derived_type_in_alloca_op1984);
                    t2=derived_type();

                    state._fsp--;


                    pushFollow(FOLLOW_index_in_alloca_op1986);
                    index54=index();

                    state._fsp--;


                    types.add(t2); operands.add(index54);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:347:5: ( ',' align )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==44) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:347:6: ',' align
                    {
                    match(input,44,FOLLOW_44_in_alloca_op1998); 

                    pushFollow(FOLLOW_align_in_alloca_op2000);
                    align55=align();

                    state._fsp--;


                    operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, align55 + ""));

                    }
                    break;

            }


            }


            inst = instFactory.createSimpleInst(dest, opcode, operands, types);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "alloca_op"



    // $ANTLR start "load_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:350:1: load_op returns [Instruction inst] : variable '=' ( VOLATILE )? 'load' pointer_type expression ( ',' align )? ;
    public final Instruction load_op() throws RecognitionException {
        Instruction inst = null;


        Constant variable56 =null;

        Type pointer_type57 =null;

        Constant expression58 =null;

        int align59 =0;



        Constant dest;
        int opcode;
        boolean isVolatile = false;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:361:5: ( variable '=' ( VOLATILE )? 'load' pointer_type expression ( ',' align )? )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:361:7: variable '=' ( VOLATILE )? 'load' pointer_type expression ( ',' align )?
            {
            pushFollow(FOLLOW_variable_in_load_op2033);
            variable56=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_load_op2035); 

            dest = variable56; opcode = InstType.loadInst;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:362:7: ( VOLATILE )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==VOLATILE) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:362:8: VOLATILE
                    {
                    match(input,VOLATILE,FOLLOW_VOLATILE_in_load_op2046); 

                    isVolatile = true;

                    }
                    break;

            }


            match(input,74,FOLLOW_74_in_load_op2052); 

            pushFollow(FOLLOW_pointer_type_in_load_op2061);
            pointer_type57=pointer_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_load_op2063);
            expression58=expression();

            state._fsp--;


            types.add(pointer_type57); operands.add(expression58);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:365:7: ( ',' align )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==44) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:365:8: ',' align
                    {
                    match(input,44,FOLLOW_44_in_load_op2081); 

                    pushFollow(FOLLOW_align_in_load_op2083);
                    align59=align();

                    state._fsp--;


                    operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, align59 + ""));

                    }
                    break;

            }


            }


            inst = instFactory.createLoadStoreInst(dest, opcode, operands, types, isVolatile);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "load_op"



    // $ANTLR start "store_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:368:1: store_op returns [Instruction inst] : ( VOLATILE )? 'store' t1= first_class_type e1= expression ',' t2= pointer_type e2= expression ( ',' align )? ;
    public final Instruction store_op() throws RecognitionException {
        Instruction inst = null;


        Type t1 =null;

        Constant e1 =null;

        Type t2 =null;

        Constant e2 =null;

        int align60 =0;



        Constant dest = null;
        int opcode;
        boolean isVolatile = false;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:379:5: ( ( VOLATILE )? 'store' t1= first_class_type e1= expression ',' t2= pointer_type e2= expression ( ',' align )? )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:379:7: ( VOLATILE )? 'store' t1= first_class_type e1= expression ',' t2= pointer_type e2= expression ( ',' align )?
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:379:7: ( VOLATILE )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==VOLATILE) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:379:8: VOLATILE
                    {
                    match(input,VOLATILE,FOLLOW_VOLATILE_in_store_op2118); 

                    isVolatile=true;

                    }
                    break;

            }


            match(input,82,FOLLOW_82_in_store_op2124); 

            opcode = InstType.storeInst;

            pushFollow(FOLLOW_first_class_type_in_store_op2139);
            t1=first_class_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_store_op2143);
            e1=expression();

            state._fsp--;


            types.add(t1); operands.add(e1);

            match(input,44,FOLLOW_44_in_store_op2146); 

            pushFollow(FOLLOW_pointer_type_in_store_op2155);
            t2=pointer_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_store_op2159);
            e2=expression();

            state._fsp--;


            types.add(t2); operands.add(e2);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:383:5: ( ',' align )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:383:6: ',' align
                    {
                    match(input,44,FOLLOW_44_in_store_op2168); 

                    pushFollow(FOLLOW_align_in_store_op2170);
                    align60=align();

                    state._fsp--;


                    operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, align60 + ""));

                    }
                    break;

            }


            }


            inst = instFactory.createLoadStoreInst(dest, opcode, operands, types, isVolatile);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "store_op"



    // $ANTLR start "getelementptr_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:386:1: getelementptr_op returns [Instruction inst] : variable '=' 'getelementptr' ( 'inbounds' )? pointer_type expression ( ',' INTEGER_TYPE index )+ ;
    public final Instruction getelementptr_op() throws RecognitionException {
        Instruction inst = null;


        Token INTEGER_TYPE64=null;
        Constant variable61 =null;

        Type pointer_type62 =null;

        Constant expression63 =null;

        Constant index65 =null;



        Constant dest;
        int opcode = InstType.getElePtrInst;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();
        boolean inbounds = false;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:397:5: ( variable '=' 'getelementptr' ( 'inbounds' )? pointer_type expression ( ',' INTEGER_TYPE index )+ )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:397:7: variable '=' 'getelementptr' ( 'inbounds' )? pointer_type expression ( ',' INTEGER_TYPE index )+
            {
            pushFollow(FOLLOW_variable_in_getelementptr_op2203);
            variable61=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_getelementptr_op2205); 

            match(input,66,FOLLOW_66_in_getelementptr_op2207); 

            dest = variable61;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:398:5: ( 'inbounds' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==69) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:398:6: 'inbounds'
                    {
                    match(input,69,FOLLOW_69_in_getelementptr_op2216); 

                    inbounds = true;

                    }
                    break;

            }


            pushFollow(FOLLOW_pointer_type_in_getelementptr_op2227);
            pointer_type62=pointer_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_getelementptr_op2229);
            expression63=expression();

            state._fsp--;


            types.add(pointer_type62); operands.add(expression63);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:400:5: ( ',' INTEGER_TYPE index )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==44) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:400:6: ',' INTEGER_TYPE index
            	    {
            	    match(input,44,FOLLOW_44_in_getelementptr_op2238); 

            	    INTEGER_TYPE64=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_getelementptr_op2240); 

            	    pushFollow(FOLLOW_index_in_getelementptr_op2242);
            	    index65=index();

            	    state._fsp--;


            	    String n = (INTEGER_TYPE64!=null?INTEGER_TYPE64.getText():null); n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
            	        operands.add(index65);

            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);


            }


            inst = instFactory.createGetElePtrInst(dest, opcode, operands, types, inbounds);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "getelementptr_op"



    // $ANTLR start "conversion_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:407:1: conversion_op returns [Instruction inst] : variable '=' CONVERSION_OP t1= scalar_type expression TO t2= scalar_type ;
    public final Instruction conversion_op() throws RecognitionException {
        Instruction inst = null;


        Token CONVERSION_OP67=null;
        Type t1 =null;

        Type t2 =null;

        Constant variable66 =null;

        Constant expression68 =null;



        Constant dest;
        String converOp;
        int opcode = InstType.converInst;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:418:5: ( variable '=' CONVERSION_OP t1= scalar_type expression TO t2= scalar_type )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:418:7: variable '=' CONVERSION_OP t1= scalar_type expression TO t2= scalar_type
            {
            pushFollow(FOLLOW_variable_in_conversion_op2294);
            variable66=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_conversion_op2296); 

            CONVERSION_OP67=(Token)match(input,CONVERSION_OP,FOLLOW_CONVERSION_OP_in_conversion_op2298); 

            pushFollow(FOLLOW_scalar_type_in_conversion_op2302);
            t1=scalar_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_conversion_op2304);
            expression68=expression();

            state._fsp--;


            match(input,TO,FOLLOW_TO_in_conversion_op2306); 

            pushFollow(FOLLOW_scalar_type_in_conversion_op2310);
            t2=scalar_type();

            state._fsp--;


            dest = variable66; converOp=(CONVERSION_OP67!=null?CONVERSION_OP67.getText():null); types.add(t1); types.add(t2); operands.add(expression68);

            }


            inst = instFactory.createOperationInst(dest, opcode, operands, types, converOp);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "conversion_op"



    // $ANTLR start "icmp_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:424:1: icmp_op returns [Instruction inst] : variable '=' 'icmp' ( ICMP_COND | CMP_COND ) ( scalar_type | vector_type ) e1= expression ',' e2= expression ;
    public final Instruction icmp_op() throws RecognitionException {
        Instruction inst = null;


        Token ICMP_COND70=null;
        Token CMP_COND71=null;
        Constant e1 =null;

        Constant e2 =null;

        Constant variable69 =null;

        Type scalar_type72 =null;

        Type vector_type73 =null;



        Constant dest;
        int opcode = InstType.icmpInst;
        String cond=null;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:435:5: ( variable '=' 'icmp' ( ICMP_COND | CMP_COND ) ( scalar_type | vector_type ) e1= expression ',' e2= expression )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:435:7: variable '=' 'icmp' ( ICMP_COND | CMP_COND ) ( scalar_type | vector_type ) e1= expression ',' e2= expression
            {
            pushFollow(FOLLOW_variable_in_icmp_op2349);
            variable69=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_icmp_op2351); 

            match(input,68,FOLLOW_68_in_icmp_op2353); 

            dest = variable69;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:437:7: ( ICMP_COND | CMP_COND )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==ICMP_COND) ) {
                alt55=1;
            }
            else if ( (LA55_0==CMP_COND) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:437:8: ICMP_COND
                    {
                    ICMP_COND70=(Token)match(input,ICMP_COND,FOLLOW_ICMP_COND_in_icmp_op2371); 

                    cond = (ICMP_COND70!=null?ICMP_COND70.getText():null);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:437:45: CMP_COND
                    {
                    CMP_COND71=(Token)match(input,CMP_COND,FOLLOW_CMP_COND_in_icmp_op2376); 

                    cond = (CMP_COND71!=null?CMP_COND71.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:438:7: ( scalar_type | vector_type )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==BOOLEAN_TYPE||LA56_0==FLOATING_POINT_TYPE||LA56_0==INTEGER_TYPE||LA56_0==LOCAL_VARIABLE||LA56_0==VOID||LA56_0==49||LA56_0==89||LA56_0==93) ) {
                alt56=1;
            }
            else if ( (LA56_0==46) ) {
                int LA56_2 = input.LA(2);

                if ( (LA56_2==93) ) {
                    alt56=1;
                }
                else if ( (LA56_2==INTEGER) ) {
                    int LA56_3 = input.LA(3);

                    if ( (LA56_3==91) ) {
                        switch ( input.LA(4) ) {
                        case BOOLEAN_TYPE:
                            {
                            int LA56_5 = input.LA(5);

                            if ( (LA56_5==48) ) {
                                int LA56_9 = input.LA(6);

                                if ( (LA56_9==43) ) {
                                    alt56=1;
                                }
                                else if ( (LA56_9==BINARY_OP||LA56_9==BOOLEAN||LA56_9==CONVERSION_OP||LA56_9==FLOATING_POINT||(LA56_9 >= GLOBAL_VARIABLE && LA56_9 <= HEX)||LA56_9==INTEGER||LA56_9==LOCAL_VARIABLE||LA56_9==NULL||LA56_9==UNDEF||(LA56_9 >= 65 && LA56_9 <= 66)||LA56_9==68) ) {
                                    alt56=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 56, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case INTEGER_TYPE:
                            {
                            int LA56_6 = input.LA(5);

                            if ( (LA56_6==48) ) {
                                int LA56_9 = input.LA(6);

                                if ( (LA56_9==43) ) {
                                    alt56=1;
                                }
                                else if ( (LA56_9==BINARY_OP||LA56_9==BOOLEAN||LA56_9==CONVERSION_OP||LA56_9==FLOATING_POINT||(LA56_9 >= GLOBAL_VARIABLE && LA56_9 <= HEX)||LA56_9==INTEGER||LA56_9==LOCAL_VARIABLE||LA56_9==NULL||LA56_9==UNDEF||(LA56_9 >= 65 && LA56_9 <= 66)||LA56_9==68) ) {
                                    alt56=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 56, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case FLOATING_POINT_TYPE:
                            {
                            int LA56_7 = input.LA(5);

                            if ( (LA56_7==48) ) {
                                int LA56_9 = input.LA(6);

                                if ( (LA56_9==43) ) {
                                    alt56=1;
                                }
                                else if ( (LA56_9==BINARY_OP||LA56_9==BOOLEAN||LA56_9==CONVERSION_OP||LA56_9==FLOATING_POINT||(LA56_9 >= GLOBAL_VARIABLE && LA56_9 <= HEX)||LA56_9==INTEGER||LA56_9==LOCAL_VARIABLE||LA56_9==NULL||LA56_9==UNDEF||(LA56_9 >= 65 && LA56_9 <= 66)||LA56_9==68) ) {
                                    alt56=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 56, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        case LOCAL_VARIABLE:
                            {
                            int LA56_8 = input.LA(5);

                            if ( (LA56_8==48) ) {
                                int LA56_9 = input.LA(6);

                                if ( (LA56_9==43) ) {
                                    alt56=1;
                                }
                                else if ( (LA56_9==BINARY_OP||LA56_9==BOOLEAN||LA56_9==CONVERSION_OP||LA56_9==FLOATING_POINT||(LA56_9 >= GLOBAL_VARIABLE && LA56_9 <= HEX)||LA56_9==INTEGER||LA56_9==LOCAL_VARIABLE||LA56_9==NULL||LA56_9==UNDEF||(LA56_9 >= 65 && LA56_9 <= 66)||LA56_9==68) ) {
                                    alt56=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 56, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 8, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 56, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:438:8: scalar_type
                    {
                    pushFollow(FOLLOW_scalar_type_in_icmp_op2389);
                    scalar_type72=scalar_type();

                    state._fsp--;


                    types.add(scalar_type72);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:438:53: vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_icmp_op2394);
                    vector_type73=vector_type();

                    state._fsp--;


                    types.add(vector_type73);

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_icmp_op2410);
            e1=expression();

            state._fsp--;


            match(input,44,FOLLOW_44_in_icmp_op2412); 

            pushFollow(FOLLOW_expression_in_icmp_op2418);
            e2=expression();

            state._fsp--;


            operands.add(e1); operands.add(e2);

            }


            inst = instFactory.createCmpInst(dest, opcode, operands, types, cond);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "icmp_op"



    // $ANTLR start "fcmp_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:441:1: fcmp_op returns [Instruction inst] : variable '=' 'fcmp' ( FCMP_COND | CMP_COND | BOOLEAN ) ( scalar_type | vector_type ) e1= expression ',' e2= expression ;
    public final Instruction fcmp_op() throws RecognitionException {
        Instruction inst = null;


        Token FCMP_COND75=null;
        Token CMP_COND76=null;
        Token BOOLEAN77=null;
        Constant e1 =null;

        Constant e2 =null;

        Constant variable74 =null;

        Type scalar_type78 =null;

        Type vector_type79 =null;



        Constant dest;
        int opcode = InstType.fcmpInst;
        String cond=null;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:452:5: ( variable '=' 'fcmp' ( FCMP_COND | CMP_COND | BOOLEAN ) ( scalar_type | vector_type ) e1= expression ',' e2= expression )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:452:7: variable '=' 'fcmp' ( FCMP_COND | CMP_COND | BOOLEAN ) ( scalar_type | vector_type ) e1= expression ',' e2= expression
            {
            pushFollow(FOLLOW_variable_in_fcmp_op2444);
            variable74=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_fcmp_op2446); 

            match(input,65,FOLLOW_65_in_fcmp_op2448); 

            dest = variable74;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:454:7: ( FCMP_COND | CMP_COND | BOOLEAN )
            int alt57=3;
            switch ( input.LA(1) ) {
            case FCMP_COND:
                {
                alt57=1;
                }
                break;
            case CMP_COND:
                {
                alt57=2;
                }
                break;
            case BOOLEAN:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:454:8: FCMP_COND
                    {
                    FCMP_COND75=(Token)match(input,FCMP_COND,FOLLOW_FCMP_COND_in_fcmp_op2466); 

                    cond = (FCMP_COND75!=null?FCMP_COND75.getText():null);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:454:45: CMP_COND
                    {
                    CMP_COND76=(Token)match(input,CMP_COND,FOLLOW_CMP_COND_in_fcmp_op2471); 

                    cond = (CMP_COND76!=null?CMP_COND76.getText():null);

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:454:80: BOOLEAN
                    {
                    BOOLEAN77=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_fcmp_op2476); 

                    cond = (BOOLEAN77!=null?BOOLEAN77.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:455:7: ( scalar_type | vector_type )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==BOOLEAN_TYPE||LA58_0==FLOATING_POINT_TYPE||LA58_0==INTEGER_TYPE||LA58_0==LOCAL_VARIABLE||LA58_0==VOID||LA58_0==49||LA58_0==89||LA58_0==93) ) {
                alt58=1;
            }
            else if ( (LA58_0==46) ) {
                int LA58_2 = input.LA(2);

                if ( (LA58_2==93) ) {
                    alt58=1;
                }
                else if ( (LA58_2==INTEGER) ) {
                    int LA58_3 = input.LA(3);

                    if ( (LA58_3==91) ) {
                        switch ( input.LA(4) ) {
                        case BOOLEAN_TYPE:
                            {
                            int LA58_5 = input.LA(5);

                            if ( (LA58_5==48) ) {
                                int LA58_9 = input.LA(6);

                                if ( (LA58_9==43) ) {
                                    alt58=1;
                                }
                                else if ( (LA58_9==BINARY_OP||LA58_9==BOOLEAN||LA58_9==CONVERSION_OP||LA58_9==FLOATING_POINT||(LA58_9 >= GLOBAL_VARIABLE && LA58_9 <= HEX)||LA58_9==INTEGER||LA58_9==LOCAL_VARIABLE||LA58_9==NULL||LA58_9==UNDEF||(LA58_9 >= 65 && LA58_9 <= 66)||LA58_9==68) ) {
                                    alt58=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 58, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 58, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case INTEGER_TYPE:
                            {
                            int LA58_6 = input.LA(5);

                            if ( (LA58_6==48) ) {
                                int LA58_9 = input.LA(6);

                                if ( (LA58_9==43) ) {
                                    alt58=1;
                                }
                                else if ( (LA58_9==BINARY_OP||LA58_9==BOOLEAN||LA58_9==CONVERSION_OP||LA58_9==FLOATING_POINT||(LA58_9 >= GLOBAL_VARIABLE && LA58_9 <= HEX)||LA58_9==INTEGER||LA58_9==LOCAL_VARIABLE||LA58_9==NULL||LA58_9==UNDEF||(LA58_9 >= 65 && LA58_9 <= 66)||LA58_9==68) ) {
                                    alt58=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 58, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 58, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case FLOATING_POINT_TYPE:
                            {
                            int LA58_7 = input.LA(5);

                            if ( (LA58_7==48) ) {
                                int LA58_9 = input.LA(6);

                                if ( (LA58_9==43) ) {
                                    alt58=1;
                                }
                                else if ( (LA58_9==BINARY_OP||LA58_9==BOOLEAN||LA58_9==CONVERSION_OP||LA58_9==FLOATING_POINT||(LA58_9 >= GLOBAL_VARIABLE && LA58_9 <= HEX)||LA58_9==INTEGER||LA58_9==LOCAL_VARIABLE||LA58_9==NULL||LA58_9==UNDEF||(LA58_9 >= 65 && LA58_9 <= 66)||LA58_9==68) ) {
                                    alt58=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 58, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 58, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        case LOCAL_VARIABLE:
                            {
                            int LA58_8 = input.LA(5);

                            if ( (LA58_8==48) ) {
                                int LA58_9 = input.LA(6);

                                if ( (LA58_9==43) ) {
                                    alt58=1;
                                }
                                else if ( (LA58_9==BINARY_OP||LA58_9==BOOLEAN||LA58_9==CONVERSION_OP||LA58_9==FLOATING_POINT||(LA58_9 >= GLOBAL_VARIABLE && LA58_9 <= HEX)||LA58_9==INTEGER||LA58_9==LOCAL_VARIABLE||LA58_9==NULL||LA58_9==UNDEF||(LA58_9 >= 65 && LA58_9 <= 66)||LA58_9==68) ) {
                                    alt58=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 58, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 58, 8, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 58, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:455:8: scalar_type
                    {
                    pushFollow(FOLLOW_scalar_type_in_fcmp_op2489);
                    scalar_type78=scalar_type();

                    state._fsp--;


                    types.add(scalar_type78);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:455:53: vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_fcmp_op2494);
                    vector_type79=vector_type();

                    state._fsp--;


                    types.add(vector_type79);

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_fcmp_op2510);
            e1=expression();

            state._fsp--;


            match(input,44,FOLLOW_44_in_fcmp_op2512); 

            pushFollow(FOLLOW_expression_in_fcmp_op2518);
            e2=expression();

            state._fsp--;


            operands.add(e1); operands.add(e2);

            }


            inst = instFactory.createCmpInst(dest, opcode, operands, types, cond);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "fcmp_op"


    public static class phi_op_return extends ParserRuleReturnScope {
        public Instruction inst;
    };


    // $ANTLR start "phi_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:458:1: phi_op returns [Instruction inst] : variable '=' 'phi' first_class_type '[' e1= expression ',' lv1= LOCAL_VARIABLE ']' ( ',' '[' e2= expression ',' lv2= LOCAL_VARIABLE ']' )* ;
    public final LLVMParser.phi_op_return phi_op() throws RecognitionException {
        LLVMParser.phi_op_return retval = new LLVMParser.phi_op_return();
        retval.start = input.LT(1);


        Token lv1=null;
        Token lv2=null;
        Constant e1 =null;

        Constant e2 =null;

        Constant variable80 =null;

        Type first_class_type81 =null;



        Constant dest;
        int opcode = InstType.phiInst;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:468:5: ( variable '=' 'phi' first_class_type '[' e1= expression ',' lv1= LOCAL_VARIABLE ']' ( ',' '[' e2= expression ',' lv2= LOCAL_VARIABLE ']' )* )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:468:7: variable '=' 'phi' first_class_type '[' e1= expression ',' lv1= LOCAL_VARIABLE ']' ( ',' '[' e2= expression ',' lv2= LOCAL_VARIABLE ']' )*
            {
            pushFollow(FOLLOW_variable_in_phi_op2544);
            variable80=variable();

            state._fsp--;


            dest = variable80;

            match(input,47,FOLLOW_47_in_phi_op2554); 

            match(input,77,FOLLOW_77_in_phi_op2556); 

            pushFollow(FOLLOW_first_class_type_in_phi_op2565);
            first_class_type81=first_class_type();

            state._fsp--;


            types.add(first_class_type81);

            match(input,49,FOLLOW_49_in_phi_op2575); 

            pushFollow(FOLLOW_expression_in_phi_op2581);
            e1=expression();

            state._fsp--;


            operands.add(e1);

            match(input,44,FOLLOW_44_in_phi_op2591); 

            lv1=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_phi_op2597); 

            operands.add(valueFactory.createVariable((lv1!=null?lv1.getText():null)));

            match(input,50,FOLLOW_50_in_phi_op2600); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:473:7: ( ',' '[' e2= expression ',' lv2= LOCAL_VARIABLE ']' )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==44) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:473:8: ',' '[' e2= expression ',' lv2= LOCAL_VARIABLE ']'
            	    {
            	    match(input,44,FOLLOW_44_in_phi_op2610); 

            	    match(input,49,FOLLOW_49_in_phi_op2612); 

            	    pushFollow(FOLLOW_expression_in_phi_op2616);
            	    e2=expression();

            	    state._fsp--;


            	    match(input,44,FOLLOW_44_in_phi_op2618); 

            	    lv2=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_phi_op2622); 

            	    operands.add(e2); operands.add(valueFactory.createVariable((lv2!=null?lv2.getText():null)));

            	    match(input,50,FOLLOW_50_in_phi_op2625); 

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);



            retval.inst = instFactory.createSimpleInst(dest, opcode, operands, types);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "phi_op"



    // $ANTLR start "select_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:475:1: select_op returns [Instruction inst] : variable '=' 'select' BOOLEAN_TYPE e1= expression ',' fc1= first_class_type e2= expression ',' fc2= first_class_type e3= expression ;
    public final Instruction select_op() throws RecognitionException {
        Instruction inst = null;


        Constant e1 =null;

        Type fc1 =null;

        Constant e2 =null;

        Type fc2 =null;

        Constant e3 =null;

        Constant variable82 =null;



        Constant dest;
        int opcode = InstType.selectInst;
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:485:5: ( variable '=' 'select' BOOLEAN_TYPE e1= expression ',' fc1= first_class_type e2= expression ',' fc2= first_class_type e3= expression )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:485:7: variable '=' 'select' BOOLEAN_TYPE e1= expression ',' fc1= first_class_type e2= expression ',' fc2= first_class_type e3= expression
            {
            pushFollow(FOLLOW_variable_in_select_op2652);
            variable82=variable();

            state._fsp--;


            match(input,47,FOLLOW_47_in_select_op2654); 

            match(input,79,FOLLOW_79_in_select_op2656); 

            match(input,BOOLEAN_TYPE,FOLLOW_BOOLEAN_TYPE_in_select_op2658); 

            pushFollow(FOLLOW_expression_in_select_op2662);
            e1=expression();

            state._fsp--;


            match(input,44,FOLLOW_44_in_select_op2664); 

            pushFollow(FOLLOW_first_class_type_in_select_op2668);
            fc1=first_class_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_select_op2672);
            e2=expression();

            state._fsp--;


            match(input,44,FOLLOW_44_in_select_op2674); 

            pushFollow(FOLLOW_first_class_type_in_select_op2678);
            fc2=first_class_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_select_op2682);
            e3=expression();

            state._fsp--;


            dest = variable82; 
                types.add(typeFactory.getIntNType(1));
                operands.add(e1);
                types.add(fc1); operands.add(e2);
                types.add(fc2); operands.add(e3);

            }


            inst = instFactory.createSimpleInst(dest, opcode, operands, types);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "select_op"



    // $ANTLR start "call_op"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:492:1: call_op returns [Instruction inst] : ( variable '=' )? ( 'tail' )? 'call' function_call[cconv, pAttributes, types, operands, fAttributes] ;
    public final Instruction call_op() throws RecognitionException {
        Instruction inst = null;


        Constant variable83 =null;



        Constant dest = null;
        boolean tail = false;
        int opcode = InstType.callInst;
        String cconv = null;
        List<String> pAttributes = new ArrayList<String>();
        List<Type> types = new ArrayList<Type>();
        List<Constant> operands = new ArrayList<Constant>();
        List<String> fAttributes = new ArrayList<String>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:506:5: ( ( variable '=' )? ( 'tail' )? 'call' function_call[cconv, pAttributes, types, operands, fAttributes] )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:506:7: ( variable '=' )? ( 'tail' )? 'call' function_call[cconv, pAttributes, types, operands, fAttributes]
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:506:7: ( variable '=' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==GLOBAL_VARIABLE||LA60_0==LOCAL_VARIABLE||LA60_0==UNDEF) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:506:8: variable '='
                    {
                    pushFollow(FOLLOW_variable_in_call_op2713);
                    variable83=variable();

                    state._fsp--;


                    match(input,47,FOLLOW_47_in_call_op2715); 

                    dest = variable83;

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:506:48: ( 'tail' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==84) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:506:49: 'tail'
                    {
                    match(input,84,FOLLOW_84_in_call_op2722); 

                    tail = true;

                    }
                    break;

            }


            match(input,57,FOLLOW_57_in_call_op2728); 

            pushFollow(FOLLOW_function_call_in_call_op2735);
            function_call(cconv, pAttributes, types, operands, fAttributes);

            state._fsp--;


            }


            inst = instFactory.createCallInst(dest, opcode, operands, types, false, cconv, pAttributes, fAttributes);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return inst;
    }
    // $ANTLR end "call_op"



    // $ANTLR start "function_call"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:509:1: function_call[String cconv, List<String> pAttributes, List<Type> types, List<Constant> operands, List<String> fAttributes] returns [boolean isVarargFunction] : ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type function_name '(' argument_list[arguments] ')' ( FUNCTION_ATTRIBUTES )* ;
    public final boolean function_call(String cconv, List<String> pAttributes, List<Type> types, List<Constant> operands, List<String> fAttributes) throws RecognitionException {
        boolean isVarargFunction = false;


        Token CCONV84=null;
        Token PARAMETER_ATTRIBUTES85=null;
        Token FUNCTION_ATTRIBUTES89=null;
        Type return_type86 =null;

        Constant function_name87 =null;

        boolean argument_list88 =false;



        List<Argument> arguments = new ArrayList<Argument>();
        boolean isVararg = false;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:522:5: ( ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type function_name '(' argument_list[arguments] ')' ( FUNCTION_ATTRIBUTES )* )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:522:7: ( CCONV )? ( PARAMETER_ATTRIBUTES )* return_type function_name '(' argument_list[arguments] ')' ( FUNCTION_ATTRIBUTES )*
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:522:7: ( CCONV )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==CCONV) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:522:8: CCONV
                    {
                    CCONV84=(Token)match(input,CCONV,FOLLOW_CCONV_in_function_call2763); 

                    cconv = (CCONV84!=null?CCONV84.getText():null);

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:523:7: ( PARAMETER_ATTRIBUTES )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==PARAMETER_ATTRIBUTES) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:523:8: PARAMETER_ATTRIBUTES
            	    {
            	    PARAMETER_ATTRIBUTES85=(Token)match(input,PARAMETER_ATTRIBUTES,FOLLOW_PARAMETER_ATTRIBUTES_in_function_call2777); 

            	    pAttributes.add((PARAMETER_ATTRIBUTES85!=null?PARAMETER_ATTRIBUTES85.getText():null));

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            pushFollow(FOLLOW_return_type_in_function_call2789);
            return_type86=return_type();

            state._fsp--;


            pushFollow(FOLLOW_function_name_in_function_call2791);
            function_name87=function_name();

            state._fsp--;


            types.add(return_type86); operands.add(function_name87);

            match(input,41,FOLLOW_41_in_function_call2801); 

            pushFollow(FOLLOW_argument_list_in_function_call2803);
            argument_list88=argument_list(arguments);

            state._fsp--;


            match(input,42,FOLLOW_42_in_function_call2807); 

            isVarargFunction = argument_list88;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:526:7: ( FUNCTION_ATTRIBUTES )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==FUNCTION_ATTRIBUTES) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:526:8: FUNCTION_ATTRIBUTES
            	    {
            	    FUNCTION_ATTRIBUTES89=(Token)match(input,FUNCTION_ATTRIBUTES,FOLLOW_FUNCTION_ATTRIBUTES_in_function_call2818); 

            	    fAttributes.add((FUNCTION_ATTRIBUTES89!=null?FUNCTION_ATTRIBUTES89.getText():null));

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }


            for(Argument arg:arguments){
              types.add(arg.getType());
              operands.add(arg.getExpr());
            }

            isVarargFunction = isVararg;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return isVarargFunction;
    }
    // $ANTLR end "function_call"



    // $ANTLR start "argument_list"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:529:1: argument_list[List<Argument> alist] returns [boolean isVarargFunction] : ( '...' | (fct1= first_class_type (pa1= PARAMETER_ATTRIBUTES )* (a1= align )? (e1= expression )? ( ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )? )* ( ',' '...' )? )? );
    public final boolean argument_list(List<Argument> alist) throws RecognitionException {
        boolean isVarargFunction = false;


        Token pa1=null;
        Token pa2=null;
        Type fct1 =null;

        int a1 =0;

        Constant e1 =null;

        Type fct2 =null;

        int a2 =0;

        Constant e2 =null;



        Type type;
        List<String> pAttributes = new ArrayList<String>(); 
        int align = -1;
        Constant expr = null;
        boolean isVararg = false;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:540:5: ( '...' | (fct1= first_class_type (pa1= PARAMETER_ATTRIBUTES )* (a1= align )? (e1= expression )? ( ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )? )* ( ',' '...' )? )? )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==45) ) {
                alt74=1;
            }
            else if ( (LA74_0==BOOLEAN_TYPE||LA74_0==FLOATING_POINT_TYPE||(LA74_0 >= INTEGER_TYPE && LA74_0 <= LABEL)||(LA74_0 >= LOCAL_VARIABLE && LA74_0 <= METADATA)||LA74_0==VOID||LA74_0==42||LA74_0==46||LA74_0==49||LA74_0==89||LA74_0==93) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:540:7: '...'
                    {
                    match(input,45,FOLLOW_45_in_argument_list2852); 

                    isVararg = true;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:541:7: (fct1= first_class_type (pa1= PARAMETER_ATTRIBUTES )* (a1= align )? (e1= expression )? ( ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )? )* ( ',' '...' )? )?
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:541:7: (fct1= first_class_type (pa1= PARAMETER_ATTRIBUTES )* (a1= align )? (e1= expression )? ( ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )? )* ( ',' '...' )? )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==BOOLEAN_TYPE||LA73_0==FLOATING_POINT_TYPE||(LA73_0 >= INTEGER_TYPE && LA73_0 <= LABEL)||(LA73_0 >= LOCAL_VARIABLE && LA73_0 <= METADATA)||LA73_0==VOID||LA73_0==46||LA73_0==49||LA73_0==89||LA73_0==93) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:541:8: fct1= first_class_type (pa1= PARAMETER_ATTRIBUTES )* (a1= align )? (e1= expression )? ( ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )? )* ( ',' '...' )?
                            {
                            pushFollow(FOLLOW_first_class_type_in_argument_list2867);
                            fct1=first_class_type();

                            state._fsp--;


                            type = fct1;

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:542:8: (pa1= PARAMETER_ATTRIBUTES )*
                            loop65:
                            do {
                                int alt65=2;
                                int LA65_0 = input.LA(1);

                                if ( (LA65_0==PARAMETER_ATTRIBUTES) ) {
                                    alt65=1;
                                }


                                switch (alt65) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:542:9: pa1= PARAMETER_ATTRIBUTES
                            	    {
                            	    pa1=(Token)match(input,PARAMETER_ATTRIBUTES,FOLLOW_PARAMETER_ATTRIBUTES_in_argument_list2884); 

                            	    pAttributes.add((pa1!=null?pa1.getText():null));

                            	    }
                            	    break;

                            	default :
                            	    break loop65;
                                }
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:543:8: (a1= align )?
                            int alt66=2;
                            int LA66_0 = input.LA(1);

                            if ( (LA66_0==ALIGN) ) {
                                alt66=1;
                            }
                            switch (alt66) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:543:9: a1= align
                                    {
                                    pushFollow(FOLLOW_align_in_argument_list2903);
                                    a1=align();

                                    state._fsp--;


                                    align = a1;

                                    }
                                    break;

                            }


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:544:8: (e1= expression )?
                            int alt67=2;
                            int LA67_0 = input.LA(1);

                            if ( (LA67_0==BINARY_OP||LA67_0==BOOLEAN||LA67_0==CONVERSION_OP||LA67_0==FLOATING_POINT||(LA67_0 >= GLOBAL_VARIABLE && LA67_0 <= HEX)||LA67_0==INTEGER||LA67_0==LOCAL_VARIABLE||LA67_0==NULL||LA67_0==UNDEF||(LA67_0 >= 65 && LA67_0 <= 66)||LA67_0==68) ) {
                                alt67=1;
                            }
                            switch (alt67) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:544:9: e1= expression
                                    {
                                    pushFollow(FOLLOW_expression_in_argument_list2920);
                                    e1=expression();

                                    state._fsp--;


                                    expr = e1;

                                    }
                                    break;

                            }


                            alist.add(valueFactory.createArgument(type, pAttributes, align, expr));
                                       pAttributes = new ArrayList<String>();
                                       align = -1;
                                       expr = null;
                                       

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:550:7: ( ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )? )*
                            loop71:
                            do {
                                int alt71=2;
                                int LA71_0 = input.LA(1);

                                if ( (LA71_0==44) ) {
                                    int LA71_1 = input.LA(2);

                                    if ( (LA71_1==BOOLEAN_TYPE||LA71_1==FLOATING_POINT_TYPE||(LA71_1 >= INTEGER_TYPE && LA71_1 <= LABEL)||(LA71_1 >= LOCAL_VARIABLE && LA71_1 <= METADATA)||LA71_1==VOID||LA71_1==46||LA71_1==49||LA71_1==89||LA71_1==93) ) {
                                        alt71=1;
                                    }


                                }


                                switch (alt71) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:550:8: ',' fct2= first_class_type (pa2= PARAMETER_ATTRIBUTES )* (a2= align )? (e2= expression )?
                            	    {
                            	    match(input,44,FOLLOW_44_in_argument_list2947); 

                            	    pushFollow(FOLLOW_first_class_type_in_argument_list2962);
                            	    fct2=first_class_type();

                            	    state._fsp--;


                            	    type = fct2;

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:552:9: (pa2= PARAMETER_ATTRIBUTES )*
                            	    loop68:
                            	    do {
                            	        int alt68=2;
                            	        int LA68_0 = input.LA(1);

                            	        if ( (LA68_0==PARAMETER_ATTRIBUTES) ) {
                            	            alt68=1;
                            	        }


                            	        switch (alt68) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:552:10: pa2= PARAMETER_ATTRIBUTES
                            	    	    {
                            	    	    pa2=(Token)match(input,PARAMETER_ATTRIBUTES,FOLLOW_PARAMETER_ATTRIBUTES_in_argument_list2980); 

                            	    	    pAttributes.add((pa2!=null?pa2.getText():null));

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop68;
                            	        }
                            	    } while (true);


                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:553:9: (a2= align )?
                            	    int alt69=2;
                            	    int LA69_0 = input.LA(1);

                            	    if ( (LA69_0==ALIGN) ) {
                            	        alt69=1;
                            	    }
                            	    switch (alt69) {
                            	        case 1 :
                            	            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:553:10: a2= align
                            	            {
                            	            pushFollow(FOLLOW_align_in_argument_list3001);
                            	            a2=align();

                            	            state._fsp--;


                            	            align = a2;

                            	            }
                            	            break;

                            	    }


                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:554:9: (e2= expression )?
                            	    int alt70=2;
                            	    int LA70_0 = input.LA(1);

                            	    if ( (LA70_0==BINARY_OP||LA70_0==BOOLEAN||LA70_0==CONVERSION_OP||LA70_0==FLOATING_POINT||(LA70_0 >= GLOBAL_VARIABLE && LA70_0 <= HEX)||LA70_0==INTEGER||LA70_0==LOCAL_VARIABLE||LA70_0==NULL||LA70_0==UNDEF||(LA70_0 >= 65 && LA70_0 <= 66)||LA70_0==68) ) {
                            	        alt70=1;
                            	    }
                            	    switch (alt70) {
                            	        case 1 :
                            	            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:554:10: e2= expression
                            	            {
                            	            pushFollow(FOLLOW_expression_in_argument_list3020);
                            	            e2=expression();

                            	            state._fsp--;


                            	            expr = e2;

                            	            }
                            	            break;

                            	    }


                            	    alist.add(valueFactory.createArgument(type, pAttributes, align, expr));
                            	               pAttributes = new ArrayList<String>();
                            	               align = -1;
                            	               expr = null;
                            	              

                            	    }
                            	    break;

                            	default :
                            	    break loop71;
                                }
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:560:10: ( ',' '...' )?
                            int alt72=2;
                            int LA72_0 = input.LA(1);

                            if ( (LA72_0==44) ) {
                                alt72=1;
                            }
                            switch (alt72) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:560:11: ',' '...'
                                    {
                                    match(input,44,FOLLOW_44_in_argument_list3048); 

                                    match(input,45,FOLLOW_45_in_argument_list3050); 

                                    isVararg = true;

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            isVarargFunction = isVararg;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return isVarargFunction;
    }
    // $ANTLR end "argument_list"



    // $ANTLR start "variable"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:567:1: variable returns [Constant expr] : ( GLOBAL_VARIABLE | LOCAL_VARIABLE | UNDEF );
    public final Constant variable() throws RecognitionException {
        Constant expr = null;


        Token GLOBAL_VARIABLE90=null;
        Token LOCAL_VARIABLE91=null;
        Token UNDEF92=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:568:5: ( GLOBAL_VARIABLE | LOCAL_VARIABLE | UNDEF )
            int alt75=3;
            switch ( input.LA(1) ) {
            case GLOBAL_VARIABLE:
                {
                alt75=1;
                }
                break;
            case LOCAL_VARIABLE:
                {
                alt75=2;
                }
                break;
            case UNDEF:
                {
                alt75=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }

            switch (alt75) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:568:7: GLOBAL_VARIABLE
                    {
                    GLOBAL_VARIABLE90=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_variable3086); 

                    expr = valueFactory.createVariable((GLOBAL_VARIABLE90!=null?GLOBAL_VARIABLE90.getText():null));

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:569:7: LOCAL_VARIABLE
                    {
                    LOCAL_VARIABLE91=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_variable3096); 

                    expr = valueFactory.createVariable((LOCAL_VARIABLE91!=null?LOCAL_VARIABLE91.getText():null));

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:570:7: UNDEF
                    {
                    UNDEF92=(Token)match(input,UNDEF,FOLLOW_UNDEF_in_variable3106); 

                    expr = valueFactory.createVariable((UNDEF92!=null?UNDEF92.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "variable"



    // $ANTLR start "expression"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:572:1: expression returns [Constant expr] : ( simple_constant | getelementptr_expr | conversion_expr | binary_expr | cmp_expr | variable );
    public final Constant expression() throws RecognitionException {
        Constant expr = null;


        Constant simple_constant93 =null;

        Constant getelementptr_expr94 =null;

        Constant conversion_expr95 =null;

        Constant binary_expr96 =null;

        Constant cmp_expr97 =null;

        Constant variable98 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:573:5: ( simple_constant | getelementptr_expr | conversion_expr | binary_expr | cmp_expr | variable )
            int alt76=6;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case FLOATING_POINT:
            case HEX:
            case INTEGER:
            case NULL:
                {
                alt76=1;
                }
                break;
            case 66:
                {
                alt76=2;
                }
                break;
            case CONVERSION_OP:
                {
                alt76=3;
                }
                break;
            case BINARY_OP:
                {
                alt76=4;
                }
                break;
            case 65:
            case 68:
                {
                alt76=5;
                }
                break;
            case GLOBAL_VARIABLE:
            case LOCAL_VARIABLE:
            case UNDEF:
                {
                alt76=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;

            }

            switch (alt76) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:573:7: simple_constant
                    {
                    pushFollow(FOLLOW_simple_constant_in_expression3124);
                    simple_constant93=simple_constant();

                    state._fsp--;


                    expr = simple_constant93;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:574:7: getelementptr_expr
                    {
                    pushFollow(FOLLOW_getelementptr_expr_in_expression3134);
                    getelementptr_expr94=getelementptr_expr();

                    state._fsp--;


                    expr = getelementptr_expr94;

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:575:7: conversion_expr
                    {
                    pushFollow(FOLLOW_conversion_expr_in_expression3144);
                    conversion_expr95=conversion_expr();

                    state._fsp--;


                    expr = conversion_expr95;

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:576:7: binary_expr
                    {
                    pushFollow(FOLLOW_binary_expr_in_expression3154);
                    binary_expr96=binary_expr();

                    state._fsp--;


                    expr = binary_expr96;

                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:577:7: cmp_expr
                    {
                    pushFollow(FOLLOW_cmp_expr_in_expression3164);
                    cmp_expr97=cmp_expr();

                    state._fsp--;


                    expr = cmp_expr97;

                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:578:7: variable
                    {
                    pushFollow(FOLLOW_variable_in_expression3174);
                    variable98=variable();

                    state._fsp--;


                    expr = variable98;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "expression"



    // $ANTLR start "getelementptr_expr"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:581:1: getelementptr_expr returns [Constant expr] : 'getelementptr' ( 'inbounds' )? '(' pointer_type expression ( ',' INTEGER_TYPE INTEGER )+ ')' ;
    public final Constant getelementptr_expr() throws RecognitionException {
        Constant expr = null;


        Token INTEGER101=null;
        Type pointer_type99 =null;

        Constant expression100 =null;



        boolean inbounds = false;
        Type type;
        Constant subExpr;
        List<Integer> indices = new ArrayList<Integer>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:591:5: ( 'getelementptr' ( 'inbounds' )? '(' pointer_type expression ( ',' INTEGER_TYPE INTEGER )+ ')' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:591:7: 'getelementptr' ( 'inbounds' )? '(' pointer_type expression ( ',' INTEGER_TYPE INTEGER )+ ')'
            {
            match(input,66,FOLLOW_66_in_getelementptr_expr3205); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:591:23: ( 'inbounds' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==69) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:591:24: 'inbounds'
                    {
                    match(input,69,FOLLOW_69_in_getelementptr_expr3208); 

                    inbounds = true;

                    }
                    break;

            }


            match(input,41,FOLLOW_41_in_getelementptr_expr3221); 

            pushFollow(FOLLOW_pointer_type_in_getelementptr_expr3223);
            pointer_type99=pointer_type();

            state._fsp--;


            type = pointer_type99;

            pushFollow(FOLLOW_expression_in_getelementptr_expr3234);
            expression100=expression();

            state._fsp--;


            subExpr = expression100;

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:594:7: ( ',' INTEGER_TYPE INTEGER )+
            int cnt78=0;
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==44) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:594:8: ',' INTEGER_TYPE INTEGER
            	    {
            	    match(input,44,FOLLOW_44_in_getelementptr_expr3246); 

            	    match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_getelementptr_expr3248); 

            	    INTEGER101=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_getelementptr_expr3250); 

            	    indices.add(Integer.parseInt((INTEGER101!=null?INTEGER101.getText():null)));

            	    }
            	    break;

            	default :
            	    if ( cnt78 >= 1 ) break loop78;
                        EarlyExitException eee =
                            new EarlyExitException(78, input);
                        throw eee;
                }
                cnt78++;
            } while (true);


            match(input,42,FOLLOW_42_in_getelementptr_expr3264); 

            }


            expr = valueFactory.createGetEleExpression(inbounds, type, subExpr, indices);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "getelementptr_expr"



    // $ANTLR start "conversion_expr"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:598:1: conversion_expr returns [Constant expr] : CONVERSION_OP '(' st1= scalar_type expression TO st2= scalar_type ')' ;
    public final Constant conversion_expr() throws RecognitionException {
        Constant expr = null;


        Token CONVERSION_OP102=null;
        Type st1 =null;

        Type st2 =null;

        Constant expression103 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:599:5: ( CONVERSION_OP '(' st1= scalar_type expression TO st2= scalar_type ')' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:599:7: CONVERSION_OP '(' st1= scalar_type expression TO st2= scalar_type ')'
            {
            CONVERSION_OP102=(Token)match(input,CONVERSION_OP,FOLLOW_CONVERSION_OP_in_conversion_expr3285); 

            match(input,41,FOLLOW_41_in_conversion_expr3287); 

            pushFollow(FOLLOW_scalar_type_in_conversion_expr3291);
            st1=scalar_type();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_conversion_expr3293);
            expression103=expression();

            state._fsp--;


            match(input,TO,FOLLOW_TO_in_conversion_expr3295); 

            pushFollow(FOLLOW_scalar_type_in_conversion_expr3299);
            st2=scalar_type();

            state._fsp--;


            match(input,42,FOLLOW_42_in_conversion_expr3301); 

            String op = (CONVERSION_OP102!=null?CONVERSION_OP102.getText():null);
                   Type type1 = st1;
                   Constant subExpr = expression103;
                   Type type2 = st2;
                   expr = valueFactory.createConversionExpression(op, type1, subExpr, type2);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "conversion_expr"



    // $ANTLR start "binary_expr"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:608:1: binary_expr returns [Constant expr] : BINARY_OP ( 'nuw' )? ( 'nsw' )? ( 'exact' )? '(' ( (et1= element_type ) | (vt1= vector_type ) ) ex1= expression ',' ( (et2= element_type ) | (vt2= vector_type ) ) ex2= expression ')' ;
    public final Constant binary_expr() throws RecognitionException {
        Constant expr = null;


        Token BINARY_OP104=null;
        Type et1 =null;

        Type vt1 =null;

        Constant ex1 =null;

        Type et2 =null;

        Type vt2 =null;

        Constant ex2 =null;



        String op;
        String nuw = null;
        String nsw = null;
        String exact = null;
        Type type1 = null;
        Constant expr1;
        Type type2 = null;
        Constant expr2;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:622:5: ( BINARY_OP ( 'nuw' )? ( 'nsw' )? ( 'exact' )? '(' ( (et1= element_type ) | (vt1= vector_type ) ) ex1= expression ',' ( (et2= element_type ) | (vt2= vector_type ) ) ex2= expression ')' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:622:7: BINARY_OP ( 'nuw' )? ( 'nsw' )? ( 'exact' )? '(' ( (et1= element_type ) | (vt1= vector_type ) ) ex1= expression ',' ( (et2= element_type ) | (vt2= vector_type ) ) ex2= expression ')'
            {
            BINARY_OP104=(Token)match(input,BINARY_OP,FOLLOW_BINARY_OP_in_binary_expr3338); 

            op = (BINARY_OP104!=null?BINARY_OP104.getText():null);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:623:7: ( 'nuw' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==76) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:623:8: 'nuw'
                    {
                    match(input,76,FOLLOW_76_in_binary_expr3349); 

                    nuw = "nuw";

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:624:7: ( 'nsw' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==75) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:624:8: 'nsw'
                    {
                    match(input,75,FOLLOW_75_in_binary_expr3363); 

                    nsw = "nsw";

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:625:7: ( 'exact' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==62) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:625:8: 'exact'
                    {
                    match(input,62,FOLLOW_62_in_binary_expr3377); 

                    exact = "exact";

                    }
                    break;

            }


            match(input,41,FOLLOW_41_in_binary_expr3390); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:7: ( (et1= element_type ) | (vt1= vector_type ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==BOOLEAN_TYPE||LA82_0==FLOATING_POINT_TYPE||LA82_0==INTEGER_TYPE||LA82_0==LOCAL_VARIABLE) ) {
                alt82=1;
            }
            else if ( (LA82_0==46) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }
            switch (alt82) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:8: (et1= element_type )
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:8: (et1= element_type )
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:9: et1= element_type
                    {
                    pushFollow(FOLLOW_element_type_in_binary_expr3405);
                    et1=element_type();

                    state._fsp--;


                    type1 = et1;

                    }


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:51: (vt1= vector_type )
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:51: (vt1= vector_type )
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:627:52: vt1= vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_binary_expr3416);
                    vt1=vector_type();

                    state._fsp--;


                    }


                    type1 = vt1;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_binary_expr3434);
            ex1=expression();

            state._fsp--;


            expr1 = ex1;

            match(input,44,FOLLOW_44_in_binary_expr3437); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:7: ( (et2= element_type ) | (vt2= vector_type ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==BOOLEAN_TYPE||LA83_0==FLOATING_POINT_TYPE||LA83_0==INTEGER_TYPE||LA83_0==LOCAL_VARIABLE) ) {
                alt83=1;
            }
            else if ( (LA83_0==46) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }
            switch (alt83) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:8: (et2= element_type )
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:8: (et2= element_type )
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:9: et2= element_type
                    {
                    pushFollow(FOLLOW_element_type_in_binary_expr3452);
                    et2=element_type();

                    state._fsp--;


                    type2 = et2;

                    }


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:51: (vt2= vector_type )
                    {
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:51: (vt2= vector_type )
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:629:52: vt2= vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_binary_expr3463);
                    vt2=vector_type();

                    state._fsp--;


                    }


                    type2 = vt2;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_binary_expr3481);
            ex2=expression();

            state._fsp--;


            expr2 = ex2;

            match(input,42,FOLLOW_42_in_binary_expr3492); 

            }


            expr = valueFactory.createBinaryExpression(op, nuw, nsw, exact, type1, expr1, type2, expr2);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "binary_expr"



    // $ANTLR start "cmp_expr"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:633:1: cmp_expr returns [Constant expr] : ( 'icmp' ( ICMP_COND |cc1= CMP_COND ) | 'fcmp' ( FCMP_COND |cc2= CMP_COND | BOOLEAN ) ) '(' (sct1= scalar_type |vt1= vector_type ) e1= expression ',' (sct2= scalar_type |vt2= vector_type ) e2= expression ')' ;
    public final Constant cmp_expr() throws RecognitionException {
        Constant expr = null;


        Token cc1=null;
        Token cc2=null;
        Token ICMP_COND105=null;
        Token FCMP_COND106=null;
        Token BOOLEAN107=null;
        Type sct1 =null;

        Type vt1 =null;

        Constant e1 =null;

        Type sct2 =null;

        Type vt2 =null;

        Constant e2 =null;



        boolean isICmp=true;
        String cond=null;
        Type type1=null, type2=null;
        Constant expr1=null, expr2=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:643:5: ( ( 'icmp' ( ICMP_COND |cc1= CMP_COND ) | 'fcmp' ( FCMP_COND |cc2= CMP_COND | BOOLEAN ) ) '(' (sct1= scalar_type |vt1= vector_type ) e1= expression ',' (sct2= scalar_type |vt2= vector_type ) e2= expression ')' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:643:7: ( 'icmp' ( ICMP_COND |cc1= CMP_COND ) | 'fcmp' ( FCMP_COND |cc2= CMP_COND | BOOLEAN ) ) '(' (sct1= scalar_type |vt1= vector_type ) e1= expression ',' (sct2= scalar_type |vt2= vector_type ) e2= expression ')'
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:643:7: ( 'icmp' ( ICMP_COND |cc1= CMP_COND ) | 'fcmp' ( FCMP_COND |cc2= CMP_COND | BOOLEAN ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==68) ) {
                alt86=1;
            }
            else if ( (LA86_0==65) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:643:8: 'icmp' ( ICMP_COND |cc1= CMP_COND )
                    {
                    match(input,68,FOLLOW_68_in_cmp_expr3517); 

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:644:7: ( ICMP_COND |cc1= CMP_COND )
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==ICMP_COND) ) {
                        alt84=1;
                    }
                    else if ( (LA84_0==CMP_COND) ) {
                        alt84=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 84, 0, input);

                        throw nvae;

                    }
                    switch (alt84) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:644:8: ICMP_COND
                            {
                            ICMP_COND105=(Token)match(input,ICMP_COND,FOLLOW_ICMP_COND_in_cmp_expr3527); 

                            cond = (ICMP_COND105!=null?ICMP_COND105.getText():null);

                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:644:45: cc1= CMP_COND
                            {
                            cc1=(Token)match(input,CMP_COND,FOLLOW_CMP_COND_in_cmp_expr3536); 

                            cond = (cc1!=null?cc1.getText():null);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:645:11: 'fcmp' ( FCMP_COND |cc2= CMP_COND | BOOLEAN )
                    {
                    match(input,65,FOLLOW_65_in_cmp_expr3552); 

                    isICmp = false;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:645:35: ( FCMP_COND |cc2= CMP_COND | BOOLEAN )
                    int alt85=3;
                    switch ( input.LA(1) ) {
                    case FCMP_COND:
                        {
                        alt85=1;
                        }
                        break;
                    case CMP_COND:
                        {
                        alt85=2;
                        }
                        break;
                    case BOOLEAN:
                        {
                        alt85=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;

                    }

                    switch (alt85) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:645:36: FCMP_COND
                            {
                            FCMP_COND106=(Token)match(input,FCMP_COND,FOLLOW_FCMP_COND_in_cmp_expr3556); 

                            cond = (FCMP_COND106!=null?FCMP_COND106.getText():null);

                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:645:73: cc2= CMP_COND
                            {
                            cc2=(Token)match(input,CMP_COND,FOLLOW_CMP_COND_in_cmp_expr3565); 

                            cond = (cc2!=null?cc2.getText():null);

                            }
                            break;
                        case 3 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:645:109: BOOLEAN
                            {
                            BOOLEAN107=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_cmp_expr3570); 

                            cond = (BOOLEAN107!=null?BOOLEAN107.getText():null);

                            }
                            break;

                    }


                    }
                    break;

            }


            match(input,41,FOLLOW_41_in_cmp_expr3589); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:647:11: (sct1= scalar_type |vt1= vector_type )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==BOOLEAN_TYPE||LA87_0==FLOATING_POINT_TYPE||LA87_0==INTEGER_TYPE||LA87_0==LOCAL_VARIABLE||LA87_0==VOID||LA87_0==49||LA87_0==89||LA87_0==93) ) {
                alt87=1;
            }
            else if ( (LA87_0==46) ) {
                int LA87_2 = input.LA(2);

                if ( (LA87_2==93) ) {
                    alt87=1;
                }
                else if ( (LA87_2==INTEGER) ) {
                    int LA87_3 = input.LA(3);

                    if ( (LA87_3==91) ) {
                        switch ( input.LA(4) ) {
                        case BOOLEAN_TYPE:
                            {
                            int LA87_5 = input.LA(5);

                            if ( (LA87_5==48) ) {
                                int LA87_9 = input.LA(6);

                                if ( (LA87_9==43) ) {
                                    alt87=1;
                                }
                                else if ( (LA87_9==BINARY_OP||LA87_9==BOOLEAN||LA87_9==CONVERSION_OP||LA87_9==FLOATING_POINT||(LA87_9 >= GLOBAL_VARIABLE && LA87_9 <= HEX)||LA87_9==INTEGER||LA87_9==LOCAL_VARIABLE||LA87_9==NULL||LA87_9==UNDEF||(LA87_9 >= 65 && LA87_9 <= 66)||LA87_9==68) ) {
                                    alt87=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 87, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 87, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case INTEGER_TYPE:
                            {
                            int LA87_6 = input.LA(5);

                            if ( (LA87_6==48) ) {
                                int LA87_9 = input.LA(6);

                                if ( (LA87_9==43) ) {
                                    alt87=1;
                                }
                                else if ( (LA87_9==BINARY_OP||LA87_9==BOOLEAN||LA87_9==CONVERSION_OP||LA87_9==FLOATING_POINT||(LA87_9 >= GLOBAL_VARIABLE && LA87_9 <= HEX)||LA87_9==INTEGER||LA87_9==LOCAL_VARIABLE||LA87_9==NULL||LA87_9==UNDEF||(LA87_9 >= 65 && LA87_9 <= 66)||LA87_9==68) ) {
                                    alt87=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 87, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 87, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case FLOATING_POINT_TYPE:
                            {
                            int LA87_7 = input.LA(5);

                            if ( (LA87_7==48) ) {
                                int LA87_9 = input.LA(6);

                                if ( (LA87_9==43) ) {
                                    alt87=1;
                                }
                                else if ( (LA87_9==BINARY_OP||LA87_9==BOOLEAN||LA87_9==CONVERSION_OP||LA87_9==FLOATING_POINT||(LA87_9 >= GLOBAL_VARIABLE && LA87_9 <= HEX)||LA87_9==INTEGER||LA87_9==LOCAL_VARIABLE||LA87_9==NULL||LA87_9==UNDEF||(LA87_9 >= 65 && LA87_9 <= 66)||LA87_9==68) ) {
                                    alt87=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 87, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 87, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        case LOCAL_VARIABLE:
                            {
                            int LA87_8 = input.LA(5);

                            if ( (LA87_8==48) ) {
                                int LA87_9 = input.LA(6);

                                if ( (LA87_9==43) ) {
                                    alt87=1;
                                }
                                else if ( (LA87_9==BINARY_OP||LA87_9==BOOLEAN||LA87_9==CONVERSION_OP||LA87_9==FLOATING_POINT||(LA87_9 >= GLOBAL_VARIABLE && LA87_9 <= HEX)||LA87_9==INTEGER||LA87_9==LOCAL_VARIABLE||LA87_9==NULL||LA87_9==UNDEF||(LA87_9 >= 65 && LA87_9 <= 66)||LA87_9==68) ) {
                                    alt87=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 87, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 87, 8, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 87, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 87, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:647:12: sct1= scalar_type
                    {
                    pushFollow(FOLLOW_scalar_type_in_cmp_expr3596);
                    sct1=scalar_type();

                    state._fsp--;


                    type1 = sct1;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:647:55: vt1= vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_cmp_expr3606);
                    vt1=vector_type();

                    state._fsp--;


                    type1 = vt1;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_cmp_expr3622);
            e1=expression();

            state._fsp--;


            expr1 = e1;

            match(input,44,FOLLOW_44_in_cmp_expr3635); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:650:8: (sct2= scalar_type |vt2= vector_type )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==BOOLEAN_TYPE||LA88_0==FLOATING_POINT_TYPE||LA88_0==INTEGER_TYPE||LA88_0==LOCAL_VARIABLE||LA88_0==VOID||LA88_0==49||LA88_0==89||LA88_0==93) ) {
                alt88=1;
            }
            else if ( (LA88_0==46) ) {
                int LA88_2 = input.LA(2);

                if ( (LA88_2==93) ) {
                    alt88=1;
                }
                else if ( (LA88_2==INTEGER) ) {
                    int LA88_3 = input.LA(3);

                    if ( (LA88_3==91) ) {
                        switch ( input.LA(4) ) {
                        case BOOLEAN_TYPE:
                            {
                            int LA88_5 = input.LA(5);

                            if ( (LA88_5==48) ) {
                                int LA88_9 = input.LA(6);

                                if ( (LA88_9==43) ) {
                                    alt88=1;
                                }
                                else if ( (LA88_9==BINARY_OP||LA88_9==BOOLEAN||LA88_9==CONVERSION_OP||LA88_9==FLOATING_POINT||(LA88_9 >= GLOBAL_VARIABLE && LA88_9 <= HEX)||LA88_9==INTEGER||LA88_9==LOCAL_VARIABLE||LA88_9==NULL||LA88_9==UNDEF||(LA88_9 >= 65 && LA88_9 <= 66)||LA88_9==68) ) {
                                    alt88=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 88, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 88, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case INTEGER_TYPE:
                            {
                            int LA88_6 = input.LA(5);

                            if ( (LA88_6==48) ) {
                                int LA88_9 = input.LA(6);

                                if ( (LA88_9==43) ) {
                                    alt88=1;
                                }
                                else if ( (LA88_9==BINARY_OP||LA88_9==BOOLEAN||LA88_9==CONVERSION_OP||LA88_9==FLOATING_POINT||(LA88_9 >= GLOBAL_VARIABLE && LA88_9 <= HEX)||LA88_9==INTEGER||LA88_9==LOCAL_VARIABLE||LA88_9==NULL||LA88_9==UNDEF||(LA88_9 >= 65 && LA88_9 <= 66)||LA88_9==68) ) {
                                    alt88=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 88, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 88, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case FLOATING_POINT_TYPE:
                            {
                            int LA88_7 = input.LA(5);

                            if ( (LA88_7==48) ) {
                                int LA88_9 = input.LA(6);

                                if ( (LA88_9==43) ) {
                                    alt88=1;
                                }
                                else if ( (LA88_9==BINARY_OP||LA88_9==BOOLEAN||LA88_9==CONVERSION_OP||LA88_9==FLOATING_POINT||(LA88_9 >= GLOBAL_VARIABLE && LA88_9 <= HEX)||LA88_9==INTEGER||LA88_9==LOCAL_VARIABLE||LA88_9==NULL||LA88_9==UNDEF||(LA88_9 >= 65 && LA88_9 <= 66)||LA88_9==68) ) {
                                    alt88=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 88, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 88, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        case LOCAL_VARIABLE:
                            {
                            int LA88_8 = input.LA(5);

                            if ( (LA88_8==48) ) {
                                int LA88_9 = input.LA(6);

                                if ( (LA88_9==43) ) {
                                    alt88=1;
                                }
                                else if ( (LA88_9==BINARY_OP||LA88_9==BOOLEAN||LA88_9==CONVERSION_OP||LA88_9==FLOATING_POINT||(LA88_9 >= GLOBAL_VARIABLE && LA88_9 <= HEX)||LA88_9==INTEGER||LA88_9==LOCAL_VARIABLE||LA88_9==NULL||LA88_9==UNDEF||(LA88_9 >= 65 && LA88_9 <= 66)||LA88_9==68) ) {
                                    alt88=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 88, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 88, 8, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 88, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;

            }
            switch (alt88) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:650:10: sct2= scalar_type
                    {
                    pushFollow(FOLLOW_scalar_type_in_cmp_expr3651);
                    sct2=scalar_type();

                    state._fsp--;


                    type2 = sct2; 

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:650:54: vt2= vector_type
                    {
                    pushFollow(FOLLOW_vector_type_in_cmp_expr3661);
                    vt2=vector_type();

                    state._fsp--;


                    type2 = vt2;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_cmp_expr3677);
            e2=expression();

            state._fsp--;


            expr2 = e2;

            match(input,42,FOLLOW_42_in_cmp_expr3688); 

            }


            expr = valueFactory.createCmpExpression(isICmp, cond, type1, expr1, type2, expr2);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "cmp_expr"



    // $ANTLR start "id_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:657:1: id_type returns [Type type] : LOCAL_VARIABLE ;
    public final Type id_type() throws RecognitionException {
        Type type = null;


        Token LOCAL_VARIABLE108=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:658:5: ( LOCAL_VARIABLE )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:658:7: LOCAL_VARIABLE
            {
            LOCAL_VARIABLE108=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_id_type3717); 

            type = typeFactory.getIDType((LOCAL_VARIABLE108!=null?LOCAL_VARIABLE108.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "id_type"



    // $ANTLR start "element_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:660:1: element_type returns [Type type] : ( BOOLEAN_TYPE | INTEGER_TYPE | FLOATING_POINT_TYPE | id_type );
    public final Type element_type() throws RecognitionException {
        Type type = null;


        Token INTEGER_TYPE109=null;
        Type id_type110 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:661:5: ( BOOLEAN_TYPE | INTEGER_TYPE | FLOATING_POINT_TYPE | id_type )
            int alt89=4;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
                {
                alt89=1;
                }
                break;
            case INTEGER_TYPE:
                {
                alt89=2;
                }
                break;
            case FLOATING_POINT_TYPE:
                {
                alt89=3;
                }
                break;
            case LOCAL_VARIABLE:
                {
                alt89=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }

            switch (alt89) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:661:7: BOOLEAN_TYPE
                    {
                    match(input,BOOLEAN_TYPE,FOLLOW_BOOLEAN_TYPE_in_element_type3735); 

                    type = typeFactory.getInt1Type();

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:662:7: INTEGER_TYPE
                    {
                    INTEGER_TYPE109=(Token)match(input,INTEGER_TYPE,FOLLOW_INTEGER_TYPE_in_element_type3745); 

                    String is = (INTEGER_TYPE109!=null?INTEGER_TYPE109.getText():null); is = is.substring(1, is.length());int i =Integer.parseInt(is);
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
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:675:7: FLOATING_POINT_TYPE
                    {
                    match(input,FLOATING_POINT_TYPE,FOLLOW_FLOATING_POINT_TYPE_in_element_type3755); 

                    type = typeFactory.getFloatType();

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:676:7: id_type
                    {
                    pushFollow(FOLLOW_id_type_in_element_type3765);
                    id_type110=id_type();

                    state._fsp--;


                    type = id_type110;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "element_type"



    // $ANTLR start "scalar_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:679:1: scalar_type returns [Type type] : ( element_type ( '*' )* ( parameter_type_list ( '*' )+ )* | structure_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ ) | union_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ ) | packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | array_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | vector_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | VOID ( parameter_type_list ( '*' )+ )+ );
    public final Type scalar_type() throws RecognitionException {
        Type type = null;


        List<Type> ptl1 =null;

        List<Type> ptl2 =null;

        Type element_type111 =null;

        List<Type> parameter_type_list112 =null;

        Type structure_type113 =null;

        Type union_type114 =null;

        Type packed_structure_type115 =null;

        List<Type> parameter_type_list116 =null;

        Type array_type117 =null;

        List<Type> parameter_type_list118 =null;

        Type vector_type119 =null;

        List<Type> parameter_type_list120 =null;

        List<Type> parameter_type_list121 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:680:5: ( element_type ( '*' )* ( parameter_type_list ( '*' )+ )* | structure_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ ) | union_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ ) | packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | array_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | vector_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | VOID ( parameter_type_list ( '*' )+ )+ )
            int alt116=7;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt116=1;
                }
                break;
            case 93:
                {
                alt116=2;
                }
                break;
            case 89:
                {
                alt116=3;
                }
                break;
            case 46:
                {
                int LA116_4 = input.LA(2);

                if ( (LA116_4==93) ) {
                    alt116=4;
                }
                else if ( (LA116_4==INTEGER) ) {
                    alt116=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 116, 4, input);

                    throw nvae;

                }
                }
                break;
            case 49:
                {
                alt116=5;
                }
                break;
            case VOID:
                {
                alt116=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }

            switch (alt116) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:680:7: element_type ( '*' )* ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_element_type_in_scalar_type3785);
                    element_type111=element_type();

                    state._fsp--;


                    type = element_type111;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:681:7: ( '*' )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==43) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:681:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_scalar_type3797); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:682:7: ( parameter_type_list ( '*' )+ )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==41) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:682:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type3812);
                    	    parameter_type_list112=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list112; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:682:152: ( '*' )+
                    	    int cnt91=0;
                    	    loop91:
                    	    do {
                    	        int alt91=2;
                    	        int LA91_0 = input.LA(1);

                    	        if ( (LA91_0==43) ) {
                    	            alt91=1;
                    	        }


                    	        switch (alt91) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:682:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_scalar_type3817); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt91 >= 1 ) break loop91;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(91, input);
                    	                throw eee;
                    	        }
                    	        cnt91++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop92;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:684:7: structure_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )
                    {
                    pushFollow(FOLLOW_structure_type_in_scalar_type3838);
                    structure_type113=structure_type();

                    state._fsp--;


                    type = structure_type113;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:685:7: ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==43) ) {
                        alt98=1;
                    }
                    else if ( (LA98_0==41) ) {
                        alt98=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 98, 0, input);

                        throw nvae;

                    }
                    switch (alt98) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:686:9: ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:686:9: ( '*' )+
                            int cnt93=0;
                            loop93:
                            do {
                                int alt93=2;
                                int LA93_0 = input.LA(1);

                                if ( (LA93_0==43) ) {
                                    alt93=1;
                                }


                                switch (alt93) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:686:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_scalar_type3859); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt93 >= 1 ) break loop93;
                                        EarlyExitException eee =
                                            new EarlyExitException(93, input);
                                        throw eee;
                                }
                                cnt93++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:687:9: (ptl1= parameter_type_list ( '*' )+ )*
                            loop95:
                            do {
                                int alt95=2;
                                int LA95_0 = input.LA(1);

                                if ( (LA95_0==41) ) {
                                    alt95=1;
                                }


                                switch (alt95) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:687:10: ptl1= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type3879);
                            	    ptl1=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:688:9: ( '*' )+
                            	    int cnt94=0;
                            	    loop94:
                            	    do {
                            	        int alt94=2;
                            	        int LA94_0 = input.LA(1);

                            	        if ( (LA94_0==43) ) {
                            	            alt94=1;
                            	        }


                            	        switch (alt94) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:688:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_scalar_type3892); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt94 >= 1 ) break loop94;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(94, input);
                            	                throw eee;
                            	        }
                            	        cnt94++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop95;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:691:9: (ptl2= parameter_type_list ( '*' )+ )+
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:691:9: (ptl2= parameter_type_list ( '*' )+ )+
                            int cnt97=0;
                            loop97:
                            do {
                                int alt97=2;
                                int LA97_0 = input.LA(1);

                                if ( (LA97_0==41) ) {
                                    alt97=1;
                                }


                                switch (alt97) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:691:10: ptl2= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type3934);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:692:9: ( '*' )+
                            	    int cnt96=0;
                            	    loop96:
                            	    do {
                            	        int alt96=2;
                            	        int LA96_0 = input.LA(1);

                            	        if ( (LA96_0==43) ) {
                            	            alt96=1;
                            	        }


                            	        switch (alt96) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:692:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_scalar_type3947); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt96 >= 1 ) break loop96;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(96, input);
                            	                throw eee;
                            	        }
                            	        cnt96++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt97 >= 1 ) break loop97;
                                        EarlyExitException eee =
                                            new EarlyExitException(97, input);
                                        throw eee;
                                }
                                cnt97++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:695:7: union_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )
                    {
                    pushFollow(FOLLOW_union_type_in_scalar_type3979);
                    union_type114=union_type();

                    state._fsp--;


                    type = union_type114;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:696:7: ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==43) ) {
                        alt104=1;
                    }
                    else if ( (LA104_0==41) ) {
                        alt104=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 104, 0, input);

                        throw nvae;

                    }
                    switch (alt104) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:697:9: ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:697:9: ( '*' )+
                            int cnt99=0;
                            loop99:
                            do {
                                int alt99=2;
                                int LA99_0 = input.LA(1);

                                if ( (LA99_0==43) ) {
                                    alt99=1;
                                }


                                switch (alt99) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:697:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_scalar_type4000); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt99 >= 1 ) break loop99;
                                        EarlyExitException eee =
                                            new EarlyExitException(99, input);
                                        throw eee;
                                }
                                cnt99++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:698:9: (ptl1= parameter_type_list ( '*' )+ )*
                            loop101:
                            do {
                                int alt101=2;
                                int LA101_0 = input.LA(1);

                                if ( (LA101_0==41) ) {
                                    alt101=1;
                                }


                                switch (alt101) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:698:10: ptl1= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type4020);
                            	    ptl1=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:699:9: ( '*' )+
                            	    int cnt100=0;
                            	    loop100:
                            	    do {
                            	        int alt100=2;
                            	        int LA100_0 = input.LA(1);

                            	        if ( (LA100_0==43) ) {
                            	            alt100=1;
                            	        }


                            	        switch (alt100) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:699:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_scalar_type4033); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt100 >= 1 ) break loop100;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(100, input);
                            	                throw eee;
                            	        }
                            	        cnt100++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop101;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:702:9: (ptl2= parameter_type_list ( '*' )+ )+
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:702:9: (ptl2= parameter_type_list ( '*' )+ )+
                            int cnt103=0;
                            loop103:
                            do {
                                int alt103=2;
                                int LA103_0 = input.LA(1);

                                if ( (LA103_0==41) ) {
                                    alt103=1;
                                }


                                switch (alt103) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:702:10: ptl2= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type4075);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:703:9: ( '*' )+
                            	    int cnt102=0;
                            	    loop102:
                            	    do {
                            	        int alt102=2;
                            	        int LA102_0 = input.LA(1);

                            	        if ( (LA102_0==43) ) {
                            	            alt102=1;
                            	        }


                            	        switch (alt102) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:703:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_scalar_type4088); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt102 >= 1 ) break loop102;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(102, input);
                            	                throw eee;
                            	        }
                            	        cnt102++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt103 >= 1 ) break loop103;
                                        EarlyExitException eee =
                                            new EarlyExitException(103, input);
                                        throw eee;
                                }
                                cnt103++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:706:7: packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_packed_structure_type_in_scalar_type4120);
                    packed_structure_type115=packed_structure_type();

                    state._fsp--;


                    type = packed_structure_type115;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:707:7: ( '*' )+
                    int cnt105=0;
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==43) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:707:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_scalar_type4133); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt105 >= 1 ) break loop105;
                                EarlyExitException eee =
                                    new EarlyExitException(105, input);
                                throw eee;
                        }
                        cnt105++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:708:7: ( parameter_type_list ( '*' )+ )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==41) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:708:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type4148);
                    	    parameter_type_list116=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list116; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:708:152: ( '*' )+
                    	    int cnt106=0;
                    	    loop106:
                    	    do {
                    	        int alt106=2;
                    	        int LA106_0 = input.LA(1);

                    	        if ( (LA106_0==43) ) {
                    	            alt106=1;
                    	        }


                    	        switch (alt106) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:708:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_scalar_type4153); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt106 >= 1 ) break loop106;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(106, input);
                    	                throw eee;
                    	        }
                    	        cnt106++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop107;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:710:7: array_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_array_type_in_scalar_type4174);
                    array_type117=array_type();

                    state._fsp--;


                    type = array_type117;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:711:7: ( '*' )+
                    int cnt108=0;
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==43) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:711:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_scalar_type4185); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt108 >= 1 ) break loop108;
                                EarlyExitException eee =
                                    new EarlyExitException(108, input);
                                throw eee;
                        }
                        cnt108++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:712:7: ( parameter_type_list ( '*' )+ )*
                    loop110:
                    do {
                        int alt110=2;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==41) ) {
                            alt110=1;
                        }


                        switch (alt110) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:712:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type4200);
                    	    parameter_type_list118=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list118; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:712:152: ( '*' )+
                    	    int cnt109=0;
                    	    loop109:
                    	    do {
                    	        int alt109=2;
                    	        int LA109_0 = input.LA(1);

                    	        if ( (LA109_0==43) ) {
                    	            alt109=1;
                    	        }


                    	        switch (alt109) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:712:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_scalar_type4205); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt109 >= 1 ) break loop109;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(109, input);
                    	                throw eee;
                    	        }
                    	        cnt109++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop110;
                        }
                    } while (true);


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:714:7: vector_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_vector_type_in_scalar_type4226);
                    vector_type119=vector_type();

                    state._fsp--;


                    type = vector_type119;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:715:7: ( '*' )+
                    int cnt111=0;
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==43) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:715:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_scalar_type4237); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt111 >= 1 ) break loop111;
                                EarlyExitException eee =
                                    new EarlyExitException(111, input);
                                throw eee;
                        }
                        cnt111++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:716:7: ( parameter_type_list ( '*' )+ )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==41) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:716:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type4252);
                    	    parameter_type_list120=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list120; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:716:152: ( '*' )+
                    	    int cnt112=0;
                    	    loop112:
                    	    do {
                    	        int alt112=2;
                    	        int LA112_0 = input.LA(1);

                    	        if ( (LA112_0==43) ) {
                    	            alt112=1;
                    	        }


                    	        switch (alt112) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:716:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_scalar_type4257); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt112 >= 1 ) break loop112;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(112, input);
                    	                throw eee;
                    	        }
                    	        cnt112++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop113;
                        }
                    } while (true);


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:718:7: VOID ( parameter_type_list ( '*' )+ )+
                    {
                    match(input,VOID,FOLLOW_VOID_in_scalar_type4278); 

                    type = typeFactory.getVoidType();

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:719:7: ( parameter_type_list ( '*' )+ )+
                    int cnt115=0;
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==41) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:719:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_scalar_type4289);
                    	    parameter_type_list121=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list121; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:719:152: ( '*' )+
                    	    int cnt114=0;
                    	    loop114:
                    	    do {
                    	        int alt114=2;
                    	        int LA114_0 = input.LA(1);

                    	        if ( (LA114_0==43) ) {
                    	            alt114=1;
                    	        }


                    	        switch (alt114) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:719:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_scalar_type4294); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt114 >= 1 ) break loop114;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(114, input);
                    	                throw eee;
                    	        }
                    	        cnt114++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt115 >= 1 ) break loop115;
                                EarlyExitException eee =
                                    new EarlyExitException(115, input);
                                throw eee;
                        }
                        cnt115++;
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "scalar_type"



    // $ANTLR start "primitive_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:733:1: primitive_type returns [Type type] : ( VOID | LABEL | METADATA | element_type );
    public final Type primitive_type() throws RecognitionException {
        Type type = null;


        Type element_type122 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:734:5: ( VOID | LABEL | METADATA | element_type )
            int alt117=4;
            switch ( input.LA(1) ) {
            case VOID:
                {
                alt117=1;
                }
                break;
            case LABEL:
                {
                alt117=2;
                }
                break;
            case METADATA:
                {
                alt117=3;
                }
                break;
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt117=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }

            switch (alt117) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:734:7: VOID
                    {
                    match(input,VOID,FOLLOW_VOID_in_primitive_type4330); 

                    type = typeFactory.getVoidType();

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:735:7: LABEL
                    {
                    match(input,LABEL,FOLLOW_LABEL_in_primitive_type4341); 

                    type = typeFactory.getLabelType();

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:736:7: METADATA
                    {
                    match(input,METADATA,FOLLOW_METADATA_in_primitive_type4351); 

                    type = typeFactory.getMetadataType();

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:737:7: element_type
                    {
                    pushFollow(FOLLOW_element_type_in_primitive_type4362);
                    element_type122=element_type();

                    state._fsp--;


                    type = element_type122;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "primitive_type"



    // $ANTLR start "first_class_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:740:1: first_class_type returns [Type type] : ( element_type ( '*' )* ( parameter_type_list ( '*' )+ )* | structure_type ( '*' )* ( parameter_type_list ( '*' )+ )* | union_type ( '*' )* ( parameter_type_list ( '*' )+ )* | packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | array_type ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )? | vector_type ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )? | VOID ( parameter_type_list ( '*' )+ )+ | LABEL | METADATA );
    public final Type first_class_type() throws RecognitionException {
        Type type = null;


        Type element_type123 =null;

        List<Type> parameter_type_list124 =null;

        Type structure_type125 =null;

        List<Type> parameter_type_list126 =null;

        Type union_type127 =null;

        List<Type> parameter_type_list128 =null;

        Type packed_structure_type129 =null;

        List<Type> parameter_type_list130 =null;

        Type array_type131 =null;

        List<Type> parameter_type_list132 =null;

        Type vector_type133 =null;

        List<Type> parameter_type_list134 =null;

        List<Type> parameter_type_list135 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:741:5: ( element_type ( '*' )* ( parameter_type_list ( '*' )+ )* | structure_type ( '*' )* ( parameter_type_list ( '*' )+ )* | union_type ( '*' )* ( parameter_type_list ( '*' )+ )* | packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | array_type ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )? | vector_type ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )? | VOID ( parameter_type_list ( '*' )+ )+ | LABEL | METADATA )
            int alt140=9;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt140=1;
                }
                break;
            case 93:
                {
                alt140=2;
                }
                break;
            case 89:
                {
                alt140=3;
                }
                break;
            case 46:
                {
                int LA140_4 = input.LA(2);

                if ( (LA140_4==93) ) {
                    alt140=4;
                }
                else if ( (LA140_4==INTEGER) ) {
                    alt140=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 140, 4, input);

                    throw nvae;

                }
                }
                break;
            case 49:
                {
                alt140=5;
                }
                break;
            case VOID:
                {
                alt140=7;
                }
                break;
            case LABEL:
                {
                alt140=8;
                }
                break;
            case METADATA:
                {
                alt140=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;

            }

            switch (alt140) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:741:7: element_type ( '*' )* ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_element_type_in_first_class_type4387);
                    element_type123=element_type();

                    state._fsp--;


                    type = element_type123;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:742:7: ( '*' )*
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( (LA118_0==43) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:742:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_first_class_type4399); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop118;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:743:7: ( parameter_type_list ( '*' )+ )*
                    loop120:
                    do {
                        int alt120=2;
                        int LA120_0 = input.LA(1);

                        if ( (LA120_0==41) ) {
                            alt120=1;
                        }


                        switch (alt120) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:743:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4413);
                    	    parameter_type_list124=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list124; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:743:152: ( '*' )+
                    	    int cnt119=0;
                    	    loop119:
                    	    do {
                    	        int alt119=2;
                    	        int LA119_0 = input.LA(1);

                    	        if ( (LA119_0==43) ) {
                    	            alt119=1;
                    	        }


                    	        switch (alt119) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:743:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_first_class_type4418); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt119 >= 1 ) break loop119;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(119, input);
                    	                throw eee;
                    	        }
                    	        cnt119++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop120;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:745:7: structure_type ( '*' )* ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_structure_type_in_first_class_type4439);
                    structure_type125=structure_type();

                    state._fsp--;


                    type = structure_type125;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:746:7: ( '*' )*
                    loop121:
                    do {
                        int alt121=2;
                        int LA121_0 = input.LA(1);

                        if ( (LA121_0==43) ) {
                            alt121=1;
                        }


                        switch (alt121) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:746:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_first_class_type4450); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop121;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:747:7: ( parameter_type_list ( '*' )+ )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==41) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:747:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4465);
                    	    parameter_type_list126=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list126; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:747:152: ( '*' )+
                    	    int cnt122=0;
                    	    loop122:
                    	    do {
                    	        int alt122=2;
                    	        int LA122_0 = input.LA(1);

                    	        if ( (LA122_0==43) ) {
                    	            alt122=1;
                    	        }


                    	        switch (alt122) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:747:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_first_class_type4470); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt122 >= 1 ) break loop122;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(122, input);
                    	                throw eee;
                    	        }
                    	        cnt122++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop123;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:749:7: union_type ( '*' )* ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_union_type_in_first_class_type4491);
                    union_type127=union_type();

                    state._fsp--;


                    type = union_type127;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:750:7: ( '*' )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==43) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:750:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_first_class_type4502); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop124;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:751:7: ( parameter_type_list ( '*' )+ )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==41) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:751:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4518);
                    	    parameter_type_list128=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list128; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:751:152: ( '*' )+
                    	    int cnt125=0;
                    	    loop125:
                    	    do {
                    	        int alt125=2;
                    	        int LA125_0 = input.LA(1);

                    	        if ( (LA125_0==43) ) {
                    	            alt125=1;
                    	        }


                    	        switch (alt125) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:751:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_first_class_type4523); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt125 >= 1 ) break loop125;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(125, input);
                    	                throw eee;
                    	        }
                    	        cnt125++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:753:7: packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_packed_structure_type_in_first_class_type4544);
                    packed_structure_type129=packed_structure_type();

                    state._fsp--;


                    type = packed_structure_type129;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:754:7: ( '*' )+
                    int cnt127=0;
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==43) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:754:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_first_class_type4555); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt127 >= 1 ) break loop127;
                                EarlyExitException eee =
                                    new EarlyExitException(127, input);
                                throw eee;
                        }
                        cnt127++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:755:7: ( parameter_type_list ( '*' )+ )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==41) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:755:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4569);
                    	    parameter_type_list130=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list130; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:755:152: ( '*' )+
                    	    int cnt128=0;
                    	    loop128:
                    	    do {
                    	        int alt128=2;
                    	        int LA128_0 = input.LA(1);

                    	        if ( (LA128_0==43) ) {
                    	            alt128=1;
                    	        }


                    	        switch (alt128) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:755:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_first_class_type4574); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt128 >= 1 ) break loop128;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(128, input);
                    	                throw eee;
                    	        }
                    	        cnt128++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop129;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:757:7: array_type ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )?
                    {
                    pushFollow(FOLLOW_array_type_in_first_class_type4595);
                    array_type131=array_type();

                    state._fsp--;


                    type = array_type131;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:758:7: ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )?
                    int alt133=2;
                    int LA133_0 = input.LA(1);

                    if ( (LA133_0==43) ) {
                        alt133=1;
                    }
                    switch (alt133) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:759:9: ( '*' )+ ( parameter_type_list ( '*' )+ )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:759:9: ( '*' )+
                            int cnt130=0;
                            loop130:
                            do {
                                int alt130=2;
                                int LA130_0 = input.LA(1);

                                if ( (LA130_0==43) ) {
                                    alt130=1;
                                }


                                switch (alt130) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:759:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_first_class_type4616); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt130 >= 1 ) break loop130;
                                        EarlyExitException eee =
                                            new EarlyExitException(130, input);
                                        throw eee;
                                }
                                cnt130++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:760:9: ( parameter_type_list ( '*' )+ )*
                            loop132:
                            do {
                                int alt132=2;
                                int LA132_0 = input.LA(1);

                                if ( (LA132_0==41) ) {
                                    alt132=1;
                                }


                                switch (alt132) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:760:10: parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4633);
                            	    parameter_type_list132=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList = parameter_type_list132; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:760:154: ( '*' )+
                            	    int cnt131=0;
                            	    loop131:
                            	    do {
                            	        int alt131=2;
                            	        int LA131_0 = input.LA(1);

                            	        if ( (LA131_0==43) ) {
                            	            alt131=1;
                            	        }


                            	        switch (alt131) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:760:155: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_first_class_type4638); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt131 >= 1 ) break loop131;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(131, input);
                            	                throw eee;
                            	        }
                            	        cnt131++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop132;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:763:7: vector_type ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )?
                    {
                    pushFollow(FOLLOW_vector_type_in_first_class_type4670);
                    vector_type133=vector_type();

                    state._fsp--;


                    type = vector_type133;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:764:7: ( ( '*' )+ ( parameter_type_list ( '*' )+ )* )?
                    int alt137=2;
                    int LA137_0 = input.LA(1);

                    if ( (LA137_0==43) ) {
                        alt137=1;
                    }
                    switch (alt137) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:765:9: ( '*' )+ ( parameter_type_list ( '*' )+ )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:765:9: ( '*' )+
                            int cnt134=0;
                            loop134:
                            do {
                                int alt134=2;
                                int LA134_0 = input.LA(1);

                                if ( (LA134_0==43) ) {
                                    alt134=1;
                                }


                                switch (alt134) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:765:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_first_class_type4691); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt134 >= 1 ) break loop134;
                                        EarlyExitException eee =
                                            new EarlyExitException(134, input);
                                        throw eee;
                                }
                                cnt134++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:766:9: ( parameter_type_list ( '*' )+ )*
                            loop136:
                            do {
                                int alt136=2;
                                int LA136_0 = input.LA(1);

                                if ( (LA136_0==41) ) {
                                    alt136=1;
                                }


                                switch (alt136) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:766:10: parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4708);
                            	    parameter_type_list134=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList = parameter_type_list134; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:766:154: ( '*' )+
                            	    int cnt135=0;
                            	    loop135:
                            	    do {
                            	        int alt135=2;
                            	        int LA135_0 = input.LA(1);

                            	        if ( (LA135_0==43) ) {
                            	            alt135=1;
                            	        }


                            	        switch (alt135) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:766:155: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_first_class_type4713); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt135 >= 1 ) break loop135;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(135, input);
                            	                throw eee;
                            	        }
                            	        cnt135++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop136;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:769:7: VOID ( parameter_type_list ( '*' )+ )+
                    {
                    match(input,VOID,FOLLOW_VOID_in_first_class_type4745); 

                    type = typeFactory.getVoidType();

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:770:7: ( parameter_type_list ( '*' )+ )+
                    int cnt139=0;
                    loop139:
                    do {
                        int alt139=2;
                        int LA139_0 = input.LA(1);

                        if ( (LA139_0==41) ) {
                            alt139=1;
                        }


                        switch (alt139) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:770:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_first_class_type4756);
                    	    parameter_type_list135=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list135; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:770:152: ( '*' )+
                    	    int cnt138=0;
                    	    loop138:
                    	    do {
                    	        int alt138=2;
                    	        int LA138_0 = input.LA(1);

                    	        if ( (LA138_0==43) ) {
                    	            alt138=1;
                    	        }


                    	        switch (alt138) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:770:153: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_first_class_type4761); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt138 >= 1 ) break loop138;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(138, input);
                    	                throw eee;
                    	        }
                    	        cnt138++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt139 >= 1 ) break loop139;
                                EarlyExitException eee =
                                    new EarlyExitException(139, input);
                                throw eee;
                        }
                        cnt139++;
                    } while (true);


                    }
                    break;
                case 8 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:772:7: LABEL
                    {
                    match(input,LABEL,FOLLOW_LABEL_in_first_class_type4782); 

                    type = typeFactory.getLabelType();

                    }
                    break;
                case 9 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:773:7: METADATA
                    {
                    match(input,METADATA,FOLLOW_METADATA_in_first_class_type4792); 

                    type = typeFactory.getMetadataType();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "first_class_type"



    // $ANTLR start "derived_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:776:1: derived_type returns [Type type] : ( element_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? | structure_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? | union_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? | packed_structure_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )? | array_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )? | vector_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )? | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* | LABEL | METADATA | OPAQUE );
    public final Type derived_type() throws RecognitionException {
        Type type = null;


        List<Type> ptl1 =null;

        List<Type> ptl2 =null;

        Type element_type136 =null;

        Type structure_type137 =null;

        Type union_type138 =null;

        Type packed_structure_type139 =null;

        Type array_type140 =null;

        Type vector_type141 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:777:5: ( element_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? | structure_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? | union_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? | packed_structure_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )? | array_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )? | vector_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )? | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* | LABEL | METADATA | OPAQUE )
            int alt177=10;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt177=1;
                }
                break;
            case 93:
                {
                alt177=2;
                }
                break;
            case 89:
                {
                alt177=3;
                }
                break;
            case 46:
                {
                int LA177_4 = input.LA(2);

                if ( (LA177_4==93) ) {
                    alt177=4;
                }
                else if ( (LA177_4==INTEGER) ) {
                    alt177=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 177, 4, input);

                    throw nvae;

                }
                }
                break;
            case 49:
                {
                alt177=5;
                }
                break;
            case VOID:
                {
                alt177=7;
                }
                break;
            case LABEL:
                {
                alt177=8;
                }
                break;
            case METADATA:
                {
                alt177=9;
                }
                break;
            case OPAQUE:
                {
                alt177=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 177, 0, input);

                throw nvae;

            }

            switch (alt177) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:777:7: element_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                    {
                    pushFollow(FOLLOW_element_type_in_derived_type4817);
                    element_type136=element_type();

                    state._fsp--;


                    type = element_type136;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:778:7: ( '*' )*
                    loop141:
                    do {
                        int alt141=2;
                        int LA141_0 = input.LA(1);

                        if ( (LA141_0==43) ) {
                            alt141=1;
                        }


                        switch (alt141) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:778:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_derived_type4829); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop141;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:779:7: (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                    int alt145=2;
                    int LA145_0 = input.LA(1);

                    if ( (LA145_0==41) ) {
                        alt145=1;
                    }
                    switch (alt145) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:779:8: ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                            {
                            pushFollow(FOLLOW_parameter_type_list_in_derived_type4848);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:780:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop143:
                            do {
                                int alt143=2;
                                alt143 = dfa143.predict(input);
                                switch (alt143) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:780:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:780:10: ( '*' )+
                            	    int cnt142=0;
                            	    loop142:
                            	    do {
                            	        int alt142=2;
                            	        int LA142_0 = input.LA(1);

                            	        if ( (LA142_0==43) ) {
                            	            alt142=1;
                            	        }


                            	        switch (alt142) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:780:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_derived_type4862); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt142 >= 1 ) break loop142;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(142, input);
                            	                throw eee;
                            	        }
                            	        cnt142++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_derived_type4882);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop143;
                                }
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:783:9: ( '*' )*
                            loop144:
                            do {
                                int alt144=2;
                                int LA144_0 = input.LA(1);

                                if ( (LA144_0==43) ) {
                                    alt144=1;
                                }


                                switch (alt144) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:783:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_derived_type4907); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop144;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:785:7: structure_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                    {
                    pushFollow(FOLLOW_structure_type_in_derived_type4930);
                    structure_type137=structure_type();

                    state._fsp--;


                    type = structure_type137;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:786:7: ( '*' )*
                    loop146:
                    do {
                        int alt146=2;
                        int LA146_0 = input.LA(1);

                        if ( (LA146_0==43) ) {
                            alt146=1;
                        }


                        switch (alt146) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:786:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_derived_type4942); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop146;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:787:7: (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                    int alt150=2;
                    int LA150_0 = input.LA(1);

                    if ( (LA150_0==41) ) {
                        alt150=1;
                    }
                    switch (alt150) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:787:8: ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                            {
                            pushFollow(FOLLOW_parameter_type_list_in_derived_type4960);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:788:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop148:
                            do {
                                int alt148=2;
                                alt148 = dfa148.predict(input);
                                switch (alt148) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:788:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:788:10: ( '*' )+
                            	    int cnt147=0;
                            	    loop147:
                            	    do {
                            	        int alt147=2;
                            	        int LA147_0 = input.LA(1);

                            	        if ( (LA147_0==43) ) {
                            	            alt147=1;
                            	        }


                            	        switch (alt147) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:788:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_derived_type4974); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt147 >= 1 ) break loop147;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(147, input);
                            	                throw eee;
                            	        }
                            	        cnt147++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_derived_type4994);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop148;
                                }
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:791:9: ( '*' )*
                            loop149:
                            do {
                                int alt149=2;
                                int LA149_0 = input.LA(1);

                                if ( (LA149_0==43) ) {
                                    alt149=1;
                                }


                                switch (alt149) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:791:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_derived_type5018); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop149;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:793:7: union_type ( '*' )* (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                    {
                    pushFollow(FOLLOW_union_type_in_derived_type5041);
                    union_type138=union_type();

                    state._fsp--;


                    type = union_type138;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:794:7: ( '*' )*
                    loop151:
                    do {
                        int alt151=2;
                        int LA151_0 = input.LA(1);

                        if ( (LA151_0==43) ) {
                            alt151=1;
                        }


                        switch (alt151) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:794:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_derived_type5053); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop151;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:795:7: (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                    int alt155=2;
                    int LA155_0 = input.LA(1);

                    if ( (LA155_0==41) ) {
                        alt155=1;
                    }
                    switch (alt155) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:795:8: ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                            {
                            pushFollow(FOLLOW_parameter_type_list_in_derived_type5071);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:796:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop153:
                            do {
                                int alt153=2;
                                alt153 = dfa153.predict(input);
                                switch (alt153) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:796:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:796:10: ( '*' )+
                            	    int cnt152=0;
                            	    loop152:
                            	    do {
                            	        int alt152=2;
                            	        int LA152_0 = input.LA(1);

                            	        if ( (LA152_0==43) ) {
                            	            alt152=1;
                            	        }


                            	        switch (alt152) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:796:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_derived_type5085); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt152 >= 1 ) break loop152;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(152, input);
                            	                throw eee;
                            	        }
                            	        cnt152++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_derived_type5105);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop153;
                                }
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:799:9: ( '*' )*
                            loop154:
                            do {
                                int alt154=2;
                                int LA154_0 = input.LA(1);

                                if ( (LA154_0==43) ) {
                                    alt154=1;
                                }


                                switch (alt154) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:799:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_derived_type5129); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop154;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:801:7: packed_structure_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )?
                    {
                    pushFollow(FOLLOW_packed_structure_type_in_derived_type5152);
                    packed_structure_type139=packed_structure_type();

                    state._fsp--;


                    type = packed_structure_type139;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:802:7: ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )?
                    int alt161=2;
                    int LA161_0 = input.LA(1);

                    if ( (LA161_0==43) ) {
                        alt161=1;
                    }
                    switch (alt161) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:802:8: ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:802:8: ( '*' )+
                            int cnt156=0;
                            loop156:
                            do {
                                int alt156=2;
                                int LA156_0 = input.LA(1);

                                if ( (LA156_0==43) ) {
                                    alt156=1;
                                }


                                switch (alt156) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:802:9: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_derived_type5165); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt156 >= 1 ) break loop156;
                                        EarlyExitException eee =
                                            new EarlyExitException(156, input);
                                        throw eee;
                                }
                                cnt156++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:803:7: (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                            int alt160=2;
                            int LA160_0 = input.LA(1);

                            if ( (LA160_0==41) ) {
                                alt160=1;
                            }
                            switch (alt160) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:803:8: ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                                    {
                                    pushFollow(FOLLOW_parameter_type_list_in_derived_type5183);
                                    ptl1=parameter_type_list();

                                    state._fsp--;


                                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:804:9: ( ( '*' )+ ptl2= parameter_type_list )*
                                    loop158:
                                    do {
                                        int alt158=2;
                                        alt158 = dfa158.predict(input);
                                        switch (alt158) {
                                    	case 1 :
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:804:10: ( '*' )+ ptl2= parameter_type_list
                                    	    {
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:804:10: ( '*' )+
                                    	    int cnt157=0;
                                    	    loop157:
                                    	    do {
                                    	        int alt157=2;
                                    	        int LA157_0 = input.LA(1);

                                    	        if ( (LA157_0==43) ) {
                                    	            alt157=1;
                                    	        }


                                    	        switch (alt157) {
                                    	    	case 1 :
                                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:804:11: '*'
                                    	    	    {
                                    	    	    match(input,43,FOLLOW_43_in_derived_type5197); 

                                    	    	    type = typeFactory.getPointerType(type);

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    if ( cnt157 >= 1 ) break loop157;
                                    	                EarlyExitException eee =
                                    	                    new EarlyExitException(157, input);
                                    	                throw eee;
                                    	        }
                                    	        cnt157++;
                                    	    } while (true);


                                    	    pushFollow(FOLLOW_parameter_type_list_in_derived_type5217);
                                    	    ptl2=parameter_type_list();

                                    	    state._fsp--;


                                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop158;
                                        }
                                    } while (true);


                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:807:9: ( '*' )*
                                    loop159:
                                    do {
                                        int alt159=2;
                                        int LA159_0 = input.LA(1);

                                        if ( (LA159_0==43) ) {
                                            alt159=1;
                                        }


                                        switch (alt159) {
                                    	case 1 :
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:807:10: '*'
                                    	    {
                                    	    match(input,43,FOLLOW_43_in_derived_type5241); 

                                    	    type = typeFactory.getPointerType(type);

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop159;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:809:7: array_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )?
                    {
                    pushFollow(FOLLOW_array_type_in_derived_type5266);
                    array_type140=array_type();

                    state._fsp--;


                    type = array_type140;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:810:7: ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )?
                    int alt167=2;
                    int LA167_0 = input.LA(1);

                    if ( (LA167_0==43) ) {
                        alt167=1;
                    }
                    switch (alt167) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:810:8: ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:810:8: ( '*' )+
                            int cnt162=0;
                            loop162:
                            do {
                                int alt162=2;
                                int LA162_0 = input.LA(1);

                                if ( (LA162_0==43) ) {
                                    alt162=1;
                                }


                                switch (alt162) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:810:9: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_derived_type5279); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt162 >= 1 ) break loop162;
                                        EarlyExitException eee =
                                            new EarlyExitException(162, input);
                                        throw eee;
                                }
                                cnt162++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:811:7: (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                            int alt166=2;
                            int LA166_0 = input.LA(1);

                            if ( (LA166_0==41) ) {
                                alt166=1;
                            }
                            switch (alt166) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:811:8: ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                                    {
                                    pushFollow(FOLLOW_parameter_type_list_in_derived_type5297);
                                    ptl1=parameter_type_list();

                                    state._fsp--;


                                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:812:9: ( ( '*' )+ ptl2= parameter_type_list )*
                                    loop164:
                                    do {
                                        int alt164=2;
                                        alt164 = dfa164.predict(input);
                                        switch (alt164) {
                                    	case 1 :
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:812:10: ( '*' )+ ptl2= parameter_type_list
                                    	    {
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:812:10: ( '*' )+
                                    	    int cnt163=0;
                                    	    loop163:
                                    	    do {
                                    	        int alt163=2;
                                    	        int LA163_0 = input.LA(1);

                                    	        if ( (LA163_0==43) ) {
                                    	            alt163=1;
                                    	        }


                                    	        switch (alt163) {
                                    	    	case 1 :
                                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:812:11: '*'
                                    	    	    {
                                    	    	    match(input,43,FOLLOW_43_in_derived_type5311); 

                                    	    	    type = typeFactory.getPointerType(type);

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    if ( cnt163 >= 1 ) break loop163;
                                    	                EarlyExitException eee =
                                    	                    new EarlyExitException(163, input);
                                    	                throw eee;
                                    	        }
                                    	        cnt163++;
                                    	    } while (true);


                                    	    pushFollow(FOLLOW_parameter_type_list_in_derived_type5331);
                                    	    ptl2=parameter_type_list();

                                    	    state._fsp--;


                                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop164;
                                        }
                                    } while (true);


                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:815:9: ( '*' )*
                                    loop165:
                                    do {
                                        int alt165=2;
                                        int LA165_0 = input.LA(1);

                                        if ( (LA165_0==43) ) {
                                            alt165=1;
                                        }


                                        switch (alt165) {
                                    	case 1 :
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:815:10: '*'
                                    	    {
                                    	    match(input,43,FOLLOW_43_in_derived_type5355); 

                                    	    type = typeFactory.getPointerType(type);

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop165;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:817:7: vector_type ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )?
                    {
                    pushFollow(FOLLOW_vector_type_in_derived_type5380);
                    vector_type141=vector_type();

                    state._fsp--;


                    type = vector_type141;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:818:7: ( ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )? )?
                    int alt173=2;
                    int LA173_0 = input.LA(1);

                    if ( (LA173_0==43) ) {
                        alt173=1;
                    }
                    switch (alt173) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:818:8: ( '*' )+ (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:818:8: ( '*' )+
                            int cnt168=0;
                            loop168:
                            do {
                                int alt168=2;
                                int LA168_0 = input.LA(1);

                                if ( (LA168_0==43) ) {
                                    alt168=1;
                                }


                                switch (alt168) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:818:9: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_derived_type5392); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt168 >= 1 ) break loop168;
                                        EarlyExitException eee =
                                            new EarlyExitException(168, input);
                                        throw eee;
                                }
                                cnt168++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:819:7: (ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )* )?
                            int alt172=2;
                            int LA172_0 = input.LA(1);

                            if ( (LA172_0==41) ) {
                                alt172=1;
                            }
                            switch (alt172) {
                                case 1 :
                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:819:8: ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                                    {
                                    pushFollow(FOLLOW_parameter_type_list_in_derived_type5410);
                                    ptl1=parameter_type_list();

                                    state._fsp--;


                                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:820:9: ( ( '*' )+ ptl2= parameter_type_list )*
                                    loop170:
                                    do {
                                        int alt170=2;
                                        alt170 = dfa170.predict(input);
                                        switch (alt170) {
                                    	case 1 :
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:820:10: ( '*' )+ ptl2= parameter_type_list
                                    	    {
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:820:10: ( '*' )+
                                    	    int cnt169=0;
                                    	    loop169:
                                    	    do {
                                    	        int alt169=2;
                                    	        int LA169_0 = input.LA(1);

                                    	        if ( (LA169_0==43) ) {
                                    	            alt169=1;
                                    	        }


                                    	        switch (alt169) {
                                    	    	case 1 :
                                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:820:11: '*'
                                    	    	    {
                                    	    	    match(input,43,FOLLOW_43_in_derived_type5424); 

                                    	    	    type = typeFactory.getPointerType(type);

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    if ( cnt169 >= 1 ) break loop169;
                                    	                EarlyExitException eee =
                                    	                    new EarlyExitException(169, input);
                                    	                throw eee;
                                    	        }
                                    	        cnt169++;
                                    	    } while (true);


                                    	    pushFollow(FOLLOW_parameter_type_list_in_derived_type5444);
                                    	    ptl2=parameter_type_list();

                                    	    state._fsp--;


                                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop170;
                                        }
                                    } while (true);


                                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:823:9: ( '*' )*
                                    loop171:
                                    do {
                                        int alt171=2;
                                        int LA171_0 = input.LA(1);

                                        if ( (LA171_0==43) ) {
                                            alt171=1;
                                        }


                                        switch (alt171) {
                                    	case 1 :
                                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:823:10: '*'
                                    	    {
                                    	    match(input,43,FOLLOW_43_in_derived_type5468); 

                                    	    type = typeFactory.getPointerType(type);

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop171;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:825:7: VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ( '*' )*
                    {
                    match(input,VOID,FOLLOW_VOID_in_derived_type5493); 

                    type = typeFactory.getVoidType();

                    pushFollow(FOLLOW_parameter_type_list_in_derived_type5508);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:827:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop175:
                    do {
                        int alt175=2;
                        alt175 = dfa175.predict(input);
                        switch (alt175) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:827:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:827:8: ( '*' )+
                    	    int cnt174=0;
                    	    loop174:
                    	    do {
                    	        int alt174=2;
                    	        int LA174_0 = input.LA(1);

                    	        if ( (LA174_0==43) ) {
                    	            alt174=1;
                    	        }


                    	        switch (alt174) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:827:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_derived_type5520); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt174 >= 1 ) break loop174;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(174, input);
                    	                throw eee;
                    	        }
                    	        cnt174++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_derived_type5538);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop175;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:830:7: ( '*' )*
                    loop176:
                    do {
                        int alt176=2;
                        int LA176_0 = input.LA(1);

                        if ( (LA176_0==43) ) {
                            alt176=1;
                        }


                        switch (alt176) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:830:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_derived_type5558); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop176;
                        }
                    } while (true);


                    }
                    break;
                case 8 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:831:7: LABEL
                    {
                    match(input,LABEL,FOLLOW_LABEL_in_derived_type5572); 

                    type = typeFactory.getLabelType();

                    }
                    break;
                case 9 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:832:7: METADATA
                    {
                    match(input,METADATA,FOLLOW_METADATA_in_derived_type5582); 

                    type = typeFactory.getMetadataType();

                    }
                    break;
                case 10 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:833:7: OPAQUE
                    {
                    match(input,OPAQUE,FOLLOW_OPAQUE_in_derived_type5593); 

                    type = typeFactory.getOpaqueType();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "derived_type"



    // $ANTLR start "aggregate_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:836:1: aggregate_type returns [Type type] : ( array_type | structure_type | union_type | id_type );
    public final Type aggregate_type() throws RecognitionException {
        Type type = null;


        Type array_type142 =null;

        Type structure_type143 =null;

        Type union_type144 =null;

        Type id_type145 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:837:5: ( array_type | structure_type | union_type | id_type )
            int alt178=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt178=1;
                }
                break;
            case 93:
                {
                alt178=2;
                }
                break;
            case 89:
                {
                alt178=3;
                }
                break;
            case LOCAL_VARIABLE:
                {
                alt178=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 178, 0, input);

                throw nvae;

            }

            switch (alt178) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:837:7: array_type
                    {
                    pushFollow(FOLLOW_array_type_in_aggregate_type5617);
                    array_type142=array_type();

                    state._fsp--;


                    type = array_type142;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:838:7: structure_type
                    {
                    pushFollow(FOLLOW_structure_type_in_aggregate_type5627);
                    structure_type143=structure_type();

                    state._fsp--;


                    type = structure_type143;

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:839:7: union_type
                    {
                    pushFollow(FOLLOW_union_type_in_aggregate_type5637);
                    union_type144=union_type();

                    state._fsp--;


                    type = union_type144;

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:840:7: id_type
                    {
                    pushFollow(FOLLOW_id_type_in_aggregate_type5647);
                    id_type145=id_type();

                    state._fsp--;


                    type = id_type145;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "aggregate_type"



    // $ANTLR start "pointer_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:843:1: pointer_type returns [Type type] : ( element_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | union_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | packed_structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | array_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | vector_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ) ( '*' )+ ;
    public final Type pointer_type() throws RecognitionException {
        Type type = null;


        List<Type> ptl1 =null;

        List<Type> ptl2 =null;

        Type element_type146 =null;

        Type structure_type147 =null;

        Type union_type148 =null;

        Type packed_structure_type149 =null;

        Type array_type150 =null;

        Type vector_type151 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:844:4: ( ( element_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | union_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | packed_structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | array_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | vector_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ) ( '*' )+ )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:845:4: ( element_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | union_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | packed_structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | array_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | vector_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* ) ( '*' )+
            {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:845:4: ( element_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | union_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | packed_structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | array_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | vector_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )? | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )
            int alt205=7;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt205=1;
                }
                break;
            case 93:
                {
                alt205=2;
                }
                break;
            case 89:
                {
                alt205=3;
                }
                break;
            case 46:
                {
                int LA205_4 = input.LA(2);

                if ( (LA205_4==93) ) {
                    alt205=4;
                }
                else if ( (LA205_4==INTEGER) ) {
                    alt205=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 205, 4, input);

                    throw nvae;

                }
                }
                break;
            case 49:
                {
                alt205=5;
                }
                break;
            case VOID:
                {
                alt205=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 205, 0, input);

                throw nvae;

            }

            switch (alt205) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:846:7: element_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    {
                    pushFollow(FOLLOW_element_type_in_pointer_type5681);
                    element_type146=element_type();

                    state._fsp--;


                    type = element_type146;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:847:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    int alt182=2;
                    alt182 = dfa182.predict(input);
                    switch (alt182) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:847:9: ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:847:9: ( '*' )*
                            loop179:
                            do {
                                int alt179=2;
                                int LA179_0 = input.LA(1);

                                if ( (LA179_0==43) ) {
                                    alt179=1;
                                }


                                switch (alt179) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:847:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_pointer_type5696); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop179;
                                }
                            } while (true);


                            pushFollow(FOLLOW_parameter_type_list_in_pointer_type5716);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:849:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop181:
                            do {
                                int alt181=2;
                                alt181 = dfa181.predict(input);
                                switch (alt181) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:849:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:849:10: ( '*' )+
                            	    int cnt180=0;
                            	    loop180:
                            	    do {
                            	        int alt180=2;
                            	        int LA180_0 = input.LA(1);

                            	        if ( (LA180_0==43) ) {
                            	            alt180=1;
                            	        }


                            	        switch (alt180) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:849:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_pointer_type5730); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt180 >= 1 ) break loop180;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(180, input);
                            	                throw eee;
                            	        }
                            	        cnt180++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type5750);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop181;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:853:7: structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    {
                    pushFollow(FOLLOW_structure_type_in_pointer_type5780);
                    structure_type147=structure_type();

                    state._fsp--;


                    type = structure_type147;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:854:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    int alt186=2;
                    alt186 = dfa186.predict(input);
                    switch (alt186) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:854:9: ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:854:9: ( '*' )*
                            loop183:
                            do {
                                int alt183=2;
                                int LA183_0 = input.LA(1);

                                if ( (LA183_0==43) ) {
                                    alt183=1;
                                }


                                switch (alt183) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:854:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_pointer_type5795); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop183;
                                }
                            } while (true);


                            pushFollow(FOLLOW_parameter_type_list_in_pointer_type5815);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:856:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop185:
                            do {
                                int alt185=2;
                                alt185 = dfa185.predict(input);
                                switch (alt185) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:856:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:856:10: ( '*' )+
                            	    int cnt184=0;
                            	    loop184:
                            	    do {
                            	        int alt184=2;
                            	        int LA184_0 = input.LA(1);

                            	        if ( (LA184_0==43) ) {
                            	            alt184=1;
                            	        }


                            	        switch (alt184) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:856:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_pointer_type5829); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt184 >= 1 ) break loop184;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(184, input);
                            	                throw eee;
                            	        }
                            	        cnt184++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type5849);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop185;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:860:7: union_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    {
                    pushFollow(FOLLOW_union_type_in_pointer_type5879);
                    union_type148=union_type();

                    state._fsp--;


                    type = union_type148;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:861:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    int alt190=2;
                    alt190 = dfa190.predict(input);
                    switch (alt190) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:861:9: ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:861:9: ( '*' )*
                            loop187:
                            do {
                                int alt187=2;
                                int LA187_0 = input.LA(1);

                                if ( (LA187_0==43) ) {
                                    alt187=1;
                                }


                                switch (alt187) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:861:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_pointer_type5893); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop187;
                                }
                            } while (true);


                            pushFollow(FOLLOW_parameter_type_list_in_pointer_type5913);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:863:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop189:
                            do {
                                int alt189=2;
                                alt189 = dfa189.predict(input);
                                switch (alt189) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:863:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:863:10: ( '*' )+
                            	    int cnt188=0;
                            	    loop188:
                            	    do {
                            	        int alt188=2;
                            	        int LA188_0 = input.LA(1);

                            	        if ( (LA188_0==43) ) {
                            	            alt188=1;
                            	        }


                            	        switch (alt188) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:863:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_pointer_type5927); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt188 >= 1 ) break loop188;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(188, input);
                            	                throw eee;
                            	        }
                            	        cnt188++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type5947);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop189;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:867:7: packed_structure_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    {
                    pushFollow(FOLLOW_packed_structure_type_in_pointer_type5977);
                    packed_structure_type149=packed_structure_type();

                    state._fsp--;


                    type = packed_structure_type149;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:868:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    int alt194=2;
                    alt194 = dfa194.predict(input);
                    switch (alt194) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:868:9: ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:868:9: ( '*' )*
                            loop191:
                            do {
                                int alt191=2;
                                int LA191_0 = input.LA(1);

                                if ( (LA191_0==43) ) {
                                    alt191=1;
                                }


                                switch (alt191) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:868:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_pointer_type5992); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop191;
                                }
                            } while (true);


                            pushFollow(FOLLOW_parameter_type_list_in_pointer_type6012);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:870:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop193:
                            do {
                                int alt193=2;
                                alt193 = dfa193.predict(input);
                                switch (alt193) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:870:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:870:10: ( '*' )+
                            	    int cnt192=0;
                            	    loop192:
                            	    do {
                            	        int alt192=2;
                            	        int LA192_0 = input.LA(1);

                            	        if ( (LA192_0==43) ) {
                            	            alt192=1;
                            	        }


                            	        switch (alt192) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:870:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_pointer_type6026); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt192 >= 1 ) break loop192;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(192, input);
                            	                throw eee;
                            	        }
                            	        cnt192++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type6046);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop193;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:874:7: array_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    {
                    pushFollow(FOLLOW_array_type_in_pointer_type6076);
                    array_type150=array_type();

                    state._fsp--;


                    type = array_type150;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:875:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    int alt198=2;
                    alt198 = dfa198.predict(input);
                    switch (alt198) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:875:9: ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:875:9: ( '*' )*
                            loop195:
                            do {
                                int alt195=2;
                                int LA195_0 = input.LA(1);

                                if ( (LA195_0==43) ) {
                                    alt195=1;
                                }


                                switch (alt195) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:875:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_pointer_type6091); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop195;
                                }
                            } while (true);


                            pushFollow(FOLLOW_parameter_type_list_in_pointer_type6111);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:877:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop197:
                            do {
                                int alt197=2;
                                alt197 = dfa197.predict(input);
                                switch (alt197) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:877:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:877:10: ( '*' )+
                            	    int cnt196=0;
                            	    loop196:
                            	    do {
                            	        int alt196=2;
                            	        int LA196_0 = input.LA(1);

                            	        if ( (LA196_0==43) ) {
                            	            alt196=1;
                            	        }


                            	        switch (alt196) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:877:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_pointer_type6125); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt196 >= 1 ) break loop196;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(196, input);
                            	                throw eee;
                            	        }
                            	        cnt196++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type6145);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop197;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:881:7: vector_type ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    {
                    pushFollow(FOLLOW_vector_type_in_pointer_type6175);
                    vector_type151=vector_type();

                    state._fsp--;


                    type = vector_type151;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:882:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?
                    int alt202=2;
                    alt202 = dfa202.predict(input);
                    switch (alt202) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:882:9: ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:882:9: ( '*' )*
                            loop199:
                            do {
                                int alt199=2;
                                int LA199_0 = input.LA(1);

                                if ( (LA199_0==43) ) {
                                    alt199=1;
                                }


                                switch (alt199) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:882:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_pointer_type6189); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    break loop199;
                                }
                            } while (true);


                            pushFollow(FOLLOW_parameter_type_list_in_pointer_type6209);
                            ptl1=parameter_type_list();

                            state._fsp--;


                            List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:884:9: ( ( '*' )+ ptl2= parameter_type_list )*
                            loop201:
                            do {
                                int alt201=2;
                                alt201 = dfa201.predict(input);
                                switch (alt201) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:884:10: ( '*' )+ ptl2= parameter_type_list
                            	    {
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:884:10: ( '*' )+
                            	    int cnt200=0;
                            	    loop200:
                            	    do {
                            	        int alt200=2;
                            	        int LA200_0 = input.LA(1);

                            	        if ( (LA200_0==43) ) {
                            	            alt200=1;
                            	        }


                            	        switch (alt200) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:884:11: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_pointer_type6223); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt200 >= 1 ) break loop200;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(200, input);
                            	                throw eee;
                            	        }
                            	        cnt200++;
                            	    } while (true);


                            	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type6243);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    }
                            	    break;

                            	default :
                            	    break loop201;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:888:7: VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    match(input,VOID,FOLLOW_VOID_in_pointer_type6277); 

                    type = typeFactory.getVoidType();

                    pushFollow(FOLLOW_parameter_type_list_in_pointer_type6295);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:890:9: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop204:
                    do {
                        int alt204=2;
                        alt204 = dfa204.predict(input);
                        switch (alt204) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:890:10: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:890:10: ( '*' )+
                    	    int cnt203=0;
                    	    loop203:
                    	    do {
                    	        int alt203=2;
                    	        int LA203_0 = input.LA(1);

                    	        if ( (LA203_0==43) ) {
                    	            alt203=1;
                    	        }


                    	        switch (alt203) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:890:11: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_pointer_type6309); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt203 >= 1 ) break loop203;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(203, input);
                    	                throw eee;
                    	        }
                    	        cnt203++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_pointer_type6329);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop204;
                        }
                    } while (true);


                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:893:6: ( '*' )+
            int cnt206=0;
            loop206:
            do {
                int alt206=2;
                int LA206_0 = input.LA(1);

                if ( (LA206_0==43) ) {
                    alt206=1;
                }


                switch (alt206) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:893:7: '*'
            	    {
            	    match(input,43,FOLLOW_43_in_pointer_type6350); 

            	    type = typeFactory.getPointerType(type);

            	    }
            	    break;

            	default :
            	    if ( cnt206 >= 1 ) break loop206;
                        EarlyExitException eee =
                            new EarlyExitException(206, input);
                        throw eee;
                }
                cnt206++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "pointer_type"



    // $ANTLR start "structure_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:895:1: structure_type returns [Type type] : '{' ( type_list )? '}' ;
    public final Type structure_type() throws RecognitionException {
        Type type = null;


        List<Type> type_list152 =null;



          List<Type> typeList = null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:899:5: ( '{' ( type_list )? '}' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:899:7: '{' ( type_list )? '}'
            {
            match(input,93,FOLLOW_93_in_structure_type6376); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:899:11: ( type_list )?
            int alt207=2;
            int LA207_0 = input.LA(1);

            if ( (LA207_0==BOOLEAN_TYPE||LA207_0==FLOATING_POINT_TYPE||(LA207_0 >= INTEGER_TYPE && LA207_0 <= LABEL)||(LA207_0 >= LOCAL_VARIABLE && LA207_0 <= METADATA)||LA207_0==OPAQUE||LA207_0==VOID||LA207_0==46||LA207_0==49||LA207_0==89||LA207_0==93) ) {
                alt207=1;
            }
            switch (alt207) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:899:12: type_list
                    {
                    pushFollow(FOLLOW_type_list_in_structure_type6379);
                    type_list152=type_list();

                    state._fsp--;


                    typeList = type_list152;

                    }
                    break;

            }


            match(input,94,FOLLOW_94_in_structure_type6387); 

            type = typeFactory.getStructType(typeList);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "structure_type"



    // $ANTLR start "packed_structure_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:902:1: packed_structure_type returns [Type type] : '<' '{' ( type_list )? '}' '>' ;
    public final Type packed_structure_type() throws RecognitionException {
        Type type = null;


        List<Type> type_list153 =null;



          List<Type> typeList = null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:906:5: ( '<' '{' ( type_list )? '}' '>' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:906:7: '<' '{' ( type_list )? '}' '>'
            {
            match(input,46,FOLLOW_46_in_packed_structure_type6418); 

            match(input,93,FOLLOW_93_in_packed_structure_type6420); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:906:15: ( type_list )?
            int alt208=2;
            int LA208_0 = input.LA(1);

            if ( (LA208_0==BOOLEAN_TYPE||LA208_0==FLOATING_POINT_TYPE||(LA208_0 >= INTEGER_TYPE && LA208_0 <= LABEL)||(LA208_0 >= LOCAL_VARIABLE && LA208_0 <= METADATA)||LA208_0==OPAQUE||LA208_0==VOID||LA208_0==46||LA208_0==49||LA208_0==89||LA208_0==93) ) {
                alt208=1;
            }
            switch (alt208) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:906:16: type_list
                    {
                    pushFollow(FOLLOW_type_list_in_packed_structure_type6423);
                    type_list153=type_list();

                    state._fsp--;


                    typeList = type_list153;

                    }
                    break;

            }


            match(input,94,FOLLOW_94_in_packed_structure_type6430); 

            match(input,48,FOLLOW_48_in_packed_structure_type6432); 

            type = typeFactory.getPackedStructType(typeList);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "packed_structure_type"



    // $ANTLR start "union_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:909:1: union_type returns [Type type] : 'union' '{' ( type_list )? '}' ;
    public final Type union_type() throws RecognitionException {
        Type type = null;


        List<Type> type_list154 =null;



          List<Type> typeList = null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:913:5: ( 'union' '{' ( type_list )? '}' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:913:7: 'union' '{' ( type_list )? '}'
            {
            match(input,89,FOLLOW_89_in_union_type6459); 

            match(input,93,FOLLOW_93_in_union_type6461); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:913:19: ( type_list )?
            int alt209=2;
            int LA209_0 = input.LA(1);

            if ( (LA209_0==BOOLEAN_TYPE||LA209_0==FLOATING_POINT_TYPE||(LA209_0 >= INTEGER_TYPE && LA209_0 <= LABEL)||(LA209_0 >= LOCAL_VARIABLE && LA209_0 <= METADATA)||LA209_0==OPAQUE||LA209_0==VOID||LA209_0==46||LA209_0==49||LA209_0==89||LA209_0==93) ) {
                alt209=1;
            }
            switch (alt209) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:913:20: type_list
                    {
                    pushFollow(FOLLOW_type_list_in_union_type6464);
                    type_list154=type_list();

                    state._fsp--;


                    typeList = type_list154;

                    }
                    break;

            }


            match(input,94,FOLLOW_94_in_union_type6471); 

            type = typeFactory.getUnionType(typeList);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "union_type"



    // $ANTLR start "type_list"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:916:1: type_list returns [List<Type> typeList] : dt= derived_type ( ',' dt2= derived_type )* ;
    public final List<Type> type_list() throws RecognitionException {
        List<Type> typeList = null;


        Type dt =null;

        Type dt2 =null;



          typeList = new ArrayList<Type>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:920:5: (dt= derived_type ( ',' dt2= derived_type )* )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:920:7: dt= derived_type ( ',' dt2= derived_type )*
            {
            pushFollow(FOLLOW_derived_type_in_type_list6502);
            dt=derived_type();

            state._fsp--;


            typeList.add(dt);

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:920:51: ( ',' dt2= derived_type )*
            loop210:
            do {
                int alt210=2;
                int LA210_0 = input.LA(1);

                if ( (LA210_0==44) ) {
                    alt210=1;
                }


                switch (alt210) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:920:52: ',' dt2= derived_type
            	    {
            	    match(input,44,FOLLOW_44_in_type_list6507); 

            	    pushFollow(FOLLOW_derived_type_in_type_list6513);
            	    dt2=derived_type();

            	    state._fsp--;


            	    typeList.add(dt2);

            	    }
            	    break;

            	default :
            	    break loop210;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return typeList;
    }
    // $ANTLR end "type_list"



    // $ANTLR start "array_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:922:1: array_type returns [Type type] : '[' INTEGER 'x' derived_type ']' ;
    public final Type array_type() throws RecognitionException {
        Type type = null;


        Token INTEGER155=null;
        Type derived_type156 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:923:5: ( '[' INTEGER 'x' derived_type ']' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:923:7: '[' INTEGER 'x' derived_type ']'
            {
            match(input,49,FOLLOW_49_in_array_type6533); 

            INTEGER155=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_array_type6535); 

            match(input,91,FOLLOW_91_in_array_type6537); 

            pushFollow(FOLLOW_derived_type_in_array_type6539);
            derived_type156=derived_type();

            state._fsp--;


            match(input,50,FOLLOW_50_in_array_type6541); 

            type = typeFactory.getArrayType(Integer.parseInt((INTEGER155!=null?INTEGER155.getText():null)), derived_type156);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "array_type"



    // $ANTLR start "vector_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:925:1: vector_type returns [Type type] : '<' INTEGER 'x' element_type '>' ;
    public final Type vector_type() throws RecognitionException {
        Type type = null;


        Token INTEGER157=null;
        Type element_type158 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:926:5: ( '<' INTEGER 'x' element_type '>' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:926:7: '<' INTEGER 'x' element_type '>'
            {
            match(input,46,FOLLOW_46_in_vector_type6559); 

            INTEGER157=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_vector_type6561); 

            match(input,91,FOLLOW_91_in_vector_type6563); 

            pushFollow(FOLLOW_element_type_in_vector_type6565);
            element_type158=element_type();

            state._fsp--;


            match(input,48,FOLLOW_48_in_vector_type6567); 

            type = typeFactory.getVectorType(Integer.parseInt((INTEGER157!=null?INTEGER157.getText():null)), element_type158);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "vector_type"



    // $ANTLR start "return_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:928:1: return_type returns [Type type] : ( element_type ( '*' )* ( parameter_type_list ( '*' )+ )* | structure_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )? | union_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )? | packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | array_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | vector_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | VOID ( parameter_type_list ( '*' )+ )* );
    public final Type return_type() throws RecognitionException {
        Type type = null;


        List<Type> ptl1 =null;

        List<Type> ptl2 =null;

        Type element_type159 =null;

        List<Type> parameter_type_list160 =null;

        Type structure_type161 =null;

        Type union_type162 =null;

        Type packed_structure_type163 =null;

        List<Type> parameter_type_list164 =null;

        Type array_type165 =null;

        List<Type> parameter_type_list166 =null;

        Type vector_type167 =null;

        List<Type> parameter_type_list168 =null;

        List<Type> parameter_type_list169 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:929:5: ( element_type ( '*' )* ( parameter_type_list ( '*' )+ )* | structure_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )? | union_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )? | packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | array_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | vector_type ( '*' )+ ( parameter_type_list ( '*' )+ )* | VOID ( parameter_type_list ( '*' )+ )* )
            int alt237=7;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt237=1;
                }
                break;
            case 93:
                {
                alt237=2;
                }
                break;
            case 89:
                {
                alt237=3;
                }
                break;
            case 46:
                {
                int LA237_4 = input.LA(2);

                if ( (LA237_4==93) ) {
                    alt237=4;
                }
                else if ( (LA237_4==INTEGER) ) {
                    alt237=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 237, 4, input);

                    throw nvae;

                }
                }
                break;
            case 49:
                {
                alt237=5;
                }
                break;
            case VOID:
                {
                alt237=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 237, 0, input);

                throw nvae;

            }

            switch (alt237) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:929:7: element_type ( '*' )* ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_element_type_in_return_type6585);
                    element_type159=element_type();

                    state._fsp--;


                    type = element_type159;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:930:7: ( '*' )*
                    loop211:
                    do {
                        int alt211=2;
                        int LA211_0 = input.LA(1);

                        if ( (LA211_0==43) ) {
                            alt211=1;
                        }


                        switch (alt211) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:930:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_return_type6596); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop211;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:931:7: ( parameter_type_list ( '*' )+ )*
                    loop213:
                    do {
                        int alt213=2;
                        int LA213_0 = input.LA(1);

                        if ( (LA213_0==41) ) {
                            alt213=1;
                        }


                        switch (alt213) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:931:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_return_type6611);
                    	    parameter_type_list160=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list160; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:932:7: ( '*' )+
                    	    int cnt212=0;
                    	    loop212:
                    	    do {
                    	        int alt212=2;
                    	        int LA212_0 = input.LA(1);

                    	        if ( (LA212_0==43) ) {
                    	            alt212=1;
                    	        }


                    	        switch (alt212) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:932:8: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_return_type6622); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt212 >= 1 ) break loop212;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(212, input);
                    	                throw eee;
                    	        }
                    	        cnt212++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop213;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:934:7: structure_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )?
                    {
                    pushFollow(FOLLOW_structure_type_in_return_type6645);
                    structure_type161=structure_type();

                    state._fsp--;


                    type = structure_type161;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:935:7: ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )?
                    int alt219=3;
                    int LA219_0 = input.LA(1);

                    if ( (LA219_0==43) ) {
                        alt219=1;
                    }
                    else if ( (LA219_0==41) ) {
                        alt219=2;
                    }
                    switch (alt219) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:936:9: ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:936:9: ( '*' )+
                            int cnt214=0;
                            loop214:
                            do {
                                int alt214=2;
                                int LA214_0 = input.LA(1);

                                if ( (LA214_0==43) ) {
                                    alt214=1;
                                }


                                switch (alt214) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:936:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_return_type6666); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt214 >= 1 ) break loop214;
                                        EarlyExitException eee =
                                            new EarlyExitException(214, input);
                                        throw eee;
                                }
                                cnt214++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:937:9: (ptl1= parameter_type_list ( '*' )+ )*
                            loop216:
                            do {
                                int alt216=2;
                                int LA216_0 = input.LA(1);

                                if ( (LA216_0==41) ) {
                                    alt216=1;
                                }


                                switch (alt216) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:937:10: ptl1= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_return_type6686);
                            	    ptl1=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:938:9: ( '*' )+
                            	    int cnt215=0;
                            	    loop215:
                            	    do {
                            	        int alt215=2;
                            	        int LA215_0 = input.LA(1);

                            	        if ( (LA215_0==43) ) {
                            	            alt215=1;
                            	        }


                            	        switch (alt215) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:938:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_return_type6699); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt215 >= 1 ) break loop215;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(215, input);
                            	                throw eee;
                            	        }
                            	        cnt215++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop216;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:941:9: (ptl2= parameter_type_list ( '*' )+ )+
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:941:9: (ptl2= parameter_type_list ( '*' )+ )+
                            int cnt218=0;
                            loop218:
                            do {
                                int alt218=2;
                                int LA218_0 = input.LA(1);

                                if ( (LA218_0==41) ) {
                                    alt218=1;
                                }


                                switch (alt218) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:941:10: ptl2= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_return_type6741);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:942:9: ( '*' )+
                            	    int cnt217=0;
                            	    loop217:
                            	    do {
                            	        int alt217=2;
                            	        int LA217_0 = input.LA(1);

                            	        if ( (LA217_0==43) ) {
                            	            alt217=1;
                            	        }


                            	        switch (alt217) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:942:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_return_type6754); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt217 >= 1 ) break loop217;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(217, input);
                            	                throw eee;
                            	        }
                            	        cnt217++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt218 >= 1 ) break loop218;
                                        EarlyExitException eee =
                                            new EarlyExitException(218, input);
                                        throw eee;
                                }
                                cnt218++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:945:7: union_type ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )?
                    {
                    pushFollow(FOLLOW_union_type_in_return_type6787);
                    union_type162=union_type();

                    state._fsp--;


                    type = union_type162;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:946:7: ( ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )* | (ptl2= parameter_type_list ( '*' )+ )+ )?
                    int alt225=3;
                    int LA225_0 = input.LA(1);

                    if ( (LA225_0==43) ) {
                        alt225=1;
                    }
                    else if ( (LA225_0==41) ) {
                        alt225=2;
                    }
                    switch (alt225) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:947:9: ( '*' )+ (ptl1= parameter_type_list ( '*' )+ )*
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:947:9: ( '*' )+
                            int cnt220=0;
                            loop220:
                            do {
                                int alt220=2;
                                int LA220_0 = input.LA(1);

                                if ( (LA220_0==43) ) {
                                    alt220=1;
                                }


                                switch (alt220) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:947:10: '*'
                            	    {
                            	    match(input,43,FOLLOW_43_in_return_type6808); 

                            	    type = typeFactory.getPointerType(type);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt220 >= 1 ) break loop220;
                                        EarlyExitException eee =
                                            new EarlyExitException(220, input);
                                        throw eee;
                                }
                                cnt220++;
                            } while (true);


                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:948:9: (ptl1= parameter_type_list ( '*' )+ )*
                            loop222:
                            do {
                                int alt222=2;
                                int LA222_0 = input.LA(1);

                                if ( (LA222_0==41) ) {
                                    alt222=1;
                                }


                                switch (alt222) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:948:10: ptl1= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_return_type6828);
                            	    ptl1=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:949:9: ( '*' )+
                            	    int cnt221=0;
                            	    loop221:
                            	    do {
                            	        int alt221=2;
                            	        int LA221_0 = input.LA(1);

                            	        if ( (LA221_0==43) ) {
                            	            alt221=1;
                            	        }


                            	        switch (alt221) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:949:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_return_type6841); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt221 >= 1 ) break loop221;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(221, input);
                            	                throw eee;
                            	        }
                            	        cnt221++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop222;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:952:9: (ptl2= parameter_type_list ( '*' )+ )+
                            {
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:952:9: (ptl2= parameter_type_list ( '*' )+ )+
                            int cnt224=0;
                            loop224:
                            do {
                                int alt224=2;
                                int LA224_0 = input.LA(1);

                                if ( (LA224_0==41) ) {
                                    alt224=1;
                                }


                                switch (alt224) {
                            	case 1 :
                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:952:10: ptl2= parameter_type_list ( '*' )+
                            	    {
                            	    pushFollow(FOLLOW_parameter_type_list_in_return_type6883);
                            	    ptl2=parameter_type_list();

                            	    state._fsp--;


                            	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:953:9: ( '*' )+
                            	    int cnt223=0;
                            	    loop223:
                            	    do {
                            	        int alt223=2;
                            	        int LA223_0 = input.LA(1);

                            	        if ( (LA223_0==43) ) {
                            	            alt223=1;
                            	        }


                            	        switch (alt223) {
                            	    	case 1 :
                            	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:953:10: '*'
                            	    	    {
                            	    	    match(input,43,FOLLOW_43_in_return_type6896); 

                            	    	    type = typeFactory.getPointerType(type);

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt223 >= 1 ) break loop223;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(223, input);
                            	                throw eee;
                            	        }
                            	        cnt223++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt224 >= 1 ) break loop224;
                                        EarlyExitException eee =
                                            new EarlyExitException(224, input);
                                        throw eee;
                                }
                                cnt224++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:956:7: packed_structure_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_packed_structure_type_in_return_type6929);
                    packed_structure_type163=packed_structure_type();

                    state._fsp--;


                    type = packed_structure_type163;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:957:7: ( '*' )+
                    int cnt226=0;
                    loop226:
                    do {
                        int alt226=2;
                        int LA226_0 = input.LA(1);

                        if ( (LA226_0==43) ) {
                            alt226=1;
                        }


                        switch (alt226) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:957:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_return_type6940); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt226 >= 1 ) break loop226;
                                EarlyExitException eee =
                                    new EarlyExitException(226, input);
                                throw eee;
                        }
                        cnt226++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:958:7: ( parameter_type_list ( '*' )+ )*
                    loop228:
                    do {
                        int alt228=2;
                        int LA228_0 = input.LA(1);

                        if ( (LA228_0==41) ) {
                            alt228=1;
                        }


                        switch (alt228) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:958:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_return_type6955);
                    	    parameter_type_list164=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list164; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:959:7: ( '*' )+
                    	    int cnt227=0;
                    	    loop227:
                    	    do {
                    	        int alt227=2;
                    	        int LA227_0 = input.LA(1);

                    	        if ( (LA227_0==43) ) {
                    	            alt227=1;
                    	        }


                    	        switch (alt227) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:959:8: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_return_type6966); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt227 >= 1 ) break loop227;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(227, input);
                    	                throw eee;
                    	        }
                    	        cnt227++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop228;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:961:7: array_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_array_type_in_return_type6989);
                    array_type165=array_type();

                    state._fsp--;


                    type = array_type165;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:962:7: ( '*' )+
                    int cnt229=0;
                    loop229:
                    do {
                        int alt229=2;
                        int LA229_0 = input.LA(1);

                        if ( (LA229_0==43) ) {
                            alt229=1;
                        }


                        switch (alt229) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:962:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_return_type7000); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt229 >= 1 ) break loop229;
                                EarlyExitException eee =
                                    new EarlyExitException(229, input);
                                throw eee;
                        }
                        cnt229++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:963:7: ( parameter_type_list ( '*' )+ )*
                    loop231:
                    do {
                        int alt231=2;
                        int LA231_0 = input.LA(1);

                        if ( (LA231_0==41) ) {
                            alt231=1;
                        }


                        switch (alt231) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:963:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_return_type7015);
                    	    parameter_type_list166=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list166; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:964:7: ( '*' )+
                    	    int cnt230=0;
                    	    loop230:
                    	    do {
                    	        int alt230=2;
                    	        int LA230_0 = input.LA(1);

                    	        if ( (LA230_0==43) ) {
                    	            alt230=1;
                    	        }


                    	        switch (alt230) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:964:8: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_return_type7026); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt230 >= 1 ) break loop230;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(230, input);
                    	                throw eee;
                    	        }
                    	        cnt230++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop231;
                        }
                    } while (true);


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:966:7: vector_type ( '*' )+ ( parameter_type_list ( '*' )+ )*
                    {
                    pushFollow(FOLLOW_vector_type_in_return_type7049);
                    vector_type167=vector_type();

                    state._fsp--;


                    type = vector_type167;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:967:7: ( '*' )+
                    int cnt232=0;
                    loop232:
                    do {
                        int alt232=2;
                        int LA232_0 = input.LA(1);

                        if ( (LA232_0==43) ) {
                            alt232=1;
                        }


                        switch (alt232) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:967:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_return_type7060); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt232 >= 1 ) break loop232;
                                EarlyExitException eee =
                                    new EarlyExitException(232, input);
                                throw eee;
                        }
                        cnt232++;
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:968:7: ( parameter_type_list ( '*' )+ )*
                    loop234:
                    do {
                        int alt234=2;
                        int LA234_0 = input.LA(1);

                        if ( (LA234_0==41) ) {
                            alt234=1;
                        }


                        switch (alt234) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:968:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_return_type7075);
                    	    parameter_type_list168=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list168; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:969:7: ( '*' )+
                    	    int cnt233=0;
                    	    loop233:
                    	    do {
                    	        int alt233=2;
                    	        int LA233_0 = input.LA(1);

                    	        if ( (LA233_0==43) ) {
                    	            alt233=1;
                    	        }


                    	        switch (alt233) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:969:8: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_return_type7086); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt233 >= 1 ) break loop233;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(233, input);
                    	                throw eee;
                    	        }
                    	        cnt233++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop234;
                        }
                    } while (true);


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:971:7: VOID ( parameter_type_list ( '*' )+ )*
                    {
                    match(input,VOID,FOLLOW_VOID_in_return_type7109); 

                    type = typeFactory.getVoidType();

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:972:7: ( parameter_type_list ( '*' )+ )*
                    loop236:
                    do {
                        int alt236=2;
                        int LA236_0 = input.LA(1);

                        if ( (LA236_0==41) ) {
                            alt236=1;
                        }


                        switch (alt236) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:972:8: parameter_type_list ( '*' )+
                    	    {
                    	    pushFollow(FOLLOW_parameter_type_list_in_return_type7120);
                    	    parameter_type_list169=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList = parameter_type_list169; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:973:7: ( '*' )+
                    	    int cnt235=0;
                    	    loop235:
                    	    do {
                    	        int alt235=2;
                    	        int LA235_0 = input.LA(1);

                    	        if ( (LA235_0==43) ) {
                    	            alt235=1;
                    	        }


                    	        switch (alt235) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:973:8: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_return_type7131); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt235 >= 1 ) break loop235;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(235, input);
                    	                throw eee;
                    	        }
                    	        cnt235++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop236;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "return_type"



    // $ANTLR start "function_type"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:977:1: function_type returns [Type type] : ( element_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | structure_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | union_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | packed_structure_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | array_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | vector_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* );
    public final Type function_type() throws RecognitionException {
        Type type = null;


        List<Type> ptl1 =null;

        List<Type> ptl2 =null;

        Type element_type170 =null;

        Type structure_type171 =null;

        Type union_type172 =null;

        Type packed_structure_type173 =null;

        Type array_type174 =null;

        Type vector_type175 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:978:5: ( element_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | structure_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | union_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | packed_structure_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | array_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | vector_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* | VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )
            int alt258=7;
            switch ( input.LA(1) ) {
            case BOOLEAN_TYPE:
            case FLOATING_POINT_TYPE:
            case INTEGER_TYPE:
            case LOCAL_VARIABLE:
                {
                alt258=1;
                }
                break;
            case 93:
                {
                alt258=2;
                }
                break;
            case 89:
                {
                alt258=3;
                }
                break;
            case 46:
                {
                int LA258_4 = input.LA(2);

                if ( (LA258_4==93) ) {
                    alt258=4;
                }
                else if ( (LA258_4==INTEGER) ) {
                    alt258=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 258, 4, input);

                    throw nvae;

                }
                }
                break;
            case 49:
                {
                alt258=5;
                }
                break;
            case VOID:
                {
                alt258=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 258, 0, input);

                throw nvae;

            }

            switch (alt258) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:978:7: element_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    pushFollow(FOLLOW_element_type_in_function_type7168);
                    element_type170=element_type();

                    state._fsp--;


                    type = element_type170;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:979:7: ( '*' )*
                    loop238:
                    do {
                        int alt238=2;
                        int LA238_0 = input.LA(1);

                        if ( (LA238_0==43) ) {
                            alt238=1;
                        }


                        switch (alt238) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:979:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_function_type7180); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop238;
                        }
                    } while (true);


                    pushFollow(FOLLOW_parameter_type_list_in_function_type7198);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:981:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop240:
                    do {
                        int alt240=2;
                        int LA240_0 = input.LA(1);

                        if ( (LA240_0==43) ) {
                            alt240=1;
                        }


                        switch (alt240) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:981:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:981:8: ( '*' )+
                    	    int cnt239=0;
                    	    loop239:
                    	    do {
                    	        int alt239=2;
                    	        int LA239_0 = input.LA(1);

                    	        if ( (LA239_0==43) ) {
                    	            alt239=1;
                    	        }


                    	        switch (alt239) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:981:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7210); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt239 >= 1 ) break loop239;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(239, input);
                    	                throw eee;
                    	        }
                    	        cnt239++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7228);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop240;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:984:7: structure_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    pushFollow(FOLLOW_structure_type_in_function_type7247);
                    structure_type171=structure_type();

                    state._fsp--;


                    type = structure_type171;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:985:7: ( '*' )*
                    loop241:
                    do {
                        int alt241=2;
                        int LA241_0 = input.LA(1);

                        if ( (LA241_0==43) ) {
                            alt241=1;
                        }


                        switch (alt241) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:985:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_function_type7259); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop241;
                        }
                    } while (true);


                    pushFollow(FOLLOW_parameter_type_list_in_function_type7277);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:987:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop243:
                    do {
                        int alt243=2;
                        int LA243_0 = input.LA(1);

                        if ( (LA243_0==43) ) {
                            alt243=1;
                        }


                        switch (alt243) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:987:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:987:8: ( '*' )+
                    	    int cnt242=0;
                    	    loop242:
                    	    do {
                    	        int alt242=2;
                    	        int LA242_0 = input.LA(1);

                    	        if ( (LA242_0==43) ) {
                    	            alt242=1;
                    	        }


                    	        switch (alt242) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:987:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7289); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt242 >= 1 ) break loop242;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(242, input);
                    	                throw eee;
                    	        }
                    	        cnt242++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7307);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop243;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:990:7: union_type ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    pushFollow(FOLLOW_union_type_in_function_type7326);
                    union_type172=union_type();

                    state._fsp--;


                    type = union_type172;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:991:7: ( '*' )*
                    loop244:
                    do {
                        int alt244=2;
                        int LA244_0 = input.LA(1);

                        if ( (LA244_0==43) ) {
                            alt244=1;
                        }


                        switch (alt244) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:991:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_function_type7337); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    break loop244;
                        }
                    } while (true);


                    pushFollow(FOLLOW_parameter_type_list_in_function_type7355);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:993:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop246:
                    do {
                        int alt246=2;
                        int LA246_0 = input.LA(1);

                        if ( (LA246_0==43) ) {
                            alt246=1;
                        }


                        switch (alt246) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:993:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:993:8: ( '*' )+
                    	    int cnt245=0;
                    	    loop245:
                    	    do {
                    	        int alt245=2;
                    	        int LA245_0 = input.LA(1);

                    	        if ( (LA245_0==43) ) {
                    	            alt245=1;
                    	        }


                    	        switch (alt245) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:993:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7367); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt245 >= 1 ) break loop245;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(245, input);
                    	                throw eee;
                    	        }
                    	        cnt245++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7385);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop246;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:996:7: packed_structure_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    pushFollow(FOLLOW_packed_structure_type_in_function_type7404);
                    packed_structure_type173=packed_structure_type();

                    state._fsp--;


                    type = packed_structure_type173;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:997:7: ( '*' )+
                    int cnt247=0;
                    loop247:
                    do {
                        int alt247=2;
                        int LA247_0 = input.LA(1);

                        if ( (LA247_0==43) ) {
                            alt247=1;
                        }


                        switch (alt247) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:997:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_function_type7415); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt247 >= 1 ) break loop247;
                                EarlyExitException eee =
                                    new EarlyExitException(247, input);
                                throw eee;
                        }
                        cnt247++;
                    } while (true);


                    pushFollow(FOLLOW_parameter_type_list_in_function_type7433);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:999:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop249:
                    do {
                        int alt249=2;
                        int LA249_0 = input.LA(1);

                        if ( (LA249_0==43) ) {
                            alt249=1;
                        }


                        switch (alt249) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:999:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:999:8: ( '*' )+
                    	    int cnt248=0;
                    	    loop248:
                    	    do {
                    	        int alt248=2;
                    	        int LA248_0 = input.LA(1);

                    	        if ( (LA248_0==43) ) {
                    	            alt248=1;
                    	        }


                    	        switch (alt248) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:999:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7445); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt248 >= 1 ) break loop248;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(248, input);
                    	                throw eee;
                    	        }
                    	        cnt248++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7463);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop249;
                        }
                    } while (true);


                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1002:7: array_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    pushFollow(FOLLOW_array_type_in_function_type7482);
                    array_type174=array_type();

                    state._fsp--;


                    type = array_type174;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1003:7: ( '*' )+
                    int cnt250=0;
                    loop250:
                    do {
                        int alt250=2;
                        int LA250_0 = input.LA(1);

                        if ( (LA250_0==43) ) {
                            alt250=1;
                        }


                        switch (alt250) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1003:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_function_type7494); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt250 >= 1 ) break loop250;
                                EarlyExitException eee =
                                    new EarlyExitException(250, input);
                                throw eee;
                        }
                        cnt250++;
                    } while (true);


                    pushFollow(FOLLOW_parameter_type_list_in_function_type7512);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1005:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop252:
                    do {
                        int alt252=2;
                        int LA252_0 = input.LA(1);

                        if ( (LA252_0==43) ) {
                            alt252=1;
                        }


                        switch (alt252) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1005:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1005:8: ( '*' )+
                    	    int cnt251=0;
                    	    loop251:
                    	    do {
                    	        int alt251=2;
                    	        int LA251_0 = input.LA(1);

                    	        if ( (LA251_0==43) ) {
                    	            alt251=1;
                    	        }


                    	        switch (alt251) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1005:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7524); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt251 >= 1 ) break loop251;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(251, input);
                    	                throw eee;
                    	        }
                    	        cnt251++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7542);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop252;
                        }
                    } while (true);


                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1008:7: vector_type ( '*' )+ ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    pushFollow(FOLLOW_vector_type_in_function_type7561);
                    vector_type175=vector_type();

                    state._fsp--;


                    type = vector_type175;

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1009:7: ( '*' )+
                    int cnt253=0;
                    loop253:
                    do {
                        int alt253=2;
                        int LA253_0 = input.LA(1);

                        if ( (LA253_0==43) ) {
                            alt253=1;
                        }


                        switch (alt253) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1009:8: '*'
                    	    {
                    	    match(input,43,FOLLOW_43_in_function_type7572); 

                    	    type = typeFactory.getPointerType(type);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt253 >= 1 ) break loop253;
                                EarlyExitException eee =
                                    new EarlyExitException(253, input);
                                throw eee;
                        }
                        cnt253++;
                    } while (true);


                    pushFollow(FOLLOW_parameter_type_list_in_function_type7590);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1011:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop255:
                    do {
                        int alt255=2;
                        int LA255_0 = input.LA(1);

                        if ( (LA255_0==43) ) {
                            alt255=1;
                        }


                        switch (alt255) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1011:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1011:8: ( '*' )+
                    	    int cnt254=0;
                    	    loop254:
                    	    do {
                    	        int alt254=2;
                    	        int LA254_0 = input.LA(1);

                    	        if ( (LA254_0==43) ) {
                    	            alt254=1;
                    	        }


                    	        switch (alt254) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1011:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7602); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt254 >= 1 ) break loop254;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(254, input);
                    	                throw eee;
                    	        }
                    	        cnt254++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7620);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop255;
                        }
                    } while (true);


                    }
                    break;
                case 7 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1014:7: VOID ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )*
                    {
                    match(input,VOID,FOLLOW_VOID_in_function_type7639); 

                    type = typeFactory.getVoidType();

                    pushFollow(FOLLOW_parameter_type_list_in_function_type7653);
                    ptl1=parameter_type_list();

                    state._fsp--;


                    List<Type> typeList = ptl1; typeList.add(0, type); type = typeFactory.getFunctionType(typeList);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1016:7: ( ( '*' )+ ptl2= parameter_type_list )*
                    loop257:
                    do {
                        int alt257=2;
                        int LA257_0 = input.LA(1);

                        if ( (LA257_0==43) ) {
                            alt257=1;
                        }


                        switch (alt257) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1016:8: ( '*' )+ ptl2= parameter_type_list
                    	    {
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1016:8: ( '*' )+
                    	    int cnt256=0;
                    	    loop256:
                    	    do {
                    	        int alt256=2;
                    	        int LA256_0 = input.LA(1);

                    	        if ( (LA256_0==43) ) {
                    	            alt256=1;
                    	        }


                    	        switch (alt256) {
                    	    	case 1 :
                    	    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1016:9: '*'
                    	    	    {
                    	    	    match(input,43,FOLLOW_43_in_function_type7665); 

                    	    	    type = typeFactory.getPointerType(type);

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt256 >= 1 ) break loop256;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(256, input);
                    	                throw eee;
                    	        }
                    	        cnt256++;
                    	    } while (true);


                    	    pushFollow(FOLLOW_parameter_type_list_in_function_type7683);
                    	    ptl2=parameter_type_list();

                    	    state._fsp--;


                    	    List<Type> typeList2 = ptl2; typeList2.add(0, type); type = typeFactory.getFunctionType(typeList2);

                    	    }
                    	    break;

                    	default :
                    	    break loop257;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return type;
    }
    // $ANTLR end "function_type"



    // $ANTLR start "parameter_type_list"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1021:1: parameter_type_list returns [List<Type> typeList] : '(' ( '...' |fct1= first_class_type ( ',' fct2= first_class_type )* ( ',' '...' )? )? ')' ;
    public final List<Type> parameter_type_list() throws RecognitionException {
        List<Type> typeList = null;


        Type fct1 =null;

        Type fct2 =null;



          typeList = new ArrayList<Type>();

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1025:5: ( '(' ( '...' |fct1= first_class_type ( ',' fct2= first_class_type )* ( ',' '...' )? )? ')' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1025:7: '(' ( '...' |fct1= first_class_type ( ',' fct2= first_class_type )* ( ',' '...' )? )? ')'
            {
            match(input,41,FOLLOW_41_in_parameter_type_list7719); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1025:11: ( '...' |fct1= first_class_type ( ',' fct2= first_class_type )* ( ',' '...' )? )?
            int alt261=3;
            int LA261_0 = input.LA(1);

            if ( (LA261_0==45) ) {
                alt261=1;
            }
            else if ( (LA261_0==BOOLEAN_TYPE||LA261_0==FLOATING_POINT_TYPE||(LA261_0 >= INTEGER_TYPE && LA261_0 <= LABEL)||(LA261_0 >= LOCAL_VARIABLE && LA261_0 <= METADATA)||LA261_0==VOID||LA261_0==46||LA261_0==49||LA261_0==89||LA261_0==93) ) {
                alt261=2;
            }
            switch (alt261) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1025:13: '...'
                    {
                    match(input,45,FOLLOW_45_in_parameter_type_list7723); 

                    typeList.add(typeFactory.getWrongType());

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1026:7: fct1= first_class_type ( ',' fct2= first_class_type )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_first_class_type_in_parameter_type_list7737);
                    fct1=first_class_type();

                    state._fsp--;


                    typeList.add(fct1);

                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1027:7: ( ',' fct2= first_class_type )*
                    loop259:
                    do {
                        int alt259=2;
                        int LA259_0 = input.LA(1);

                        if ( (LA259_0==44) ) {
                            int LA259_1 = input.LA(2);

                            if ( (LA259_1==BOOLEAN_TYPE||LA259_1==FLOATING_POINT_TYPE||(LA259_1 >= INTEGER_TYPE && LA259_1 <= LABEL)||(LA259_1 >= LOCAL_VARIABLE && LA259_1 <= METADATA)||LA259_1==VOID||LA259_1==46||LA259_1==49||LA259_1==89||LA259_1==93) ) {
                                alt259=1;
                            }


                        }


                        switch (alt259) {
                    	case 1 :
                    	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1027:8: ',' fct2= first_class_type
                    	    {
                    	    match(input,44,FOLLOW_44_in_parameter_type_list7748); 

                    	    pushFollow(FOLLOW_first_class_type_in_parameter_type_list7754);
                    	    fct2=first_class_type();

                    	    state._fsp--;


                    	    typeList.add(fct2);

                    	    }
                    	    break;

                    	default :
                    	    break loop259;
                        }
                    } while (true);


                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1027:67: ( ',' '...' )?
                    int alt260=2;
                    int LA260_0 = input.LA(1);

                    if ( (LA260_0==44) ) {
                        alt260=1;
                    }
                    switch (alt260) {
                        case 1 :
                            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1027:68: ',' '...'
                            {
                            match(input,44,FOLLOW_44_in_parameter_type_list7762); 

                            match(input,45,FOLLOW_45_in_parameter_type_list7764); 

                            typeList.add(typeFactory.getWrongType());

                            }
                            break;

                    }


                    }
                    break;

            }


            match(input,42,FOLLOW_42_in_parameter_type_list7772); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return typeList;
    }
    // $ANTLR end "parameter_type_list"



    // $ANTLR start "initializer"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1033:1: initializer returns [Constant constant] : ( 'zeroinitializer' | 'c' STRING | constant | GLOBAL_VARIABLE );
    public final Constant initializer() throws RecognitionException {
        Constant constant = null;


        Token STRING176=null;
        Token GLOBAL_VARIABLE178=null;
        Constant constant177 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1034:5: ( 'zeroinitializer' | 'c' STRING | constant | GLOBAL_VARIABLE )
            int alt262=4;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt262=1;
                }
                break;
            case 56:
                {
                alt262=2;
                }
                break;
            case BINARY_OP:
            case BOOLEAN:
            case CONVERSION_OP:
            case FLOATING_POINT:
            case HEX:
            case INTEGER:
            case NULL:
            case 46:
            case 49:
            case 65:
            case 66:
            case 68:
            case 93:
                {
                alt262=3;
                }
                break;
            case GLOBAL_VARIABLE:
                {
                alt262=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 262, 0, input);

                throw nvae;

            }

            switch (alt262) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1034:7: 'zeroinitializer'
                    {
                    match(input,92,FOLLOW_92_in_initializer7793); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.nullConst, "null");

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1035:7: 'c' STRING
                    {
                    match(input,56,FOLLOW_56_in_initializer7803); 

                    STRING176=(Token)match(input,STRING,FOLLOW_STRING_in_initializer7805); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.nullConst, (STRING176!=null?STRING176.getText():null));

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1036:7: constant
                    {
                    pushFollow(FOLLOW_constant_in_initializer7815);
                    constant177=constant();

                    state._fsp--;


                    constant = constant177;

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1037:7: GLOBAL_VARIABLE
                    {
                    GLOBAL_VARIABLE178=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_initializer7825); 

                    constant = valueFactory.createVariable((GLOBAL_VARIABLE178!=null?GLOBAL_VARIABLE178.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return constant;
    }
    // $ANTLR end "initializer"



    // $ANTLR start "index"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1039:1: index returns [Constant expr] : ( INTEGER | variable );
    public final Constant index() throws RecognitionException {
        Constant expr = null;


        Token INTEGER179=null;
        Constant variable180 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1040:5: ( INTEGER | variable )
            int alt263=2;
            int LA263_0 = input.LA(1);

            if ( (LA263_0==INTEGER) ) {
                alt263=1;
            }
            else if ( (LA263_0==GLOBAL_VARIABLE||LA263_0==LOCAL_VARIABLE||LA263_0==UNDEF) ) {
                alt263=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 263, 0, input);

                throw nvae;

            }
            switch (alt263) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1040:7: INTEGER
                    {
                    INTEGER179=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_index7844); 

                    expr = valueFactory.createConstantValue(SimpleConstantValue.intConst, (INTEGER179!=null?INTEGER179.getText():null));

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1041:7: variable
                    {
                    pushFollow(FOLLOW_variable_in_index7854);
                    variable180=variable();

                    state._fsp--;


                    expr = variable180;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "index"



    // $ANTLR start "constant"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1043:1: constant returns [Constant constant] : ( getelementptr_expr | conversion_expr | binary_expr | cmp_expr | complex_constant | simple_constant );
    public final Constant constant() throws RecognitionException {
        Constant constant = null;


        Constant getelementptr_expr181 =null;

        Constant conversion_expr182 =null;

        Constant binary_expr183 =null;

        Constant cmp_expr184 =null;

        Constant complex_constant185 =null;

        Constant simple_constant186 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1044:5: ( getelementptr_expr | conversion_expr | binary_expr | cmp_expr | complex_constant | simple_constant )
            int alt264=6;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt264=1;
                }
                break;
            case CONVERSION_OP:
                {
                alt264=2;
                }
                break;
            case BINARY_OP:
                {
                alt264=3;
                }
                break;
            case 65:
            case 68:
                {
                alt264=4;
                }
                break;
            case 46:
            case 49:
            case 93:
                {
                alt264=5;
                }
                break;
            case BOOLEAN:
            case FLOATING_POINT:
            case HEX:
            case INTEGER:
            case NULL:
                {
                alt264=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 264, 0, input);

                throw nvae;

            }

            switch (alt264) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1044:7: getelementptr_expr
                    {
                    pushFollow(FOLLOW_getelementptr_expr_in_constant7872);
                    getelementptr_expr181=getelementptr_expr();

                    state._fsp--;


                    constant = getelementptr_expr181;

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1045:7: conversion_expr
                    {
                    pushFollow(FOLLOW_conversion_expr_in_constant7883);
                    conversion_expr182=conversion_expr();

                    state._fsp--;


                    constant = conversion_expr182;

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1046:7: binary_expr
                    {
                    pushFollow(FOLLOW_binary_expr_in_constant7893);
                    binary_expr183=binary_expr();

                    state._fsp--;


                    constant = binary_expr183;

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1047:7: cmp_expr
                    {
                    pushFollow(FOLLOW_cmp_expr_in_constant7903);
                    cmp_expr184=cmp_expr();

                    state._fsp--;


                    constant = cmp_expr184;

                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1048:7: complex_constant
                    {
                    pushFollow(FOLLOW_complex_constant_in_constant7913);
                    complex_constant185=complex_constant();

                    state._fsp--;


                    constant = complex_constant185;

                    }
                    break;
                case 6 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1049:7: simple_constant
                    {
                    pushFollow(FOLLOW_simple_constant_in_constant7923);
                    simple_constant186=simple_constant();

                    state._fsp--;


                    constant = simple_constant186;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return constant;
    }
    // $ANTLR end "constant"



    // $ANTLR start "simple_constant"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1051:1: simple_constant returns [Constant constant] : ( INTEGER | HEX | BOOLEAN | FLOATING_POINT | NULL );
    public final Constant simple_constant() throws RecognitionException {
        Constant constant = null;


        Token INTEGER187=null;
        Token HEX188=null;
        Token BOOLEAN189=null;
        Token FLOATING_POINT190=null;
        Token NULL191=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1052:5: ( INTEGER | HEX | BOOLEAN | FLOATING_POINT | NULL )
            int alt265=5;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt265=1;
                }
                break;
            case HEX:
                {
                alt265=2;
                }
                break;
            case BOOLEAN:
                {
                alt265=3;
                }
                break;
            case FLOATING_POINT:
                {
                alt265=4;
                }
                break;
            case NULL:
                {
                alt265=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 265, 0, input);

                throw nvae;

            }

            switch (alt265) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1052:7: INTEGER
                    {
                    INTEGER187=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_simple_constant7941); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.intConst, (INTEGER187!=null?INTEGER187.getText():null));

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1053:7: HEX
                    {
                    HEX188=(Token)match(input,HEX,FOLLOW_HEX_in_simple_constant7951); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.hexConst, (HEX188!=null?HEX188.getText():null));

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1054:7: BOOLEAN
                    {
                    BOOLEAN189=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_constant7961); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.boolConst, (BOOLEAN189!=null?BOOLEAN189.getText():null));

                    }
                    break;
                case 4 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1055:7: FLOATING_POINT
                    {
                    FLOATING_POINT190=(Token)match(input,FLOATING_POINT,FOLLOW_FLOATING_POINT_in_simple_constant7971); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.floatConst, (FLOATING_POINT190!=null?FLOATING_POINT190.getText():null));

                    }
                    break;
                case 5 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1056:7: NULL
                    {
                    NULL191=(Token)match(input,NULL,FOLLOW_NULL_in_simple_constant7981); 

                    constant = valueFactory.createConstantValue(SimpleConstantValue.nullConst, (NULL191!=null?NULL191.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return constant;
    }
    // $ANTLR end "simple_constant"



    // $ANTLR start "complex_constant"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1058:1: complex_constant returns [Constant constant] : ( structure_constant | array_constant | vector_constant );
    public final Constant complex_constant() throws RecognitionException {
        Constant constant = null;


        LLVMParser.structure_constant_return structure_constant192 =null;

        LLVMParser.array_constant_return array_constant193 =null;

        LLVMParser.vector_constant_return vector_constant194 =null;


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1059:5: ( structure_constant | array_constant | vector_constant )
            int alt266=3;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt266=1;
                }
                break;
            case 49:
                {
                alt266=2;
                }
                break;
            case 46:
                {
                alt266=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 266, 0, input);

                throw nvae;

            }

            switch (alt266) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1059:7: structure_constant
                    {
                    pushFollow(FOLLOW_structure_constant_in_complex_constant7999);
                    structure_constant192=structure_constant();

                    state._fsp--;


                    constant = valueFactory.createConstantValue(ComplexConstantValue.structure, (structure_constant192!=null?input.toString(structure_constant192.start,structure_constant192.stop):null));

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1060:7: array_constant
                    {
                    pushFollow(FOLLOW_array_constant_in_complex_constant8009);
                    array_constant193=array_constant();

                    state._fsp--;


                    constant = valueFactory.createConstantValue(ComplexConstantValue.array, (array_constant193!=null?input.toString(array_constant193.start,array_constant193.stop):null));

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1061:7: vector_constant
                    {
                    pushFollow(FOLLOW_vector_constant_in_complex_constant8019);
                    vector_constant194=vector_constant();

                    state._fsp--;


                    constant = valueFactory.createConstantValue(ComplexConstantValue.vector, (vector_constant194!=null?input.toString(vector_constant194.start,vector_constant194.stop):null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return constant;
    }
    // $ANTLR end "complex_constant"



    // $ANTLR start "constant_list"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1063:1: constant_list : derived_type initializer ( ',' derived_type initializer )* ;
    public final void constant_list() throws RecognitionException {
        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1063:15: ( derived_type initializer ( ',' derived_type initializer )* )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1063:17: derived_type initializer ( ',' derived_type initializer )*
            {
            pushFollow(FOLLOW_derived_type_in_constant_list8028);
            derived_type();

            state._fsp--;


            pushFollow(FOLLOW_initializer_in_constant_list8030);
            initializer();

            state._fsp--;


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1063:42: ( ',' derived_type initializer )*
            loop267:
            do {
                int alt267=2;
                int LA267_0 = input.LA(1);

                if ( (LA267_0==44) ) {
                    alt267=1;
                }


                switch (alt267) {
            	case 1 :
            	    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1063:43: ',' derived_type initializer
            	    {
            	    match(input,44,FOLLOW_44_in_constant_list8033); 

            	    pushFollow(FOLLOW_derived_type_in_constant_list8035);
            	    derived_type();

            	    state._fsp--;


            	    pushFollow(FOLLOW_initializer_in_constant_list8037);
            	    initializer();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop267;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "constant_list"


    public static class structure_constant_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "structure_constant"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1065:1: structure_constant : '{' constant_list '}' ;
    public final LLVMParser.structure_constant_return structure_constant() throws RecognitionException {
        LLVMParser.structure_constant_return retval = new LLVMParser.structure_constant_return();
        retval.start = input.LT(1);


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1065:20: ( '{' constant_list '}' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1065:22: '{' constant_list '}'
            {
            match(input,93,FOLLOW_93_in_structure_constant8047); 

            pushFollow(FOLLOW_constant_list_in_structure_constant8049);
            constant_list();

            state._fsp--;


            match(input,94,FOLLOW_94_in_structure_constant8051); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "structure_constant"


    public static class array_constant_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "array_constant"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1067:1: array_constant : '[' constant_list ']' ;
    public final LLVMParser.array_constant_return array_constant() throws RecognitionException {
        LLVMParser.array_constant_return retval = new LLVMParser.array_constant_return();
        retval.start = input.LT(1);


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1067:16: ( '[' constant_list ']' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1067:18: '[' constant_list ']'
            {
            match(input,49,FOLLOW_49_in_array_constant8059); 

            pushFollow(FOLLOW_constant_list_in_array_constant8061);
            constant_list();

            state._fsp--;


            match(input,50,FOLLOW_50_in_array_constant8063); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_constant"


    public static class vector_constant_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "vector_constant"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1069:1: vector_constant : '<' constant_list '>' ;
    public final LLVMParser.vector_constant_return vector_constant() throws RecognitionException {
        LLVMParser.vector_constant_return retval = new LLVMParser.vector_constant_return();
        retval.start = input.LT(1);


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1069:17: ( '<' constant_list '>' )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1069:19: '<' constant_list '>'
            {
            match(input,46,FOLLOW_46_in_vector_constant8071); 

            pushFollow(FOLLOW_constant_list_in_vector_constant8073);
            constant_list();

            state._fsp--;


            match(input,48,FOLLOW_48_in_vector_constant8075); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "vector_constant"



    // $ANTLR start "function_name"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1071:1: function_name returns [Constant expr] : ( GLOBAL_VARIABLE | LOCAL_VARIABLE | assembly_expr );
    public final Constant function_name() throws RecognitionException {
        Constant expr = null;


        Token GLOBAL_VARIABLE195=null;
        Token LOCAL_VARIABLE196=null;
        LLVMParser.assembly_expr_return assembly_expr197 =null;



        String name=null;

        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1078:5: ( GLOBAL_VARIABLE | LOCAL_VARIABLE | assembly_expr )
            int alt268=3;
            switch ( input.LA(1) ) {
            case GLOBAL_VARIABLE:
                {
                alt268=1;
                }
                break;
            case LOCAL_VARIABLE:
                {
                alt268=2;
                }
                break;
            case 54:
                {
                alt268=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 268, 0, input);

                throw nvae;

            }

            switch (alt268) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1078:7: GLOBAL_VARIABLE
                    {
                    GLOBAL_VARIABLE195=(Token)match(input,GLOBAL_VARIABLE,FOLLOW_GLOBAL_VARIABLE_in_function_name8103); 

                    name = (GLOBAL_VARIABLE195!=null?GLOBAL_VARIABLE195.getText():null);

                    }
                    break;
                case 2 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1078:56: LOCAL_VARIABLE
                    {
                    LOCAL_VARIABLE196=(Token)match(input,LOCAL_VARIABLE,FOLLOW_LOCAL_VARIABLE_in_function_name8108); 

                    name = (LOCAL_VARIABLE196!=null?LOCAL_VARIABLE196.getText():null);

                    }
                    break;
                case 3 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1078:103: assembly_expr
                    {
                    pushFollow(FOLLOW_assembly_expr_in_function_name8113);
                    assembly_expr197=assembly_expr();

                    state._fsp--;


                    name = (assembly_expr197!=null?input.toString(assembly_expr197.start,assembly_expr197.stop):null);

                    }
                    break;

            }

            expr = valueFactory.createVariable(name);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "function_name"


    public static class assembly_expr_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "assembly_expr"
    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:1: assembly_expr : 'asm' ( 'sideeffect' )? ( 'alignstack' )? STRING ',' STRING ;
    public final LLVMParser.assembly_expr_return assembly_expr() throws RecognitionException {
        LLVMParser.assembly_expr_return retval = new LLVMParser.assembly_expr_return();
        retval.start = input.LT(1);


        try {
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:15: ( 'asm' ( 'sideeffect' )? ( 'alignstack' )? STRING ',' STRING )
            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:17: 'asm' ( 'sideeffect' )? ( 'alignstack' )? STRING ',' STRING
            {
            match(input,54,FOLLOW_54_in_assembly_expr8123); 

            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:23: ( 'sideeffect' )?
            int alt269=2;
            int LA269_0 = input.LA(1);

            if ( (LA269_0==81) ) {
                alt269=1;
            }
            switch (alt269) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:23: 'sideeffect'
                    {
                    match(input,81,FOLLOW_81_in_assembly_expr8125); 

                    }
                    break;

            }


            // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:37: ( 'alignstack' )?
            int alt270=2;
            int LA270_0 = input.LA(1);

            if ( (LA270_0==52) ) {
                alt270=1;
            }
            switch (alt270) {
                case 1 :
                    // D:\\workspace\\s\\JLLVM_b\\src\\cn\\edu\\sjtu\\jllvm\\VMCore\\Parser\\LLVM.g:1080:37: 'alignstack'
                    {
                    match(input,52,FOLLOW_52_in_assembly_expr8128); 

                    }
                    break;

            }


            match(input,STRING,FOLLOW_STRING_in_assembly_expr8131); 

            match(input,44,FOLLOW_44_in_assembly_expr8133); 

            match(input,STRING,FOLLOW_STRING_in_assembly_expr8135); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assembly_expr"

    // Delegated rules


    protected DFA143 dfa143 = new DFA143(this);
    protected DFA148 dfa148 = new DFA148(this);
    protected DFA153 dfa153 = new DFA153(this);
    protected DFA158 dfa158 = new DFA158(this);
    protected DFA164 dfa164 = new DFA164(this);
    protected DFA170 dfa170 = new DFA170(this);
    protected DFA175 dfa175 = new DFA175(this);
    protected DFA182 dfa182 = new DFA182(this);
    protected DFA181 dfa181 = new DFA181(this);
    protected DFA186 dfa186 = new DFA186(this);
    protected DFA185 dfa185 = new DFA185(this);
    protected DFA190 dfa190 = new DFA190(this);
    protected DFA189 dfa189 = new DFA189(this);
    protected DFA194 dfa194 = new DFA194(this);
    protected DFA193 dfa193 = new DFA193(this);
    protected DFA198 dfa198 = new DFA198(this);
    protected DFA197 dfa197 = new DFA197(this);
    protected DFA202 dfa202 = new DFA202(this);
    protected DFA201 dfa201 = new DFA201(this);
    protected DFA204 dfa204 = new DFA204(this);
    static final String DFA143_eotS =
        "\4\uffff";
    static final String DFA143_eofS =
        "\4\uffff";
    static final String DFA143_minS =
        "\2\5\2\uffff";
    static final String DFA143_maxS =
        "\2\136\2\uffff";
    static final String DFA143_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA143_specialS =
        "\4\uffff}>";
    static final String[] DFA143_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA143_eot = DFA.unpackEncodedString(DFA143_eotS);
    static final short[] DFA143_eof = DFA.unpackEncodedString(DFA143_eofS);
    static final char[] DFA143_min = DFA.unpackEncodedStringToUnsignedChars(DFA143_minS);
    static final char[] DFA143_max = DFA.unpackEncodedStringToUnsignedChars(DFA143_maxS);
    static final short[] DFA143_accept = DFA.unpackEncodedString(DFA143_acceptS);
    static final short[] DFA143_special = DFA.unpackEncodedString(DFA143_specialS);
    static final short[][] DFA143_transition;

    static {
        int numStates = DFA143_transitionS.length;
        DFA143_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA143_transition[i] = DFA.unpackEncodedString(DFA143_transitionS[i]);
        }
    }

    class DFA143 extends DFA {

        public DFA143(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 143;
            this.eot = DFA143_eot;
            this.eof = DFA143_eof;
            this.min = DFA143_min;
            this.max = DFA143_max;
            this.accept = DFA143_accept;
            this.special = DFA143_special;
            this.transition = DFA143_transition;
        }
        public String getDescription() {
            return "()* loopback of 780:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA148_eotS =
        "\4\uffff";
    static final String DFA148_eofS =
        "\4\uffff";
    static final String DFA148_minS =
        "\2\5\2\uffff";
    static final String DFA148_maxS =
        "\2\136\2\uffff";
    static final String DFA148_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA148_specialS =
        "\4\uffff}>";
    static final String[] DFA148_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA148_eot = DFA.unpackEncodedString(DFA148_eotS);
    static final short[] DFA148_eof = DFA.unpackEncodedString(DFA148_eofS);
    static final char[] DFA148_min = DFA.unpackEncodedStringToUnsignedChars(DFA148_minS);
    static final char[] DFA148_max = DFA.unpackEncodedStringToUnsignedChars(DFA148_maxS);
    static final short[] DFA148_accept = DFA.unpackEncodedString(DFA148_acceptS);
    static final short[] DFA148_special = DFA.unpackEncodedString(DFA148_specialS);
    static final short[][] DFA148_transition;

    static {
        int numStates = DFA148_transitionS.length;
        DFA148_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA148_transition[i] = DFA.unpackEncodedString(DFA148_transitionS[i]);
        }
    }

    class DFA148 extends DFA {

        public DFA148(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 148;
            this.eot = DFA148_eot;
            this.eof = DFA148_eof;
            this.min = DFA148_min;
            this.max = DFA148_max;
            this.accept = DFA148_accept;
            this.special = DFA148_special;
            this.transition = DFA148_transition;
        }
        public String getDescription() {
            return "()* loopback of 788:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA153_eotS =
        "\4\uffff";
    static final String DFA153_eofS =
        "\4\uffff";
    static final String DFA153_minS =
        "\2\5\2\uffff";
    static final String DFA153_maxS =
        "\2\136\2\uffff";
    static final String DFA153_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA153_specialS =
        "\4\uffff}>";
    static final String[] DFA153_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA153_eot = DFA.unpackEncodedString(DFA153_eotS);
    static final short[] DFA153_eof = DFA.unpackEncodedString(DFA153_eofS);
    static final char[] DFA153_min = DFA.unpackEncodedStringToUnsignedChars(DFA153_minS);
    static final char[] DFA153_max = DFA.unpackEncodedStringToUnsignedChars(DFA153_maxS);
    static final short[] DFA153_accept = DFA.unpackEncodedString(DFA153_acceptS);
    static final short[] DFA153_special = DFA.unpackEncodedString(DFA153_specialS);
    static final short[][] DFA153_transition;

    static {
        int numStates = DFA153_transitionS.length;
        DFA153_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA153_transition[i] = DFA.unpackEncodedString(DFA153_transitionS[i]);
        }
    }

    class DFA153 extends DFA {

        public DFA153(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 153;
            this.eot = DFA153_eot;
            this.eof = DFA153_eof;
            this.min = DFA153_min;
            this.max = DFA153_max;
            this.accept = DFA153_accept;
            this.special = DFA153_special;
            this.transition = DFA153_transition;
        }
        public String getDescription() {
            return "()* loopback of 796:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA158_eotS =
        "\4\uffff";
    static final String DFA158_eofS =
        "\4\uffff";
    static final String DFA158_minS =
        "\2\5\2\uffff";
    static final String DFA158_maxS =
        "\2\136\2\uffff";
    static final String DFA158_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA158_specialS =
        "\4\uffff}>";
    static final String[] DFA158_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA158_eot = DFA.unpackEncodedString(DFA158_eotS);
    static final short[] DFA158_eof = DFA.unpackEncodedString(DFA158_eofS);
    static final char[] DFA158_min = DFA.unpackEncodedStringToUnsignedChars(DFA158_minS);
    static final char[] DFA158_max = DFA.unpackEncodedStringToUnsignedChars(DFA158_maxS);
    static final short[] DFA158_accept = DFA.unpackEncodedString(DFA158_acceptS);
    static final short[] DFA158_special = DFA.unpackEncodedString(DFA158_specialS);
    static final short[][] DFA158_transition;

    static {
        int numStates = DFA158_transitionS.length;
        DFA158_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA158_transition[i] = DFA.unpackEncodedString(DFA158_transitionS[i]);
        }
    }

    class DFA158 extends DFA {

        public DFA158(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 158;
            this.eot = DFA158_eot;
            this.eof = DFA158_eof;
            this.min = DFA158_min;
            this.max = DFA158_max;
            this.accept = DFA158_accept;
            this.special = DFA158_special;
            this.transition = DFA158_transition;
        }
        public String getDescription() {
            return "()* loopback of 804:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA164_eotS =
        "\4\uffff";
    static final String DFA164_eofS =
        "\4\uffff";
    static final String DFA164_minS =
        "\2\5\2\uffff";
    static final String DFA164_maxS =
        "\2\136\2\uffff";
    static final String DFA164_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA164_specialS =
        "\4\uffff}>";
    static final String[] DFA164_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA164_eot = DFA.unpackEncodedString(DFA164_eotS);
    static final short[] DFA164_eof = DFA.unpackEncodedString(DFA164_eofS);
    static final char[] DFA164_min = DFA.unpackEncodedStringToUnsignedChars(DFA164_minS);
    static final char[] DFA164_max = DFA.unpackEncodedStringToUnsignedChars(DFA164_maxS);
    static final short[] DFA164_accept = DFA.unpackEncodedString(DFA164_acceptS);
    static final short[] DFA164_special = DFA.unpackEncodedString(DFA164_specialS);
    static final short[][] DFA164_transition;

    static {
        int numStates = DFA164_transitionS.length;
        DFA164_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA164_transition[i] = DFA.unpackEncodedString(DFA164_transitionS[i]);
        }
    }

    class DFA164 extends DFA {

        public DFA164(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 164;
            this.eot = DFA164_eot;
            this.eof = DFA164_eof;
            this.min = DFA164_min;
            this.max = DFA164_max;
            this.accept = DFA164_accept;
            this.special = DFA164_special;
            this.transition = DFA164_transition;
        }
        public String getDescription() {
            return "()* loopback of 812:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA170_eotS =
        "\4\uffff";
    static final String DFA170_eofS =
        "\4\uffff";
    static final String DFA170_minS =
        "\2\5\2\uffff";
    static final String DFA170_maxS =
        "\2\136\2\uffff";
    static final String DFA170_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA170_specialS =
        "\4\uffff}>";
    static final String[] DFA170_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA170_eot = DFA.unpackEncodedString(DFA170_eotS);
    static final short[] DFA170_eof = DFA.unpackEncodedString(DFA170_eofS);
    static final char[] DFA170_min = DFA.unpackEncodedStringToUnsignedChars(DFA170_minS);
    static final char[] DFA170_max = DFA.unpackEncodedStringToUnsignedChars(DFA170_maxS);
    static final short[] DFA170_accept = DFA.unpackEncodedString(DFA170_acceptS);
    static final short[] DFA170_special = DFA.unpackEncodedString(DFA170_specialS);
    static final short[][] DFA170_transition;

    static {
        int numStates = DFA170_transitionS.length;
        DFA170_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA170_transition[i] = DFA.unpackEncodedString(DFA170_transitionS[i]);
        }
    }

    class DFA170 extends DFA {

        public DFA170(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 170;
            this.eot = DFA170_eot;
            this.eof = DFA170_eof;
            this.min = DFA170_min;
            this.max = DFA170_max;
            this.accept = DFA170_accept;
            this.special = DFA170_special;
            this.transition = DFA170_transition;
        }
        public String getDescription() {
            return "()* loopback of 820:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA175_eotS =
        "\4\uffff";
    static final String DFA175_eofS =
        "\4\uffff";
    static final String DFA175_minS =
        "\2\5\2\uffff";
    static final String DFA175_maxS =
        "\2\136\2\uffff";
    static final String DFA175_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA175_specialS =
        "\4\uffff}>";
    static final String[] DFA175_transitionS = {
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\3\uffff"+
            "\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff\2\2\3\uffff"+
            "\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\3\uffff"+
            "\3\2\5\uffff\1\2\1\uffff\3\2",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\2\2\2\uffff\1\2\1\uffff"+
            "\1\3\1\uffff\1\1\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff\3\2\2\uffff"+
            "\2\2\3\uffff\2\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\1\2\3\uffff\3\2\5\uffff\1\2\1\uffff\3\2",
            "",
            ""
    };

    static final short[] DFA175_eot = DFA.unpackEncodedString(DFA175_eotS);
    static final short[] DFA175_eof = DFA.unpackEncodedString(DFA175_eofS);
    static final char[] DFA175_min = DFA.unpackEncodedStringToUnsignedChars(DFA175_minS);
    static final char[] DFA175_max = DFA.unpackEncodedStringToUnsignedChars(DFA175_maxS);
    static final short[] DFA175_accept = DFA.unpackEncodedString(DFA175_acceptS);
    static final short[] DFA175_special = DFA.unpackEncodedString(DFA175_specialS);
    static final short[][] DFA175_transition;

    static {
        int numStates = DFA175_transitionS.length;
        DFA175_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA175_transition[i] = DFA.unpackEncodedString(DFA175_transitionS[i]);
        }
    }

    class DFA175 extends DFA {

        public DFA175(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 175;
            this.eot = DFA175_eot;
            this.eof = DFA175_eof;
            this.min = DFA175_min;
            this.max = DFA175_max;
            this.accept = DFA175_accept;
            this.special = DFA175_special;
            this.transition = DFA175_transition;
        }
        public String getDescription() {
            return "()* loopback of 827:7: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA182_eotS =
        "\4\uffff";
    static final String DFA182_eofS =
        "\4\uffff";
    static final String DFA182_minS =
        "\1\51\1\5\2\uffff";
    static final String DFA182_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA182_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA182_specialS =
        "\4\uffff}>";
    static final String[] DFA182_transitionS = {
            "\1\2\1\uffff\1\1",
            "\1\3\1\uffff\1\3\3\uffff\1\3\2\uffff\1\3\2\uffff\2\3\3\uffff"+
            "\1\3\4\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\1\2\1\uffff"+
            "\1\1\25\uffff\2\3\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA182_eot = DFA.unpackEncodedString(DFA182_eotS);
    static final short[] DFA182_eof = DFA.unpackEncodedString(DFA182_eofS);
    static final char[] DFA182_min = DFA.unpackEncodedStringToUnsignedChars(DFA182_minS);
    static final char[] DFA182_max = DFA.unpackEncodedStringToUnsignedChars(DFA182_maxS);
    static final short[] DFA182_accept = DFA.unpackEncodedString(DFA182_acceptS);
    static final short[] DFA182_special = DFA.unpackEncodedString(DFA182_specialS);
    static final short[][] DFA182_transition;

    static {
        int numStates = DFA182_transitionS.length;
        DFA182_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA182_transition[i] = DFA.unpackEncodedString(DFA182_transitionS[i]);
        }
    }

    class DFA182 extends DFA {

        public DFA182(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 182;
            this.eot = DFA182_eot;
            this.eof = DFA182_eof;
            this.min = DFA182_min;
            this.max = DFA182_max;
            this.accept = DFA182_accept;
            this.special = DFA182_special;
            this.transition = DFA182_transition;
        }
        public String getDescription() {
            return "847:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?";
        }
    }
    static final String DFA181_eotS =
        "\4\uffff";
    static final String DFA181_eofS =
        "\4\uffff";
    static final String DFA181_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA181_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA181_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA181_specialS =
        "\4\uffff}>";
    static final String[] DFA181_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA181_eot = DFA.unpackEncodedString(DFA181_eotS);
    static final short[] DFA181_eof = DFA.unpackEncodedString(DFA181_eofS);
    static final char[] DFA181_min = DFA.unpackEncodedStringToUnsignedChars(DFA181_minS);
    static final char[] DFA181_max = DFA.unpackEncodedStringToUnsignedChars(DFA181_maxS);
    static final short[] DFA181_accept = DFA.unpackEncodedString(DFA181_acceptS);
    static final short[] DFA181_special = DFA.unpackEncodedString(DFA181_specialS);
    static final short[][] DFA181_transition;

    static {
        int numStates = DFA181_transitionS.length;
        DFA181_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA181_transition[i] = DFA.unpackEncodedString(DFA181_transitionS[i]);
        }
    }

    class DFA181 extends DFA {

        public DFA181(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 181;
            this.eot = DFA181_eot;
            this.eof = DFA181_eof;
            this.min = DFA181_min;
            this.max = DFA181_max;
            this.accept = DFA181_accept;
            this.special = DFA181_special;
            this.transition = DFA181_transition;
        }
        public String getDescription() {
            return "()* loopback of 849:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA186_eotS =
        "\4\uffff";
    static final String DFA186_eofS =
        "\4\uffff";
    static final String DFA186_minS =
        "\1\51\1\5\2\uffff";
    static final String DFA186_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA186_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA186_specialS =
        "\4\uffff}>";
    static final String[] DFA186_transitionS = {
            "\1\2\1\uffff\1\1",
            "\1\3\1\uffff\1\3\3\uffff\1\3\2\uffff\1\3\2\uffff\2\3\3\uffff"+
            "\1\3\4\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\1\2\1\uffff"+
            "\1\1\25\uffff\2\3\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA186_eot = DFA.unpackEncodedString(DFA186_eotS);
    static final short[] DFA186_eof = DFA.unpackEncodedString(DFA186_eofS);
    static final char[] DFA186_min = DFA.unpackEncodedStringToUnsignedChars(DFA186_minS);
    static final char[] DFA186_max = DFA.unpackEncodedStringToUnsignedChars(DFA186_maxS);
    static final short[] DFA186_accept = DFA.unpackEncodedString(DFA186_acceptS);
    static final short[] DFA186_special = DFA.unpackEncodedString(DFA186_specialS);
    static final short[][] DFA186_transition;

    static {
        int numStates = DFA186_transitionS.length;
        DFA186_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA186_transition[i] = DFA.unpackEncodedString(DFA186_transitionS[i]);
        }
    }

    class DFA186 extends DFA {

        public DFA186(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 186;
            this.eot = DFA186_eot;
            this.eof = DFA186_eof;
            this.min = DFA186_min;
            this.max = DFA186_max;
            this.accept = DFA186_accept;
            this.special = DFA186_special;
            this.transition = DFA186_transition;
        }
        public String getDescription() {
            return "854:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?";
        }
    }
    static final String DFA185_eotS =
        "\4\uffff";
    static final String DFA185_eofS =
        "\4\uffff";
    static final String DFA185_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA185_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA185_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA185_specialS =
        "\4\uffff}>";
    static final String[] DFA185_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA185_eot = DFA.unpackEncodedString(DFA185_eotS);
    static final short[] DFA185_eof = DFA.unpackEncodedString(DFA185_eofS);
    static final char[] DFA185_min = DFA.unpackEncodedStringToUnsignedChars(DFA185_minS);
    static final char[] DFA185_max = DFA.unpackEncodedStringToUnsignedChars(DFA185_maxS);
    static final short[] DFA185_accept = DFA.unpackEncodedString(DFA185_acceptS);
    static final short[] DFA185_special = DFA.unpackEncodedString(DFA185_specialS);
    static final short[][] DFA185_transition;

    static {
        int numStates = DFA185_transitionS.length;
        DFA185_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA185_transition[i] = DFA.unpackEncodedString(DFA185_transitionS[i]);
        }
    }

    class DFA185 extends DFA {

        public DFA185(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 185;
            this.eot = DFA185_eot;
            this.eof = DFA185_eof;
            this.min = DFA185_min;
            this.max = DFA185_max;
            this.accept = DFA185_accept;
            this.special = DFA185_special;
            this.transition = DFA185_transition;
        }
        public String getDescription() {
            return "()* loopback of 856:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA190_eotS =
        "\4\uffff";
    static final String DFA190_eofS =
        "\4\uffff";
    static final String DFA190_minS =
        "\1\51\1\5\2\uffff";
    static final String DFA190_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA190_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA190_specialS =
        "\4\uffff}>";
    static final String[] DFA190_transitionS = {
            "\1\2\1\uffff\1\1",
            "\1\3\1\uffff\1\3\3\uffff\1\3\2\uffff\1\3\2\uffff\2\3\3\uffff"+
            "\1\3\4\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\1\2\1\uffff"+
            "\1\1\25\uffff\2\3\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA190_eot = DFA.unpackEncodedString(DFA190_eotS);
    static final short[] DFA190_eof = DFA.unpackEncodedString(DFA190_eofS);
    static final char[] DFA190_min = DFA.unpackEncodedStringToUnsignedChars(DFA190_minS);
    static final char[] DFA190_max = DFA.unpackEncodedStringToUnsignedChars(DFA190_maxS);
    static final short[] DFA190_accept = DFA.unpackEncodedString(DFA190_acceptS);
    static final short[] DFA190_special = DFA.unpackEncodedString(DFA190_specialS);
    static final short[][] DFA190_transition;

    static {
        int numStates = DFA190_transitionS.length;
        DFA190_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA190_transition[i] = DFA.unpackEncodedString(DFA190_transitionS[i]);
        }
    }

    class DFA190 extends DFA {

        public DFA190(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 190;
            this.eot = DFA190_eot;
            this.eof = DFA190_eof;
            this.min = DFA190_min;
            this.max = DFA190_max;
            this.accept = DFA190_accept;
            this.special = DFA190_special;
            this.transition = DFA190_transition;
        }
        public String getDescription() {
            return "861:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?";
        }
    }
    static final String DFA189_eotS =
        "\4\uffff";
    static final String DFA189_eofS =
        "\4\uffff";
    static final String DFA189_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA189_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA189_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA189_specialS =
        "\4\uffff}>";
    static final String[] DFA189_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA189_eot = DFA.unpackEncodedString(DFA189_eotS);
    static final short[] DFA189_eof = DFA.unpackEncodedString(DFA189_eofS);
    static final char[] DFA189_min = DFA.unpackEncodedStringToUnsignedChars(DFA189_minS);
    static final char[] DFA189_max = DFA.unpackEncodedStringToUnsignedChars(DFA189_maxS);
    static final short[] DFA189_accept = DFA.unpackEncodedString(DFA189_acceptS);
    static final short[] DFA189_special = DFA.unpackEncodedString(DFA189_specialS);
    static final short[][] DFA189_transition;

    static {
        int numStates = DFA189_transitionS.length;
        DFA189_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA189_transition[i] = DFA.unpackEncodedString(DFA189_transitionS[i]);
        }
    }

    class DFA189 extends DFA {

        public DFA189(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 189;
            this.eot = DFA189_eot;
            this.eof = DFA189_eof;
            this.min = DFA189_min;
            this.max = DFA189_max;
            this.accept = DFA189_accept;
            this.special = DFA189_special;
            this.transition = DFA189_transition;
        }
        public String getDescription() {
            return "()* loopback of 863:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA194_eotS =
        "\4\uffff";
    static final String DFA194_eofS =
        "\4\uffff";
    static final String DFA194_minS =
        "\1\51\1\5\2\uffff";
    static final String DFA194_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA194_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA194_specialS =
        "\4\uffff}>";
    static final String[] DFA194_transitionS = {
            "\1\2\1\uffff\1\1",
            "\1\3\1\uffff\1\3\3\uffff\1\3\2\uffff\1\3\2\uffff\2\3\3\uffff"+
            "\1\3\4\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\1\2\1\uffff"+
            "\1\1\25\uffff\2\3\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA194_eot = DFA.unpackEncodedString(DFA194_eotS);
    static final short[] DFA194_eof = DFA.unpackEncodedString(DFA194_eofS);
    static final char[] DFA194_min = DFA.unpackEncodedStringToUnsignedChars(DFA194_minS);
    static final char[] DFA194_max = DFA.unpackEncodedStringToUnsignedChars(DFA194_maxS);
    static final short[] DFA194_accept = DFA.unpackEncodedString(DFA194_acceptS);
    static final short[] DFA194_special = DFA.unpackEncodedString(DFA194_specialS);
    static final short[][] DFA194_transition;

    static {
        int numStates = DFA194_transitionS.length;
        DFA194_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA194_transition[i] = DFA.unpackEncodedString(DFA194_transitionS[i]);
        }
    }

    class DFA194 extends DFA {

        public DFA194(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 194;
            this.eot = DFA194_eot;
            this.eof = DFA194_eof;
            this.min = DFA194_min;
            this.max = DFA194_max;
            this.accept = DFA194_accept;
            this.special = DFA194_special;
            this.transition = DFA194_transition;
        }
        public String getDescription() {
            return "868:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?";
        }
    }
    static final String DFA193_eotS =
        "\4\uffff";
    static final String DFA193_eofS =
        "\4\uffff";
    static final String DFA193_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA193_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA193_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA193_specialS =
        "\4\uffff}>";
    static final String[] DFA193_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA193_eot = DFA.unpackEncodedString(DFA193_eotS);
    static final short[] DFA193_eof = DFA.unpackEncodedString(DFA193_eofS);
    static final char[] DFA193_min = DFA.unpackEncodedStringToUnsignedChars(DFA193_minS);
    static final char[] DFA193_max = DFA.unpackEncodedStringToUnsignedChars(DFA193_maxS);
    static final short[] DFA193_accept = DFA.unpackEncodedString(DFA193_acceptS);
    static final short[] DFA193_special = DFA.unpackEncodedString(DFA193_specialS);
    static final short[][] DFA193_transition;

    static {
        int numStates = DFA193_transitionS.length;
        DFA193_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA193_transition[i] = DFA.unpackEncodedString(DFA193_transitionS[i]);
        }
    }

    class DFA193 extends DFA {

        public DFA193(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 193;
            this.eot = DFA193_eot;
            this.eof = DFA193_eof;
            this.min = DFA193_min;
            this.max = DFA193_max;
            this.accept = DFA193_accept;
            this.special = DFA193_special;
            this.transition = DFA193_transition;
        }
        public String getDescription() {
            return "()* loopback of 870:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA198_eotS =
        "\4\uffff";
    static final String DFA198_eofS =
        "\4\uffff";
    static final String DFA198_minS =
        "\1\51\1\5\2\uffff";
    static final String DFA198_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA198_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA198_specialS =
        "\4\uffff}>";
    static final String[] DFA198_transitionS = {
            "\1\2\1\uffff\1\1",
            "\1\3\1\uffff\1\3\3\uffff\1\3\2\uffff\1\3\2\uffff\2\3\3\uffff"+
            "\1\3\4\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\1\2\1\uffff"+
            "\1\1\25\uffff\2\3\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA198_eot = DFA.unpackEncodedString(DFA198_eotS);
    static final short[] DFA198_eof = DFA.unpackEncodedString(DFA198_eofS);
    static final char[] DFA198_min = DFA.unpackEncodedStringToUnsignedChars(DFA198_minS);
    static final char[] DFA198_max = DFA.unpackEncodedStringToUnsignedChars(DFA198_maxS);
    static final short[] DFA198_accept = DFA.unpackEncodedString(DFA198_acceptS);
    static final short[] DFA198_special = DFA.unpackEncodedString(DFA198_specialS);
    static final short[][] DFA198_transition;

    static {
        int numStates = DFA198_transitionS.length;
        DFA198_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA198_transition[i] = DFA.unpackEncodedString(DFA198_transitionS[i]);
        }
    }

    class DFA198 extends DFA {

        public DFA198(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 198;
            this.eot = DFA198_eot;
            this.eof = DFA198_eof;
            this.min = DFA198_min;
            this.max = DFA198_max;
            this.accept = DFA198_accept;
            this.special = DFA198_special;
            this.transition = DFA198_transition;
        }
        public String getDescription() {
            return "875:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?";
        }
    }
    static final String DFA197_eotS =
        "\4\uffff";
    static final String DFA197_eofS =
        "\4\uffff";
    static final String DFA197_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA197_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA197_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA197_specialS =
        "\4\uffff}>";
    static final String[] DFA197_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA197_eot = DFA.unpackEncodedString(DFA197_eotS);
    static final short[] DFA197_eof = DFA.unpackEncodedString(DFA197_eofS);
    static final char[] DFA197_min = DFA.unpackEncodedStringToUnsignedChars(DFA197_minS);
    static final char[] DFA197_max = DFA.unpackEncodedStringToUnsignedChars(DFA197_maxS);
    static final short[] DFA197_accept = DFA.unpackEncodedString(DFA197_acceptS);
    static final short[] DFA197_special = DFA.unpackEncodedString(DFA197_specialS);
    static final short[][] DFA197_transition;

    static {
        int numStates = DFA197_transitionS.length;
        DFA197_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA197_transition[i] = DFA.unpackEncodedString(DFA197_transitionS[i]);
        }
    }

    class DFA197 extends DFA {

        public DFA197(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 197;
            this.eot = DFA197_eot;
            this.eof = DFA197_eof;
            this.min = DFA197_min;
            this.max = DFA197_max;
            this.accept = DFA197_accept;
            this.special = DFA197_special;
            this.transition = DFA197_transition;
        }
        public String getDescription() {
            return "()* loopback of 877:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA202_eotS =
        "\4\uffff";
    static final String DFA202_eofS =
        "\4\uffff";
    static final String DFA202_minS =
        "\1\51\1\5\2\uffff";
    static final String DFA202_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA202_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA202_specialS =
        "\4\uffff}>";
    static final String[] DFA202_transitionS = {
            "\1\2\1\uffff\1\1",
            "\1\3\1\uffff\1\3\3\uffff\1\3\2\uffff\1\3\2\uffff\2\3\3\uffff"+
            "\1\3\4\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\1\2\1\uffff"+
            "\1\1\25\uffff\2\3\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA202_eot = DFA.unpackEncodedString(DFA202_eotS);
    static final short[] DFA202_eof = DFA.unpackEncodedString(DFA202_eofS);
    static final char[] DFA202_min = DFA.unpackEncodedStringToUnsignedChars(DFA202_minS);
    static final char[] DFA202_max = DFA.unpackEncodedStringToUnsignedChars(DFA202_maxS);
    static final short[] DFA202_accept = DFA.unpackEncodedString(DFA202_acceptS);
    static final short[] DFA202_special = DFA.unpackEncodedString(DFA202_specialS);
    static final short[][] DFA202_transition;

    static {
        int numStates = DFA202_transitionS.length;
        DFA202_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA202_transition[i] = DFA.unpackEncodedString(DFA202_transitionS[i]);
        }
    }

    class DFA202 extends DFA {

        public DFA202(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 202;
            this.eot = DFA202_eot;
            this.eof = DFA202_eof;
            this.min = DFA202_min;
            this.max = DFA202_max;
            this.accept = DFA202_accept;
            this.special = DFA202_special;
            this.transition = DFA202_transition;
        }
        public String getDescription() {
            return "882:7: ( ( '*' )* ptl1= parameter_type_list ( ( '*' )+ ptl2= parameter_type_list )* )?";
        }
    }
    static final String DFA201_eotS =
        "\4\uffff";
    static final String DFA201_eofS =
        "\4\uffff";
    static final String DFA201_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA201_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA201_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA201_specialS =
        "\4\uffff}>";
    static final String[] DFA201_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA201_eot = DFA.unpackEncodedString(DFA201_eotS);
    static final short[] DFA201_eof = DFA.unpackEncodedString(DFA201_eofS);
    static final char[] DFA201_min = DFA.unpackEncodedStringToUnsignedChars(DFA201_minS);
    static final char[] DFA201_max = DFA.unpackEncodedStringToUnsignedChars(DFA201_maxS);
    static final short[] DFA201_accept = DFA.unpackEncodedString(DFA201_acceptS);
    static final short[] DFA201_special = DFA.unpackEncodedString(DFA201_specialS);
    static final short[][] DFA201_transition;

    static {
        int numStates = DFA201_transitionS.length;
        DFA201_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA201_transition[i] = DFA.unpackEncodedString(DFA201_transitionS[i]);
        }
    }

    class DFA201 extends DFA {

        public DFA201(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 201;
            this.eot = DFA201_eot;
            this.eof = DFA201_eof;
            this.min = DFA201_min;
            this.max = DFA201_max;
            this.accept = DFA201_accept;
            this.special = DFA201_special;
            this.transition = DFA201_transition;
        }
        public String getDescription() {
            return "()* loopback of 884:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
    static final String DFA204_eotS =
        "\4\uffff";
    static final String DFA204_eofS =
        "\4\uffff";
    static final String DFA204_minS =
        "\1\53\1\5\2\uffff";
    static final String DFA204_maxS =
        "\1\53\1\104\2\uffff";
    static final String DFA204_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA204_specialS =
        "\4\uffff}>";
    static final String[] DFA204_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\2\uffff\2\2\3\uffff"+
            "\1\2\4\uffff\1\2\1\uffff\1\2\5\uffff\1\2\5\uffff\1\3\1\uffff"+
            "\1\1\25\uffff\2\2\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA204_eot = DFA.unpackEncodedString(DFA204_eotS);
    static final short[] DFA204_eof = DFA.unpackEncodedString(DFA204_eofS);
    static final char[] DFA204_min = DFA.unpackEncodedStringToUnsignedChars(DFA204_minS);
    static final char[] DFA204_max = DFA.unpackEncodedStringToUnsignedChars(DFA204_maxS);
    static final short[] DFA204_accept = DFA.unpackEncodedString(DFA204_acceptS);
    static final short[] DFA204_special = DFA.unpackEncodedString(DFA204_specialS);
    static final short[][] DFA204_transition;

    static {
        int numStates = DFA204_transitionS.length;
        DFA204_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA204_transition[i] = DFA.unpackEncodedString(DFA204_transitionS[i]);
        }
    }

    class DFA204 extends DFA {

        public DFA204(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 204;
            this.eot = DFA204_eot;
            this.eof = DFA204_eof;
            this.min = DFA204_min;
            this.max = DFA204_max;
            this.accept = DFA204_accept;
            this.special = DFA204_special;
            this.transition = DFA204_transition;
        }
        public String getDescription() {
            return "()* loopback of 890:9: ( ( '*' )+ ptl2= parameter_type_list )*";
        }
    }
 

    public static final BitSet FOLLOW_target_in_program55 = new BitSet(new long[]{0x3000000008020000L,0x0000000000200000L});
    public static final BitSet FOLLOW_named_type_in_program68 = new BitSet(new long[]{0x3000000008020000L});
    public static final BitSet FOLLOW_global_variable_in_program83 = new BitSet(new long[]{0x3000000000020000L});
    public static final BitSet FOLLOW_aliases_variable_in_program101 = new BitSet(new long[]{0x3000000000020000L});
    public static final BitSet FOLLOW_function_declaration_in_program118 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_function_definition_in_program148 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_target183 = new BitSet(new long[]{0x0800000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_set_in_target185 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_target193 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_STRING_in_target195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_named_type208 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_named_type210 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_named_type212 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_named_type222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_global_variable261 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_global_variable270 = new BitSet(new long[]{0x0400000004000000L,0x0000000000400008L});
    public static final BitSet FOLLOW_LINKAGE_in_global_variable273 = new BitSet(new long[]{0x0400000000000000L,0x0000000000400008L});
    public static final BitSet FOLLOW_86_in_global_variable285 = new BitSet(new long[]{0x0400000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_global_variable297 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_58_in_global_variable301 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_global_variable311 = new BitSet(new long[]{0x01024000204648A2L,0x0000000030000016L});
    public static final BitSet FOLLOW_initializer_in_global_variable320 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_global_variable332 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_section_in_global_variable334 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_global_variable355 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_align_in_global_variable357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_aliases_variable402 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_aliases_variable412 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_aliases_variable414 = new BitSet(new long[]{0x000240605D808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_LINKAGE_in_aliases_variable417 = new BitSet(new long[]{0x0002406059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_VISIBILITY_in_aliases_variable430 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_aliases_variable441 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_aliases_variable454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_function_declaration492 = new BitSet(new long[]{0x000240608C808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_LINKAGE_in_function_declaration495 = new BitSet(new long[]{0x0002406088808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_VISIBILITY_in_function_declaration509 = new BitSet(new long[]{0x0002404088808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_CCONV_in_function_declaration523 = new BitSet(new long[]{0x0002404088808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_PARAMETER_ATTRIBUTES_in_function_declaration537 = new BitSet(new long[]{0x0002404088808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_return_type_in_function_declaration549 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_function_declaration560 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_function_declaration570 = new BitSet(new long[]{0x0002644019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_argument_list_in_function_declaration572 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_function_declaration576 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_FUNCTION_ATTRIBUTES_in_function_declaration586 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_61_in_function_definition625 = new BitSet(new long[]{0x000240608C808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_LINKAGE_in_function_definition635 = new BitSet(new long[]{0x0002406088808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_VISIBILITY_in_function_definition649 = new BitSet(new long[]{0x0002404088808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_CCONV_in_function_definition663 = new BitSet(new long[]{0x0002404088808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_PARAMETER_ATTRIBUTES_in_function_definition677 = new BitSet(new long[]{0x0002404088808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_return_type_in_function_definition689 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_function_definition699 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_function_definition709 = new BitSet(new long[]{0x0002644019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_argument_list_in_function_definition711 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_function_definition715 = new BitSet(new long[]{0x0000000000010010L,0x0000000020000000L});
    public static final BitSet FOLLOW_FUNCTION_ATTRIBUTES_in_function_definition725 = new BitSet(new long[]{0x0000000000010010L,0x0000000020000000L});
    public static final BitSet FOLLOW_align_in_function_definition739 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_function_definition751 = new BitSet(new long[]{0x0280009808020040L,0x00000000041C4240L});
    public static final BitSet FOLLOW_basic_block_in_function_definition762 = new BitSet(new long[]{0x0280009808020040L,0x00000000441C4240L});
    public static final BitSet FOLLOW_94_in_function_definition775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_ID_in_basic_block805 = new BitSet(new long[]{0x0280009808020000L,0x00000000041C4240L});
    public static final BitSet FOLLOW_phi_op_in_basic_block819 = new BitSet(new long[]{0x0280009808020000L,0x00000000041C4240L});
    public static final BitSet FOLLOW_operator_in_basic_block833 = new BitSet(new long[]{0x0280009808020000L,0x00000000041C4240L});
    public static final BitSet FOLLOW_terminator_in_basic_block846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALIGN_in_align874 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_align876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SECTION_in_section894 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_STRING_in_section896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_terminator929 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_VOID_in_terminator934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_type_in_terminator947 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_terminator951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNWIND_in_terminator965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_terminator979 = new BitSet(new long[]{0x0000000001000100L});
    public static final BitSet FOLLOW_block_label_in_terminator999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_TYPE_in_terminator1019 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_terminator1023 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_terminator1025 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1029 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_terminator1031 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_terminator1063 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_terminator1067 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_terminator1071 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_terminator1073 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1077 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_terminator1100 = new BitSet(new long[]{0x0004000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_terminator1105 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_terminator1107 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_terminator1109 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1113 = new BitSet(new long[]{0x0004000000800000L});
    public static final BitSet FOLLOW_50_in_terminator1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_terminator1150 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_pointer_type_in_terminator1152 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_terminator1156 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_terminator1158 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_terminator1160 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1164 = new BitSet(new long[]{0x0004100000000000L});
    public static final BitSet FOLLOW_44_in_terminator1189 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1193 = new BitSet(new long[]{0x0004100000000000L});
    public static final BitSet FOLLOW_50_in_terminator1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_terminator1208 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_terminator1210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_terminator1225 = new BitSet(new long[]{0x0002404088808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_function_call_in_terminator1227 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_TO_in_terminator1242 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1246 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_UNWIND_in_terminator1248 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_block_label_in_terminator1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_terminator1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_block_label1293 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_block_label1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_op_in_operator1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vector_op_in_operator1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aggregate_op_in_operator1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memory_op_in_operator1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conversion_op_in_operator1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_icmp_op_in_operator1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fcmp_op_in_operator1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_op_in_operator1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_op_in_operator1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_binary_op1442 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_binary_op1452 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BINARY_OP_in_binary_op1454 = new BitSet(new long[]{0x4000400008808100L,0x0000000000001800L});
    public static final BitSet FOLLOW_76_in_binary_op1465 = new BitSet(new long[]{0x4000400008808100L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_binary_op1472 = new BitSet(new long[]{0x4000400008808100L});
    public static final BitSet FOLLOW_62_in_binary_op1479 = new BitSet(new long[]{0x0000400008808100L});
    public static final BitSet FOLLOW_element_type_in_binary_op1493 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_binary_op1498 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_binary_op1514 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_binary_op1517 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_binary_op1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_vector_op1554 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_vector_op1557 = new BitSet(new long[]{0x8000000000000000L,0x0000000000010080L});
    public static final BitSet FOLLOW_63_in_vector_op1566 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_vector_type_in_vector_op1570 = new BitSet(new long[]{0x0000000808020000L});
    public static final BitSet FOLLOW_variable_in_vector_op1574 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_vector_op1576 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_vector_op1580 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_vector_op1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_vector_op1603 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_vector_type_in_vector_op1607 = new BitSet(new long[]{0x0000000808020000L});
    public static final BitSet FOLLOW_variable_in_vector_op1611 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_vector_op1613 = new BitSet(new long[]{0x0000000008808100L});
    public static final BitSet FOLLOW_element_type_in_vector_op1617 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_vector_op1621 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_vector_op1623 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_vector_op1627 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_vector_op1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_vector_op1649 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_vector_type_in_vector_op1653 = new BitSet(new long[]{0x0000000808020000L});
    public static final BitSet FOLLOW_variable_in_vector_op1657 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_vector_op1659 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_vector_type_in_vector_op1663 = new BitSet(new long[]{0x0000000808020000L});
    public static final BitSet FOLLOW_variable_in_vector_op1667 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_vector_op1669 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_vector_type_in_vector_op1673 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_vector_op1693 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_vector_op1697 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_vector_op1701 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_vector_op1722 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_vector_op1726 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_vector_op1730 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_vector_op1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_aggregate_op1786 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_aggregate_op1789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000101L});
    public static final BitSet FOLLOW_64_in_aggregate_op1798 = new BitSet(new long[]{0x0002000008000000L,0x0000000022000000L});
    public static final BitSet FOLLOW_aggregate_type_in_aggregate_op1802 = new BitSet(new long[]{0x0000000808020000L});
    public static final BitSet FOLLOW_variable_in_aggregate_op1806 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_aggregate_op1808 = new BitSet(new long[]{0x0000000808420000L});
    public static final BitSet FOLLOW_index_in_aggregate_op1812 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_aggregate_op1828 = new BitSet(new long[]{0x0000000808420000L});
    public static final BitSet FOLLOW_index_in_aggregate_op1832 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_72_in_aggregate_op1844 = new BitSet(new long[]{0x0002000008000000L,0x0000000022000000L});
    public static final BitSet FOLLOW_aggregate_type_in_aggregate_op1848 = new BitSet(new long[]{0x0000000808020000L});
    public static final BitSet FOLLOW_variable_in_aggregate_op1852 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_aggregate_op1854 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_aggregate_op1858 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_aggregate_op1862 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_aggregate_op1864 = new BitSet(new long[]{0x0000000808420000L});
    public static final BitSet FOLLOW_index_in_aggregate_op1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getelementptr_op_in_memory_op1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alloca_op_in_memory_op1909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_op_in_memory_op1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_op_in_memory_op1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_alloca_op1956 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_alloca_op1958 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_alloca_op1960 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_alloca_op1964 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_alloca_op1980 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_alloca_op1984 = new BitSet(new long[]{0x0000000808420000L});
    public static final BitSet FOLLOW_index_in_alloca_op1986 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_alloca_op1998 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_align_in_alloca_op2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_load_op2033 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_load_op2035 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_VOLATILE_in_load_op2046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_load_op2052 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_pointer_type_in_load_op2061 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_load_op2063 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_load_op2081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_align_in_load_op2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOLATILE_in_store_op2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_store_op2124 = new BitSet(new long[]{0x0002404019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_first_class_type_in_store_op2139 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_store_op2143 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_store_op2146 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_pointer_type_in_store_op2155 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_store_op2159 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_store_op2168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_align_in_store_op2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_getelementptr_op2203 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_getelementptr_op2205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_getelementptr_op2207 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000020L});
    public static final BitSet FOLLOW_69_in_getelementptr_op2216 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_pointer_type_in_getelementptr_op2227 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_getelementptr_op2229 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_getelementptr_op2238 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_getelementptr_op2240 = new BitSet(new long[]{0x0000000808420000L});
    public static final BitSet FOLLOW_index_in_getelementptr_op2242 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_variable_in_conversion_op2294 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_conversion_op2296 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_CONVERSION_OP_in_conversion_op2298 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_conversion_op2302 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_conversion_op2304 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_TO_in_conversion_op2306 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_conversion_op2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_icmp_op2349 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_icmp_op2351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_icmp_op2353 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_ICMP_COND_in_icmp_op2371 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_CMP_COND_in_icmp_op2376 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_icmp_op2389 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_icmp_op2394 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_icmp_op2410 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_icmp_op2412 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_icmp_op2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_fcmp_op2444 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_fcmp_op2446 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_fcmp_op2448 = new BitSet(new long[]{0x0000000000002480L});
    public static final BitSet FOLLOW_FCMP_COND_in_fcmp_op2466 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_CMP_COND_in_fcmp_op2471 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_BOOLEAN_in_fcmp_op2476 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_fcmp_op2489 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_fcmp_op2494 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_fcmp_op2510 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_fcmp_op2512 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_fcmp_op2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_phi_op2544 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_phi_op2554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_phi_op2556 = new BitSet(new long[]{0x0002404019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_first_class_type_in_phi_op2565 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_phi_op2575 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_phi_op2581 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_phi_op2591 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_phi_op2597 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_phi_op2600 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_phi_op2610 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_phi_op2612 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_phi_op2616 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_phi_op2618 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_phi_op2622 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_phi_op2625 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_variable_in_select_op2652 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_select_op2654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_select_op2656 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_BOOLEAN_TYPE_in_select_op2658 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_select_op2662 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_select_op2664 = new BitSet(new long[]{0x0002404019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_first_class_type_in_select_op2668 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_select_op2672 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_select_op2674 = new BitSet(new long[]{0x0002404019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_first_class_type_in_select_op2678 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_select_op2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_call_op2713 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_call_op2715 = new BitSet(new long[]{0x0200000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_call_op2722 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_call_op2728 = new BitSet(new long[]{0x0002404088808300L,0x0000000022000000L});
    public static final BitSet FOLLOW_function_call_in_call_op2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CCONV_in_function_call2763 = new BitSet(new long[]{0x0002404088808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_PARAMETER_ATTRIBUTES_in_function_call2777 = new BitSet(new long[]{0x0002404088808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_return_type_in_function_call2789 = new BitSet(new long[]{0x0040000008020000L});
    public static final BitSet FOLLOW_function_name_in_function_call2791 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_function_call2801 = new BitSet(new long[]{0x0002644019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_argument_list_in_function_call2803 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_function_call2807 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_FUNCTION_ATTRIBUTES_in_function_call2818 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_45_in_argument_list2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_first_class_type_in_argument_list2867 = new BitSet(new long[]{0x00001008A84648B2L,0x0000000000000016L});
    public static final BitSet FOLLOW_PARAMETER_ATTRIBUTES_in_argument_list2884 = new BitSet(new long[]{0x00001008A84648B2L,0x0000000000000016L});
    public static final BitSet FOLLOW_align_in_argument_list2903 = new BitSet(new long[]{0x00001008284648A2L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_argument_list2920 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_argument_list2947 = new BitSet(new long[]{0x0002404019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_first_class_type_in_argument_list2962 = new BitSet(new long[]{0x00001008A84648B2L,0x0000000000000016L});
    public static final BitSet FOLLOW_PARAMETER_ATTRIBUTES_in_argument_list2980 = new BitSet(new long[]{0x00001008A84648B2L,0x0000000000000016L});
    public static final BitSet FOLLOW_align_in_argument_list3001 = new BitSet(new long[]{0x00001008284648A2L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_argument_list3020 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_argument_list3048 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_argument_list3050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_variable3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_variable3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDEF_in_variable3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_constant_in_expression3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getelementptr_expr_in_expression3134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conversion_expr_in_expression3144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_expr_in_expression3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cmp_expr_in_expression3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_expression3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_getelementptr_expr3205 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_getelementptr_expr3208 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_getelementptr_expr3221 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_pointer_type_in_getelementptr_expr3223 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_getelementptr_expr3234 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_getelementptr_expr3246 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_getelementptr_expr3248 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_getelementptr_expr3250 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_getelementptr_expr3264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONVERSION_OP_in_conversion_expr3285 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_conversion_expr3287 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_conversion_expr3291 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_conversion_expr3293 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_TO_in_conversion_expr3295 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_conversion_expr3299 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_conversion_expr3301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_OP_in_binary_expr3338 = new BitSet(new long[]{0x4000020000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_76_in_binary_expr3349 = new BitSet(new long[]{0x4000020000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_binary_expr3363 = new BitSet(new long[]{0x4000020000000000L});
    public static final BitSet FOLLOW_62_in_binary_expr3377 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_binary_expr3390 = new BitSet(new long[]{0x0000400008808100L});
    public static final BitSet FOLLOW_element_type_in_binary_expr3405 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_binary_expr3416 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_binary_expr3434 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_binary_expr3437 = new BitSet(new long[]{0x0000400008808100L});
    public static final BitSet FOLLOW_element_type_in_binary_expr3452 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_binary_expr3463 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_binary_expr3481 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_binary_expr3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_cmp_expr3517 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_ICMP_COND_in_cmp_expr3527 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_CMP_COND_in_cmp_expr3536 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_65_in_cmp_expr3552 = new BitSet(new long[]{0x0000000000002480L});
    public static final BitSet FOLLOW_FCMP_COND_in_cmp_expr3556 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_CMP_COND_in_cmp_expr3565 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_BOOLEAN_in_cmp_expr3570 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_cmp_expr3589 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_cmp_expr3596 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_cmp_expr3606 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_cmp_expr3622 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_cmp_expr3635 = new BitSet(new long[]{0x0002404008808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_scalar_type_in_cmp_expr3651 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_vector_type_in_cmp_expr3661 = new BitSet(new long[]{0x00000008284648A0L,0x0000000000000016L});
    public static final BitSet FOLLOW_expression_in_cmp_expr3677 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_cmp_expr3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_id_type3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_TYPE_in_element_type3735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_TYPE_in_element_type3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATING_POINT_TYPE_in_element_type3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_type_in_element_type3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_type_in_scalar_type3785 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_scalar_type3797 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type3812 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type3817 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_structure_type_in_scalar_type3838 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type3859 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type3879 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type3892 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type3934 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type3947 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_union_type_in_scalar_type3979 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4000 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type4020 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4033 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type4075 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4088 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_packed_structure_type_in_scalar_type4120 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4133 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type4148 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4153 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_array_type_in_scalar_type4174 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4185 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type4200 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4205 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_vector_type_in_scalar_type4226 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4237 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type4252 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4257 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_VOID_in_scalar_type4278 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_scalar_type4289 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_scalar_type4294 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_VOID_in_primitive_type4330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_primitive_type4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METADATA_in_primitive_type4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_type_in_primitive_type4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_type_in_first_class_type4387 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_first_class_type4399 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4413 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4418 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_structure_type_in_first_class_type4439 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_first_class_type4450 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4465 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4470 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_union_type_in_first_class_type4491 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_first_class_type4502 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4518 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4523 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_packed_structure_type_in_first_class_type4544 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4555 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4569 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4574 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_array_type_in_first_class_type4595 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_first_class_type4616 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4633 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4638 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_vector_type_in_first_class_type4670 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_first_class_type4691 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4708 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4713 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_VOID_in_first_class_type4745 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_first_class_type4756 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_first_class_type4761 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_LABEL_in_first_class_type4782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METADATA_in_first_class_type4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_type_in_derived_type4817 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_derived_type4829 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type4848 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type4862 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type4882 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type4907 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_structure_type_in_derived_type4930 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_derived_type4942 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type4960 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type4974 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type4994 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5018 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_union_type_in_derived_type5041 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5053 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5071 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5085 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5105 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5129 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_packed_structure_type_in_derived_type5152 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5165 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5183 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5197 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5217 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5241 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_array_type_in_derived_type5266 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5279 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5297 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5311 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5331 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5355 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_vector_type_in_derived_type5380 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5392 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5410 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5424 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5444 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5468 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_VOID_in_derived_type5493 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5508 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5520 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_derived_type5538 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_derived_type5558 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_LABEL_in_derived_type5572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METADATA_in_derived_type5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPAQUE_in_derived_type5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_type_in_aggregate_type5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_in_aggregate_type5627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_type_in_aggregate_type5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_type_in_aggregate_type5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_type_in_pointer_type5681 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5696 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type5716 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5730 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type5750 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_structure_type_in_pointer_type5780 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5795 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type5815 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5829 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type5849 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_union_type_in_pointer_type5879 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5893 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type5913 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5927 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type5947 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_packed_structure_type_in_pointer_type5977 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type5992 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6012 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6026 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6046 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_array_type_in_pointer_type6076 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6091 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6111 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6125 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6145 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_vector_type_in_pointer_type6175 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6189 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6209 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6223 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6243 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_VOID_in_pointer_type6277 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6295 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6309 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_pointer_type6329 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_pointer_type6350 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_93_in_structure_type6376 = new BitSet(new long[]{0x0002404059808100L,0x0000000062000000L});
    public static final BitSet FOLLOW_type_list_in_structure_type6379 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_structure_type6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_packed_structure_type6418 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_packed_structure_type6420 = new BitSet(new long[]{0x0002404059808100L,0x0000000062000000L});
    public static final BitSet FOLLOW_type_list_in_packed_structure_type6423 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_packed_structure_type6430 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_packed_structure_type6432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_union_type6459 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_union_type6461 = new BitSet(new long[]{0x0002404059808100L,0x0000000062000000L});
    public static final BitSet FOLLOW_type_list_in_union_type6464 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_union_type6471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derived_type_in_type_list6502 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_type_list6507 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_type_list6513 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_49_in_array_type6533 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_array_type6535 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_array_type6537 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_array_type6539 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_array_type6541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_vector_type6559 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_INTEGER_in_vector_type6561 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_vector_type6563 = new BitSet(new long[]{0x0000000008808100L});
    public static final BitSet FOLLOW_element_type_in_vector_type6565 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_vector_type6567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_type_in_return_type6585 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_return_type6596 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type6611 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6622 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_structure_type_in_return_type6645 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_return_type6666 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type6686 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6699 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type6741 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6754 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_union_type_in_return_type6787 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_return_type6808 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type6828 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6841 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type6883 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6896 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_packed_structure_type_in_return_type6929 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6940 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type6955 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type6966 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_array_type_in_return_type6989 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type7000 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type7015 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type7026 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_vector_type_in_return_type7049 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type7060 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type7075 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type7086 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_VOID_in_return_type7109 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_parameter_type_list_in_return_type7120 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_return_type7131 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_element_type_in_function_type7168 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_function_type7180 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7198 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7210 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7228 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_structure_type_in_function_type7247 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_function_type7259 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7277 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7289 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7307 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_union_type_in_function_type7326 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_43_in_function_type7337 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7355 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7367 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7385 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_packed_structure_type_in_function_type7404 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_function_type7415 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7433 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7445 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7463 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_array_type_in_function_type7482 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_function_type7494 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7512 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7524 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7542 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_vector_type_in_function_type7561 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_function_type7572 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7590 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7602 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7620 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_VOID_in_function_type7639 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7653 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_function_type7665 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_parameter_type_list_in_function_type7683 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_41_in_parameter_type_list7719 = new BitSet(new long[]{0x0002644019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_45_in_parameter_type_list7723 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_first_class_type_in_parameter_type_list7737 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_parameter_type_list7748 = new BitSet(new long[]{0x0002404019808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_first_class_type_in_parameter_type_list7754 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_parameter_type_list7762 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parameter_type_list7764 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_parameter_type_list7772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_initializer7793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_initializer7803 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_STRING_in_initializer7805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_initializer7815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_initializer7825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_index7844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_index7854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getelementptr_expr_in_constant7872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conversion_expr_in_constant7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_expr_in_constant7893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cmp_expr_in_constant7903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complex_constant_in_constant7913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_constant_in_constant7923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_simple_constant7941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_simple_constant7951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_constant7961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATING_POINT_in_simple_constant7971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_simple_constant7981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_constant_in_complex_constant7999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_constant_in_complex_constant8009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vector_constant_in_complex_constant8019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derived_type_in_constant_list8028 = new BitSet(new long[]{0x01024000204648A0L,0x0000000030000016L});
    public static final BitSet FOLLOW_initializer_in_constant_list8030 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_constant_list8033 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_derived_type_in_constant_list8035 = new BitSet(new long[]{0x01024000204648A0L,0x0000000030000016L});
    public static final BitSet FOLLOW_initializer_in_constant_list8037 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_93_in_structure_constant8047 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_constant_list_in_structure_constant8049 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_structure_constant8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_array_constant8059 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_constant_list_in_array_constant8061 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_array_constant8063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_vector_constant8071 = new BitSet(new long[]{0x0002404059808100L,0x0000000022000000L});
    public static final BitSet FOLLOW_constant_list_in_vector_constant8073 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_vector_constant8075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_VARIABLE_in_function_name8103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCAL_VARIABLE_in_function_name8108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assembly_expr_in_function_name8113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_assembly_expr8123 = new BitSet(new long[]{0x0010000200000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_assembly_expr8125 = new BitSet(new long[]{0x0010000200000000L});
    public static final BitSet FOLLOW_52_in_assembly_expr8128 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_STRING_in_assembly_expr8131 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_assembly_expr8133 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_STRING_in_assembly_expr8135 = new BitSet(new long[]{0x0000000000000002L});

}