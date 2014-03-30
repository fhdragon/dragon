package org.apache.dragon.weixin.controller;


import org.apache.dragon.weixin.model.Weixin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统计逻辑控制
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 06, 2014
 * @since 1.0
 */
@Controller
public class IndexController {

	// Local variables
	/**
	 * service
	 */
	@Autowired
//	private StatsService service;
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
	public @ResponseBody String index(Weixin model) {
		logger.debug("Begin: index(" + model + ")...");
		//check
		//return
		String result = model.getEchostr();
		logger.debug("End: result = " + result);
		return result;
	}

	/**
	 * default welcome page
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/nav/{page}", method = RequestMethod.GET)
	public String index(@PathVariable("page") String page) {
		logger.debug("Begin: index(" + page + ")...");
		String result = page;
		logger.debug("End: result = " + result);
		return result;
	}

}
