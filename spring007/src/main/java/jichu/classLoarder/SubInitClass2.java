package jichu.classLoarder;

/**
 * @author wangwentao1@jd.com
 * @date 2018/3/2.
 */
public class SubInitClass2 extends InitClass2 {
    static {
        System.out.println("运行子类静态代码");
    }

    public SubInitClass2(){
        System.out.println("子类的构造函数");
    }

    public static Field2 f2 = new Field2();
}
