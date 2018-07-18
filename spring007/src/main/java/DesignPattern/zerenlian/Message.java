package DesignPattern.zerenlian;

public class Message {
    Level level;
    private String[] messageTypes;
    private boolean sendMail;
    private boolean sendShortMsg;
    private boolean sendApp;



    public Message(Level level, String[] messageTypes){
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
