package de.cie.gdi2.tree;

public class BinarySearchTreeItem<K extends Comparable<?>> {

	K key;

	public BinarySearchTreeItem<K> left;

	public BinarySearchTreeItem<K> right;

	public BinarySearchTreeItem(K key) {
		this.key = key;
	}


}
