package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "book_review")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookReviewID;
    private int BookID;
    private int UserID;
    private Timestamp ReviewTime;
    private String Content;
    private String Title;
    private int Score;
    private int Likes;

    public BookReview() {
    }

    public BookReview(int bookReviewID, int bookID, int userID, Timestamp reviewTime, String content, String title, int score, int likes) {
        BookReviewID = bookReviewID;
        BookID = bookID;
        UserID = userID;
        ReviewTime = reviewTime;
        Content = content;
        Title = title;
        Score = score;
        Likes = likes;
    }

    public int getBookReviewID() {
        return BookReviewID;
    }

    public void setBookReviewID(int bookReviewID) {
        BookReviewID = bookReviewID;
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

    public Timestamp getReviewTime() {
        return ReviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        ReviewTime = reviewTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }
}
