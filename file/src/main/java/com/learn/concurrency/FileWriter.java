package com.learn.concurrency;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * @author MengXH
 * @date 2024/1/26
 */
public class FileWriter implements Runnable {
    @Override
    public void run() {
        Path filePath = Paths.get("E:/test.txt");
        try {
            Thread.sleep(100);
            Files.write(filePath, "ABCDEFGHIJKLMNOPQRSTUVWXYZ一二三四五六七八九十ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            Thread.sleep(100);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
