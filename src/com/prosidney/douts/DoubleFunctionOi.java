package com.prosidney.douts;

import java.util.function.DoubleFunction;

/**
 * Created by Sidney on 2017-02-14.
 */
public class DoubleFunctionOi {
    public static void main(String[] args){
        DoubleFunction<String> df = x->{
          if (x > 5){
              return "maior que 5";
          } else {
              return "menor que 5";
          }
        };

        System.out.println(df.apply(6));
        System.out.println(df.apply(4));
    }
}
