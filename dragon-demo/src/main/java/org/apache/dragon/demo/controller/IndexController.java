package org.apache.dragon.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IndexController: default welcome page
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 1, 2013
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(IndexController.class);

	// Logic
	/**
	 * default welcome page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("Begin: index(" + model + ")...");
		String result = "index";
		logger.debug("End: result = " + result);
		return result;
	}

}
