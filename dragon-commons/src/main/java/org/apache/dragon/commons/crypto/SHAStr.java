package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.binary.Hex;
import org.apache.dragon.commons.lang.StringPool;

/**
 * :SHA for string
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class SHAStr implements Digest<String> {

	//Local variables
	private Digest<byte[]> digest = new SHAByte();
	private String seed = StringPool.BLANK;
	
	//Constructor
	/**
	 * Creates a new <code>SHAStr</code> instance. 
	 */
	public SHAStr(){
		
	}
	/**
	 * Creates a new <code>SHAStr</code> instance with seed. 
	 */
	public SHAStr(String seed){
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
		return Hex.encodeHexString(this.digest.digest((this.seed + t).getBytes()));
	}

}
