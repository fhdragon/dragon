package org.apache.dragon.algs;

/**
 * QuickFind: quick-find api
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 3, 2014
 * @since 1.0
 */
public class QuickFind extends AbstractUnionFind {

	//Local variables
	
	//Constructor
	/**
	 * Creates a new <code>UnionFind</code> instance. initialize N sites with integer names(0, N - 1)
	 * 
	 * @param count
	 */
	public QuickFind(int count){
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
		//put p and q into the same component
		int pid = find(p);
		int qid = find(q);
		//rename p's component to q's name
		if(pid != qid) {
			for(int i = 0, maxi = ids.length; i < maxi; i++){
				if(ids[i] == pid){
					ids[i] = qid;
				}
			}
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
		return ids[p];
	}

}
