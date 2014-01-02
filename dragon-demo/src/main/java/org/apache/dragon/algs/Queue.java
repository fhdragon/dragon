package org.apache.dragon.algs;

/**
 * 队列集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public interface Queue<T> {

	// Local variables

	// Logic
	/**
	 * push e into queue
	 * 
	 * @param e
	 * @return
	 */
	public void push(T e);
	
	/**
	 * pop e from queue
	 * 
	 * @param e
	 * @return
	 */
	public T pop();

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size();

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * 
	 * @return <tt>true</tt> if this list contains no elements
	 */
	public boolean isEmpty();

}
