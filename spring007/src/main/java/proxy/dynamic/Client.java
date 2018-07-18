package proxy.dynamic;

import proxy.UserManager;
import proxy.UserManagerImpl;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/18.
 */
public class Client {
    /**
     * 动态代理优点：
     *
     * 动态代理与静态代理相比较，
     * 最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。
     * 这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。
     * 而且动态代理的应用使我们的类职责更加单一，复用性更强
     * @param args
     */
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImpl());
        userManager.addUser("007", "spring007");
    }
}
