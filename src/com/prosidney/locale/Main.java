package com.prosidney.locale;

import java.text.NumberFormat;
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
    }
}
