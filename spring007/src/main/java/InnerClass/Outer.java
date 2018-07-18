package InnerClass;

/**
 * Created by G on 2016/12/3.
 */
public class Outer {
    class Inner{}
    public static void foo(){
        new Outer().new Inner();}
    public void bar(){
        new Inner();}

    public static void main(String[] args) {
        //new Inner();
        /**
         * foo main 都是静态方法， 静态方法中没有this，也就是没有外部类对象，
         * 因此不能创建内部类对象，
         * 所以在静态方法中创建内部类 要像下面一样
         */
        new Outer().new Inner();
    }
}
