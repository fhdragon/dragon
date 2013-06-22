package org.apache.dragon.commons.crypto;

import java.security.MessageDigest;

/**
 * md5 for byte[]
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class MD5Byte implements Digest<byte[]> {

	//Local variables
	/**
	 * algorithm
	 */
	private static final String ALGORITHM = "MD5";
	
	//Constructor
	/**
	 * Creates a new <code>MD5Byte</code> instance. 
	 */
	public MD5Byte(){
		
	}

	//Logic
	/** 
	 * digest t
	 * 
	  * @param t
	  * @return
	  * @see org.apache.dragon.commons.crypto.Digest#digest(java.lang.Object)
	  */
	@Override
	public byte[] digest(byte[] t) {
		try {
			return MessageDigest.getInstance(ALGORITHM).digest(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
