package org.apache.dragon.commons.set;

/**
 * This class provides skeletal implementations of some {@link Queue}
 * operations. The implementations in this class are appropriate when the base
 * implementation does <em>not</em> allow <tt>null</tt> elements. Methods
 * {@link #add put}, respectively but throw exceptions instead of indicating
 * failure via <tt>false</tt> or <tt>null</tt> returns.
 * 
 * <p>
 * A <tt>Queue</tt> implementation that extends this class must minimally define
 * a method {@link Queue#put} which does not permit insertion of <tt>null</tt>
 * elements, {@link Queue#size}. Typically, additional methods will be
 * overridden as well.
 * 
 * <p>
 * This class is a member of the Java Collections Framework.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/18
 * @since 1.0
 */
public abstract class AbstractQueue<T> implements Queue<T> {

	// Constructor
	/**
	 * Constructor for use by subclasses.
	 */
	protected AbstractQueue() {
	}

	// Query Operations
	/**
	 * Returns the number of elements in this collection. If this collection
	 * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
	 * <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return the number of elements in this collection
	 */
	@Override
	public abstract int size();

	/**
	 * Return a boolean value that indicates whether the queue is empty. Return
	 * true if empty and false if not empty.
	 * 
	 * @return true if the queue is empty and false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Remove the element at the front of the queue and return its value.
	 * 
	 * @return value of the element removed from the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	@Override
	public abstract T pop();

	/**
	 * Return the value of the element at the front of the queue.
	 * 
	 * @return value of element at the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	@Override
	public abstract T peek();

	// Modification Operations
	/**
	 * Insert item at the back of the queue.
	 * 
	 * @param item
	 *            insert item at the back of the queue
	 */
	@Override
	public abstract void offer(T item);

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * The collection will be empty after this method returns.
	 */
	@Override
	public void clear() {
		while (!isEmpty())
			pop();
	}
	
	/**
	 * Removes all of the elements that non-use
	 */
	@Override
	public abstract void release();

}
