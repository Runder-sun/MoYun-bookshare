package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "forum_message")
public class ForumMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ForumMessageID;
    private int ForumID;
    private String UserID;
    private String Content;
    private Timestamp CommentTime;

    public ForumMessage() {
    }

    public ForumMessage(int forumMessageID, int forumID, String userID, String content, Timestamp commentTime) {
        ForumMessageID = forumMessageID;
        ForumID = forumID;
        UserID = userID;
        Content = content;
        CommentTime = commentTime;
    }

    public int getForumMessageID() {
        return ForumMessageID;
    }

    public void setForumMessageID(int forumMessageID) {
        ForumMessageID = forumMessageID;
    }

    public int getForumID() {
        return ForumID;
    }

    public void setForumID(int forumID) {
        ForumID = forumID;
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
