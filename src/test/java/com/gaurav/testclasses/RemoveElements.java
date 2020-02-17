package com.gaurav.testclasses;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveElements {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != val) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void testRemoveElements(){
        assertThat(removeElement(Common.intArray(),0), is(0));
        assertThat(removeElement(Common.intArray(1),1), is(0));
        assertThat(removeElement(Common.intArray(1),2), is(1));
        assertThat(removeElement(Common.intArray(1,2),2), is(1));
        assertThat(removeElement(Common.intArray(1,2),3), is(0));
        assertThat(removeElement(Common.intArray(1,2,3),2), is(2));
        assertThat(removeElement(Common.intArray(1,2,3),3), is(2));
        assertThat(removeElement(Common.intArray(1,2,3,4),3), is(3));
    }

}
