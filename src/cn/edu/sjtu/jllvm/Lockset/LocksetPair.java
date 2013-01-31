package cn.edu.sjtu.jllvm.Lockset;

public class LocksetPair {
	private Lockset entry_ls;
	private Lockset out_ls;
	public LocksetPair(Lockset en, Lockset out){
		entry_ls = en;
		out_ls = out;
	}
	
	public boolean equals(LocksetPair lp){
		return entry_ls.equals(lp.entry_ls) && out_ls.equals(lp.out_ls);
	}
}
