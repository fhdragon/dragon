package org.apache.dragon.commons.io;

import static org.apache.dragon.commons.io.Out.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * OutTest: test for Out
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Mar 27, 2013
 * @since 1.0
 */
public class OutTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(OutTest.class);

	// Logic
	/**
	 * test {@link Out#out(Object)} and {@link Out#outln(Object)}
	 */
	@Test
	public void outTest() {
		logger.debug("Begin: outTest()...");
		//byte array
		byte[] bas = new byte[2];
		bas[0] = 1;
		bas[1] = 2;
		out("byte[] : ");
		outln(bas);
		//int array
		int[] ias = new int[2];
		ias[0] = 11;
		ias[1] = 22;
		out("int[] : ");
		outln(ias);
		//short array
		short[] sas = new short[2];
		sas[0] = 111;
		sas[1] = 222;
		out("short[] : ");
		outln(sas);
		//short array
		char[] cas = new char[2];
		cas[0] = '0';
		cas[1] = 'a';
		out("char[] : ");
		outln(cas);
		//float array
		float[] fas = new float[2];
		fas[0] = 11111F;
		fas[1] = 22222F;
		out("float[] : ");
		outln(fas);
		//double array
		double[] das = new double[2];
		das[0] = 111111D;
		das[1] = 222222D;
		out("double[] : ");
		outln(das);
		//long array
		long[] las = new long[2];
		las[0] = 111111L;
		las[1] = 222222L;
		out("long[] : ");
		outln(las);
		//boolean array
		boolean[] blas = new boolean[2];
		blas[0] = true;
		blas[1] = false;
		out("boolea[] : ");
		outln(blas);
		//Object
		Object o = new Object();
		out("Object: ");
		outln(o);
		//String
		String s = "F.H Dragon";
		out(s);
		s = "(wenlong.meng@gmail.com)";
		outln(s);
		//Byte array
		Byte[] Bas = new Byte[2];
		Bas[0] = 99;
		Bas[1] = 88;
		out("Byte[] : ");
		outln(Bas);
		//Long array
		Long[] Las = new Long[2];
		Las[0] = 999L;
		Las[1] = 888L;
		out("Long[] : ");
		outln(Las);
		//Object array
		Object[] oas = new Object[2];
		oas[0] = Las;
		oas[1] = "Wenlong Meng";
		out("Object[] : ");
		outln(oas);
		//Map
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("code", 1000000);
		m.put("num", 1111);
		out("Map : ");
		outln(m);
		//List
		List<Object> l = new ArrayList<Object>();
		l.add(m);
		l.add(las);
		out("List : ");
		outln(l);
		//Integer
		Integer I = new Integer(Integer.MAX_VALUE);
		out("Integer : ");
		outln(I);

		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * allocate expensive external resources(like logging into a database) before any of the test methods in the class.
	 */
	@BeforeClass
	public static void init() {
		logger.debug("Begin: init()...");
		logger.debug("End: init()!");
	}

	/**
	 * releases any resource that you allocate expensive external resources in a {@link BeforeClass} method after all
	 * the tests in the this class have been run. this method guaranteed to run.
	 */
	@AfterClass
	public static void destory() {
		logger.debug("Begin: destory()...");
		logger.debug("End: destory()!");
	}

}
