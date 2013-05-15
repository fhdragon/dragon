package org.apache.dragon.demo.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.Logger;

/**
 * Server: tomcat server
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 12, 2013
 * @since 1.0
 */
public class Server {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(Server.class);
	
	//Constructor
	/**
	 * Creates a new <code>Server</code> instance. Register a shutdown hook to do a clean shutdown 
	 */
	public Server(){
		Runtime.getRuntime().addShutdownHook(
			new Thread() {
				public void run(){
					stopServer();
				}
			}
		);
	}

	//test
	/**
	 * start test...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Server server = new Server();
		server.start();
	}
	
	//Logic
	/**
	 * 初始化服务，并启动
	 */
	public void start() {
		init();
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			logger.error("", e);
		}
		tomcat.getServer().await();
	}
	
	/**
	 * stop server and release resources
	 */
	public void stopServer(){
		try {
			tomcat.stop();
			tomcat.destroy();
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	/**
	 * init server
	 */
	private void init() {
		logger.debug("Begin: init()...");
		tomcat = new Tomcat();
		tomcat.setPort(PORT);
		try {
			tomcat.addWebapp(PATH, DOC_BASE);
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.debug("End!");
	}
	
	//local variables
	private Tomcat tomcat;
	private static final String PATH = "/";
	private static final String DOC_BASE = "/fhdragon/ws/gitws/repositories/fhdragon/fhdragon/demo/target/fhdragon-demo";
	private static final int PORT = 8080;
	

}
