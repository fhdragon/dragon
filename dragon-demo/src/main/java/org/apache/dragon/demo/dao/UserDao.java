package org.apache.dragon.demo.dao;

import org.apache.dragon.demo.model.User;
import org.springframework.stereotype.Component;

/**
 * select, delete, update, select user dao interface
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 2, 2013
 * @since 1.0
 */
@Component
public interface UserDao {

	//Logic
	/**
	 * add a new user
	 * 
	 * @param user
	 * @return
	 */
	int add(User user);
	
	/**
	 * select a user by id
	 * 
	 * @param user
	 * @return
	 */
	User select(int id);
	
}
