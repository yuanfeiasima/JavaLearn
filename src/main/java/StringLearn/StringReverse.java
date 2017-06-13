package StringLearn;

/**
 * Created by G on 2016/12/3.
 */
public class StringReverse {

    public static String reverse(String originStr){
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        } else {
            return reverse(originStr.substring(1)) + originStr.charAt(0);
        }

    }

    public static void main(String[] args) {
        String originStr = "abcdefg";
        System.out.println(originStr.charAt(0));
        String resultStr = reverse(originStr);
        System.out.println(resultStr);
    }
}
