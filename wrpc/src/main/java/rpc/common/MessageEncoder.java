package rpc.common;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/10.
 */
public class MessageEncoder extends MessageToMessageEncoder<MessageOutput> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageOutput messageOutput, List<Object> list) throws Exception {

    }
}
