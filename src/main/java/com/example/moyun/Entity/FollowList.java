package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "follow_list")
public class FollowList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FollowListID;
    private String FollowerID;
    private String FollowedID;
    private Timestamp FollowTime;

    public FollowList() {
    }

    public FollowList(int followListID, String followerID, String followedID, Timestamp followTime) {
        FollowListID = followListID;
        FollowerID = followerID;
        FollowedID = followedID;
        FollowTime = followTime;
    }

    public int getFollowListID() {
        return FollowListID;
    }

    public void setFollowListID(int followListID) {
        FollowListID = followListID;
    }

    public String getFollowerID() {
        return FollowerID;
    }

    public void setFollowerID(String followerID) {
        FollowerID = followerID;
    }

    public String getFollowedID() {
        return FollowedID;
    }

    public void setFollowedID(String followedID) {
        FollowedID = followedID;
    }

    public Timestamp getFollowTime() {
        return FollowTime;
    }

    public void setFollowTime(Timestamp followTime) {
        FollowTime = followTime;
    }
}
