package com.example.moyun.Service;

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
}
