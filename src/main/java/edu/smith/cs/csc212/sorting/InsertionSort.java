package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSort {
	
	/**
	 * Insertion Sort
	 * Take value from unsorted list, and insert in the right position in the sorted list
	 */

	public static ListADT<Integer> insertSorted(ListADT<Integer> input) {
		int N = input.size();

		ListADT<Integer> sorted = new JavaList<>();
		
		while (! input.isEmpty()) {
			boolean found = false;
			int x = input.removeFront(); 
			for (int i = 0; i<sorted.size(); i++) {
				//sorted=[1,2,3] x=4
				if (x <sorted.getIndex(i)) {
					sorted.addIndex(i, x);
					found = true;
					break;
				}
			}
			
			//creates a new space for the value to be added (belongs after the whole thing)
			if (!found) {
				sorted.addBack(x);
			}
		}
		input.addAll(sorted);
		return sorted;
	}
}
