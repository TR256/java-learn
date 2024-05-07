package com.basis;

import java.util.HashMap;
import java.util.Map;

/**
 * JAVA中的数据都是值传递
 *
 * @author MengXH
 * @date 2023/11/24
 */
public class ValueTransportTest {
    /**
     * 基本数据类型为值传递
     *
     * @param integer
     */
    public static void transform(Integer integer) {
        System.out.println(integer + "\t" + integer.hashCode());
        integer = 0;
        System.out.println(integer + "\t" + integer.hashCode());
    }

    public static void testInteger() {
        Integer integer0 = 100;
        transform(integer0);
        System.out.println(integer0 + "\t" + integer0.hashCode());

        System.out.println("---------------");

        Integer integer1 = new Integer(100);
        transform(integer1);
        System.out.println(integer1 + "\t" + integer1.hashCode());
    }

    /**
     * String类使用final修饰
     *
     * @param string
     */
    public static void transform(String string) {
        System.out.println(string + "\t" + string.hashCode());
        string = "CHANGE";
        System.out.println(string + "\t" + string.hashCode());
    }

    public static void testString() {
        String string = "STRING";
        transform(string);
        System.out.println(string + "\t" + string.hashCode());
    }

    public static void transform(Map<String, Integer> map) {
        System.out.println(map.hashCode());
        map = new HashMap<>();
        map.put("ONE", 1);
        System.out.println(map.hashCode());
        System.out.println(map.get("ONE"));
    }

    public static void addDataToMap(Map<String, Integer> map) {
        System.out.println(map.hashCode());
        map.put("ONE", 1);
        System.out.println(map.hashCode());
    }


    public static void testHashMap() {
        Map<String, Integer> map = new HashMap<>();
        transform(map);
        System.out.println(map.hashCode() + "\t" + map.hashCode());
        System.out.println(map.get("ONE"));
        System.out.println("----");

        addDataToMap(map);
        System.out.println(map.hashCode() + "\t" + map.hashCode());
        System.out.println(map.get("ONE"));
    }

    public static void main(String[] args) {

        testInteger();
        System.out.println();
        testString();
        System.out.println();
        testHashMap();

    }
}
