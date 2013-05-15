package org.apache.dragon.commons.set;

import java.util.Iterator;

/**
 * EmptyIterator: empty iterator
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 2, 2013
 * @since 1.0
 */
public final class EmptyIterator<E> implements Iterator<E> {

	// Local variables

	// Logic
	/**
	 * Returns <tt>true</tt> if the iteration has more elements. (In other words, returns <tt>true</tt> if <tt>next</tt>
	 * would return an element rather than throwing an exception.)
	 * 
	 * @return <tt>false</tt> if the iteration has more elements
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return false;
	}

	/**
	 * Returns the next element in the iterator
	 * 
	 * @return the next element in the iteration.
	 * @see java.util.Iterator#next()
	 * @throws UnsupportedOperationException
	 *             if <tt>next</tt> is not supported operation
	 */
	@Override
	public E next() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes from the underlying collection the last element returned by the iterator (optional operation). This
	 * method can be called only once per call to <tt>next</tt>. The behavior of an iterator is unspecified if the
	 * underlying collection is modified while the iteration is in progress in any way other than by calling this
	 * method.
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		// do nothing...
	}

}
