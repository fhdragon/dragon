package org.apache.dragon.commons.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * AES for byte[]
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 31, 2013
 * @since 1.0
 */
public class AESByte implements Crypto<byte[]> {

	//Local variables
	private SecretKey secretKey;
	private Cipher cipher;
	/**
	 * algorithm
	 */
	private static final String ALGORITHM = "AES";
	
	//Constructor
	/**
	 * Creates a new <code>AESByte</code> instance. 
	 */
	public AESByte(){
		this(null);
	}
	/**
	 * Creates a new <code>AESByte</code> instance with seed. 
	 */
	public AESByte(String seed){
		this.secretKey = Helper.generateKey(ALGORITHM, seed);
		this.cipher = Helper.cipher(ALGORITHM);
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
