package org.apache.dragon.commons.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

import static f.h.dragon.commons.util.StringUtil.*;

/**
 * server utilities：support get local ip, check ip. etc
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 9, 2013
 * @since 1.0
 */
public final class ServerUtil {

	//local variables
	/**
	 * cache InetAddress
	 */
	private static InetAddress inetAddress;
	/**
	 * bit flag: 1000(8) - ip4; 100000(32) - ip6
	 */
	private static int flagIP = 0X8;

	//Logic
	/**
	 * get local ip
	 * 
	 * @return
	 */
	public final static String ip() {
		// first call: 
		if(inetAddress == null){
			String osName = System.getProperty("os.name").toUpperCase();
			try{
				//for linux and unix
				if(osName.indexOf("NIX") > -1 || osName.indexOf("NUX") > -1){
					Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
					while(e.hasMoreElements()){
						NetworkInterface ni = (NetworkInterface)e.nextElement();
						Enumeration<InetAddress> ias = ni.getInetAddresses();
						for(InetAddress ia : Collections.list(ias)){
							if(!ia.isLoopbackAddress()){
								if(((flagIP & 0X8) > 0 && ia instanceof Inet4Address) || ((flagIP & 0X20) > 0 && ia instanceof Inet6Address)){
									inetAddress = ia;
								}
							}
						}
					}
				//for Windwos and OS X it should work well
				}else{
					inetAddress = InetAddress.getLocalHost();
				}
			}catch(Exception e){
				//check exception -> uncheck exception
				throw new RuntimeException(e);
			}
		}
		return inetAddress.getHostAddress();
	}
	
	/**
	 * ip: 验证字符串是否为合法ip(xxx.xxx.xxx.xxx)，若是则返回true; 否则返回false
	 * 
	 * @param ip 待验证字符串
	 * @return
	 */
	public static boolean ip(String ip) {
		String[] _ips = ip.split("\\.");
		if(_ips.length != 4){
			return false;
		}
		int i = 0;
		for(String _ip : _ips){
			i = num(_ip, -1);
			if(i > 255 && i < 0){
				return false;
			}
		}
		return true;
	}

}
