package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.ListSlice;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {

	/**
	 * Helper method: Merge two sorted lists into one sorted list
	 */
	public static ListADT<Integer> helper(ListADT<Integer> left, ListADT<Integer> right) {

		ListADT<Integer> combined = new JavaList<>();

		while (!left.isEmpty() && !right.isEmpty()) {
			if (left.getFront() <= right.getFront()) {
				combined.addBack(left.removeFront());
			}

			else {
				combined.addBack(right.removeFront());
			}
		}
		if (!left.isEmpty()) {
			combined.addAll(left); //adding whatever is still in "left" to combined
		}

		if (!right.isEmpty()) {
			combined.addAll(right); //adding whatever is still in "right" to combined
		}
		return combined;

	}

	/**
	 * Recursive MergeSort
	 */
	public static ListADT<Integer> RecursiveMergeSort(ListADT<Integer> input) {
		int N = input.size();
		
		int mid = input.size() / 2; 
		int start = 0; //get the first index
		int end = input.size() - 1; //get the last index
		
		if (input.size() > 1) {
			ListADT<Integer> left = input.slice(start, mid);
			ListADT<Integer> right = input.slice(mid, end);
			ListADT<Integer> leftResult = RecursiveMergeSort(left);
			ListADT<Integer> rightResult = RecursiveMergeSort(right);
			return helper(leftResult, rightResult);
			
			//mergeSort: slices and mergeSorts a list until list is all in single pieces
		}
		return input;
		
	}
	

	/**
	 * Iterative MergeSort
	 */
	public static ListADT<Integer> iterativeSort(ListADT<Integer> input) {
		ListADT<ListADT<Integer>> queue = new JavaList<>();
		
		
		//creates the list of lists 
		for (int i = 0; i<input.size(); i++) {
			ListADT<Integer> single = new JavaList<>();
			single.addBack(input.getIndex(i));
			queue.addBack(single);
		}
		
		while (queue.size() > 1) {
			ListADT<Integer> first = queue.removeFront();
			ListADT<Integer> second = queue.removeFront();
			ListADT<Integer> helperResult = helper(first, second);
			queue.addBack(helperResult);
			
			//break when queue is size 1 
		}
		
		return queue.getFront();
		

	}

	

}
