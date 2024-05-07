package thread;

/**
 * @author MengXH
 * @date 2023/12/12
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static void print(String threadName) {
        System.out.println(threadName + ":" + threadLocal.get());
    }

    public static void main(String[] args) {

        new Thread(()->{
            threadLocal.set("A");
            print(Thread.currentThread().getName());
            System.out.println(threadLocal.get());

        }, "A").start();
        new Thread(()->{
            threadLocal.set("B");
            print(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
        }, "B").start();
    }

}
