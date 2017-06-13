package ThreadNotify;

/**
 * Created by G on 2016/5/23.
 */
public class main {
    public static void main(String[] args) {
        OtherThread otherThread = new OtherThread();
        Thread thread = new Thread(otherThread);
        thread.start();
//        System.out.println("current thread is " + Thread.currentThread().getName());
//        thread.notify();

    }
}
