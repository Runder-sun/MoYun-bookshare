package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BlogDao;
import com.example.moyun.Entity.Blog;
import com.example.moyun.Entity.BlogCollection;
import com.example.moyun.Entity.BlogComment;
import com.example.moyun.Service.BlogService;
import com.example.moyun.Vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    public List<BlogVo> BlogToBlogVo(List<Blog> list){
        List<BlogVo> blogVos=new ArrayList<>();
        for (Blog blog:list){
            BlogVo blogVo=new BlogVo();
            blogVo.setBlogID(blog.getBlogID());
            //待确认的属性
            blogVos.add(blogVo);
        }
        return blogVos;
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
}
