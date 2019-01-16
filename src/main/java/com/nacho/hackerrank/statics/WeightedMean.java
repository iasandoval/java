package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class WeightedMean {

    private double mean;

    @Test
    public void test() {

        WeightedMean weightedMean = new WeightedMean();
        weightedMean.calculate("10 40 30 50 20", "1 2 3 4 5");

        System.out.println(weightedMean.getMean());

        Assert.assertTrue(32f == weightedMean.getMean());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String X = scan.nextLine();
        String W = scan.nextLine();
        scan.close();

        WeightedMean weightedMean = new WeightedMean();
        weightedMean.calculate(X, W);

        System.out.println(weightedMean.getMean());
    }

    /**
     * Task
     * Given an array, X, of N integers and an array, W, representing the respective weights of X's elements,
     * calculate and print the weighted mean of X's elements.
     * Your answer should be rounded to a scale of  decimal place (i.e., 12.3 format).
     *
     * Input Format
     * The first line contains an integer, N, denoting the number of elements in arrays X and W.
     * The second line contains N space-separated integers describing the respective elements of array X.
     * The third line contains N space-separated integers describing the respective elements of array W.
     */
    public void calculate (String X, String W) {
        double[] valuesX = StaticsUtil.parseDoubleArray(X);
        double[] valuesW = StaticsUtil.parseDoubleArray(W);

        this.mean = this.weightedMean(valuesX, valuesW);

    }

    private double weightedMean(double[] X, double[] W) {
        double sup = 0;
        double inf = 0;

        for(int i = 0; i<X.length; i++) {
            sup += (X[i]*W[i]);
            inf += W[i];
        }

        return StaticsUtil.roundDF(sup/inf);
    }

    public double getMean() {
        return mean;
    }
}
