package DesignPattern.Decorator;

/**
 * Created by G on 2017/3/13.
 */
public class Far {
    public static void main(String[] args) {
        SchoolReport schoolReport;
        schoolReport = new FourGradeSchoolReport();
        schoolReport = new HighScoreDecorator(schoolReport);
        schoolReport = new SortDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign("通过");
    }
}
