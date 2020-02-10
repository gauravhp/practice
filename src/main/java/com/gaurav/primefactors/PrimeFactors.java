package com.gaurav.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> primeFactorsOf(int i) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int divisor = 2;divisor <= i;divisor++) {
            for (; i % divisor == 0; i = i / divisor)
                factors.add(divisor);
        }
        return factors;
    }
}
