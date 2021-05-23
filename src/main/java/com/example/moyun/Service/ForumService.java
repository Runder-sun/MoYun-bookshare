package com.example.moyun.Service;

import com.example.moyun.Entity.Forum;
import com.example.moyun.Vo.ForumVo;

import java.util.List;

public interface ForumService {
    //删除Forum
    void deleteForum(Integer ForumID);

    //查看全部Forum
    List<Forum> getAllForum();

    //根据ForumID查找Forum
    Forum getForumByForumID(Integer ForumID);

    //ForumList转ForumVoList
    List<ForumVo> ForumToForumVo(List<Forum> list);
}
