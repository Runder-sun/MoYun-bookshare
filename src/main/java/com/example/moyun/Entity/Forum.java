package com.example.moyun.Entity;

import javax.persistence.*;

@Entity
@Table(name = "forum_info")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ForumID;
    private String Topic;
    private int GroupID;
    private String CreateID;
    private String CreateTime;
    private String Kind;
    private int ForumMessages;

    public Forum() {
    }

    public Forum(int forumID, String topic, int groupID, String createID, String createTime, String kind, int forumMessages) {
        ForumID = forumID;
        Topic = topic;
        GroupID = groupID;
        CreateID = createID;
        CreateTime = createTime;
        Kind = kind;
        ForumMessages = forumMessages;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
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

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    public int getForumID() {
        return ForumID;
    }

    public void setForumID(int forumID) {
        ForumID = forumID;
    }

    public int getForumMessages() {
        return ForumMessages;
    }

    public void setForumMessages(int forumMessages) {
        ForumMessages = forumMessages;
    }
}
