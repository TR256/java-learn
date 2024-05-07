package com.clazz.extend;

/**
 * @author: tr256
 * @time: 2023/9/7
 */
public class Son extends Father{

    Person person = new Person("Son");

    static {
        System.out.println("son static");
    }

    public Son() {
        System.out.println("son constructor");
    }
}
