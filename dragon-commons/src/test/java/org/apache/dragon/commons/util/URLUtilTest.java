package org.apache.dragon.commons.util;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * URLUtilTest: test for URLUtil
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 3, 2013
 * @since 1.0
 */
public class URLUtilTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(URLUtilTest.class);

	// Logic
	/**
	 * test {@link URLUtil#valid(String)}}
	 */
	@Test
	public void valid() {
		logger.debug("Begin: valid()...");
		//test url
		assert true == URLUtil.valid("http://www.baidu.com");
		assert true == URLUtil.valid("google.com");
//		assert false == URLUtil.valid("baisssssdu.co1111m");
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link URLUtil#sslUrl(String)}}
	 */
	@Test
	public void sslUrl() {
		logger.debug("Begin: sslUrl()...");
		//test url
		assert "https://google.com".equals(URLUtil.sslUrl("google.com"));
		assert "https://google.com".equals(URLUtil.sslUrl("https://google.com"));
		assert "https://google.com".equals(URLUtil.sslUrl("http://google.com"));
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link URLUtil#url(String)}}
	 */
	@Test
	public void url() {
		logger.debug("Begin: url()...");
		//test url
		assert "http://google.com".equals(URLUtil.url("google.com"));
		assert "https://google.com".equals(URLUtil.url("https://google.com"));
		assert "http://google.com".equals(URLUtil.url("http://google.com"));
		
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
