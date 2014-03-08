package de.cie.gdi2.list;

import de.cie.gdi2.aux.structures.LinearSequence;

public class DoublyLinkedList<K extends Comparable<K>> extends
		LinearSequence<K> {

	DoublyLinkedListItem<K> first;

	DoublyLinkedListItem<K> last;

	/**
	 * Default Constructor
	 */
	public DoublyLinkedList(DoublyLinkedListItem<K> first) {
		this.first = first;
		this.last = first;
	}

	/**
	 * Algorithmic problem: Linear sequence: number
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data:
	 * 
	 * A pointer of type pointer to list item of type . A counter .
	 */
	@Override
	public int number() {

		// induction basis:
		DoublyLinkedListItem<K> p = first;
		int c = 0;

		// induction step:
		while (true) {
			if (p == null)
				return c;
			else {
				p = p.next;
				c = c + 1;
			}
		}
	}

	/**
	 * Algorithmic problem: Linear sequence: find
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type pointer to list item of type .
	 */
	@Override
	public boolean find(K k) {
		// induction basis:
		DoublyLinkedListItem<K> p = first;

		// induction step:
		while (true) {
			if (p == null)
				return false;
			else if (p.key == k)
				return true;
			else
				p = p.next;
		}
	}

	/**
	 * Algorithmic problem: Linear sequence: remove
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type pointer to a doubly-linked list item of
	 * type .
	 */
	@Override
	public boolean remove(K k) {

		// induction basis:
		DoublyLinkedListItem<K> p = null;
		if (first == null)
			return false;
		else
			p = first;

		// induction step:
		while (true) {
			if (p == null) {
				return false;
			} else if (p.key != k) {
				p = p.next;
			} else if (p.key == k && p != null) {
				if (p.prev == null) {
					first = p.next;
					first.prev = null;
				} else {
					p.prev.next = p.next;
				}
				if (p.next == null) {
					last = p.prev;
					last.next = null;
				} else {
					p.next.prev = p.prev;
				}
				return true;
			}
		}
	}

	/**
	 * Algorithmic problem: Linear sequence: find at position
	 * 
	 * Prerequisites:
	 * 
	 * Parameters: A position .
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data:
	 * 
	 * A pointer of type pointer to list item of type . A counter .
	 */
	@Override
	public K findAtPosition(int l) {

		// induction basis:
		DoublyLinkedListItem<K> p = first;
		int i = 0;

		// induction step:
		while (true) {
			if (p == null || i + 1 == l)
				return p.key;
			else {
				i++;
				p = p.next;
			}
		}
	}

	/**
	 * Algorithmic problem: Linear sequence: insert at tail
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: Two pointers, and , of type pointer to list item of type
	 * .
	 */
	@Override
	public void insertAtTail(K k) {

		// induction basis:
		DoublyLinkedListItem<K> p = null;
		if (first != null) {
			p = first;
		} else {
			DoublyLinkedListItem<K> q = new DoublyLinkedListItem<K>(k, null,
					null);
			first = q;
			last = q;
			return;
		}

		// induction step:
		while (true) {
			if (p.next != null) {
				p = p.next;
			} else {
				DoublyLinkedListItem<K> q = new DoublyLinkedListItem<K>(k,
						null, p);
				p.next = q;
				last = q;
				return;
			}
		}
	}

	/**
	 * Algorithmic problem: Linear sequence: insert at position
	 * 
	 * Prerequisites:
	 * 
	 * Parameters: A key , a position .
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: Two pointers, and , of type pointer to doubly-linked list
	 * item of type .
	 */
	@Override
	public void insertAtPosition(K k, int l) {

		// induction basis:
		DoublyLinkedListItem<K> p = null;
		if (l > 0) {
			p = first;
		} else {
			DoublyLinkedListItem<K> q = new DoublyLinkedListItem<K>(k, first,
					null);
			if (first != null)
				first.prev = q;
			first = q;
			if (last == null)
				last = first;
			return;
		}

		// induction step:
		int i = 0;
		while (true) {
			if (i + 1 < l) {
				p = p.next;
				i++;
			} else {
				DoublyLinkedListItem<K> q = new DoublyLinkedListItem<K>(k,
						p.next, p);
				p.next = q;
				if (q.next == null)
					last = q;
				else
					q.next.prev = q;
				return;
			}
		}

	}

	public void print() {
		DoublyLinkedListItem<K> p = first;
		while (p != null) {
			System.out.print(p.key + " ");
			p = p.next;
		}
	}

}
