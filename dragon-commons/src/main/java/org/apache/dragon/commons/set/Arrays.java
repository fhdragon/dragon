package org.apache.dragon.commons.set;

import org.apache.commons.codec.binary.Hex;

/**
 * Arrays: array utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 1, 2013
 * @since 1.0
 */
public class Arrays {

	//Logic
	/**
	 * Swaps x[a] with x[b]: x ^ y ^ x = y
	 * 
	 * @param x
	 * @param a
	 * @param b
	 */
	public static void swapX(int x[], int a, int b) {
		x[a] ^= x[b];
		x[b] ^= x[a];
		x[a] ^= x[b];
	}
	
	/**
	 * Swaps x[a] with x[b]
	 * 
	 * @param x
	 * @param a
	 * @param b
	 */
	public static void swap(int x[], int a, int b) {
		int t = x[a];
		x[a] = x[b];
		x[b] = t;
	}
	
	/**
	 * Swaps x[a] with x[b]：x + y - y = x, may be overflow(x + y > Integer.MAX_VALUE)
	 * 
	 * @param x
	 * @param a
	 * @param b
	 * 
	 * @deprecated see {@link #swap(int[], int, int)}
	 */
	public static void swapS(int x[], int a, int b) {
		x[a] += x[b];//may be overflow
		x[b] = x[a] - x[b];
		x[a] = x[a] - x[b];
	}

	/**
	 * Swaps x[a .. (a+n-1)] with x[b .. (b+n-1)].
	 * 
	 * @param x
	 * @param a
	 * @param b
	 * @param n
	 */
	public static void swap(int x[], int a, int b, int n) {
		for (int i = 0; i < n; i++, a++, b++){
			swap(x, a, b);
		}
	}
	
	/**
	 * reswaps x[(a+n-1) .. a] with x[(b+n-1) .. b].
	 * 
	 * @param x
	 * @param a
	 * @param b
	 * @param n
	 */
	public static void reswap(int x[], int a, int b, int n) {
		b += n - 1;
		for (int i = 0; i < n; i++, a++, b--){
			swap(x, a, b);
		}
	}
	
	/**
	 * toHex
	 * 
	 * @param s
	 * @return
	 */
	public static String toHex(byte[] s){
		return Hex.encodeHexString(s);
	}
	
}
