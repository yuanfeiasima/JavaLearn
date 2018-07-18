package DesignPattern.DecoratorPattern;

/**
 * Created by grace on 17/3/12.
 */
public class SortDecorator extends Decorator{
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportSort(){
        System.out.println("你家孩子的排名是10！");
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
