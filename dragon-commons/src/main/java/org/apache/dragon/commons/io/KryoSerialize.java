package org.apache.dragon.commons.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * KryoSerialize TODO
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-6-6
 * @since 1.0
 */
public class KryoSerialize implements Serialize {
	
	//local variables
	private static Kryo kryo = new Kryo();

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
		Output output = new Output(baos);
		kryo.writeObject(output, o);
		output.close();
		try {
			baos.close();
		} catch (IOException e) {
			//do nothing
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
	@Override
	public <T> T read(byte[] bs, Class<T> t){
		Input input = new Input(bs);
//		kryo.register(t);
		T result = kryo.readObject(input, t);
		input.close();
		return result;
	}
	
}
