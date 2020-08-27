package com.leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PascalsTriangle {

    public List<List<Integer>> generatePascalsTriangle(int numRows) {
        List outer = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return outer;
        }
        outer.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1){
            return outer;
        }
        for(int level = 1; level < numRows; level++){
            List<Integer> inner = new ArrayList<>();
            List<Integer> prev = (List<Integer>) outer.get(level-1);
            for(int index = 0; index<=level; index++){
                if(index == 0 || index == level){
                    inner.add(1);
                    continue;
                }
                inner.add(prev.get(index-1)+prev.get(index));
            }
            outer.add(inner);
        }

        return outer;
    }

    @Test
    public void testGeneratePascalsTriangle() {
        assertThat(generatePascalsTriangle(1),is(getPascalsTriangleFor(1)));
        assertThat(generatePascalsTriangle(2),is(getPascalsTriangleFor(2)));
        assertThat(generatePascalsTriangle(3),is(getPascalsTriangleFor(3)));
        assertThat(generatePascalsTriangle(4),is(getPascalsTriangleFor(4)));
        assertThat(generatePascalsTriangle(5),is(getPascalsTriangleFor(5)));
    }

    private List<List<Integer>> getPascalsTriangleFor(int elements){
        List<List<Integer>> outer = new ArrayList<>();
        switch (elements){
            case 1:
                outer.add(new ArrayList<>(Arrays.asList(1)));
                return outer;
            case 2:
                outer.add(new ArrayList<>(Arrays.asList(1)));
                outer.add(new ArrayList<>(Arrays.asList(1,1)));
                return outer;
            case 3:
                outer.add(new ArrayList<>(Arrays.asList(1)));
                outer.add(new ArrayList<>(Arrays.asList(1,1)));
                outer.add(new ArrayList<>(Arrays.asList(1,2,1)));
                return outer;
            case 4:
                outer.add(new ArrayList<>(Arrays.asList(1)));
                outer.add(new ArrayList<>(Arrays.asList(1,1)));
                outer.add(new ArrayList<>(Arrays.asList(1,2,1)));
                outer.add(new ArrayList<>(Arrays.asList(1,3,3,1)));
                return outer;
            case 5:
                outer.add(new ArrayList<>(Arrays.asList(1)));
                outer.add(new ArrayList<>(Arrays.asList(1,1)));
                outer.add(new ArrayList<>(Arrays.asList(1,2,1)));
                outer.add(new ArrayList<>(Arrays.asList(1,3,3,1)));
                outer.add(new ArrayList<>(Arrays.asList(1,4,6,4,1)));
                return outer;
        }
        return outer;
    }

    private List<List<Integer>> getPascalsTriangleForTwoElements() {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>(Arrays.asList(1)));
        outer.add(new ArrayList<>(Arrays.asList(1,1)));
        return outer;
    }
}
