package com.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: MengXH
 * @time: 2023/11/7
 * @description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        String s = map.get(null);
        System.out.println(s);

    }
}
