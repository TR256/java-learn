package com.reflection;

/**
 * @author MengXH
 * @date 2024/1/25
 */
public class ReflectionTest {

    public static void main(String[] args) {
        DaoProxyFactory<IBeanDao> beanDaoDaoProxyFactory = new DaoProxyFactory<>(IBeanDao.class);
        IBeanDao beanDao = beanDaoDaoProxyFactory.newInstance();
        String ok = beanDao.getByKey("key");
        System.out.println(ok);
    }
}
