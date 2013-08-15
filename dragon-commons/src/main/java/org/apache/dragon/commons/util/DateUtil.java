package org.apache.dragon.commons.util;

import java.text.ParseException;
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

	//Logic
	/**
	 * format格式化date: 其中缓存date format提高效率
	 * 
	 * @param date
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
	 * 默认日期格式格式化date
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return YYYYMMDDHHMMSS.format(date);
	}
	
	/**
	 * format格式化date: 其中缓存date format提高效率
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parse(String date, String format) {
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
		return null;
	}
	
	/**
	 * format格式化date: 默认格式格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date parse(String date) {
		try {
			return YYYYMMDDHHMMSS.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * year是否闰年，是则返回true，否则false
	 * 
	 * @param year
	 * @return
	 */
	public static boolean leap(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	/**
	 * 返回年、月对应的天数，即该月最大日
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int maxDay(int year, int month){
		return DAYS_OF_MONTH[month == 2 && leap(year) ? 0 : month];
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
	/**
	 * default date format
	 */
	public static final SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 月天数:闰年2月在首位
	 */
	public static final int[] DAYS_OF_MONTH = {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

}
