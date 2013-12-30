package org.apache.dragon.algs;

import org.apache.dragon.commons.set.BitArray;
import org.apache.dragon.commons.set.Bits;

/**
 * BitsSearch: 位搜索
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 28, 2013
 * @since 1.0
 */
public class BitsSearch {

	//Local variables
	/**
	 * store data
	 */
	private Bits data;
	
	//Constructor
	/**
	 * Creates a new <code>BitsSearch</code> instance with data. 
	 * 
	 * @param data
	 */
	public BitsSearch(int[] data, int max){
		this.data = new BitArray(max);
		for(int d : data){
			this.data.set(d, 1);
		}
	}

	//Logic
	/**
	 * bit Search
	 * 
	 * @param key
	 * @return
	 */
	public boolean search(int key){
		return this.data.get(key) == 1;
	}

}
