package edu.nyu.cs9053.homework8;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class HashMultimap<K, V> extends AbstractMultimap<K, V> {

	public HashMultimap(HashMap<K, List<V>> hashMap) {
		super(hashMap);
	}

	@Override
	public boolean putItem(K key, V value) {
		if (map.get(key)==null) {
			map.put(key, new LinkedList<V>());
		}
		return map.get(key).add(value);
	}

	@Override
	public List<V> put(K key, List<V> value) {
		if (value instanceof LinkedList) {
			return map.put(key, value);
		}
		throw new IllegalArgumentException();
	}

}