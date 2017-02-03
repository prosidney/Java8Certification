package com.prosidney.douts;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by admin on 03/02/17.
 */
public class HangExample {
    public static void main(String[] args){

        DoubleStream random = DoubleStream. generate (Math::random);
        DoubleStream fractions = DoubleStream. iterate (.5, d -> d / 2);
        random.forEach(System.out::println);


    }
}
