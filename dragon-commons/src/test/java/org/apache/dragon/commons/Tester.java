package org.apache.dragon.commons;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.dragon.commons.crypto.AESStr;
import org.apache.dragon.commons.crypto.Base64Str;
import org.apache.dragon.commons.crypto.Crypto;
import org.apache.dragon.commons.crypto.DESStr;
import org.apache.dragon.commons.crypto.Digest;
import org.apache.dragon.commons.crypto.Helper;
import org.apache.dragon.commons.crypto.MD5Str;
import org.apache.dragon.commons.crypto.RSAByte;
import org.apache.dragon.commons.crypto.RSAStr;
import org.apache.dragon.commons.crypto.SHAStr;
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
		System.out.println("sfsfdsdf" + "sss" == null ? "" : "aaaaaa");
//		long st = System.currentTimeMillis();
//		BufferedReader fr = new BufferedReader(new FileReader(new File("/Users/wenlongmeng/Downloads/twitter_rv.net")));
//		Map<String, Integer> s = new HashMap<String, Integer>();
//		int i = 0;
//		String k;
//		while(i++<100000000){
//			k = fr.readLine().split("	")[0];
//			if(!s.containsKey(k)){
//				s.put(k, 1);
//			}else{
//				s.put(k, s.get(k) + 1);
//			}
//			System.out.println(i);
//		}
//		System.out.println(s.size() + ": " + s);
//		fr.close();
//		System.out.println("Cost: " + (System.currentTimeMillis() - st));
		
//		Runtime.getRuntime().gc();
//		System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
//		int i = 1;
//		System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
//		Runtime.getRuntime().gc();
//		System.out.println(Runtime.getRuntime().exec("java"));
		
		//		Digest<String> d = new SHAStr();
//		System.out.println(d.digest("fhdragon"));
//		Crypto<String> c = new RSAStr();
//		String r = c.encrytor("fhdragon");
//		System.out.println(r);
//		System.out.println(new RSAStr(((RSAStr)c).privateKey(), ((RSAStr)c).publicKey()).decrytor(r));
		
//		System.out.println(Arrays.toString(Helper.PUB_KEY));
//		System.out.println(Base64.encodeBase64String(Helper.PUB_KEY));
//		String s = "rO0ABXNyABRqYXZhLnNlY3VyaXR5LktleVJlcL35T7OImqVDAgAETAAJYWxnb3JpdGhtdAASTGphdmEvbGFuZy9TdHJpbmc7WwAHZW5jb2RlZHQAAltCTAAGZm9ybWF0cQB+AAFMAAR0eXBldAAbTGphdmEvc2VjdXJpdHkvS2V5UmVwJFR5cGU7eHB0AANSU0F1cgACW0Ks8xf4BghU4AIAAHhwAAAAojCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAoW5I6RcAoe2m8uaPbUO56WggMItOg0pLiFCk1uWijAKEzGpL1tTVHdaui4UgIsRiQEPZKji/t6ESLpNE7Fl58mybGzOd+PXBQWzFRn7X8u7Xvu5J7STlAML/fvQXBh6wYcN5nZhEUETCOnDHlH2s+Szzyy7UhnVuVvBg0ISb29kCAwEAAXQABVguNTA5fnIAGWphdmEuc2VjdXJpdHkuS2V5UmVwJFR5cGUAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAZQVUJMSUM=";
//		System.out.println(s);
//		System.out.println(Arrays.toString(Base64.decodeBase64(s)));
//		Crypto<byte[]> cc = new RSAByte();
//		byte[] b = cc.encrytor("1".getBytes());
//		System.out.println(cc.decrytor(b));
//		byte[] p = ((RSAByte)cc).privateKey();
//		System.out.println(Arrays.toString(p));
//		byte[] pubKey = ((RSAByte)cc).publicKey();
//		System.out.println(Arrays.toString(pubKey));
//		cc = new RSAByte(p, pubKey);
//		System.out.println(new String(cc.decrytor(b)));
//		Crypto<String> c = new RSAStr();
//		String ss = c.encrytor("1");
//		System.out.println(c.decrytor(ss));
//		System.out.println(((RSAStr)c).privateKey());
//		System.out.println(((RSAStr)c).publicKey());
//		String sss = "rO0ABXNyABRqYXZhLnNlY3VyaXR5LktleVJlcL35T7OImqVDAgAETAAJYWxnb3JpdGhtdAASTGphdmEvbGFuZy9TdHJpbmc7WwAHZW5jb2RlZHQAAltCTAAGZm9ybWF0cQB+AAFMAAR0eXBldAAbTGphdmEvc2VjdXJpdHkvS2V5UmVwJFR5cGU7eHB0AANSU0F1cgACW0Ks8xf4BghU4AIAAHhwAAACejCCAnYCAQAwDQYJKoZIhvcNAQEBBQAEggJgMIICXAIBAAKBgQChbkjpFwCh7aby5o9tQ7npaCAwi06DSkuIUKTW5aKMAoTMakvW1NUd1q6LhSAixGJAQ9kqOL+3oRIuk0TsWXnybJsbM5349cFBbMVGftfy7te+7kntJOUAwv9+9BcGHrBhw3mdmERQRMI6cMeUfaz5LPPLLtSGdW5W8GDQhJvb2QIDAQABAoGAOcgh7NzA6zUHhvYj7HZLe1I8A2Q5rCDRvG8xMYJsljTol8qMbs8roUyQmXwDLq6ghGREvSom5XGP8n/gMcEtNpkr1Xnxr22Cq2laPeiubbAM+ipqwBSoiDdX+8TyJpLidLHDxhY/4Jfcu8XzxW2fJI6W/MUVffgeHumj8V9SziECQQDS925bs8AQuiUqS78x8hs1zsid9cz9zXpTsZCX+p4qT6BRQ5CDvljlEPKj9+fReqxKZVx2nP9VmqZUSmaJYMPVAkEAw+PnGZ7+eX0i+15c51vEDVev4xmgNrZ54tQbT81E9LGxI7gHKj2lkmb3UbdYUiKa9dsSSODdvDBrGIJ29EQt9QJBAJck0DsA4ATb6A6ScCuvYhE90fthg/j+Arr9hzNrSW/U1m4CMwJAGF4cs0oILVymP9OZJRKRzlkdUDcpiqa33fUCQEvKySbboqBE750MpKuLkO6Mp+wZhSjGL6C46pxU0sJOYjhswrDwSzi7CCQg6VZWN1i623dBMenXXgiMqhPWsWUCQBlo18HZ662n4R/zBU6MUmkFgxioEbjmpaT3WY8XB+NvesdVPiuMTa658eFAf1KsoFOO9AWPa/VhJFL7ASozXwZ0AAZQS0NTIzh+cgAZamF2YS5zZWN1cml0eS5LZXlSZXAkVHlwZQAAAAAAAAAAEgAAeHIADmphdmEubGFuZy5FbnVtAAAAAAAAAAASAAB4cHQAB1BSSVZBVEU=";
//		c = new RSAStr(sss, s);
//		System.out.println(c.decrytor(ss));
		
