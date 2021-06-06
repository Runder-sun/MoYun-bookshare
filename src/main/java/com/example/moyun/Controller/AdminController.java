package com.example.moyun.Controller;

import com.example.moyun.Entity.*;
import com.example.moyun.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BookReviewService bookReviewService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserMessageService userMessageService;

    @GetMapping("/admin")//管理员主页面(已完成)
    public Map<String,Object> admin(){
        Map<String,Object> map=new HashMap<>();
        try {
            List<User> users=adminService.getAllUser();
            List<Blog> blogs=blogService.getAllBlog();
            List<Book> books=bookService.getAllBook();
            List<Forum> forums=forumService.getAllForum();
            List<Group> groups=groupService.getAllGroup();
            List<BookReview> bookReviews=bookReviewService.getAllBookReview();
            map.put("users",users);
            map.put("blogs",blogs);
            map.put("books",books);
            map.put("forums",forums);
            map.put("groups",groups);
            map.put("bookReviews",bookReviews);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/forbidUser")//管理员封禁用户(已完成)
    public Map<String,Object> forbidUser(@RequestBody Map<String,String> forbidmap){
        Map<String,Object> map=new HashMap<>();
        String UserID=forbidmap.get("UserID");
        Timestamp MessageTime=new Timestamp(System.currentTimeMillis());
        try{
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setUserID(UserID);
            systemMessage.setMessageTime(MessageTime);
            systemMessage.setSystemMessageContent("您被封禁了，请注意您的言行！");
            adminService.updateUserIsForbidden(UserID,true);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/unblockUser")//管理员解封用户(已完成)
    public Map<String,Object> unblockUser(@RequestBody Map<String,String> unblockmap){
        Map<String,Object> map=new HashMap<>();
        String UserID=unblockmap.get("UserID");
        try{
            adminService.updateUserIsForbidden(UserID,false);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
