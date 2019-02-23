package ThreadNotify;

import static java.lang.Thread.sleep;

/**
 * Created by wangwentao on 2016/5/23.
 */
public class OtherThread implements Runnable{
    public void run() {
        try{
            System.out.println("other before wait");
            sleep(5000);
            System.out.println("other after wait");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
