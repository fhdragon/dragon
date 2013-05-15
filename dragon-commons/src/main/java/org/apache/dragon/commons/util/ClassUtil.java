package org.apache.dragon.commons.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * ClassUtil：class utilities
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 1, 2013
 * @since 1.0
 * @see <a href="http://www.javaworld.com/javaworld/javaqa/2003-07/01-qa-0711-classsrc.html?page=1">Back to your Class
 *      roots</a>
 */
public final class ClassUtil {

	//Logic
	/**
	 * Given a Class object, attempts to find its .class location [returns null if no such definition can be found]. Use
	 * for testing/debugging only.
	 * 
	 * @param cls
	 * @return URL that points to the class definition [null if not found].
	 */
	public static URL getPath(@SuppressWarnings("rawtypes") final Class cls) {

		// check: throw e if cls is null
		if (cls == null)
			throw new IllegalArgumentException("null input: cls");

		// package to path
		final String clsAsResource = cls.getName().replace('.', '/').concat(".class");

		// get class pd
		final ProtectionDomain pd = cls.getProtectionDomain();
		URL result = null;// url
		// java.lang.Class contract does not specify if 'pd' can ever be null;
		// it is not the case for Sun's implementations, but guard against null
		// just in case:
		if (pd != null) {
			final CodeSource cs = pd.getCodeSource();
			// 'cs' can be null depending on the classloader behavior:
			if (cs != null)
				result = cs.getLocation();

			if (result != null) {
				// Convert a code source location into a full class file
				// location
				// for some common cases:
				if ("file".equals(result.getProtocol())) {
					try {
						if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip"))
							result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
						else if (new File(result.getFile()).isDirectory())
							result = new URL(result, clsAsResource);
					} catch (MalformedURLException ignore) {
					}
				}
			}
		}

		// result is null
		if (result == null) {
			// Try to find 'cls' definition as a resource; this is not
			// documented to be legal, but Sun's implementations seem to allow
			// this:
			final ClassLoader clsLoader = cls.getClassLoader();
			result = clsLoader != null ? clsLoader.getResource(clsAsResource) : ClassLoader
					.getSystemResource(clsAsResource);
		}

		return result;
	}

}
