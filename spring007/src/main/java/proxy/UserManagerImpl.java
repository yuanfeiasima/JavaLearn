package proxy;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/18.
 */
public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String userId, String userName) {
        System.out.println("UserManagerImpl add user: " + userId + "name: " + userName);
    }
}
