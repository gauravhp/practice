package com.hackerrank.fizzbuzz;

/**
 * User: Gaurav Parmar
 * Date: 18-05-2021
 * Time: 07:09
 */
public class Result {

    public static void fizzBuzz(int n) {

    }

    private static void fizzBuzzPrinter(int n){
        if(n%3 == 0 && n%5==0)
            System.out.println("FizzBuzz");
        else if(n%3==0)
            System.out.println("Fizz");
        else if(n%5==0)
            System.out.println("Buzz");
        else
            System.out.println(n);
    }
}
