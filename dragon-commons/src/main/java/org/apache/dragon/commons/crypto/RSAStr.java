package org.apache.dragon.commons.crypto;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * rsa for string
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class RSAStr implements Crypto<String> {

	//Local variables
	private Crypto<byte[]> crypto;
	
	//Constructor
	/**
	 * Creates a new <code>RSAStr</code> instance. 
	 */
	public RSAStr(){
		this.crypto = new RSAByte();
	}
	/**
	 * Creates a new <code>RSAStr</code> instance with private key and public key. 
	 * 
	 * @param priKey
	 * @param pubKey
	 */
	public RSAStr(String priKey, String pubKey){
		try {
			this.crypto = new RSAByte(Hex.decodeHex(priKey.toCharArray()), Hex.decodeHex(pubKey.toCharArray()));
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
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
		return Hex.encodeHexString(this.crypto.encrytor(t.getBytes()));
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
			return new String(this.crypto.decrytor(Hex.decodeHex(t.toCharArray())));
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
	}
	

	/**
	 * private Key
	 * 
	 * @return
	 */
	public String privateKey(){
		return Hex.encodeHexString(((RSAByte)crypto).privateKey());
	}
	
	/**
	 * public Key
	 * 
	 * @return
	 */
	public String publicKey(){
		return Hex.encodeHexString(((RSAByte)crypto).publicKey());
	}

}
