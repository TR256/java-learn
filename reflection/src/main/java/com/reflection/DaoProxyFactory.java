package com.reflection;

import java.lang.reflect.Proxy;

/**
 * @author MengXH
 * @date 2024/1/25
 */
public class DaoProxyFactory<D> {

    private Class<D> daoClass;

    public DaoProxyFactory(Class<D> daoClass) {
        this.daoClass = daoClass;
    }

    public D newInstance(){
        DaoProxy<D> proxy = new DaoProxy<>(this.daoClass);
        return (D) Proxy.newProxyInstance(this.daoClass.getClassLoader(), new Class[]{this.daoClass}, proxy);
    }
}
