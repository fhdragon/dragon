package org.apache.dragon.commons.set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

/**
 * EmptyIteratorTest: test for EmptyIterator
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 2, 2013
 * @since 1.0
 */
public class EmptyIteratorTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(EmptyIteratorTest.class);

	// Logic
	/**
	 * test {@link EmptyIterator#hasNext()}
	 */
	@Test
	public void hasNext() {
		logger.debug("Begin: hasNext()...");
		Iterator<Object> itr = new EmptyIterator<Object>();
		assert itr.hasNext() == false;
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptyIterator#remove()}
	 */
	@Test
	public void remove() {
		logger.debug("Begin: remove()...");
		Iterator<Object> itr = new EmptyIterator<Object>();
		itr.remove();
		
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test {@link EmptyIterator#next()}
	 */
	@Test
	public void next() {
		logger.debug("Begin: next()...");
		Iterator<Object> itr = new EmptyIterator<Object>();
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
