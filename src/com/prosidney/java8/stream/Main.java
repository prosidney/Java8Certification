package com.prosidney.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

/**
 * Created by admin on 17/01/17.
 */
public class Main {
    public static void main(String args[]){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        final double sum = transactions.stream().mapToDouble(Transaction::getValue).sum();
        System.out.println(sum);

        List<Transaction> question1 =
                transactions.stream()
                        .filter(a -> 2011 == a.getYear())
                        .sorted(Comparator.comparing(Transaction::getValue))
                        .collect(toList());

        System.out.println(question1);

        List<String> question2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(toList());

        System.out.println(question2);

        List<Trader> question3 = transactions.stream()
                .filter(a -> "Cambridge".equals(a.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());

        System.out.println(question3);

        List<String> question4 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(trader -> trader.getName().split(""))
                .flatMap(Arrays::stream)
                .collect(toList());

        System.out.println(question4);

       Boolean question5 = transactions.stream()
                .filter(a -> "Cambridge".equals(a.getTrader().getCity()))
                .count() > 0;

        System.out.println(question5);

       Boolean question5_1 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Cambridge"));

        System.out.println(question5_1);

       transactions.stream()
                .filter(a -> "Cambridge".equals(a.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Integer question7 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(0, (a, b) -> Integer.max(a, b));

        System.out.println(question7);

        Optional<Integer> question8 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min);

        System.out.println(question8.get());

        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .min(comparing(Transaction::getValue));

        System.out.println(smallestTransaction.get());
    }
}
