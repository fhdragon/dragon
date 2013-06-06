package org.apache.dragon.commons.io;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for serialize with kryo
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 07, 2013
 * @since 1.0
 */
public class KryoSerializeTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(KryoSerializeTest.class);

	// Logic
	/**
	 * test {@link Serialize#write(Object)} and {@link Serialize#read(Object)}
	 */
	@Test
	public void serialize() {
		logger.debug("Begin: serialize()...");
		User user = new User();
		user.setId(1111);
		user.setName("Wenlong Meng");
		user.setBirth(new Date());
		Serialize s = new KryoSerialize();
		byte[] userBytes = s.write(user);
		logger.debug(Arrays.toString(userBytes));
		User user1 = s.read(userBytes, User.class);
		logger.debug("user = " + user);
		logger.debug("user1 = " + user1);
		boolean result = user.toString().equals(user1.toString());
		assert result;
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
	
	//inner class
	/**
	 * User: 
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Jun 6, 2013
	 * @since 1.0
	 */
	public static class User implements Serializable {
		
		//local variables
		private static final long serialVersionUID = -3771915902021954613L;
		private int id;
		private String name;
		private Date birth;
		
		//getter and setter
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
		  * @see java.lang.Object#toString()
		  */
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
		}
	}

}
