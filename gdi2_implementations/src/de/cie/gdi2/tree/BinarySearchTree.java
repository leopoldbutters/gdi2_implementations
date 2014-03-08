package de.cie.gdi2.tree;

import java.util.LinkedList;

import de.cie.gdi2.aux.structures.SortedSequence;
import de.cie.gdi2.aux.structures.Stack;

public class BinarySearchTree<K extends Comparable<K>> extends
		SortedSequence<K> {

	public BinarySearchTreeItem<K> root;

	public BinarySearchTree(BinarySearchTreeItem<K> root) {
		this.root = root;
	}

	/**
	 * Algorithmic problem: Sorted sequence: insert
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type
	 * "pointer to binary search tree node of type ".
	 */
	@Override
	public void insert(K k) {

		// induction basis:
		BinarySearchTreeItem<K> p;
		if (root == null) {
			p = new BinarySearchTreeItem<K>(k);
			p.left = null;
			p.right = null;
		} else {
			p = root;
		}

		// induction step:
		while (true) {
			if (p.key == k) {
				if (p.left == null) {
					p.left = new BinarySearchTreeItem<K>(k);
					p.left.left = null;
					p.left.right = null;
					break;
				} else if (p.right == null) {
					p.right = new BinarySearchTreeItem<K>(k);
					p.right.left = null;
					p.right.right = null;
					break;
				} else {
					p = p.left;
				}
			} else if ((Integer) p.key > (Integer) k) {
				if (p.left == null) {
					p.left = new BinarySearchTreeItem<K>(k);
					p.left.left = null;
					p.left.right = null;
					break;
				} else {
					p = p.left;
				}
			} else if ((Integer) p.key < (Integer) k) {
				if (p.right == null) {
					p.right = new BinarySearchTreeItem<K>(k);
					p.right.left = null;
					p.right.right = null;
					break;
				} else {
					p = p.right;
				}
			}
		}
	}

	/**
	 * Algorithmic problem: Sorted sequence: traverse
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data:
	 * 
	 * A stack whose elements are pairs consisting of a natural number in the
	 * range and a binary search tree node . Pointers and to stack elements.
	 */
	@Override
	public String traverse() {
		StackBST stack = new StackBST();
		StringBuilder l = new StringBuilder();

		// induction basis:
		StackBSTelem elem = new StackBSTelem(0, root);
		stack.push(elem);

		// induction step:
		BinarySearchTreeItem<K> node;
		while (true) {
			elem = stack.top();
			node = elem.node;
			if (elem.seenChildren == 0) {
				if (node.left != null) {
					StackBSTelem elem2 = new StackBSTelem(0, node.left);
					stack.push(elem2);
				} else {
					elem.seenChildren = 1;
					l.append(elem.node.key);
				}
			} else if (elem.seenChildren == 1) {
				if (node.right != null) {
					StackBSTelem elem2 = new StackBSTelem(0, node.right);
					stack.push(elem2);
				} else {
					elem.seenChildren = 2;
				}
			} else if (elem.seenChildren == 2) {
				stack.pop();
				if (stack.isEmpty()) {
					return l.toString();
				}
				elem = stack.top();
				elem.seenChildren += 1;
				if (elem.seenChildren == 1 && elem.node.left != null) {
					l.append(elem.node.key);
				}
			}
		}
	}

	/**
	 * Algorithmic problem: Sorted sequence: find
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type
	 * "pointer to binary search tree node of type ".
	 */
	@Override
	public boolean find(K k) {

		// induction basis:
		BinarySearchTreeItem<K> p = root;

		// induction step:
		while (true) {
			if (p == null)
				return false;
			else if (p.key == k)
				return true;
			else {
				if ((Integer) k < (Integer) p.key)
					p = p.left;
				else if ((Integer) k > (Integer) p.key)
					p = p.right;
			}
		}
	}

	/**
	 * Algorithmic problem: Sorted sequence: remove
	 * 
	 * Prerequisites:
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type "pointer to binary search tree node".
	 */
	@Override
	public boolean remove(K k) {

		// induction basis:
		BinarySearchTreeItem<K> p;
		if (root.key == k) {
			if (root.left == null)
				root = root.right;
			else if (root.right == null)
				root = root.left;
			else
				removeNode(root);
			return true;
		} else {
			p = root;
		}

		// induction step:
		while (true) {
			if ((Integer) k < (Integer) p.key) {
				if (p.left == null) {
					return false;
				} else if (p.left.key == k) {
					if (p.left.left == null)
						p.left = p.left.right;
					else if (p.left.right == null)
						p.left = p.left.left;
					else {
						removeNode(p.left);
						return true;
					}
				} else {
					p = p.left;
				}
			} else if ((Integer) k > (Integer) p.key) {
				if (p.right == null) {
					return false;
				} else if (p.right.key == k) {
					if (p.right.left == null)
						p.right = p.right.right;
					else if (p.right.right == null)
						p.right = p.right.left;
					else {
						removeNode(p.right);
						return true;
					}
				} else {
					p = p.right;
				}
			}
		}

	}

	/**
	 * Algorithmic problem: See the remark clause of Binary search tree; pointer
	 * as defined there is the input.
	 * 
	 * Prerequisites: p.left != void
	 * 
	 * Type of algorithm: loop
	 * 
	 * Auxiliary data: A pointer of type "pointer to a binary search tree node".
	 * 
	 * @param root
	 */
	private void removeNode(BinarySearchTreeItem<K> p) {

		// induction basis:
		BinarySearchTreeItem<K> q;
		if (p.left.right == null) {
			p.key = p.left.key;
			p.left = p.left.left;
			return;
		} else {
			q = p.left;
		}

		// induction step:
		while (true) {
			if (q.right.right == null) {
				p.key = q.right.key;
				q.right = q.right.left;
				break;
			} else {
				q = q.right;
			}
		}
	}

	class StackBST implements Stack<StackBSTelem> {

		java.util.LinkedList<StackBSTelem> list;
		public StackBST() {
			this.list = new LinkedList<StackBSTelem>();
		}

		@Override
		public void push(StackBSTelem k) {
			this.list.addLast(k);
		}

		@Override
		public StackBSTelem pop() {
			return this.list.removeLast();
		}

		@Override
		public StackBSTelem top() {
			return this.list.getLast();
		}

		@Override
		public boolean isEmpty() {
			return this.list.isEmpty();
		}

	}

	class StackBSTelem {

		int seenChildren;
		BinarySearchTreeItem<K> node;

		public StackBSTelem(int seenChildren, BinarySearchTreeItem<K> node) {
			this.seenChildren = seenChildren;
			this.node = node;
		}

	}
}
