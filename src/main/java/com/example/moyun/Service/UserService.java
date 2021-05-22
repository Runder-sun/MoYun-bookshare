package com.example.moyun.Service;

import com.example.moyun.Entity.User;

public interface UserService {
    //注册
    void registerUser(User user);

    //判断身份
    Boolean checkIsTeacher(String UserID);

    //根据UserID查找User
    User getUserByUserID(String UserID);

    //判断密码是否正确
    User getUserByUserIDAndPassword(String UserID,String Password);

    //判断邮箱是否正确
    User getUserByUserIDAndEmail(String UserID,String Email);

    //根据UserID查找Password
    String getPasswordByUserID(String UserID);

    //修改密码
    void updatePasswordByUserID(String UserID,String Password);
}
