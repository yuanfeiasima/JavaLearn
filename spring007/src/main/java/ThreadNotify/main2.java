package ThreadNotify;

import static java.lang.Thread.sleep;

public class main2 {
    public static void main(String[] args) {
        OtherThread otherThread = new OtherThread();
        Thread t = new Thread(otherThread);
        /**
         * 如果子线程是daemon的，那么主线程退出，子线程也退出，jvm进程退出
         * 如果子线程不是daemon的，那么主线程退出，子线程执行完，jvm再退出
         */
//        t.setDaemon(true);
        t.start();
        System.out.println("main thread over");
    }
}
