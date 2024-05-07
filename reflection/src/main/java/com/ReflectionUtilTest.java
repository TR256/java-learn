package com;

import com.utils.ReflectionUtil;

import java.lang.reflect.Method;

/**
 * @author MengXH
 * @date 2024/1/16
 */
public class ReflectionUtilTest {

    public static void main(String[] args) {
        ReflectionBean reflectionBean = new ReflectionBean();
        reflectionBean.setId(1L);
        reflectionBean.setName("ReflectionName");
        reflectionBean.setFlag(Boolean.FALSE);

        Long idValue = ReflectionUtil.getPropertyValue(reflectionBean, "id", Long.class);
        System.out.println(idValue);

        Object flagValue = ReflectionUtil.getPropertyValue(reflectionBean, "flag");
        System.out.println(flagValue);


        ReflectionUtil.setPropertyValue(reflectionBean, "flag", Boolean.TRUE);
        System.out.println(reflectionBean.getFlag());
    }
}
