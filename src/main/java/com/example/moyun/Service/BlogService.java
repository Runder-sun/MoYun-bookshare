package com.example.moyun.Service;

import com.example.moyun.Entity.Blog;
import com.example.moyun.Entity.BlogCollection;
import com.example.moyun.Entity.BlogComment;
import com.example.moyun.Vo.BlogVo;

import java.sql.Timestamp;
import java.util.List;

public interface BlogService {
    //删除日志
    void deleteBlog(Integer BlogID);

    //管理员获取所有日志
    List<Blog> getAllBlog();

    //查看日志信息
    Blog getBlogByBlogID(Integer BlogID);

    //BlogList转成BlogVoList
    List<BlogVo> BlogToBlogVo(List<Blog> list);

    //查看日志收藏
    List<BlogCollection> getBlogCollectionByUserID(String UserID);

    //获取用户日志列表
    List<Blog> getBlogListByUserID(String UserID);

    //发表日志
    void addBlog(Blog blog);

    //修改日志
    void editBlog(Integer BlogID,String BlogTitle,Timestamp RecentFinishTime,String Content);

    //评论日志
    void addBlogComment(BlogComment blogComment);

    //转载日志
    void reprintBlog(Blog blog);

    //获取日志评论列表
    List<BlogComment> getBlogCommentListByBlogID(Integer BlogID);

    //删除日志评论
    void deleteBlogComment(Integer BlogID);

    //收藏日志
    void collectBlog(BlogCollection blogCollection);

    //取消收藏日志
    void cancelCollectBlog(Integer BlogCollectionID);

    //点赞日志
    void likeBlog(Integer BlogID);

    //取消点赞日志
    void cancelLikeBlog(Integer BlogID);

    //删除收藏（删除日志引起的）日志记录
    void deleteBlogCollection(Integer BlogID);

    //获取动态日志
    List<Blog> getBlogDT(String UserID);
}
