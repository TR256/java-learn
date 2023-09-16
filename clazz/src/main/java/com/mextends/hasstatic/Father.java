package com.mextends.hasstatic;

/**
 * @author: tr256
 * @time: 2023/9/7
 */

class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}

class Son extends Father{

    Person person = new Person("Son");

    static {
        System.out.println("son static");
    }

    public Son() {
        System.out.println("son constructor");
    }
}

public class Father {

    Person person = new Person("Father");

    static {
        System.out.println("father static");
    }

    public Father() {
        System.out.println("father constructor");
    }

    public static void main(String[] args) {
        new Son();
    }
}
