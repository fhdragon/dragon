package org.apache.dragon.algs;

/**
 * Stopwatch:
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class Stopwatch {

	//Local variables
	/**
	 * start time
	 */
	private long st;

	//Constructor
	/**
	 * Creates a new <code>Stopwatch</code> instance with specified st(now()). 
	 */
	public Stopwatch(){
		this.st = System.currentTimeMillis();
	}
	
	//Logic
	/**
	 * cost millis second
	 * 
	 * @return
	 */
	public long cost(){
		return System.currentTimeMillis() - st;
	}

}
