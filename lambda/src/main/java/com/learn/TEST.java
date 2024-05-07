package com.learn;

/**
 * @author MengXH
 * @date 2023/12/21
 */
public class TEST {

    public static void main(String[] args) {
        System.out.println(String.class.isAssignableFrom(CharSequence.class));
        System.out.println(String.class.equals(CharSequence.class));
        System.out.println(CharSequence.class.isAssignableFrom(String.class));
    }
}
