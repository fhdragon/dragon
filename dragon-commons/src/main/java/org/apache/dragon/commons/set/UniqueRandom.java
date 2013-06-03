package org.apache.dragon.commons.set;

import static org.apache.dragon.commons.set.Arrays.*;
import static org.apache.dragon.commons.set.RandomUtil.*;

import java.util.Arrays;
import java.util.BitSet;

/**
 * UniqueRandom: 唯一随机数实现类,提供指定范围内的唯一随机数
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013/01/21
 * @since 1.0
 */
public class UniqueRandom implements Random {

	//Local variables
	/**
	 * store randoms
	 */
	private Random radom = null;
	
	//Constructor
	/**
	 * 构建唯一随机数对象
	 */
	public UniqueRandom(){
		this(0, Integer.MAX_VALUE);
	}
	/**
	 * 构建唯一随机数对象: 介于min与max之间
	 */
	public UniqueRandom(int min, int max){
		//range check
		checkRange(min, max);
		if(max - min < (1<<20)){
			this.radom = new ArrayUniqueRandom(min, max);
		}else{
			this.radom = new BitsUniqueRandom(min, max);
		}
	}
	/**
	 * 构建唯一随机数对象：介于min与max之间，且不包括rs
	 */
	public UniqueRandom(int min, int max, int[] rs){
		//range check
		checkRange(min, max);
		if(max - min < (1<<20)){
			this.radom = new ArrayUniqueRandom(min, max, rs);
		}else{
			this.radom = new BitsUniqueRandom(min, max, rs);
		}
	}

	//Logic
	/**
	 * 返回介于min(包含)和max(不包含)之间的随机数
	 * 
	 * @return the random
	 * @see jp.gummy.commons.lang.Random#next()
	 */
	@Override
	public int next() {
		return this.radom.next();
	}
	
	/**
	 * check min and max range
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private static void checkRange(int min, int max){
		//range check
		if(min < 0 || max <= min){
			throw new IllegalArgumentException("min = " + min + ", max = " + max);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UniqueRandom [radom=" + radom + "]";
	}
	
	//Inner class
	/**
	 * ArrayUniqueRandom: 数组形式生成随机数，适用于小范围随机数
	 *
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2013/01/21
	 * @since 1.0
	 */
	public static class ArrayUniqueRandom implements Random {
		//Local variables
		/**
		 * store randoms
		 */
		private int[] randoms = null;
		/**
		 * the index of randoms
		 */
		private int index = 0;
		
		//Constructor
		/**
		 * 构建唯一随机数对象
		 */
		public ArrayUniqueRandom(int min, int max){
			//init random values
			randoms = new int[max - min];
			for(int i = 0, counti = randoms.length; i < counti; i++){
				randoms[i] = i + min;
			}
			//make randoms
			for(int i = 0, counti = randoms.length; i < counti; i++){
				swap(this.randoms, i, random(i, counti));
			}
		}
		
		/**
		 * 构建唯一随机数对象: 指定的rs除外
		 */
		public ArrayUniqueRandom(int min, int max, int[] rs){
			//init random values
			randoms = new int[max - min];
			for(int i = 0, counti = randoms.length; i < counti; i++){
				randoms[i] = i + min;
			}
			//swap rs
			for(int i = 0, counti = rs.length; i < counti; i++){
				swap(this.randoms, i, rs[i]);
			}
		}

		//Logic
		/**
		 * 返回介于min(包含)和max(不包含)之间的随机数
		 * 
		 * @return the random
		 * @see jp.gummy.commons.lang.Random#next()
		 */
		@Override
		public int next() {
			//make randoms
			swap(this.randoms, index, random(index, randoms.length));
			return this.randoms[index++];
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final int maxLen = 100;
			return "ArrayUniqueRandom [randoms="
					+ (randoms != null ? Arrays.toString(Arrays.copyOf(randoms,
							Math.min(randoms.length, maxLen))) : null)
					+ ", index=" + index + "]";
		}
		
	}
	/**
	 * BitsUniqueRandom: 位标识形式生成随机数，适用于大范围随机数
	 *
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2013/01/21
	 * @since 1.0
	 */
	public static class BitsUniqueRandom implements Random {
		//Local variables
		/**
		 * store randoms
		 */
		private BitSet randoms = null;
		/**
		 * random
		 */
		private java.util.Random random = new java.util.Random();
		/**
		 * min
		 */
		private int min;
		/**
		 * max
		 */
		private int max;
		
		//Constructor
		/**
		 * 构建唯一随机数对象
		 */
		public BitsUniqueRandom(int min, int max){
			this.max = max;
			this.min = min;
			randoms = new BitSet(max - min);
		}
		/**
		 * 构建唯一随机数对象: 指定的rs除外
		 */
		public BitsUniqueRandom(int min, int max, int[] rs){
			this(min, max);
			for(int r : rs){
				this.randoms.set(r);
			}
		}
		
		//Logic
		/**
		 * 返回介于min(包含)和max(不包含)之间的随机数
		 * 
		 * @return the random
		 * @see jp.gummy.commons.lang.Random#next()
		 */
		@Override
		public int next() {
			int r = this.random.nextInt(max - min);
			while(this.randoms.get(r)){
				r = this.random.nextInt(max - min);
			}
			this.randoms.set(r);
			return r + min;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "BitsUniqueRandom [randoms=" + randoms + ", random="
					+ random + ", min=" + min + ", max=" + max + "]";
		}
		
	}
	
	//Test
	/**
	 * test...
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Random r = new UniqueRandom(0, 40);
		System.out.println(r);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 40; i++){
			sb.append(r.next()).append(",");
		}
		System.out.println(sb);
		Random r1 = new UniqueRandom(0, 200000000);
		System.out.println(r1);
		StringBuilder sb1 = new StringBuilder();
		for(int i = 0; i < 200; i++){
			sb1.append(r1.next()).append(",");
		}
		System.out.println(sb1);
	}
	
}
