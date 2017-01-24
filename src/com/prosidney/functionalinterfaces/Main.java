package com.prosidney.functionalinterfaces;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * Created by Sidney on 2017-01-18.
 */
public class Main {
    public static void main(String args[]){
        /**
         * Suplier nao recebe parametro e returna um valor
         */
        System.out.println("Suplier");

        Supplier<String> supplier = () -> "supplier rocks";
        System.out.println(supplier.get().toUpperCase());

        System.out.println("========================================");
        /**
         * Consumer recebe parametro e não retorna nada(void)
         */
        System.out.println("Consumer");

        Consumer<Integer> consumerLong = p -> System.out.println(p+10);
        consumerLong.accept(20);

        Consumer<Integer> consumerShort = System.out::println;
        consumerShort.accept(20);

        System.out.println("========================================");
        /**
         * BiConsumer recebe 2 parametros e não retorna nada(void)
         */
        System.out.println("BiConsumer");

        BiConsumer<BigDecimal, BigDecimal> biConsumer = (p, i) -> System.out.println(p.add(i));
        biConsumer.accept(new BigDecimal(5), new BigDecimal(5));

        System.out.println("========================================");
        /**
         * Predicate recebe 1 parametro e returna true/false (boolean)
         */
        System.out.println("Predicate");

        Predicate<String> predicate = "Sidney"::equals;
        System.out.println(predicate.test("Sidney"));

        System.out.println("========================================");
        /**
         * BiPredicate recebe 2 parametros e returna true/false (boolean)
         */
        System.out.println("BiPredicate");

        BiPredicate<String, String> biPredicate = (t,u) -> "Sidney".equals(t) && "Bruna".equals(u);
        System.out.println(biPredicate.test("Sidney", "Bruna"));

        System.out.println("========================================");
        /**
         * Function recebe 1 parametro e pode retornar de outro tipo
         */
        System.out.println("Function");

        Function<Integer, String> function = t -> "é o número " + t;
        System.out.println(function.apply(1));

        System.out.println("========================================");
        /**
         * BiFunction recebe 1 parametro e pode retornar de outro tipo
         */
        System.out.println("BiFunction");

        BiFunction<Integer, Integer, String> biFunction = (t, u) -> "A soma da " + t.sum(t, u);
        System.out.println(biFunction.apply(8, 9));

        System.out.println("========================================");
    }
}
