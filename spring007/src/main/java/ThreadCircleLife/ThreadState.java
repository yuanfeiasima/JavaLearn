package ThreadCircleLife;

/**
 * Created by wangwentao on 2016/5/21.
 */
public class ThreadState implements Runnable{

    /**
     * 使当前线程等待0.5秒
     * 或 其他线程调用notify() 或 notifyAll()方法
     * @throws InterruptedException
     */
    public synchronized void waitForASecond() throws InterruptedException{
        wait(500);
    }

    /**
     * 使当前线程永久等待，直到其他线程调用notify() 或 notifyAll()方法
     * @throws InterruptedException
     */
    public synchronized void waitForYears() throws InterruptedException {
        wait();
    }

    /**
     * 唤醒由调用wait()方法进入等待状态的线程
     * @throws InterruptedException
     */
    public synchronized void notifyNow() throws InterruptedException{
        notify();
    }
    public void run() {
        try {
            waitForASecond();
            waitForYears();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
