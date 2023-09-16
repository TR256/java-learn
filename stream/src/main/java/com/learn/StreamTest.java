package com.learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: tr256
 * @time: 2023/9/16
 */
public class StreamTest {

    public static void testFilter(List<EntityBean> beanList) {
        List<EntityBean> filterList = beanList.stream().filter(item -> item.getOk() == true).collect(Collectors.toList());
        for (EntityBean entityBean : filterList) {
            System.out.println(entityBean);
        }
    }

    public static void testSort(List<EntityBean> beanList) {
        List<EntityBean> sortedList = beanList.stream().sorted(Comparator.comparingInt(EntityBean::getId)).collect(Collectors.toList());
        for (EntityBean entityBean : sortedList) {
            System.out.println(entityBean);
        }
    }


    public static void testMap(List<EntityBean> beanList) {
        List<Integer> mapList = beanList.stream().map(EntityBean::getId).collect(Collectors.toList());
        for (Integer integer : mapList) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        List<EntityBean> beanList = new ArrayList<>();
        beanList.add(new EntityBean(1, "one", true));
        beanList.add(new EntityBean(4, "four", true));
        beanList.add(new EntityBean(5, "five", false));
        beanList.add(new EntityBean(3, "three", false));
        beanList.add(new EntityBean(2, "two", true));
        beanList.add(new EntityBean(6, "six", true));

        System.out.println("====ORIGIN====");
        for (EntityBean entityBean : beanList) {
            System.out.println(entityBean);
        }

        System.out.println("\n====FILTER====");
        testFilter(beanList);

        System.out.println("\n====SORT====");
        testSort(beanList);

        System.out.println("\n====GET ONE PROPERTY LIST====");
        testMap(beanList);

    }
}
