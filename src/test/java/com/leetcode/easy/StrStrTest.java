package com.leetcode.easy;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StrStrTest {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }
    @Test
    public void testStrStr(){
        assertThat(strStr("abc",""),is(0));
        assertThat(strStr("abc","d"),is(-1));
        assertThat(strStr("abc","a"),is(0));
        assertThat(strStr("abc","b"),is(1));
        assertThat(strStr("abc","c"),is(2));
        assertThat(strStr("abc","bc"),is(1));
        assertThat(strStr("abc","de"),is(-1));
        assertThat(strStr("hello","ll"),is(2));
        assertThat(strStr("aaaaa","bba"),is(-1));
    }
}
