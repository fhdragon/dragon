package org.apache.dragon.commons.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.apache.dragon.commons.util.CloseUtil.*;

/**
 * serialize java pojo with java
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-6-6
 * @since 1.0
 */
public class DefaultSerialize implements Serialize {
	
	//local variables

	//Logic
	/**
	 * 序列化o为字节数组
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public <T> byte[] write(T o) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(baos);
			output.writeObject(o);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			close(output);
			close(baos);
		}
		byte[] result = baos.toByteArray();
		return result;
	}

	/**
	 * 反序列化bs为t类型对象
	 * 
	 * @param <T>
	 * @param bs
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T read(byte[] bs, Class<T> t){
		ByteArrayInputStream baos = new ByteArrayInputStream(bs);
		ObjectInputStream input = null;
		T result = null;
		try {
			input = new ObjectInputStream(baos);
			result = ((T) input.readObject());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			close(input);
		}
		return result;
	}
	
}
