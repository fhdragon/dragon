package org.apache.dragon.algs;

import java.util.Iterator;

/**
 * 队列集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class LinkedQueue<T> implements Queue<T>, Iterable<T> {

	// Local variables
	/**
	 * head of queue
	 */
	private Node head;
	/**
	 * tail of queue
	 */
	private Node tail;
	/**
	 * the number of data
	 */
	private int size;

	// Constructor
	/**
	 * Constructs an empty <code>queue</code> instance with the specified default max capacity.
	 * 
	 * @param max
	 */
	public LinkedQueue() {
		
	}

	// Logic
	/**
	 * push e into queue
	 * 
	 * @param e
	 * @return
	 */
	public void push(T e) {
		Node lastTail =  tail;
		tail = new Node();
		tail.t = e;
		if(isEmpty()){
			head = tail;
		}else{
			lastTail.next = tail;
		}
		size++;
	}
	
	/**
	 * pop e from queue
	 * 
	 * @param e
	 * @return
	 */
	public T pop() {
		T t = head.t;
		head = head.next;
		if(isEmpty()){
			tail = null;
		}
		size--;
		return t;	
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
	  * @see java.lang.Iterable#iterator()
	  */
	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}
	
	//inner class
	private class ReverseArrayIterator implements Iterator<T> {
		
		//local variables
		private Node h = head;

		@Override
		public boolean hasNext() {
			return h != null;
		}

		@Override
		public T next() {
			T t = h.t;
			h = h.next;
			return t;
		}

		@Override
		public void remove() {
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
		//local variables
		T t;
		Node next;
	}

}
