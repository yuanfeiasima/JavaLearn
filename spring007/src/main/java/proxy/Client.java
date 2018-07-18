package proxy;

import proxy.staticproxy.UserManagerImplProxy;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/18.
 */
public class Client {

    public static void main(String[] args) {
        UserManager userManagerImpl = new UserManagerImpl();
        UserManager proxy = new UserManagerImplProxy(userManagerImpl);
        proxy.addUser("007", "James");
    }
}
