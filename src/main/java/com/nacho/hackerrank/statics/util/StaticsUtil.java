package com.nacho.hackerrank.statics.util;

import java.text.DecimalFormat;

public abstract class StaticsUtil {

    private StaticsUtil() {
        // Private constructor
    }

    /**
     * This method will parse a String to int values separated by space.
     *
     * @param args The string containing the int values separated by space.
     * @return An array of int.
     */
    public static int[] parseIntArray(String args) {
        String[] values = args.split(" ");
        int[] result = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = Integer.valueOf(values[i]);
        }

        return result;
    }

    /**
     * This method will parse a String to double values separated by space.
     *
     * @param args The string containing the double values separated by space.
     * @return An array of double.
     */
    public static double[] parseDoubleArray(String args) {
        String[] values = args.split(" ");
        double[] result = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = Double.valueOf(values[i]);
        }

        return result;
    }

    /**
     * This method will round to 1 decimal digit (Ex. 12.3).
     *
     * @param value Value to round.
     * @return Rounded value to 1 decimal digit (Ex. 12.3)
     */
    public static double round(double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.valueOf(df.format(value));
    }
}
