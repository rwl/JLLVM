package cn.edu.sjtu.jllvm.test;

import java.io.PrintWriter;

public class ESPArguments {
	
	//ESP
	public static boolean
	
		DEBUG_CURRENT_FUNCTION = true,
	
		TEST_HTTPD = false,		//test httpd
		
		DEBUG_ALL_INFO = false,
		
		DEBUG_LOCK_INFO = true,
		
		DEBUG_INFO_TO_FILE = true,		//test info write to file
	
		DEBUG_SPECIAL_FUNCTION = false;	//false if debug all functions, true to debug SpecialFunctions[]

	public static String SpecialFunctions[] = {"ap_core_translate"};
	
	public static PrintWriter fileWriter;
}
