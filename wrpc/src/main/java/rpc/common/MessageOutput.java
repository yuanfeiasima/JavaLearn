package rpc.common;

import lombok.Data;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/6.
 */
@Data
public class MessageOutput {
    private String requestId;
    private String type;
    private Object payload;

    public MessageOutput(String requestId, String type, Object payload) {
        this.requestId = requestId;
        this.type = type;
        this.payload = payload;
    }
}
