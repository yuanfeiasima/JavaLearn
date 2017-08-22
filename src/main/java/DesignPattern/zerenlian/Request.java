package DesignPattern.zerenlian;

public class Request {
    Level level;
    private String messageType;

    public Request(Level level, String messageType){
        this.level = level;
        this.messageType = messageType;
    }

    public Level getLevel(){
        return level;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
