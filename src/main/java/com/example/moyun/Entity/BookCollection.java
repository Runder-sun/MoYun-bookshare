package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "book_collection")
public class BookCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookCollectionID;
    private int BookID;
    private String UserID;
    private Timestamp CollectTime;

    public BookCollection() {
    }

    public BookCollection(int bookCollectionID, int bookID, String userID, Timestamp collectTime) {
        BookCollectionID = bookCollectionID;
        BookID = bookID;
        UserID = userID;
        CollectTime = collectTime;
    }

    public int getBookCollectionID() {
        return BookCollectionID;
    }

    public void setBookCollectionID(int bookCollectionID) {
        BookCollectionID = bookCollectionID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public Timestamp getCollectTime() {
        return CollectTime;
    }

    public void setCollectTime(Timestamp collectTime) {
        CollectTime = collectTime;
    }
}
