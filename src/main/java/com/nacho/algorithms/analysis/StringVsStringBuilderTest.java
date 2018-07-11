package com.nacho.algorithms.analysis;

import org.junit.Test;

public class StringVsStringBuilderTest {
    /**
     * Array of number of times that tha Character will be concatenated/appended.
     */
    private final int[] aNumbers = {1000, 5000, 10000, 20000, 40000, 50000, 100000, 500000, 1000000};

    /**
     * Character to concatenate/append.
     */
    private final char c = '*';


    /**
     * This method will run the test to compare the performance between String
     * concatenate and StringBuilder append.
     */
    @Test
    public void testStringsConcat() {
        // Testing String concatenation
        for (int i = 0; i < aNumbers.length; i++) {
            TimeResult resultStr = StringVsStringBuilder.stringConcat(c, aNumbers[i]);
            System.out.println("String concatenate results: " + resultStr.toString());
        }
    }

    /**
     * This method will run the test to compare the performance between String
     * concatenate and StringBuilder append.
     */
    @Test
    public void testStringBuilderAppend() {
        // Testing StringBuilder
        for (int i = 0; i < aNumbers.length; i++) {
            TimeResult resultBld = StringVsStringBuilder.builderAppend(c, aNumbers[i]);
            System.out.println("StringBuilder append results: " + resultBld.toString());
        }
    }
}
