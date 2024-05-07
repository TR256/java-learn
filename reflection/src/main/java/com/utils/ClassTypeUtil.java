package com.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author MengXH
 * @date 2024/1/16
 */
public abstract class ClassTypeUtil {

    private Class<?> clazz;

    private Type[] getTypes() {
        if (clazz.isInterface()) {
            Type[] interfaces = clazz.getGenericInterfaces();
            if (interfaces.length > 0) {
                if (interfaces[0] instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) interfaces[0];
                    return parameterizedType.getActualTypeArguments();
                }
            }
        }
        return new Type[0];
    }
}
