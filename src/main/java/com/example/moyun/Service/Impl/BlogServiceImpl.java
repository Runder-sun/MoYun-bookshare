package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BlogDao;
import com.example.moyun.Entity.Blog;
import com.example.moyun.Entity.BlogCollection;
import com.example.moyun.Entity.BlogComment;
import com.example.moyun.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Override
    public void deleteBlog(Integer BlogID){
        blogDao.deleteBlog(BlogID);
    }

    @Override
    public List<Blog> getAllBlog(){
        return blogDao.getAllBlog();
    }

    @Override
    public Blog getBlogByBlogID(Integer BlogID){
        return blogDao.getBlogByBlogID(BlogID);
    }

    @Override
    public List<BlogCollection> getBlogCollectionByUserID(String UserID){
        return blogDao.getBlogCollectionByUserID(UserID);
    }

    @Override
    public List<Blog> getBlogListByUserID(String UserID){
        return blogDao.getBlogListByUserID(UserID);
    }

    @Override
    public void addBlog(Blog blog){
        blogDao.addBlog(blog);
    }

    @Override
    public void editBlog(Integer BlogID, String BlogTitle, Timestamp RecentFinishTime, String Content){
        blogDao.editBlog(BlogID,BlogTitle,RecentFinishTime,Content);
    }

    @Override
    public void addBlogComment(BlogComment blogComment){
        blogDao.addBlogComment(blogComment);
    }

    @Override
    public void reprintBlog(Blog blog){
        blogDao.reprintBlog(blog);
    }

    @Override
    public List<BlogComment> getBlogCommentListByBlogID(Integer BlogID){
        return blogDao.getBlogCommentListByBlogID(BlogID);
    }

    @Override
    public void deleteBlogComment(Integer BlogID){
        blogDao.deleteBlogComment(BlogID);
    }

    @Override
    public void collectBlog(BlogCollection blogCollection){
        blogDao.collectBlog(blogCollection);
    }

    @Override
    public void likeBlog(Integer BlogID){
        blogDao.likeBlog(BlogID);
    }

    @Override
    public void cancelLikeBlog(Integer BlogID){
        blogDao.cancelLikeBlog(BlogID);
    }

    @Override
    public void cancelCollectBlog(Integer BlogCollectionID){
        blogDao.cancelCollectBlog(BlogCollectionID);
    }

    @Override
    public void deleteBlogCollection(Integer BlogID){
        blogDao.deleteBlogCollection(BlogID);
    }

    @Override
    public List<Blog> getBlogDT(String UserID){
        return blogDao.getBlogDT(UserID);
    }

    @Override
    public BlogCollection isCollect(String UserID,Integer BlogID){
        return blogDao.isCollect(UserID,BlogID);
    }
}
