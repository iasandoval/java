package com.nacho.hackerrank.fillshape;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillShapeTest {

    // Test Drop
    @Test
    public void test0() {
        // Matrix to fill
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0, 0, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 1, 0, 0));
        matrix.add(Arrays.asList(0, 1, 0, 1, 0));
        matrix.add(Arrays.asList(1, 0, 0, 0, 1));
        matrix.add(Arrays.asList(1, 0, 0, 0, 1));
        matrix.add(Arrays.asList(0, 1, 1, 1, 0));
        matrix.add(Arrays.asList(0, 0, 0, 0, 0));

        // Expected result
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0, 0, 0));
        expected.add(Arrays.asList(0, 0, 1, 0, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 0));
        expected.add(Arrays.asList(1, 1, 1, 1, 1));
        expected.add(Arrays.asList(1, 1, 1, 1, 1));
        expected.add(Arrays.asList(0, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 0, 0, 0, 0));

        List<List<Integer>> listFill = new FillShape2().fillShape(matrix);

        this.printFill(listFill);

        Assert.assertEquals(expected, listFill);
    }

    // Test Arrow
    @Test
    public void test1() {
        // Matrix to fill
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        matrix.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0));
        matrix.add(Arrays.asList(0, 1, 1, 1, 1, 1, 0));
        matrix.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0));
        matrix.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0));
        matrix.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0));
        matrix.add(Arrays.asList(0, 0, 1, 0, 1, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0));

        // Expected result
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        expected.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 0, 1, 1, 1, 0, 0));
        expected.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0));
        expected.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0));

        List<List<Integer>> listFill = new FillShape2().fillShape(matrix);

        this.printFill(listFill);

        Assert.assertEquals(expected, listFill);
    }

    // Test start
    @Test
    public void test2() {
        // Matrix to fill
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0));
        matrix.add(Arrays.asList(1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1));
        matrix.add(Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0));
        matrix.add(Arrays.asList(0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0));
        matrix.add(Arrays.asList(0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0));
        matrix.add(Arrays.asList(0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0));
        matrix.add(Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0));


        // Expected result
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        expected.add(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0));
        expected.add(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0));
        expected.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0));
        expected.add(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0));
        expected.add(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0));
        expected.add(Arrays.asList(0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0));
        expected.add(Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0));

        List<List<Integer>> listFill = new FillShape2().fillShape(matrix);

        this.printFill(listFill);

        Assert.assertEquals(expected, listFill);
    }

    private void printFill(List<List<Integer>> listFill) {
        for (List<Integer> r : listFill) {
            System.out.println(String.join(" ", String.valueOf(r)));
        }
    }
}
