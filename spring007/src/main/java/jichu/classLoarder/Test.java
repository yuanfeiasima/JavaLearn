package jichu.classLoarder;

/**
 * @author wangwentao1@jd.com
 * @date 2018/3/2.
 */
public class Test {
    /**
     * 主动引用：先初始化父类的静态代码（父类中按顺序），再初始化子类的
     *
     * 没有显式构造函数的时候：
     * 运行父类静态代码
     * Field1构造方法
     * 运行子类静态代码
     * Field2构造方法
     *
     * 有显式构造函数的时候：
     * 运行父类静态代码
     * Field1构造方法
     * 运行子类静态代码
     * Field2构造方法
     * 父类的构造函数
     * 子类的构造函数
     * @param args
     */
    public static void main(String[] args) {

        new SubInitClass2();
    }
}
