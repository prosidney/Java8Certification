package com.prosidney.java8.MultiplasHerancas;

/**
 * Created by Sidney on 2017-02-06.
 */
public interface OtherHouse extends House{
    public default String getAddress(){
        return "Lange Achteromstraat";
    }
}
