package org.apache.dragon.commons.parser;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for ExcelParser
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 9, 2013
 * @since 1.0
 */
public class ExcelParserTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(ExcelParserTest.class);

	// Logic
	/**
	 * test {@link ExcelParser#getValue(int, int, int)}
	 */
	@Test
	public void getValue() {
		logger.debug("Begin: read()...");
		//TODO add test
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
