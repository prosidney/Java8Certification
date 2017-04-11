package com.prosidney.java8.douts;

import java.util.function.Function;

/**
 * Created by admin on 10/02/17.
 */
public class Calculator{
    public static void main(String[] args) {
        double principle = 100;
        int interestrate = 5;
        double amount = compute(principle, x->x*interestrate);
        System.out.println("depois");
        System.out.println(amount);
    }

    public static Integer compute(double base, Function<Integer, Integer > func){
        final Integer apply = func.apply((int) base);

        System.out.println(apply.getClass());
        System.out.println(apply);

        return apply;
    }
}
