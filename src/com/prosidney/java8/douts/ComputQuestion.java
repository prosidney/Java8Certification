package com.prosidney.java8.douts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 25/01/17.
 */
public class ComputQuestion {
    public static void main(String args[]) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 11);
        map1.put("b", 1);
        map1.put("c", null);

        map1.compute("a", (key, value)-> value > 10?value+1:value);

        map1.merge("c", 3, (i1, i2)->i1+i2);

        System.out.println(map1);
    }
}
