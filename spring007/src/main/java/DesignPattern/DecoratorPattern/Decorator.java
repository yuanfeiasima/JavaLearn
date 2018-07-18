package DesignPattern.DecoratorPattern;

/**
 * Created by grace on 17/3/12.
 */
public class Decorator extends SchoolReport {
    private SchoolReport sr;

    public Decorator(SchoolReport schoolReport){
        this.sr = schoolReport;
    }

    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
