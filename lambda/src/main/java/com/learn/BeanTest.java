package com.learn;

/**
 * @author: tr256
 * @time: 2023/10/16
 */
public class BeanTest {

    public static void main(String[] args) {

        JavaBean javaBean = BeanBuilder.Builder(JavaBean::new)
                .set(JavaBean::setName, "123")
                .build();
        System.out.println(javaBean);

        System.out.println(String.valueOf(null));
    }
}
