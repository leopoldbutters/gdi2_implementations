package de.cie.gdi2.list;

import de.cie.gdi2.aux.structures.LinearSequence;

public class LinkedList<K extends Comparable<K>> extends LinearSequence<K> {

	LinkedListItem<K> first;

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
		LinkedListItem<K> p = first;
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
		LinkedListItem<K> p = first;

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
	 * Auxiliary data: A pointer of type pointer to list item of type .
	 */
	@Override
	public boolean remove(K k) {

		// induction basis:
		LinkedListItem<K> p;
		if (first == null)
			return false;
		if (first.key == k) {
			first = first.next;
			return true;
		} else {
			p = first;
		}
		// induction step:
		while (true) {
			if (p.next == null) {
				return false;
			} else if (p.next.key == k) {
				p.next = p.next.next;
				return true;
			} else {
				p = p.next;
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
		LinkedListItem<K> p = first;
		int i = 0;

		// induction step:
		while (true) {
			if (!p.hasNext() || i + 1 == l)
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
	 * Auxiliary data: A pointer of type pointer to list item of type .
	 */
	@Override
	public void insertAtTail(K k) {

		// induction basis:
		LinkedListItem<K> p;
		if (first == null) {
			first = new LinkedListItem<K>(k, null);
			return;
		} else {
			p = first;
		}

		// induction step:
		while (true) {
			if (p.next == null) {
				p.next = new LinkedListItem<K>(k, null);
				return;
			} else {
				p = p.next;
			}
		}
	}

	/**
	 * Algorithmic problem: Linear sequence: insert at position
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: Two pointers, and , of type pointer to list item of type
	 * .
	 */
	@Override
	public void insertAtPosition(K k, int l) {
		// precondition: 0 <= l <= number()

		// induction basis:
		LinkedListItem<K> p;
		if (l == 0) {
			LinkedListItem<K> q = new LinkedListItem<K>(k, first);
			first = q;
			return;
		} else {
			p = first;
		}

		// induction step:
		int i = 0;
		while (true) {
			if (i + 1 == l) {
				LinkedListItem<K> q = new LinkedListItem<K>(k, p.next);
				p.next = q;
				return;
			} else {
				p = p.next;
				i++;
			}
		}
	}

	/**
	 * Auxiliary method: print
	 */
	public void print() {
		LinkedListItem<K> p = first;
		while (p != null) {
			System.out.print(p.key + " ");
			p = p.next;
		}
	}

}
