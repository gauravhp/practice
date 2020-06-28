package com.leetcode.easy;
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class AddBinaryTest {
    public class ValueAndCarryFwd{
        int value=0;
        int carryFwd=0;

        public ValueAndCarryFwd(int value, int carryFwd) {
            this.value = value;
            this.carryFwd = carryFwd;
        }

        public int getValue() {
            return value;
        }

        public int getCarryFwd() {
            return carryFwd;
        }
    }
    @Test
    public void testAddBinary(){
        assertThat(addBinary("0","0"), is("0"));
        assertThat(addBinary("1","0"), is("1"));
        assertThat(addBinary("0","1"), is("1"));
        assertThat(addBinary("1","1"), is("10"));
        assertThat(addBinary("10","0"),is("10"));
        assertThat(addBinary("10","1"),is("11"));
        assertThat(addBinary("11","1"),is("100"));
        assertThat(addBinary("1010","1011"),is("10101"));
    }

    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty())
            return b;
        if(b == null || b.isEmpty())
            return a;


        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aBit;
        int bBit;
        int carry = 0;
        int result;

        while(i >= 0 || j >= 0 || carry == 1) {
            aBit = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            bBit = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = aBit ^ bBit ^ carry;
            carry = ((aBit + bBit + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }


}
