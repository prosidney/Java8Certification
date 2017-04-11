package com.prosidney.java8.douts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 25/01/17.
 */
public class MapMergeExample {
    public static void main(String args[]) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 1);
        map1.put("c", null);

        map1.merge("b", 2, (i1, i2)->10+i2);
        map1.merge("c", 3, (i1, i2)->i1+i2);

        System.out.println(map1);
    }
}
