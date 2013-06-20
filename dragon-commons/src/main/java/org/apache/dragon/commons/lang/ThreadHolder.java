package org.apache.dragon.commons.lang;

/**
 * Holder class to expose the T in the form of a thread-bound
 * {@link T} object.
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 27, 2013
 * @since 1.0
 */
public class ThreadHolder<T> implements Holder<T>{

	//Local variables
	/**
	 * store t into current thread
	 */
	private final ThreadLocal<T> holder = new ThreadLocal<T>();

	//Logic
	/**
	 * Reset the T for the current thread.
	 */
	@Override
	public void remove() {
		holder.remove();
	}

	/**
	 * Bind the given T to the current thread.
	 * 
	 * @param t the T to expose,
	 * or {@code null} to reset the thread-bound context
	 * @return
	 */
	@Override
	public void set(T t) {
		if (t == null) {
			remove();
		}else {
			holder.set(t);
		}
	}

	/**
	 * Return the T currently bound to the thread.
	 * 
	 * @return the T currently bound to the thread,
	 * or {@code null} if none bound
	 */
	@Override
	public T get() {
		return holder.get();
	}

}
