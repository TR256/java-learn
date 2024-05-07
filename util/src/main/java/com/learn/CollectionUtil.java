package com.learn;

import java.util.List;

/**
 * @author MengXH
 * @date 2024/2/2
 */
public class CollectionUtil {

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }
}
