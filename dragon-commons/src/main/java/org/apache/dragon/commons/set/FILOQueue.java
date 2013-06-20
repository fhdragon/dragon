package org.apache.dragon.commons.set;

import java.util.Arrays;

/**
 * An unbounded priority {@linkplain Queue queue} based on a priority heap. The elements of the priority queue are
 * ordered according to their {@linkplain Comparable natural ordering}, or by a {@link Comparator} provided at queue
 * construction time, depending on which constructor is used. A priority queue does not permit {@code null} elements. A
 * priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may
 * result in {@code ClassCastException}).
 * 
 * <p>
 * The <em>head</em> of this queue is the <em>least</em> element with respect to the specified ordering. If multiple
 * elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily. The queue
 * retrieval operations {@code poll}, {@code remove}, {@code peek}, and {@code element} access the element at the head
 * of the queue.
 * 
 * <p>
 * A priority queue is unbounded, but has an internal <i>capacity</i> governing the size of an array used to store the
 * elements on the queue. It is always at least as large as the queue size. As elements are added to a priority queue,
 * its capacity grows automatically. The details of the growth policy are not specified.
 * 
 * <p>
 * This class and its iterator implement all of the <em>optional</em> methods of the {@link Collection} and
 * {@link Iterator} interfaces. The Iterator provided in method {@link #iterator()} is <em>not</em> guaranteed to
 * traverse the elements of the priority queue in any particular order. If you need ordered traversal, consider using
 * {@code Arrays.sort(pq.toArray())}.
 * 
 * <p>
 * <strong>Note that this implementation is not synchronized.</strong> Multiple threads should not access a
 * {@code PriorityQueue} instance concurrently if any of the threads modifies the queue. Instead, use the thread-safe
 * {@link java.util.concurrent.PriorityBlockingQueue} class.
 * 
 * <p>
 * This class is a member of the Java Collections Framework.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/18
 * @since 1.0
 */
public class FILOQueue<T> extends AbstractQueue<T> implements java.io.Serializable {

	// local variables
	/**
	 * uid
	 */
	private static final long serialVersionUID = 7710105636604323922L;
	/**
	 * The number of elements in the queue.
	 */
	private int size = 0;
	/**
	 * The number of times this priority queue has been <i>structurally modified</i>. See AbstractList for gory details.
	 */
	private transient int modCount = 0;
	/**
	 * The array buffer into which the elements of the queue are stored. The capacity of the queue is the length of this
	 * array buffer.
	 */
	private transient Object[] queue;

	// Constructor
	/**
	 * Constructs an empty queue with the specified initial capacity.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the list
	 * @exception IllegalArgumentException
	 *                if the specified initial capacity is negative
	 */
	public FILOQueue(int initCapacity) {
		if (initCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initCapacity);
		this.queue = new Object[initCapacity];
	}

	// Query Operations
	/**
	 * Returns the number of elements in this queue.
	 * 
	 * @return the number of elements in this offset
	 * @see jp.gummy.bsns.ugc.search.util.AbstractQueue#size()
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Remove the element at the front of the queue and return its value.
	 * 
	 * @return value of the element removed from the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	@Override
	public T pop() {
		T result = peek();
		fastRemove(0);
		return result;
	}

	/**
	 * Return the value of the element at the front of the queue.
	 * 
	 * @return value of element at the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		return (T) queue[0];
	}

	// Modification Operations
	/**
	 * Insert e at the back of the queue.
	 * 
	 * @param e
	 *            insert e at the back of the queue
	 * @throws RuntimeException
	 */
	@Override
	public int push(T e) {
		// non-null
		if (e != null) {
			resize(size);
			// store
			this.queue[size] = e;
			modCount++;
			size++;
		}
		return size;
	}

	/**
	 * Increases the capacity of this <tt>queue</tt> instance, if necessary, to ensure that it can hold at least the
	 * number of elements specified by the minimum capacity argument.
	 * 
	 * @param minCapacity
	 *            the desired minimum capacity
	 */
	public void resize(int minCapacity) {
		modCount++;
		int oldCapacity = queue.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			// minCapacity is usually close to size, so this is a win:
			queue = Arrays.copyOf(queue, newCapacity);
		}
	}

	/**
	 * Remove the specified member from this queue, If member was not a member of the set no operation is performed.
	 * 
	 * @param e
	 * @return
	 */
	public int remove(T e) {
		if (e == null) {
			for (int i = 0; i < size; i++)
				if (queue[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (e.equals(queue[i]))
					return i;
		}
		return -1;
	}

	/**
	 * Private remove method that skips bounds checking and does not return the value removed.
	 */
	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(queue, index + 1, queue, index, numMoved);
		queue[--size] = null; // Let gc do its work
	}

}
