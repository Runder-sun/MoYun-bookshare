package com.example.moyun.Service;

import com.example.moyun.Entity.*;
import com.example.moyun.Vo.UserVo;

import java.util.List;

public interface AdminService {
    //删除User
    void deleteUser(String UserID);

    //查看全部User
    List<User> getAllUser();

    //UserList转UserVoList
    List<UserVo> UserToUserVo(List<User> list);

    //根据AdminID查找Admin
    Admin getAdminByAdminID(String AdminID);

    //判断密码是否正确
    Admin getAdminByAdminIDAndPassword(String AdminID,String Password);
}
