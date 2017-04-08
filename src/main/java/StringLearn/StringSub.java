package StringLearn;


/**
 * Created by grace on 17/2/18.
 */
public class StringSub {
    public static void main(String[] args) throws Exception {
        String str = "中国abc";
        int num = trimGBK(str.getBytes("GBK"), 5);
        System.out.println(str.substring(0, num));
    }

    /**
     * gbk编码格式中文占位
     * @param buf
     * @param n
     * @return
     */
    private static int trimGBK(byte[] buf, int n){
        int num =0;
        boolean bChineseFirstHalf = false;
        for (int i =0; i< n;i++) {
            if (buf[i] < 0 && !bChineseFirstHalf) {
                bChineseFirstHalf = true;
            }else{
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;
    }
}
