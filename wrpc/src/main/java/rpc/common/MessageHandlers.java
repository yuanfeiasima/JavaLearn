package rpc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/6.
 */
public class MessageHandlers {
    private Map<String, IMessageHandler<?>> handlers = new HashMap<>();
    private IMessageHandler<MessageInput> defaultHandler;
    public void register(String type, IMessageHandler<?> handler) {
        handlers.put(type, handler);
    }

    public MessageHandlers defaultHandler(IMessageHandler<MessageInput> defaultHandler) {
        this.defaultHandler = defaultHandler;
        return this;
    }

    public IMessageHandler<MessageInput> defaultHandler() {
        return defaultHandler;
    }

    /**
     * 泛型的 T ？ 有什么区别？
     * @param type
     * @return
     */
    public IMessageHandler<?> get(String type) {
        IMessageHandler<?> handler = handlers.get(type);
        return handler;
    }
}
