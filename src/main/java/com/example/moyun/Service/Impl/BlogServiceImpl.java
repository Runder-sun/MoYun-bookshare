package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.BlogDao;
import com.example.moyun.Entity.Blog;
import com.example.moyun.Service.BlogService;
import com.example.moyun.Vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Blog> getBlogCollectionByUserID(String UserID){
        return blogDao.getBlogCollectionByUserID(UserID);
    }
}
