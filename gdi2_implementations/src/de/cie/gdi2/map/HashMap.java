package de.cie.gdi2.map;

import java.util.Comparator;

import de.cie.gdi2.aux.BoundedMap;

public class HashMap<K, V> implements BoundedMap<K, V> {

	MapItem<K, V>[] table;
	
	int n;
	
	Comparator<K> cmp;

	@SuppressWarnings("unchecked")
	public HashMap(int nMax, Comparator<K> cmp) {
		this.table = new MapItem[nMax];
		this.cmp = cmp;
	}

	@Override
	public V find(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V insert(K k, V v) {
		// TODO Auto-generated method stub
		return null;
	}

}
