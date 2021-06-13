package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.UserDao;
import com.example.moyun.Entity.Blacklist;
import com.example.moyun.Entity.FollowList;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user){
        userDao.registerUser(user);
    }

    @Override
    public Integer checkIsTeacher(String UserID){
        if(UserID.startsWith("JS")){
            return 1;
        }
        else {
            return 0;
        }
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

    @Override
    public void updateUserInfo(String UserID,String Username, Integer Sex, String Email,Date Birthday, String Signature){
        userDao.updateUserInfo(UserID,Username,Sex,Email,Birthday,Signature);
    }

    @Override
    public void updatePictures(String UserID,String HeadImage,String BackgroundImage){
        userDao.updatePictures(UserID,HeadImage,BackgroundImage);
    }

    @Override
    public void addFollow(FollowList followList){
        userDao.addFollow(followList);
    }

    @Override
    public void deleteFollow(Integer FollowListID){
        userDao.deleteFollow(FollowListID);
    }

    @Override
    public List<FollowList> getFollowListByUserID(String UserID){
        return userDao.getFollowListByUserID(UserID);
    }

    @Override
    public void addBlacklist(Blacklist blacklist){
        userDao.addBlacklist(blacklist);
    }

    @Override
    public void deleteBlacklist(Integer BlacklistID){
        userDao.deleteBlacklist(BlacklistID);
    }

    @Override
    public List<Blacklist> getBlacklistByUserID(String UserID){
        return userDao.getBlacklistByUserID(UserID);
    }

    @Override
    public FollowList isFollow(String MyID,String UserID){
        return userDao.isFollow(MyID,UserID);
    }

    @Override
    public Blacklist isBan(String MyID,String UserID){
        return userDao.isBan(MyID,UserID);
    }
}
