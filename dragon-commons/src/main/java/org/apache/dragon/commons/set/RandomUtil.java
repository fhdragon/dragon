package jp.gummy.commons.lang;

import java.util.Random;

/**
 * Random.java: 随机数相关工具类
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013/01/21
 * @since 1.0
 */
public class RandomUtil {
	
	//global variables
	/**
	 * random
	 */
	private static Random random = new Random();

    //Logic
    /**
	 * 生成介于min(包含)和max(不包含)之间的随机数
	 * 
	 * @param min the min of random
	 * @param max the max of random
	 * @return the random
	 */
	public static int random(int min, int max){
		if(min < 0 || max <= min){
			throw new IllegalArgumentException("min = " + min + ", max = " + max);
		}
		return random.nextInt(max - min) + min;
	}
	
}
