package jichu.classLoarder;

/**
 * @author wangwentao1@jd.com
 * @date 2018/3/2.
 */
public class Test {
    /**
     * 主动引用：先初始化父类的静态代码（父类中按顺序），再初始化子类的
     * @param args
     */
    public static void main(String[] args) {

        //结果：
        //运行父类静态代码
        //Field1构造方法
        //运行子类静态代码
        //Field2构造方法
        new SubInitClass2();
    }
}
