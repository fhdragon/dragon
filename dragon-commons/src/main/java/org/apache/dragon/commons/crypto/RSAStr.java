package org.apache.dragon.commons.crypto;

import static org.apache.commons.codec.binary.Base64.*;

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
	/**
	 * default crypto
	 */
	public static final Crypto<String> DEFAULT = new RSAStr(Helper.PRI_KEY, Helper.PUB_KEY);
	
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
		this.crypto = new RSAByte(decodeBase64(priKey), decodeBase64(pubKey));
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
		return encodeBase64String(this.crypto.encrytor(t.getBytes()));
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
		return new String(this.crypto.decrytor(decodeBase64(t)));
	}
	

	/**
	 * private Key
	 * 
	 * @return
	 */
	public String privateKey(){
		return encodeBase64String(((RSAByte)crypto).privateKey());
	}
	
	/**
	 * public Key
	 * 
	 * @return
	 */
	public String publicKey(){
		return encodeBase64String(((RSAByte)crypto).publicKey());
	}

}
