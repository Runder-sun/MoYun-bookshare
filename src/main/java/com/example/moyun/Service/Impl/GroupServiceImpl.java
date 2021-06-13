package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.GroupDao;
import com.example.moyun.Entity.*;
import com.example.moyun.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    @Override
    public void deleteGroup(Integer GroupID){
        groupDao.deleteGroup(GroupID);
    }

    @Override
    public List<Group> getAllGroup(){
        return groupDao.getAllGroup();
    }

    @Override
    public Group getGroupByGroupID(Integer GroupID){
        return groupDao.getGroupByGroupID(GroupID);
    }

    @Override
    public List<Group> getHotGroup(){
        return groupDao.getHotGroup();
    }

    @Override
    public List<GroupCollection> getGroupCollectionByUserID(String UserID){
        return groupDao.getGroupCollectionByUserID(UserID);
    }

    @Override
    public void addGroup(Group group){
        groupDao.addGroup(group);
    }

    @Override
    public void addGroupMember(GroupMember groupMember){
        groupDao.addGroupMember(groupMember);
    }

    @Override
    public void deleteGroupMember(Integer MemberID){
        groupDao.deleteGroupMember(MemberID);
    }

    @Override
    public void updateGroupInfo(Integer GroupID,String GroupName,String Tag,Integer isPrivate,String Introduce){
        groupDao.updateGroupInfo(GroupID,GroupName,Tag,isPrivate,Introduce);
    }

    @Override
    public List<GroupMember> getGroupMemberListByGroupID(Integer GroupID){
        return groupDao.getGroupMemberListByGroupID(GroupID);
    }

    @Override
    public void addGroupApply(GroupApply groupApply){
        groupDao.addGroupApply(groupApply);
    }

    @Override
    public void updateGroupApply(Integer GroupApplyID){
        groupDao.updateGroupApply(GroupApplyID);
    }

    @Override
    public List<GroupApply> getGroupApplyListByGroupID(Integer GroupID){
        return groupDao.getGroupApplyListByGroupID(GroupID);
    }

    @Override
    public void deleteGroupApply(Integer GroupApplyID){
        groupDao.deleteGroupApply(GroupApplyID);
    }

    @Override
    public List<Group> getGroupListByUserID(String UserID){
        return groupDao.getGroupListByUserID(UserID);
    }

    @Override
    public void addTask(Task task){
        groupDao.addTask(task);
    }

    @Override
    public List<Task> getTaskList(Integer GroupID){
        return groupDao.getTaskList(GroupID);
    }

    @Override
    public void collectGroup(GroupCollection groupCollection){
        groupDao.collectGroup(groupCollection);
    }

    @Override
    public void cancelCollectGroup(Integer GroupCollectionID){
        groupDao.cancelCollectGroup(GroupCollectionID);
    }

    @Override
    public void deleteGroupCollection(Integer GroupID){
        groupDao.deleteGroupCollection(GroupID);
    }

    @Override
    public void deleteTask(Integer GroupID){
        groupDao.deleteTask(GroupID);
    }

    @Override
    public void deleteMemberList(Integer GroupID){
        groupDao.deleteMemberList(GroupID);
    }

    @Override
    public void deleteGroupApplyByGroupID(Integer GroupID){
        groupDao.deleteGroupApplyByGroupID(GroupID);
    }

    @Override
    public GroupApply getGroupApplyByGroupApplyID(Integer GroupApplyID){
        return groupDao.getGroupApplyByGroupApplyID(GroupApplyID);
    }

    @Override
    public List<Group> searchGroup(String GroupName,String Tag){
        return groupDao.searchGroup(GroupName,Tag);
    }

    @Override
    public GroupCollection isCollect(String UserID,Integer GroupID){
        return groupDao.isCollect(UserID,GroupID);
    }
}
