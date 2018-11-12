package rpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import rpc.common.IMessageHandler;
import rpc.common.MessageHandlers;
import rpc.common.MessageRegistry;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/6.
 */
public class RPCServer {

    private String ip;
    private int port;
    private int ioThreads;
    private int workerThread;
    private MessageHandlers handlers = new MessageHandlers();
    private MessageRegistry registry = new MessageRegistry();

    {
        handlers.defaultHandler(new DefaultHandler());
    }

    public RPCServer(String ip, int port, int ioThreads, int workThread) {
        this.ip = ip;
        this.port = port;
        this.ioThreads = ioThreads;
        this.workerThread = workThread;
    }

    private ServerBootstrap bootstrap;
    private EventLoopGroup group;
    private MessageCollector collector;
    private Channel serverChannel;

    public RPCServer service(String type, Class<?> clazz, IMessageHandler<?> handler) {
        registry.registry(type, clazz);
        handlers.register(type, handler);
        return this;
    }

    public void start(){
        bootstrap = new ServerBootstrap();
        group = new NioEventLoopGroup(ioThreads);
        bootstrap.group(group);
        collector = new MessageCollector(handlers, registry, workerThread);

//        MessageE
    }
}
