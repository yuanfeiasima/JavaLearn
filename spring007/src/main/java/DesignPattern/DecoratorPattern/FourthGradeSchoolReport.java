package DesignPattern.DecoratorPattern;

/**
 * Created by grace on 17/3/12.
 */
public class FourthGradeSchoolReport extends SchoolReport {
    @Override
    public void report() {
        System.out.println("你家孩子的语文成绩是：" + 69);
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名为："+name);
    }
}
