package com.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * @author MengXH
 * @date 2024/1/16
 */
public abstract class ReflectionUtil {

    /**
     * 获取属性描述信息
     *
     * @param clazz    类
     * @param property 属性字段
     * @return 属性描述信息
     */
    private static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String property) {
        try {
            return new PropertyDescriptor(property, clazz);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取属性的getter方法
     *
     * @param clazz    类
     * @param property 属性
     * @return 属性的getter方法
     */
    public static Method getReadMethod(Class<?> clazz, String property) {
        PropertyDescriptor propertyDescriptor = ReflectionUtil.getPropertyDescriptor(clazz, property);
        return propertyDescriptor.getReadMethod();
    }

    /**
     * 获取属性的setter方法
     *
     * @param clazz    类
     * @param property 属性
     * @return setter方法
     */
    public static Method getWriteMethod(Class<?> clazz, String property) {
        PropertyDescriptor propertyDescriptor = ReflectionUtil.getPropertyDescriptor(clazz, property);
        return propertyDescriptor.getWriteMethod();
    }

    /**
     * 获取实体某个字段的值
     *
     * @param entity   实体
     * @param property 属性
     * @param <T>
     * @return 属性值
     */
    public static <T> Object getPropertyValue(T entity, String property) {
        Method readMethod = ReflectionUtil.getReadMethod(entity.getClass(), property);
        try {
            return readMethod.invoke(entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取实体某个字段的值
     *
     * @param entity        实体
     * @param property      属性
     * @param propertyClazz 属性类型
     * @param <T>
     * @return 属性值
     */
    public static <T, R> R getPropertyValue(T entity, String property, Class<R> propertyClazz) {
        Method readMethod = ReflectionUtil.getReadMethod(entity.getClass(), property);
        try {
            return (R) readMethod.invoke(entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置实体某个字段的值
     *
     * @param entity   实体
     * @param property 属性
     * @param value    值
     * @param <T>
     * @param <R>
     */
    public static <T, R> void setPropertyValue(T entity, String property, R value) {
        Method writeMethod = ReflectionUtil.getWriteMethod(entity.getClass(), property);
        try {
            writeMethod.invoke(entity, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
