package com.prosidney.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by Sidney on 2017-02-02.
 */
public class MaxValue {
    public static void main(String args[]){
        List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);

        BinaryOperator<Integer> integerBinaryOperator = (a, b) -> a > b ? a : b;

        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, integerBinaryOperator));
        System.out.println(ls.stream().max(Integer::max).get());

        System.out.println(ls.stream().max((a, b) -> a > b ? a : b));
    }
}
