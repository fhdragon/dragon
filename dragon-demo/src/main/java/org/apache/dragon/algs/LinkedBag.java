package org.apache.dragon.algs;

import java.util.Iterator;

/**
 * 背包集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class LinkedBag<T> implements Iterable<T> {

	// Local variables
	/**
	 * the head of bag
	 */
	private Node head;
	/**
	 * the max of data
	 */
	private int max;
	/**
	 * the number of data
	 */
	private int size;
	
	// Constructor
	/**
	 * Constructs an empty <code>Bag</code> instance with the specified default max capacity.
	 * 
	 * @param max
	 */
	public LinkedBag() {
		this(Integer.MAX_VALUE);
	}

	/**
	 * Constructs an empty <code>Bag</code> instance with the specified max capacity.
	 * 
	 * @param max
	 *            the max of the age
	 * @exception IllegalArgumentException
	 *                if the specified max capacity is negative
	 */
	public LinkedBag(int max) {
		this.max = max;
	}

	// Logic
	/**
	 * add e into bag
	 * 
	 * @param e
	 * @return
	 */
	public void add(T e) {
		if(size == max){
			throw new RuntimeException("this bag is full.");
		}
		Node n = new Node();
		n.t = e;
		n.next = head;
		head = n;
		size++;
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * 
	 * @return <tt>true</tt> if this list contains no elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * iterator
	 * 
	 * @return
	 */
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	// inner class
	/**
	 * ListIterator:
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Dec 30, 2013
	 * @since 1.0
	 */
	private class ListIterator implements Iterator<T> {

		private Node h = head;

		public boolean hasNext() {
			return h != null;
		}

		public void remove() {
		}

		public T next() {
			T t = h.t;
			h = h.next;
			return t;
		}
	}
	
	/**
	 * Node: 
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Dec 30, 2013
	 * @since 1.0
	 */
	public class Node {
		T t; 
		Node next;
	}

}
