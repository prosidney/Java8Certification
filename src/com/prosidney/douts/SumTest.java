package com.prosidney.douts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 30/01/17.
 */
public class SumTest {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3);

        double sum = ls.stream().mapToInt(x->x).sum();
    }


}
