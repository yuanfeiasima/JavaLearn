package StringLearn;

/**
 * Created by G on 2017/1/19.
 */
public class StringPlusI {
    public static void main(String[] args) {
        String string = "String";
        int i;
//        System.out.println(string + i); error

        final int[] intArray = {1, 2, 3};
        intArray[0] = 1;
        int[] intBarray = {4, 5, 6};
//        intArray = intBarray; error

        final String str1 = "aaa";
//        str1 = "def"; error
        String str2 = str1.replace('a', 'b');
        System.out.println(str1);
        System.out.println(str2);

        int outPut = 10;
        boolean b1 = false;
        if ((b1 == true) && ((outPut += 10) == 20)) {
            System.out.println("equal" + outPut);
        } else {
            System.out.println("not equal " + outPut);
        }

        MyOver myOver = new MyOver(10);
    }

}
