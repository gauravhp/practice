package com.gaurav.testclasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.gaurav.testclasses.Common.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortedMergeInPlace {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testSortedMergeInPlace() {
        int m = 0;
        int n = 0;
        int[] mArray = intArray();
        int[] nArray =  intArray();
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray()));

        m = 1;
        n = 0;
        mArray =  intArray(1);
        nArray = intArray();
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1)));

        m = 0;
        n = 1;
        mArray =  intArray(0);
        nArray = intArray(1);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1)));

        m = 1;
        n = 1;
        mArray =  intArray(1,0);
        nArray = intArray(1);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1,1)));

        m = 1;
        n = 1;
        mArray =  intArray(1,0);
        nArray = intArray(2);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1,2)));

        m = 2;
        n = 1;
        mArray =  intArray(1,3,0);
        nArray = intArray(2);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1,2,3)));

        m = 1;
        n = 2;
        mArray =  intArray(2,0,0);
        nArray = intArray(1,3);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1,2,3)));

        m = 2;
        n = 1;
        mArray =  intArray(1,2,0);
        nArray = intArray(2);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1,2,2)));

        m = 3;
        n = 3;
        mArray =  intArray(1,2,3,0,0,0);
        nArray = intArray(2,5,6);
        merge(mArray,m,nArray,n);
        assertThat(mArray, is(intArray(1,2,2,3,5,6)));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m+n==0 || (n==0)){
            return;
        }
        if(m==0){
            nums1 = nums2.clone();
            return;
        }
        int k = m+n-1;
        for(int i=m-1,j=n-1;i>=0||j>=0;){
            if(j<0){
                while(i>=0){
                    nums1[k--] = nums1[i--];
                }
                return;
            }
            if(i<0){
                while(j>=0){
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            } else{
                nums1[k--] = nums2[j--];
            }
        }
    }

}
