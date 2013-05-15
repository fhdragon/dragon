package org.apache.dragon.framework.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


/**
 * AppContextUtils: application context utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 1, 2013
 * @since 1.0
 */
public class AppContextUtils {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(AppContextUtils.class);
	/**
	 * application context
	 */
	@Autowired
	private static ApplicationContext context;
	

}
