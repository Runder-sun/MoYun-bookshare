package com.example.moyun.Dao;

import com.example.moyun.Entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface GroupDao {
    void deleteGroup(Integer GroupID);

    List<Group> getAllGroup();

    Group getGroupByGroupID(Integer GroupID);

    List<Group> getHotGroup();

    List<GroupCollection> getGroupCollectionByUserID(String UserID);

    void addGroup(Group group);

    void addGroupMember(GroupMember groupMember);

    void deleteGroupMember(Integer MemberID);

    void updateGroupInfo(Integer GroupID,String GroupName,String Tag,Integer isPrivate,String Introduce);

    List<GroupMember> getGroupMemberListByGroupID(Integer GroupID);

    void addGroupApply(GroupApply groupApply);

    void updateGroupApply(Integer GroupApplyID);

    List<GroupApply> getGroupApplyListByGroupID(Integer GroupID);

    void deleteGroupApply(Integer GroupApplyID);

    List<Group> getGroupListByUserID(String UserID);

    void addTask(Task task);

    List<Task> getTaskList(Integer GroupID);

    void collectGroup(GroupCollection groupCollection);

    void cancelCollectGroup(Integer BlogID,String UserID);

    void deleteGroupCollection(Integer GroupID);

    void deleteTask(Integer GroupID);

    void deleteMemberList(Integer GroupID);

    void deleteGroupApplyByGroupID(Integer GroupID);

    GroupApply getGroupApplyByGroupApplyID(Integer GroupApplyID);

    List<Group> searchGroup(String GroupName,String Tag);

    GroupCollection isCollect(String UserID,Integer GroupID);
}
