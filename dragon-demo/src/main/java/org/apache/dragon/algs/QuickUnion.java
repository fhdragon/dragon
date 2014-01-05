package org.apache.dragon.algs;

/**
 * QuickUnion: quick-union api
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 3, 2014
 * @since 1.0
 */
public class QuickUnion extends AbstractUnionFind {

	//Local variables
	
	//Constructor
	/**
	 * Creates a new <code>QuickUnion</code> instance. initialize N sites with integer names(0, N - 1)
	 * 
	 * @param count
	 */
	public QuickUnion(int count){
		super(count);
	}
	
	//Logic
	/**
	 * add connection between p and q
	 * 
	 * @param p
	 * @param q
	 */
	@Override
	public void union(int p, int q) {
		//give p and q the same root
		int pid = find(p);
		int qid = find(q);
		//rename p's component to q's name
		if(pid != qid) {
			ids[p] = qid;
			count--;
		}
	}
	
	/**
	 * component identifier for p(0, N - 1)
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int find(int p) {
		//find component name
		while(p != ids[p]){
			p = ids[p];
		}
		return p;
	}

}
