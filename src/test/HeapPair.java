package test;

import java.util.Comparator;

public class HeapPair implements Comparator<HeapPair> {

	private int diff;
	private int index;
	
	
	
	
	public HeapPair(int diff, int index) {
		super();
		this.diff = diff;
		this.index = index;
	}
	
	public int getDiff() {
		return diff;
	}
	public void setDiff(int diff) {
		this.diff = diff;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compare(HeapPair o1, HeapPair o2) {
		// TODO Auto-generated method stub
		return o2.diff-o1.diff;
	}

	public HeapPair() {
		super();
	}
	
	
	
}
