package de.cie.gdi2.aux.structures;

public abstract class SortedSequence<K extends Comparable<K>> {
	
	public abstract void insert(K k);
	
	public abstract String traverse();
	
	public abstract boolean find(K k);
	
	public abstract boolean remove(K  k);


}
