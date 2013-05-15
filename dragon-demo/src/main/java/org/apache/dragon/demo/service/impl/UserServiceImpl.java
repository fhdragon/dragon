package org.apache.dragon.demo.service.impl;

import org.apache.dragon.demo.dao.UserDao;
import org.apache.dragon.demo.model.User;
import org.apache.dragon.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * add, delete, update, select user service implementation
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 2, 2013
 * @since 1.0
 */
@Component
public class UserServiceImpl implements UserService {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	/**
	 * dao
	 */
	@Autowired
	private UserDao dao;

	//Logic
	/** 
	 * add a new user
	 * 
	 * @param user
	 * @return 
	 * @see f.h.dragon.demo.service.UserService#add(f.h.dragon.demo.model.User)
	 */
	@Override
	public int add(User user) {
		logger.debug("Begin: add(" + user + ")...");
		int result = this.dao.add(user);
		logger.debug("End: result = " + result);
		return result;
	}
	
	/** 
	 * select a user by id
	 * 
	 * @param user
	 * @return 
	 * @see f.h.dragon.demo.service.UserService#add(f.h.dragon.demo.model.User)
	 */
	@Override
	public User select(int id) {
		logger.debug("Begin: select(" + id + ")...");
		User result = this.dao.select(id);
		logger.debug("End: result = " + result);
		return result;
	}

}
