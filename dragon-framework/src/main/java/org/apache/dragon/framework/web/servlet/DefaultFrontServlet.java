package org.apache.dragon.framework.web.servlet;
//package f.h.dragon.framework.web.servlet;
//
//import org.apache.log4j.Logger;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import static f.h.dragon.
//
///**
// * DefaultFrontServlet: TODO
// * 
// * @author Wenlong Meng(wenlong.meng@gmail.com)
// * @version 1.0 at May 14, 2013
// * @since 1.0
// */
//public class DefaultFrontServlet extends DispatcherServlet {
//
//	//Local variables
//	private static final long serialVersionUID = -3304865776232525894L;
//	/**
//	 * logger
//	 */
//	private static Logger logger = Logger.getLogger(DefaultFrontServlet.class);
//	private static String CONF_PATH = "";
//	
//	//Constructor
//	/**
//	 * Creates a new <code>DefaultFrontServlet</code> instance.
//	 * 
//	 * @see #DispatcherServlet
//	 */
//	public DefaultFrontServlet() {
//		super();
//	}
//	/**
//	 * Creates a new <code>DefaultFrontServlet</code> instance with webApplicationContext. 
//	 * 
//	 * @param webApplicationContext
//	 * @see #DispatcherServlet
//	 */
//	public DefaultFrontServlet(WebApplicationContext webApplicationContext) {
//		super(webApplicationContext);
//	}
//	
//	//setter and getter
//	/** 
//	  * TODO
//	  * @see org.springframework.web.servlet.FrameworkServlet#getContextConfigLocation()
//	  */
//	@Override
//	public String getContextConfigLocation() {
//		logger.debug("Begin: getContextConfigLocation()...");
//		String result = super.getContextConfigLocation();
//		result += + CONF_PATH;
//		// TODO Auto-generated method stub
//		return super.getContextConfigLocation();
//		logger.debug("End: result = " + result);
//	}
//	
//
//}
