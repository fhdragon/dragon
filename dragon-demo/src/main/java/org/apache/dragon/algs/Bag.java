package org.apache.dragon.algs;

import org.apache.dragon.commons.set.BitArray;
import org.apache.dragon.commons.set.Bits;

/**
 * 背包集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class Bag<T> {

	// Local variables
	/**
	 * store data
	 */
	private Object[] data;
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
	public Bag() {
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
	public Bag(int max) {
		this.max = max;
		this.data = new Object[DEFAULT_INIT_CAPACITY];
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
	 * add e into bag
	 * 
	 * @param e
	 * @return
	 */
	public T get(int i) {
		return (T)this.data[i >= max ? Integer.MAX_VALUE : i];
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

}
