package DesignPattern.Decorator;

/**
 * Created by G on 2017/3/13.
 */
public class HighScoreDecorator extends Decorator{
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportHighScore(){
        System.out.println("语文成绩最高分：70");
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
}
