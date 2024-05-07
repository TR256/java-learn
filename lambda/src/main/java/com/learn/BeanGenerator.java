package com.learn;

import javax.sound.midi.Sequence;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

/**
 * @author MengXH
 * @date 2023/12/21
 */
public class BeanGenerator {

    private final static List<Class<?>> baseTypeList = new ArrayList<>();

    static {
        baseTypeList.add(Double.class);
        baseTypeList.add(double.class);
        baseTypeList.add(Float.class);
        baseTypeList.add(float.class);
        baseTypeList.add(Long.class);
        baseTypeList.add(long.class);
        baseTypeList.add(Integer.class);
        baseTypeList.add(int.class);
        baseTypeList.add(Short.class);
        baseTypeList.add(short.class);
        baseTypeList.add(Boolean.class);
        baseTypeList.add(boolean.class);
        baseTypeList.add(Character.class);
        baseTypeList.add(char.class);
        baseTypeList.add(String.class);
    }

    public static Object createFiledValue(Field field) throws InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        Class<?> fieldClass = field.getType();
        System.out.println(fieldClass);
        if (CharSequence.class.isAssignableFrom(fieldClass)) {
            return "String";
        }
        if (Boolean.class.isAssignableFrom(fieldClass)){
            return Boolean.TRUE;
        }
        if (Character.class.isAssignableFrom(fieldClass)) {
            return 'C';
        }
        if (Number.class.isAssignableFrom(fieldClass)) {
            return 10;
        }
        if (Collection.class.isAssignableFrom(fieldClass)) {
            Type genericType = field.getGenericType();
            System.out.println(genericType);
            ParameterizedType parameterizedType = (ParameterizedType)genericType;
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            Type actualType = actualTypes[0];
            String typeName = actualType.getTypeName();
            Class<?> actualClass = Class.forName(typeName);
            System.out.println(actualClass);
            ArrayList<Object> list = new ArrayList<>();
            Object listItem = createInstance(actualClass);
            list.add(listItem);
            return list;
        }
        if (Map.class.isAssignableFrom(fieldClass)) {
            return new HashMap<>();
        }
        if (fieldClass.isArray()) {
            return new Object() {
            };
        }
        return createInstance(fieldClass);
    }

    /**
     * @param field
     * @return
     */
    public static String getFileName(Field field) {
        String fieldName = field.getName();
        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof XmlAttribute) {
                fieldName = ((XmlAttribute) annotation).name();
            }
            if (annotation instanceof XmlElement) {
                fieldName = ((XmlElement) annotation).name();
            }
        }
        return fieldName;
    }

    public static Object createInstance(Class<?> clazz) throws IntrospectionException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {

        Object instance = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            String fieldName = getFileName(field);
            Object filedValue = createFiledValue(field);
//            PropertyDescriptor descriptor = new PropertyDescriptor(fieldName, TestBean.class);
//            Method writeMethod = descriptor.getWriteMethod();
//            writeMethod.invoke(instance, filedValue);
            Method method = clazz.getMethod("set" + fieldName, field.getType());
            method.invoke(instance, filedValue);
        }
        return instance;
    }

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {
        Object bean = createInstance(TestBean.class);
        System.out.println(bean);
    }
}
