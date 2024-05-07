package com.basis;


import java.sql.Timestamp;

/**
 * @author MengXH
 * @date 2023/11/30
 */
public class TimestampTest {

    public static void main(String[] args) throws InterruptedException {

        Timestamp start = new Timestamp(System.currentTimeMillis());

        Thread.sleep(2000);

        Timestamp end = new Timestamp(System.currentTimeMillis());

        System.out.println(end.getTime() - start.getTime());
    }
}
