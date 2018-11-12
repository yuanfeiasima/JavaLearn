package rpc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/10.
 */
public class MessageRegistry {
    private Map<String, Class<?>> clazzes = new HashMap<>();

    public void registry(String type, Class<?> clazz) {
        clazzes.put(type, clazz);
    }

    public Class<?> get(String type) {
        return clazzes.get(type);
    }
}
