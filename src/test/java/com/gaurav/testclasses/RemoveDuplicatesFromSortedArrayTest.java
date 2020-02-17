package com.gaurav.testclasses;
/*
* Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
 */
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void testRemovalOfDuplicates(){
        assertThat(removeDuplicates(Common.intArray()), is(0));
        assertThat(removeDuplicates(Common.intArray(1)),is(1));
        assertThat(removeDuplicates(Common.intArray(1,2)),is(2));
        assertThat(removeDuplicates(Common.intArray(1,1)),is(1));
        performLengthAndInputTest(Common.intArray(1,1,2),Common.intArray(1,2,2),2);
        performLengthAndInputTest(Common.intArray(1,2,2),Common.intArray(1,2,2),2);
        performLengthAndInputTest(Common.intArray(1,2,3),Common.intArray(1,2,3),3);
        performLengthAndInputTest(Common.intArray(1,2,3,4),Common.intArray(1,2,3,4),4);
        performLengthAndInputTest(Common.intArray(2,2,3,4),Common.intArray(2,3,4,4),3);
        performLengthAndInputTest(Common.intArray(2,3,4,4),Common.intArray(2,3,4,4),3);
        performLengthAndInputTest(Common.intArray(2,2,3,3),Common.intArray(2,3,3,3),2);
        performLengthAndInputTest(Common.intArray(2,2,2,3),Common.intArray(2,3,2,3),2);
        performLengthAndInputTest(Common.intArray(2,3,3,3),Common.intArray(2,3,3,3),2);
        //performLengthAndInputTest(Common.intArray(0,0,1,1,1,2,2,3,3,4),Common.intArray(0,1,2,3,4,0,1,1,2,3),5);
    }

    private void performLengthAndInputTest(int[] input, int [] output, int length) {
        assertThat(removeDuplicates(input),is(length));
        assertThat(input,is(output));
    }

        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
}
