package org.apache.dragon.commons.util;

/**
 * Character Utilities. 
 * ACSII Code(a ~ z & A ~ Z):
 *      65,      66,      67,      68,      69,      70,      71,      72,      73,      74,      75,      76,      77,      78,      79,      80,      81,      82,      83,      84,      85,      86,      87,      88,      89,      90, 
 * 1000001, 1000010, 1000011, 1000100, 1000101, 1000110, 1000111, 1001000, 1001001, 1001010, 1001011, 1001100, 1001101, 1001110, 1001111, 1010000, 1010001, 1010010, 1010011, 1010100, 1010101, 1010110, 1010111, 1011000, 1011001, 1011010, 
 * 		 A,       B,       C,       D,       E,       F,       G,       H,       I,       J,       K,       L,       M,       N,       O,       P,       Q,       R,       S,       T,       U,       V,       W,       X,       Y,       Z, 
 *		97,      98,      99,     100,     101,     102,     103,     104,     105,     106,     107,     108,     109,     110,     111,     112,     113,     114,     115,     116,     117,     118,     119,     120,     121,     122, 
 * 1100001, 1100010, 1100011, 1100100, 1100101, 1100110, 1100111, 1101000, 1101001, 1101010, 1101011, 1101100, 1101101, 1101110, 1101111, 1110000, 1110001, 1110010, 1110011, 1110100, 1110101, 1110110, 1110111, 1111000, 1111001, 1111010, 
 * 		 a,       b,       c,       d,       e,       f,       g,       h,       i,       j,       k,       l,       m,       n,       o,       p,       q,       r,       s,       t,       u,       v,       w,       x,       y,       z,
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Aug 15, 2013
 * @since 1.0
 */
public final class CharUtil {
	
	//Logic
	/**
	 * <p>
	 * Converts the character argument to lowercase using bit.
	 * </p>
	 * 
	 * @param c
	 *            the character to lowercase
	 * @return
	 */
	public static char lower(char c) {
		return isUpper(c) ? (char)(c | 0X020) : c;
	}
	
	/**
	 * <p>
	 * Converts the character argument to uppercase using bit.
	 * </p>
	 * 
	 * @param c
	 *            the character to lowercase
	 * @return
	 */
	public static char upper(char c) {
		return isLower(c) ? (char)(c & 0XFFDF) : c;
	}
	
	/**
	 * check c is lower letter
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isLower(char c) {
		return c >= 97 && c <= 122;
	}
	
	/**
	 * check c is upper letter
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isUpper(char c) {
		return c >= 56 && c <= 90;
	}
	
	/**
	 * check c is letter
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isLetter(char c) {
		return isLower(c) || isUpper(c);
	}
	
}
