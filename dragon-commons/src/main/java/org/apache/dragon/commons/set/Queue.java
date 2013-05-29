package org.apache.dragon.commons.set;

/**
 * A collection designed for holding elements prior to their execution. The
 * collection stores elements with a first-in-first-out (FIFO) order. The
 * interface defines methods for insertion (push), extraction (pop) and
 * inspection (peek).
 * <p>
 * The remove() method removes and returns the element at the front of the stack
 * or throws an exception if the queue is empty. The peek() method returns the
 * value of the element at the front of the queue, but does not remove it.
 * <p>
 * A queue implementation may use a dynamically expanding storage structure that
 * allows for an unlimited number of element or fixed-length ("bounded") queue.
 * 
 * <p>
 * This interface is a member of the Java Collections Framework.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/19
 * @since 1.0
 * @param <E>
 *            the type of elements held in this collection
 * @see java.lang.Iterable
 */
public interface Queue<T> {

	// Query Operations
	/**
	 * Returns the number of elements in this collection. If this collection
	 * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
	 * <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return the number of elements in this collection
	 */
	int size();

	/**
	 * Return a boolean value that indicates whether the queue is empty. Return
	 * true if empty and false if not empty.
	 * 
	 * @return true if the queue is empty and false otherwise.
	 */
	boolean isEmpty();

	/**
	 * Remove the element at the front of the queue and return its value.
	 * 
	 * @return value of the element removed from the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	T pop();

	/**
	 * Return the value of the element at the front of the queue.
	 * 
	 * @return value of element at the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	T peek();

	// Modification Operations
	/**
	 * Insert item at the back of the queue.
	 * 
	 * @param item
	 *            insert item at the back of the queue
	 */
	void offer(T item);

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * The collection will be empty after this method returns.
	 */
	void clear();
	
	/**
	 * Removes all of the elements that non-use
	 */
	void release();

}
