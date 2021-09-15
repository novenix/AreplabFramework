package org.example.webappexample;
import org.example.HttpServer;
import org.example.nextspring.Components;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WebAppStart {
    public static void main(String[] args) {
        try {
            HttpServer
                    .getInstance()
                    .startServer(getComponentsAnnotation(new File("./src/main/java/" + WebAppStart.class.getPackage().getName().replace(".", "/"))));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getComponentsAnnotation(File file) {
        List<String> getClasses= new ArrayList<>();
        if (file.isDirectory()) {
            for (File source : file.listFiles()) {
                getClasses.addAll(getComponentsAnnotation(source));
            }
        } else {
            if (file.getName().endsWith(".java")) {
                String[] getPath = file.getPath().replace(".java", "").split("\\\\");
                String Files = "";
                for (int i = 4; i < getPath.length; i++) {
                    Files += (i == getPath.length - 1) ? getPath[i] : getPath[i] + ".";
                }
                try {
                    Class c = Class.forName(Files);
                    if (c.isAnnotationPresent(Components.class)) {
                        getClasses.add(Files);
                    }
                } catch (ClassNotFoundException e) {
                    Logger.getLogger(WebAppStart.class.getName()).log(Level.SEVERE, "Component not found", e);
                }
            }
        }
        return getClasses;
    }
}