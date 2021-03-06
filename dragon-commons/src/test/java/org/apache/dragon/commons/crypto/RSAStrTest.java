package org.apache.dragon.commons.crypto;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for RSAStr
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 22, 2013
 * @since 1.0
 */
public class RSAStrTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(RSAStrTest.class);

	// Logic
	/**
	 * test {@link RSAStr}
	 */
	@Test
	public void rsa() {
		logger.debug("Begin: rsa()...");
		//one time test
		String s = "F.H Dragon";
		String seed = "";
		Crypto<String> c = new RSAStr();
		logger.debug("public key:" + ((RSAStr)c).publicKey());
		logger.debug("private key:" + ((RSAStr)c).privateKey());
		String r = c.encrytor(s);
		String rr = c.decrytor(r);
		logger.debug("seed = " + seed + ", r = " + r + ", rr = " + rr);
		assert s.equals(rr);
		
		
		//default test
		
		//with p key test
		c = new RSAStr(((RSAStr)c).privateKey(), ((RSAStr)c).publicKey());
		logger.debug("public key:" + ((RSAStr)c).publicKey());
		logger.debug("private key:" + ((RSAStr)c).privateKey());
		r = c.encrytor(s);
		rr = c.decrytor(r);
		logger.debug("seed = " + seed + ", r = " + r + ", rr = " + rr);
		assert s.equals(rr);
		
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
