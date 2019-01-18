package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class WeightedMean {

    @Test
    public void test() {

        double[] X = StaticsUtil.parseDoubleArray("10 40 30 50 20");
        double[] W = StaticsUtil.parseDoubleArray("1 2 3 4 5");

        WeightedMean weightedMean = new WeightedMean();

        double mean = StaticsUtil.round(weightedMean.calculate(X, W));

        System.out.println(mean);

        Assert.assertTrue(32 == mean);
    }

    /**
     * Task
     * Given an array, X, of N integers and an array, W, representing the respective weights of X's elements,
     * calculate and print the weighted mean of X's elements.
     * Your answer should be rounded to a scale of  decimal place (i.e., 12.3 format).
     * <p>
     * Input Format
     * The first line contains an integer, N, denoting the number of elements in arrays X and W.
     * The second line contains N space-separated integers describing the respective elements of array X.
     * The third line contains N space-separated integers describing the respective elements of array W.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String Xs = scan.nextLine();
        String Ws = scan.nextLine();
        scan.close();

        double[] X = StaticsUtil.parseDoubleArray(Xs);
        double[] W = StaticsUtil.parseDoubleArray(Ws);

        WeightedMean weightedMean = new WeightedMean();

        System.out.println(StaticsUtil.round(weightedMean.calculate(X, W)));
    }

    public double calculate(double[] X, double[] W) {
        double sup = 0;
        double inf = 0;

        for (int i = 0; i < X.length; i++) {
            sup += (X[i] * W[i]);
            inf += W[i];
        }

        return sup / inf;
    }

}
