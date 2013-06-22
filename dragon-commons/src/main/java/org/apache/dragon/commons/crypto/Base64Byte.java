package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64 for byte[]
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 31, 2013
 * @since 1.0
 */
public class Base64Byte implements Crypto<byte[]> {

	//Local variables
	
	//Constructor
	public Base64Byte(){
	}

	//Logic
	/** 
	 * encrytor t
	 * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Crypto#encrytor(java.lang.Object)
	  * @see {@link Base64#encodeBase64(byte[])}
	  */
	@Override
	public byte[] encrytor(byte[] t) {
		return Base64.encodeBase64(t);
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
	public byte[] decrytor(byte[] t) {
		return Base64.decodeBase64(t);
	}

}
