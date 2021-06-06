package com.example.moyun.Controller;

import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.SystemMessage;
import com.example.moyun.Entity.User;
import com.example.moyun.Entity.UserMessage;
import com.example.moyun.Service.UserMessageService;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageController {
    @Autowired
    private UserMessageService userMessageService;

    @Autowired
    private UserService userService;

    @GetMapping("/SystemMessage")//系统消息列表（已完成）
    public Map<String,Object> getSystemMessageList(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<SystemMessage> systemMessageList=userMessageService.getSystemMessageByUserID(UserID);
            map.put("SystemMessageList",systemMessageList);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/ChatMessageList")//用户间私信列表（已完成）
    public Map<String,Object> getChatMessageList(HttpServletRequest request, @RequestBody Map<String,String> chatMessageMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String SendID= String.valueOf(session.getAttribute("UserID"));
        String GetID=chatMessageMap.get("GetID");
        try {
            User send=userService.getUserByUserID(SendID);
            User get= userService.getUserByUserID(GetID);
            List<UserMessage> userMessageList=userMessageService.getUserMessageListBySendIDAndGetID(SendID,GetID);
            map.put("UserMessageList",userMessageList);
            map.put("sendUser",send);
            map.put("getUser",get);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/SendMessage")//发送私信（已完成）
    public Map<String,Object> sendMessage(HttpServletRequest request,@RequestBody Map<String,String> sendMessageMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String SendID= String.valueOf(session.getAttribute("UserID"));
        String GetID=sendMessageMap.get("GetID");
        String Message=sendMessageMap.get("Message");
        Timestamp SendTime=new Timestamp(System.currentTimeMillis());
        try {
            UserMessage userMessage=new UserMessage();
            userMessage.setSendID(SendID);
            userMessage.setGetID(GetID);
            userMessage.setMessage(Message);
            userMessage.setSendTime(SendTime);
            userMessageService.addUserMessage(userMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/getRecommend")//获取个性化推荐（已完成）
    public Map<String,Object> getRecommend(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<Book> recommendBookList=userMessageService.getPersonalRecommend(UserID);
            map.put("recommend",recommendBookList);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/MessageHome")//用户私信的对话对象（已完成）
    public Map<String,Object> messageHome(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<User> MessageTargetList= userMessageService.getMessageTarget(UserID);
            map.put("MessageTargetList",MessageTargetList);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
