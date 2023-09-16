package com.basis;

/**
 * @author: tr256
 * @time: 2023/9/16
 */
public class ByteTest {
    public static void main(String[] args) {
//        short s1 = 1;
//        short s2 = s1 + 2;//编译不通过，类型转换错误

        short s3 = 1;
        short s4 = s3 += 1; //正常运算
        System.out.println(s4);
    }
}
