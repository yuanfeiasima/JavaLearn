package suanfa;

/**
 * @author wangwentao1@jd.com
 * @date 2018/4/17.
 */
public class ShellSort extends Example{

    /**
     * 希尔排序
     * 在插入排序的基础上改变步长
     * 时间复杂度 nlogn
     * 空间复杂度 o(1)
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }

                //为了方便观察
//                for (int j = i; j >= h; j -= h) {
//                    Comparable aj = a[j];
//                    Comparable ajh = a[j - h];
//                    if (less(a[j], a[j-h])) {
//                        exch(a, j, j-h);
//                    }
//                }
            }
            h = h / 3;
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
