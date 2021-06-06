package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.ForumDao;
import com.example.moyun.Entity.Forum;
import com.example.moyun.Entity.ForumMessage;
import com.example.moyun.Service.ForumService;
import com.example.moyun.Vo.ForumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumDao forumDao;

    @Override
    public void deleteForum(Integer ForumID){
        forumDao.deleteForum(ForumID);
    }

    @Override
    public List<Forum> getAllForum(){
        return forumDao.getAllForum();
    }

    @Override
    public Forum getForumByForumID(Integer ForumID){
        return forumDao.getForumByForumID(ForumID);
    }

    @Override
    public List<ForumVo> ForumToForumVo(List<Forum> list){
        List<ForumVo> forumVos=new ArrayList<>();
        for (Forum forum:list){
            ForumVo forumVo=new ForumVo();
            forumVo.setForumID(forum.getForumID());
            //待确认的属性
            forumVos.add(forumVo);
        }
        return forumVos;
    }

    @Override
    public void addForum(Forum forum){
        forumDao.addForum(forum);
    }

    @Override
    public List<ForumMessage> getForumMessageListByForumID(Integer ForumID){
        return forumDao.getForumMessageListByForumID(ForumID);
    }

    @Override
    public void addForumMessage(ForumMessage forumMessage){
        forumDao.addForumMessage(forumMessage);
    }

    @Override
    public List<Forum> getHotForumByGroupID(Integer GroupID){
        return forumDao.getHotForumByGroupID(GroupID);
    }

    @Override
    public List<Forum> getForumByGroupID(Integer GroupID){
        return forumDao.getForumByGroupID(GroupID);
    }

    @Override
    public void addMessageNum(Integer ForumID){
        forumDao.addMessageNum(ForumID);
    }

    @Override
    public void deleteForumMessage(Integer ForumID){
        forumDao.deleteForumMessage(ForumID);
    }

    @Override
    public void deleteForumByGroupID(Integer GroupID){
        forumDao.deleteForumByGroupID(GroupID);
    }

    @Override
    public void deleteForumMessageByGroupID(Integer GroupID){
        forumDao.deleteForumMessageByGroupID(GroupID);
    }
}
