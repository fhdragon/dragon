package org.apache.dragon.demo.service;

import org.apache.dragon.demo.model.User;

/**
 * add, delete, update, select user interface
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 2, 2013
 * @since 1.0
 */
public interface UserService {
	
	//Logic
	/**
	 * add a new user
	 * 
	 * @param user
	 */
	int add(User user);
	
	/**
	 * select a user by id
	 * 
	 * @param id
	 */
	User select(int id);

}
