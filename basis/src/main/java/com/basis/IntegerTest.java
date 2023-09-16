package com.basis;

/**
 *
 * @author: tr256
 * @time: 2023/9/16
 * 在[-128, 127]范围内，new创建新对象，其他使用缓存中的数据
 * 超出[-128, 127]范围，在堆空间创建新对象
 */
public class IntegerTest {

    public static void main(String[] args) {
        /**
         * 在[-128, 127]范围内，new创建新对象，其他使用缓存中的数据
         */
        Integer integer11 = 127;// 在缓存中取得数据
        Integer integer12 = 127;// 在缓存中取得数据
        Integer integer13 = Integer.valueOf(127);// 在缓存中取得数据
        Integer integer14 = new Integer(127);// 在堆空间新建对象

        System.out.println(integer11 == integer12);
        System.out.println(integer11 == integer13);
        System.out.println(integer11 == integer14);
        System.out.println(integer13 == integer14);
        System.out.println(integer11.equals(integer14));
        System.out.println(integer13.equals(integer14));

        System.out.println("------");

        /**
         * 超出[-128, 127]范围，在堆空间创建新对象
         */
        Integer integer21 = 128;
        Integer integer22 = 128;
        Integer integer23 = Integer.valueOf(128);
        Integer integer24 = new Integer(128);

        System.out.println(integer21 == integer22);
        System.out.println(integer21 == integer23);
        System.out.println(integer21 == integer24);
        System.out.println(integer23 == integer24);
        System.out.println(integer21.equals(integer22));
        System.out.println(integer21.equals(integer23));
        System.out.println(integer21.equals(integer24));
        System.out.println(integer23.equals(integer24));

    }
}
