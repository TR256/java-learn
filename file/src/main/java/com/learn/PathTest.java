package com.learn;

import java.nio.file.Paths;

/**
 * @author MengXH
 * @date 2024/1/9
 */
public class PathTest {

    public static void main(String[] args) {
        String programFilesDir = System.getenv("ProgramFiles");
        String string = Paths.get(programFilesDir).toString();
        System.out.println(string);
    }
}
