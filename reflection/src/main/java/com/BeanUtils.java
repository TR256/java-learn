package com;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MengXH
 * @date 2023/12/18
 */
public class BeanUtils {

    public static <T> void copyProperties(T source, T target) throws IntrospectionException {

        AssertUtils.notNull(source, "parameter source cannot be null");

        AssertUtils.notNull(target, "parameter target cannot be null");

        Class<?> tClass = source.getClass();

        Field[] fields = tClass.getDeclaredFields();

        for (Field field : fields) {

            try {

                PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), tClass);

                Method readMethod = descriptor.getReadMethod();

                Method writeMethod = descriptor.getWriteMethod();

                Object value = readMethod.invoke(source);

                if (value != null) {
                    writeMethod.invoke(target, value);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
