package com.prosidney.formatting;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by admin on 24/01/17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Locale.getDefault();

        double x = 12345.123;

        /**
         * Formatting numbers
         */
        NumberFormat.getInstance().format(x);
        NumberFormat.getInstance(Locale.GERMANY).format(x);

        final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat.getCurrencyInstance(Locale.GERMANY);

        final NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        NumberFormat.getIntegerInstance(Locale.GERMANY);

        NumberFormat.getNumberInstance();
        NumberFormat.getNumberInstance(Locale.GERMANY);

        NumberFormat.getPercentInstance();
        NumberFormat.getPercentInstance(Locale.GERMANY);

        /**
         * Formatting dates
         */
        final Date dt = new Date();

        DateFormat.getInstance().format(dt);

        DateFormat.getDateInstance();
        DateFormat.getDateInstance(DateFormat.DEFAULT);
        DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.UK).format(dt);

        DateFormat.getTimeInstance();
        DateFormat.getTimeInstance(DateFormat.DEFAULT);
        DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.UK).format(dt);

        DateFormat.getDateTimeInstance();
        DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);
        DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.UK).format(dt);


        Locale.setDefault(Locale.CHINESE);


        DateFormat df = DateFormat.getDateInstance();
        final String formatted = df.format(dt);
        System.out.println(formatted);

        df.parse("");


        LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);//T17:13:50");
        LocalDate d2 = LocalDate.of(2015, 2, 5);
        LocalDate d3 = LocalDate.now();
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

    }
}
