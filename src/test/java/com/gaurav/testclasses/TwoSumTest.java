package com.gaurav.testclasses;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class TwoSumTest {
    private int[] intArray(Integer... ints) {
        int[] newArray = new int[ints.length];
        int index = 0;
        for(int i : ints){
            newArray[index++] = i;
        }
        return newArray;
    }
    @Test
    public void testTwoSum(){
        assertThat(twoSum(intArray(1,2),3),equalTo(intArray(0,1)));
        assertThat(twoSum(intArray(2,1),3),equalTo(intArray(0,1)));
        assertThat(twoSum(intArray(1,2,3),5),equalTo(intArray(1,2)));
        assertThat(twoSum(intArray(1,3,2),5),equalTo(intArray(1,2)));
        assertThat(twoSum(intArray(2,1,3),5),equalTo(intArray(0,2)));
        assertThat(twoSum(intArray(4,2,1,3),7),equalTo(intArray(0,3)));
        assertThat(twoSum(intArray(2,7,11,15),9),equalTo(intArray(0,1)));
        assertThat(twoSum(intArray(2,5,5,11),10),equalTo(intArray(1,2)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] twoSumArray = new int[2];
        int i = 0;

        while(i < nums.length - 1) {
            int j = 1;
            while (j < nums.length ) {
                if(i==j) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    twoSumArray[0]=i<j?i:j;
                    twoSumArray[1]=i<j?j:i;
                }
                j++;
            }
            i++;
        }
        return twoSumArray;
    }


}
