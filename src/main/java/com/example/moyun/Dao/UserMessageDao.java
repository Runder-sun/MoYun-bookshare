package com.example.moyun.Dao;

import com.example.moyun.Entity.UserMessage;
import com.example.moyun.Vo.UserMessageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMessageDao {
    List<UserMessage> getAllUserMessage();

    UserMessage getUserMessageByUserMessageID(Integer UserMessageID);
}
