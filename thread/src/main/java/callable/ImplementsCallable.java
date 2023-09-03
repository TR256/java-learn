package com.example.thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: tr256
 * @time: 2023/9/1
 */
public class ImplementsCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return Thread.currentThread().getName() + "\t" + new Date();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask1 = new FutureTask<>(new ImplementsCallable());
        new Thread(futureTask1, "thread-1").start();
        FutureTask<String> futureTask2 = new FutureTask<>(new ImplementsCallable());
        new Thread(futureTask2, "thread-2").start();
        FutureTask<String> futureTask3 = new FutureTask<>(new ImplementsCallable());
        new Thread(futureTask3, "thread-3").start();
        System.out.println(new Date());
        System.out.printf("%s\t%s\r\n", new Date(), futureTask1.get());
        System.out.println(new Date());
        System.out.println(new Date());
        System.out.printf("%s\t%s\r\n", new Date(), futureTask2.get());
        System.out.println(new Date());
        System.out.println(new Date());
        System.out.printf("%s\t%s\r\n", new Date(), futureTask3.get());
        System.out.println(new Date());
    }
}
