package com.example.moyun.Service.Impl;

import com.example.moyun.Dao.GroupDao;
import com.example.moyun.Entity.Group;
import com.example.moyun.Service.GroupService;
import com.example.moyun.Vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;

    @Override
    public void deleteGroup(Integer GroupID){
        groupDao.deleteGroup(GroupID);
    }

    @Override
    public List<Group> getAllGroup(){
        return groupDao.getAllGroup();
    }

    @Override
    public Group getGroupByGroupID(Integer GroupID){
        return groupDao.getGroupByGroupID(GroupID);
    }

    @Override
    public List<GroupVo> GroupToGroupVo(List<Group> list){
        List<GroupVo> groupVos=new ArrayList<>();
        for (Group group:list){
            GroupVo groupVo=new GroupVo();
            groupVo.setGroupID(group.getGroupID());
            //待确认的属性
            groupVos.add(groupVo);
        }
        return groupVos;
    }

    @Override
    public List<Group> getHotGroup(){
        return groupDao.getHotGroup();
    }
}
