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
	 * Converts an array of bytes into a string representing the hex values of each byte in order.
	 * 
	 * @param b
	 * @return
	 * @see {@link Hex#encodeHexString(byte[])}
	 */
	public static String hex(byte[] b){
		return Hex.encodeHexString(b);
	}
	
	/**
	 * Converts a number value into an array of bytes
	 * 
	 * @param n
	 * @return
	 */
	public static byte[] bytes(long n){
		byte[] result = new byte[8];
		for(int i = result.length; i > 0;){
			result[--i] = (byte)(n >> (i * 8));
		}
		return result;
	}
	
	/**
	 * Converts a number value into an array of bytes
	 * 
	 * @param n
	 * @return
	 */
	public static byte[] bytes(int n){
		byte[] result = new byte[4];
		for(int i = result.length; i > 0;){
			result[--i] = (byte)(n >> (i * 8));
		}
		return result;
	}
	
}
