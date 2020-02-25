package com.gaurav.testclasses;
/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class SquareRootTest {

    @Test
    public void testSquareRoot(){
        assertThat(mySqrt(4),is(2));
        assertThat(mySqrt(9),is(3));
        assertThat(mySqrt(8),is(2));
    }

    public int mySqrt(int i) {
        return Math.toIntExact((long) Math.floor(Math.sqrt(i)));
    }
}
