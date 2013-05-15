package org.apache.dragon.commons.set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * EmptySetTest: test for EmptySet
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 2, 2013
 * @since 1.0
 */
public class EmptySetTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(EmptySetTest.class);

	// Logic
	/**
	 * test {@link EmptySet#isEmpty()}
	 */
	@Test
	public void isEmpty() {
		logger.debug("Begin: isEmpty()...");
		Set<Object> set = new EmptySet<Object>();
		assert set.isEmpty() == true;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptySet#contains()}
	 */
	@Test
	public void contains() {
		logger.debug("Begin: contains()...");
		Set<Object> set = new EmptySet<Object>();
		assert set.contains(1) == false;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptySet#size()}
	 */
	@Test
	public void size() {
		logger.debug("Begin: size()...");
		Set<Object> set = new EmptySet<Object>();
		assert set.size() == 0;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptySet#next()}
	 */
	@Test
	public void next() {
		logger.debug("Begin: next()...");
		Iterator<Object> itr = new EmptySet<Object>().iterator();
		boolean result = false;
		try{
			itr.next();
		}catch(UnsupportedOperationException e){
			result = true;
			logger.debug("End: result = " + result);
		}
		assert result;
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
