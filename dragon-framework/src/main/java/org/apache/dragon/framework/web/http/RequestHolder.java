/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dragon.framework.web.http;

import javax.servlet.http.HttpServletRequest;

import org.apache.dragon.commons.set.Holder;
import org.apache.dragon.commons.set.ThreadHolder;

/**
 * Holder class to expose the web request in the form of a thread-bound
 * {@link HttpServletRequest} object. The request will be inherited
 * by any child threads spawned by the current thread if the
 * {@code inheritable} flag is set to {@code true}.
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 27, 2013
 * @since 1.0
 */
public abstract class RequestHolder {

	//local variables
	/**
	 * thread holder
	 */
	private static final Holder<HttpServletRequest> holder = new ThreadHolder<HttpServletRequest>();

	//Logic
	/**
	 * Reset the Request for the current thread.
	 */
	public static void remove() {
		holder.remove();
	}

	/**
	 * Bind the given HttpServletRequest to the current thread.
	 * @param req the HttpServletRequest to expose,
	 * or {@code null} to reset the thread-bound context
	 * @return
	 */
	public static void set(HttpServletRequest req) {
		holder.set(req);
	}

	/**
	 * Return the HttpServletRequest currently bound to the thread.
	 * @return the HttpServletRequest currently bound to the thread,
	 * or {@code null} if none bound
	 */
	public static HttpServletRequest get() {
		return holder.get();
	}

}
