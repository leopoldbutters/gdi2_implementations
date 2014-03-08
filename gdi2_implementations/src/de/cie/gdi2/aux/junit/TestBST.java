package de.cie.gdi2.aux.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.cie.gdi2.tree.BinarySearchTree;
import de.cie.gdi2.tree.BinarySearchTreeItem;

public class TestBST {

	BinarySearchTree<Integer> bst;

	BinarySearchTreeItem<Integer> item1;
	BinarySearchTreeItem<Integer> item2;
	BinarySearchTreeItem<Integer> item3;
	BinarySearchTreeItem<Integer> item4;
	BinarySearchTreeItem<Integer> item5;
	BinarySearchTreeItem<Integer> item6;
	BinarySearchTreeItem<Integer> item7;

	@Before
	public void init() {
		item1 = new BinarySearchTreeItem<Integer>(1);
		item2 = new BinarySearchTreeItem<Integer>(2);
		item3 = new BinarySearchTreeItem<Integer>(3);
		item4 = new BinarySearchTreeItem<Integer>(4);
		item5 = new BinarySearchTreeItem<Integer>(5);
		item6 = new BinarySearchTreeItem<Integer>(6);
		item7 = new BinarySearchTreeItem<Integer>(7);

		bst = new BinarySearchTree<Integer>(item4);

		item4.left = item2;
		item4.right = item6;

		item2.left = item1;
		item2.right = item3;

		item6.left = item5;
		item6.right = item7;

	}

	@Test
	public void testFind() {
		assertTrue(bst.find(5));
		assertFalse(bst.find(8));
	}

	@Test
	public void testInsert() {
		assertFalse(bst.find(8));
		bst.insert(8);
		assertTrue(bst.find(8));
	}

	@Test
	public void testRemove() {
		assertTrue(bst.find(6));
		bst.remove(6);
		assertFalse(bst.find(6));
	}

	@Test
	public void testTraverse() {
		assertEquals(bst.traverse(), "1234567");
	}

	@After
	public void printAfter() {
		// BSTPrinter.printNode(bst);
	}

}
