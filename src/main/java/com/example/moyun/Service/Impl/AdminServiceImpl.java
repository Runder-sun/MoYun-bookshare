package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.AdminDao;
import com.example.moyun.Entity.Admin;
import com.example.moyun.Entity.User;
import com.example.moyun.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<User> getAllUser(){
        return adminDao.getAllUser();
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
    public void updateUserIsForbidden(String UserID,Integer isForbidden){
        adminDao.updateUserIsForbidden(UserID,isForbidden);
    }
}
