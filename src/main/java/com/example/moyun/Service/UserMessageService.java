package com.example.moyun.Service;

import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.SystemMessage;
import com.example.moyun.Entity.User;
import com.example.moyun.Entity.UserMessage;
import com.example.moyun.Vo.UserMessageVo;


import java.util.List;

public interface UserMessageService {
    //查看全部UserMessage
    List<UserMessage> getAllUserMessage();

    //根据UserMessageID查找UserMessage
    UserMessage getUserMessageByUserMessageID(Integer UserMessageID);

    //UserMessageList转UserMessageVoList
    List<UserMessageVo> UserMessageToUserMessageVo(List<UserMessage> list);

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
    List<User> getMessageTarget(String UserID);

}
