package suanfa;

/**
 * @author wangwentao1@jd.com
 * @date 2018/4/17.
 */
public class BubbleSort extends Example {

    /**
     * 冒泡排序 从后向前 比较
     * 时间复杂度 平方
     * 空间复杂度 o(1)
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int i = 0; i < N; i++) {
            for (int j = N; j > i; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    // A B C D E F G   H I J K I L M N
    // O P Q  R S T  U V W  X Y Z
    public static void main(String[] args) {
        String[] a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
