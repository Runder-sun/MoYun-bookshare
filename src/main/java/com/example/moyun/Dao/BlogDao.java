package com.example.moyun.Dao;

import com.example.moyun.Entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDao {
    void deleteBlog(Integer BlogID);
    List<Blog> getAllBlog();
    Blog getBlogByBlogID(Integer BlogID);
    List<Blog> getBlogCollectionByUserID(String UserID);
}
