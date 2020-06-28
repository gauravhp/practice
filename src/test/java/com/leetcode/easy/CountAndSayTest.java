package com.leetcode.easy;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountAndSayTest {

    @Test
    public void testCountAndSay(){
        assertThat(getCountAndSay(1),is("1"));
        assertThat(getCountAndSay(2),is("11"));
        assertThat(getCountAndSay(3),is("21"));
        assertThat(getCountAndSay(4),is("1211"));
        assertThat(getCountAndSay(5),is("111221"));
        assertThat(getCountAndSay(6),is("312211"));
        assertThat(getCountAndSay(7),is("13112221"));
    }

    private String getCountAndSay(int i) {
        return new CountAndSay().countAndSay(i);
    }
}
