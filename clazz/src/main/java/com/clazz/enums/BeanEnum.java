package com.clazz.enums;

/**
 * @author: MengXH
 * @time: 2023/11/7
 * @description:
 */
public enum BeanEnum {
    /**
     * 枚举元素
     */
    UN_SUBMIT("00", "未提交"),

    SUBMIT("01", "提交"),

    REJECT("03", "驳回"),

    PASS("02", "通过");

    BeanEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private final String key;
    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    public static void main(String[] args) {
        System.out.println(BeanEnum.valueOf("SUBMIT"));
    }
}

