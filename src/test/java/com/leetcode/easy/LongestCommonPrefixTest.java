package com.leetcode.easy;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

*/

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class LongestCommonPrefixTest {

    private String[] stringArray(String... strs) {
        String[] newArray = new String[strs.length];
        int index = 0;
        for(String i : strs){
            newArray[index++] = i;
        }
        return newArray;
    }

    @Test
    public void testPrefix(){
        String[] input = new String[10];
        assertThat(longestCommonPrefix(stringArray("")), is(""));
        assertThat(longestCommonPrefix(stringArray("a")), is("a"));
        assertThat(longestCommonPrefix(stringArray("abc")), is("abc"));
        assertThat(longestCommonPrefix(stringArray("ab","ab")), is("ab"));
        assertThat(longestCommonPrefix(stringArray("ab","ac")), is("a"));
        assertThat(longestCommonPrefix(stringArray("abc","abd")), is("ab"));
        assertThat(longestCommonPrefix(stringArray("abcd","abce")), is("abc"));
        assertThat(longestCommonPrefix(stringArray("flower","flow","flight")), is("fl"));
        assertThat(longestCommonPrefix(stringArray("dog","racecar","car")), is(""));
        assertThat(longestCommonPrefix(stringArray("aca","cba")), is(""));
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        } else if (strs.length > 1 ){
            String returnString = "";
            int length = getSmallestLength(strs);

            for(int index = 0;index < length;index++)
                if(isSameChar(strs, index))
                    returnString = returnString + getCharAt(strs[0], index);
                else
                    break;

            return returnString;
        }

        return "";
    }

    private int getSmallestLength(String [] strs){
        int minLength = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < minLength){
                minLength = strs[i].length();
            }
        }
        return minLength;
    }

    private char getCharAt(String str, int i) {
        return str.charAt(i);
    }

    private boolean isSameChar(String[] strs, int i) {
        int length = strs.length;

        for(int index = 0; index < length-1; index++)
            if(strs[index].charAt(i) != strs[index+1].charAt(i))
                return false;

        return true;
    }
}
