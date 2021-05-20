package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "book_review_collection")
public class BookReviewCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookReviewCollectionID;
    private int BookReviewID;
    private String UserID;
    private Timestamp CollectTime;

    public BookReviewCollection() {
    }

    public BookReviewCollection(int bookReviewCollectionID, int bookReviewID, String userID, Timestamp collectTime) {
        BookReviewCollectionID = bookReviewCollectionID;
        BookReviewID = bookReviewID;
        UserID = userID;
        CollectTime = collectTime;
    }

    public int getBookReviewCollectionID() {
        return BookReviewCollectionID;
    }

    public void setBookReviewCollectionID(int bookReviewCollectionID) {
        BookReviewCollectionID = bookReviewCollectionID;
    }

    public int getBookReviewID() {
        return BookReviewID;
    }

    public void setBookReviewID(int bookReviewID) {
        BookReviewID = bookReviewID;
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
