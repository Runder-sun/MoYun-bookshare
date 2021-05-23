package com.example.moyun.Dao;

import com.example.moyun.Entity.Forum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ForumDao {
    void deleteForum(Integer ForumID);

    List<Forum> getAllForum();

    Forum getForumByForumID(Integer ForumID);
}
