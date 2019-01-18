package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class StandardDeviation {

    @Test
    public void test() {
        StandardDeviation standardDeviation = new StandardDeviation();

        double[] N = StaticsUtil.parseDoubleArray("10 40 30 50 20");
        double value = standardDeviation.calculate(N);

        System.out.println(StaticsUtil.round(value));

        Assert.assertTrue(14.1 == StaticsUtil.round(value));
    }

    /**
     * Task
     * Given an array, X, of N integers, calculate and print the standard deviation.
     * Your answer should be in decimal form, rounded to a scale of 1 decimal place (i.e., 12.3 format).
     * An error margin of +-0.1 will be tolerated for the standard deviation.
     * <p>
     * Input Format
     * The first line contains an integer, N, denoting the number of elements in the array.
     * The second line contains N space-separated integers describing the respective elements of the array.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        double[] N = StaticsUtil.parseDoubleArray(s);
        StandardDeviation standardDeviation = new StandardDeviation();

        double value = standardDeviation.calculate(N);

        System.out.println(StaticsUtil.round(value));
    }

    public double calculate(double[] N) {
        // First we calculate the Mean
        double mean = MeanMedianMode.mean(N);

        // Next, we calculate the squared distance from the mean, for each element
        double sum = 0;
        for (double n : N) {
            sum += this.sqtDistance(n, mean);
        }

        // Finally, we calculate the standard deviation
        double value = Math.sqrt(sum / N.length);

        return value;
    }

    private double sqtDistance(double value, double mean) {
        return Math.pow((value - mean), 2);
    }
}
