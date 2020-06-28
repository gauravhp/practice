package com.leetcode.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveElements {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1 && nums[0] == val)
            return 0;
        else if(nums.length == 1 )
            return 1;

        int i = 0;
        int length = nums.length;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            } else {
                length--;
            }
        }

        return length;
    }

    @Test
    public void testRemoveElements(){
        assertThat(removeElement(Common.intArray(),0), is(0));

        assertThat(removeElement(Common.intArray(1),1), is(0));
        assertThat(removeElement(Common.intArray(1),2), is(1));

        assertThat(removeElement(Common.intArray(1,2),3), is(2));
        assertThat(removeElement(Common.intArray(1,2),1), is(1));
        assertThat(removeElement(Common.intArray(1,2),2), is(1));

        assertThat(removeElement(Common.intArray(1,2,3),4), is(3));
        assertThat(removeElement(Common.intArray(1,2,3),1), is(2));
        assertThat(removeElement(Common.intArray(1,2,3),2), is(2));
        assertThat(removeElement(Common.intArray(1,2,3),3), is(2));

        assertThat(removeElement(Common.intArray(3,2,2,3),3), is(2));

        assertThat(removeElement(Common.intArray(0,1,2,2,3,0,4,2),2), is(5));
    }

}
