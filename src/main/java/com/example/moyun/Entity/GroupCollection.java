package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_collection")
public class GroupCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GroupCollectionID;
    private int UserID;
    private int GroupID;
    private Timestamp CollectTime;

    public GroupCollection() {
    }

    public GroupCollection(int groupCollectionID, int userID, int groupID, Timestamp collectTime) {
        GroupCollectionID = groupCollectionID;
        UserID = userID;
        GroupID = groupID;
        CollectTime = collectTime;
    }

    public int getGroupCollectionID() {
        return GroupCollectionID;
    }

    public void setGroupCollectionID(int groupCollectionID) {
        GroupCollectionID = groupCollectionID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public Timestamp getCollectTime() {
        return CollectTime;
    }

    public void setCollectTime(Timestamp collectTime) {
        CollectTime = collectTime;
    }
}
