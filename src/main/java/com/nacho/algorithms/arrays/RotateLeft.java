package com.nacho.algorithms.arrays;

public class RotateLeft {

    /**
     * Given an array of integers (int[] a) and a number (int n), perform "n"
     * left rotations on the array.
     * Return the updated array to be printed as a single line of space-separated integers.
     *
     * Sample Input [1 2 3 4 5]
     * Sample Output [5 1 2 3 4]
     *
     * @param a Array of integers.
     * @param n Number to perform left rorations.
     * @return Updated array.
     */
    public static int[] rotateLeft(int[] a, int n) {

        int[] r = a.clone();

        int aSize = r.length;

        for(int i = 0; i<aSize; i++){
            int pos = (i+n) % aSize;
            r[i] = a[pos];
        }

        return r;
    }
}
