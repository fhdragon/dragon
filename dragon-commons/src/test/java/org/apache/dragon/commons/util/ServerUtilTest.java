package org.apache.dragon.commons.util;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * ServerUtilTest: test for ServerUtil
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 6, 2013
 * @since 1.0
 */
public class ServerUtilTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(ServerUtilTest.class);

	// Logic
	/**
	 * test {@link ServerUtil#ip(String)}}
	 */
	@Test
	public void ip() {
		logger.debug("Begin: ip()...");
		//test url
		assert ServerUtil.ip("127.0.0.1");
		assert !ServerUtil.ip("127.0.0.");
		assert !ServerUtil.ip(".sdfsfdf.sdf");
		assert ServerUtil.ip(ServerUtil.ip());//Mac/Windows is ok
		logger.debug("ip : " + ServerUtil.ip());
		
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
