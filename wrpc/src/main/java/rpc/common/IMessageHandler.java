package rpc.common;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author wangwentao1@jd.com
 * @date 2018/7/26.
 */
// TODO: 2018/9/10 这个注解
@FunctionalInterface
public interface IMessageHandler<T> {
    void handle(ChannelHandlerContext context, String requestId, T message);
}
