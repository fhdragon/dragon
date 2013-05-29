package org.apache.dragon.commons.util;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * StringUtilTest: test for StringUtil
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 6, 2013
 * @since 1.0
 */
public class StringUtilTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(StringUtilTest.class);

	// Logic
	/**
	 * test {@link StringUtil#blank(String)}}
	 */
	@Test
	public void blank() {
		logger.debug("Begin: blank()...");
		assert false == StringUtil.blank("http://www.baidu.com");
		assert false == StringUtil.blank(" null ");
		assert true == StringUtil.blank("    ");
		assert true == StringUtil.blank("");
		assert true == StringUtil.blank(null);
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link StringUtil#empty(String)}}
	 */
	@Test
	public void empty() {
		logger.debug("Begin: empty()...");
		assert false == StringUtil.empty("http://www.baidu.com");
		assert false == StringUtil.empty(" null ");
		assert false == StringUtil.empty("    ");
		assert true == StringUtil.empty("");
		assert true == StringUtil.empty(null);
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link StringUtil#num(String)}}
	 */
	@Test
	public void num() {
		logger.debug("Begin: num()...");
		assert -1 == StringUtil.num(" 333 ", -1);
		assert 333 == StringUtil.num("333", -1);
		assert -1 == StringUtil.num("fhdragon", -1);
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link StringUtil#num(String)}}
	 */
	@Test
	public void isNum() {
		logger.debug("Begin: toInt()...");
		assert false == StringUtil.num(" 333 ");
		assert true == StringUtil.num("333");
		assert false == StringUtil.num("fhdragon");
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link StringUtil#equals(String)}}
	 */
	@Test
	public void equals() {
		logger.debug("Begin: equals()...");
		assert false == StringUtil.eq("asd", "sdf");
		assert false == StringUtil.eq("asd", "ASD");
		assert true == StringUtil.eq("asd", "asd");
		assert false == StringUtil.eq("asd", null);
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link StringUtil#equalsIngoreCase(String)}}
	 */
	@Test
	public void equalsIngoreCase() {
		logger.debug("Begin: equalsIngoreCase()...");
		assert false == StringUtil.eqIngoreCase("asd", "sdf");
		assert false == StringUtil.eqIngoreCase("asd", null);
		assert true == StringUtil.eqIngoreCase("asd", "asd");
		assert true == StringUtil.eqIngoreCase("asd", "ASD");
		
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
