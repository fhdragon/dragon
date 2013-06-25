package org.apache.dragon.demo.dao;

import org.apache.dragon.demo.model.UserFollower;
import org.springframework.stereotype.Component;

/**
 * select, delete, update, select user follower dao interface
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 2, 2013
 * @since 1.0
 */
@Component
public interface UserFollowerDao {

	//Logic
	/**
	 * add a new user
	 * 
	 * @param user
	 * @return
	 */
	int add(UserFollower userFollower);
	
	/**
	 * select a user by id
	 * 
	 * @param user
	 * @return
	 */
	UserFollower select(int id);
	
}
