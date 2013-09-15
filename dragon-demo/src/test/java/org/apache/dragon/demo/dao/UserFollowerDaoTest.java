package org.apache.dragon.demo.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.dragon.demo.model.User;
import org.apache.dragon.demo.model.UserFollower;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * test for UserFollowerDao
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 24, 2013
 * @since 1.0
 */
public class UserFollowerDaoTest {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(UserFollowerDaoTest.class);
	/**
	 * dao
	 */
	private static UserFollowerDao dao;
	/**
	 * context
	 */
	private static ApplicationContext context;
	
	//Logic
	/**
	 * test select method
	 * @throws Exception 
	 */
//	@Test
	public void parse() throws Exception{
		logger.debug("Begin: parse()...");
		long st = System.currentTimeMillis();
		BufferedReader fr = new BufferedReader(new FileReader(new File("/Users/wenlongmeng/Downloads/twitter_rv.net")));
		Map<String, Integer> result = new HashMap<String, Integer>();
		int i = 0;
		String[] k;
		while(i++<100000000){
			String l = fr.readLine();
			k = l.split("	");
			if(k.length == 2){
//				logger.debug();
//				UserFollower userFollower = new UserFollower();
//				userFollower.setId(Integer.parseInt(k[0]));
//				userFollower.setFid(Integer.parseInt(k[1]));
//				dao.add(userFollower);
			}else{
//				logger.error("err: " + l);
				System.out.println("err: " + l);
			}
//			if(!result.containsKey(k[0])){
//				result.put(k[0], 1);
//			}else{
//				result.put(k[0], result.get(k[0]) + 1);
//			}
//			System.out.println(i);
		}
		fr.close();
		System.out.println("Cost: " + (System.currentTimeMillis() - st));
		logger.debug("End: size = " + result.size() + ", result = " + result);
	}
	
	/**
	 * init resources
	 */
	@BeforeClass
	public static void init(){
		logger.debug("Begin: init()...");
		try{
			context = new ClassPathXmlApplicationContext(new String[]{"conf/applicationContext-context.xml", "conf/applicationContext-mvc.xml", "conf/applicationContext-mybatis.xml"});
			dao = context.getBean(UserFollowerDao.class);
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
