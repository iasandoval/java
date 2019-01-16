package com.nacho.hackerrank.java;

import org.junit.Assert;
import org.junit.Test;

public class IfElse {

    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";

    @Test
    public void test() {
        IfElse ifElse = new IfElse();
        Assert.assertEquals(WEIRD, ifElse.validate(3));
        Assert.assertEquals(NOT_WEIRD, ifElse.validate(24));
        Assert.assertEquals(WEIRD, ifElse.validate(20));
    }

    /**
     * Given an integer, n, perform the following conditional actions:
     *
     * If n is odd, print Weird
     * If n is even and in the inclusive range of 2 to 5, print Not Weird
     * If n is even and in the inclusive range of 6 to 20, print Weird
     * If n is even and greater than 20, print Not Weird
     * @param n
     * @return
     */
    public String validate (int n) {

        String result = "Error!";

        if (n%2 == 0) {
            if(this.isBetween(n, 2, 5)) {
                result = NOT_WEIRD;
            }

            if(this.isBetween(n, 6, 20)) {
                result = WEIRD;
            }

            if(n > 20) {
                result = NOT_WEIRD;
            }
        } else {
            result = WEIRD;
        }

        return result;
    }

    /**
     * Return True if the n number provided is in between a and b (inclusive).
     *
     * @param n Number to compare
     * @param a lower value
     * @param b upper value
     * @return True if the n number provides is in between a and b.
     */
    private boolean isBetween(int n, int a, int b) {
        return (n >= a && n <= b);
    }


}
