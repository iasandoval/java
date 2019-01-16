package com.nacho.hackerrank.statics.util;

import java.text.DecimalFormat;

public abstract class StaticsUtil {

    private StaticsUtil() {
        // Private constructor
    }

    public static int[] parseIntArray(String args) {
        String[] values = args.split(" ");
        int[] result = new int[values.length];

        for(int i = 0; i<values.length; i++) {
            result[i] = Integer.valueOf(values[i]);
        }

        return result;
    }

    public static double[] parseDoubleArray(String args) {
        String[] values = args.split(" ");
        double[] result = new double[values.length];

        for(int i = 0; i<values.length; i++) {
            result[i] = Double.valueOf(values[i]);
        }

        return result;
    }

    public static double roundDF(double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.valueOf(df.format(value));
    }

    public static double round(double value, int digits) {
        return Math.round(value * (Math.pow(10, digits)) / Math.pow(10, digits));
    }
}
