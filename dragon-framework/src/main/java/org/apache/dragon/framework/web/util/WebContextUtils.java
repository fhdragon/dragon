package org.apache.dragon.framework.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dragon.framework.web.http.RequestHolder;
import org.apache.dragon.framework.web.http.ResponseHolder;

/**
 * AppContextUtils: application context utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 1, 2013
 * @since 1.0
 */
public class WebContextUtils {

	//Local variables
	
	//Logic
	/**
	 * return the current request from current thread
	 * 
	 * @return the current request from current thread
	 */
	public static HttpServletRequest getReq(){
		return RequestHolder.get();
	}
	
	/**
	 * return the current response from current thread
	 * 
	 * @return the current response from current thread
	 */
	public static HttpServletResponse getRes(){
		return ResponseHolder.get();
	}
	

}
