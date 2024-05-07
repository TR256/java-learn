package com.clazz.extend;

/**
 * @author: tr256
 * @time: 2023/9/7
 */

public class Father {

    Person person = new Person("Father");

    static {
        System.out.println("father static");
    }

    public Father() {
        System.out.println("father constructor");
    }

}
