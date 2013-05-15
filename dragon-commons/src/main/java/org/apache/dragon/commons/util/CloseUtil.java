package org.apache.dragon.commons.util;

import java.io.Closeable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * CloseUtil: close the closeable object to releases associated resources with it, call these methods in the finnally
 * block. For example:
 * 
 * <pre>
 * 		import static f.h.dragon.commons.util.CloseUtil.*;
 * 
 * 		...
 * 
 * 		Writer w = ...;
 * 		try{
 * 			//to do some things...
 * 		}catch(Exception e){
 * 			//handle exception
 * 		}finally{
 * 			close(w);
 * 		}
 * 
 * 		...
 * </pre>
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Mar 29, 2013
 * @since 1.0
 */
public class CloseUtil {

	// Logic
	/**
	 * Closes c and releases any system resources associated with it. If c is null then invoking this method has no
	 * effect. call it in the finally block
	 * 
	 * @param c
	 *            the Closeable object to close
	 */
	public static void close(Closeable c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (IOException e) {
			e.printStackTrace();// ignore
		}
	}

	/**
	 * close c and releases any system resources associated with it. If c is null then invoking this method has no
	 * effect. call it in the finally block
	 * 
	 * @param c
	 *            the statement to close
	 */
	public static void close(Statement c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();// ignore
		}
	}

	/**
	 * close c and releases any system resources associated with it. If c is null then invoking this method has no
	 * effect. call it in the finally block
	 * 
	 * @param c
	 *            the ResultSet to close
	 */
	public static void close(ResultSet c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();// ignore
		}
	}

}
