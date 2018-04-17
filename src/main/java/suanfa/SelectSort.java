package suanfa;

/**
 * 选择排序
 *
 * @author wangwentao1@jd.com
 * @date 2018/4/17.
 */
public class SelectSort extends Example {

    /**
     * 不断地在剩余元素中找到最小的元素
     */
    public static void sort(Comparable[] a) {
        show(a);
        //数组的长度
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //最小元素的索引
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void sort2(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[i])) {
                    exch(a, i, j);
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
