package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/18.
 */
public class LogHandler implements InvocationHandler {

    private Object targetObject;

    /**
     * 绑定被调用对象
     *
     * @param targetObject
     * @return
     */
    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        Object result = null;
        try {
            System.out.println("before");
            result = method.invoke(targetObject, args);
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
            throw e;
        }
        return result;
    }
}
