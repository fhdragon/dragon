package org.apache.dragon.commons.set;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * EmptyMap: empty map
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 3, 2013
 * @since 1.0
 */
public final class EmptyMap<K, V> implements Map<K, V> {

	// Logic
	/**
	 * Returns the number of key-value mappings in this map. If the map contains more than <tt>Integer.MAX_VALUE</tt>
	 * elements, returns <tt>Integer.MAX_VALUE</tt>.
	 * 
	 * @return the number of key-value mappings in this map
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings
	 * 
	 * @return <tt>true</tt> if this map contains no key-value mappings
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the specified key. more formally, returns <tt>true</tt>
	 * if and only if this map contains a mapping for a key <tt>k</tt> such that
	 * <tt>key ==null ? k == null : key.equals(k)</tt>. (There can be at most one such mapping.)
	 * 
	 * @param key
	 *            key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified key
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	/**
	 * Returns <tt>true</tt> if this map maps one or more keys to the specified value. more formally, returns
	 * <tt>true</tt> if and only if this map contains at least one mapping to a value <tt>v</tt> such that
	 * <tt> value == null ? v == null : value.equals(v)</tt>. this operation will probably require time linear in this
	 * map size for most implementations of the <tt>Map> interface.
	 * 
	 * @param value
	 *            value whose presence this map is to be tested
	 * @return <tt>true</tt> if this map maps one or more keys to the specified value
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	/**
	 * Returns the value to which the specified key is mapped. or {@code null} if this map contains no mapping for the
	 * key.
	 * 
	 * <p>
	 * More formally, if this map contains a mapping from a key {@code k} to a value {@code v} such that
	 * {@code key == null ? k == null : key.equals(k)}, then this method returns {@code v}; otherwise it returns
	 * {@code null}. (There can be at most one such mapping.)
	 * 
	 * <p>
	 * If this map permits null values, then a return value of {@code null} does not <i>necessarily</i> indicate that
	 * the map contains no mapping for the key; it's also possible that the map explicitly maps the key to {@code null}.
	 * the {@link #containsKey(Object) containsKey} operation may be used to distinguish two cases.
	 * 
	 * @param key
	 *            the key whose associated the value is to be returned
	 * @return the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the
	 *         key
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public V get(Object key) {
		return null;
	}

	/**
	 * Associates the specified key to the specified value in this map(optional operation). If the map previously
	 * contained a mapping for the key, the old value is replaced by the specified value. (A map <tt>m</tt> is said to
	 * contain a mapping for a key <tt>k</tt> if and only if {@link #containsKey(Object) m.containsKey(k)} would return
	 * <tt>true</tt>.)
	 * 
	 * @param key
	 *            key with which the specified value is to be associated
	 * @param value
	 *            value to be associated with the specified key
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for
	 *         <tt>key</tt>. (A <tt>null</tt> return also indicate that the map previously associated <tt>null</tt> with
	 *         key, if the implementation supports <tt>null</tt> value.)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 * @throws UnsupportedOperationException
	 *             if the <tt>put</tt> operation is not supported by this map
	 */
	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the mapping for a key from this map if it is present(optional operation). More formally, if this map
	 * contains a mapping from key <tt>k</tt> to value <tt>v</tt> such that
	 * <code>key == null > k == null ? key.equals(k)</code>, that mapping is removed. (the map can contain at most one
	 * such mapping.)
	 * 
	 * <p>
	 * Returns the value to which this map previously associated the key, or <tt>null</tt> if this map contains no
	 * mapping for the key.
	 * 
	 * <p>
	 * If the map permits <tt>null</tt> values, then a return value of <tt>null</tt> does not <i>necessarily</i>
	 * indicates that the map contained no mapping for the key; it's also possible that the map explicitly mapped the
	 * key to <tt>null</tt>
	 * 
	 * <p>
	 * The map will not contain a mapping for the specified key once the call returns
	 * 
	 * @param key
	 *            key whose mapping is to be removed from the map
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for
	 *         <tt>key</tt>.
	 * @see java.util.Map#remove(java.lang.Object)
	 * @throws UnsupportedOperationException
	 *             if the <tt>remove</tt> operation is not supported by this map
	 */
	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Copies all of the mappings from the specified map to this map(option operation). The effect of this call is
	 * equivalent to that of calling {@link #put(Object, Object) put(k, v)} on this map once for each mapping from key
	 * <tt>k</tt> to value <tt>v</tt> in the specified map. the behavior of this operation is undefined if the specified
	 * map is modified while the operation is in progress.
	 * 
	 * @param m
	 *            mappings to be stored in this map
	 * @see java.util.Map#putAll(java.util.Map)
	 * @throws UnsupportedOperationException
	 *             if the <tt>putAll</tt> operation is not supported by this map
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes all of the mappings from this map(option operation), the map will be empty after this call returns.
	 * 
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		// do nothing
	}

	/**
	 * Returns a {@link Set} view of the keys contained in this map. The set is backed by the map, so changes to the map
	 * are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress
	 * (except through the iterator's own <tt>remove</tt> operation), the results of the iteration are undefined. The
	 * set supports element removal, which removes the corresponding mapping from the map, via the
	 * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
	 * operations. It does not support the <tt>add</tt> or <tt>addAll</tt> operations.
	 * 
	 * @return a set view of the keys contained in this map
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<K> keySet() {
		return new EmptySet<K>();
	}

	/**
	 * Returns a {@link Collection} view of the values contained in this map. The collection is backed by the map, so
	 * changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration
	 * over the collection is in progress (except through the iterator's own <tt>remove</tt> operation), the results of
	 * the iteration are undefined. The collection supports element removal, which removes the corresponding mapping
	 * from the map, via the <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>, <tt>removeAll</tt>,
	 * <tt>retainAll</tt> and <tt>clear</tt> operations. It does not support the <tt>add</tt> or <tt>addAll</tt>
	 * operations.
	 * 
	 * @return a collection view of the values contained in this map
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<V> values() {
		return new EmptySet<V>();
	}

	/**
	 * Returns a {@link Set} view of the mappings contained in this map. The set is backed by the map, so changes to the
	 * map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in
	 * progress (except through the iterator's own <tt>remove</tt> operation, or through the <tt>setValue</tt> operation
	 * on a map entry returned by the iterator) the results of the iteration are undefined. The set supports element
	 * removal, which removes the corresponding mapping from the map, via the <tt>Iterator.remove</tt>,
	 * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and <tt>clear</tt> operations. It does not support
	 * the <tt>add</tt> or <tt>addAll</tt> operations.
	 * 
	 * @return a set view of the mappings contained in this map
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return new EmptySet<java.util.Map.Entry<K, V>>();
	}

}
