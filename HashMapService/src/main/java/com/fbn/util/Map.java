package com.fbn.util;

public interface Map<K,V> {
	


	/**
	 * Method returns value corresponding to key.
	 * @param key
	 */
	public V get(K key);
	
	/**
	 * Method allows you put key-value pair in HashMapCustom.
	 * If the map already contains a mapping for the key, the old value is replaced.
	 * Note: method does not allows you to put null key though it allows null values.
	 * Implementation allows you to put custom objects as a key as well.
	 * Key Features: implementation provides you with following features:-
	 *     >provide complete functionality how to override equals method.
	 *  >provide complete functionality how to override hashCode method.
	 * @param newKey
	 * @param data
	 */
	public void put(K newKey, V data);
	
	/**
	 * Method removes key-value pair from HashMapCustom.
	 * @param key
	 */
	public boolean remove(K deleteKey);	


}