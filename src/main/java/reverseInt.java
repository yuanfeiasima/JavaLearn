/**
 * i am git
 * Created by grace on 17/3/19.
 */
public class reverseInt {

    private static int reverseInt(int x){
        long rev = 0;
        while(x != 0){
            rev = rev * 10 + x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;

    }
    public static void main(String[] args) {
        int x = 123456;
        int rev = reverseInt(x);
        System.out.println(rev);
    }
}
