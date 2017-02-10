package com.prosidney.newflavorsmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sidney on 2017-02-09.
 */
public class Main {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("greg", "dave", "don", "ed", "fred", "fiona");

        Map<Integer, List<String>> collect = names.stream().collect(
                Collectors.groupingBy(String::length)
        );

        collect.forEach((value, key) -> {
            System.out.println(""+value + key);
        });

        System.out.println("computing");
        collect.computeIfAbsent(2, (b) -> {
            System.out.println("b = " + b);
            List<String> opa = new ArrayList<>();
            opa.add("Adicionado depois");

            return opa;
        });
        System.out.println("computed");
        collect.forEach((value, key) -> {
            System.out.println(""+value + key);
        });
    }
}
