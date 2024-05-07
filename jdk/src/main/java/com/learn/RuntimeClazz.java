package com.learn;

/**
 * @author MengXH
 * @date 2024/1/8
 */
public class RuntimeClazz {

    public static void  memory(){
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        System.out.println(freeMemory);
        System.out.println(maxMemory);
        System.out.println(totalMemory);
        System.out.println(maxMemory - totalMemory + freeMemory);
    }

    public static void processor(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int processors = runtime.availableProcessors();
        System.out.println(processors);
    }


    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
    }
}
