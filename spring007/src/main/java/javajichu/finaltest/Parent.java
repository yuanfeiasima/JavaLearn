package javajichu.finaltest;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/20.
 */
public class Parent {
    /**
     * 不能修饰构造方法，编译报错
     */
//    public final Parent() {}

    public final void menthod(String str) {
        System.out.println(str);

    }
}
