package org.apache.dragon.commons.util;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * UrlUtil: url utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 6, 2013
 * @since 1.0
 */
public final class URLUtil {

	// Logic
	/**
	 * test whether the url is can connection
	 * 
	 * @param url
	 * @return true if the url is can connection false else
	 * 
	 */
	public static boolean valid(String url) {
		// format url
		url = url(url);
		// try connection 3 times
		int conns = 3;
		while (conns-- > 0) {
			try {
				URL _url = new URL(url);
				if (((HttpURLConnection) _url.openConnection()).getResponseCode() == 200) {
					return true;
				}
			} catch (Exception ex) {
			}
		}
		return false;
	}

	/**
	 * format url: if no <tt>http(s):</tt> start, add <tt>http://</tt>
	 * 
	 * @param url
	 * @return if the url is not start with <tt>http(s):</tt>, then add <tt>http://</tt>
	 * 
	 */
	public static String url(String url) {
		// return url.indexOf("://") > 0 ? url : "http://" + url;
		return url.startsWith("http:") || url.startsWith("https:") ? url : "http://" + url;
	}

	/**
	 * format url: 1. add https 2. update http -> https
	 * 
	 * @param url
	 * @return if the url is not start with "http", then add http://
	 * 
	 */
	public static String sslUrl(String url) {
		return url.startsWith("http") ? url.replaceFirst("http:", "https:") : "https://" + url;
	}

}
