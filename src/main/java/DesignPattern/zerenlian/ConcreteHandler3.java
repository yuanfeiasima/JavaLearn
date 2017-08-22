package DesignPattern.zerenlian;

public class ConcreteHandler3 extends Handler{
    protected Level getHandlerLevel() {
        return new Level(5);
    }

    @Override
    protected String getMessageType() {
        return "shortMessage";
    }

    public Response response(Request request) {
//        System.out.println("-----请求由处理器3进行处理-----");
        String[] messages = request.getMessageTypes();
        for (String s : messages) {
            if (s.equals(this.getMessageType())) {
                System.out.println("----发短信-----");
            }
        }
        return null;
    }
}

