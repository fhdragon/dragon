package org.apache.dragon.commons.crypto;

import static org.apache.commons.codec.binary.Base64.*;

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
	private String slat = Helper.SEED;
	
	//Constructor
	/**
	 * Creates a new <code>SHAStr</code> instance. 
	 */
	public SHAStr(){
		
	}
	/**
	 * Creates a new <code>SHAStr</code> instance with slat. 
	 */
	public SHAStr(String slat){
		this.slat = slat;
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
		return encodeBase64String(this.digest.digest((this.slat + t).getBytes()));
	}

}
