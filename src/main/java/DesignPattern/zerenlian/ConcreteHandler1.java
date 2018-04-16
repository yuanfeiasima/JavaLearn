package DesignPattern.zerenlian;

public class ConcreteHandler1 extends Handler{
    protected Level getHandlerLevel() {
        return new Level(1);
    }
    protected String getMessageType() {
        return "mail";
    }
    public Response response(Message request) {
        String[] messages = request.getMessageTypes();
        for (String s : messages) {
            if (s.equals(this.getMessageType())) {
                System.out.println("----发邮件-----");
            }
        }

//       System.out.println("-----请求由处理器1进行处理-----");
        return null;
    }
}
