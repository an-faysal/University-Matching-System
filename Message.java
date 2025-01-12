package twentyfour.fall.oop.group2.final_java_project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    // Fields
    private String senderId; // ID of the sender
    private String receiverId; // ID of the receiver
    private String content; // Content of the message
    private LocalDateTime timestamp; // Time when the message was sent

    // Constructor
    public Message(String senderId, String receiverId, String content, LocalDateTime timestamp) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters
    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Method to format the timestamp
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    // Method to display message details
    public String displayMessage() {
        return "From: " + senderId + "\nTo: " + receiverId + "\nSent: " + getFormattedTimestamp() + "\nMessage: " + content;
    }
}
