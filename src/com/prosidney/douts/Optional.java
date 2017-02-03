package com.prosidney.douts;

import java.util.stream.LongStream;

/**
 * Created by admin on 03/02/17.
 */
public class Optional {
    public static void main(String args[]) {
        LongStream longs = LongStream.of();
        long sum = longs.sum();
        System.out.println(sum);
    }
}
