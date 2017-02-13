package com.prosidney.sumarizaraparadatoda;

import com.prosidney.stream.*;
import com.prosidney.stream.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sidney on 2017-02-10.
 */
public class Main {
    public static void main(String args[]){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<com.prosidney.stream.Transaction> transactions = Arrays.asList(
                new com.prosidney.stream.Transaction(brian, 2011, 300),
                new com.prosidney.stream.Transaction(raoul, 2009, 1000),
                new com.prosidney.stream.Transaction(raoul, 2011, 400),
                new com.prosidney.stream.Transaction(mario, 2005, 710),
                new com.prosidney.stream.Transaction(mario, 2012, 700),
                new com.prosidney.stream.Transaction(alan, 2013, 950)
        );


        transactions.stream()
                .mapToInt(Transaction::getYear)
                .max()
                .ifPresent(System.out::println);

        transactions.stream()
                .min(Comparator.comparing(Transaction::getYear))
                .ifPresent(System.out::println);

        transactions.stream().collect(
                Collectors.groupingBy(tr->tr.getTrader(),
                        Collectors.toSet())).forEach((key, value) -> {
            System.out.println(key.getName());
            System.out.println(value);
        });

        transactions.stream().collect(
                Collectors.groupingBy(tr->tr.getTrader()))
                .forEach((key, value) -> {
            System.out.println(key.getName());

            value.stream().collect(
                    Collectors.groupingBy(tr -> tr.getYear(),
                            Collectors.toList()
                    )).forEach((key1, value1)->{
                System.out.println("    "+key1);
                System.out.println("        "+value1);
            });

        });


        //COLOCAR NO NOTES QUE SE TIVER .mapping, tem que ter o segundo parametro(downstream).
        List<Integer> collect =
                transactions.stream().collect(
                        Collectors.mapping(tr -> tr.getYear(),
                                Collectors.toList()
                        )
                );


        Map<Boolean, List<Transaction>> collect1 = transactions.stream().collect(
                Collectors.partitioningBy(t -> t.getValue() > 500)
        );

        System.out.println(collect1);


    }
}
