package com.learn;

/**
 * @author MengXH
 * @date 2024/2/2
 */
public class StringUtil {

    public static boolean isEmpty(String string){
        return string == null || string.trim().length() == 0;
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }
}
