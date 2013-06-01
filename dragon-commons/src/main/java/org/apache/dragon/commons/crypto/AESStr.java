package org.apache.dragon.commons.crypto;

import org.apache.dragon.commons.set.Arrays;

/**
 * RSAByte: rsa for string
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class AESStr implements Crypto<String> {

	//Local variables
	
	//Constructor
	/**
	 * Creates a new <code>RSAStr</code> instance. 
	 */
	public AESStr(){
		
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
	public String encrytor(String t) {
		return Arrays.hex(Cryptos.AESByte.encrytor(t.getBytes()));
	}

	/** 
	  * decrytor t
	  * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Crypto#decrytor(java.lang.Object)
	  */
	@Override
	public String decrytor(String t) {
		return Arrays.hex(Cryptos.AESByte.decrytor(t.getBytes()));
	}

}
