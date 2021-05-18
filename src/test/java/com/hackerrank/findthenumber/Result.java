package com.hackerrank.findthenumber;

import java.util.List;

/**
 * User: Gaurav Parmar
 * Date: 18-05-2021
 * Time: 07:32
 */
public class Result {
    public static String findNumber(List<Integer> arr, int k) {
        for (Integer i : arr) {
            if(i.intValue()==k)
                return "YES";
        }
        return "NO";
    }
}
