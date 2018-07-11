package com.nacho.algorithms.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class RotateLeftTest {

    private final int[] input;
    private final int[] expected;
    private final int number;

    public RotateLeftTest(int[] i, int n, int[] e) {
        this.input = i;
        this.number = n;
        this.expected = e;
    }

    @Parameterized.Parameters(name = "{index}: rotateLeft({0},{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, 4, new int[]{5,1,2,3,4}},
                {new int[]{41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51}, 10, new int[]{77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77}},
                {new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97}, 13, new int[]{87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60}}
        });
    }

    @Test
    public void testRotateLeft() {

        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Number: " + number);
        System.out.println("Expected: " + Arrays.toString(expected));

        assertThat(RotateLeft.rotateLeft(input, number), is(expected));
    }
}
