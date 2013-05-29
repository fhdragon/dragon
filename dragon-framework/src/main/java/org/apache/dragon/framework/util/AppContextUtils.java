package org.apache.dragon.framework.util;

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
	 * auto wired application context
	 */
	@Autowired
	private static ApplicationContext context;
	
	//Logic
	/**
	 * Return the bean instance that uniquely matches the given object type, if any.
	 * 
	 * @param type type the bean must match; can be an interface or superclass. null is disallowed.
	 * @return an instance of the single bean matching the required type
	 */
	public static <T> T bean(Class<T> type){
		return context.getBean(type);
	}
	
	/**
	 * Return an instance, which may be shared or independent, of the specified bean.
	 * 
	 * @param name the name of the bean to retrieve
	 * @return an instance of the bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T bean(String name){
		return (T)context.getBean(name);
	}
	
	/**
	 * Find the root WebApplicationContext for this web application, which is typically loaded via {@link org.springframework.web.context.ContextLoaderListener}
	 * 
	 * @return
	 */
	public static ApplicationContext getContext(){
		return context;
	}

}
