package com.prosidney.locale;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by admin on 24/01/17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        double x = 12345.123;

        /**
         * Formatting number without Locale
         */
        String str = NumberFormat.getInstance().format(x);
        System.out.println(str);

        /**
         * Formatting number with Locale Chinese
         */
        String strChinese = NumberFormat.getInstance(Locale.GERMANY).format(x);
        System.out.println(strChinese);


        Locale.setDefault(Locale.CHINESE);

        DateFormat df = DateFormat.getDateInstance();
        final String formatted = df.format(new Date());
        System.out.println(formatted);


        LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);//T17:13:50");
        LocalDate d2 = LocalDate.of(2015, 2, 5);
        LocalDate d3 = LocalDate.now();
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

    }
}
