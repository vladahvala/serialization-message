package Serialization;

import java.io.*;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String recipient;
    private String text;
    private LocalDateTime timestamp;

    public Message(String sender, String recipient, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void display() {
        System.out.println("[" + timestamp + "] " + sender + " -> " + recipient + ": " + text);
    }
}
