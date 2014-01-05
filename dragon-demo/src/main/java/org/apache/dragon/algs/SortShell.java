package org.apache.dragon.algs;

/**
 * SortSelection: shell排序实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 5, 2014
 * @since 1.0
 */
public class SortShell {

	//Local variables

	//Logic
	/**
	 * sort ds
	 * 
	 * @param is
	 */
	public static void sort(int[] ds){
		for(int i = 1, maxi = ds.length; i < maxi; i++){
			for(int j = i; j > 0; j--){
				if(ds[j] < ds[j - 1]){
					int t = ds[j];
					ds[j] = ds[j - 1];
					ds[j - 1] = t;
				}
			}
		}
	}

}
