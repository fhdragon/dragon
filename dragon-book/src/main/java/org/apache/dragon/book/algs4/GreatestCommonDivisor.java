package org.apache.dragon.algs4;

/**
 * Euclid's algorithm: compute the greatest common divisor of two nonnegative integer p and q as follows: If q is 0, the
 * answer is p. If not, divide p by q and take the remainder r, The answer is the greatest common divisor of q and r.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Nov 24, 2013
 * @since 1.0
 */
public class GreatestCommonDivisor {

	// Local variables

	// Logic
	/**
	 * Euclid's algorithm: compute the greatest common divisor of two nonnegative integer p and q as follows: If q is 0,
	 * the answer is p. If not, divide p by q and take the remainder r, The answer is the greatest common divisor of q
	 * and r.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p, int q) {
		return q == 0 ? p : gcd(q, p % q);
	}

	/**
	 * test for gcd
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int p = 88, q = 42;
		System.out.println("gcd(" + p + ", " + q +  ") = " + gcd(p, q));
		p = 0; q = 42;
		System.out.println("gcd(" + p + ", " + q +  ") = " + gcd(p, q));
		p = 99; q = 66;
		System.out.println("gcd(" + p + ", " + q +  ") = " + gcd(p, q));
		p = 89; q = 0;
		System.out.println("gcd(" + p + ", " + q +  ") = " + gcd(p, q));
	}

}
