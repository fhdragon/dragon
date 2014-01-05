package org.apache.dragon.algs;

/**
 * TestSort: test for sort
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 5, 2014
 * @since 1.0
 */
public class TestSort {

	//Local variables

	//Logic
	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ods = {45, 67, 23, 1, 7, 43, 999, 71};
		int[] ds = java.util.Arrays.copyOf(ods, ods.length);
		System.out.println("arrays：" + java.util.Arrays.toString(ds));
		SortSelection.sort(ds);
		System.out.println("selection sort: " + java.util.Arrays.toString(ds));
		ds = java.util.Arrays.copyOf(ods, ods.length);
		System.out.println("arrays：" + java.util.Arrays.toString(ds));
		SortInsertion.sort(ds);
		System.out.println("insertion sort: " + java.util.Arrays.toString(ds));
		ds = java.util.Arrays.copyOf(ods, ods.length);
		System.out.println("arrays：" + java.util.Arrays.toString(ds));
		SortShell.sort(ds);
		System.out.println("shell sort: " + java.util.Arrays.toString(ds));
	}

}
