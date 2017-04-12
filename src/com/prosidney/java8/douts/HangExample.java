package com.prosidney.java8.douts;

import java.util.stream.DoubleStream;

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
