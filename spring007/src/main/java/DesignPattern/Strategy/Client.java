package DesignPattern.Strategy;

public class Client {

    /**
     * 1.策略模式通常与模板模式， 工厂模式一起使用
     *      抽象策略类会封装公共代码
     *      具体算法由子类实现
     * 2.与模板不同的是，调用对象是context
     * 优点
     * 1.易于扩展，不用修改原代码
     * 2.避免使用多重条件语句
     * 3.策略类之间可以自由切换
     *
     * 缺点
     * 1.维护策略类的开销，策略类太多，对数量的控制
     * 2.违反迪米特法则，调用方必须熟悉具体策略
     *
     * 适用场景
     * 1.几个算法主要逻辑相同，只是部分有区别
     * 2.客户端动态调用
     * @param args
     */
    public static void main(String[] args) {

        Context context;
        System.out.println("执行策略A");
        context = new Context(new ConcreteStrategyA());
        context.execute();

        System.out.println("执行策略B");
        context = new Context(new ConcreteStrategyB());
        context.execute();

    }
}
