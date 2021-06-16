package com.example.moyun.Controller;

import com.example.moyun.Entity.BookReview;
import com.example.moyun.Entity.BookReviewComment;
import com.example.moyun.Entity.SystemMessage;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.BookReviewService;
import com.example.moyun.Service.BookService;
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
public class BookReviewController {
    @Autowired
    private BookReviewService bookReviewService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMessageService userMessageService;

    @GetMapping("/BookReview")//书评主页
    public Map<String,Object> bookReview(HttpServletRequest request){
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        try {
            List<BookReview> bookReviewCollection=bookReviewService.getBookReviewCollectionByUserID(UserID);
            List<BookReview> myBookReview=bookReviewService.getMyBookReview(UserID);
            map.put("bookReviewCollection",bookReviewCollection);
            map.put("MyBookReview",myBookReview);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/likeBookReview")//点赞书评(已完成测试)
    public Map<String,Object> likeBookReview(HttpServletRequest request,@RequestBody Map<String,String> lmap){
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Timestamp MessageTime=new Timestamp(System.currentTimeMillis());
        Integer BookReviewID=Integer.valueOf(lmap.get("BookReviewID"));
        Map<String,Object> map=new HashMap<>();
        try {
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(MessageTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"点赞了你的书评！");
            systemMessage.setUserID(bookReviewService.getBookReviewByBookReviewID(BookReviewID).getUserID());
            bookReviewService.likeBookReview(BookReviewID);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/cancelLikeBookReview")//取消点赞数书评(已完成测试)
    public Map<String,Object> cancelLikeBookReview(@RequestBody Map<String,String> lmap){
        Integer BookReviewID=Integer.valueOf(lmap.get("BookReviewID"));
        Map<String,Object> map=new HashMap<>();
        try {
            bookReviewService.cancelLikeBookReview(BookReviewID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/createBookReview")//写书评（已完成测试）
    public Map<String,Object> createBookReview(HttpServletRequest request, @RequestBody Map<String, String> rmap){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Integer BookID=Integer.valueOf(rmap.get("BookID"));
        String Title=rmap.get("Title");
        String Content=rmap.get("Content");
        Timestamp ReviewTime=new Timestamp(System.currentTimeMillis());
        Integer Score=Integer.valueOf(rmap.get("Score"));
        Map<String,Object> map=new HashMap<>();
        try {
            BookReview review=new BookReview();
            review.setBookID(BookID);
            review.setUserID(UserID);
            review.setTitle(Title);
            review.setContent(Content);
            review.setScore(Score);
            review.setReviewTime(ReviewTime);
            bookReviewService.createBookReviewByBookID(review);
            bookService.updateBookScore(BookID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/commentReview")//评论书评(已完成测试)
    public Map<String,Object> commentReview(HttpServletRequest request,@RequestBody Map<String,String> rmap){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Integer BookReviewID=Integer.valueOf(rmap.get("BookReviewID"));
        String Content=rmap.get("Content");
        Timestamp CommentTime=new Timestamp(System.currentTimeMillis());
        Map<String,Object> map=new HashMap<>();
        try {
            BookReviewComment comment=new BookReviewComment();
            comment.setUserID(UserID);
            comment.setBookReviewID(BookReviewID);
            comment.setContent(Content);
            comment.setCommentTime(CommentTime);
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(CommentTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"评论了你的书评！");
            systemMessage.setUserID(bookReviewService.getBookReviewByBookReviewID(BookReviewID).getUserID());
            bookReviewService.createBookReviewCommentByReviewID(comment);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/updateBookReview")//修改书评(已完成测试)
    public Map<String,Object> updateBookReview(@RequestBody Map<String,String> umap){
        Integer BookReviewID=Integer.valueOf(umap.get("BookReviewID"));
        String Content=umap.get("Content");
        String Title=umap.get("Title");
        Integer Score=Integer.valueOf(umap.get("Score"));
        Map<String,Object> map=new HashMap<>();
        try {
            bookReviewService.updateBookReview(BookReviewID,Content,Title,Score);
            bookService.updateBookScore(bookReviewService.getBookReviewByBookReviewID(BookReviewID).getBookID());
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteBookReview")//删除书评（已完成）
    public Map<String,Object> deleteReview(@RequestBody Map<String,String>delmap) {
        Integer BookReviewID= Integer.valueOf(delmap.get("BookReviewID"));
        Map<String,Object> map=new HashMap<>();
        try {
            bookReviewService.deleteRelatedComment(BookReviewID);
            bookReviewService.deleteCollectBookReview(BookReviewID);
            bookReviewService.deleteBookReview(BookReviewID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/collectBookReview")//收藏书评(已完成测试)
    public Map<String,Object> collectBookReview(HttpServletRequest request,@RequestBody Map<String,String> cmap){
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Integer BookReviewID=Integer.valueOf(cmap.get("BookReviewID"));
        Timestamp CollectTime=new Timestamp(System.currentTimeMillis());
        Map<String,Object> map=new HashMap<>();
        try {
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(CollectTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(UserID).getUsername()+"收藏了你的书评！");
            systemMessage.setUserID(bookReviewService.getBookReviewByBookReviewID(BookReviewID).getUserID());
            bookReviewService.collectBookReview(BookReviewID,UserID,CollectTime);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/cancelCollectBookReview")//取消收藏书评（已完成测试）
    public Map<String,Object> cancelCollectBookReview(HttpServletRequest request,@RequestBody Map<String,String> cancelCollectMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer BookReviewID=Integer.valueOf(cancelCollectMap.get("BookReviewID"));
        try {
            bookReviewService.cancelCollectBookReview(BookReviewID,UserID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/inspectBookReview")//查看书评（已完成测试）
    public Map<String,Object> inspectReview(HttpServletRequest request, @RequestParam("BookReviewID")Integer BookReviewID) {
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        // Integer BookReviewID= Integer.valueOf(insmap.get("BookReviewID"));
        Map<String,Object> map=new HashMap<>();
        try {
            BookReview bookReview=bookReviewService.getBookReviewByBookReviewID(BookReviewID);
            List<BookReviewComment> bookReviewComments=bookReviewService.getBookReviewCommentList(BookReviewID);
            List<User> users=new ArrayList<>();
            if(bookReviewComments.size()!=0){
                for(BookReviewComment bookReviewComment:bookReviewComments){
                    users.add(userService.getUserByUserID(bookReviewComment.getUserID()));
                }
            }
            User user=userService.getUserByUserID(bookReview.getUserID());
            boolean isCollect=bookReviewService.isCollect(UserID,BookReviewID)!=null;
            map.put("bookReviewInfo",bookReview);
            map.put("bookReviewCommentList",bookReviewComments);
            map.put("bookReviewCommentUser",users);
            map.put("isCollect",isCollect);
            map.put("user",user);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}

