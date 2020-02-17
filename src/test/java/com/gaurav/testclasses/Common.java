package com.gaurav.testclasses;

import java.util.Arrays;
import java.util.List;

public class Common {
    public static int[] intArray(Integer... ints) {
        int[] newArray = new int[ints.length];
        int index = 0;
        for(int i : ints){
            newArray[index++] = i;
        }
        return newArray;
    }

    public static List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
