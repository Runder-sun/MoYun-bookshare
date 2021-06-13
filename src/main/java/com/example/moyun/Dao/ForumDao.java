package com.example.moyun.Dao;

import com.example.moyun.Entity.Forum;
import com.example.moyun.Entity.ForumMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ForumDao {
    void deleteForum(Integer ForumID);

    List<Forum> getAllForum();

    Forum getForumByForumID(Integer ForumID);

    void addForum(Forum forum);

    List<ForumMessage> getForumMessageListByForumID(Integer ForumID);

    void addForumMessage(ForumMessage forumMessage);

    List<Forum> getHotForumByGroupID(Integer GroupID);

    List<Forum> getForumByGroupID(Integer GroupID);

    void addMessageNum(Integer ForumID);

    void deleteForumMessage(Integer ForumID);

    void deleteForumByGroupID(Integer GroupID);

    void deleteForumMessageByGroupID(Integer GroupID);
}
