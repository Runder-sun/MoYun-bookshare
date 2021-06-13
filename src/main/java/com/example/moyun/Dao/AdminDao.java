package com.example.moyun.Dao;

import com.example.moyun.Entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    List<User> getAllUser();

    Admin getAdminByAdminID(String AdminID);

    Admin getAdminByAdminIDAndPassword(String AdminID,String Password);

    void updateUserIsForbidden(String UserID,Integer isForbidden);
}
