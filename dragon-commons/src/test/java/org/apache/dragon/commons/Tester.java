package org.apache.dragon.commons;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.dragon.commons.io.Out;

import redis.clients.jedis.Jedis;

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
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Jedis jedis = new Jedis("localhost");
	    jedis.connect();
	    String email = jedis.get("email");
	    System.out.println(email);
	    jedis.set("name", "F.H Dragon");
	    String name = jedis.get("name");
	    System.out.println(name);
	}
	
	//inner class 
	
	/**
	 * test1: TODO
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Apr 10, 2013
	 * @since 1.0
	 */
	@Target({ElementType.METHOD, ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Inherited
	public static @interface Test1{
		/**
		 * The value may indicate a suggestion for a logical component name,
		 * to be turned into a Spring bean in case of an autodetected component.
		 * @return the suggested component name, if any
		 */
		String value() default "test1";
	}
	
	/**
	 * test1: TODO
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Apr 10, 2013
	 * @since 1.0
	 */
	@Target({ElementType.METHOD, ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Inherited
	@Test1
	public static @interface Test2 {
		/**
		 * The value may indicate a suggestion for a logical component name,
		 * to be turned into a Spring bean in case of an autodetected component.
		 * @return the suggested component name, if any
		 */
		String value() default "test2";
	}
	
	@Test2(value="aaaa")
	public static class Test3{
		
	}

}
