package com.example.moyun.Dao;

import com.example.moyun.Entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {
    void deleteGroup(Integer GroupID);

    List<Group> getAllGroup();

    Group getGroupByGroupID(Integer GroupID);

    List<Group> getHotGroup();

    List<Group> getGroupCollectionByUserID(String UserID);
}
