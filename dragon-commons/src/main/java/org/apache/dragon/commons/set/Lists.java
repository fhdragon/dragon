package org.apache.dragon.commons.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Lists: list utilities class
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class Lists {

	//Local variables
	
	//Logic
	/**
	 * sort for list
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> sort(List<T> list){
		return new ArrayList<T>(new TreeSet<T>(list));
	}
	
	/**
	 * sort for list
	 * 
	 * @param list
	 * @param comparator
	 * @return
	 */
	public static <T> List<T> sort(List<T> list, Comparator<? super T> comparator){
		Set<T> ts = new TreeSet<T>(comparator);
		ts.addAll(list);
		return new ArrayList<T>(ts);
	}

}
