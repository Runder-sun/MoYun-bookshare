package com.example.moyun.Service;

import com.example.moyun.Entity.Group;
import com.example.moyun.Vo.GroupVo;

import java.util.List;

public interface GroupService {
    //删除Group
    void deleteGroup(Integer GroupID);

    //查看全部Group
    List<Group> getAllGroup();

    //根据GroupID查找Group
    Group getGroupByGroupID(Integer GroupID);

    //GroupList转GroupVoList
    List<GroupVo> GroupToGroupVo(List<Group> list);
}
