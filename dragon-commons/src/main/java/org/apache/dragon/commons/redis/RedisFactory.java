package org.apache.dragon.commons.redis;

import org.apache.log4j.Logger;

import redis.clients.jedis.JedisPool;

/**
 * RedisFactory: redis factory
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 7, 2013
 * @since 1.0
 */
public class RedisFactory {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(RedisFactory.class);
	
	//Logic
	/**
	 * return a redis Pool
	 * 
	 * @return
	 */
	public static JedisPool getPool(){
		return null;
	}

}
