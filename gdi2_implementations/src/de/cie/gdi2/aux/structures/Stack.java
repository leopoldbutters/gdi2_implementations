package de.cie.gdi2.aux.structures;

public interface Stack<K> {

	/**
	 * @param k
	 *            push k into stack
	 */
	public void push(K k);

	/**
	 * @return return the head of the stack and remove it
	 */
	public K pop();

	/**
	 * @return return the head of the stack
	 */
	public K top();

	/**
	 * @return returns true if the stack is empty
	 */
	public boolean isEmpty();

}
