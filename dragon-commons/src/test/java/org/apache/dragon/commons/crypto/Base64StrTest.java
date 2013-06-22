package org.apache.dragon.commons.crypto;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for Base64Str
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 22, 2013
 * @since 1.0
 */
public class Base64StrTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(Base64StrTest.class);

	// Logic
	/**
	 * test {@link SHAStr}
	 */
	@Test
	public void base64() {
		logger.debug("Begin: base64()...");
		//one time test
		String s = "F.H Dragon";
		Crypto<String> c = new Base64Str();
		String r = c.encrytor(s);
		String rr = c.decrytor(r);
		assert s.equals(rr);
		
		String result = "true";
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
