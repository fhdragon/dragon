package org.apache.dragon.algs;

/**
 * Fibonacci: 费波那西数列（意大利语：Successione di Fibonacci），又译费波拿契数、斐波那契数列、费氏数列、黄金分割数列。
 * 在数学上，费波那西数列是以递归的方法来定义：
 *   F_0=0
 *   F_1=1
 *   F_n = F_{n-1}+ F_{n-2}
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 28, 2013
 * @since 1.0
 */
public class Fibonacci {

	//Logic
	/**
	 * 计算i的Fibonacci数:递归实现，返回负数表示参数i错误
	 * 
	 * @param i
	 * @return 返回负数表示参数i错误
	 */
	public static long fib1(long i){
		return i < 2 ? i : fib1(i - 1) + fib1(i - 2);
	}
	
	/**
	 * 计算i的Fibonacci数：迭代实现，返回负数表示参数i错误
	 * 
	 * @param i
	 * @return 返回负数表示参数i错误，否则返回i对应的Fibonacci数
	 */
	public static long fib2(long i){
		long r1 = 0, r2 = 1, j = i;
		while(j-- > 1){
			r1 ^= r2;
			r2 ^= r1;
			r1 ^= r2;
			r2 += r1;
		}
		return i < 2 ? i : r2;
	}
	
	/**
	 * 计算i的Fibonacci数：公式近似值实现，返回负数表示参数i错误
	 * 
	 * @param i
	 * @return 返回负数表示参数i错误，否则返回i对应的Fibonacci数
	 */
	public static long fib3(long i){
		return (long)(0.4472135955 * Math.pow(1.618033988745, i) + 0.5);
	}

}
