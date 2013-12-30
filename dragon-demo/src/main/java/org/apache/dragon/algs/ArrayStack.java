package org.apache.dragon.algs;

import java.util.Iterator;

/**
 * 栈集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class ArrayStack<T> implements Stack<T>, Iterable<T> {

	// Local variables
	/**
	 * store data
	 */
	private T[] data;
	/**
	 * the max of data
	 */
	private int max;
	/**
	 * the number of data
	 */
	private int size;
	/**
	 * the default init capacity
	 */
	private static final int DEFAULT_INIT_CAPACITY = 16;

	// Constructor
	/**
	 * Constructs an empty <code>stack</code> instance with the specified default max capacity.
	 * 
	 * @param max
	 */
	public ArrayStack() {
		this(Integer.MAX_VALUE);
	}

	/**
	 * Constructs an empty <code>stack</code> instance with the specified max capacity.
	 * 
	 * @param max
	 *            the max of the stack
	 * @exception IllegalArgumentException
	 *                if the specified max capacity is negative
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int max) {
		this.max = max;
		this.data = (T[])new Object[DEFAULT_INIT_CAPACITY];
	}

	// Logic
	/**
	 * push e into bag
	 * 
	 * @param e
	 * @return
	 */
	public void push(T e) {
		if(size == data.length){
			resize(size * 2 > max ? max : size * 2);
		}
		this.data[size++] = e;
	}
	
	/**
	 * pop e from bag
	 * 
	 * @param e
	 * @return
	 */
	public T pop() {
		T e = this.data[--size];
		this.data[size] = null;
		if(size == data.length / 4){
			resize(data.length / 2);
		}
		return e;
	}
	
	 /**
     * Increases the capacity of this <tt>ArrayStack</tt> instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the (size * 2 / max) capacity.
     */
	private void resize(int newSize){
		T[] newData = (T[])new Object[newSize];
		for(int i = 0, maxi = (newSize > size ? size : newSize); i < maxi; i++){
			newData[i] = data[i];
		}
		data = newData;
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
	private class ReverseArrayIterator implements Iterator<T> {
		
		//local variables
		private int index = size;

		@Override
		public boolean hasNext() {
			return index > 0;
		}

		@Override
		public T next() {
			return data[--index];
		}

		@Override
		public void remove() {
		}
		
	}

}
