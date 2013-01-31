package cn.edu.sjtu.jllvm.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.commons.io.FileUtils;

import cn.edu.sjtu.jllvm.Lockset.FunctionCache;
import cn.edu.sjtu.jllvm.Lockset.LocksetTraverse;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMLexer;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMParser;

public class TestLocksetTraverse {
	public void readFile(String name) throws Exception {
		File file = new File(name);
		byte[] buffer = new byte[(int) file.length()];
		BufferedInputStream f = new BufferedInputStream(new FileInputStream(file));
	   	f.read(buffer);
	   	LLVMLexer l = new LLVMLexer(new ANTLRStringStream(new String(buffer)));
		CommonTokenStream ct = new CommonTokenStream(l);
		LLVMParser p = new LLVMParser(ct);
		Module cfg = p.program();
		
		LocksetTraverse traverse= new LocksetTraverse();
		traverse.traverse_cfg(cfg);
		
		Hashtable<String, FunctionCache> caches = traverse.getFunctionCache();
		List<String> keys = new ArrayList<String>(caches.keySet());
		
		int count=0;
		for(String functionName: keys){
			FunctionCache cache = caches.get(functionName);
			if(cache.isRelateToLock()){
				System.out.print(file.getAbsolutePath()+":"+functionName+"\n"+cache.toString());
				count++;
			}
		}
		
		System.out.println("num functions:"+count);
	}
	
	public static void main(String [] args) throws Exception{
		Collection<File> cfgFiles = FileUtils.listFiles(new File("Example"),
				new String[] { "ll" }, true);
		for (File file : cfgFiles) {
			System.out.println("Testing: " + file.getName());
			TestLocksetTraverse test = new TestLocksetTraverse();
			test.readFile(file.getAbsolutePath());
			System.out.println("Finished: " + file.getName());
			System.out.println("Press ENTER to continue(import 'c' to quit)...");
			
			int in;
			while ((in = System.in.read()) != '\n'){
				if(in == 'c'){
					in = 0;
					break;
				}
			}
			
			if(in == 0)
				break;
		}
	}
}
