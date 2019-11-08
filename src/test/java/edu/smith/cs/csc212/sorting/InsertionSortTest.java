package edu.smith.cs.csc212.sorting;

import java.util.Arrays;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;


@SuppressWarnings("javadoc")
public class InsertionSortTest {
	
	@Test
	public void testInsertionSort() {
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : SortTestingHelpers.data) {
			sortMe.addBack(y);
		}
		InsertionSort.insertSorted(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sortMe, SortTestingHelpers.data.length));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		InsertionSort.insertSorted(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sortMe, SortTestingHelpers.data.length));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), SortTestingHelpers.data.length);
	}

}
