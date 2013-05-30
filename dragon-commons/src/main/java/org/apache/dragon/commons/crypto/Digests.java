package org.apache.dragon.commons.crypto;

/**
 * Digests: digest message utilities class
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public abstract class Digests {

	//Local variables
	/**
	 * digest for byte[]
	 */
	public static Digest<byte[]> MD5Byte = new MD5Byte();
	/**
	 * digest for string
	 */
	public static Digest<String> MD5Str = new MD5Str();
	/**
	 * digest for byte[]
	 */
	public static Digest<byte[]> SHAByte = new SHAByte();
	/**
	 * digest for byte[]
	 */
	public static Digest<String> SHAStr = new SHAStr();
	

}
