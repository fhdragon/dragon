package org.apache.dragon.commons.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Date Utilities class
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/10/25
 * @since 1.0
 */
public final class DateUtil {

	/**
	 * format格式化date: 其中缓存date format提高效率
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		if (date != null && format != null) {
			SimpleDateFormat sdf = DATE_FORMATS.get(format);
			if (sdf == null) {
				sdf = new SimpleDateFormat(format);
				DATE_FORMATS.put(format, sdf);
			}
			return sdf.format(date);
		}
		return "";
	}
	
	/**
	 * format格式化date: 其中缓存date format提高效率
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static Date parse(String date, String format) {
		if (date != null && format != null) {
			SimpleDateFormat sdf = DATE_FORMATS.get(format);
			if (sdf == null) {
				sdf = new SimpleDateFormat(format);
				DATE_FORMATS.put(format, sdf);
			}
			try {
				return sdf.parse(date);
			} catch (Exception e) {
				//do nothing
			}
		}
		return null;
	}

	// Constants
	/**
	 * 时差：毫秒
	 */
	public final static long TIME_ZONE_OFF = Calendar.getInstance().getTimeZone()
			.getRawOffset();
	/**
	 * second In milliseconds
	 */
	public final static long SECOND_IN_MILLIS = 1000L;
	/**
	 * minute In milliseconds
	 */
	public final static long MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60L;
	/**
	 * hour In milliseconds
	 */
	public final static long HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
	/**
	 * day In milliseconds
	 */
	public final static long DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;
	/**
	 * date format
	 */
	private static Map<String, SimpleDateFormat> DATE_FORMATS = new HashMap<String, SimpleDateFormat>();

}
