package com.gaurav.testclasses;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */
public class LastWordLengthTest {
    public int lengthOfLastWord(String s) {
        if(s.isEmpty() || s.trim().length()==0) {
            return 0;
        }
        s = s.trim();
        if(s.contains(" ")){
            return s.length() - s.lastIndexOf(" ") - 1;
        }

        return s.length();
    }

    @Test
    public void testLengthOfLastWord(){
        assertThat(lengthOfLastWord(""),is(0));
        assertThat(lengthOfLastWord(" "),is(0));
        assertThat(lengthOfLastWord("   "),is(0));

        assertThat(lengthOfLastWord("ii"),is(2));
        assertThat(lengthOfLastWord("i i"),is(1));
        assertThat(lengthOfLastWord("i ii"),is(2));
        assertThat(lengthOfLastWord("iiii  iii"),is(3));
        assertThat(lengthOfLastWord("iiii  iii   ii"),is(2));
        assertThat(lengthOfLastWord("Hello World"),is(5));
        assertThat(lengthOfLastWord("a "),is(1));
    }
}
