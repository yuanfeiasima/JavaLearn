package proxy.staticproxy;

import proxy.UserManager;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/18.
 */
public class UserManagerImplProxy implements UserManager {

    /**
     * 目标对象
     */
    private UserManager userManager;

    /**
     * 通过构造函数传入目标对象
     *
     * @param userManager
     */
    public UserManagerImplProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addUser(String userId, String userName) {
        System.out.println("start addUser");
        userManager.addUser(userId, userName);
        System.out.println("end addUser");
    }
}
