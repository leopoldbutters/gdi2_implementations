package de.cie.gdi2.list;

public class ArrayListItem<K> implements Comparable<ArrayListItem<K>> {

	K[] array;
	int n;

	public ArrayListItem(K[] array, int n) {
		this.array = array;
		this.n = n;
	}

	@Override
	public int compareTo(ArrayListItem<K> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