//		String s = new RSAStr().encrytor("F.H Dragon");
//		System.out.println(s);
//		System.out.println(new RSAStr().decrytor(s));
//		System.out.println(new Base64Str().encrytor("1"));
		
//		String s = Cryptos.DESStr.encrytor("1");
//		System.out.println(s);
//		s = Cryptos.DESStr.encrytor("1");
//		System.out.println(s);
//		System.out.println(Cryptos.DESStr.decrytor(s));
//		s = Cryptos.AESStr.encrytor("1");
//		System.out.println(s);
//		s = Cryptos.AESStr.encrytor("1");
//		System.out.println(s);
//		System.out.println(Cryptos.AESStr.decrytor(s));
//		s = Cryptos.AESStr.encrytor("2");
//		System.out.println(s);
//		System.out.println(Cryptos.AESStr.decrytor(s));
//		System.out.println(Digests.SHAStr.digest("1"));
//		System.out.println(Digests.SHAStr.digest("1"));
//		System.out.println(Digests.SHAStr.digest("2"));
//		System.out.println(Digests.SHAStr.digest("2"));
//		System.out.println(Digests.SHAStr.digest("fhdragon"));
//		System.out.println(Digests.SHAStr.digest("fhdragon"));
//		System.out.println(new java.sql.Date(new java.util.Date().getTime()).toString());
//		try
//        {
//            File f = new File("test.xml");
//            System.out.println(f.toString());
//            System.out.println(f.getCanonicalFile().toString());
//            System.out.println(f.getAbsoluteFile().toString());
//            System.out.println(f.getPath());
//            System.out.println(f.getCanonicalFile().getPath());
//            System.out.println(f.getAbsoluteFile().getPath());
//            System.out.println(f.toURI());
//            System.out.println(f.getCanonicalFile().toURI());
//            System.out.println(f.getAbsoluteFile().toURI());
//            System.out.println(f.toURL());
//            System.out.println(f.getAbsolutePath());
//            System.out.println(f.getCanonicalFile().getAbsolutePath());
//            System.out.println(f.getAbsoluteFile().getAbsolutePath());
//            System.out.println(f.getCanonicalPath());
//            if (f.exists())
//            {
//                File key = f.getCanonicalFile();
//                System.out.println(key);
//            }
//        }
//        catch (IOException e)
//        {
//        }
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
