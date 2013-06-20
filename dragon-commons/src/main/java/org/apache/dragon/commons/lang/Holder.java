package org.apache.dragon.commons.lang;

/**
 * Holder: the holder interface
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 27, 2013
 * @since 1.0
 */
public interface Holder<T> {

	//Logic
		/**
		 * Reset the T for the current thread.
		 */
		public void remove();

		/**
		 * Bind the given T to the current thread.
		 * @param req the T to expose,
		 * or {@code null} to reset the thread-bound context
		 * @return
		 */
		public void set(T t);

		/**
		 * Return the T currently bound to the thread.
		 * @return the T currently bound to the thread,
		 * or {@code null} if none bound
		 */
		public T get();

}
