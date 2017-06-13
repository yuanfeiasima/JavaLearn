package daimazhimei;

/**
 * Created by G on 2016/9/28.
 */
public class weiyi {
    public static void main(String[] args) {

        int j = 10;
        System.out.println("j is :" + j);
        System.out.println("Integer.toBinaryString(j) = " + Integer.toBinaryString(j));
        int k = j << 1;
        System.out.println("j << 1 = " + k); //左移1等于 X 2
        System.out.println("Integer.toBinaryString(j << 1) = " + Integer.toBinaryString(k));
        int l = j >> 1;
        System.out.println("j >> 1 = " + l); //右移1等于 除 2  >>> 无符号右移
        System.out.println("Integer.toBinaryString(j >> 1) = " + Integer.toBinaryString(l));

        System.out.println("j << 2 = " + (j << 2));

        int m = 2;
        System.out.println("m << m == " + (m << m ));
        System.out.println("m | m == " + (m | m));
    }
}
