package com.gaurav.testclasses;
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class ClimbingStairsTest {
    List<Integer> memoList;

    public ClimbingStairsTest() {
        memoList = new ArrayList<>();
        memoList.add(1);
        memoList.add(2);
    }

    @Test
    public void testClimbingStairs(){
        assertThat(climbStairs(1),is(1));
        assertThat(climbStairs(2),is(2));
        assertThat(climbStairs(3),is(3));
        assertThat(climbStairs(4),is(5));
        assertThat(climbStairs(5),is(8));
        assertThat(climbStairs(6),is(13));
        assertThat(climbStairs(42),is(433494437));
    }

    public int climbStairs(int i) {
        if(i==1 || i == 2) return i;
        if(i<memoList.size())
            return memoList.get(i-1);
        memoList.add(i-1,climbStairs(i-1) + climbStairs(i-2));
        return memoList.get(i-1);
    }
}
