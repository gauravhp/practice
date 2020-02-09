import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PrimeFactorsTest {
    private Matcher<List<Integer>> isListOf(Integer... ints) {
        return is(asList(ints));
    }

    @Test
    public void testPrimeFactors(){
        assertThat(PrimeFactors.primeFactorsOf(1),isListOf());
        assertThat(PrimeFactors.primeFactorsOf(2),isListOf(2));
        assertThat(PrimeFactors.primeFactorsOf(3),isListOf(3));
        assertThat(PrimeFactors.primeFactorsOf(4),isListOf(2,2));
        assertThat(PrimeFactors.primeFactorsOf(5),isListOf(5));
        assertThat(PrimeFactors.primeFactorsOf(6),isListOf(2,3));
        assertThat(PrimeFactors.primeFactorsOf(7),isListOf(7));
        assertThat(PrimeFactors.primeFactorsOf(8),isListOf(2,2,2));
        assertThat(PrimeFactors.primeFactorsOf(9),isListOf(3,3));
    }
}
