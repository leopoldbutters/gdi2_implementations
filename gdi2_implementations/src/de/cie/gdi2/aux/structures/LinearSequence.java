package de.cie.gdi2.aux.structures;

public abstract class LinearSequence<K extends Comparable<K>> {

	/**
	 * @return returns length of sequence
	 */
	public abstract int number();

	/**
	 * @param k
	 *            item to be found
	 * @return returns true if the item was found
	 */
	public abstract boolean find(K k);

	/**
	 * @param k
	 *            item to be removed from list
	 * @return returns true if the item was successfully removed
	 */
	public abstract boolean remove(K k);

	/**
	 * @param l
	 *            search item by position
	 * @return return the item at position k
	 */
	public abstract K findAtPosition(int l);

	/**
	 * @param k
	 *            item to be inserted at tail
	 */
	public abstract void insertAtTail(K k);

	/**
	 * @param k
	 *            item to be inserted to list
	 * @param l
	 *            position of the item to be inserted
	 */
	public abstract void insertAtPosition(K k, int l);

}
