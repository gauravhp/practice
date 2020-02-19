package com.gaurav.testclasses;
import com.gaurav.strings.CountAndSay;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.
https://www.careercup.com/question?id=4425679
 */
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
