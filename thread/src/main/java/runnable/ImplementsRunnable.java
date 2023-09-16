package runnable;

/**
 * @author: tr256
 * @time: 2023/9/1
 */
public class ImplementsRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }

    public static void main(String[] args) {
        new Thread( new ImplementsRunnable(),"thread-1").start();
        new Thread( new ImplementsRunnable(),"thread-2").start();
        new Thread( new ImplementsRunnable(),"thread-3").start();
    }
}
