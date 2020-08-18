package com.leetcode.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        Map<Character, Integer> charactersAndTheirPosition = new HashMap<Character, Integer>();
        int max=0;
        for (int cursor=0, begin=0; cursor<s.length(); ++cursor){
            if (charactersAndTheirPosition.containsKey(s.charAt(cursor))){
                begin = Math.max(begin,charactersAndTheirPosition.get(s.charAt(cursor))+1);
            }
            charactersAndTheirPosition.put(s.charAt(cursor),cursor);
            max = Math.max(max,cursor-begin+1);
        }
        return max;
    }

    @Test
    public void testLengthOfLongestSubstring(){
        assertThat(lengthOfLongestSubstring(""), is(0));
        assertThat(lengthOfLongestSubstring("a"), is(1));
        assertThat(lengthOfLongestSubstring("aa"), is(1));
        assertThat(lengthOfLongestSubstring("ab"), is(2));
        assertThat(lengthOfLongestSubstring("abcabcbb"), is(3));
        assertThat(lengthOfLongestSubstring("bbbbb"), is(1));
        assertThat(lengthOfLongestSubstring("pwwkew"), is(3));
        assertThat(lengthOfLongestSubstring("au"), is(2));
        assertThat(lengthOfLongestSubstring("tmmzuxt"), is(5));
    }
}
