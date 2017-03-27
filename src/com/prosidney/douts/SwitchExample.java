package com.prosidney.douts;

/**
 * Created by admin on 25/01/17.
 */
public class SwitchExample {

    public static void main(String[] args) {
        String[] input = new String[2];
        input[0] = "a";
        input[1] = "A";

        test(input);
    }

    public static void test(String[] args){
        final String verificator2 = "b";
        final String verificator = "a";
        String opa = "opa";
        for(String arg : args){
            switch(opa){
                case verificator : System.out.println("great!");
                    break;
                case verificator2 : System.out.println("great!");
                    break;
                default : System.out.println("unknown");
            }
        }
    }
}
