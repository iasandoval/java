package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MeanMedianMode {

    @Test
    public void test() {
        double[] N = StaticsUtil.parseDoubleArray("64630 11735 14216 99233 14470 4978 73429 38120 51135 67060");

        double mean = MeanMedianMode.mean(N);
        double median = MeanMedianMode.median(N);
        double mode = MeanMedianMode.mode(N);

        System.out.println("Mean = " + mean);
        System.out.println("Median = " + median);
        System.out.println("Mode = " + mode);

        Assert.assertTrue(43900.6 == mean);
        Assert.assertTrue(44627.5 == median);
        Assert.assertTrue(4978 == mode);
    }

    /**
     * Task
     * Given an array, X, of N integers, calculate and print the respective mean, median, and mode
     * on separate lines. If your array contains more than one modal value, choose the
     * numerically smallest one.
     * <p>
     * Note: Other than the modal value (which will always be an integer), your answers should be
     * in decimal form, rounded to a scale of 1 decimal place (i.e., 12.3, 7.0 format).
     * <p>
     * Input Format
     * The first line contains an integer, N, denoting the number of elements in the array.
     * The second line contains N space-separated integers describing the array's elements.
     * <p>
     * Output Format
     * Print  lines of output in the following order:
     * <p>
     * Print the mean on a new line, to a scale of  decimal place (i.e., 12.3, 7.0).
     * Print the median on a new line, to a scale of  decimal place (i.e., 12.3, 7.0).
     * Print the mode on a new line; if more than one such value exists, print the numerically smallest one.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        double[] N = StaticsUtil.parseDoubleArray(s);
        double mean = MeanMedianMode.mean(N);
        double median = MeanMedianMode.median(N);
        double mode = MeanMedianMode.mode(N);

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
    }

    public static double mean(double[] values) {
        double mean = 0;

        for (double value : values) {
            mean += value;
        }

        return mean / values.length;
    }

    public static double median(double[] values) {
        // To Calculate Median, array has to be sorted.
        Arrays.sort(values);

        double median;

        if (values.length % 2 == 0) {
            // Even
            median = (values[values.length / 2] + values[values.length / 2 - 1]) / 2;
        } else {
            // Odd
            median = values[values.length / 2];
        }

        return median;
    }

    public static double mode(double[] values) {
        // To Calculate Mode, array has to be sorted.
        Arrays.sort(values);

        Map<Double, Integer> modeMap = new HashMap<>();

        double vTemp = 0;
        double vCount = 0;

        for (double v : values) {
            int value = (modeMap.get(v) != null) ? modeMap.get(v) : 0;
            int counter = new AtomicInteger(value).incrementAndGet();

            if (counter > vCount) {
                vTemp = v;
                vCount = counter;
            }

            modeMap.put(v, counter);
        }

        return vTemp;
    }
}
