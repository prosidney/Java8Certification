package com.prosidney.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by admin on 24/01/17.
 */
public class Main {
    public static void main(String args[]){

        /**
         *                                  Creating LocalDate
         */
        final LocalDate localDate = LocalDate.of(2015, 05, 05);
        /**
         *                              Creating LocalDate with parser
         */
        final LocalDate localDateParsed = java.time.LocalDate.parse("2015-01-01");
        /**==============================================================================
         *                                      Creating LocalTime
         */
        final LocalTime localTime = LocalTime.of(12, 35, 05);
        /**
         * Creating LocalTime with parser
         */
        final LocalTime localTimeParsed = java.time.LocalTime.parse("a valid time(JUST TIME)");
        /**==============================================================================
         *                                    Creating LocalDateTime
         */
        final LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        /**
         *                                  Creating LocalDateTime with parser
         */
        final LocalDateTime localDateTimeParsed = java.time.LocalDateTime.parse("a valid datetime(DATE AND TIME)");
        /**==============================================================================
         *                                      Creating ZoneId
         */
        final ZoneId ect = ZoneId.of("ECT");
        /**==============================================================================
         *                                      Creating ZonedDateTime
         */
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ect);
        /**
         *                                  Creating ZonedDateTime with parser
         */
        final ZonedDateTime zonedDateTimeParsed =
                java.time.ZonedDateTime.parse("a valid zonedDateTime(DATE, TIME AND TIMEZONE)");
        /**==============================================================================
         *                                          Formatting <any>Date
         */
        final String localDateFormatted = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
