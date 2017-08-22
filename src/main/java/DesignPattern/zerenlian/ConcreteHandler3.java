package DesignPattern.zerenlian;

public class ConcreteHandler3 extends Handler{
    protected Level getHandlerLevel() {
        return new Level(5);
    }

    @Override
    protected String getMessageType() {
        return "短信";
    }

    public Response response(Request request) {
//        System.out.println("-----请求由处理器3进行处理-----");
        if (this.getMessageType().equals(request.getMessageType())) {
            System.out.println("----发短信-----");
        }
        return null;
    }
}

