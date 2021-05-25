package com.example.moyun.Dao;

import com.example.moyun.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;

@Mapper
public interface UserDao {
    void registerUser(User user);

    User getUserByUserID(String UserID);

    User getUserByUserIDAndPassword(String UserID,String Password);

    User getUserByUserIDAndEmail(String UserID,String Email);

    String getPasswordByUserID(String UserID);

    void updatePasswordByUserID(String UserID,String Password);

    void updateUserInfo(String UserID,String Username, Boolean Sex,String Email, Date Birthday, String Signature);

    void updatePictures(String UserID,String HeadImage,String BackgroundImage);
}
