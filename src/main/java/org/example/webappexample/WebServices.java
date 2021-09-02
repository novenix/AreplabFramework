package org.example.webappexample;

import org.example.nextspring.GetMapping;

public class WebServices {
    @GetMapping("/fecha")
    public static String date(String s){
        return java.time.LocalTime.now().toString();
    }
}
