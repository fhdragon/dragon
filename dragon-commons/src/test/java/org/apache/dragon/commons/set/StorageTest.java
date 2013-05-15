package org.apache.dragon.commons.set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * StorageTest: test for Storage
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 7, 2013
 * @since 1.0
 */
public class StorageTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(StorageTest.class);

	// Logic
	/**
	 * test {@link Storage#get(Object)},{@link Storage#put(Object, Object)}, {@link Storage#containsKey(Object)}
	 */
	@Test
	public void storage() {
		logger.debug("Begin: storage()...");
		Storage s = Storage.malloc("default");
		s.put(1, 11);
		s.put("1", "22");
		Integer i11 = s.get(1);
		String s22 = s.get("1");
		assert i11 == 11;
		assert "22".equals(s22);
		assert s.containsKey(1);
		assert s.containsKey("1");
		assert !s.containsKey("22");
		
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
