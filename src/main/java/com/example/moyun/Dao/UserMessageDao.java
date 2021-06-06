package com.example.moyun.Dao;

import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.SystemMessage;
import com.example.moyun.Entity.User;
import com.example.moyun.Entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMessageDao {
    List<UserMessage> getAllUserMessage();

    UserMessage getUserMessageByUserMessageID(Integer UserMessageID);

    List<UserMessage> getUserMessageListBySendIDAndGetID(String SendID,String GetID);

    void addUserMessage(UserMessage userMessage);

    void addSystemMessage(SystemMessage systemMessage);

    List<SystemMessage> getSystemMessageByUserID(String UserID);

    List<Book> getPersonalRecommend(String UserID);

    List<User> getMessageTarget(String UserID);
}
