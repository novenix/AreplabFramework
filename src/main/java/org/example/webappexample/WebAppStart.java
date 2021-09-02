package org.example.webappexample;

import org.example.HttpServer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebAppStart {
    public static void main(String[] args){
        try {
            HttpServer.getInstance().startServer(args);
        } catch (IOException e) {
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE,"null",e);
        } catch (URISyntaxException e) {
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE,"null",e);
        }
    }
}
