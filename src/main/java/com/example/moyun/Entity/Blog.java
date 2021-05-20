package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "blog_info")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BlogID;
    private String BlogTitle;
    private String AuthorID;
    private Timestamp RecentFinishTime;
    private String Content;
    private boolean isReprint;
    private int Likes;

    public Blog(int blogID, String blogTitle, String authorID, Timestamp recentFinishTime, String content, boolean isReprint, int likes) {
        BlogID = blogID;
        BlogTitle = blogTitle;
        AuthorID = authorID;
        RecentFinishTime = recentFinishTime;
        Content = content;
        this.isReprint = isReprint;
        Likes = likes;
    }

    public Blog() {
    }

    public String getBlogTitle() {
        return BlogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        BlogTitle = blogTitle;
    }

    public String getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(String authorID) {
        AuthorID = authorID;
    }

    public Timestamp getRecentFinishTime() {
        return RecentFinishTime;
    }

    public void setRecentFinishTime(Timestamp recentFinishTime) {
        RecentFinishTime = recentFinishTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isReprint() {
        return isReprint;
    }

    public void setReprint(boolean reprint) {
        isReprint = reprint;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public int getBlogID() {
        return BlogID;
    }

    public void setBlogID(int blogID) {
        BlogID = blogID;
    }
}
