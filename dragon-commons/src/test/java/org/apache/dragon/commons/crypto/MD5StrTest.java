package org.apache.dragon.commons.crypto;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for MD5Str
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 22, 2013
 * @since 1.0
 */
public class MD5StrTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(MD5StrTest.class);

	// Logic
	/**
	 * test {@link MD5Str}
	 */
	@Test
	public void md5() {
		logger.debug("Begin: md5()...");
		//one time test
		String s = "F.H Dragon";
		Digest<String> d = new MD5Str();
		String result = d.digest(s);
		logger.debug("seed is null, result = " + result);
		String seed = "dragon";
		d = new MD5Str(seed);
		result = d.digest(s);
		logger.debug("seed is " + seed + ", result = " + result);
		logger.debug("End!");
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
