package org.apache.dragon.commons.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class implements the interface IStorage. see {@link IStorage}
 * 
 * For example, the following method use it:
 * 
 * <pre class=code>
 * 
 * public void someMethod() {
 * 	Storage s = Storage.malloc();
 * 	s.put(1, 11);
 * 	s.put(&quot;1&quot;, &quot;22&quot;);
 * 	int i11 = s.get(1);// out: 11 --int
 * 	String s22 = s.get(&quot;1&quot;);// out:22 --String
 * }
 * </pre>
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/16
 * @since 1.0
 */
public abstract class Storage implements Serializable {

	// local variables
	/**
	 * Storage.java
	 */
	private static final long serialVersionUID = 5950250119646800888L;
	/**
	 * storage
	 */
	private static Map<String, Storage> storages = new HashMap<String, Storage>();

	// Logic
	/**
	 * get storage or malloc a new storage with the specified key
	 * 
	 * @param key
	 *            the specified key with storage
	 * @return
	 */
	public static Storage malloc(String key) {
		if (!storages.containsKey(key)) {
			synchronized (storages) {
				if (!storages.containsKey(key)) {
					storages.put(key, new StorageImpl());
				}
			}
		}
		return storages.get(key);
	}

	/**
	 * put key--value to store
	 * 
	 * @param <K>
	 * @param <V>
	 * @param key
	 * @param value
	 */
	public abstract <K, V> void put(K key, V value);

	/**
	 * get value from store
	 * 
	 * @param <K>
	 * @param <V>
	 * @param key
	 * @return
	 */
	public abstract <K, V> V get(K key);

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the specified key. More formally, returns <tt>true</tt>
	 * if and only if this map contains a mapping for a key <tt>k</tt> such that
	 * <tt>(key==null ? k==null : key.equals(k))</tt>. (There can be at most one such mapping.)
	 * 
	 * @param key
	 *            key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified key
	 * @throws ClassCastException
	 *             if the key is of an inappropriate type for this map (optional)
	 * @throws NullPointerException
	 *             if the specified key is null and this map does not permit null keys (optional)
	 */
	public abstract <T> boolean containsKey(T key);

	/**
	 * Returns an iterator over a set of elements of type T.
	 * 
	 * @return an Iterator.
	 */
	@SuppressWarnings("rawtypes")
	public abstract Iterator iterator();
	
	/**
	 * remove all storages from this storage
	 * 
	 */
	public static void clear(){
		storages.clear();
	}
	
	/**
	 * remove the specified storage from this storage
	 * 
	 * @param key the specified key to storage
	 * @return
	 */
	public static void clear(String key){
		storages.remove(key);
	}

	// inner class
	/**
	 * This class extends the class Storage. see {@link Storage}
	 * 
	 * For example, the following method use it:
	 * 
	 * <pre class=code>
	 * 
	 * public void someMethod() {
	 * 	Storage s = Storage.malloc("core");
	 * 	s.put(1, 11);
	 * 	s.put(&quot;1&quot;, &quot;22&quot;);
	 * 	int i11 = s.get(1);// out: 11 --int
	 * 	String s22 = s.get(&quot;1&quot;);// out:22 --String
	 * }
	 * </pre>
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2011/11/16
	 * @since 1.0
	 */
	public static class StorageImpl extends Storage {

		// local variables
		/**
		 * uid
		 */
		private static final long serialVersionUID = 5676215926082749930L;
		/**
		 * store
		 */
		private Map<Object, Object> store = new HashMap<Object, Object>();

		// Logic
		/**
		 * put key--value to store
		 * 
		 * @param <K>
		 * @param <V>
		 * @param key
		 * @param value
		 */
		@Override
		public <K, V> void put(K key, V value) {
			this.store.put(key, value);
		}

		/**
		 * get value from store
		 * 
		 * @param <K>
		 * @param <V>
		 * @param key
		 * @return
		 */
		@Override
		@SuppressWarnings("unchecked")
		public <K, V> V get(K key) {
			return (V) this.store.get(key);
		}

		/**
		 * Returns <tt>true</tt> if this map contains a mapping for the specified key. More formally, returns
		 * <tt>true</tt> if and only if this map contains a mapping for a key <tt>k</tt> such that
		 * <tt>(key==null ? k==null : key.equals(k))</tt>. (There can be at most one such mapping.)
		 * 
		 * @param key
		 *            key whose presence in this map is to be tested
		 * @return <tt>true</tt> if this map contains a mapping for the specified key
		 * @throws ClassCastException
		 *             if the key is of an inappropriate type for this map (optional)
		 * @throws NullPointerException
		 *             if the specified key is null and this map does not permit null keys (optional)
		 */
		public <T> boolean containsKey(T key) {
			return this.store.containsKey(key);
		}

		/**
		 * Returns an iterator over a set of key of type Object.
		 * 
		 * @return an Iterator.
		 */
		@SuppressWarnings("rawtypes")
		@Override
		public Iterator iterator() {
			return this.store.keySet().iterator();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final int maxLen = 100;
			return "Storage [store=" + (store != null ? toString(store.entrySet(), maxLen) : null) + "]";
		}

		private String toString(Collection<?> collection, int maxLen) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			int i = 0;
			for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
				if (i > 0)
					builder.append(", ");
				builder.append(iterator.next());
			}
			builder.append("]");
			return builder.toString();
		}

	}

}
