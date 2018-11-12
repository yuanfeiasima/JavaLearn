package ThreadNotify;

/**
 * Created by G on 2016/5/23.
 */
public class main {

    /**
     * 线程操作的wait()、notify()、notifyAll()方法只能在同步控制方法或同步控制块内调用
     * @param args
     */
    public static void main(String[] args) {
        OtherThread otherThread = new OtherThread();
        Thread thread = new Thread(otherThread);
        thread.start();
        System.out.println("current thread is " + Thread.currentThread().getName());
        thread.notify();

    }
}
