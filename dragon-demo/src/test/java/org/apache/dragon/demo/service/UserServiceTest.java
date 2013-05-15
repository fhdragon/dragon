package org.apache.dragon.demo.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import org.apache.dragon.demo.model.User;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserServiceTest: user service test
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 3, 2013
 * @since 1.0
 */
public class UserServiceTest {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	/**
	 * context
	 */
	private static ApplicationContext context;
	/**
	 * service
	 */
	private static UserService service;
	
	//Logic
	/**
	 * test select method
	 */
	@Test
	public void select(){
		logger.debug("Begin: select()...");
		User result = service.select(2);
		logger.debug("End: result = " + result);
	}
	
	/**
	 * test add a new user
	 */
	@Test
	public void add(){
		logger.debug("Begin: add()...");
		User user = new User();
		Random r = new Random();
		user.setId(r.nextInt(10000));
		user.setAge(r.nextInt(100));
		user.setName("Wenlong Meng " + r.nextLong());
		user.setSex(1 + r.nextInt(2));
		Calendar c = Calendar.getInstance();
		c.set(1700 + r.nextInt(300), 1 + r.nextInt(12), 1 + r.nextInt(31));
		user.setBirthday(c.getTime());
		int result = service.add(user);
		logger.debug("End: result = " + result);
	}
	
	/**
	 * init resources
	 */
	@BeforeClass
	public static void init(){
		logger.debug("Begin: init()...");
		try{
			context = new ClassPathXmlApplicationContext(new String[]{"conf/applicationContext-context.xml", "conf/applicationContext-mvc.xml", "conf/applicationContext-mybatis.xml"});
			service = context.getBean(UserService.class);
		}catch(Exception e){
			logger.error("", e);
		}
		String result = Arrays.toString(context.getBeanDefinitionNames());
		logger.debug("End: result = " + result);
	}
	
	/**
	 * release resources
	 */
	@AfterClass
	public static void destroy(){
		logger.debug("Begin: destroy()...");
		((ConfigurableApplicationContext)context).close();
		logger.debug("End");
	}

}
