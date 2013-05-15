package org.apache.dragon.commons.io;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Out: utility for out（see {@link System#out})
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Mar 28, 2013
 * @since 1.0
 */
public class Out {

	// Local variables
	/**
	 * see {@link System#out}
	 */
	private static final PrintStream out = System.out;

	// Logic
	/**
	 * Prints an object(eg. array, string, primitive type, etc.). The string produced by the <code>{@link
	 * PrintStream#print(Object)}</code>and/or <code>{@link Arrays#toString(Object[])}</code> method is translated into
	 * bytes according to the platform's default character encoding, and these bytes are written in exactly the manner
	 * of the <code>{@link PrintStream#print(Object)}</code> method.
	 * 
	 * @param obj
	 *            The <code>Object</code> to be printed
	 * @see java.lang.Object#toString()
	 */
	public static void out(Object obj) {
		if (obj != null && obj.getClass().isArray()) {
			String type = obj.getClass().getSimpleName().intern();
			// array: primitive type
			if (type == "byte[]") {
				out.print(Arrays.toString((byte[]) obj));
			} else if (type == "char[]") {
				out.print((char[]) obj);
			} else if (type == "short[]") {
				out.print(Arrays.toString((short[]) obj));
			} else if (type == "int[]") {
				out.print(Arrays.toString((int[]) obj));
			} else if (type == "float[]") {
				out.print(Arrays.toString((float[]) obj));
			} else if (type == "double[]") {
				out.print(Arrays.toString((double[]) obj));
			} else if (type == "long[]") {
				out.print(Arrays.toString((long[]) obj));
			} else if (type == "boolean[]") {
				out.print(Arrays.toString((boolean[]) obj));
				// array: other--wrap class, object, etc.
			} else {
				out.print(Arrays.toString((Object[]) obj));
			}
			// other object: non array
		} else {
			out.print(obj);
		}
	}

	/**
	 * Prints an object(eg. array, string, primitive type, etc.) and then terminate the line. The string produced by the
	 * <code>{@link
	 * PrintStream#println(Object)}</code>and/or <code>{@link Arrays#toString(Object[])}</code> method is translated
	 * into bytes according to the platform's default character encoding, and these bytes are written in exactly the
	 * manner of the <code>{@link PrintStream#println(Object)}</code> method.
	 * 
	 * @param obj
	 *            The <code>Object</code> to be printed
	 * @see java.lang.Object#toString()
	 */
	public static void outln(Object obj) {
		out(obj);
		outln();
	}

	/**
	 * Terminates the current line by writing the line separator string. The line separator string is defined by the
	 * system property <code>line.separator</code>, and is not necessarily a single newline character (<code>'\n'</code>
	 * ).
	 * 
	 * @see {@link PrintStream#println()}
	 */
	public static void outln() {
		out.println();
	}

}
