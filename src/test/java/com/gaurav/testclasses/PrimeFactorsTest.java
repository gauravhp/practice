package com.gaurav.testclasses;

import com.gaurav.primefactors.PrimeFactors;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;

public class PrimeFactorsTest {
    private Matcher<List<Integer>> isListOf(Integer... ints) {
        return CoreMatchers.is(asList(ints));
    }

    @Test
    public void testPrimeFactors(){
        Assert.assertThat(PrimeFactors.primeFactorsOf(1),isListOf());
        Assert.assertThat(PrimeFactors.primeFactorsOf(2),isListOf(2));
        Assert.assertThat(PrimeFactors.primeFactorsOf(3),isListOf(3));
        Assert.assertThat(PrimeFactors.primeFactorsOf(4),isListOf(2,2));
        Assert.assertThat(PrimeFactors.primeFactorsOf(5),isListOf(5));
        Assert.assertThat(PrimeFactors.primeFactorsOf(6),isListOf(2,3));
        Assert.assertThat(PrimeFactors.primeFactorsOf(7),isListOf(7));
        Assert.assertThat(PrimeFactors.primeFactorsOf(8),isListOf(2,2,2));
        Assert.assertThat(PrimeFactors.primeFactorsOf(9),isListOf(3,3));
    }
}
