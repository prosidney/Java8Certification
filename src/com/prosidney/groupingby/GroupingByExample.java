package com.prosidney.groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by admin on 03/02/17.
 */
public class GroupingByExample {
    public static void main(String args[]){
        List<String> names = Arrays.asList("greg", "dave", "don", "ed", "fred", "fiona" );


        final Map<String, List<String>> collect =
                names.stream().collect(
                        Collectors.groupingBy(a -> a.substring(0, 1))
                );


        System.out.println(collect);
    }
}
