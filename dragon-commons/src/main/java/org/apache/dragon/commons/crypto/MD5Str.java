package org.apache.dragon.commons.crypto;

import org.apache.dragon.commons.set.Arrays;

/**
 * MD5Str: md5 for string
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class MD5Str implements Digest<String> {

	//Local variables
	private String salt = "dragon";
	
	//Constructor
	/**
	 * Creates a new <code>MD5Str</code> instance. 
	 */
	public MD5Str(){
		
	}
	/**
	 * Creates a new <code>MD5Str</code> instance with salt. 
	 * 
	 * @param salt
	 */
	public MD5Str(String salt){
		this.salt = salt;
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
	public String digest(String t) {
		return Arrays.hex(Digests.MD5Byte.digest((t + salt).getBytes()));
	}

}
