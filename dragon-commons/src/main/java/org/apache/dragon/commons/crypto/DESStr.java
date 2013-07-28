package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * encrytor/decrytor by ByteDES
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class DESStr implements Crypto<String> {

	// Local variables
	/**
	 * byte DES
	 */
	private Crypto<byte[]> crypto;
	
	//Constructor
		/**
		 * Creates a new <code>DESStr</code> instance. 
		 */
		public DESStr(){
			this(null);
		}
		/**
		 * Creates a new <code>DESStr</code> instance with seed. 
		 * 
		 * @param seed
		 */
		public DESStr(String seed){
			this.crypto = new DESByte(seed);
		}

	// Logic
	/**
	 * encrytor t
	 * 
	 * @param t
	 * @return
	 * @see org.apache.dragon.commons.crypto.Crypto#encrytor(java.lang.Object)
	 */
	@Override
	public String encrytor(String t) {
		return Hex.encodeHexString(this.crypto.encrytor(t.getBytes()));
	}

	/**
	 * decrytor t
	 * 
	 * @param t
	 * @return
	 * @see org.apache.dragon.commons.crypto.Crypto#decrytor(java.lang.Object)
	 * @see #byteDES
	 * @see Arrays#hex(String)
	 */
	@Override
	public String decrytor(String t) {
		try {
			return new String(this.crypto.decrytor(Hex.decodeHex(t.toCharArray())));
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
	}

}
