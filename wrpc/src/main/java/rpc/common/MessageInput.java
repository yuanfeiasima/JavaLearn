package rpc.common;

import com.alibaba.fastjson.JSON;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/6.
 */
public class MessageInput {
    private String type;
    private String requestId;
    private String payload;

    public MessageInput(String type, String requestId, String payload) {
        this.type = type;
        this.requestId = requestId;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public String getRequestId() {
        return requestId;
    }

    public <T> T getPayload(Class<T> clazz) {
        if (payload == null) {
            return null;
        }
        return JSON.parseObject(payload, clazz);
    }
}
