package org.apache.dragon.framework.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.dragon.commons.lang.StringPool.*;

import static org.apache.dragon.commons.util.StringUtil.*;

/**
 * CookieUtil is the class for all cookie-related operations.
 * <p>
 * In this implementation, only one cookie is set for all data. This is to reduce issues with servlet containers that
 * cannot handle more than one cookie to be set at once.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 26, 2013
 * @since 1.0
 */
public class CookieUtil {

	// Local variables
	/**
	 * Maximum life time of a permanent cookie(in seconds). -1 : cookies auto-expire
	 */
	private static final int COOKIE_MAX_AGE = -1;//60 * 60 * 24 * 365;
	/**
	 * "/": will be returned to all pages
	 */
	private static final String COOKIE_PATH = FORWARD_SLASH;

	// Constructor
	/**
	 * Creates a new <code>CookieUtil</code> instance. Private constructor to stop anyone from instantiating this class
	 * - the static methods should be used explicitly.
	 */
	private CookieUtil() {
		//this class contains only static methods
	}

	// Logic
	/**
	 * Stores a value in a cookie for res. 
	 * 
	 * @param res 
	 * @param name name of the cookie to store
	 * @param value value of the cookie to store
	 * @param domain domain of the cookie to store
	 * @param path path of the cookie to store
	 * @param maxAge max age of the cookie to store
	 */
	private static final void add(HttpServletResponse res, String name, String value, String domain, int maxAge, String path) {
		//create cookie
		Cookie cookie = new Cookie(name, value);
		if(maxAge > -1){
			cookie.setMaxAge(maxAge);
		}
		if(!blank(domain)){
			cookie.setDomain(domain);
		}
		if(!blank(path)){
			cookie.setPath(path);
		}
		//build cookie
		add(res, cookie);
	}
	
	/**
	 * Stores a cookie for res. 
	 * 
	 * @param res 
	 * @param cookie the cookie to store
	 */
	private static final void add(HttpServletResponse res, Cookie cookie) {
		//build cookie
		res.addCookie(cookie);
	}
	
	/**
	 * Stores a value in a cookie for current response. 
	 * 
	 * @param name name of the cookie to store
	 * @param value value of the cookie to store
	 * @param domain domain of the cookie to store
	 * @param path path of the cookie to store
	 * @param maxAge max age of the cookie to store
	 */
	public static final void add(String name, String value, String domain, int maxAge, String path) {
		//check require
		if(blank(name) || blank(value)){
			return;
		}
		//if domain is null, set default domain
		if(blank(domain)){
			HttpServletRequest req = WebContextUtils.getReq();
			domain = req.getServerName();
		}
		//if path is null, set default path
		if(blank(path)){
			path = COOKIE_PATH;
		}
		HttpServletResponse res = WebContextUtils.getRes();
		add(res, name, value, domain, maxAge, path);
	}
	
	/**
	 * Stores a value in a cookie for current request. 
	 * 
	 * @param name name of the cookie to store
	 * @param value value of the cookie to store
	 */
	public static final void add(String name, String value) {
		add(name, value, null, COOKIE_MAX_AGE, null);
	}
	
	/**
	 * Returns the value of the cookie associated with the name for current request.
	 * 
	 * @param prefix the name of the cookies start with the specified prefix 
	 * @return a <code>List<Cookie></code> that every Cookie 's name start with the specified prefix
	 */
	public static Map<String, String> gets(String prefix) {
		HttpServletRequest req = WebContextUtils.getReq();
		return gets(req, prefix);
	}
	
	/**
	 * Returns the value of the cookie associated with the name for current request.
	 * 
	 * @param req
	 * @param name
	 * @return a <code>String</code> containing the cookie's present value
	 * 
	 * @see #set
	 * @see Cookie
	 */
	public static String get(String name) {
		HttpServletRequest req = WebContextUtils.getReq();
		return get(req, name);
	}
	
	/**
	 * Returns the value of the cookie associated with the name for req.
	 * 
	 * @param req
	 * @param name
	 * @return a <code>String</code> containing the cookie's present value
	 * 
	 * @see #set
	 * @see Cookie
	 */
	private static String get(HttpServletRequest req, String name) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (eq(cookie.getName(), name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the value of the cookie associated with the name for req.
	 * 
	 * @param req
	 * @param prefix the name of the cookies start with the specified prefix 
	 * @return a <code>List<Cookie></code> that every Cookie 's name start with the specified prefix
	 */
	private static Map<String, String> gets(HttpServletRequest req, String prefix) {
		Cookie[] cookies = req.getCookies();
		Map<String, String> result = new HashMap<String, String>();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().startsWith(prefix)) {
					result.put(cookie.getName(), cookie.getValue());
				}
			}
		}
		return result;
	}
	
	/**
	 * remove the cookie associated with the name.
	 * 
	 * @param name the name of the cookies 
	 * @return a <code>List<Cookie></code> that every Cookie 's name the specified
	 */
	public static void remove(String name) {
		HttpServletResponse res = WebContextUtils.getRes();
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		res.addCookie(cookie);
	}

}
