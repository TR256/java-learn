package com.learn.beans;

import org.modelmapper.ModelMapper;

/**
 * @author: MengXH
 * @time: 2023/10/25
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        SourceBean sourceBean = new SourceBean(1, "one", null, null, "source");
        TargetBean targetBean = new TargetBean(2, "two", "333", "444", null);
        modelMapper.map(sourceBean, targetBean);
        System.out.println(targetBean);
    }
}
