package com.example.moyun.Service;

import com.example.moyun.Entity.*;

import java.util.List;

public interface AdminService {

    //查看全部User
    List<User> getAllUser();

    //根据AdminID查找Admin
    Admin getAdminByAdminID(String AdminID);

    //判断密码是否正确
    Admin getAdminByAdminIDAndPassword(String AdminID,String Password);

    //更新用户是否封禁信息
    void updateUserIsForbidden(String UserID,Integer isForbidden);
}
