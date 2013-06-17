package org.apache.dragon.commons;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.dragon.commons.crypto.Crypto;
import org.apache.dragon.commons.crypto.Cryptos;
import org.apache.dragon.commons.crypto.DESStr;
import org.apache.dragon.commons.io.KryoSerialize;
import org.apache.dragon.commons.io.Serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

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
	public static void main(String[] args) throws Exception {
		try
        {
            File f = new File("test.xml");
            System.out.println(f.toString());
            System.out.println(f.getCanonicalFile().toString());
            System.out.println(f.getAbsoluteFile().toString());
            System.out.println(f.getPath());
            System.out.println(f.getCanonicalFile().getPath());
            System.out.println(f.getAbsoluteFile().getPath());
            System.out.println(f.toURI());
            System.out.println(f.getCanonicalFile().toURI());
            System.out.println(f.getAbsoluteFile().toURI());
            System.out.println(f.toURL());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getCanonicalFile().getAbsolutePath());
            System.out.println(f.getAbsoluteFile().getAbsolutePath());
            System.out.println(f.getCanonicalPath());
            if (f.exists())
            {
                File key = f.getCanonicalFile();
                System.out.println(key);
            }
        }
        catch (IOException e)
        {
        }
//		Package p = Tester.class.getPackage();
//		System.out.println(p);
//		System.out.println(p.getName());
//		System.out.println(p.getSpecificationTitle());
//		System.out.println(p.getSpecificationVersion());
//		System.out.println(p.getImplementationTitle());
//		System.out.println(p.getImplementationVendor());
//		System.out.println(p.getImplementationVersion());
//		Serialize s = new KryoSerialize();
//		Obj obj = new Obj();
//		obj.setId(1);
//		Kryo kryo = new Kryo();
//		User user = new User();
//		user.setId(1111);
//		user.setName("Wenlong Meng");
//		user.setBirth(new Date());
//		obj.setO(user);
//		byte[] userBytes = s.write(obj);
//		System.out.println(Arrays.toString(userBytes));
//		System.out.println(user);
//		Input input = new Input(userBytes);
//		kryo.register(User.class);
//		kryo.register(java.util.Date.class);
//		Obj o1 = (Obj)kryo.readObject(input, Obj.class);
//		System.out.println(obj);
//		System.out.println(o1);
//		User user1 = (User)o1.getO();
//		System.out.println(user1);
//		input.close();
//		
//		new Test4<String>().t("1111");
//		new Test4<Integer>().t(2222);
		
//		System.out.println(Cryptos.Base64Str.encrytor("admin"));
//		System.out.println(Cryptos.Base64Str.decrytor("YWRtaW4="));
////		byte[] s = MessageDigest.getInstance("MD5").digest("admin{salt}".getBytes());
//		byte[] s = MessageDigest.getInstance("MD5").digest("1".getBytes());
//		System.out.println(Hex.encodeHexString(s));
//		byte[] s1 = MessageDigest.getInstance("MD5").digest("2".getBytes());
//		System.out.println(Hex.encodeHexString(s1));
////		Crypto<String> c = new StrDES();
////		System.out.println(c.encrytor("WenlongMeng"));
//		Jedis jedis = new Jedis("localhost");
//	    jedis.connect();
//	    String email = jedis.get("email");
//	    System.out.println(email);
//	    jedis.set("name", "F.H Dragon");
//	    String name = jedis.get("name");
//	    System.out.println(name);
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
	
	public static class Test4<T> {
		public T t(T t){
			System.out.println(t);
			System.out.println(t.getClass());
			if(t instanceof String){
				return (T)"String";
			}else if(t instanceof Integer){
				return t;
			}
			return t;
		}
	}
	
	public static class User {
		private int id;
		private String name;
		private Date birth;
		
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * @return the birth
		 */
		public Date getBirth() {
			return birth;
		}
		
		/**
		 * @param birth the birth to set
		 */
		public void setBirth(Date birth) {
			this.birth = birth;
		}

		/** 
		  * TODO
		  * @see java.lang.Object#toString()
		  */
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
		}
		
	}
	
	/**
	 * Obj: TODO
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Jun 7, 2013
	 * @since 1.0
	 */
	public static class Obj{
		private Object o;
		private int id;
		
		/**
		 * @return the o
		 */
		public Object getO() {
			return o;
		}
		
		/**
		 * @param o the o to set
		 */
		public void setO(Object o) {
			this.o = o;
		}
		
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/** 
		  * TODO
		  * @see java.lang.Object#toString()
		  */
		@Override
		public String toString() {
			return "Obj [o=" + o + ", id=" + id + "]";
		}
		
		
	}

}
