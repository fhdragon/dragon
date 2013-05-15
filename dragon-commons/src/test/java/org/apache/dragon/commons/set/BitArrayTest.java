package org.apache.dragon.commons.set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * BitArrayTest: test for BitArray
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 3, 2013
 * @since 1.0
 */
public class BitArrayTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(BitArrayTest.class);

	// Logic
	/**
	 * test {@link BitArray#set(int, int)}、{@link BitArray#get(int)}
	 */
	@Test
	public void bitArray() {
		logger.debug("Begin: bitArray()...");
		//test set/get/clear
		Bits bs = new BitArray();
		bs.set(' ', 1);
		bs.set('　', 1);
		assert bs.get(' ') == 1;
		assert bs.get('　') == 1;
		assert bs.get(1) == 0;
		bs.clear();
		assert bs.get(' ') == 0;
		assert bs.get('　') == 0;
		assert bs.get(1) == 0;
		
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
