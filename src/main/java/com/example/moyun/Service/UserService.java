package com.example.moyun.Service;

import com.example.moyun.Entity.Blacklist;
import com.example.moyun.Entity.FollowList;
import com.example.moyun.Entity.User;

import java.sql.Date;
import java.util.List;

public interface UserService {
    //注册
    void registerUser(User user);

    //判断身份
    Boolean checkIsTeacher(String UserID);

    //查看个人信息
    User getUserByUserID(String UserID);

    //判断密码是否正确
    User getUserByUserIDAndPassword(String UserID,String Password);

    //判断邮箱是否正确
    User getUserByUserIDAndEmail(String UserID,String Email);

    //修改密码
    void updatePasswordByUserID(String UserID,String Password);

    //修改用户信息(不包括头像及背景)
    void updateUserInfo(String UserID,String Username, Boolean Sex,String Email,Date Birthday,String Signature);

    //修改头像、背景
    void updatePictures(String UserID,String HeadImage,String BackgroundImage);

    //关注用户
    void addFollow(FollowList followList);

    //取消关注
    void deleteFollow(Integer FollowListID);

    //获取用户关注列表
    List<FollowList> getFollowListByUserID(String UserID);

    //屏蔽用户
    void addBlacklist(Blacklist blacklist);

    //取消屏蔽
    void deleteBlacklist(Integer BlacklistID);

    //获取屏蔽列表
    List<Blacklist> getBlacklistByUserID(String UserID);
}
