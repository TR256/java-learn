package com.property;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: tr256
 * @time: 2022/9/2
 */
public class BeanProperty {

    public static class Bean {
        private Integer id;
        private String name;

        public Bean() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Bean bean = new Bean();
        PropertyDescriptor propertyDescriptor =new PropertyDescriptor("id", Bean.class);
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(bean, 1);
        System.out.println(bean);

        Method readMethod = propertyDescriptor.getReadMethod();
        Class<?> returnTypeClass = readMethod.getReturnType();
        System.out.println(returnTypeClass);
        Object id = readMethod.invoke(bean);
        System.out.println(id);
    }
}
