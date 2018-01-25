package com.nacho.algorithms.analysis;

public class AnalysisExamples {

    public static void main(String[] args) {
	
	
	final int[] aNumbers = {1000, 5000, 10000, 20000, 40000, 50000, 100000, 500000, 1000000};
	final char c = '*';
	
	StringVsStringBuilder compare = new StringVsStringBuilder();
	compare.testStringVsStringBuilder(c, aNumbers);
	
	

    }
}
