package org.apache.dragon.commons.util;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * FileUtilTest: test for FileUtil
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 9, 2013
 * @since 1.0
 */
public class FileUtilTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(FileUtilTest.class);

	// Logic
	/**
	 * test {@link FileUtil#read(String)}
	 */
	@Test
	public void read() {
		logger.debug("Begin: read()...");
		assert !StringUtil.empty(FileUtil.read("pom.xml"));
		
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
