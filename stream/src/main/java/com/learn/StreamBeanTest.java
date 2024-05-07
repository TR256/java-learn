package com.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: MengXH
 * @time: 2023/11/6
 * @description:
 */
public class StreamBeanTest {


    public static void main(String[] args) {

        Random random = new Random();
        int size = 1000000;
        List<StreamBean> beanList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            StreamBean bean = new StreamBean(random.nextInt(),
                    random.nextInt(), String.valueOf(random.nextInt()),
                    random.nextInt(), String.valueOf(random.nextInt()),
                    random.nextInt(), String.valueOf(random.nextInt()));
            beanList.add(bean);
        }

        Long start = System.currentTimeMillis();
        Set<Integer> ids = new HashSet<>();
        for (StreamBean bean : beanList) {
            if (bean.getK1() != null) {
                ids.add(bean.getId());
            }

            if (bean.getK2() != null) {
                ids.add(bean.getId());
            }

            if (bean.getK3() != null) {
                ids.add(bean.getId());
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);


        start = System.currentTimeMillis();
        Set<Integer> ids1 = new HashSet<>();
        for (StreamBean bean : beanList) {
            ids1.add(bean.getId());
            ids1.add(bean.getId());
            ids1.add(bean.getId());
        }
        ids1.remove(null);
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
