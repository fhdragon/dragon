package org.apache.dragon.commons.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Helper:
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 21, 2013
 * @since 1.0
 */
public class Helper {

	// local variables

	// Logic
	/**
	 * generate Key with algorithm and seed
	 * 
	 * @param algorithm
	 * @param seed
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static SecretKey generateKey(String algorithm, String seed) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
			SecureRandom secureRandom = null;
			if(seed == null){
				secureRandom = new SecureRandom();
			}else{
				secureRandom = new SecureRandom(seed.getBytes());
			}
			keyGenerator.init(secureRandom);
			return keyGenerator.generateKey();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * generate KeyPair with algorithm and seed
	 * 
	 * @param algorithm
	 * @param seed
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static KeyPair generateKeyPair(String algorithm) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(algorithm);
			// keyGenerator.initialize(1024, new SecureRandom(seed));
			return keyGenerator.generateKeyPair();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * cipher instance
	 * 
	 * @param algorithm
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static Cipher cipher(String algorithm) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			return Cipher.getInstance(algorithm);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
