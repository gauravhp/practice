package com.gaurav.testclasses;

import com.gaurav.sorting.QuickSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QuickSortTest {
    private final QuickSort quickSort = new QuickSort();
    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(quickSort.sort(unsorted), is(sorted));
    }

    private void sortBigList(int n) {
        List<Integer> unsorted = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            unsorted.add((int)(Math.random() * 10000.0));

        List<Integer> sorted = quickSort.sort(unsorted);
        for(int i = 0; i<n-1; i++)
            assertTrue(sorted.get(i)<=sorted.get(i+1));
    }

    @Test
    public void sorting(){
        assertSorted(intList(), intList());
        assertSorted(intList(1),intList(1));
        assertSorted(intList(2,1),intList(1,2));
        assertSorted(intList(2,1,3), intList(1,2,3));
        assertSorted(intList(2,3,1), intList(1,2,3));
        assertSorted(intList(3,2,1),intList(1,2,3));
        assertSorted(intList(3,2,2,1),intList(1,2,2,3));
        sortBigList(1000000);
    }
}
