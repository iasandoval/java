package com.nacho.hackerrank.bank;

import org.junit.Assert;
import org.junit.Test;

public class SwapValues {

    @Test
    public void test() {
        int a = 4;
        int b = 7;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Swap Values without creating a temp variable
        a = a+b;
        b = a-b;
        a = a-b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Assert.assertEquals(7, a);
        Assert.assertEquals(4, b);
    }

}
