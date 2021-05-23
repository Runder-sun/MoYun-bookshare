package com.example.moyun.Dao;

import com.example.moyun.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void registerUser(User user);

    User getUserByUserID(String UserID);

    User getUserByUserIDAndPassword(String UserID,String Password);

    User getUserByUserIDAndEmail(String UserID,String Email);

    String getPasswordByUserID(String UserID);

    void updatePasswordByUserID(String UserID,String Password);
}
