package org.apache.dragon.commons.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * EmptySet: empty set
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 2, 2013
 * @since 1.0
 */
public final class EmptySet<E> implements Set<E> {

	// Local variables

	// Logic
	/**
	 * Returns the number of elements in this set (its cardinality).  If this
     * set contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return 0
	 * @see java.util.Set#size()
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * Returns <tt>true</tt> if this set contains no elements.
	 * 
	 * @return true
	 * @see java.util.Set#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}

	/** 
	  * Returns <tt>true</tt> if this set contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this set
     * contains an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	  * 
	  * @return false
	  * @see java.util.Set#contains(java.lang.Object)
	  */
	@Override
	public boolean contains(Object o) {
		return false;
	}

	/** 
	  * Returns an iterator over the elements in this set.  The elements are
     * returned in no particular order (unless this set is an instance of some
     * class that provides a guarantee).
	  * 
	  * @return an empty iterator
	  * @see java.util.Set#iterator()
	  */
	@Override
	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}

	/** 
	  * Returns an array containing all of the elements in this set.
     * If this set makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the
     * elements in the same order.
     *
     * <p>The returned array will be "safe" in that no references to it
     * are maintained by this set.  (In other words, this method must
     * allocate a new array even if this set is backed by an array).
     * The caller is thus free to modify the returned array.
     * 
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
	  * 
	  * @return an empty array
	  * @see java.util.Set#toArray()
	  */
	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	/** 
	 * Returns an array containing all of the elements in this set; the
     * runtime type of the returned array is that of the specified array.
     * If the set fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this set.
     *
     * <p>If this set fits in the specified array with room to spare
     * (i.e., the array has more elements than this set), the element in
     * the array immediately following the end of the set is set to
     * <tt>null</tt>.  (This is useful in determining the length of this
     * set <i>only</i> if the caller knows that this set does not contain
     * any null elements.)
     *
     * <p>If this set makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements
     * in the same order.
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose <tt>x</tt> is a set known to contain only strings.
     * The following code can be used to dump the set into a newly allocated
     * array of <tt>String</tt>:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
	  * 
	  * @return an array containing all the elements in this set
	  * @see java.util.Set#toArray(T[])
	  */
	@Override
	public <T> T[] toArray(T[] a) { 
		return a;
	}

	/** 
	  * Adds the specified element to this set if it is not already present
     * (optional operation).  More formally, adds the specified element
     * <tt>e</tt> to this set if the set contains no element <tt>e2</tt>
     * such that
     * <tt>(e==null&nbsp;?&nbsp;e2==null&nbsp;:&nbsp;e.equals(e2))</tt>.
     * If this set already contains the element, the call leaves the set
     * unchanged and returns <tt>false</tt>.  In combination with the
     * restriction on constructors, this ensures that sets never contain
     * duplicate elements.
     *
     * <p>The stipulation above does not imply that sets must accept all
     * elements; sets may refuse to add any particular element, including
     * <tt>null</tt>, and throw an exception, as described in the
     * specification for {@link Collection#add Collection.add}.
     * Individual set implementations should clearly document any
     * restrictions on the elements that they may contain.
	  * 
	  * @param e elment to be added to this set
	  * @return <tt>true</tt> if this set did not already contain the specified
     *         element
	  * @see java.util.Set#add(java.lang.Object)
	  * @throws UnsupportedOperationException
	  */
	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	/** 
	  * Removes the specified element from this set if it is present
     * (optional operation).  More formally, removes an element <tt>e</tt>
     * such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>, if
     * this set contains such an element.  Returns <tt>true</tt> if this set
     * contained the element (or equivalently, if this set changed as a
     * result of the call).  (This set will not contain the element once the
     * call returns.)
	  * 
	  * @param o object to be removed from this set, if present
	  * @return <tt>true</tt> if this set contained the specified element
	  * @see java.util.Set#remove(java.lang.Object)
	  * @throws UnsupportedOperationException
	  */
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	/** 
	  * Returns <tt>true</tt> if this set contains all of the elements of the
     * specified collection.  If the specified collection is also a set, this
     * method returns <tt>true</tt> if it is a <i>subset</i> of this set.
	  * 
	  * @param c collection to be checked for containment in this set
	  * @return false
	  * @see java.util.Set#containsAll(java.util.Collection)
	  */
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	/** 
	  * Adds all of the elements in the specified collection to this set if
     * they're not already present (optional operation).  If the specified
     * collection is also a set, the <tt>addAll</tt> operation effectively
     * modifies this set so that its value is the <i>union</i> of the two
     * sets.  The behavior of this operation is undefined if the specified
     * collection is modified while the operation is in progress.
	  * 
	  * @param c collection containing elements to be added to be this set
	  * @return <tt>true</tt> if this set changed as a result of the call
	  * @see java.util.Set#addAll(java.util.Collection)
	  * @throws UnsupportedOperationException if the <tt>addAll</tt> operation is not supported by this set
	  */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/** 
	  * Retains only the elements in this set that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this set all of its elements that are not contained in the
     * specified collection.  If the specified collection is also a set, this
     * operation effectively modifies this set so that its value is the
     * <i>intersection</i> of the two sets.
	  * 
	  * @param c collection containing elements to be retained in this set
	  * @return <tt>true</tt> if this set changed as a result of the call
	  * @see java.util.Set#retainAll(java.util.Collection)
	  * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation is not supported by this set
	  */
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	/** 
	  * Removes from this set all of its elements that are contained in the
     * specified collection (optional operation).  If the specified
     * collection is also a set, this operation effectively modifies this
     * set so that its value is the <i>asymmetric set difference</i> of
     * the two sets.
	  * 
	  * @param c collection containing elements removed from this set
	  * @return true if this set changed as a result of the call
	  * @see java.util.Set#removeAll(java.util.Collection)
	  * @throws UnsupportedOperationException if the <tt>removeAll</tt> operation is not supported by this set
	  */
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	/** 
	  * Removes all of the elements from this set (optional operation).
     * The set will be empty after this call returns.
	  * 
	  * @see java.util.Set#clear()
	  */
	@Override
	public void clear() {
		//do nothing
	}

}
