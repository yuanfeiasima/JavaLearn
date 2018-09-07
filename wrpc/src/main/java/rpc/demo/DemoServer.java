package rpc.demo;

import io.netty.channel.ChannelHandlerContext;
import rpc.common.IMessageHandler;
import rpc.common.MessageOutput;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwentao1@jd.com
 * @date 2018/9/6.
 */

class FibRequestHandler implements IMessageHandler<Integer> {

    private List<Long> fibs = new ArrayList<>();

    {
        fibs.add(1L);
        fibs.add(1L);
    }

    @Override
    public void handle(ChannelHandlerContext ctx, String requestId, Integer n) {
        for (int i = fibs.size(); i < n + 1; i++) {
            long value = fibs.get(i - 2) + fibs.get(i - 1);
            fibs.add(value);
        }
        ctx.writeAndFlush(new MessageOutput(requestId, "fib_res", fibs.get(n)));
    }
}

class ExpRequestHandler implements IMessageHandler<ExpRequest> {

    @Override
    public void handle(ChannelHandlerContext ctx, String requestId, ExpRequest message) {
        int base = message.getBase();
        int exp = message.getExp();
        long start = System.nanoTime();
        long res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        long cost = System.nanoTime() - start;
        ctx.writeAndFlush(new MessageOutput(requestId, "exp_res", new ExpResponse(res, cost)));
    }
}

public class DemoServer {

    public static void main(String[] args) {
        RPCServer
    }
}
