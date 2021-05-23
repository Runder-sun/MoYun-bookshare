package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.ForumDao;
import com.example.moyun.Entity.Forum;
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
}
