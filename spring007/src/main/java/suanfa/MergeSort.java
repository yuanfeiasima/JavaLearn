package suanfa;

/**
 * 自顶向下的归并排序
 *
 * @author wangwentao1@jd.com
 * @date 2018/4/17.
 */
public class MergeSort extends Example {

    /**
     * 归并所需要的额外数组
     */
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        //一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        //将左半边排序
        sort(a, lo, mid);
        //将右半边排序
        sort(a, mid + 1, hi);
        //归并结果
        merge(a, lo, mid, hi);
    }

    /**
     * 原地归并的抽象方法
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //将a[lo...mid] 和 a[mid+1...hi] 归并
        int i = lo, j = mid + 1;
        //先复制到额外的数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                //左边取完了 取右边的
                a[k] = aux[j++];
            } else if (j > hi) {
                //右边取完了 取左边的
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                //两边都有值取小的
                a[k] = aux[j++];
            } else {
                //两边都有值取小的
                a[k] = aux[i++];
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
