package com.example.moyun.Controller;


import com.example.moyun.Entity.*;
import com.example.moyun.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/PersonalInfo")
    public Map<String,Object> personalInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        Map<String,Object> map=new HashMap<>();
        User user=userService.getUserByUserID(String.valueOf(session.getAttribute("UserID")));
        map.put("personalInfo",user);
        return map;
    }

    @PostMapping("/ChangePersonalInfo")
    public Map<String,Object> changePersonalInfo(HttpServletRequest request, @RequestBody Map<String,String> changeInfoMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        String Username=changeInfoMap.get("Username");
        Boolean Sex=Boolean.valueOf(changeInfoMap.get("Sex"));
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

    @PostMapping("/ChangePictures")
    public Map<String,Object> changePictures(HttpServletRequest request,@RequestBody Map<String,String> changePictureMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        String HeadImage=changePictureMap.get("HeadImage");
        String BackgroundImage=changePictureMap.get("BackgroundImage");
        try{
            userService.updatePictures(UserID,HeadImage,BackgroundImage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/PersonalCollection")
    public Map<String,Object> personalCollection(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        List<Blog> blogCollection=blogService.getBlogCollectionByUserID(UserID);
        List<Book> bookCollection=bookService.getBookCollectionByUserID(UserID);
        List<BookReview> bookReviewCollection=bookReviewService.getBookReviewCollectionByUserID(UserID);
        List<Group> groupCollection=groupService.getGroupCollectionByUserID(UserID);
        map.put("blogCollection",blogCollection);
        map.put("bookCollection",bookCollection);
        map.put("bookReviewCollection",bookReviewCollection);
        map.put("groupCollection",groupCollection);
        return map;
    }
}
