package com.reflection;

/**
 * @author MengXH
 * @date 2024/1/25
 */
public interface IBeanDao<Bean, Long> extends IDao {

    String getByKey(String key);
}
