package org.apache.dragon.commons.util;

/**
 * Fast String Utilities. Operations on {@link java.lang.String} that are
 * {@code null} safe.
 * 
 * These string utilities provide both conveniance methods and performance improvements over most standard library
 * versions. The main aim of the optimizations is to avoid object creation unless absolutely required.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Feb 7, 2012
 * @since 1.0
 */
public final class StringUtil {
	
	//Logic
	/**
	 * Returns an <code>int</code> value holding the value of the specified <code>String</code>. The argument is
	 * interpreted as representing a signed decimal integer, exactly as if the argument were given to the
	 * {@link #parseInt(java.lang.String)} method. The result is an <code>int</code> value that represents the integer
	 * value specified by the string.
	 * <p>
	 * In other words, this method returns an <code>int</code> value equal to the value of:
	 * 
	 * <blockquote><code>
	 * Integer.parseInt(s)
	 * </code></blockquote>. if NumberFormatException error occur, return defaultVal.
	 * 
	 * @param s
	 *            the string to be parsed.
	 * @param defaultVal
	 *            the default value
	 * @return an <code>int</code> value holding the value represented by the string argument. return defaultVal if
	 *         NumberFormatException error occur.
	 */
	public static final int num(String str, int defaultVal) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defaultVal;
		}
	}

	/**
	 * Determines if the specified string is a digit.
	 * <p>
	 * A character is a digit if its general category type, provided by <code>Character.getType(ch)</code>, is
	 * <code>DECIMAL_DIGIT_NUMBER</code>.
	 * <p>
	 * Some Unicode character ranges that contain digits:
	 * <ul>
	 * <li><code>'&#92;u0030'</code> through <code>'&#92;u0039'</code>, ISO-LATIN-1 digits (<code>'0'</code> through
	 * <code>'9'</code>)
	 * <li><code>'&#92;u0660'</code> through <code>'&#92;u0669'</code>, Arabic-Indic digits
	 * <li><code>'&#92;u06F0'</code> through <code>'&#92;u06F9'</code>, Extended Arabic-Indic digits
	 * <li><code>'&#92;u0966'</code> through <code>'&#92;u096F'</code>, Devanagari digits
	 * <li><code>'&#92;uFF10'</code> through <code>'&#92;uFF19'</code>, Fullwidth digits
	 * </ul>
	 * 
	 * Many other character ranges contain digits as well.
	 * 
	 * <p>
	 * <b>Note:</b> This method cannot handle <a href="#supplementary"> supplementary characters</a>. To support all
	 * Unicode characters, including supplementary characters, use the {@link #isDigit(int)} method.
	 * 
	 * @param str
	 *            the string to be tested
	 * @return <code>true</code> if the string is a digit; <code>false</code> otherwise.
	 * @see java.lang.Character#isDigit(char)
	 */
	public static final boolean isNum(String str) {
		// way1: toCharArray
		// for (char c : str.toCharArray()) {//new char[]
		// if (!Character.isDigit(c)) {
		// return false;
		// }
		// }
		// way2: charAt
		int i = str.length();
		while (--i > 0) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a String is empty ("") or null.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 * 
	 * <p>
	 * NOTE: This method changed in Lang version 2.0. It no longer trims the String. That functionality is available in
	 * isBlank().
	 * </p>
	 * 
	 * @param str
	 *            the String to check, may be null
	 * @return <code>true</code> if the String is empty or null
	 */
	public static final boolean empty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * <p>
	 * Checks if a String is whitespace, empty ("") or null.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 * 
	 * @param str
	 *            the String to check, may be null
	 * @return <code>true</code> if the String is null, empty or whitespace
	 * @since 2.0
	 */
	public static final boolean blank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	/**
     * Compares the specified string s1 to the specified string s2.  The result is {@code
     * true} if and only if {@code s1 == null && s2 == null} or {@code s1.equalsIngoreCase(s2)}
     * object.
     *
     * @param  s1
     *         The string to compare s2 against
     * @param  s2
     *         The string to compare s1 against
     *
     * @return  {@code true} if the string s1 equivalent to the string s2, {@code false} otherwise
     */
	public static final boolean eq(String s1, String s2){
		return s1 != null && s2 != null ? s1.intern() == s2.intern() : s1 == s2;
	}
	
	/**
	 * Compares the specified string s1 to the specified string s2.  The result is {@code
	 * true} if and only if {@code s1 == null && s2 == null} or {@code s1.equalsIngoreCase(s2)}
	 * object.
	 *
	 * @param  s1
	 *         The string to compare s2 against
	 * @param  s2
	 *         The string to compare s1 against
	 *
	 * @return  {@code true} if the string s1 equivalent to the string s2, {@code false} otherwise
	 */
	public static final boolean eqIngoreCase(String s1, String s2){
		if(!eq(s1, s2)){
			//only one is null, or length not equal
			if(s1 == null || s2 == null || s1.length() != s2.length()){
				return false;
			}
			//to lower case and ==
			return s1.toLowerCase().intern() == s2.toLowerCase().intern();
		}
		return true;
	}
	
	 /**
     * Splits this string around matches of the given ",". and convert str to int value
     *
     * @param  str the delimiting regular expression
     *
     * @return  the array of ints from the strings computed by splitting this string
     *          around matches of the given regular expression
     *
     * @throws NullPointerException if the str is null
     */
	public static final int[] splitInt(String str){
		return splitInt(str, ",");
	}
	public static final int[] splitInt(String str, String regex){
		return splitInt(str, regex, Integer.MIN_VALUE);
	}
	
	/**
	 * 根据regex分隔str字符串，并转化为int值，若非字符串则默认为defaultVal. 若str、regex为null，则抛出NullPointerException
	 * 
	 * @param str
	 * @param regex
	 * @param defaultVal
	 * @return
	 * @throws NullPointerException if str or regex is null
	 */
	public static final int[] splitInt(String str, String regex, int defaultVal){
		String[] strs = str.split(regex);
		int[] result = new int[strs.length];
		int i = 0;
		for(String s : strs){
			result[i++] = num(s, defaultVal);
		}
		return result;
	}
	
	/**
	 * splits the str around matches of the given regex, and convert str to int
	 * 
	 * @param str
	 * @param regex
	 * @return
	 */
	public static final int[] splitInt(String str, String[] regex){
		return splitInt(str, regex, Integer.MIN_VALUE);
	}
	public static final int[] splitInt(String str, String[] regex, int defaultVal){
		String r = regex[0];
		for(int i = 1, counti = regex.length; i < counti; i++){
			str = str.replaceAll(regex[i], r);
		}
		int[] result = splitInt(str, r, defaultVal);
		return result;
	}

}
