package org.apache.dragon.commons.crypto;

import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.dragon.commons.io.DefaultSerialize;
import org.apache.dragon.commons.io.Serialize;

/**
 * rsa for byte[]
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class RSAByte implements Crypto<byte[]> {

	//Local variables
	private PublicKey pubKey;
	private PrivateKey priKey;
	private Cipher cipher;
	private Serialize s = new DefaultSerialize();
	/**
	 * algorithm
	 */
	private static final String ALGORITHM = "RSA";
	
	//Constructor
	/**
	 * Creates a new <code>RSAByte</code> instance. 
	 */
	public RSAByte(){
		java.security.KeyPair kp = Helper.generateKeyPair(ALGORITHM);
		this.priKey = kp.getPrivate();
		this.pubKey = kp.getPublic();
		this.cipher = Helper.cipher(ALGORITHM);
	}
	/**
	 * Creates a new <code>RSAByte</code> instance with public key and private key. 
	 * 
	 * @param priKey
	 * @param pubKey
	 */
	public RSAByte(byte[] priKey, byte[] pubKey){
		if(priKey != null){
			this.priKey = s.read(priKey);
		}
		if(pubKey != null){
			this.pubKey = s.read(pubKey);
		}
		this.cipher = Helper.cipher(ALGORITHM);
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
		try {
			cipher.init(Cipher.ENCRYPT_MODE, this.pubKey);
			return cipher.doFinal(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
			cipher.init(Cipher.DECRYPT_MODE, this.priKey);
			return cipher.doFinal(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * private Key
	 * 
	 * @return
	 */
	public byte[] privateKey(){
		return s.write(this.priKey);
	}
	
	/**
	 * public Key
	 * 
	 * @return
	 */
	public byte[] publicKey(){
		return s.write(this.pubKey);
	}

}
