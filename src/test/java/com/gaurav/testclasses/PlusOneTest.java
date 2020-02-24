package com.gaurav.testclasses;
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class PlusOneTest {

    public int[] plusOne(int[] digits) {
        int length = digits.length - 1 ;
        if(digits[length] == 9) {
            while (length >= 0 && digits[length] == 9) {
                digits[length] = 0;
                length--;
            }
            if (length >= 0) {
                digits[length]++;
                return digits;

            }
            if(length<0){
                List<Integer> tempArrayList = Arrays.stream(digits).boxed().collect(Collectors.toList());
                tempArrayList.add(0, 1);
                digits = new int[digits.length + 1];
                int index = 0;
                for (int i : tempArrayList) {
                    digits[index++] = i;
                }
                return digits;
            }

        }
        digits[length]++;

        return digits;
    }

    @Test
    public void testPlusOne(){
        assertThat(plusOne(Common.intArray(0)), is(Common.intArray(1)));
        assertThat(plusOne(Common.intArray(1)), is(Common.intArray(2)));
        assertThat(plusOne(Common.intArray(1,0)), is(Common.intArray(1,1)));
        assertThat(plusOne(Common.intArray(1,8,9)), is(Common.intArray(1,9,0)));
        assertThat(plusOne(Common.intArray(9)), is(Common.intArray(1,0)));
        assertThat(plusOne(Common.intArray(1,2,3)), is(Common.intArray(1,2,4)));
        assertThat(plusOne(Common.intArray(4,3,2,1)), is(Common.intArray(4,3,2,2)));
        assertThat(plusOne(Common.intArray(1,9,9)), is(Common.intArray(2,0,0)));
        assertThat(plusOne(Common.intArray(9,9,9)), is(Common.intArray(1,0,0,0)));
        assertThat(plusOne(Common.intArray(9,8,7,6,5,4,3,2,1,0)), is(Common.intArray(9,8,7,6,5,4,3,2,1,1)));
        assertThat(plusOne(Common.intArray(7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6)), is(Common.intArray(7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,7)));
    }
}
