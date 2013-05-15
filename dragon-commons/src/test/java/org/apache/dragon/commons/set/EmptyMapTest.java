package org.apache.dragon.commons.set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

/**
 * EmptyMapTest: test for EmptyMap
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 3, 2013
 * @since 1.0
 */
public class EmptyMapTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(EmptyMapTest.class);

	// Logic
	/**
	 * test {@link EmptyMap#isEmpty()}
	 */
	@Test
	public void isEmpty() {
		logger.debug("Begin: isEmpty()...");
		Map<Object, Object> set = new EmptyMap<Object, Object>();
		assert set.isEmpty() == true;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptyMap#containsKey()}
	 */
	@Test
	public void containsKey() {
		logger.debug("Begin: containsKey()...");
		Map<Object, Object> set = new EmptyMap<Object, Object>();
		assert set.containsKey(1) == false;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptyMap#size()}
	 */
	@Test
	public void size() {
		logger.debug("Begin: size()...");
		Map<Object, Object> set = new EmptyMap<Object, Object>();
		assert set.size() == 0;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptyMapt#get()}
	 */
	@Test
	public void get() {
		logger.debug("Begin: get()...");
		Object o = new EmptyMap<Object, Object>().get(1);
		assert o == null;
		
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
