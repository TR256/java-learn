package com.learn;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public enum OCRTypeEnum {
    /**
     * 中文简体
     */
    CHI_SIM("00", "chi_sim"),

    /**
     * 英文
     */
    ENG("01", "eng"),
    /**
     * 中英文混合
     */
    MIX_CHI_SIM__ENG("02", "chi_sim+eng");


    private String key;
    private String value;

    OCRTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
