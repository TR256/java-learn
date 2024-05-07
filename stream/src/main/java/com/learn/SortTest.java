package com.learn;

import java.util.*;

/**
 * @author: MengXH
 * @time: 2023/11/7
 * @description:
 */
public class SortTest {


    public static void main(String[] args) {

        Random random = new Random();
        int size = 100000;
        List<StreamBean> beanList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            StreamBean bean = new StreamBean(i,
                    random.nextInt(), String.valueOf(random.nextInt()),
                    random.nextInt(), String.valueOf(random.nextInt()),
                    random.nextInt(), String.valueOf(random.nextInt()));
            beanList.add(bean);
        }

        Optional<StreamBean> first = beanList.stream().sorted(Comparator.comparingInt(StreamBean::getId)).findFirst();

        System.out.println(first.get().getId());

        Optional<StreamBean> first1 = beanList.stream().sorted((o1, o2) -> o1.getId() >= o2.getId() ? 1 : -1).findFirst();

        System.out.println(first1.get().getId());

        Optional<StreamBean> max = beanList.stream().max(Comparator.comparingInt(StreamBean::getId));

        System.out.println(max.get().getId());
    }
}
