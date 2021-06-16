package com.example.moyun.Controller;

import com.example.moyun.Entity.*;
import com.example.moyun.Service.BlogService;
import com.example.moyun.Service.UserMessageService;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMessageService userMessageService;

    @PostMapping("/deleteBlog")//删除日志（已完成测试）
    public Map<String,Object> deleteBlog(@RequestBody Map<String,String> delmap){
        Integer BlogID= Integer.valueOf(delmap.get("BlogID"));
        Map<String,Object> map=new HashMap<>();
        try{
            blogService.deleteBlogCollection(BlogID);
            blogService.deleteBlogComment(BlogID);
            blogService.deleteBlog(BlogID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectBlog")//查看日志信息（已完成测试）
    public Map<String,Object> inspectBlog(HttpServletRequest request, @RequestParam("BlogID")Integer BlogID){
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        // Integer BlogID= Integer.valueOf(insmap.get("BlogID"));
        Map<String,Object> map=new HashMap<>();
        try{
            Blog blog=blogService.getBlogByBlogID(BlogID);
            List<BlogComment> blogCommentList=blogService.getBlogCommentListByBlogID(BlogID);
            List<User> users=new ArrayList<>();
            if(blogCommentList.size()!=0){
                for(BlogComment blogComment:blogCommentList){
                    users.add(userService.getUserByUserID(blogComment.getUserID()));
                }
            }
            boolean isCollect = blogService.isCollect(UserID,BlogID)!=null;
            map.put("blogInfo",blog);
            map.put("isCollect",isCollect);
            map.put("blogCommentList",blogCommentList);
            map.put("blogCommentUser",users);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/BlogList")//查看个人日志列表（已完成测试）
    public Map<String,Object> blogList(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<Blog> blogList=blogService.getBlogListByUserID(UserID);
            map.put("blogList",blogList);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/WriteBlog")//写日志（已完成测试）
    public Map<String,Object> writeBlog(HttpServletRequest request,@RequestBody Map<String,String> writeBlogMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        String BlogTitle=writeBlogMap.get("BlogTitle");
        Timestamp RecentFinishTime=new Timestamp(System.currentTimeMillis());
        String Content=writeBlogMap.get("Content");
        try {
            Blog blog=new Blog();
            blog.setBlogTitle(BlogTitle);
            blog.setAuthorID(UserID);
            blog.setRecentFinishTime(RecentFinishTime);
            blog.setContent(Content);
            blogService.addBlog(blog);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/EditBlog")//修改日志（已完成测试）
    public Map<String,Object> editBlog(@RequestBody Map<String,String> editBlogMap){
        Map<String,Object> map=new HashMap<>();
        Integer BlogID=Integer.valueOf(editBlogMap.get("BlogID"));
        String BlogTitle=editBlogMap.get("BlogTitle");
        Timestamp RecentFinishTime=new Timestamp(System.currentTimeMillis());
        String Content=editBlogMap.get("Content");
        try {
            blogService.editBlog(BlogID,BlogTitle,RecentFinishTime,Content);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/WriteBlogComment")//评论日志（已完成测试）
    public Map<String,Object> writeBlogComment(HttpServletRequest request,@RequestBody Map<String,String> blogCommentMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BlogID= Integer.valueOf(blogCommentMap.get("BlogID"));
        String Comment=blogCommentMap.get("Comment");
        Timestamp CommentTime=new Timestamp(System.currentTimeMillis());
        try {
            BlogComment blogComment=new BlogComment();
            blogComment.setBlogID(BlogID);
            blogComment.setComment(Comment);
            blogComment.setUserID(UserID);
            blogComment.setCommentTime(CommentTime);
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(CommentTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"评论了你的日志！");
            systemMessage.setUserID(blogService.getBlogByBlogID(BlogID).getAuthorID());
            blogService.addBlogComment(blogComment);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/ReprintBlog")//转载日志(已完成测试)
    public Map<String,Object> reprintBlog(HttpServletRequest request,@RequestBody Map<String,String> reprintMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BlogID= Integer.valueOf(reprintMap.get("BlogID"));
        Timestamp RecentFinishTime=new Timestamp(System.currentTimeMillis());
        Blog blog0=blogService.getBlogByBlogID(BlogID);
        try {
            Blog blog=new Blog();
            blog.setAuthorID(blog0.getAuthorID());
            blog.setBlogTitle(blog0.getBlogTitle());
            blog.setContent(blog0.getContent());
            blog.setAuthorID(UserID);
            blog.setRecentFinishTime(RecentFinishTime);
            blog.setIsReprint(1);
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(RecentFinishTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"转载了你的日志！");
            systemMessage.setUserID(blogService.getBlogByBlogID(BlogID).getAuthorID());
            blogService.reprintBlog(blog);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/CollectBlog")//收藏日志(已完成测试)
    public Map<String,Object> collectBlog(HttpServletRequest request,@RequestBody Map<String,String> collectBlogMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BlogID= Integer.valueOf(collectBlogMap.get("BlogID"));
        Timestamp CollectTime=new Timestamp(System.currentTimeMillis());
        try {
            BlogCollection blogCollection=new BlogCollection();
            blogCollection.setBlogID(BlogID);
            blogCollection.setUserID(UserID);
            blogCollection.setCollectTime(CollectTime);
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(CollectTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"收藏了你的日志！");
            systemMessage.setUserID(blogService.getBlogByBlogID(BlogID).getAuthorID());
            blogService.collectBlog(blogCollection);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/CancelCollectBlog")//取消收藏日志（已完成测试）
    public Map<String,Object> cancelCollectBlog(HttpServletRequest request,@RequestBody Map<String,String> cancelCollectBlogMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BlogID= Integer.valueOf(cancelCollectBlogMap.get("BlogID"));
        try {
            blogService.cancelCollectBlog(BlogID,UserID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/LikeBlog")//点赞日志(已完成测试)
    public Map<String,Object> likeBlog(HttpServletRequest request,@RequestBody Map<String,String> likeBlogMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BlogID= Integer.valueOf(likeBlogMap.get("BlogID"));
        Timestamp MessageTime=new Timestamp(System.currentTimeMillis());
        try {
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(MessageTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"点赞了你的日志！");
            systemMessage.setUserID(blogService.getBlogByBlogID(BlogID).getAuthorID());
            blogService.likeBlog(BlogID);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/CancelLikeBlog")//取消点赞日志（已完成测试）
    public Map<String,Object> cancelLikeBlog(@RequestBody Map<String,String> cancelLikeBlogMap){
        Map<String,Object> map=new HashMap<>();
        Integer BlogID= Integer.valueOf(cancelLikeBlogMap.get("BlogID"));
        try {
            blogService.cancelLikeBlog(BlogID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
