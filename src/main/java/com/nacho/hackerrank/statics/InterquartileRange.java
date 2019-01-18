package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterquartileRange {

    @Test
    public void test() {
        InterquartileRange interquartileRange = new InterquartileRange();

        double[] X = StaticsUtil.parseDoubleArray("6 12 8 10 20 16");
        double[] F = StaticsUtil.parseDoubleArray("5 4 3 2 1 5");

        double value = interquartileRange.calculate(X, F);

        Assert.assertTrue(9 == value);
    }

    /**
     * Task
     * The interquartile range of an array is the difference between its first (Q1)
     * and third (Q3) quartiles (i.e., Q3-Q1).
     * <p>
     * Given an array, X, of n integers and an array, f, representing the respective frequencies of X's elements,
     * construct a data set, S, where each xi occurs at frequency fi. Then calculate and print S's interquartile
     * range, rounded to a scale of 1 decimal place (i.e., 12.3 format).
     * <p>
     * Tip: Be careful to not use integer division when averaging the middle two elements for a data set with
     * an even number of elements, and be sure to not include the median in your upper and lower data sets.
     * <p>
     * Input Format
     * The first line contains an integer, n, denoting the number of elements in arrays X and F.
     * The second line contains n space-separated integers describing the respective elements of array X.
     * The third line contains n space-separated integers describing the respective elements of array F.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String Xs = scan.nextLine();
        String Fs = scan.nextLine();
        scan.close();

        double[] X = StaticsUtil.parseDoubleArray(Xs);
        double[] F = StaticsUtil.parseDoubleArray(Fs);

        InterquartileRange interquartileRange = new InterquartileRange();
        double value = interquartileRange.calculate(X, F);

        System.out.println(value);
    }

    public double calculate(double[] X, double[] F) {
        double value;

        double[] S = this.createDataSet(X, F);

        Quartiles quartiles = new Quartiles(S);

        double q1 = quartiles.getQ1();
        double q3 = quartiles.getQ3();
        value = q3 - q1;

        System.out.println("Q1 = " + q1);
        System.out.println("Q3 = " + q3);
        System.out.println("Value = " + value);

        return StaticsUtil.round(value);
    }

    private double[] createDataSet(double[] X, double[] F) {

        List<Double> list = new ArrayList<>();

        for (int i = 0; i < X.length; i++) {
            for (int f = 0; f < F[i]; f++) {
                list.add(X[i]);
            }
        }

        return list.stream().sorted().mapToDouble(i -> i).toArray();
    }

}
