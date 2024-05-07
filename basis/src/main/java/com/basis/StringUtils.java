package com.basis;

/**
 * @author MengXH
 * @date 2023/11/16
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
