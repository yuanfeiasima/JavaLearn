package rpc.common;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/26.
 */
public interface IMessageHandler<T> {
    void handle(ChannelHandlerContext context, String requestId, T message);
}
