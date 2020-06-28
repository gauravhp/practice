package com.leetcode.easy;

import com.gaurav.sorting.BubbleSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SortTest {
    private final BubbleSort bubbleSort = new BubbleSort();

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(bubbleSort.sort(unsorted), is(sorted));
    }

    @Test
    public void sortings(){
        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
        assertSorted(intList(2,1),intList(1,2));
        assertSorted(intList(1,3,2), intList(1,2,3));
        assertSorted(intList(3,2,1), intList(1,2,3));

        sortBigList(25000);
    }

    private void sortBigList(int n) {
        List<Integer> unsorted = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            unsorted.add((int)(Math.random() * 10000.0));

        List<Integer> sorted = bubbleSort.sort(unsorted);
        for(int i = 0; i<n-1; i++)
            assertTrue(sorted.get(i)<=sorted.get(i+1));
    }

}
