package com.basis;

/**
 * @author: tr256
 * @time: 2022/9/16
 *
 * 函数有返回值的情况下：
 *      如果catch中没有回执值，则程序编译出错：缺少返回语句
 *
 * try中代码段出现异常：
 *      异常值之后的代码不再执行
 *      如果finally有返回值，返回finally中的结果
 *      如果finally中没有返回值，返回catch中的返回值
 *
 *
 * try中代码段未出现异常：
 *      catch中的代码段不再执行
 *      如果finally有返回值，返回finally中的结果
 *      如果finally中没有返回值，返回try中的返回结果
 */
public class TryCatchFinally {


//    public static String tryCatchFinallyTest0() {
//        try {
//            System.out.println("try...........");
//            int i = 10 / 0;
//            System.out.println("try。。。。。。。。");
//            return "try中的返回值";
//        } catch (Exception exception) {
//            System.out.println("catch............");
//        } finally {
//            System.out.println("finally.....");
//        }
//    }


    public static String tryCatchFinallyTest1() {
        try {
            System.out.println("try...........");
            int i = 10 / 0;
            System.out.println("try。。。。。。。。");
            return "try中的返回值";
        } catch (Exception exception) {
            System.out.println("catch............");
            return "catch中的返回值";
        } finally {
            System.out.println("finally.....");
        }
    }

    public static String tryCatchFinallyTest2() {
        try {
            System.out.println("try...........");
            int i = 10 / 0;
            System.out.println("try。。。。。。。。");
            return "try中的返回值";
        } catch (Exception exception) {
            System.out.println("catch............");
            return "catch中的返回值";
        } finally {
            System.out.println("finally.....");
            return "finally中的返回值";
        }
    }



    public static String tryCatchFinallyTest3() {
        try {
            System.out.println("try...........");
            int i = 10 / 1;
            System.out.println("try。。。。。。。。");
            return "try中的返回值";
        } catch (Exception exception) {
            System.out.println("catch............");
            return "catch中的返回值";
        } finally {
            System.out.println("finally.....");
        }
    }

    public static String tryCatchFinallyTest4() {
        try {
            System.out.println("try...........");
            int i = 10 / 1;
            System.out.println("try。。。。。。。。");
            return "try中的返回值";
        } catch (Exception exception) {
            System.out.println("catch............");
            return "catch中的返回值";
        } finally {
            System.out.println("finally.....");
            return "finally中的返回值";
        }
    }
//
//    public static String tryCatchFinallyTest5() {
//        try {
//            System.out.println("try...........");
//            int i = 10 / 1;
//            System.out.println("try。。。。。。。。");
//            return "try中的返回值";
//        } catch (Exception exception) {
//            System.out.println("catch............");
//        } finally {
//            System.out.println("finally.....");
//        }
//    }


    public static void main(String[] args) {
        System.out.println(tryCatchFinallyTest1());
        System.out.println(tryCatchFinallyTest2());
        System.out.println(tryCatchFinallyTest3());
        System.out.println(tryCatchFinallyTest4());
    }
}
