package com.example.moyun.Service;

import com.example.moyun.Entity.Forum;
import com.example.moyun.Entity.ForumMessage;

import java.util.List;

public interface ForumService {
    //删除讨论
    void deleteForum(Integer ForumID);

    //管理员获取讨论列表
    List<Forum> getAllForum();

    //根据ForumID查找Forum
    Forum getForumByForumID(Integer ForumID);

    //发起讨论
    void addForum(Forum forum);

    //获取讨论消息列表
    List<ForumMessage> getForumMessageListByForumID(Integer ForumID);

    //在讨论中发表消息
    void addForumMessage(ForumMessage forumMessage);

    //获取热门讨论列表
    List<Forum> getHotForumByGroupID(Integer GroupID);

    //获取圈子的讨论列表
    List<Forum> getForumByGroupID(Integer GroupID);

    //更改消息数
    void addMessageNum(Integer ForumID);

    //删除讨论时同步删除讨论消息
    void deleteForumMessage(Integer ForumID);

    //删除圈子时同步删除讨论
    void deleteForumByGroupID(Integer GroupID);

    //删除圈子时同步删除讨论消息
    void deleteForumMessageByGroupID(Integer GroupID);
}
