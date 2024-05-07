package com.basis;

/**
 * @author MengXH
 * @date 2023/12/18
 */
public class CharTest {

    public static String get(double d){
        String str = String.format("%.8f", d);
        if (str.equals("0.00000000")) {
            return "0";
        }

        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c - '0' <= 0) {
                continue;
            }
            if (i + 3 <= len) {
                return str.substring(0, i + 3);
            }
            return str.substring(0, len);
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println('0' - '0');
        System.out.println('1' - '0');
        System.out.println('2' - '0');
        System.out.println('3' - '0');

        System.out.println('4' - '0');
        System.out.println('5' - '0');
        System.out.println('6' - '0');

        System.out.println('7' - '0');
        System.out.println('8' - '0');
        System.out.println('9' - '0');


        System.out.println("------------->>>");

        System.out.println(get(0.0001201D));

    }
}
