package com.prosidney.resourcebundle;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by admin on 25/01/17.
 */
public class Main {
    public static void main(String args[]){
        Locale myloc = new Locale.Builder().setLanguage("en").setRegion("UK").build(); //L1
        ResourceBundle msgs = ResourceBundle.getBundle("mymsgs", myloc);

        Enumeration<String> en = msgs.getKeys();
        while(en.hasMoreElements()){
            String key = en.nextElement();
            String val = msgs.getString(key);
            System.out.println(key+" : "+val);
        }

    }
}
