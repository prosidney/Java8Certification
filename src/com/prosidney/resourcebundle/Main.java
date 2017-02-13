package com.prosidney.resourcebundle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by admin on 25/01/17.
 */
public class Main {
    public static void main(String args[]){
        final Locale locale = new Locale("en", "UK");
        Locale myloc = new Locale.Builder().setLanguage("en").setRegion("UK").build(); //L1
        ResourceBundle msgs = ResourceBundle.getBundle("mymsgs", myloc);

        Enumeration<String> en = msgs.getKeys();
        while(en.hasMoreElements()){
            String key = en.nextElement();
            String val = msgs.getString(key);
            System.out.println(key+" : "+val);
        }

        final TemporalAdjuster adjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);

        final LocalDate with = LocalDate.now().with(adjuster);
        System.out.println(with);

    }
}
