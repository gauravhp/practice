package com.hackerrank.oddnumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: Gaurav Parmar
 * Date: 18-05-2021
 * Time: 07:45
 */
public class Result {
    public static List<Integer> oddNumbers(int l, int r) {
        return IntStream.range(l,r+1).boxed().filter(i->i%2==1).collect(Collectors.toList());
    }
}
