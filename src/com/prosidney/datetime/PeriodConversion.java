package com.prosidney.datetime;

import java.time.Duration;
import java.time.Period;

/**
 * Created by Sidney on 2017-01-30.
 */
public class PeriodConversion {
    public static void main(String args[]){
        Period p = Period.ofDays(35);

        System.out.println(p);

        Duration duration = Duration.ofHours(25);
        System.out.println(duration);
    }
}
