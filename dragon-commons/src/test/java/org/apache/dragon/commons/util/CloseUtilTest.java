package org.apache.dragon.commons.util;

import static org.apache.dragon.commons.util.CloseUtil.*;

import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * CloseUtilTest: test for CloseUtil
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Mar 27, 2013
 * @since 1.0
 */
public class CloseUtilTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(CloseUtilTest.class);

	// Logic
	/**
	 * test {@link CloseUtil#close(java.io.Closeable)}、{@link CloseUtil#close(java.sql.ResultSet)}、{@link CloseUtil#close(java.sql.Statement)}
	 */
	@Test
	public void closeTest() {
		logger.debug("Begin: closeTest()...");
		//close ResultSet
		ResultSet rs = null;
		try{
			logger.debug("test for close result set...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			logger.debug("closing result set ...");
			close(rs);
		}
		
		//close Statement
		Statement s = null;
		try{
			logger.debug("test for close statement...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			logger.debug("closing statement...");
			close(s);
		}
		
		//close closeable
		StringReader c = new StringReader("Wenlong Meng(wenlong.meng@gmail.com)");
		try{
			logger.debug("before close : " + c.read());
			close(c);
//			logger.debug("after close : " + c.read());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			logger.debug("closing closeable...");
			close(c);
		}

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
