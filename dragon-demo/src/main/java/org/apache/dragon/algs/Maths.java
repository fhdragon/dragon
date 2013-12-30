package org.apache.dragon.algs;

/**
 * Maths: utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 28, 2013
 * @since 1.0
 */
public class Maths {

	//Local variables

	//Logic
	/**
	 * Returns the absolute value of an <code>int</code> value.
     * If the argument is not negative, the argument is returned.
     * If the argument is negative, the negation of the argument is returned. 
     * 
     * <p>Note that if the argument is equal to the value of
     * <code>Integer.MIN_VALUE</code>, the most negative representable
     * <code>int</code> value, the result is that same value, which is
     * negative.
	 * 
	 * @param a
	 * @return the absolute value of the argument
	 */
	public static int abs(int a) {
		return a < 0 ? -a : a;
	}
	
	/**
	 * Returns the absolute value of an <code>double</code> value.
	 * If the argument is not negative, the argument is returned.
	 * If the argument is negative, the negation of the argument is returned. 
	 * 
	 * <p>Note that if the argument is equal to the value of
	 * <code>Double.MIN_VALUE</code>, the most negative representable
	 * <code>double</code> value, the result is that same value, which is
	 * negative.
	 * 
	 * @param a
	 * @return the absolute value of the argument
	 */
	public static double abs(double a) {
		return a < 0.0 ? -a : a;
	}
	
	/**
	 * return true if a is prime, return false if a isn't prime
	 * 
	 * @param a
	 * @return true if a is prime
	 */
	public static boolean isPrime(int a) {
		if(a < 2) return false;
		for(int i = 1; i * i < a; i++){
			if(a % i == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * the sqrt of a; if a less than zero,return Double.Nan
	 * 牛顿迭代法
	 * 
	 * @param a
	 * @return the sqrt of a; if a less than zero,return Double.Nan
	 */
	public static double sqrt(double a) {
		if(a < 0) return Double.NaN;
		double err = 1e-15;
		double t = a;
		while(abs(t - a / t) > err * t){
			t = (a / t + t) / 2.0;
		}
		return t;
	}
	
	/**
	 * compute the hypotenuse of Triangle
	 * 
	 * @param a
	 * @return 
	 */
	public static double hypotenuse(double a, double b) {
		return sqrt(a * a + b * b);
	}
	
	/**
	 * Harmonic series: H(n) = 1 + 1/2 + 1/3 + 1/4 + ... + 1/(n - 1) + 1/n
	 * 
	 * @param a
	 * @return 
	 */
	public static double harmonicSeries(int n) {
		double result = 0;
		for(int i = 1; i <= n; i++){
			result += 1.0 / i;
		}
		return result;
	}

}
