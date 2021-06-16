package com.example.moyun.Service;

import com.example.moyun.Entity.*;

import java.sql.Timestamp;
import java.util.List;

public interface GroupService {
    //删除圈子
    void deleteGroup(Integer GroupID);

    //管理员查看全部圈子
    List<Group> getAllGroup();

    //查看圈子信息
    Group getGroupByGroupID(Integer GroupID);

    //查看人数最多的圈子(前8、热门圈子)
    List<Group> getHotGroup();

    //获取用户圈子收藏列表
    List<GroupCollection> getGroupCollectionByUserID(String UserID);

    //创建圈子
    void addGroup(Group group);

    //申请加入圈子
    void addGroupApply(GroupApply groupApply);

    //批准加入圈子
    void updateGroupApply(Integer GroupApplyID);

    //获取圈子申请列表
    List<GroupApply> getGroupApplyListByGroupID(Integer GroupID);

    //拒绝申请
    void deleteGroupApply(Integer GroupApplyID);

    //增加新成员
    void addGroupMember(GroupMember groupMember);

    //删除成员
    void deleteGroupMember(Integer MemberID);

    //修改圈子信息
    void updateGroupInfo(Integer GroupID,String GroupName,String Tag,Integer isPrivate,String Introduce);

    //获取成员列表
    List<GroupMember> getGroupMemberListByGroupID(Integer GroupID);

    //获取已加入圈子
    List<Group> getGroupListByUserID(String UserID);

    //发布任务
    void addTask(Task task);

    //获取任务列表
    List<Task> getTaskList(Integer GroupID);

    //收藏圈子
    void collectGroup(GroupCollection groupCollection);

    //取消收藏
    void cancelCollectGroup(Integer GroupID,String UserID);

    //删除圈子时同步删除圈子收藏
    void deleteGroupCollection(Integer GroupID);

    //删除圈子时同步删除任务列表
    void deleteTask(Integer GroupID);

    //删除圈子时同步删除成员列表
    void deleteMemberList(Integer GroupID);

    //删除圈子时同步删除申请列表
    void deleteGroupApplyByGroupID(Integer GroupID);

    //获取申请（一个）
    GroupApply getGroupApplyByGroupApplyID(Integer GroupApplyID);

    //搜索圈子
    List<Group> searchGroup(String GroupName,String Tag);

    //判断是否收藏
    GroupCollection isCollect(String UserID,Integer GroupID);
}
