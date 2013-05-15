package org.apache.dragon.demo.controller;

import java.util.Date;
import java.util.Random;

import org.apache.dragon.demo.model.User;
import org.apache.dragon.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * add, delete, update, select for user
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 2, 2013
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(UserController.class);
	/**
	 * service
	 */
	@Autowired
	private UserService service;

	// Logic
	/**
	 * add a new user
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		logger.debug("Begin: add(" + model + ")...");
		User user = new User();
		Random r = new Random();
		user.setId(r.nextInt(10000));
		user.setAge(30);
		user.setName("F.H Dragon");
		user.setBirthday(new Date());
		user.setSex(1);
		this.service.add(user);
		model.addAttribute("user", user);
		String result = "user";
		logger.debug("End: result = " + result);
		return result;
	}
	
	/**
	 * select a user
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String select(@PathVariable("id") int id, Model model) {
		logger.debug("Begin: select(" + id + ", " + model + ")...");
		User user = this.service.select(id);
		model.addAttribute("user", user);
		logger.debug("user = " + user);
		logger.debug("model = " + model);
		String result = "user";
		logger.debug("End: result = " + result);
		return result;
	}

}
