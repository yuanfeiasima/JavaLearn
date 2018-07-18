package DesignPattern.Strategy;

public class ConcreteStrategyA implements IStrategy{

    @Override
    public void doSomething() {
        System.out.println("执行具体策略A！");
    }
}
