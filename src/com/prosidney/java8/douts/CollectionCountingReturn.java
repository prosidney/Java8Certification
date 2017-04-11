package com.prosidney.java8.douts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by admin on 25/01/17.
 */
public class CollectionCountingReturn {
    public static void main(String args[]){
        List<String> names = Arrays.asList("greg", "dave", "don", "ed", "fred" );

        Map<Integer, Long> data = names.stream().collect(Collectors.groupingBy(
                String::length,
                Collectors.counting()) );
        System.out.println(data.values());
    }
}
