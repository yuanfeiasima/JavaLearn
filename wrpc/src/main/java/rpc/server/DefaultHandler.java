package rpc.server;

import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpc.common.IMessageHandler;
import rpc.common.MessageInput;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/10.
 */
public class DefaultHandler implements IMessageHandler<MessageInput> {

    private final static Logger LOG = LoggerFactory.getLogger(DefaultHandler.class);

    @Override
    public void handle(ChannelHandlerContext context, String requestId, MessageInput input) {
        LOG.error("unrecognizied message type {} comes", input.getType());
        context.close();
    }
}
