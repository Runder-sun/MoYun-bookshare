package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_member")
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MemberID;
    private int UserID;
    private int GroupID;
    private Timestamp EnterTime;

    public GroupMember() {
    }

    public GroupMember(int memberID, int userID, int groupID, Timestamp enterTime) {
        MemberID = memberID;
        UserID = userID;
        GroupID = groupID;
        EnterTime = enterTime;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) {
        MemberID = memberID;
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

    public Timestamp getEnterTime() {
        return EnterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        EnterTime = enterTime;
    }
}
