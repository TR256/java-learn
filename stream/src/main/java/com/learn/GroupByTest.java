package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MengXH
 * @date 2024/1/25
 */
class Bean{
    private Long id;
    private String name;

    public Bean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
public class GroupByTest {

    public static void main(String[] args) {

        List<Bean> beans = new ArrayList<>();
        beans.add(new Bean(2L, "NAME_1"));
        beans.add(new Bean(2L, "NAME_2"));
        beans.add(new Bean(4L, "NAME_3"));
        beans.add(new Bean(4L, "NAME_4"));
        beans.add(new Bean(6L, "NAME_5"));
        beans.add(new Bean(6L, "NAME_6"));
        beans.add(new Bean(8L, "NAME_7"));
        beans.add(new Bean(8L, "NAME_8"));
        beans.add(new Bean(9L, "NAME_9"));

        Map<Long, List<Bean>> map = beans.stream().collect(Collectors.groupingBy(Bean::getId));

        map.forEach((k, v)->{
            System.out.println(k + "\t" + v);
        });
    }
}
