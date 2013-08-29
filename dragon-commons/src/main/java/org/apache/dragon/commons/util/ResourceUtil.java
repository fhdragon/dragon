package org.apache.dragon.commons.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 资源工具类：提供资源文件通用服务
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/10/24
 * @since 1.0
 */
public class ResourceUtil {

	/**
	 * 默认加载classpath下fn资源文件：根据文件后缀区分不同处理方式
	 * 
	 * @param fn 资源文件名称
	 * @return
	 */
	public static Map<String, String> parser(String fn) {
		// 从classpath下面加载资源文件
		Properties _props = new Properties();
		try {
			InputStream in = ResourceUtil.class.getResourceAsStream(fn);
			if(fn.endsWith(".properties")){
				_props.load(in);
			}else if(fn.endsWith(".xml")){
				_props.loadFromXML(in);
			}
		} catch (Exception e) {
//			throw new RuntimeException("load file err: " + fn, e);
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		for(Map.Entry<Object, Object> entry : _props.entrySet()){
			map.put((String)entry.getKey(), (String)entry.getValue());
		}
		return map;
	}

}
