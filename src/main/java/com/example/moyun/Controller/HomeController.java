package com.example.moyun.Controller;

import com.example.moyun.Entity.Admin;
import com.example.moyun.Entity.Book;
import com.example.moyun.Entity.Group;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GroupService groupService;

    @PostMapping("/Register")//（已完成测试）
    public Map<String,Object> registerUser(@RequestBody Map<String,String> remap){
        String UserID=remap.get("UserID");
        String Password=remap.get("Password");
        String Password1=remap.get("rePassword");
        String Email=remap.get("Email");
        Map<String, Object> map = new HashMap<>();
        try{
            if(userService.getUserByUserID(UserID)!=null){
                map.put("success",false);
                map.put("message","用户ID已存在！");
            }
            else if(!Password.equals(Password1)){
                map.put("success",false);
                map.put("message","请输入一样的密码！");
            }
            else{
                User user=new User();
                user.setIsTeacher(userService.checkIsTeacher(UserID));
                user.setUserID(UserID);
                user.setEmail(Email);
                user.setPassword(DigestUtils.md5DigestAsHex(Password.getBytes(StandardCharsets.UTF_8)));
                userService.registerUser(user);
                map.put("success",true);
                map.put("message","用户注册成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","用户注册失败！");
        }
        return map;
    }

    @PostMapping("/Login")//（已完成测试）
    public Map<String,Object> login(HttpServletRequest request, @RequestBody Map<String, String> loginMap){
        String UserID = loginMap.get("UserID");
        String Password = loginMap.get("Password");
        Map<String, Object> map = new HashMap<>();
        try {
            User user=userService.getUserByUserIDAndPassword(UserID, DigestUtils.md5DigestAsHex(Password.getBytes(StandardCharsets.UTF_8)));
            Admin admin=adminService.getAdminByAdminIDAndPassword(UserID,Password);
            if (userService.getUserByUserID(UserID) == null&&adminService.getAdminByAdminID(UserID)==null) {
                map.put("success", false);
                map.put("message", "用户ID不存在！");
            }
            else if(user==null&&admin==null){
                map.put("success",false);
                map.put("message","密码错误！");
            }
            else{
                if(user==null){
                    HttpSession session=request.getSession();
                    session.setAttribute("UserID",UserID);
                    map.put("success", true);
                    map.put("message", "用户登录成功！");
                    map.put("isAdmin",true);
                    map.put("Admin",admin);
                }
                else{
                    if(user.getIsForbidden()==0){
                        HttpSession session=request.getSession();
                        session.setAttribute("UserID",UserID);
                        map.put("success", true);
                        map.put("message", "用户登录成功！");
                        map.put("isAdmin",false);
                        map.put("user",user);
                    }
                    else{
                        map.put("success",false);
                        map.put("message","当前用户被封禁！");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "用户登录失败！");
        }
        return map;
    }

    @PostMapping("/ForgetPassword")//（已完成测试）
    public Map<String,Object> forgetPassword(HttpServletRequest request,@RequestBody Map<String,String> forgetMap){
        String UserID=forgetMap.get("UserID");
        String Email=forgetMap.get("Email");
        Map<String,Object> map=new HashMap<>();
        try{
            if(userService.getUserByUserID(UserID)==null){
                map.put("success", false);
                map.put("message", "用户ID不存在！");
            }
            else if(userService.getUserByUserIDAndEmail(UserID,Email)==null){
                map.put("success", false);
                map.put("message", "用户邮箱不正确！");
            }
            else{
                HttpSession session=request.getSession();
                emailService.sendEmail(Email,session);
                map.put("success", true);
                map.put("message", "邮件已发送，请查看你绑定的邮箱！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "发送失败！");
        }
        return map;
    }

    @PostMapping("/code")//（已完成测试）
    public Map<String,Object> resetPassword(HttpServletRequest request,@RequestBody Map<String,String> resetMap){
        String UserID=resetMap.get("UserID");
        String Password=resetMap.get("Password");
        String Password1=resetMap.get("rePassword");

        String code=resetMap.get("code");
        Map<String,Object> map=new HashMap<>();
        try{
            if(!Password.equals(Password1)){
                map.put("success",false);
                map.put("message","请输入一样的密码！");
            }
            else if(!request.getSession().getAttribute("code").equals(code)){
                map.put("success",false);
                map.put("message","验证码错误");
            }
            else{
                userService.updatePasswordByUserID(UserID,DigestUtils.md5DigestAsHex(Password.getBytes(StandardCharsets.UTF_8)));
                request.getSession().removeAttribute("code");
                map.put("success",true);
                map.put("message","修改密码成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","修改失败！");
        }
        return map;
    }

    @PostMapping("/logout")//（已完成测试）
    public Map<String,Object> logout (HttpServletRequest request){
        Map<String ,Object> map=new HashMap<>();
        try {
            HttpSession session=request.getSession();
            session.removeAttribute("UserID");
            map.put("success",true);
            map.put("message","成功注销！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","注销失败！");
        }
        return map;
    }

    @GetMapping("/Home")//（已完成测试）
    public Map<String,Object> home(){
        Map<String,Object> map=new HashMap<>();
        try {
            List<Book> books= bookService.getHotBook();
            List<Group> groups=groupService.getHotGroup();
            map.put("hotBook",books);
            map.put("hotGroup",groups);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
