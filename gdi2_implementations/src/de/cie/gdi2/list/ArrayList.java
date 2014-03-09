package de.cie.gdi2.list;

import de.cie.gdi2.aux.structures.LinearSequence;

public class ArrayList<K extends Comparable<K>> extends LinearSequence<K> {

	/****************** ATTRIBUTES ******************/

	private LinkedList<ArrayListItem<K>> list;

	private int N;

	/************************************************/

	/**
	 * Constructor
	 * 
	 * @param N
	 *            fixed number N is size of array
	 */
	public ArrayList(int N) {
		this.list = new LinkedList<ArrayListItem<K>>();
		this.N = N;
	}

	@Override
	public int number() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Algorithmic problem: Linear sequence: find
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type
	 * "pointer to list item of array lists of component type ".
	 */
	@Override
	public boolean find(K k) {

		// induction basis:
		LinkedListItem<ArrayListItem<K>> p = list.first;

		// induction step:
		while (true) {
			if (p == null) {
				return false;
			} else {
				for (int i = 0; i < p.key.n; i++) {
					if (p.key.array[i] == k) {
						return true;
					}
				}
			}
			p = p.next;
		}
	}

	@Override
	public boolean remove(K k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public K findAtPosition(int l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public void insertAtTail(K k) {
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
	 * Auxiliary data:
	 * 
	 * A natural number sum, which contains the total number of all elements
	 * seen so far in the visited arrays. Two pointers, and , of type
	 * "pointer to list item of type array of component type ".
	 */
	@Override
	public void insertAtPosition(K k, int l) {

		// induction basis:
		LinkedListItem<ArrayListItem<K>> p = list.first;
		int sum = 0;
		
		// induction step:
		while(true) {
			if(sum + p.key.n < l) {
				sum += p.key.n;
				p = p.next;
			} else {
				if(p.key.n == N) {
					// TODO
					// K[] f = new K[N];
					// ArrayListItem<K> q = new ArrayListItem<>(new K[N], n)
				}
			}
		}
	}

}
