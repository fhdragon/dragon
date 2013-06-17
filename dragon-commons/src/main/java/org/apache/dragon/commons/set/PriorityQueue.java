package org.apache.dragon.commons.set;

import java.util.Comparator;

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
public class PriorityQueue<T> extends AbstractQueue<T> implements java.io.Serializable {

	// local variables
	/**
	 * uid
	 */
	private static final long serialVersionUID = 7710105636604323922L;
	/**
	 * The number of elements in the priority queue.
	 */
	private int size = 0;
	/**
	 * offset of this queue
	 */
	private int offset = 0;
	/**
	 * the number of elements in this queue
	 */
	private int limit = Integer.MAX_VALUE;
	/**
	 * the number of elements that pushed in this queue
	 */
	private int maxLimit = Integer.MAX_VALUE;
	/**
	 * The number of times this priority queue has been <i>structurally modified</i>. See AbstractList for gory details.
	 */
	private transient int modCount = 0;
	/**
	 * The index of element of this priority queue
	 */
	private transient int index = 0;
	/**
	 * The comparator, or null if priority queue uses elements' natural ordering.
	 */
	private Comparator<T> comparator;
	/**
	 * true - already call release method, then call the offer method throw Exception
	 */
	private boolean release;
	/**
	 * Priority queue represented as a balanced binary heap: the two children of queue[n] are queue[2*n+1] and
	 * queue[2*(n+1)]. The priority queue is ordered by comparator, or by the elements' natural ordering, if comparator
	 * is null: For each node n in the heap and each descendant d of n, n <= d. The element with the lowest value is in
	 * queue[0], assuming the queue is nonempty.
	 */
	private transient Object[] queue;

	// Constructor
	/**
	 * Creates a {@code PriorityQueue} with the specified initial capacity that orders its elements according to their
	 * {@linkplain Comparable natural ordering}.
	 * 
	 * @param offset
	 *            the initial offset for this priority queue
	 * @param limit
	 *            the number of elements in this queue
	 * @throws IllegalArgumentException
	 *             if {@code initialCapacity} is less than 1
	 */
	public PriorityQueue(int offset, int limit) {
		this(offset, limit, Integer.MAX_VALUE);
	}
	/**
	 * Creates a {@code PriorityQueue} with the specified initial capacity that orders its elements according to their
	 * {@linkplain Comparable natural ordering}.
	 * 
	 * @param offset
	 *            the initial offset for this priority queue
	 * @param limit
	 *            the number of elements in this queue
	 * @param maxLimit
	 *            the max number of elements that offer
	 * @throws IllegalArgumentException
	 *             if {@code initialCapacity} is less than 1
	 */
	public PriorityQueue(int offset, int limit, int maxLimit) {
		if (maxLimit < 0)
			throw new IllegalArgumentException("Illegal maxLimit: " + maxLimit);
		if (offset < 0)
			throw new IllegalArgumentException("Illegal offset: " + offset);
		if (limit < 1)
			throw new IllegalArgumentException("Illegal limit: " + limit);
		this.maxLimit = maxLimit;
		this.offset = offset;
		this.limit = limit;
		this.queue = new Object[offset + limit];
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
	 * @param comparator
	 *            the comparator to set
	 */
	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Remove the element at the front of the queue and return its value.
	 * 
	 * @return value of the element removed from the front of the queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	@Override
	public T pop() {
		return null;
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
		check();
		//non-null
		if (e != null) {
			// store
			this.queue[index] = e;
			this.maxLimit--;
			modCount++;
			index++;
			// sort
			sort();
		}
		return 1;
	}

	/**
	 * check release
	 */
	private void check() {
		if(this.modCount == -1){
			throw new RuntimeException("already call release() method");
		}
		if(this.maxLimit < 0){
			throw new RuntimeException("too many elements");
		}
	}

	/**
	 * sort FIXME -O
	 * 
	 * @param index
	 */
	private void sort() {
		if (comparator != null) {
			// Arrays.sort(this.queue, 0, reIndex() + 1, comparator);
		} else {
			// Arrays.sort(this.queue, 0, reIndex() + 1);
		}
	}

}
