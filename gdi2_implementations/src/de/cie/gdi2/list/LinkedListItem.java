package de.cie.gdi2.list;

public class LinkedListItem<K> {

	K key;

	LinkedListItem<K> next;

	/**
	 * Constructor:
	 * 
	 * @param key
	 * @param next
	 */
	public LinkedListItem(K key, LinkedListItem<K> next) {
		this.key = key;
		this.next = next;
	}

	/**
	 * Auxiliary method: hasNext
	 * 
	 * @return boolean
	 */
	public boolean hasNext() {
		return this.next != null;
	}

}
