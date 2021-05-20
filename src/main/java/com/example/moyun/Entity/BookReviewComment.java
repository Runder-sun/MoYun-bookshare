package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "book_review_comment")
public class BookReviewComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookReviewCommentID;
    private int BookReviewID;
    private String UserID;
    private String Content;
    private Timestamp CommentTime;

    public BookReviewComment() {
    }

    public BookReviewComment(int bookReviewCommentID, int bookReviewID, String userID, String content, Timestamp commentTime) {
        BookReviewCommentID = bookReviewCommentID;
        BookReviewID = bookReviewID;
        UserID = userID;
        Content = content;
        CommentTime = commentTime;
    }

    public int getBookReviewCommentID() {
        return BookReviewCommentID;
    }

    public void setBookReviewCommentID(int bookReviewCommentID) {
        BookReviewCommentID = bookReviewCommentID;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Timestamp getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        CommentTime = commentTime;
    }
}
