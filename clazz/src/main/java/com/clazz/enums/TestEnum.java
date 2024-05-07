package com.clazz.enums;

/**
 * @author MengXH
 * @date 2023/12/12
 */
public enum TestEnum implements BasicEnum {
    /**
     *
     */
    ONE("01", "ONE");

    private final String key;
    private final String name;

    TestEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String getKey() {
        return key;
    }
}
