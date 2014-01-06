package org.apache.dragon.demo;

import org.apache.dragon.demo.service.SequenceServiceTest;
import org.apache.log4j.Logger;

/**
 * test for sequence
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Feb 23, 2014
 * @since 1.0
 */
public class Tester {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(SequenceServiceTest.class);

	//Logic
	/**
	 * test generator next id
	 */
	public static void main(String[] args){
		logger.debug("Begin: next()...");
		System.out.println("?sourceid=school&amp;amp;cid=1".replaceAll("amp;", ""));
		long result = 0, st = System.currentTimeMillis();
		System.out.println("Cost: " + (System.currentTimeMillis() - st));
		logger.debug("End: " + result);
	}

}
