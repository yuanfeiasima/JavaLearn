package Thread;

/**
 * Created by wangwentao on 2016/5/21.
 * 多线程没有使用同步，字符串一般不是10个
 */
public class Practice001 {

    public static void main(String[] args) {
        final StringBuffer sb = new StringBuffer();
        for (int i=0;i<5;i++) {
            new Thread(){
                @Override
                public void run(){
                    sb.append(Thread.currentThread().getName()+" add string a \n");
                }
            }.start();
        }

        for (int i=0;i<5;i++) {
            new Thread() {
                public void run(){
                    sb.append(Thread.currentThread().getName() + " add string b \n");
                }
            }.start();
        }

        System.out.println("main thread "+ Thread.currentThread().getName());
        System.out.println(sb);
    }
}
