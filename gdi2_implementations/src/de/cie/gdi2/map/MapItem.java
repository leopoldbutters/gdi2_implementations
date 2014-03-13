package de.cie.gdi2.map;

public class MapItem<K, V> {

	public K key;

	public V value;

	public MapItem(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
