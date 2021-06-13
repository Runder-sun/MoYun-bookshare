package com.example.moyun.Dao;

import com.example.moyun.Entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMessageDao {
    List<UserMessage> getUserMessageListBySendIDAndGetID(String SendID,String GetID);

    void addUserMessage(UserMessage userMessage);

    void addSystemMessage(SystemMessage systemMessage);

    List<SystemMessage> getSystemMessageByUserID(String UserID);

    List<Book> getPersonalRecommend(String UserID);

    List<FollowList> getMessageTarget(String UserID);
}
