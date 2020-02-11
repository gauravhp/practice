package com.gaurav.testclasses;
/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class PalindromeNumberTest {
    @Test
    public void testPalindromeNumbers(){
        assertThat(isPalindrome(0),is(true));
        assertThat(isPalindrome(10),is(false));
        assertThat(isPalindrome(11),is(true));
        assertThat(isPalindrome(-1),is(false));
        assertThat(isPalindrome(100),is(false));
        assertThat(isPalindrome(121),is(true));
        assertThat(isPalindrome(-121),is(false));
        assertThat(isPalindrome(1000),is(false));
        assertThat(isPalindrome(1331),is(true));
        assertThat(isPalindrome(12321),is(true));
        assertThat(isPalindrome(123321),is(true));
        assertThat(isPalindrome(1234321),is(true));
        assertThat(isPalindrome(1234521),is(false));
    }

    public boolean isPalindrome(int x) {
        if(x<0)
            return false;

        if(x<10)
            return true;

        int n = x;
        int length = String.valueOf(x).length();
        while(n>0 && length > 1){
            if((n%10) != (int)(n/Math.pow(10,(length-1)))){
                return false;
            }
            int firstDigit = (int) (n/Math.pow(10,(length-1)));
            n = (int)(n - firstDigit * Math.pow(10,(length-1)));
            n = n/10;
            length = length - 2;
        }

        return true;
    }
}
