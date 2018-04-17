package suanfa;

/**
 * @author wangwentao1@jd.com
 * @date 2018/4/17.
 */
public class InsertSort extends Example{

    /**
     * 插入排序 类似扑克牌
     * 时间复杂度  平方级别
     * 空间复杂度 o(1)
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //将a[j]插入到a[j-1], a[j-2], a[j-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
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
