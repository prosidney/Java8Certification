package com.prosidney.java8.douts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 31/01/17.
 */
public class ChangingInForEach {
    public static void main(String[] args){
        List<String> dList = Arrays.asList("1", "2");

        dList.stream().forEach(x->{ x = x+10; });

        dList.stream().forEach(d->System.out.println(d));
        System.out.println(dList);
    }
}
