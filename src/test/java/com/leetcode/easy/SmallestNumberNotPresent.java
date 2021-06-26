package com.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Gaurav Parmar
 * Date: 18-06-2021
 * Time: 12:31
 */
public class SmallestNumberNotPresent {
    public static void main(String[] args) {
        SmallestNumberNotPresent sm = new SmallestNumberNotPresent();
        int[] arr = new int[]{ 1,2,3};
        System.out.println(sm.solution(arr));
    }
    public int solution(int[] A) {
        int size = A.length;
        int copyArray[] = new int[size];
        int index = 1;
        for (int i = 0; i < size; i++) {
            if (A[i] <= size && A[i] >0 ) {
                copyArray[A[i] - 1] = A[i];

            }
            boolean flag = true;
            int value = A[i];
            if (value == index) {
                index++;
                while (true) {
                    if ( index<= size) {
                        value = copyArray[index-1];
                        if (value == index) {
                            index++;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return index;
    }


}
