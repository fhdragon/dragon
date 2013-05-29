package org.apache.dragon.framework.web.http;

import javax.servlet.http.Cookie;

/**
 * decorator pattern: encrypt the value of the cookie
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 27, 2013
 * @since 1.0
 */
public class EnCryptCookie extends Cookie {

	//Local variables
	
	//Constructor
    /**
     * Constructs a crypt-cookie with a specified cookie {@link #Cookie}
     * and the value to be encrypt.
     * 
     * @param cookie 		a <code>String</code> specifying the name of the cookie
     * @param value			a <code>String</code> specifying the value of the cookie, and to be encrypt by default 
     * @see #Cookie
     */
    public EnCryptCookie(Cookie cookie) {
    	super(cookie.getName(), cookie.getValue());
    	//set other properties
    	this.setComment(cookie.getComment());
    	this.setDomain(cookie.getDomain());
    	this.setMaxAge(cookie.getMaxAge());
    	this.setPath(cookie.getPath());
    	this.setSecure(cookie.getSecure());
    }
    
    /**
     * Constructs a crypt-cookie with a specified cookie {@link #Cookie}
     * and the value to be encrypt.
     * 
     * @param cookie 		a <code>String</code> specifying the name of the cookie
     * @param value			a <code>String</code> specifying the value of the cookie, and to be encrypt by default 
     * @see #Cookie
     */
    public EnCryptCookie(String name, String value) {
    	super(name, value);
    }
    

}
