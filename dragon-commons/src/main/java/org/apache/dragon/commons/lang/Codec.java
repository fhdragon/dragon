package org.apache.dragon.commons.lang;

/**
 * encode and decode interface
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2012/04/27
 * @since 1.0
 */
public interface Codec<T> {

	// Logic
	/**
	 * encode the specified t
	 * 
	 * @param t
	 *            The t to be filtered
	 * @return null - if t is null
	 * @throws NullPointerException
	 *             - if t is null
	 */
	T encode(T t);

	/**
	 * decode the specified t
	 * 
	 * @param t
	 * @throws NullPointerException
	 *             if t is null
	 */
	T decode(T t);

}
