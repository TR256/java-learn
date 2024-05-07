package com.clazz.extend;

/**
 * @author: tr256
 * @time: 2023/9/7
 */

public class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}
