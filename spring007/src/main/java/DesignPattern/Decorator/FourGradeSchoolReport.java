package DesignPattern.Decorator;

/**
 * Created by G on 2017/3/13.
 */
public class FourGradeSchoolReport extends SchoolReport{
    public void report() {
        System.out.println("我的语文成绩是:69");
    }

    public void sign(String name) {
        System.out.println("家长签名：" + name);
    }
}
