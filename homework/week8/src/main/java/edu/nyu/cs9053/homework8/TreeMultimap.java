package edu.nyu.cs9053.homework8;

import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class TreeMultimap<K, V> extends AbstractMultimap<K, V> {
	
	public TreeMultimap(TreeMap<K, List<V>> treeMap) {
		super(treeMap);
	}

	@Override

	public List<V> put(K key, List<V> value) {
		if (value instanceof ArrayList) {
			return map.put(key, value);
		}
		throw new IllegalArgumentException();
	}
}