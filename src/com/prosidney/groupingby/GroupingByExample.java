package com.prosidney.groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by admin on 03/02/17.
 */
public class GroupingByExample {
    public static void main(String args[]){
        List<String> names = Arrays.asList("greg", "dave", "don", "ed", "fred", "fiona");


        final Map<String, List<String>> collect =
                names.stream().collect(
                        Collectors.groupingBy(a -> a.substring(0, 1),
                                Collectors.mapping(String::toUpperCase, Collectors.toList()))
                );
        System.out.println(collect);


        OptionalInt min = names.stream().mapToInt(String::length).min();
        System.out.println(min);

        OptionalInt max = names.stream().map(String::length).mapToInt(x -> x).max();
        max.ifPresent(x->System.out.println(x));

        AtomicInteger counting = new AtomicInteger(0);
        boolean allMatch = names.stream().allMatch(x -> {
            counting.incrementAndGet();
            return x.startsWith("s");
        });

        System.out.println(counting.get());
    }
}
