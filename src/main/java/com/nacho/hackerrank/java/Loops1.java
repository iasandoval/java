package com.nacho.hackerrank.java;

import org.junit.Test;

public class Loops1 {

    @Test
    public void test() {

        Loops1 loops1 = new Loops1();

        for(int i = 1;i<=10; i ++) {
            System.out.println(loops1.multiples(2, i));
        }
    }

    /**
     * Task
     * Given an integer, n, print its first 10 multiples.
     * Each multiple n x i (where 1 <= i <= 10) should be printed on a new line in the form: N x i = result.
     *
     * Input Format
     * A single integer, n.
     *
     * Output Format
     * Print 10 lines of output; each line i (where 1 <= i <= 10) contains the result of n x i in the form:
     * N x i = result.
     * @param n
     * @param i
     * @return
     */
    public String multiples(int n, int i) {
        return n + " x " + i + " = " + (n*i);
    }
}
