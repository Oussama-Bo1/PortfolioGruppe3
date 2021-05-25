package ApplicationServicePackage;

import java.io.Serializable;

public class MessageObject implements Serializable {
    private int senderID;
    private int recipientID;
    private String text;

    public MessageObject(int senderID, int recipientID, String text) {
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.text = text;
    }

    public int getSenderID() {
        return senderID;
    }

    public String getText() {
        return text;
    }
}
