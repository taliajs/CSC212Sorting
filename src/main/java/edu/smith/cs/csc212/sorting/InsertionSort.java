package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSort {
	public static void insertSorted(ListADT<Integer> input) {
		int N = input.size();

		ListADT<Integer> sorted = new JavaList<>();
		
		while (! input.isEmpty()) {
			int x = input.removeFront(); 
			for (int i = 0; i<sorted.size(); i++) {
				if (x <sorted.getIndex(i)) {
					sorted.addIndex(i, x);
				}
				
			} input.addAll(sorted);
		}
	}
}
