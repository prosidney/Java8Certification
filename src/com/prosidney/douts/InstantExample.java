package com.prosidney.douts;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Created by admin on 06/02/17.
 */
public class InstantExample {

    public static void main(String args[]){
        final Instant parse = Instant.parse("2015-06-25T16:43:30.00z");

        final Instant plus = parse.plus(10, ChronoUnit.DAYS);

        System.out.println(plus);
    }

}
