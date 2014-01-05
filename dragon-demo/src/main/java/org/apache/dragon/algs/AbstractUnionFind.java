package org.apache.dragon.algs;

import org.apache.log4j.Logger;


/**
 * UnionFind: union-find api
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 3, 2014
 * @since 1.0
 */
public abstract class AbstractUnionFind {

	//Local variables
	int[] ids;
	int count;
	
	//Constructor
	/**
	 * Creates a new <code>UnionFind</code> instance. initialize N sites with integer names(0, N - 1)
	 * 
	 * @param count
	 */
	public AbstractUnionFind(int count){
		this.count = count;
		ids = new int[count];
		for(int i = 0; i < count; i++){
			ids[i] = i;
		}
	}
	
	//Logic
	/**
	 * add connection between p and q
	 * 
	 * @param p
	 * @param q
	 */
	public abstract void union(int p, int q);
	
	/**
	 * component identifier for p(0, N - 1)
	 * 
	 * @param p
	 * @return
	 */
	public abstract int find(int p);
	
	/**
	 * return true if p and q are in the same component
	 * 
	 * @param p
	 * @return
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * number of components
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}

}
