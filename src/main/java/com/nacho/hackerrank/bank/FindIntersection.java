package com.nacho.hackerrank.bank;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindIntersection {

    private static final Set<Integer> A = new HashSet<>(Arrays.asList(2,3,4));
    private static final Set<Integer> B = new HashSet<>(Arrays.asList(6,4,3,8));

    @Test
    public void test() {

        Set<Integer> intersection = new HashSet<>();

        for(int a : A) {
            if(B.contains(a)) {
                intersection.add(a);
            }
        }

        intersection.forEach((v) -> {System.out.println(v);});

    }


}
