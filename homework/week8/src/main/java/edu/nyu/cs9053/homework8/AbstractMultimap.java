package edu.nyu.cs9053.homework8;

import java.util.Collection;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
	protected final Map<K, List<V>> map;

	protected AbstractMultimap(Map<K, List<V>> map) {
		this.map = map;
	}

	@Override
	public boolean putItem(K key, V value) {
		if (map.get(key)==null) {
			map.put(key, new ArrayList<V>());
		}
		return map.get(key).add(value);
	}

	@Override
	public List<V> getItems(K key) {
		return map.get(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Set<Map.Entry<K, List<V>>> entrySet() {
		return map.entrySet();
	}

	@Override
	public boolean equals(Object o) {
		return map.equals(o);
	}

	@Override
	public List<V> get(Object key) {
		return map.get(key);
	}

	@Override
	public int hashCode() {
		return map.hashCode();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public List<V> put(K key, List<V> value) {
		return map.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends List<V>> m) {
		map.putAll(m);
	}

	@Override
	public List<V> remove(Object key) {
		return map.remove(key);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Collection<List<V>> values() {
		return map.values();
	}
}