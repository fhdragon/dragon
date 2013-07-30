package org.apache.dragon.commons.redis;

import java.util.Map;

import static org.apache.dragon.commons.util.ResourceUtil.*;
import static org.apache.dragon.commons.util.StringUtil.*;
import org.apache.log4j.Logger;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * RedisFactory: redis factory
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 7, 2013
 * @since 1.0
 */
public class RedisFactory {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(RedisFactory.class);
	/**
	 * a jedis pool
	 */
	private static JedisPool pool;

	// Logic
	/**
	 * return a redis Pool
	 * 
	 * @return
	 */
	public static JedisPool getPool() {
		if(pool == null){
			synchronized (RedisFactory.class) {
				if(pool == null){
					load();
				}
			}
		}
		return pool;
	}

	/**
	 * load config for jedis
	 */
	public static void load() {
		logger.debug("Begin: load()...");
		String redisConfig = "redis.properties";
		String defaultRedisConfig = "/conf/_default_redis.properties";
		// load redis config
		Map<String, String> _configs = loadResource(redisConfig);
		logger.debug(redisConfig + " : " + _configs);
		// load default redis config
		Map<String, String> configs = loadResource(defaultRedisConfig);
		logger.debug(defaultRedisConfig + " : " + _configs);
		// merger config
		configs.putAll(_configs);
		logger.debug("configs : " + _configs);

		//populate config object
		JedisPoolConfig config = new JedisPoolConfig();
		int value = num(configs.get("redids.maxActive"), -1);
		if (value > 0) {
			config.setMaxActive(value);
		}
		value = num(configs.get("redids.maxIdle"), -1);
		if (value > 0) {
			config.setMaxIdle(value);
		}
		value = num(configs.get("redids.maxWait"), -1);
		if (value > 0) {
			config.setMaxWait(value);
		}
		value = num(configs.get("redids.minEvictableIdleTimeMillis"), -1);
		if (value > 0) {
			config.setMinEvictableIdleTimeMillis(value);
		}
		value = num(configs.get("redids.minIdle"), -1);
		if (value > 0) {
			config.setMinIdle(value);
		}
		value = num(configs.get("redids.numTestsPerEvictionRun"), -1);
		if (value > 0) {
			config.setNumTestsPerEvictionRun(value);
		}
		value = num(configs.get("redids.softMinEvictableIdleTimeMillis"), -1);
		if (value > 0) {
			config.setSoftMinEvictableIdleTimeMillis(value);
		}
		value = num(configs.get("redids.timeBetweenEvictionRunsMillis"), -1);
		if (value > 0) {
			config.setTimeBetweenEvictionRunsMillis(value);
		}
		value = num(configs.get("redids.whenExhaustedAction"), -1);
		if (value > 0) {
			config.setWhenExhaustedAction((byte) value);
		}
		config.setTestOnBorrow(Boolean.parseBoolean(configs.get("redis.testOnBorrow")));
		config.setTestOnReturn(Boolean.parseBoolean(configs.get("redis.testOnReturn")));
		config.setTestWhileIdle(Boolean.parseBoolean(configs.get("redis.testWhileIdle")));
		
		//init pool
		pool = new JedisPool(config, configs.get("redis.host"), num(configs.get("redis.port"), Protocol.DEFAULT_PORT));
		logger.debug("End: result = " + pool);
	}

}
