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
	 * Return a boolean value that indicates whether the queue is empty. Return
	 * true if empty and false if not empty.
	 * 
	 * @return true if the queue is empty and false otherwise.
	 */
	@Override
	public boolean empty() {
		return size() == 0;
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * The collection will be empty after this method returns.
	 */
	@Override
	public void clear() {
		while (!empty())
			pop();
	}

}
