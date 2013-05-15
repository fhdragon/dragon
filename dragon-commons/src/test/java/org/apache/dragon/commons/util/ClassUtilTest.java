package org.apache.dragon.commons.util;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.apache.dragon.commons.util.ClassUtil.*;

/**
 * ClassUtilTest: test for ClassUtil
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 1, 2013
 * @since 1.0
 */
public class ClassUtilTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(ClassUtilTest.class);

	// Logic
	/**
	 * test {@link ClassUtil#getPath(Class)}
	 */
	@Test
	public void getPathTest() {
		logger.debug("Begin: getPathTest()...");
		//"file:/fhdragon/ws/gitws/repositories/fhdragon/commons/commons/target/classes/f/h/dragon/commons/set/Arrays.class";
		String url1 = getPath(org.apache.dragon.commons.set.Arrays.class).toString(); 
		//"jar:file:/Users/wenlongmeng/.m2/repository/log4j/log4j/1.2.16/log4j-1.2.16.jar!/org/apache/log4j/Logger.class";
		String url2 = getPath(org.apache.log4j.Logger.class).toString(); 
		assert url1.startsWith("file:") && url1.endsWith("/org/apache/dragon/commons/set/Arrays.class");
		assert url2.startsWith("jar:file:") && url2.endsWith("/log4j/1.2.16/log4j-1.2.16.jar!/org/apache/log4j/Logger.class");
		
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
