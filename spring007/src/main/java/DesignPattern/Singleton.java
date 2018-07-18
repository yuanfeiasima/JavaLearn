package DesignPattern;

/**
 * Created by grace on 17/2/18.
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton(){
        return singleton;
    }
}
