package com.example.moyun.Controller;

import com.example.moyun.Entity.*;
import com.example.moyun.Service.BlogService;
import com.example.moyun.Service.BookReviewService;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DTController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BookReviewService bookReviewService;

    @Autowired
    private UserService userService;

    @GetMapping("/blogDT")//动态日志(已完成测试)
    public Map<String,Object> blogDT(HttpServletRequest request){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        try{
            List<Blog> blogList=blogService.getBlogDT(UserID);
            List<User> users=new ArrayList<>();
            if (blogList.size()!=0){
                for (Blog blog:blogList){
                    users.add(userService.getUserByUserID(blog.getAuthorID()));
                }
            }
            map.put("blogDT",blogList);
            map.put("blogDTUser",users);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/bookReviewDT")//书评动态（已完成测试）
    public Map<String,Object> bookReviewDT(HttpServletRequest request){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        try{
            List<BookReview> bookReviewList=bookReviewService.getBookReviewDT(UserID);
            List<User> users=new ArrayList<>();
            if (bookReviewList.size()!=0){
                for (BookReview bookReview:bookReviewList){
                    users.add(userService.getUserByUserID(bookReview.getUserID()));
                }
            }
            map.put("bookReviewDT",bookReviewList);
            map.put("bookReviewDTUser",users);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/FollowListAndBlacklist")//关注列表与黑名单（已完成测试）
    public Map<String,Object> followListAndBlacklist(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<FollowList> FollowList=userService.getFollowListByUserID(UserID);
            List<Blacklist> Blacklist= userService.getBlacklistByUserID(UserID);
            List<User> followUsers=new ArrayList<>();
            List<User> blacklistUsers=new ArrayList<>();
            if(FollowList.size()!=0){
                for (FollowList followList:FollowList){
                    followUsers.add(userService.getUserByUserID(followList.getFollowedID()));
                }
            }
            if(Blacklist.size()!=0){
                for (Blacklist blacklist:Blacklist){
                    blacklistUsers.add(userService.getUserByUserID(blacklist.getBanUserID()));
                }
            }
            map.put("FollowList",FollowList);
            map.put("Blacklist",Blacklist);
            map.put("Follow",followUsers);
            map.put("BlacklistUser",blacklistUsers);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/cancelFollow")//取消关注（已完成测试）
    public Map<String,Object> cancelFollow(@RequestBody Map<String,String> cancelFollowMap){
        Map<String,Object> map=new HashMap<>();
        Integer FollowListID=Integer.valueOf(cancelFollowMap.get("FollowListID"));
        try {
            userService.deleteFollow(FollowListID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/cancelBlacklist")//移除黑名单（已完成测试）
    public Map<String,Object> cancelBlacklist(@RequestBody Map<String,String> cancelBlacklistMap){
        Map<String,Object> map=new HashMap<>();
        Integer BlacklistID=Integer.valueOf(cancelBlacklistMap.get("BlacklistID"));
        try {
            userService.deleteBlacklist(BlacklistID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
