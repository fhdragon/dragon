package org.apache.dragon.commons.cache;

/**
 * <code>CacheException</code> is exception that can be thrown during the normal operation of cache.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Sep 12, 2013
 * @since 1.0
 */
public class CacheException extends RuntimeException {

	private static final long serialVersionUID = -193202262468464650L;

	//Constructor
	/**
	 * Creates a new <code>CacheException</code> instance without a detail message.
	 */
	public CacheException() {
		super();
	}

	/**
	 * Creates a new <code>CacheException</code> instance with a detail message. 
	 * 
	 * @param message
	 */
	public CacheException(String message) {
		super(message);
	}

	/**
	 * Creates a new <code>CacheException</code> instance with a detail message and an exception. 
	 * 
	 * @param message
	 * @param cause
	 */
	public CacheException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new <code>CacheException</code> instance with an throwable. 
	 * 
	 * @param cause
	 */
	public CacheException(Throwable cause) {
		super(cause);
	}

}
