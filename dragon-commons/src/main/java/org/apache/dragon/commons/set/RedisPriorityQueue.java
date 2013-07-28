package org.apache.dragon.commons.set;

import java.util.Set;

import org.apache.dragon.commons.io.KryoSerialize;
import org.apache.dragon.commons.io.Serialize;
import org.apache.dragon.commons.redis.RedisFactory;
import org.apache.dragon.commons.util.StringUtil;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;
import redis.clients.util.SafeEncoder;

/**
 * An unbounded priority {@linkplain Queue queue} based on redis. The elements of the priority queue are
 * ordered according to their score {@linkplain ScoreObj}. A priority queue does not permit {@code null} elements. 
 * 
 * <p>
 * The <em>head</em> of this queue is the <em>least</em> element with respect to the specified ordering. If multiple
 * elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily. The queue
 * retrieval operations {@code push}, {@code clear}, {@code peek}, and {@code pop} access the element at the head
 * of the queue.
 * 
 * <p>
 * <strong>Note that this implementation is synchronized.</strong> 
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/18
 * @since 1.0
 */
public class RedisPriorityQueue extends AbstractQueue<ScoreObj> implements java.io.Serializable {

	// local variables
	/**
	 * uid
	 */
	private static final long serialVersionUID = 7710105636604323922L;
	/**
	 * key
	 */
	private byte[] key;
	/**
	 * Serialize
	 */
	private static Serialize serialize = new KryoSerialize();
	/**
	 * redis factory
	 */
	private transient JedisPool pool = null;

	// Constructor
	/**
	 * Creates a {@code PriorityQueue} with the specified initial key that orders its elements according to their
	 * weight. default pool is {@link RedisFactory#getPool()}
	 * 
	 * @param key
	 *            the initial key for redis
	 * @throws IllegalArgumentException
	 *             if {@code initialCapacity} is less than 1
	 */
	public RedisPriorityQueue(String key) {
		this(key, RedisFactory.getPool());
	}
	/**
	 * Creates a {@code PriorityQueue} with the specified initial key that orders its elements according to their
	 * weight.
	 * 
	 * @param key
	 *            the initial key for redis
	 * @param pool the pool of redis
	 * @throws IllegalArgumentException
	 *             if {@code initialCapacity} is less than 1
	 */
	public RedisPriorityQueue(String key, JedisPool pool) {
		if(StringUtil.empty(key) || pool == null){
			
		}
		this.key = SafeEncoder.encode(key);
		this.pool = pool;
	}

	// Query Operations
	/**
	 * Returns the number of elements in this collection. If this collection contains more than
	 * <tt>Integer.MAX_VALUE</tt> elements, returns <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return the number of elements in this collection
	 * @see jp.gummy.bsns.ugc.search.util.AbstractQueue#size()
	 */
	@Override
	public int size() {
		//get redis from redis pool
		Jedis jedis = pool.getResource();
		long result = -1;
		try{
			//get size of queue
			result = jedis.zcard(key);
		}finally{
			//release resources
			pool.returnResource(jedis);
		}
		return (int)result;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns <tt>null</tt> if this queue is empty.
	 * 
	 * @return the head of this queue, or <tt>null</tt> if this queue is empty
	 * @throws RuntimeException if error 
	 */
	@Override
	public ScoreObj peek() {
		//get redis from redis pool
		BinaryJedis jedis = pool.getResource();
		Set<byte[]> s = null;
		try{
			//get first element from queue
			s = jedis.zrange(key, 0, 0);
		}finally{
			//release resources
			pool.returnResource(jedis); 
		}
		//handle result: default null
		ScoreObj result = null;
		if(s != null && s.size() > 0){
			//get byte[] value 
			byte[] bs = s.iterator().next();
			//deserialize bs to ScoreObj object
			result = serialize.read(bs);
		}
		return result;
	}

	/**
	 * Add the specified member having the specifeid score to the sorted set stored at key. If member is already a
	 * member of the sorted set the score is updated, and the element reinserted in the right position to ensure
	 * sorting. If key does not exist a new sorted set with the specified member as sole member is crated. If the key
	 * exists but does not hold a sorted set value an error is returned.
	 * <p>
	 * The score value can be the string representation of a double precision floating point number.
	 * <p>
	 * Time complexity O(log(N)) with N being the number of elements in the sorted set
	 * 
	 * @param key
	 * @param score
	 * @param value
	 * @return Integer reply, specifically: 1 if the new element was added 0 if the element was already a member of the
	 *         sorted set and the score was updated
	 */
	@Override
	public int push(ScoreObj e) {
		//get redis from redis pool
		BinaryJedis jedis = pool.getResource();
		long result = -1;
		try{
			//serialize object into byte[]
			byte[] bs = serialize.write(e);
			//push byte[] into redis
			result = jedis.zadd(key, e.getScores()[0], bs);
		}finally{
			//release resources
			pool.returnResource(jedis);
		}
		return (int)result;
	}
	

	/**
	 * Retrieves and removes the head of this queue, or returns <tt>null</tt> if this queue is empty.
	 * 
	 * @return the head of this queue, or <tt>null</tt> if this queue is empty
	 * @throws RuntimeException if error
	 */
	@Override
	public ScoreObj pop() {
		//get redis from redis pool
		BinaryJedis jedis = pool.getResource();
		Response<Set<byte[]>> r = null;
		try{
			//start transaction
			Transaction t = jedis.multi();
			//get the first element of queue
			r = t.zrange(key, 0, 0);
			//remove the first element of queue
			t.zremrangeByRank(key, 0, 0);
			//commit 
			t.exec();
		}finally{
			//release resources
			pool.returnResource(jedis); 
		}
		//handle result
		ScoreObj result = null;
		if(r.get() != null && r.get().size() > 0){
			//deserialize byte[] into object
			result = serialize.read(r.get().iterator().next());
		}
		return result;
	}
	
	/**
	 * Remove the specified member from this queue, If member was not a member of the set no operation is performed.
	 * 
	 * @param e
	 * @return
	 */
	@Override
	public int remove(ScoreObj e){
		//get redis from redis pool
		BinaryJedis jedis = pool.getResource();
		long result = -1;
		try{
			//serialize object into byte[]
			byte[] bs = serialize.write(e);
			//remove byte[] into redis
			result = jedis.zrem(key, bs);
		}finally{
			//release resources
			pool.returnResource(jedis);
		}
		return (int)result;
	}

}
