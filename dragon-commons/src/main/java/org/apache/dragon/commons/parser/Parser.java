package org.apache.dragon.commons.parser;

/**
 * Parses I to instances of O.
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @since 3.0
 * @param <T> the type of object this Parser arg
 * @param <O> the type of object this Parser produces
 */
public interface Parser<I, O> {

	/**
	 * Parse in to produce a O.
	 * 
	 * @param in
	 * @return an instance of O
	 */
	O parse(I in);

}
