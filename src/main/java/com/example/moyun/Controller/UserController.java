package com.example.moyun.Controller;


import com.example.moyun.Entity.*;
import com.example.moyun.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private BookReviewService bookReviewService;

    @Autowired
    private UserMessageService userMessageService;

    @GetMapping("/PersonalInfo")//获取个人信息（已完成测试）
    public Map<String,Object> personalInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        Map<String,Object> map=new HashMap<>();
       try {
           User user=userService.getUserByUserID(String.valueOf(session.getAttribute("UserID")));
           map.put("personalInfo",user);
           map.put("success",true);
       }catch (Exception e){
           e.printStackTrace();
           map.put("success",false);
       }
        return map;
    }

    @GetMapping("/inspectUser")//查看其他用户信息（已完成测试）
    public Map<String,Object> inspectUser(HttpServletRequest request,@RequestBody Map<String,String> insmap){
        HttpSession session=request.getSession();
        String MyID= String.valueOf(session.getAttribute("UserID"));
        String UserID=insmap.get("UserID");
        Map<String,Object> map=new HashMap<>();
        try{
            User user=userService.getUserByUserID(UserID);
            boolean isFollowed=userService.isFollow(MyID, UserID) != null;
            boolean isBan=userService.isBan(MyID,UserID)!=null;
            map.put("success",true);
            map.put("userInfo",user);
            map.put("isFollowed",isFollowed);
            map.put("isBan",isBan);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/ChangePersonalInfo")//修改个人信息（已完成测试）
    public Map<String,Object> changePersonalInfo(HttpServletRequest request, @RequestBody Map<String,String> changeInfoMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        String Username=changeInfoMap.get("Username");
        Integer Sex=Integer.valueOf(changeInfoMap.get("Sex"));
        String Email=changeInfoMap.get("Email");
        Date Birthday= Date.valueOf(changeInfoMap.get("Birthday"));
        String Signature=changeInfoMap.get("Signature");
        try{
            userService.updateUserInfo(UserID,Username,Sex,Email,Birthday,Signature);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/ChangeHeadImage")//修改头像（已完成测试）
    public Map<String,Object> changeHeadImage(HttpServletRequest request,@RequestParam("file") MultipartFile file){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        if (file.isEmpty()){
            map.put("success",false);
            map.put("message","上传失败");
        }
        String filename1=file.getOriginalFilename();
        String newName1= UUID.randomUUID()+filename1;
        File dest1=new File(newName1);
        try {
            file.transferTo(dest1);
            String HeadImage=dest1.getPath();
            String BackgroundImage=userService.getUserByUserID(UserID).getBackgroundImage();
            try{
                userService.updatePictures(UserID,HeadImage,BackgroundImage);
                map.put("success",true);
            }catch (Exception e){
                e.printStackTrace();
                map.put("success",false);
            }
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/ChangeBackgroundImage")//修改背景（已完成测试）
    public Map<String,Object> ChangeBackgroundImage(HttpServletRequest request,@RequestParam("file") MultipartFile file){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        if (file.isEmpty()){
            map.put("success",false);
            map.put("message","上传失败");
        }
        String filename1=file.getOriginalFilename();
        String newName1= UUID.randomUUID()+filename1;
        File dest1=new File(newName1);
        try {
            file.transferTo(dest1);
            String BackgroundImage=dest1.getPath();
            String HeadImage=userService.getUserByUserID(UserID).getHeadImage();
            try{
                userService.updatePictures(UserID,HeadImage,BackgroundImage);
                map.put("success",true);
            }catch (Exception e){
                e.printStackTrace();
                map.put("success",false);
            }
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/PersonalCollection")//个人收藏（已完成测试）
    public Map<String,Object> personalCollection(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<BlogCollection> blogCollection=blogService.getBlogCollectionByUserID(UserID);
            List<BookCollection> bookCollection=bookService.getBookCollectionByUserID(UserID);
            List<BookReview> bookReviewCollection=bookReviewService.getBookReviewCollectionByUserID(UserID);
            List<GroupCollection> groupCollection=groupService.getGroupCollectionByUserID(UserID);
            List<Blog> blogs=new ArrayList<>();
            List<Book> books=new ArrayList<>();
            List<User> users=new ArrayList<>();
            List<User> users1=new ArrayList<>();
            if(blogCollection.size()!=0){
                for (BlogCollection blogCollection1:blogCollection){
                    blogs.add(blogService.getBlogByBlogID(blogCollection1.getBlogID()));
                    users1.add(userService.getUserByUserID(blogService.getBlogByBlogID(blogCollection1.getBlogID()).getAuthorID()));
                }
            }
            if(bookCollection.size()!=0){
                for (BookCollection bookCollection1:bookCollection){
                    books.add(bookService.getBookByBookID(bookCollection1.getBookID()));
                }
            }
            if(bookReviewCollection.size()!=0){
                for (BookReview bookReview:bookReviewCollection){
                    users.add(userService.getUserByUserID(bookReview.getUserID()));
                }
            }
            map.put("blogCollection",blogCollection);
            map.put("blogCollectionBlog",blogs);
            map.put("blogAuthor",users1);
            map.put("bookCollection",bookCollection);
            map.put("bookCollectionBook",books);
            map.put("bookReviewCollection",bookReviewCollection);
            map.put("bookReviewUser",users);
            map.put("groupCollection",groupCollection);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/addFollow")//关注用户(已完成测试)
    public Map<String,Object> addFollow(HttpServletRequest request,@RequestBody Map<String,String> addFollowMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String FollowerID= String.valueOf(session.getAttribute("UserID"));
        String FollowedID=addFollowMap.get("FollowedID");
        Timestamp FollowTime=new Timestamp(System.currentTimeMillis());
       try {
           FollowList followList=new FollowList();
           followList.setFollowedID(FollowedID);
           followList.setFollowerID(FollowerID);
           followList.setFollowTime(FollowTime);
           SystemMessage systemMessage=new SystemMessage();
           systemMessage.setMessageTime(FollowTime);
           systemMessage.setSystemMessageContent(userService.getUserByUserID(FollowerID).getUsername()+"关注了你！");
           systemMessage.setUserID(FollowedID);
           userService.addFollow(followList);
           userMessageService.addSystemMessage(systemMessage);
           map.put("success",true);
       }catch (Exception e){
           e.printStackTrace();
           map.put("success",false);
        }
        return map;
    }

    @PostMapping("/addBlacklist")//添加黑名单（已完成测试）
    public Map<String,Object> addBlacklist(HttpServletRequest request,@RequestBody Map<String,String> addBlacklistMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        String BanUserID=addBlacklistMap.get("BanUserID");
        Timestamp BanTime=new Timestamp(System.currentTimeMillis());
        try {
            Blacklist blacklist=new Blacklist();
            blacklist.setBanUserID(BanUserID);
            blacklist.setUserID(UserID);
            blacklist.setBanTime(BanTime);
            userService.addBlacklist(blacklist);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
