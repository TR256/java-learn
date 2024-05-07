package com.learn;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @author MengXH
 * @date 2024/1/16
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws FileNotFoundException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("E:/random.txt", "rw");

    }
}
