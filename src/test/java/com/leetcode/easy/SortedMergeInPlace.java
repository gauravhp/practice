package com.leetcode.easy;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortedMergeInPlace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m+n==0 || (n==0)){
            return;
        }
        if(m==0){
            nums1 = nums2.clone();
            return;
        }
        int k = m+n-1;
        for(int i=m-1,j=n-1;i>=0||j>=0;){
            if(j<0){
                while(i>=0){
                    nums1[k--] = nums1[i--];
                }
                return;
            }
            if(i<0){
                while(j>=0){
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            } else{
                nums1[k--] = nums2[j--];
            }
        }
    }

}
