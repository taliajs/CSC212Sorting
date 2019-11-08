package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;

public class SelectionSort {
	
	/**
	 * SelectionSort
	 * Find minimum value in list and bring it to the front
	 */
	
	public static void sort(ListADT<Integer> input) {
		int N = input.size();
		
		for (int i=0; i<N-1; i++) {
			int min = input.getIndex(i);
			int minIndex = i;
			for (int j = i+1; j<N; j++) {
				if (input.getIndex(j) < min) {
					min = input.getIndex(j);
					minIndex = j;
				}
			}
			input.swap(i, minIndex);
		}
		
	} 
	

}
 