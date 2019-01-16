package com.nacho.hackerrank.statics;

import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MeanMedianMode {

    private double mean;
    private double median;
    private double mode;

    @Test
    public void test() {

        MeanMedianMode meanMedianMode = new MeanMedianMode();
        meanMedianMode.calculate("64630 11735 14216 99233 14470 4978 73429 38120 51135 67060");

        System.out.println(meanMedianMode.getMean());
        System.out.println(meanMedianMode.getMedian());
        System.out.println(meanMedianMode.getMode());

        Assert.assertTrue(43900.6 == meanMedianMode.getMean());
        Assert.assertTrue(44627.5 == meanMedianMode.getMedian());
        Assert.assertTrue(4978 == meanMedianMode.getMode());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        MeanMedianMode meanMedianMode = new MeanMedianMode();
        meanMedianMode.calculate(s);

        System.out.println(meanMedianMode.getMean());
        System.out.println(meanMedianMode.getMedian());
        System.out.println(meanMedianMode.getMode());
    }


    /**
     * Task
     * Given an array, X, of N integers, calculate and print the respective mean, median, and mode
     * on separate lines. If your array contains more than one modal value, choose the
     * numerically smallest one.
     *
     * Note: Other than the modal value (which will always be an integer), your answers should be
     * in decimal form, rounded to a scale of 1 decimal place (i.e., 12.3, 7.0 format).
     *
     * Input Format
     * The first line contains an integer, N, denoting the number of elements in the array.
     * The second line contains N space-separated integers describing the array's elements.
     *
     * Output Format
     * Print  lines of output in the following order:
     *
     * Print the mean on a new line, to a scale of  decimal place (i.e., 12.3, 7.0).
     * Print the median on a new line, to a scale of  decimal place (i.e., 12.3, 7.0).
     * Print the mode on a new line; if more than one such value exists, print the numerically smallest one.
     */
    public void calculate (String args) {

        double[] values = StaticsUtil.parseDoubleArray(args);

        this.mean =  StaticsUtil.roundDF(this.mean(values));
        this.median = StaticsUtil.roundDF(this.median(values));
        this.mode = StaticsUtil.roundDF(this.mode(values));
    }

    private double mean(double[] args) {
        double mean = 0;

        for(int i = 0; i<args.length; i++) {
            mean += args[i];
        }

        return mean/args.length;
    }

    private double median(double[] args) {
        double median;
        Arrays.sort(args);

        if(args.length%2 == 0) {
            median = (args[args.length/2] + args[args.length/2 - 1])/2;
        } else {
            median = args[args.length/2];
        }

        return median;
    }

    private double mode(double[] args){
        Arrays.sort(args);

        Map<Double, Integer> modeMap = new HashMap<>();

        double vTemp = 0;
        double vCount = 0;

        for(int i = 0; i<args.length; i++) {
            int value = (modeMap.get(args[i]) != null)?modeMap.get(args[i]):0;
            int counter = new AtomicInteger(value).incrementAndGet();

            if (counter > vCount) {
                vTemp = args[i];
                vCount = counter;
            }

            modeMap.put(args[i], counter);

        }

        return vTemp;
    }

    public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    public double getMode() {
        return mode;
    }
}
