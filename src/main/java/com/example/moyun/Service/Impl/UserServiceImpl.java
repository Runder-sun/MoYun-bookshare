package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.UserDao;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user){
        userDao.registerUser(user);
    }

    @Override
    public Boolean checkIsTeacher(String UserID){
        return UserID.startsWith("JS");
    }

    @Override
    public User getUserByUserID(String UserID){
        return userDao.getUserByUserID(UserID);
    }

    @Override
    public User getUserByUserIDAndPassword(String UserID,String Password){
        return userDao.getUserByUserIDAndPassword(UserID,Password);
    }

    @Override
    public User getUserByUserIDAndEmail(String UserID,String Email){
        return userDao.getUserByUserIDAndEmail(UserID,Email);
    }

    @Override
    public void updatePasswordByUserID(String UserID,String Password){
        userDao.updatePasswordByUserID(UserID,Password);
    }
}
