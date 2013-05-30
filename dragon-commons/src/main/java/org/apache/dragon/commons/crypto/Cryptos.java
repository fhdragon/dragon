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

}
