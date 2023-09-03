package com.example.thread;

/**
 * @author: tr256
 * @time: 2023/9/1
 */
public class ExtendsThread extends Thread {

    public ExtendsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }

    public static void main(String[] args) {
        new ExtendsThread("Thread-1").start();
        new ExtendsThread("Thread-2").start();
    }
}
