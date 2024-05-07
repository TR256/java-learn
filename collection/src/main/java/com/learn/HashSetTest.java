package com.learn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: MengXH
 * @time: 2023/11/7
 * @description:
 */
public class HashSetTest {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        boolean removed = set.remove(null);

        System.out.println(removed);
    }
}
