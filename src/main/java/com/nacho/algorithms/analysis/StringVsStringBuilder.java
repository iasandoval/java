package com.nacho.algorithms.analysis;

/**
 * Class to compare the performance between String concatenation and
 * StringBuilder append methods.
 *
 * @author iasandoval
 */
public class StringVsStringBuilder {

    /**
     * This method will concatenate the character provided by n times, by using String + "" syntaxis.
     *
     * @param c character to concatenate.
     * @param n Number to indicate the times this character will be concatenated.
     * @return TimeResult object with Number of characters and the time in
     * milliseconds taken to concatenate the characters.
     */
    public static TimeResult stringConcat(char c, int n) {

        long starTime = System.currentTimeMillis();

        String result = "";
        for (int i = 0; i < n; i++) {
            result += c;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - starTime;

        return new TimeResult(n, elapsedTime);
    }

    /**
     * This method will append the character provided by n times, by using StringBuilder append method.
     *
     * @param c character to concatenate.
     * @param n Number to indicate the times this character will be appended.
     * @return TimeResult object with Number of characters and the time in
     * milliseconds taken to append the characters.
     */
    public static TimeResult builderAppend(char c, int n) {
        long starTime = System.currentTimeMillis();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(c);
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - starTime;

        return new TimeResult(n, elapsedTime);
    }

}
