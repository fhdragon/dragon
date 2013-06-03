package org.apache.dragon.login.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * LoginController: 登录、退出等相关逻辑处理
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 3, 2013
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	//Logic
	/**
	 * 默认跳转至登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		logger.debug("Begin: index()...");
		String result = "login";
		logger.debug("End: result = " + result);
		return result;
	}
	
	/**
	 * 登录相关逻辑处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String name, String password){
		logger.debug("Begin: login(" + name + ", " + password + ")...");
		String result = "index";
		logger.debug("End: result = " + result);
		return result;
	}
	
	/**
	 * 退出相关逻辑处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(){
		logger.debug("Begin: logout()...");
		String result = "index";
		logger.debug("End: result = " + result);
		return result;
	}

}
