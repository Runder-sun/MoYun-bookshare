package com.example.moyun.Controller;

import com.example.moyun.Entity.*;
import com.example.moyun.Service.*;
import com.example.moyun.Vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;

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

    @GetMapping("/admin")
    public Map<String,Object> admin(){
        Map<String,Object> admap=new HashMap<>();
        List<User> users=adminService.getAllUser();
        List<Blog> blogs=blogService.getAllBlog();
        List<Book> books=bookService.getAllBook();
        List<Forum> forums=forumService.getAllForum();
        List<Group> groups=groupService.getAllGroup();
        List<UserMessage> userMessages=userMessageService.getAllUserMessage();
        List<BookReview> bookReviews=bookReviewService.getAllBookReview();
        admap.put("users",users);
        admap.put("blogs",blogs);
        admap.put("books",books);
        admap.put("forums",forums);
        admap.put("groups",groups);
        admap.put("userMessages",userMessages);
        admap.put("bookReviews",bookReviews);
        return admap;
    }

    @PostMapping("/deleteUser")
    public Map<String,Object> deleteUser(@RequestBody Map<String,String> delmap){
        String UserID=delmap.get("UserID");
        Map<String,Object> map=new HashMap<>();
        try{
            adminService.deleteUser(UserID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectUser")
    public Map<String,Object> inspectUser(@RequestBody Map<String,String> insmap){
        String UserID=insmap.get("UserID");
        Map<String,Object> map=new HashMap<>();
        try{
            User user=userService.getUserByUserID(UserID);
            map.put("success",true);
            map.put("userInfo",user);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/forbidUser")
    public Map<String,Object> forbidUser(@RequestBody Map<String,String> forbidmap){
        Map<String,Object> map=new HashMap<>();
        try{
            adminService.updateUserIsForbidden(forbidmap.get("UserID"),true);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/unblockUser")
    public Map<String,Object> unblockUser(@RequestBody Map<String,String> unblockmap){
        Map<String,Object> map=new HashMap<>();
        try{
            adminService.updateUserIsForbidden(unblockmap.get("UserID"),false);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteBlog")
    public Map<String,Object> deleteBlog(@RequestBody Map<String,String> delmap){
        String BlogID=delmap.get("BlogID");
        Map<String,Object> map=new HashMap<>();
        try{
            blogService.deleteBlog(Integer.valueOf(BlogID));
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectBlog")
    public Map<String,Object> inspectBlog(@RequestBody Map<String,String> insmap){
        String BlogID=insmap.get("BlogID");
        Map<String,Object> map=new HashMap<>();
        try{
            Blog blog=blogService.getBlogByBlogID(Integer.valueOf(BlogID));
            map.put("success",true);
            map.put("blogInfo",blog);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteGroup")
    public Map<String,Object> deleteGroup(@RequestBody Map<String,String> delmap){
        String GroupID=delmap.get("GroupID");
        Map<String,Object> map=new HashMap<>();
        try {
            groupService.deleteGroup(Integer.valueOf(GroupID));
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectGroup")
    public Map<String,Object> inspectGroup(@RequestBody Map<String,String> insmap){
        String GroupID=insmap.get("GroupID");
        Map<String,Object> map=new HashMap<>();
        try {
            Group group=groupService.getGroupByGroupID(Integer.valueOf(GroupID));
            map.put("success",true);
            map.put("groupInfo",group);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteForum")
    public Map<String,Object> deleteForum(@RequestBody Map<String,String> delmap){
        String ForumID=delmap.get("ForumID");
        Map<String,Object> map=new HashMap<>();
        try {
            forumService.deleteForum(Integer.valueOf(ForumID));
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectForum")
    public Map<String,Object> inspectForum(@RequestBody Map<String,String> insmap){
        String ForumID=insmap.get("ForumID");
        Map<String,Object> map=new HashMap<>();
        try {
            Forum forum=forumService.getForumByForumID(Integer.valueOf(ForumID));
            map.put("success",true);
            map.put("forumInfo",forum);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteBook")
    public Map<String,Object> deleteBook(@RequestBody Map<String,String> delmap){
        String BookID=delmap.get("BookID");
        Map<String,Object> map=new HashMap<>();
        try {
            bookService.deleteBook(Integer.valueOf(BookID));
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectBook")
    public Map<String,Object> inspectBook(@RequestBody Map<String,String> insmap){
        String BookID=insmap.get("BookID");
        Map<String,Object> map=new HashMap<>();
        try {
            Book book=bookService.getBookByBookID(Integer.valueOf(BookID));
            map.put("success",true);
            map.put("bookInfo",book);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteBookReview")
    public Map<String,Object> deleteReview(@RequestBody Map<String,String>delmap) {
        String BookReviewID=delmap.get("BookReviewID");
        Map<String,Object> map=new HashMap<>();
        try {
            bookReviewService.deleteBookReview(Integer.valueOf(BookReviewID));
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectBookReview")
    public Map<String,Object> inspectReview(@RequestBody Map<String,String>insmap) {
        String BookReviewID=insmap.get("BookReviewID");
        Map<String,Object> map=new HashMap<>();
        try {
            BookReview bookReview=bookReviewService.getBookReviewByBookReviewID(Integer.valueOf(BookReviewID));
            map.put("success",true);
            map.put("bookReviewInfo",bookReview);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
