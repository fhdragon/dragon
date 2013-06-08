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
	public static Map<String, String> loadResource(String fn) {
		if(fn.endsWith(".properties")){
			return loadProps(fn);
		}else if(fn.endsWith(".xml")){
			return loadXmls(fn);
		}
		return null;
	}
	
	/**
	 * 默认加载classpath下props资源文件
	 * 
	 * @param props
	 *            指定的.properties结构的文档
	 * @return
	 */
	public static Map<String, String> loadProps(String props) {
		// 从classpath下面加载资源文件
		Properties _props = new Properties();
		try {
			InputStream in = ResourceUtil.class.getResourceAsStream(props);
			_props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		for(Map.Entry<Object, Object> entry : _props.entrySet()){
			map.put((String)entry.getKey(), (String)entry.getValue());
		}
		return map;
	}
	
	/**
	 * 默认加载classpath下xmlFile配置文件
	 * 
	 * @param xmlFile
	 *            指定的xml结构的文档
	 * @return
	 */
	public static Map<String, String> loadXmls(String props) {
		Properties _props = new Properties();
		try {
			// 从classpath下面加载资源文件
			InputStream in = ResourceUtil.class.getResourceAsStream(props);
			_props.loadFromXML(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		for(Map.Entry<Object, Object> entry : _props.entrySet()){
			map.put((String)entry.getKey(), (String)entry.getValue());
		}
		return map;
	}

}
