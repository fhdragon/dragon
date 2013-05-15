package org.apache.dragon.commons.set;

import java.util.ListIterator;

/**
 * EmptyListIterator: empty list iterator
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 3, 2013
 * @since 1.0
 */
public final class EmptyListIterator<E> implements ListIterator<E> {

	// Local variables

	// Logic
	/**
	 * Returns <tt>true</tt> if this list iterator has more elements when traversing the list in the forward direction.
	 * (In other words, returns <tt>true</tt> if <tt>next</tt> would return an element rather than throwing an
	 * exception.)
	 * 
	 * @return <tt>true</tt> if the list iterator has more elements when traversing the list in the forward direction.
	 * @see java.util.ListIterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return false;
	}

	/**
	 * Returns the next element in the list. This method may be called repeatedly to iterate through the list, or
	 * intermixed with calls to <tt>previous</tt> to go back and forth. (Note that alternating calls to <tt>next</tt>
	 * and <tt>previous</tt> will return the same element repeatedly.)
	 * 
	 * @return the next element in the list.
	 * @exception UnsupportedOperationException
	 *                if the <tt>next</tt> operation is not supported by this list iterator
	 * @see java.util.ListIterator#next()
	 */
	@Override
	public E next() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes from the list the last element that was returned by <tt>next</tt> or <tt>previous</tt> (optional
	 * operation). This call can only be made once per call to <tt>next</tt> or <tt>previous</tt>. It can be made only
	 * if <tt>ListIterator.add</tt> has not been called after the last call to <tt>next</tt> or <tt>previous</tt>.
	 * 
	 * @exception UnsupportedOperationException
	 *                if the <tt>remove</tt> operation is not supported by this list iterator.
	 * @see java.util.ListIterator#remove()
	 */
	@Override
	public void remove() {
		// do nothing...
	}

	/**
	 * Returns <tt>true</tt> if this list iterator has more elements when traversing the list in the reverse direction.
	 * (In other words, returns <tt>true</tt> if <tt>previous</tt> would return an element rather than throwing an
	 * exception.)
	 * 
	 * @return <tt>true</tt> if the list iterator has more elements when traversing the list in the reverse direction.
	 * @see java.util.ListIterator#hasPrevious()
	 */
	@Override
	public boolean hasPrevious() {
		return false;
	}

	/**
	 * Returns the previous element in the list. This method may be called repeatedly to iterate through the list
	 * backwards, or intermixed with calls to <tt>next</tt> to go back and forth. (Note that alternating calls to
	 * <tt>next</tt> and <tt>previous</tt> will return the same element repeatedly.)
	 * 
	 * @return the previous element in the list.
	 * @see java.util.ListIterator#previous()
	 * @throws UnsupportedOperationException
	 *             if the <tt>previous</tt> is not supported by this list iterator
	 */
	@Override
	public E previous() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the index of the element that would be returned by a subsequent call to <tt>next</tt>. (Returns list size
	 * if the list iterator is at the end of the list.)
	 * 
	 * @return the index of the element that would be returned by a subsequent call to <tt>next</tt>, or list size if
	 *         list iterator is at end of list.
	 * @see java.util.ListIterator#nextIndex()
	 * @throws UnsupportedOperationException
	 *             if the <tt>nextIndex</tt> operation is not supported by this list iterator
	 */
	@Override
	public int nextIndex() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the index of the element that would be returned by a subsequent call to <tt>previous</tt>. (Returns -1 if
	 * the list iterator is at the beginning of the list.)
	 * 
	 * @return the index of the element that would be returned by a subsequent call to <tt>previous</tt>, or -1 if list
	 *         iterator is at beginning of list.
	 * @see java.util.ListIterator#previousIndex()
	 * @throws UnsupportedOperationException
	 *             if the <tt>previousIndex</tt> is not supported by this list iterator
	 */
	@Override
	public int previousIndex() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Replaces the last element returned by <tt>next</tt> or <tt>previous</tt> with the specified element (optional
	 * operation). This call can be made only if neither <tt>ListIterator.remove</tt> nor <tt>ListIterator.add</tt> have
	 * been called after the last call to <tt>next</tt> or <tt>previous</tt>.
	 * 
	 * @param e
	 *            the element with which to replace the last element returned by <tt>next</tt> or <tt>previous</tt>.
	 * @exception UnsupportedOperationException
	 *                if the <tt>set</tt> operation is not supported by this list iterator.
	 * @see java.util.ListIterator#set(java.lang.Object)
	 */
	@Override
	public void set(E e) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Inserts the specified element into the list (optional operation). The element is inserted immediately before the
	 * next element that would be returned by <tt>next</tt>, if any, and after the next element that would be returned
	 * by <tt>previous</tt>, if any. (If the list contains no elements, the new element becomes the sole element on the
	 * list.) The new element is inserted before the implicit cursor: a subsequent call to <tt>next</tt> would be
	 * unaffected, and a subsequent call to <tt>previous</tt> would return the new element. (This call increases by one
	 * the value that would be returned by a call to <tt>nextIndex</tt> or <tt>previousIndex</tt>.)
	 * 
	 * @param e
	 *            the element to insert.
	 * @exception UnsupportedOperationException
	 *                if the <tt>add</tt> method is not supported by this list iterator.
	 * 
	 * @exception ClassCastException
	 *                if the class of the specified element prevents it from being added to this list.
	 * 
	 * @exception IllegalArgumentException
	 *                if some aspect of this element prevents it from being added to this list.
	 * @see java.util.ListIterator#add(java.lang.Object)
	 */
	@Override
	public void add(E e) {
		throw new UnsupportedOperationException();
	}

}
