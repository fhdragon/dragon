package org.apache.dragon.test;

import java.io.File;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * Test: TODO
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Sep 3, 2013
 * @since 1.0
 */
public class Test {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(Test.class);

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		m.put(11, 12);
		m.put(12, 11);
		m.put(1, 2);
		m.put(4, 4);
		m.put(3, 9);
//		System.out.println(m.descendingMap());
		for(Integer k : m.descendingKeySet()){
			System.out.println(k + "=" + m.get(k));
		}
	}

}
