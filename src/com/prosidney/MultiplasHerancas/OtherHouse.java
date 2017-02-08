package com.prosidney.MultiplasHerancas;

/**
 * Created by Sidney on 2017-02-06.
 */
public interface OtherHouse extends House{
    public default String getAddress(){
        return "Lange Achteromstraat";
    }
}
