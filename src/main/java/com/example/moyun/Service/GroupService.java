package com.example.moyun.Service;

import com.example.moyun.Entity.Book;
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

    //查看人数最多的Group(前8)
    List<Group> getHotGroup();

    //根据UserID查找GroupCollection
    List<Group> getGroupCollectionByUserID(String UserID);
}
