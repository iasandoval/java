package com.nacho.algorithms.analysis;

/**
 * Class to compare the performance between String concatenation and
 * StringBuilder append methods.
 * 
 * @author iasandoval
 *
 */
public class StringVsStringBuilder {

    /**
     * Default constructor
     */
    public StringVsStringBuilder() {
	// Empty constructor
    }

    /**
     * This method will run the test to compare the performance between String
     * concatenate and StringBuilder append.
     * 
     * @param c Character to concatenate/append.
     * @param aNumbers Array of number of times that tha Character will be
     *            concatenated/appended.
     */
    public void testStringVsStringBuilder(char c, int[] aNumbers) {
	// Testing String concatenation
	for (int i = 0; i < aNumbers.length; i++) {
	    TimeResult resultStr = this.stringConcat(c, aNumbers[i]);
	    System.out.println("String concatenate results:" + resultStr.toString());
	}

	// Testing StringBuilder
	for (int i = 0; i < aNumbers.length; i++) {
	    TimeResult resultBld = this.builderAppend(c, aNumbers[i]);
	    System.out.println("StringBuilder append results:" + resultBld.toString());
	}
    }

    /**
     * This method will concatenate the character provided by n times, by using String + "" syntaxis.
     * 
     * @param c character to concatenate.
     * @param n Number to indicate the times this character will be concatenated.
     * @return TimeResult object with Number of characters and the time in
     *         milliseconds taken to concatenate the characters.
     */
    public TimeResult stringConcat(char c, int n) {

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
     *         milliseconds taken to append the characters.
     */
    public TimeResult builderAppend(char c, int n) {
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
