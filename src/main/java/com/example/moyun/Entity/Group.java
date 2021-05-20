package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "group_info")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GroupID;
    private String GroupName;
    private String Tag;
    private String CreateID;
    private Timestamp CreateTime;
    private int MemberNum;
    private boolean isPrivate;

    public Group() {
    }


    public Group(int groupID, String groupName, String tag, String createID, Timestamp createTime, int memberNum, boolean isPrivate) {
        GroupID = groupID;
        GroupName = groupName;
        Tag = tag;
        CreateID = createID;
        CreateTime = createTime;
        MemberNum = memberNum;
        this.isPrivate = isPrivate;
    }


    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
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

    public int getMemberNum() {
        return MemberNum;
    }

    public void setMemberNum(int memberNum) {
        MemberNum = memberNum;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }
}
