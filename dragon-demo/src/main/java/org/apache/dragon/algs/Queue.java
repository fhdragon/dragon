package org.apache.dragon.algs;

/**
 * 队列集合数据类型实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class Queue<T> {

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
	 * Constructs an empty <code>queue</code> instance with the specified default max capacity.
	 * 
	 * @param max
	 */
	public Queue() {
		this(Integer.MAX_VALUE);
	}

	/**
	 * Constructs an empty <code>queue</code> instance with the specified max capacity.
	 * 
	 * @param max
	 *            the max of the age
	 * @exception IllegalArgumentException
	 *                if the specified max capacity is negative
	 */
	public Queue(int max) {
		this.max = max;
		this.data = new Object[DEFAULT_INIT_CAPACITY];
	}

	// Logic
	/**
	 * push e into queue
	 * 
	 * @param e
	 * @return
	 */
	public void push(T e) {
		resize();
		this.data[size++] = e;
	}
	
	/**
	 * pop e from queue
	 * 
	 * @param e
	 * @return
	 */
	public T pop() {
		if(size > 0){
			@SuppressWarnings("unchecked")
			T e = (T)this.data[0];
			this.data = java.util.Arrays.copyOfRange(this.data, 1, size);
			return e;
		}
		return null;	
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
