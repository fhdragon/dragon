package org.apache.dragon.commons.set;

import org.apache.dragon.commons.io.KryoSerialize;
import org.apache.dragon.commons.io.Serialize;
import org.apache.dragon.commons.redis.RedisFactory;
import org.apache.dragon.commons.util.StringUtil;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.SafeEncoder;

/**
 * An unbounded {@linkplain Queue queue} based on redis. The elements of the priority queue are
 * ordered according to their {@linkplain Comparable natural ordering}, or by a {@link Comparator} provided at queue
 * construction time, depending on which constructor is used. A priority queue does not permit {@code null} elements. A
 * priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may
 * result in {@code ClassCastException}).
 * 
 * <p>
 * The <em>head</em> of this queue is the <em>least</em> element with respect to the specified ordering. If multiple
 * elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily. The queue
 * retrieval operations {@code poll}, {@code remove}, {@code peek}, and {@code element} access the element at the head
 * of the queue.
 * 
 * <p>
 * A priority queue is unbounded, but has an internal <i>capacity</i> governing the size of an array used to store the
 * elements on the queue. It is always at least as large as the queue size. As elements are added to a priority queue,
 * its capacity grows automatically. The details of the growth policy are not specified.
 * 
 * <p>
 * This class and its iterator implement all of the <em>optional</em> methods of the {@link Collection} and
 * {@link Iterator} interfaces. The Iterator provided in method {@link #iterator()} is <em>not</em> guaranteed to
 * traverse the elements of the priority queue in any particular order. If you need ordered traversal, consider using
 * {@code Arrays.sort(pq.toArray())}.
 * 
 * <p>
 * <strong>Note that this implementation is not synchronized.</strong> Multiple threads should not access a
 * {@code PriorityQueue} instance concurrently if any of the threads modifies the queue. Instead, use the thread-safe
 * {@link java.util.concurrent.PriorityBlockingQueue} class.
 * 
 * <p>
 * This class is a member of the Java Collections Framework.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/18
 * @since 1.0
 */
public class RedisQueue<E> extends AbstractQueue<E> implements java.io.Serializable {

	// local variables
	/**
	 * uid
	 */
	private static final long serialVersionUID = 7710105636604323922L;
	/**
	 * redis pool
	 */
	private transient JedisPool pool;
	/**
	 * key
	 */
	private byte[] key;
	/**
	 * Serialize
	 */
	private static Serialize serialize = new KryoSerialize();

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
	public RedisQueue(String key) {
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
	public RedisQueue(String key, JedisPool pool) {
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
		Jedis jedis = pool.getResource();
		long result = jedis.zcard(key);
		pool.returnResource(jedis);
		return (int)result;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns <tt>null</tt> if this queue is empty.
	 * 
	 * @return the head of this queue, or <tt>null</tt> if this queue is empty
	 */
	@Override
	public E peek() {
		BinaryJedis jedis = pool.getResource();
		byte[] bs = jedis.get(key);
		E result = serialize.read(bs);
		pool.returnResource(jedis); 
		return result;
	}
	
	/**
	 * Retrieves and removes the head of this queue, or returns <tt>null</tt> if this queue is empty.
	 * 
	 * @return the head of this queue, or <tt>null</tt> if this queue is empty
	 */
	@Override
	public E pop() {
		BinaryJedis jedis = pool.getResource();
		byte[] bs = jedis.lpop(key);
		E result = serialize.read(bs);
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
	public int push(E e) {
		BinaryJedis jedis = pool.getResource();
		byte[] bs = serialize.write(e);
		long result = jedis.rpush(key, bs);
		pool.returnResource(jedis);
		return (int)result;
	}
	

	/**
	 * Remove the specified member from this queue, If member was not a member of the set no operation is performed.
	 * 
	 * @param e
	 * @return
	 */
	@Override
	public int remove(E e){
		//get redis from redis pool
		BinaryJedis jedis = pool.getResource();
		long result = -1;
		try{
			//serialize object into byte[]
			byte[] bs = serialize.write(e);
			//remove byte[] into redis
			result = jedis.lrem(key, 1, bs);
		}finally{
			//release resources
			pool.returnResource(jedis);
		}
		return (int)result;
	}

}
