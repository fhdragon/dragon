package org.apache.dragon.commons.crypto;

/**
 * Digest: TODO
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public interface Digest<T> {

	/**
	 * digest
	 * 
	 * @param t
	 * @return
	 */
	T digest(T t);
	
}
