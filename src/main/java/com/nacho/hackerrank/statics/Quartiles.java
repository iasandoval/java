package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

    private final double q1;
    private final double q2;
    private final double q3;

    /**
     * Task
     * Given an array, X, of n integers, calculate the respective first quartile (Q1), second quartile (Q2),
     * and third quartile (Q3). It is guaranteed that Q1, Q2, and Q3 are integers.
     * <p>
     * Input Format
     * The first line contains an integer, n, denoting the number of elements in the array.
     * The second line contains n space-separated integers describing the array's elements.
     * <p>
     * Method
     * Use the median to divide the ordered data set into two halves.
     * If there are an odd number of data points in the original ordered data set,
     * do not include the median (the central value in the ordered list) in either half.
     * If there are an even number of data points in the original ordered data set,
     * split this data set exactly in half.
     * The lower quartile value is the median of the lower half of the data.
     * The upper quartile value is the median of the upper half of the data.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String Xs = scan.nextLine();
        scan.close();

        double[] X = StaticsUtil.parseDoubleArray(Xs);

        Quartiles quartiles = new Quartiles(X);

        System.out.println(quartiles.getQ1());
        System.out.println(quartiles.getQ2());
        System.out.println(quartiles.getQ3());
    }

    public Quartiles(double[] X) {
        // To Calculate Quartiles, array has to be sorted.
        Arrays.sort(X);

        double[] L = Quartiles.getLowerQuartile(X);
        double[] U = Quartiles.getUpperQuartile(X);

        this.q1 = MeanMedianMode.median(L);
        this.q2 = MeanMedianMode.median(X);
        this.q3 = MeanMedianMode.median(U);
    }

    public static double[] getLowerQuartile(double[] X) {
        return Arrays.copyOfRange(X, 0, X.length / 2);
    }

    public static double[] getUpperQuartile(double[] X) {
        double[] U;
        if (X.length % 2 == 0) {
            // Even
            U = Arrays.copyOfRange(X, (X.length / 2), X.length);
        } else {
            // Odd
            U = Arrays.copyOfRange(X, (X.length / 2) + 1, X.length);
        }

        return U;
    }

    public double getQ1() {
        return q1;
    }

    public double getQ2() {
        return q2;
    }

    public double getQ3() {
        return q3;
    }
}
