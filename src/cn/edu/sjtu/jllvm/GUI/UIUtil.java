package cn.edu.sjtu.jllvm.GUI;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

import cn.edu.sjtu.jllvm.ESP.ESPChecking;
import cn.edu.sjtu.jllvm.ESP.ESPProperty.ESPTransitionSystem;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMLexer;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMParser;

public class UIUtil {
	public static String filePath = "./Example/httpd_all_modules.ll";
	public static String fileFolder = ".";
	
	public static boolean 
		DEBUG_ALL_INFO = false,
		DEBUG_LOCK_INFO = true,
		
		DEBUG_SPECIAL_FUNCTION = false;
	
	public static String SpecialFunctions[] = {"allocator_alloc"};
	
	public String run() throws Exception {
		if(!filePath.endsWith(".ll")){
			return "";
		}
		
		File file = new File(filePath);
		
		if(!file.exists()){
			return "";
		}
		fileFolder = file.getParent();
		
		byte[] buffer = new byte[(int) file.length()];
		BufferedInputStream f = new BufferedInputStream(new FileInputStream(file));
	   	f.read(buffer);
	   	LLVMLexer l = new LLVMLexer(new ANTLRStringStream(new String(buffer)));
		CommonTokenStream ct = new CommonTokenStream(l);
		LLVMParser p = new LLVMParser(ct);
		BasicBlock.CONTACT=false;
		Module cfg = p.program();
		cfg.syntaxAnalysis();
		
		//target is a ESP system
		ESPTransitionSystem system = null;	
		if(DEBUG_SPECIAL_FUNCTION){
			system = new ESPTransitionSystem(cfg, SpecialFunctions);
		}else{
			system = new ESPTransitionSystem(cfg);
		}
		ESPChecking mc = new ESPChecking();
		
		//solve the ESP system with standard ModelChecking algorithm
		mc.solve(system);
		
		/*if(DEBUG_INFO_TO_FILE){
			String dir = file.getParent()+"\\ModelChecking_ESP_output\\";
			File out_dir = new File(dir);
			if(!out_dir.exists()){
				out_dir.mkdir();
			}
			String fileName = file.getName();
			fileName = fileName.substring(0, fileName.length()-3)+"_ESP.txt";
			File outputFile = new File(dir+fileName);
			if(!outputFile.exists()){
				outputFile.createNewFile();
			}
			
			ESPArguments.fileWriter = new PrintWriter(new FileWriter(outputFile));
		}*/
		
		String result = mc.getInfo();
		
		return result;
		/*if(ESPArguments.DEBUG_INFO_TO_FILE){
			ESPArguments.fileWriter.close();
		}*/
	}
}
