package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blog_collection")
public class BlogCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BlogCollectionID;
    private int BlogID;
    private String UserID;
    private Timestamp CollectTime;

    public BlogCollection() {
    }

    public BlogCollection(int blogCollectionID, int blogID, String userID, Timestamp collectTime) {
        BlogCollectionID = blogCollectionID;
        BlogID = blogID;
        UserID = userID;
        CollectTime = collectTime;
    }

    public int getBlogCollectionID() {
        return BlogCollectionID;
    }

    public void setBlogCollectionID(int blogCollectionID) {
        BlogCollectionID = blogCollectionID;
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

    public Timestamp getCollectTime() {
        return CollectTime;
    }

    public void setCollectTime(Timestamp collectTime) {
        CollectTime = collectTime;
    }
}
