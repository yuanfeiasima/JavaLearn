package DesignPattern.DecoratorPattern;

/**
 * Created by grace on 17/3/12.
 */
public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }

    @Override
    public void sign(String name) {
        super.sign(name);
    }

    private void reportHighScore(){
        System.out.println("最高的语文成绩是80！");
    }
}
