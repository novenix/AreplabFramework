package org.example.webappexample;

import org.example.nextspring.GetMapping;

public class MathServices {
    @GetMapping(value="/square")
    public static Double square(String n){
        Double number = Double.valueOf(n);
        return number *number;
    }
    @GetMapping(value="/PI")
    public static Double PI(String n){
        Double number = Double.valueOf(n);
        return Math.PI;
    }
    @GetMapping(value="/strcount")
    public static String length(String s){
        //Double number = Double.valueOf(n);
        return "the length of string is:"+s.length();
    }
}
