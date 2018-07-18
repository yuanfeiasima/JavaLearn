package suanfa;

/**
 * Created by grace on 18/4/18.
 */
public class QuickSort extends Example{

    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a) 随机打乱
        sort(a, 0, a.length -1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //切分
        int j = partition(a, lo, hi);
        //将左半部分排序
        sort(a, lo, j - 1);
        //将有半部分排序
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        //左右扫描指针
        int i = lo, j = hi + 1;
        //切分元素
        Comparable v = a[lo];
        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                //i 左指针一直往右走，直到遇到比v大的 停下
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                //右指针一直往左走，直到遇到一个比v小的 停下
                if (j == lo) {
                    break;
                }
            }

            //左右指针相遇，本次循环结束
            if (i >= j) {
                break;
            }
            //交换左大右小， 变成 左小 v 右大
            exch(a, i ,j);
        }
        //将v(a[lo])放到j的位置
        //排定一个元素，左边不大于它， 右边不小于它
        exch(a, lo, j);
        return j;
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
