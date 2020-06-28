package com.leetcode.easy;
/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class RomanNumbersTest {
    private Map<String,Integer> romanNumerals = new HashMap<String,Integer>();

    @Before
    public void initialize(){
        romanNumerals.put("I",1);
        romanNumerals.put("V",5);
        romanNumerals.put("X",10);
        romanNumerals.put("L",50);
        romanNumerals.put("C",100);
        romanNumerals.put("D",500);
        romanNumerals.put("M",1000);
    }

    @Test
    public void testRomanNumerals(){
        assertThat(romanToInt(""),is(0));
        assertThat(romanToInt("I"),is(1));
        assertThat(romanToInt("V"),is(5));
        assertThat(romanToInt("II"),is(2));
        assertThat(romanToInt("III"),is(3));
        assertThat(romanToInt("VI"),is(6));
        assertThat(romanToInt("IV"),is(4));
        assertThat(romanToInt("IX"),is(9));
        assertThat(romanToInt("LVIII"),is(58));
        assertThat(romanToInt("MCMXCIV"),is(1994));
    }

    public int romanToInt(String s) {
        if(s.length()==0)
            return 0;

        if(s.length()==1)
            return romanNumerals.get(s);

        int result = 0;
        for(int i = 0 ; i< s.length() ; i++) {
            char currentChar = getaCharAt(s, i);
            char nextChar = getaCharAt(s, i+1);

            if(nextChar!=Character.MIN_VALUE) {
                if (specialCase(currentChar, nextChar)>0){
                    result = result + specialCase(currentChar, nextChar);
                    i++;
                    continue;
                }
            }
            result = result + getInteger(s, i);
        }

        return result;
    }

    private int specialCase(char currentChar, char nextChar) {
         if(currentChar =='I' && nextChar =='V')
             return 4;

        if(currentChar =='I' && nextChar =='X')
            return 9;

        if(currentChar =='X' && nextChar =='L')
            return 40;

        if(currentChar =='X' && nextChar =='C')
            return 90;

        if(currentChar =='C' && nextChar =='D')
            return 400;

        if(currentChar =='C' && nextChar =='M')
            return 900;

         return 0;
    }

    private char getaCharAt(String s, int i) {
        if(s.length()>i)
            return s.charAt(i);

        return Character.MIN_VALUE;
    }

    private Integer getInteger(String s, int i) {
        return romanNumerals.get(String.valueOf(getaCharAt(s, i)));
    }


}
