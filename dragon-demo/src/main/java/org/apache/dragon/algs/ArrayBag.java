package org.apache.dragon.algs;

import java.util.Iterator;

/**
 * 背包集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class ArrayBag<T> implements Bag<T> {

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
	 * Constructs an empty <code>Bag</code> instance with the specified default max capacity.
	 * 
	 * @param max
	 */
	public ArrayBag() {
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
	@SuppressWarnings("unchecked")
	public ArrayBag(int max) {
		this.max = max;
		this.data = (T[])new Object[DEFAULT_INIT_CAPACITY];
	}

	// Logic
	/**
	 * add e into bag
	 * 
	 * @param e
	 * @return
	 */
	public void add(T e) {
		resize();
		this.data[size++] = e;
	}
	
	 /**
     * Increases the capacity of this <tt>Bag</tt> instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the (size * 2 / max) capacity.
     */
	private void resize(){
		if(size == this.max){
			// minCapacity is usually close to size, so this is a win:
            data = java.util.Arrays.copyOf(data, size * 2 > max ? max : size * 2);
		}
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
		return new ListIterator();
	}
	
	//inner class 
	/**
	 * ListIterator: 
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Dec 30, 2013
	 * @since 1.0
	 */
	public class ListIterator implements Iterator<T> {
		
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
		public void remove() {}
		
	}

}
