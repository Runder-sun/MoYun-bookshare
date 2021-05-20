package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "system_message")
public class SystemMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SystemMessageID;
    private String Content;
    private String UserID;
    private Timestamp MessageTime;

    public SystemMessage() {
    }

    public SystemMessage(int systemMessageID, String content, String userID, Timestamp messageTime) {
        SystemMessageID = systemMessageID;
        Content = content;
        UserID = userID;
        MessageTime = messageTime;
    }

    public int getSystemMessageID() {
        return SystemMessageID;
    }

    public void setSystemMessageID(int systemMessageID) {
        SystemMessageID = systemMessageID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public Timestamp getMessageTime() {
        return MessageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        MessageTime = messageTime;
    }
}
