package org.apache.dragon.commons;

import java.util.Arrays;

import org.apache.dragon.commons.util.CharUtil;
import org.apache.dragon.commons.util.StringUtil;

/**
 * Tester: temp test
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 8, 2013
 * @since 1.0
 */
public class Tester {

	//Local variables

	//test
	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		char[] is = new char[4];
		is[3] = 98;
		is[2] = (char)0;
		is[1] = 97;
		is[0] = '0';
		System.out.println(Arrays.toString(is));
		System.out.println((char)0);
		System.out.println(StringUtil.lower("sfdDFWERWdfsdf对方地方sdfSDFDSF324234498"));
		System.out.println(StringUtil.upper("sfdDFWERWdfsdf对方地方sdfSDFDSF324234498"));
//		for(int i = 65; i<91; i++){
//			System.out.print("     " + i + ", ");
//		}
//		System.out.println();
//		for(int i = 65; i<91; i++){
//			System.out.print(Integer.toBinaryString(i) + ", ");
//		}
//		System.out.println();
//		for(int i = 65; i<91; i++){
//			System.out.print("      " + (char)i + ", ");
//		}
//		System.out.println();
//		for(int i = 97; i<123; i++){
//			System.out.print((i < 100 ? "     " : "    ") + i + ", ");
//		}
//		System.out.println();
//		for(int i = 97; i<123; i++){
//			System.out.print(Integer.toBinaryString(i) + ", ");
//		}
//		System.out.println();
//		for(int i = 97; i<123; i++){
//			System.out.print("      " + (char)i + ", ");
//		}
	}

}
