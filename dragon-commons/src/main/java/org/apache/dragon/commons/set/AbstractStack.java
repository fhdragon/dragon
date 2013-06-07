package org.apache.dragon.commons.set;

/**
 * This class provides skeletal implementations of some {@link Stack} operations. The implementations in this class are
 * appropriate when the base implementation does <em>not</em> allow <tt>null</tt> elements. Methods {@link #add put},
 * respectively but throw exceptions instead of indicating failure via <tt>false</tt> or <tt>null</tt> returns.
 * 
 * <p>
 * A <tt>Stack</tt> implementation that extends this class must minimally define a method {@link Stack#push} which does
 * not permit insertion of <tt>null</tt> elements, {@link Queue#size}. Typically, additional methods will be overridden
 * as well.
 * 
 * <p>
 * This class is a member of the Java Collections Framework.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/18
 * @since 1.0
 */
public abstract class AbstractStack<E> implements Stack<E> {

	// Constructor
	/**
	 * Constructor for use by subclasses.
	 */
	protected AbstractStack() {
	}

	// Query Operations
	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * 
	 * @return <tt>true</tt> if this collection contains no elements
	 */
	@Override
	public boolean empty() {
		return size() == 0;
	}

	// Modification Operations
	/**
	 * Removes all of the elements from this collection (optional operation). The collection will be empty after this
	 * method returns.
	 */
	@Override
	public void clear() {
		while (pop() != null)
			;
	}

}
