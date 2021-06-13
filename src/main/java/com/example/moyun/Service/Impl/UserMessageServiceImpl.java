package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.UserMessageDao;
import com.example.moyun.Entity.*;
import com.example.moyun.Service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    private UserMessageDao userMessageDao;

    @Override
    public List<UserMessage> getUserMessageListBySendIDAndGetID(String SendID,String GetID){
        return userMessageDao.getUserMessageListBySendIDAndGetID(SendID,GetID);
    }

    @Override
    public void addUserMessage(UserMessage userMessage){
        userMessageDao.addUserMessage(userMessage);
    }

    @Override
    public void addSystemMessage(SystemMessage systemMessage){
        userMessageDao.addSystemMessage(systemMessage);
    }

    @Override
    public List<SystemMessage> getSystemMessageByUserID(String UserID){
        return userMessageDao.getSystemMessageByUserID(UserID);
    }

    @Override
    public List<Book> getPersonalRecommend(String UserID){
        return userMessageDao.getPersonalRecommend(UserID);
    }

    @Override
    public List<FollowList> getMessageTarget(String UserID){
        return userMessageDao.getMessageTarget(UserID);
    }
}
