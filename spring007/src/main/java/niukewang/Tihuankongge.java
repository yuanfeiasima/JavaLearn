package niukewang;

/**
 * Created by grace on 17/4/8.
 */
public class Tihuankongge {
    public static String replaceSpace(StringBuffer str) {
        String result = str.toString().replace(" ", "%20");
        return result;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("we are happy");
        String result = replaceSpace(stringBuffer);
        System.out.println(result);
    }
}
