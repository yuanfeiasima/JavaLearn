package javabingfabianchengdeyishu;

import java.util.HashMap;
import java.util.UUID;

/**
 * <p>hashMap死循环</p>
 * <p>1000，000 没遇见死循环
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author wangwt
 * @version 1.0
 * @Date Created in 2017年07月04日 21:18
 * @since 1.0
 */
public class HashMapDeadLoop {
    public static void main(String[] args) {
        try {
            final HashMap<String, String> map = new HashMap<>(2);
            Thread t = new Thread(new Runnable() {

                public void run() {
                    for(int i = 0; i<1000000; i++){
                        System.out.println("i = " + i);
                        new Thread(new Runnable() {
                            public void run() {
                                map.put(UUID.randomUUID().toString(), "");
                            }
                        }, "ftf" + i).start();
                    }
                }
            }, "ftf");
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
