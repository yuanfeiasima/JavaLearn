package atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/19.
 */
public class Atomic {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();
        long startTime = System.currentTimeMillis();
        System.out.println("before:" + counter.getC());
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
//            new Thread(new helper(counter)).start();
            new Thread(()->{
                counter.addC();
                countDownLatch.countDown();
            }).start();
        }
//        Thread.currentThread().sleep(5000);
        countDownLatch.await();
        long endTime = System.currentTimeMillis();

        System.out.println("after:" + counter.getC() + ", use time:" + (endTime - startTime) / 1000 + "s");
    }

    public static class helper implements Runnable {
        private Counter counter;

        public helper(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.addC();
        }
    }

    public static class Counter {
        private AtomicInteger c;
        private ReadWriteLock lock;

        public Counter() {
            c = new AtomicInteger();
            lock = new ReentrantReadWriteLock();
        }

        public int getC() {
            lock.readLock().lock();
            try {
                return c.get();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                lock.readLock().unlock();
            }
        }

        public void addC() {
            lock.writeLock().lock();
            try {
                c.addAndGet(1);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static class Counter2 {
        private AtomicInteger c;

        public Counter2() {
            c = new AtomicInteger();
        }

        public int getC() {

            return c.get();

        }

        public void addC() {

            c.addAndGet(1);

        }
    }
}
