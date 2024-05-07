package com.property;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author MengXH
 * @date 2023/11/28
 */
public class StrategyProxy<T> implements InvocationHandler {

    private Class<T> interfaceClass;

    public StrategyProxy(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("OK");
        method.invoke(interfaceClass);
        return null;
    }

    public T getInstance() {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, this);
    }
}
