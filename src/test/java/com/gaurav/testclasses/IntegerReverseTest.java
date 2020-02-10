package com.gaurav.testclasses;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class IntegerReverseTest {

    @Test
    public void testReverse(){
        assertThat(reverse(0),equalTo(0));
        assertThat(reverse(1),equalTo(1));
        assertThat(reverse(-1),equalTo(-1));
        assertThat(reverse(12),equalTo(21));
        assertThat(reverse(11),equalTo(11));
        assertThat(reverse(-12),equalTo(-21));
        assertThat(reverse(-11),equalTo(-11));
        assertThat(reverse(10),equalTo(1));
        assertThat(reverse(-10),equalTo(-1));
        assertThat(reverse(123),equalTo(321));
        assertThat(reverse(-123),equalTo(-321));
        assertThat(reverse(100),equalTo(1));
        assertThat(reverse(101),equalTo(101));
        assertThat(reverse(-100),equalTo(-1));
        assertThat(reverse(1234),equalTo(4321));
        assertThat(reverse(10000),equalTo(1));
        assertThat(reverse(1534236469),equalTo(0));
        assertThat(reverse(-2147483648),equalTo(0));
    }

    public int reverse(Integer x) {
        Long newLong = Long.valueOf(x);
        String n = "";
        boolean negative = x<0;
        if(Math.abs(newLong)>9){

            newLong=Math.abs(Long.valueOf(x));
            while(newLong>0){
                n = n + String.valueOf(newLong%10);
                newLong =newLong/10;
            }
            if(negative) n = "-" + n;
        } else {
            return x;
        }

        if(!negative && Long.parseLong(n)>Math.pow(2,31)-1){
            return 0;
        }
        if(negative && Long.parseLong(n.substring(1,n.length())) > Math.abs(Math.pow(-2,31))){
            return 0;
        }
        return Integer.valueOf(n);
    }
}
