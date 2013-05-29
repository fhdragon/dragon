package org.apache.dragon.commons.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * FullMap: isEmpty() -> false
 * 			containsKey() -> true
 * 			containsValue() -> true
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-3-15
 * @since 1.0
 */
public class FullMap<K, V> implements Map<K, V>, Serializable {

	// Local variables
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	//Logic
	/**
	 * Returns <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return the number of key-value mappings in this map
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns <tt>false</tt>
	 * 
	 * @return <tt>false</tt>
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Returns <tt>true</tt>
	 * 
	 * @param key
	 *            key whose presence in this map is to be tested
	 * @return <tt>true</tt>
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return true;
	}

	/**
	 * Returns <tt>true</tt>
	 * 
	 * @param value
	 *            value whose presence in this map is to be tested
	 * @return <tt>true</tt>
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		return true;
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @param key
	 *            the key whose associated value is to be returned
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public V get(Object key) {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#put(java.lang.Object)
	 */
	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @param key
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @param key
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#putAll(java.lang.Object)
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#clear(java.lang.Object)
	 */
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#keySet(java.lang.Object)
	 */
	@Override
	public Set<K> keySet() {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#keySet(java.lang.Object)
	 */
	@Override
	public Collection<V> values() {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw UnsupportedOperationException
	 * 
	 * @return
	 * @throws UnsupportedOperationException
	 * @see java.util.Map#keySet(java.lang.Object)
	 */
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

}
