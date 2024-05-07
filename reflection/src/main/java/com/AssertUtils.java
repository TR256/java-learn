package com;

/**
 * @author MengXH
 * @date 2023/12/18
 */
public class AssertUtils {

    /**
     * 断言非null
     *
     * @param object  被判断的对象
     * @param message 异常信息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new RuntimeException(message);
        }
    }

    /**
     * 断言为真
     *
     * @param value   被判断的值
     * @param message 异常信息
     */
    public static void isTrue(boolean value, String message) {
        if (!value) {
            throw new RuntimeException(message);
        }
    }
}
