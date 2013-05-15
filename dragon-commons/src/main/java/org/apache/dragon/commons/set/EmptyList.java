package org.apache.dragon.commons.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * EmptySet: empty set
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 2, 2013
 * @since 1.0
 */
public final class EmptyList<E> implements List<E> {

	// Local variables

	// Logic
	/**
	 * Returns the number of elements in this list. If this list contains more than <tt>Integer.MAX_VALUE</tt> elements,
	 * returns <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return 0
	 * @see java.util.Set#size()
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * 
	 * @return true
	 * @see java.util.Set#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element. More formally, returns <tt>true</tt> if and
	 * only if this list contains at least one element <tt>e</tt> such that
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
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return
	 * @see java.util.Set#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
	 * 
	 * <p>
	 * The returned array will be "safe" in that no references to it are maintained by this list. (In other words, this
	 * method must allocate a new array even if this list is backed by an array). The caller is thus free to modify the
	 * returned array.
	 * 
	 * <p>
	 * This method acts as bridge between array-based and collection-based APIs.
	 * 
	 * @return
	 * @see java.util.Set#toArray()
	 */
	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element); the
	 * runtime type of the returned array is that of the specified array. If the list fits in the specified array, it is
	 * returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size
	 * of this list.
	 * 
	 * <p>
	 * If the list fits in the specified array with room to spare (i.e., the array has more elements than the list), the
	 * element in the array immediately following the end of the list is set to <tt>null</tt>. (This is useful in
	 * determining the length of the list <i>only</i> if the caller knows that the list does not contain any null
	 * elements.)
	 * 
	 * <p>
	 * Like the {@link #toArray()} method, this method acts as bridge between array-based and collection-based APIs.
	 * Further, this method allows precise control over the runtime type of the output array, and may, under certain
	 * circumstances, be used to save allocation costs.
	 * 
	 * <p>
	 * Suppose <tt>x</tt> is a list known to contain only strings. The following code can be used to dump the list into
	 * a newly allocated array of <tt>String</tt>:
	 * 
	 * <pre>
	 * 
	 * String[] y = x.toArray(new String[0]);
	 * </pre>
	 * 
	 * Note that <tt>toArray(new Object[0])</tt> is identical in function to <tt>toArray()</tt>.
	 * 
	 * @return
	 * @see java.util.Set#toArray(T[])
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return a;
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * 
	 * <p>
	 * Lists that support this operation may place limitations on what elements may be added to this list. In
	 * particular, some lists will refuse to add null elements, and others will impose restrictions on the type of
	 * elements that may be added. List classes should clearly specify in their documentation any restrictions on what
	 * elements may be added.
	 * 
	 * @see java.util.Set#add(java.lang.Object)
	 * @throws UnsupportedOperationException if <tt>add</tt> operation is not supported by this list
	 */
	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it is present (optional operation). If
	 * this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index
	 * <tt>i</tt> such that <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt> (if such an element
	 * exists). Returns <tt>true</tt> if this list contained the specified element (or equivalently, if this list
	 * changed as a result of the call).
	 * 
	 * @see java.util.Set#remove(java.lang.Object)
	 * @throws UnsupportedOperationException if <tt>remove</tt> operation is not supported by this list
	 */
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * 
	 * @return false
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are
	 * returned by the specified collection's iterator (optional operation). The behavior of this operation is undefined
	 * if the specified collection is modified while the operation is in progress. (Note that this will occur if the
	 * specified collection is this list, and it's nonempty.)
	 * 
	 * @see java.util.Set#addAll(java.util.Collection)
	 * @throws UnsupportedOperationException if <tt>addAll</tt> operation is not supported by this list
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retains only the elements in this list that are contained in the specified collection (optional operation). In
	 * other words, removes from this list all the elements that are not contained in the specified collection.
	 * 
	 * @see java.util.Set#retainAll(java.util.Collection)
	 * @throws UnsupportedOperationException if <tt>retainAll</tt> operation is not supported by this list
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes from this list all of its elements that are contained in the specified collection (optional operation).
	 * 
	 * @see java.util.Set#removeAll(java.util.Collection)
	 * @throws UnsupportedOperationException if <tt>removeAll</tt> operation is not supported by this list
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes all of the elements from this list (optional operation). The list will be empty after this call returns.
	 * 
	 * @see java.util.Set#clear()
	 */
	@Override
	public void clear() {
		// do nothing
	}

	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are
	 * returned by the specified collection's iterator (optional operation). The behavior of this operation is undefined
	 * if the specified collection is modified while the operation is in progress. (Note that this will occur if the
	 * specified collection is this list, and it's nonempty.)
	 * 
	 * @see java.util.List#addAll(int, java.util.Collection)
	 * @throws UnsupportedOperationException if <tt>addAll</tt> operation is not supported by this list
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @return
	 * @see java.util.List#get(int)
	 * @throws UnsupportedOperationException if <tt>get</tt> operation is not supported by this list
	 */
	@Override
	public E get(int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element (optional operation).
	 * 
	 * @see java.util.List#set(int, java.lang.Object)
	 * @throws UnsupportedOperationException if <tt>set</tt> operation is not supported by this list
	 */
	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation). Shifts the element
	 * currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * 
	 * @see java.util.List#add(int, java.lang.Object)
	 * @throws UnsupportedOperationException if <tt>add</tt> operation is not supported by this list
	 */
	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it is present (optional operation). If
	 * this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index
	 * <tt>i</tt> such that <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt> (if such an element
	 * exists). Returns <tt>true</tt> if this list contained the specified element (or equivalently, if this list
	 * changed as a result of the call).
	 * 
	 * @see java.util.List#remove(int)
	 * @throws UnsupportedOperationException if <tt>remove</tt> operation is not supported by this list
	 */
	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not
	 * contain the element. More formally, returns the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>, or -1 if there is no such index.
	 * 
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o) {
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not
	 * contain the element. More formally, returns the highest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>, or -1 if there is no such index.
	 * 
	 * @return -1
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	@Override
	public int lastIndexOf(Object o) {
		return -1;
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 * 
	 * @see java.util.List#listIterator()
	 */
	@Override
	public ListIterator<E> listIterator() {
		return new EmptyListIterator<E>();
	}

	/**
	 * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in
	 * this list. The specified index indicates the first element that would be returned by an initial call to
	 * {@link ListIterator#next next}. An initial call to {@link ListIterator#previous previous} would return the
	 * element with the specified index minus one.
	 * 
	 * @see java.util.List#listIterator(int)
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return new EmptyListIterator<E>();
	}

	/**
	 * Returns a view of the portion of this list between the specified <tt>fromIndex</tt>, inclusive, and
	 * <tt>toIndex</tt>, exclusive. (If <tt>fromIndex</tt> and <tt>toIndex</tt> are equal, the returned list is empty.)
	 * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this
	 * list, and vice-versa. The returned list supports all of the optional list operations supported by this list.
	 * <p>
	 * 
	 * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays). Any
	 * operation that expects a list can be used as a range operation by passing a subList view instead of a whole list.
	 * For example, the following idiom removes a range of elements from a list:
	 * 
	 * <pre>
	 * list.subList(from, to).clear();
	 * </pre>
	 * 
	 * Similar idioms may be constructed for <tt>indexOf</tt> and <tt>lastIndexOf</tt>, and all of the algorithms in the
	 * <tt>Collections</tt> class can be applied to a subList.
	 * <p>
	 * 
	 * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is
	 * <i>structurally modified</i> in any way other than via the returned list. (Structural modifications are those
	 * that change the size of this list, or otherwise perturb it in such a fashion that iterations in progress may
	 * yield incorrect results.)
	 * 
	 * @return this empty list
	 * @see java.util.List#subList(int, int)
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return this;
	}

}
