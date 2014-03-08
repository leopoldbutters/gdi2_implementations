package de.cie.gdi2.list;

public class DoublyLinkedListItem<K extends Comparable<K>> {

	K key;

	DoublyLinkedListItem<K> next;

	DoublyLinkedListItem<K> prev;

	public DoublyLinkedListItem(K key, DoublyLinkedListItem<K> next,
			DoublyLinkedListItem<K> prev) {
		this.key = key;
		this.next = next;
		this.prev = prev;
	}

}
