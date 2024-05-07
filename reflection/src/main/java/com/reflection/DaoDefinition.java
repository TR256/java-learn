package com.reflection;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author MengXH
 * @date 2024/1/25
 */
@Data
public class DaoDefinition<E, K> {

    private Class<E> entityClass;

    private Class<K> keyClass;

    private Field keyField;

    private IDao<E, K> dao;
}
