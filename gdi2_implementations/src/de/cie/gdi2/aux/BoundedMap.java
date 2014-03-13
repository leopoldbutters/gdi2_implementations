package de.cie.gdi2.aux;

public interface BoundedMap<K, V> {
	
	public V find(K k);
	
	public V insert(K k, V v);

}
