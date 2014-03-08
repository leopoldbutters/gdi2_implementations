package de.cie.gdi2.aux.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.cie.gdi2.list.DoublyLinkedList;

public class TestDoublyList {

	DoublyLinkedList<Integer> list;

	@Before
	public void init() {

		list = new DoublyLinkedList<Integer>(null);
		list.insertAtPosition(5, 0);
		list.insertAtPosition(4, 0);
		list.insertAtPosition(3, 0);
		list.insertAtPosition(2, 0);
		list.insertAtPosition(1, 0);
	}

	@Test
	public void testInsertAtPosition() {
		assertFalse(list.find(9));
		list.insertAtPosition(9, 1);
		assertTrue(list.find(9));

	}

	@Test(timeout = 100)
	public void testInsertAtTail() {
		assertFalse(list.find(99));
		list.insertAtTail(99);
		assertTrue(list.find(99));
	}

	@Test
	public void testRemove() {
		for (int i = 2; i < 5; i++) {
			assertTrue(list.find(i));
			list.remove(i);
			assertFalse(list.find(i));
		}
	}

}
