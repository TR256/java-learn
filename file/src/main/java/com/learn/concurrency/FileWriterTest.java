package com.learn.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author MengXH
 * @date 2024/1/26
 */
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        Files.createFile(Paths.get("E:/test.txt"));
        for (int i = 0; i < 100; i++){
            new Thread(new FileWriter()).start();
        }
    }
}
