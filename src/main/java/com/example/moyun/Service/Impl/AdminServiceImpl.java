package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.AdminDao;
import com.example.moyun.Entity.Admin;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.AdminService;
import com.example.moyun.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public void deleteUser(String UserID){
        adminDao.deleteUser(UserID);
    }

    @Override
    public List<User> getAllUser(){
        return adminDao.getAllUser();
    }

    @Override
    public List<UserVo> UserToUserVo(List<User> list){
        List<UserVo> userVos=new ArrayList<>();
        for (User user:list){
            UserVo userVo=new UserVo();
            userVo.setUserID(user.getUserID());
            //待确认的属性
            userVos.add(userVo);
        }
        return userVos;
    }

    @Override
    public Admin getAdminByAdminID(String AdminID){
        return adminDao.getAdminByAdminID(AdminID);
    }

    @Override
    public Admin getAdminByAdminIDAndPassword(String AdminID,String Password){
        return adminDao.getAdminByAdminIDAndPassword(AdminID,Password);
    }

    @Override
    public void updateUserIsForbidden(String UserID,Boolean isForbidden){
        adminDao.updateUserIsForbidden(UserID,isForbidden);
    }
}
