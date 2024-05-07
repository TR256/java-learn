package com.reflection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MengXH
 * @date 2024/1/25
 */
public class DaoRegistry {
    
    private final Map<String, DaoDefinition> classMap = new HashMap<>();


    public  <D, E, K> void register(Class<D> daoClass) throws NoSuchFieldException {
        DaoDefinition<E, K> daoDefinition = new DaoDefinition();
        daoDefinition.setKeyClass(Bean.class);
        daoDefinition.setKeyClass(K);
        daoDefinition.setKeyField(Bean.class.getField("key"));
        DaoProxyFactory<D> daoProxyFactory = new DaoProxyFactory<>(daoClass);
        D dao = daoProxyFactory.newInstance();
        daoDefinition.setDao(dao);
        classMap.put(daoClass.getSimpleName(), daoDefinition);
    }
}
