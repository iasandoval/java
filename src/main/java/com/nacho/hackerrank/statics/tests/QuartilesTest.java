package com.nacho.hackerrank.statics.tests;

import com.nacho.hackerrank.statics.Quartiles;
import com.nacho.hackerrank.statics.util.StaticsUtil;
import org.junit.Assert;
import org.junit.Test;

public class QuartilesTest {

    @Test
    public void test() {

        double[] X = StaticsUtil.parseDoubleArray("3 7 8 5 12 14 21 13 18");

        Quartiles quartiles = new Quartiles(X);

        System.out.println(quartiles.getQ1());
        System.out.println(quartiles.getQ2());
        System.out.println(quartiles.getQ3());

        Assert.assertTrue(6 == quartiles.getQ1());
        Assert.assertTrue(12 == quartiles.getQ2());
        Assert.assertTrue(16 == quartiles.getQ3());
    }
}
