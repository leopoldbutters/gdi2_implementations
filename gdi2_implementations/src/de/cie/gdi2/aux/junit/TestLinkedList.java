package de.cie.gdi2.aux.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.cie.gdi2.list.LinkedList;

public class TestLinkedList {

	LinkedList<Integer> list;

	@Before
	public void init() {
		list = new LinkedList<Integer>();
		list.insertAtPosition(4, 0);
		list.insertAtPosition(3, 0);
		list.insertAtPosition(2, 0);
		list.insertAtPosition(1, 0);
	}

	@Test
	public void testRemove() {
		assertEquals(list.find(4), true);
		list.remove(4);
		assertEquals(list.find(4), false);

		assertEquals(list.find(2), true);
		list.remove(2);
		assertEquals(list.find(2), false);
	}

	@Test(timeout = 1000)
	public void testInsertAtTail() {
		assertEquals(list.findAtPosition(list.number()), (Integer) 4);
		list.insertAtTail(5);
		assertEquals(list.findAtPosition(list.number()), (Integer) 5);
	}

	@Test
	public void testFind() {
		assertEquals(list.find(4), true);
		assertEquals(list.find(5), false);

		// find at position:
		assertEquals(list.findAtPosition(1), (Integer) 1);
		assertEquals(list.findAtPosition(2), (Integer) 2);
		assertEquals(list.findAtPosition(3), (Integer) 3);
	}

	@Test
	public void testInsertAtPosition() {
		assertEquals(list.number(), 4);
		list.insertAtPosition(5, 4);
		assertEquals(list.number(), 5);
	}

	@Test(timeout = 1000)
	public void testDuplicate() {
		assertEquals(list.number(), 4);
		list.duplicate();
		assertEquals(list.number(), 8);
	}

}
