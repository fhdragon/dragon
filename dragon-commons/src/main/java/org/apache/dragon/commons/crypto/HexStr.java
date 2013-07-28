package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Converts hexadecimal Strings. The charset used for certain operation can be set, the default is set in
 * {@link #DEFAULT_CHARSET_NAME}
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jul 27, 2013
 * @since 1.0
 */
public class HexStr implements Crypto<String> {

	//Local variables
	
	//Constructor
	/**
	 * Creates a new <code>HexStr</code> instance. 
	 */
	public HexStr(){
		
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
			return Hex.encodeHexString(t.getBytes());
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
			try {
				return new String(Hex.decodeHex(t.toCharArray()));
			} catch (DecoderException e) {
				throw new RuntimeException(e);
			}
		}

}
