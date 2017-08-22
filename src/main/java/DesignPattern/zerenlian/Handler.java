package DesignPattern.zerenlian;

public abstract class Handler {
    private Handler nextHandler;
    public final Response handleRequest(Request request){
        Response response = null;

//        if(this.getHandlerLevel().above(request.getLevel())){
//            response = this.response(request);
//        }else{
//            if(this.nextHandler != null){
//                this.nextHandler.handleRequest(request);
//            }else{
//                System.out.println("-----没有合适的处理器-----");
//            }
//        }

        this.response(request);
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(request);
        } else {
            System.out.println("----------handle finish----------");
        }


        return response;
    }
    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }
    protected abstract Level getHandlerLevel();
    protected abstract String getMessageType();
    public abstract Response response(Request request);
}
