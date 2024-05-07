package com.basis.media;

/**
 * @author: MengXH
 * @time: 2023/11/13
 * @description:
 */
public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new Factory("OK", "TEST");

        AComponment aComponment = factory.createA();

        BComponment bComponment = factory.createB();
    }


}
