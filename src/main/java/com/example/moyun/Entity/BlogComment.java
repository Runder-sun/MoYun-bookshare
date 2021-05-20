package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blog_comment")
public class BlogComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BlogCommentID;
    private int BlogID;
    private String UserID;
    private String Comment;
    private Timestamp CommentTime;

    public BlogComment() {
    }

    public BlogComment(int blogCommentID, int blogID, String userID, String comment, Timestamp commentTime) {
        BlogCommentID = blogCommentID;
        BlogID = blogID;
        UserID = userID;
        Comment = comment;
        CommentTime = commentTime;
    }

    public int getBlogCommentID() {
        return BlogCommentID;
    }

    public void setBlogCommentID(int blogCommentID) {
        BlogCommentID = blogCommentID;
    }

    public int getBlogID() {
        return BlogID;
    }

    public void setBlogID(int blogID) {
        BlogID = blogID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Timestamp getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        CommentTime = commentTime;
    }
}
