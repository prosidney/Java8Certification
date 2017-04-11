package com.prosidney.java8.douts;

import java.util.stream.LongStream;

/**
 * Created by Sidney on 2017-01-18.
 */
public class SideEffectSum {
    public static void main(String args[]){
        System.out.println(sideEffectSum(10));
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }
}
