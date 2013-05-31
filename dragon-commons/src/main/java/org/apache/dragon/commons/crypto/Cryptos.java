package org.apache.dragon.commons.crypto;

/**
 * Cryptos: crytor utilities class
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public abstract class Cryptos {

	//Local variables
	/**
	 * des for byte[]
	 */
	public static Crypto<byte[]> DESByte = new DESByte();
	/**
	 * des for string
	 */
	public static Crypto<String> DESStr = new DESStr();
	/**
	 * rsa for byte[]
	 */
	public static Crypto<byte[]> RSAByte = null;//new RSAByte();
	/**
	 * rsa for string
	 */
	public static Crypto<String> RSAStr = new RSAStr();
	/**
	 * AES for byte[]
	 */
	public static Crypto<byte[]> AESByte = new AESByte();
	/**
	 * AES for string
	 */
	public static Crypto<String> AESStr = new AESStr();
	/**
	 * Base64 for byte[]
	 */
	public static Crypto<byte[]> Base64Byte = new Base64Byte();
	/**
	 * Base64 for string
	 */
	public static Crypto<String> Base64Str = new Base64Str();

}
