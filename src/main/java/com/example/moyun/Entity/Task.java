package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task_info")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ForumID;
    private int GroupID;
    private String CreateID;
    private Timestamp CreateTime;
    private String TaskContent;

    public Task() {
    }

    public Task(int forumID, int groupID, String createID, Timestamp createTime, String taskContent) {
        ForumID = forumID;
        GroupID = groupID;
        CreateID = createID;
        CreateTime = createTime;
        TaskContent = taskContent;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public String getCreateID() {
        return CreateID;
    }

    public void setCreateID(String createID) {
        CreateID = createID;
    }

    public Timestamp getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Timestamp createTime) {
        CreateTime = createTime;
    }

    public String getTaskContent() {
        return TaskContent;
    }

    public void setTaskContent(String taskContent) {
        TaskContent = taskContent;
    }

    public int getForumID() {
        return ForumID;
    }

    public void setForumID(int forumID) {
        ForumID = forumID;
    }
}
