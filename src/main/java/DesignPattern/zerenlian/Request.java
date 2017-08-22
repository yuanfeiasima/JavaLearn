package DesignPattern.zerenlian;

public class Request {
    Level level;
    private String[] messageTypes;

    public Request(Level level, String[] messageTypes){
        this.level = level;
        this.messageTypes = messageTypes;
    }

    public Level getLevel(){
        return level;
    }

    public String[] getMessageTypes() {
        return messageTypes;
    }

    public void setMessageType(String[] messageTypes) {
        this.messageTypes = messageTypes;
    }
}
