package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "read_history")
public class ReadHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookHistoryID;
    private int BookID;
    private int UserID;
    private Timestamp ReadTime;

    public ReadHistory() {
    }

    public ReadHistory(int bookHistoryID, int bookID, int userID, Timestamp readTime) {
        BookHistoryID = bookHistoryID;
        BookID = bookID;
        UserID = userID;
        ReadTime = readTime;
    }

    public int getBookHistoryID() {
        return BookHistoryID;
    }

    public void setBookHistoryID(int bookHistoryID) {
        BookHistoryID = bookHistoryID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public Timestamp getReadTime() {
        return ReadTime;
    }

    public void setReadTime(Timestamp readTime) {
        ReadTime = readTime;
    }
}
