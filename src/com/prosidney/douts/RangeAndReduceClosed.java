package com.prosidney.douts;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * Created by admin on 27/01/17.
 */
public class RangeAndReduceClosed {
    public static void main(String[] args) throws IOException {
        /**
         * Closed means inclusive
         */
        IntStream is = IntStream.rangeClosed(1, 4);

        int sum = is.peek(a-> System.out.println(a))
                    .reduce(0, (a, b)->a+b);

        System.out.println(sum);


        /**
         * just range means exclusive
         */
        IntStream is1 = IntStream.range(1, 4);

        int sum1 = is1.peek(a-> System.out.println(a))
                .reduce(0, (a, b)->a+b);

        System.out.println(sum1);
    }
}
