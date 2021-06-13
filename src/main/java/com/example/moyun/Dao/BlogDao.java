package com.example.moyun.Dao;

import com.example.moyun.Entity.Blog;
import com.example.moyun.Entity.BlogCollection;
import com.example.moyun.Entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BlogDao {
    void deleteBlog(Integer BlogID);

    List<Blog> getAllBlog();

    Blog getBlogByBlogID(Integer BlogID);

    List<BlogCollection> getBlogCollectionByUserID(String UserID);

    List<Blog> getBlogListByUserID(String UserID);

    void addBlog(Blog blog);

    void editBlog(Integer BlogID, String BlogTitle, Timestamp RecentFinishTime, String Content);

    void addBlogComment(BlogComment blogComment);

    void reprintBlog(Blog blog);

    List<BlogComment> getBlogCommentListByBlogID(Integer BlogID);

    void deleteBlogComment(Integer BlogID);

    void collectBlog(BlogCollection blogCollection);

    void likeBlog(Integer BlogID);

    void cancelLikeBlog(Integer BlogID);

    void cancelCollectBlog(Integer BlogCollectionID);

    void deleteBlogCollection(Integer BlogID);

    List<Blog> getBlogDT(String UserID);

    BlogCollection isCollect(String UserID,Integer BlogID);
}
