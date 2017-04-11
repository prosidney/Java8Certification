package com.prosidney.java8.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sidney on 2017-01-30.
 */
public class PeriodConversion {
    public static void main(String args[]){
        Period p = Period.ofDays(35);
        System.out.println(p);

        Duration duration = Duration.ofHours(25);
        System.out.println(duration);

        Duration duration1 = Duration.ofDays(1);
        System.out.println(duration1);

        final LocalDateTime of = LocalDateTime.of(2015, 5, 5, 5, 5);
        final String format = DateTimeFormatter.ISO_ZONED_DATE_TIME.format(of);
    }
}
