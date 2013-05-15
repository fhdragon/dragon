package org.apache.dragon.commons.set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.apache.dragon.commons.set.Arrays.*;

import java.util.Arrays;

/**
 * ArraysTest: test for Arrays
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 1, 2013
 * @since 1.0
 */
public class ArraysTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(ArraysTest.class);

	// Logic
	/**
	 * test {@link Arrays#swap(int[], int, int)}、{@link Arrays#swapS(int[], int, int)}、
	 * {@link Arrays#swapX(int[], int, int)}、{@link Arrays#swap(int[], int, int, int)}、
	 * {@link Arrays#reswap(int[], int, int, int)}
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void swaps() {
		logger.debug("Begin: swaps()...");
		//test swap
		int[] vs = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] rs = {2, 1, 3, 4, 5, 6, 7, 8, 9};
		swap(vs, 0, 1);
		assert Arrays.equals(vs, rs);
		
		//test swapS
		int[] vs1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		swapS(vs1, 0, 1);
		assert Arrays.equals(vs1, rs);
		
		//test swapX
		int[] vs2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		swapX(vs2, 0, 1);
		assert Arrays.equals(vs2, rs);
		
		//test swap n
		int[] vs3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] rs3 = {7, 8, 9, 4, 5, 6, 1, 2, 3};
		swap(vs3, 0, 6, 3);
		assert Arrays.equals(vs3, rs3);
		
		//test reswap
		int[] vs4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] rs4 = {9, 8, 7, 4, 5, 6, 3, 2, 1};
		reswap(vs4, 0, 6, 3);
		assert Arrays.equals(vs4, rs4);
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}

	/**
	 * allocate expensive external resources(like logging into a database) before any of the test methods in the class.
	 */
	@BeforeClass
	public static void init() {
		logger.debug("Begin: init()...");
		logger.debug("End: init()!");
	}

	/**
	 * releases any resource that you allocate expensive external resources in a {@link BeforeClass} method after all
	 * the tests in the this class have been run. this method guaranteed to run.
	 */
	@AfterClass
	public static void destory() {
		logger.debug("Begin: destory()...");
		logger.debug("End: destory()!");
	}

}
