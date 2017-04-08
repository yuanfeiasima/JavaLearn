package DesignPattern.DecoratorPattern;

/**
 * Created by grace on 17/3/12.
 */
public class Father {
    public static void main(String[] args) {
//        SchoolReport sr = new FourthGradeSchoolReport();
//        sr.report();
        SchoolReport sr;
        sr = new FourthGradeSchoolReport();//原装成绩单
        sr = new HighScoreDecorator(sr);
            //this.reportHighScore();
            //super.report();
        sr = new SortDecorator(sr);
            //super.report();
            //this.reportSort();
        sr.report();
        sr.sign("张三丰");
    }
}
