package org.apache.dragon.algs;

import java.util.Iterator;

/**
 * 栈集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class LinkedStack<T> implements Stack<T>, Iterable<T> {

	// Local variables
	/**
	 * first node
	 */
	private Node first;
	/**
	 * the number of data
	 */
	private int size;

	// Constructor
	/**
	 * Constructs an empty <code>stack</code> instance with the specified default max capacity.
	 * 
	 * @param max
	 */
	public LinkedStack() {
	}

	// Logic
	/**
	 * push e into bag
	 * 
	 * @param e
	 * @return
	 */
	public void push(T e) {
		Node n = new Node();
		n.t = e;
		n.next = first;
		first = n;
		size++;
	}
	
	/**
	 * pop e from bag
	 * 
	 * @param e
	 * @return
	 */
	public T pop() {
		T result = first.t;
		first = first.next;
		size--;
		return result;
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

	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}
	
	//inner class
	/**
	 * ReverseArrayIterator: 
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Dec 30, 2013
	 * @since 1.0
	 */
	private class ReverseArrayIterator implements Iterator<T> {
		
		//local variables
		private int index = size;
		private Node n = first;

		@Override
		public boolean hasNext() {
			return index > 0;
		}

		@Override
		public T next() {
			T r = n.t;
			n = n.next;
			index--;
			return r;
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
	private class Node {
		//local variables
		T t;
		Node next;
	}

}
