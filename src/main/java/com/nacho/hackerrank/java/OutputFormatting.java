package com.nacho.hackerrank.java;

import org.junit.Assert;
import org.junit.Test;

public class OutputFormatting {

    @Test
    public void test() {
        OutputFormatting format = new OutputFormatting();

        Assert.assertEquals("java           100", format.formatString("java", 100));
        Assert.assertEquals("cpp            065", format.formatString("cpp", 65));
        Assert.assertEquals("python         050", format.formatString("python", 50));

    }

    /**
     * Input Format:
     * Every line of input will contain a String followed by an integer.
     * Each String will have a maximum of 10 alphabetic characters, and each integer will be
     * in the inclusive range from 0 to 999.
     *
     * Output Format:
     * In each line of output there should be two columns:
     * The first column contains the String and is left justified using exactly 15 characters.
     * The second column contains the integer, expressed in exactly 3 digits; if the original
     * input has less than three digits, you must pad your output's leading digits with zeroes.
     * @param str
     * @return
     */
    public String formatString(String str, int n) {
        return String.format("%-15s%03d", str, n);
    }


}
