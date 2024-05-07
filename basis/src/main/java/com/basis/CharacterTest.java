package com.basis;

import java.nio.charset.Charset;

/**
 * @author MengXH
 * @date 2023/12/4
 */
public class CharacterTest {

    public static void main(String[] args) {
        String string = "中文字符abcd";
        int byteLength = string.getBytes().length;
        int charLength = string.length();
        System.out.println(byteLength + "\t" + charLength + "\t" + (byteLength - charLength));
    }
}
