package com.learn;

import java.io.Console;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class SystemClass {

    public static void properties() {
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            Object element = enumeration.nextElement();
            System.out.printf("%s\t\t%s\n", element.toString(), properties.getProperty(element.toString()));
        }
    }

    public static void env() {
        Map<String, String> envMap = System.getenv();
        envMap.forEach((key, value) -> {
            System.out.printf("%s\t%s\n", key, value);
        });
    }


    public static void console() {
        Console console = System.console();
        console.printf("%s\n", "OK");
    }


    public static void main(String[] args) {
//        SystemClass.properties();
//        System.out.println(System.getenv("INCLUDE"));
//        System.out.println(System.getenv("LIB"));
//        SystemClass.env();
//        SystemClass.console();
        String path = System.getenv().get("Path");
        path = path + ";D:/SC-OFD/libs/pdf2ofd";
        System.getenv().replace("Path", path);
        System.out.println(System.getenv().get("Path"));
    }

}
