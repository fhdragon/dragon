package org.apache.dragon.algs;

/**
 * BinarySearch: 二叉树搜索
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 28, 2013
 * @since 1.0
 */
public class BinarySearch {

	//Local variables

	//Logic
	/**
	 * binarySearch: loop
	 * 
	 * @param key
	 * @param keys
	 * @return
	 */
	public static int binarySearch1(int key, int[] keys){
		int mid = 0, l = 0, h = keys.length - 1;
		while(l <= h){
			mid = (l + h) / 2;
			if(key > keys[mid]) {
				l = mid + 1;
			}else if (key < keys[mid]) {
				h = mid - 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * binarySearch：Recursive
	 * 
	 * @param key
	 * @param keys
	 * @return
	 */
	public static int binarySearch2(int key, int[] keys){
		return binarySearch2_1(key, keys, 0, keys.length - 1);
	}
	
	/**
	 * binarySearch：Recursive
	 * 
	 * @param key
	 * @param keys
	 * @return
	 */
	private static int binarySearch2_1(int key, int[] keys, int l, int h){
		if(l > h) return -1;
		int mid = (l + h) / 2;
		if(key > keys[mid]) {
			l = mid + 1;
			return binarySearch2_1(key, keys, l, h);
		}else if (key < keys[mid]) {
			h = mid - 1;
			return binarySearch2_1(key, keys, l, h);
		}else {
			return mid;
		}
	}

}
