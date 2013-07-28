package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.binary.Hex;

import static org.apache.dragon.commons.lang.StringPool.BLANK;;

/**
 * md5 for string
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class MD5Str implements Digest<String> {

	//Local variables
	private String seed = BLANK;
	private Digest<byte[]> digest = new MD5Byte();
	
	//Constructor
	/**
	 * Creates a new <code>MD5Str</code> instance with default salt. 
	 */
	public MD5Str(){
		
	}
	/**
	 * Creates a new <code>MD5Str</code> instance with seed. 
	 * 
	 * @param seed
	 */
	public MD5Str(String seed){
		if(seed != null){
			this.seed = seed;
		}
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
		return Hex.encodeHexString(this.digest.digest((t + seed).getBytes()));
	}

}
