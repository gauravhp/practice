package com.gaurav.testclasses;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 */
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class MaxSubArrayTest {
    public int maxSubArray(int[] nums) {
        int maxSub = Integer.MIN_VALUE;
        int leftPositive = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSub = Math.max(maxSub, leftPositive + nums[i]);
            leftPositive = Math.max(0, leftPositive + nums[i]);
        }
        return maxSub;
    }

    @Test
    public void testMaxSubArray(){
        assertThat(maxSubArray(Common.intArray(1)),is(1));
        assertThat(maxSubArray(Common.intArray(1,2)),is(3));
        assertThat(maxSubArray(Common.intArray(-1,2)),is(2));
        assertThat(maxSubArray(Common.intArray(1,-2)),is(1));
        assertThat(maxSubArray(Common.intArray(-1,-2)),is(-1));
        assertThat(maxSubArray(Common.intArray(1,2,3)),is(6));
        assertThat(maxSubArray(Common.intArray(-1,2,3)),is(5));
        assertThat(maxSubArray(Common.intArray(1,-2,3)),is(3));
        assertThat(maxSubArray(Common.intArray(-2,1,-3,4,-1,2,1,-5,4)),is(6));
    }
}
