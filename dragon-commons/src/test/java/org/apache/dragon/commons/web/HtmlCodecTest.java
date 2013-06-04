package org.apache.dragon.commons.web;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for HtmlFilter
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at June 02, 2013
 * @since 1.0
 */
public class HtmlCodecTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(HtmlCodecTest.class);

	// Logic
	/**
	 * test encode: char -> num
	 */
	@Test
	public void encodeNum() {
		logger.debug("Begin: encodeNum()...");
		String s = "&</school_name><major>理</major><faculty>情報系</fac>'\"&#60;\" is &amp;<\"asd";
		String ss = "&#38;&#60;/school_name&#62;&#60;major&#62;理&#60;/major&#62;&#60;faculty&#62;情報系&#60;/fac&#62;&#39;&#34;&#38;#60;&#34; is &#38;amp;&#60;&#34;asd";
		logger.debug("encode(String) : start " + System.nanoTime());
		if(HtmlCodec.encode(s).intern() == ss){
			logger.debug("encode(String) is ok");
		}else{
			logger.error("ss = " + ss);
			logger.error("encode(s) = " + HtmlCodec.DefaultChar2ENM.encode(s));
			throw new AssertionError("encode(String) is error");
		}
		logger.debug("encode(String) : stop " + System.nanoTime());
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test encode: char -> name
	 */
	@Test
	public void encodeName() {
		logger.debug("Begin: encodeName()...");
		String s = "&</school_name><major>理</major><faculty>情報系</fac>'\"&#60;\" is &amp;<\"asd";
		String ss = "&amp;&lt;/school_name&gt;&lt;major&gt;理&lt;/major&gt;&lt;faculty&gt;情報系&lt;/fac&gt;&apos;&quot;&amp;#60;&quot; is &amp;amp;&lt;&quot;asd";
		logger.debug("HtmlFilter.DefaultCharENM.encode(String) : start " + System.nanoTime());
		if(HtmlCodec.DefaultChar2ENM.encode(s).intern() == ss){
			logger.debug("encode(String) is ok");
		}else{
			logger.error("ss = " + ss);
			logger.error("encode(s) = " + HtmlCodec.DefaultChar2ENM.encode(s));
			throw new AssertionError("encode(String) is error");
		}
		logger.debug("HtmlFilter.DefaultCharENM.encode(String) : stop " + System.nanoTime());
		boolean result = true;
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test decode
	 */
	@Test
	public void decode() {
		logger.debug("Begin: decode()...");
		String s = "&</school_name><major>理</major><faculty>情報系</fac>'\"&#60;\" is &amp;<\"asd";
		String ss = "&#38;&#60;/school_name&#62;&#60;major&#62;理&#60;/major&#62;&#60;faculty&#62;情報系&#60;/fac&#62;&#39;&#34;&#38;#60;&#34; is &#38;amp;&#60;&#34;asd";
		System.out.println("decode(String) : start " + System.nanoTime());
		if(HtmlCodec.decode(ss).intern() == s){
			System.out.println("decode(String) is ok");
		}else{
			throw new AssertionError("decode(String) is error");
		}
		System.out.println("decode(String) : stop " + System.nanoTime());
		
		s = "&</school_name><major>理</major><faculty>情報系</fac>'\"&#60;\" is &amp;<\"asd";
		ss = "&amp;&lt;/school_name&gt;&lt;major&gt;理&lt;/major&gt;&lt;faculty&gt;情報系&lt;/fac&gt;&apos;&quot;&amp;#60;&quot; is &amp;amp;&lt;&quot;asd";
		System.out.println("HtmlFilter.DefaultCharENM.decode(String) : start " + System.nanoTime());
		if(HtmlCodec.DefaultChar2ENM.decode(ss).intern() == s){
			System.out.println("decode(String) is ok");
		}else{
//			System.out.println(s);
//			System.out.println(decode(ss));
			throw new AssertionError("decode(String) is error");
		}
		System.out.println("HtmlFilter.DefaultCharENM.decode(String) : stop " + System.nanoTime());
		
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
