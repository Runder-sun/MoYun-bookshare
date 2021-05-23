package com.example.moyun.Service;

import com.example.moyun.Entity.Blog;
import com.example.moyun.Vo.BlogVo;

import java.util.List;

public interface BlogService {
    //删除Blog
    void deleteBlog(Integer BlogID);

    //查看全部Blog
    List<Blog> getAllBlog();

    //根据BlogID查找Blog
    Blog getBlogByBlogID(Integer BlogID);

    //BlogList转成BlogVoList
    List<BlogVo> BlogToBlogVo(List<Blog> list);
}
