package de.cie.gdi2.aux.structures;

public interface Stack<K> {
	
	public void push(K k);
	
	public K pop();
	
	public K top();
	
	public boolean isEmpty();


}
