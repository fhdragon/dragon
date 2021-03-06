package org.apache.dragon.commons.io;

import java.io.Serializable;

/**
 * ObjectWrapper: wrap object
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 7, 2013
 * @since 1.0
 */
public class ObjectWrapper implements Serializable {

	//Local variables
	private static final long serialVersionUID = 4051695217550883613L;
	/**
	 * store object
	 */
	private Object obj;
	
	//Constructor
	/**
	 * Creates a new <code>ObjectWrapper</code> instance.
	 */
	public ObjectWrapper(){
		
	}
	/**
	 * Creates a new <code>ObjectWrapper</code> instance. 
	 * 
	 * @param obj
	 */
	public ObjectWrapper(Object obj){
		this.obj = obj;
	}

	//setter and getter
	/**
	 * @return the obj
	 */
	@SuppressWarnings("unchecked")
	public <T> T getObj() {
		return (T)obj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
