package rpc.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpc.common.IMessageHandler;
import rpc.common.MessageHandlers;
import rpc.common.MessageInput;
import rpc.common.MessageRegistry;
import sun.rmi.runtime.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/10.
 */

/**
 * 这个注解是什么作用？
 */
@ChannelHandler.Sharable
public class MessageCollector extends ChannelInboundHandlerAdapter {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageCollector.class);

    private ThreadPoolExecutor executor;
    private MessageHandlers handlers;
    private MessageRegistry registry;

    public MessageCollector(MessageHandlers handlers, MessageRegistry registry, int workerThread) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger seq = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("rpc-" + seq.getAndIncrement());
                return t;
            }
        };


        // TODO: 2018/9/10 参数的含义
        this.executor = new ThreadPoolExecutor(1, workerThread, 30,
                TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.CallerRunsPolicy());

        this.handlers = handlers;
        this.registry = registry;
    }

    /**
     * 两个shutdown的不同
     */
    public void closeGracefully(){
        this.executor.shutdown();
        try {
            this.executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        this.executor.shutdownNow();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        LOGGER.debug("connection comes");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.debug("connection leaves");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        if (msg instanceof MessageInput) {
            this.executor.execute(()->{
                this.handleMessage(ctx, (MessageInput) msg);
            });
        }

    }

    private void handleMessage(ChannelHandlerContext ctx, MessageInput input) {
        Class<?> clazz = registry.get(input.getType());
        if (clazz == null) {
            handlers.defaultHandler().handle(ctx, input.getRequestId(), input);
            return;
        }

        Object o = input.getPayload(clazz);
        IMessageHandler<Object> handler = (IMessageHandler<Object>) handlers.get(input.getType());
        if (handler != null) {
            handler.handle(ctx, input.getRequestId(), o);
        } else {
            handlers.defaultHandler().handle(ctx, input.getRequestId(), input);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.warn("connection error", cause);
    }
}
