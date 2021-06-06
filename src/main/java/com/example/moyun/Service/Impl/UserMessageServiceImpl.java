package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.UserMessageDao;
import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.SystemMessage;
import com.example.moyun.Entity.User;
import com.example.moyun.Entity.UserMessage;
import com.example.moyun.Service.UserMessageService;
import com.example.moyun.Vo.UserMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    private UserMessageDao userMessageDao;

    @Override
    public List<UserMessage> getAllUserMessage(){
        return userMessageDao.getAllUserMessage();
    }

    @Override
    public UserMessage getUserMessageByUserMessageID(Integer UserMessageID){
        return userMessageDao.getUserMessageByUserMessageID(UserMessageID);
    }

    @Override
    public List<UserMessageVo> UserMessageToUserMessageVo(List<UserMessage> list){
        List<UserMessageVo> userMessageVos=new ArrayList<>();
        for (UserMessage userMessage:list){
            UserMessageVo userMessageVo=new UserMessageVo();
            userMessageVo.setUserMessageID(userMessage.getUserMessageID());
            //待确认的属性
            userMessageVos.add(userMessageVo);
        }
        return userMessageVos;
    }

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
    public List<User> getMessageTarget(String UserID){
        return userMessageDao.getMessageTarget(UserID);
    }
}
