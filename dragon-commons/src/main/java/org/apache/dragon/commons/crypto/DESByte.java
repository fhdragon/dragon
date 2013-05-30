package org.apache.dragon.commons.crypto;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * CryptoDES: TODO
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class DESByte implements Crypto<byte[]> {

	//Local variables
	private KeyGenerator keyGenerator;
	private SecretKey secretKey;
	private Cipher cipher;
	
	//Constructor
	@SuppressWarnings("restriction")
	public DESByte(){
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			keyGenerator = KeyGenerator.getInstance("DES");
			secretKey = this.keyGenerator.generateKey();
			cipher = Cipher.getInstance("DES");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//Logic
	/** 
	 * encrytor t
	 * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Crypto#encrytor(java.lang.Object)
	  */
	@Override
	public byte[] encrytor(byte[] t) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
			return cipher.doFinal(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	  * decrytor t
	  * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Crypto#decrytor(java.lang.Object)
	  */
	@Override
	public byte[] decrytor(byte[] t) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
			return cipher.doFinal(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
