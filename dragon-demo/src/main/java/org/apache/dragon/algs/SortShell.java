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
		int length = ds.length;
		int h = 1;
		//确定步长：1，4，13，40，121，364，1093，。。。
		while(h < length / 3){
			h = 3 * h + 1;
		}
		//按步长循环排序
		for(; h >= 1; h /= 3){//调整步长
		//h-sort the array
			for(int i = h; i < length; i++){
				//insert a[i] among a[i - h], a[i - 2 * h], a[i - 3 * h] ...
				for(int j = i; j >= h; j -= h){
					if(ds[j] < ds[j - h]){
						int t = ds[j];
						ds[j] = ds[j - h];
						ds[j - h] = t;
					}
				}
			}
		}
	}

}
