package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Converts hexadecimal Strings. The charset used for certain operation can be set, the default is set in
 * {@link #DEFAULT_CHARSET_NAME}
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at July 27, 2013
 * @since 1.0
 */
public class HexByte implements Crypto<byte[]> {

	//Local variables
	
	//Constructor
	/**
	 * Creates a new <code>HexByte</code> instance. 
	 */
	public HexByte(){
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
		return Hex.encodeHexString(t).getBytes();
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
			return Hex.decodeHex(new String(t).toCharArray());
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
	}

}
