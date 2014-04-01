package org.apache.dragon.weixin.service;

import org.apache.dragon.weixin.model.QA;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * test for iq service
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Feb 23, 2014
 * @since 1.0
 */
public class IQServiceTest {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(IQServiceTest.class);
	/**
	 * context
	 */
	private static ApplicationContext context;
	/**
	 * service
	 */
	private static IQService service;
	
	//Logic
	/**
	 * test q for iq
	 */
	@Test
	public void q(){
		logger.debug("Begin: q()...");
		QA result = this.service.q(1);
		logger.debug("End: " + result);
	}
	
	/**
	 * init resources
	 */
	@BeforeClass
	public static void init(){
		logger.debug("Begin: init()...");
		try{
			context = new ClassPathXmlApplicationContext(new String[]{"conf/applicationContext-context.xml", "conf/applicationContext-mvc.xml", "conf/applicationContext-mybatis.xml", "conf/applicationContext-weixin.xml"});
			service = context.getBean(IQService.class);
		}catch(Exception e){
            e.printStackTrace();
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
