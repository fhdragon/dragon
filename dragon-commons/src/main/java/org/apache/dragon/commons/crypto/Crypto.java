package org.apache.dragon.commons.crypto;

/**
 * Crypto: TODO
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public interface Crypto<T> {
	
	//Logic
	/**
	 * encrytor
	 * 
	 * @param t
	 * @return
	 */
	T encrytor(T t);
	
	/**
	 * decrytor
	 * 
	 * @param t
	 * @return
	 */
	T decrytor(T t);

}
