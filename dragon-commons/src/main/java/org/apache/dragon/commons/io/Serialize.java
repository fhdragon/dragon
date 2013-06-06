package org.apache.dragon.commons.io;

/**
 * Serialize 序列化接口
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-6-6
 * @since 1.0
 */
public interface Serialize {
	
	//Logic
	/**
	 * 序列化o为字节数组
	 * 
	 * @param o
	 * @return
	 */
	<T> byte[] serialize(T o);

	/**
	 * 反序列化bs为t类型对象
	 * 
	 * @param <T>
	 * @param bs
	 * @param t
	 * @return
	 */
	<T> T deserialize(byte[] bs, Class<T> t);

}
