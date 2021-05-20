package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_message")
public class UserMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserMessageID;
    private String GetID;
    private String SendID;
    private String Message;
    private Timestamp SendTime;

    public UserMessage() {
    }

    public UserMessage(int userMessageID, String getID, String sendID, String message, Timestamp sendTime) {
        UserMessageID = userMessageID;
        GetID = getID;
        SendID = sendID;
        Message = message;
        SendTime = sendTime;
    }

    public int getUserMessageID() {
        return UserMessageID;
    }

    public void setUserMessageID(int userMessageID) {
        UserMessageID = userMessageID;
    }

    public String getGetID() {
        return GetID;
    }

    public void setGetID(String getID) {
        GetID = getID;
    }

    public String getSendID() {
        return SendID;
    }

    public void setSendID(String sendID) {
        SendID = sendID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Timestamp getSendTime() {
        return SendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        SendTime = sendTime;
    }
}
