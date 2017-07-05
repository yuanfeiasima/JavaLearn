package DesignPattern.Decorator;

/**
 * Created by G on 2017/3/13.
 */
public class SortDecorator extends Decorator{
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportSort(){
        System.out.println("我的排名是10！");
    }
    @Override
    public void report() {
        super.report();
        this.reportSort();
    }

    @Override
    public void sign(String name) {
        super.sign(name);
    }
}
