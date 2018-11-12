package suanfa;

/**
 * 随机洗牌
 *
 * @author wangwentao1@jd.com
 * @date 2018/8/1.
 */
public class Shuffle {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Math.random() * i);
//        }
        int[] array = {1,2,3,4,5,6,7,8,9};
        shuffle(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void shuffle(int[] array) {
        int m = array.length;

        for (int i = 0; i < array.length; i++) {
            int j = (int) Math.random()* i;
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }
}
