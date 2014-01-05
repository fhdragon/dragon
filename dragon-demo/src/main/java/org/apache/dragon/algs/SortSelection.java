package org.apache.dragon.algs;

/**
 * SortSelection: 选择排序实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 5, 2014
 * @since 1.0
 */
public class SortSelection {

	//Local variables

	//Logic
	/**
	 * sort ds
	 * 
	 * @param is
	 */
	public static void sort(int[] ds){
		for(int i = 0, maxi = ds.length - 1; i < maxi; i++){
			int min = i;
			for(int j = i + 1, maxj = ds.length; j < maxj; j++){
				if(ds[min] > ds[j]){
					min = j;
				}
			}
			int t = ds[min];
			ds[min] = ds[i];
			ds[i] = t;
		}
	}

}
