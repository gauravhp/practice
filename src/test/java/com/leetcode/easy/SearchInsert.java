package com.leetcode.easy;
import com.leetcode.common.DataGenerator;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
 */

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }

        int index = 0;

        while(index < nums.length){
            if(foundLocation(nums[index], target))
                return index;

            if (isLastLocationAndGreater(nums,target,index))
                return index+1;

            if (isLastLocationAndSmaller(nums,target,index))
                return index;

            index++;
        }

        return -1;
    }

    private boolean isLastLocationAndGreater(int [] nums, int target, int index){
        return  index==nums.length-1 && nums[index] < target;
    }

    private boolean isLastLocationAndSmaller(int [] nums, int target, int index){
        return  index==nums.length-1 && nums[index] > target;
    }
    private boolean foundLocation(int num, int target) {
        return num == target || num >target;
    }

    @Test
    public void testSearchInsert(){
        assertThat(searchInsert(DataGenerator.intArray(),1),is(0));
        assertThat(searchInsert(DataGenerator.intArray(1),0),is(0));
        assertThat(searchInsert(DataGenerator.intArray(0),1),is(1));
        assertThat(searchInsert(DataGenerator.intArray(1,2),1),is(0));
        assertThat(searchInsert(DataGenerator.intArray(1,2),2),is(1));
        assertThat(searchInsert(DataGenerator.intArray(1,2),3),is(2));
        assertThat(searchInsert(DataGenerator.intArray(1,2),0),is(0));
        assertThat(searchInsert(DataGenerator.intArray(1,3),2),is(1));
        assertThat(searchInsert(DataGenerator.intArray(1,3,5,6),5),is(2));
        assertThat(searchInsert(DataGenerator.intArray(1,3,5,6),2),is(1));
        assertThat(searchInsert(DataGenerator.intArray(1,3,5,6),7),is(4));
        assertThat(searchInsert(DataGenerator.intArray(1,3,5,6),0),is(0));
    }
}
