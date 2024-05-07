package com.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MengXH
 * @date 2024/1/25
 */
public class DaoProxy<T> implements InvocationHandler {

    private Class<T> daoClass;

    public DaoProxy(Class<T> daoClass) {
        this.daoClass = daoClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        if (Object.class.equals(method.getDeclaringClass())){
            try {
                return method.invoke(this, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("你被代理了");
        return null;
    }
}
