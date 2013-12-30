package org.apache.dragon.algs;

import java.util.Random;

/**
 * Arrays: array utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 28, 2013
 * @since 1.0
 */
public class Arrays {

	//Local variables
	
	//Logic
	/**
	 * find max from a
	 * 
	 * @param a
	 * @return
	 */
	public static int max(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length; i++){
			if(a[i] > max){
				max = a[i];
			}
		}
		return max;
	}
	
	/**
	 * compute the average of the array a
	 * 
	 * @param a
	 * @return
	 */
	public static int average(int[] a) {
		int sum = a[0];
		for(int i = 1; i < a.length; i++){
			sum += a[i];
		}
		return sum / a.length;
	}
	
	/**
	 * copy array a to a new array and return new array
	 * 
	 * @param a
	 * @return
	 */
	public static int[] copy(int[] a) {
		int[] result = new int[a.length];
		for(int i = 0; i < a.length; i++){
			result[i] = a[i];
		}
		return result;
	}
	
	/**
	 * copy array a to a new array by system and return new array
	 * 
	 * @param a
	 * @return
	 */
	public static int[] copy1(int[] a) {
		int[] result = new int[a.length];
		System.arraycopy(a, 0, result, 0, a.length);
		return result;
	}
	
	/**
	 * copy array a to a new array by Arrays and return new array
	 * 
	 * @param a
	 * @return
	 */
	public static int[] copy2(int[] a) {
		return java.util.Arrays.copyOf(a, a.length);
	}
	
	/**
	 * reverse elements in array a
	 * 
	 * @param a
	 * @return
	 */
	public static void reverse(int[] a) {
		for(int i = 0, counti = a.length; i <= counti / 2; i++){
			a[i] = a[counti - i - 1];
		}
	}
	
	/**
	 * Matrix multiply
	 * 
	 * @param a
	 * @return
	 */
	public static int[][] multiply(int[][] a) {
		int n = a.length;
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					result[i][j] += a[i][k] * a[k][j];
				}
			}
		}
		return result;
	}
	
	/**
	 * shuffle array
	 * 
	 * @param a
	 * @return
	 */
	private static Random r;
	public static void shuffle(int[] a) {
		if(r == null){
			r = new Random();
		}
		int i = a.length;
		while(i-- > 1){
			int j = r.nextInt(i);
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
	}
	
	/**
	 * swap array by ox
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * @return
	 */
	public static void swapOX(int[] a, int i, int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	
	/**
	 * swap array by sum: XXX overflow
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * @return
	 */
	public static void swapSum(int[] a, int i, int j) {
		a[i] += a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}
	
	/**
	 * swap array by variable
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * @return
	 */
	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
