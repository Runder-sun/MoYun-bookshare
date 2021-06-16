package com.example.moyun.Controller;

import com.example.moyun.Entity.Forum;
import com.example.moyun.Entity.ForumMessage;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.ForumService;
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
public class ForumController {
    @Autowired
    private ForumService forumService;
    @Autowired
    private UserService userService;

    @GetMapping("/ForumHome")//讨论区主页（已完成测试）
    public Map<String,Object> forumHome(@RequestParam("GroupID")Integer GroupID){
        Map<String,Object> map=new HashMap<>();
        //Integer GroupID=Integer.valueOf(forumHomeMap.get("GroupID"));
        try {
            List<Forum> GroupForum=forumService.getForumByGroupID(GroupID);
            map.put("GroupForum",GroupForum);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/getForumMessage")//获取讨论消息（已完成测试）
    public Map<String,Object> getForumMessage(@RequestParam("ForumID")Integer ForumID){
        Map<String,Object> map=new HashMap<>();
        //Integer ForumID= Integer.valueOf(forumMessageMap.get("ForumID"));
       try {
           Forum forum=forumService.getForumByForumID(ForumID);
           List<ForumMessage> forumMessageList=forumService.getForumMessageListByForumID(ForumID);
           List<User> users=new ArrayList<>();
           if(forumMessageList.size()!=0){
               for (ForumMessage forumMessage:forumMessageList){
                   users.add(userService.getUserByUserID(forumMessage.getUserID()));
               }
           }
           map.put("ForumMessageList",forumMessageList);
           map.put("ForumMessageUser",users);
           map.put("Forum",forum);
           map.put("success",true);
       }catch (Exception e){
           e.printStackTrace();
           map.put("success",false);
       }
        return map;
    }

    @PostMapping("/addMessage")//发送消息（已完成测试）
    public Map<String,Object> addMessage(HttpServletRequest request,@RequestBody Map<String,String> addMessageMap){
        Map<String,Object> map=new HashMap<>();
        Integer ForumID=Integer.valueOf(addMessageMap.get("ForumID"));
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        String Comment=addMessageMap.get("Comment");
        Timestamp CommentTime=new Timestamp(System.currentTimeMillis());
        try {
            ForumMessage forumMessage=new ForumMessage();
            forumMessage.setForumID(ForumID);
            forumMessage.setUserID(UserID);
            forumMessage.setComment(Comment);
            forumMessage.setCommentTime(CommentTime);
            forumService.addForumMessage(forumMessage);
            forumService.addMessageNum(ForumID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/addForum")//发起讨论（已完成测试）
    public Map<String,Object> addForum(HttpServletRequest request,@RequestBody Map<String,String> addForumMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String CreateID=String.valueOf(session.getAttribute("UserID"));
        String Topic=addForumMap.get("Topic");
        Integer GroupID=Integer.valueOf(addForumMap.get("GroupID"));
        Timestamp CreateTime=new Timestamp(System.currentTimeMillis());
        try {
            Forum forum=new Forum();
            forum.setCreateID(CreateID);
            forum.setCreateTime(CreateTime);
            forum.setGroupID(GroupID);
            forum.setTopic(Topic);
            forumService.addForum(forum);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteForum")//删除讨论（已完成）
    public Map<String,Object> deleteForum(@RequestBody Map<String,String> delmap){
        Integer ForumID= Integer.valueOf(delmap.get("ForumID"));
        Map<String,Object> map=new HashMap<>();
        try {
            forumService.deleteForumMessage(ForumID);
            forumService.deleteForum(ForumID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
