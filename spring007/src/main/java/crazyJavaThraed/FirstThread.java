package crazyJavaThraed;

/**
 * Created by G on 2016/5/23.
 */
public class FirstThread extends Thread{
    private int i;//通过继承Thread方式， 多条线程之间无法共享线程类的实例变量
    public void run(){
        for (;i<100;i++) {
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}
