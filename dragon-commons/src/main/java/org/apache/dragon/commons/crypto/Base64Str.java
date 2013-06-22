package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64 for string
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 31, 2013
 * @since 1.0
 */
public class Base64Str implements Crypto<String> {

	//Local variables
	
	//Constructor
	/**
	 * Creates a new <code>Base64Str</code> instance. 
	 */
	public Base64Str(){
		
	}

	//Logic
	/** 
	 * encrytor t
	 * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Crypto#encrytor(java.lang.Object)
	  * @see {@link Base64#encodeBase64String(byte[])}
	  */
	@Override
	public String encrytor(String t) {
		return Base64.encodeBase64String(t.getBytes());
	}

	/** 
	  * decrytor t
	  * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Crypto#decrytor(java.lang.Object)
	  * @see {@link Base64#decodeBase64(byte[])}
	  */
	@Override
	public String decrytor(String t) {
		return new String(Base64.decodeBase64(t));
	}

}
