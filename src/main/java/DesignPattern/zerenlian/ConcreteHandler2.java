package DesignPattern.zerenlian;

public class ConcreteHandler2  extends Handler{
    protected Level getHandlerLevel(){
        return new Level(3);
    }

    @Override
    protected String getMessageType() {
        return "app";
    }

    public Response response(Request request) {
//        System.out.println("-----请求由处理器2进行处理-----");
        if (this.getMessageType().equals(request.getMessageType())) {
            System.out.println("----发app推送-----");
        }
        return null;
    }
}
