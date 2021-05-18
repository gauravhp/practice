package com.hackerrank.oddnumbers;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Gaurav Parmar
 * Date: 18-05-2021
 * Time: 07:45
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.oddNumbers(l, r);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining())
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
