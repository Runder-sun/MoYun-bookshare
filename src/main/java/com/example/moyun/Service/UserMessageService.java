package com.example.moyun.Service;

import com.example.moyun.Entity.*;


import java.util.List;

public interface UserMessageService {
    //获取两个用户间的私信列表
    List<UserMessage> getUserMessageListBySendIDAndGetID(String SendID,String GetID);

    //发送私信
    void addUserMessage(UserMessage userMessage);

    //发送系统消息
    void addSystemMessage(SystemMessage systemMessage);

    //获取用户系统消息列表
    List<SystemMessage> getSystemMessageByUserID(String UserID);

    //获取个性化推荐
    List<Book> getPersonalRecommend(String UserID);

    //获取私信列表（关注者和被关注者）
    List<FollowList> getMessageTarget(String UserID);

}
