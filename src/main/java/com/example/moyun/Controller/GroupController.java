package com.example.moyun.Controller;

import com.example.moyun.Entity.*;
import com.example.moyun.Service.ForumService;
import com.example.moyun.Service.GroupService;
import com.example.moyun.Service.UserMessageService;
import com.example.moyun.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private UserMessageService userMessageService;

    @Autowired
    private UserService userService;

    @GetMapping("/GroupHome")//圈子主页（已完成测试）
    public Map<String,Object> groupHome(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        try {
            List<Group> HotGroup= groupService.getHotGroup();
            List<Group> UserGroup=groupService.getGroupListByUserID(UserID);
            map.put("HotGroup",HotGroup);
            map.put("UserGroup",UserGroup);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/GroupInfo")//圈子信息（已完成测试）
    public Map<String,Object> groupInfo(HttpServletRequest request,@RequestParam("GroupID")Integer GroupID){
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Map<String,Object> map=new HashMap<>();
        //Integer GroupID=Integer.valueOf(groupInfoMap.get("GroupID"));
        try {
            Group group=groupService.getGroupByGroupID(GroupID);
            List<GroupMember> groupMemberList=groupService.getGroupMemberListByGroupID(GroupID);
            List<User> users=new ArrayList<>();
            if(groupMemberList.size()!=0){
                for(GroupMember groupMember:groupMemberList){
                    users.add(userService.getUserByUserID(groupMember.getUserID()));
                }
            }
            boolean isCollect=groupService.isCollect(UserID,GroupID)!=null;
            List<Forum> HotForum=forumService.getHotForumByGroupID(GroupID);
            List<Task> taskList=groupService.getTaskList(GroupID);
            map.put("GroupInfo",group);
            map.put("MemberList",groupMemberList);
            map.put("MemberUser",users);
            map.put("HotForum",HotForum);
            map.put("TaskList",taskList);
            map.put("isCollect",isCollect);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteGroup")//删除圈子(已完成测试)
    public Map<String,Object> deleteGroup(@RequestBody Map<String,String> delmap){
        Integer GroupID= Integer.valueOf(delmap.get("GroupID"));
        Map<String,Object> map=new HashMap<>();
        try {
            groupService.deleteGroupCollection(GroupID);
            forumService.deleteForumMessageByGroupID(GroupID);
            forumService.deleteForumByGroupID(GroupID);
            groupService.deleteTask(GroupID);
            groupService.deleteGroupApplyByGroupID(GroupID);
            groupService.deleteMemberList(GroupID);
            groupService.deleteGroup(GroupID);
            map.put("success",true);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/addGroup")//创建圈子（已完成测试）
    public Map<String,Object> addGroup(HttpServletRequest request, @RequestParam("GroupName") String GroupName, @RequestParam("Tag") String Tag,@RequestParam("Introduce")String Introduce,@RequestParam("isPrivate") Integer isPrivate,@RequestParam("file") MultipartFile file){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String CreateID= String.valueOf(session.getAttribute("UserID"));
        Timestamp CreateTime=new Timestamp(System.currentTimeMillis());
        if(file.isEmpty()){
            map.put("success",false);
        }
        String filename=file.getOriginalFilename();
        String newName= UUID.randomUUID()+filename;
        File dest=new File(newName);
        try {
            file.transferTo(dest);
            String GroupImage=dest.getPath();
            try {
                Group group=new Group();
                group.setCreateID(CreateID);
                group.setGroupName(GroupName);
                group.setCreateTime(CreateTime);
                group.setIntroduce(Introduce);
                group.setTag(Tag);
                group.setGroupImage(GroupImage);
                group.setIsPrivate(isPrivate);
                groupService.addGroup(group);
                map.put("success",true);
            }catch (Exception e){
                e.printStackTrace();
                map.put("success",false);
            }
        }catch (IOException e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/applyGroup")//申请加入圈子（已完成测试）
    public Map<String,Object> applyGroup(HttpServletRequest request,@RequestBody Map<String,String> applyGroupMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String ApplyUserID= String.valueOf(session.getAttribute("UserID"));
        Integer GroupID= Integer.valueOf(applyGroupMap.get("GroupID"));
        Timestamp ApplyTime=new Timestamp(System.currentTimeMillis());
        try {
            GroupApply groupApply=new GroupApply();
            groupApply.setGroupID(GroupID);
            groupApply.setApplyTime(ApplyTime);
            groupApply.setApplyUserID(ApplyUserID);
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(ApplyTime);
            systemMessage.setSystemMessageContent(userService.getUserByUserID(ApplyUserID).getUsername()+"申请加入圈子"+groupService.getGroupByGroupID(GroupID).getGroupName()+"!");
            systemMessage.setUserID(groupService.getGroupByGroupID(GroupID).getCreateID());
            groupService.addGroupApply(groupApply);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/addMember")//批准申请，添加用户（已完成测试）
    public Map<String,Object> addMember(@RequestBody Map<String,String> addMemberMap){
        Map<String,Object> map=new HashMap<>();
        Integer GroupApplyID= Integer.valueOf(addMemberMap.get("GroupApplyID"));
        Integer GroupId=Integer.valueOf(addMemberMap.get("GroupID"));
        String UserID=addMemberMap.get("UserID");
        try {
            GroupMember groupMember=new GroupMember();
            groupMember.setGroupID(GroupId);
            groupMember.setUserID(UserID);
            groupService.deleteGroupApply(GroupApplyID);
            groupService.addGroupMember(groupMember);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/refuseApply")//拒绝申请(已完成测试)
    public Map<String,Object> refuseApply(@RequestBody Map<String,String> refuseApplyMap){
        Map<String,Object> map=new HashMap<>();
        Integer GroupID=Integer.valueOf(refuseApplyMap.get("GroupID"));
        Integer GroupApplyID= Integer.valueOf(refuseApplyMap.get("GroupApplyID"));
        Timestamp MessageTime=new Timestamp(System.currentTimeMillis());
        try {
            SystemMessage systemMessage=new SystemMessage();
            systemMessage.setMessageTime(MessageTime);
            systemMessage.setSystemMessageContent("您被拒绝加入圈子"+groupService.getGroupByGroupID(GroupID)+"!");
            systemMessage.setUserID(groupService.getGroupApplyByGroupApplyID(GroupApplyID).getApplyUserID());
            groupService.deleteGroupApply(GroupApplyID);
            userMessageService.addSystemMessage(systemMessage);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/changeGroupInfo")//修改圈子信息（已完成测试）
    public Map<String,Object> changeGroupInfo(@RequestBody Map<String,String> changeGroupInfoMap){
        Map<String,Object> map=new HashMap<>();
        Integer GroupID=Integer.valueOf(changeGroupInfoMap.get("GroupID"));
        String GroupName=changeGroupInfoMap.get("GroupName");
        String Tag=changeGroupInfoMap.get("Tag");
        String Introduce=changeGroupInfoMap.get("Introduce");
        Integer isPrivate=Integer.valueOf(changeGroupInfoMap.get("isPrivate"));
        try {
            groupService.updateGroupInfo(GroupID,GroupName,Tag,isPrivate,Introduce);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/deleteMember")//删除圈子成员(已完成测试)
    public Map<String,Object> deleteMember(@RequestBody Map<String,String> deleteMemberMap){
        Map<String,Object> map=new HashMap<>();
        Integer MemberID=Integer.valueOf(deleteMemberMap.get("MemberID"));
        try {
            groupService.deleteGroupMember(MemberID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/CollectGroup")//收藏圈子（已完成测试）
    public Map<String,Object> collectGroup(HttpServletRequest request,@RequestBody Map<String,String> collectGroupMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID= String.valueOf(session.getAttribute("UserID"));
        Integer GroupID=Integer.valueOf(collectGroupMap.get("GroupID"));
        Timestamp CollectTime=new Timestamp(System.currentTimeMillis());
        try {
            GroupCollection groupCollection=new GroupCollection();
            groupCollection.setGroupID(GroupID);
            groupCollection.setCollectTime(CollectTime);
            groupCollection.setUserID(UserID);
            groupService.collectGroup(groupCollection);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @PostMapping("/cancelCollectGroup")//取消收藏圈子（已完成测试）
    public Map<String,Object> cancelCollectGroup(HttpServletRequest request,@RequestBody Map<String,String> cancelCollectGroupMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String UserID=String.valueOf(session.getAttribute("UserID"));
        Integer GroupID=Integer.valueOf(cancelCollectGroupMap.get("GroupID"));
        try {
            groupService.cancelCollectGroup(GroupID,UserID);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @GetMapping("/GroupApplyList")//获取申请列表（已完成测试）
    public Map<String,Object> groupApplyList(@RequestParam("GroupID")Integer GroupID){
        Map<String,Object> map=new HashMap<>();
        //Integer GroupID=Integer.valueOf(groupApplyListMap.get("GroupID"));
       try {
           List<GroupApply> groupApplyList=groupService.getGroupApplyListByGroupID(GroupID);
           List<User> users=new ArrayList<>();
           if(groupApplyList.size()!=0){
               for(GroupApply groupApply:groupApplyList){
                   users.add(userService.getUserByUserID(groupApply.getApplyUserID()));
               }
           }
           map.put("GroupApplyList",groupApplyList);
           map.put("GroupApplyUser",users);
           map.put("success",true);
       }catch (Exception e){
           e.printStackTrace();
           map.put("success",false);
       }
        return map;
    }

    @PostMapping("/addTask")//发布任务(已完成测试)
    public Map<String,Object> addTask(HttpServletRequest request,@RequestBody Map<String,String> addTaskMap){
        Map<String,Object> map=new HashMap<>();
        HttpSession session=request.getSession();
        String CreateID= String.valueOf(session.getAttribute("UserID"));
        Integer GroupID= Integer.valueOf(addTaskMap.get("GroupID"));
        String TaskContent=addTaskMap.get("TaskContent");
        Timestamp CreateTime=new Timestamp(System.currentTimeMillis());
        try {
            Task task=new Task();
            task.setGroupID(GroupID);
            task.setCreateID(CreateID);
            task.setTaskContent(TaskContent);
            task.setCreateTime(CreateTime);
            groupService.addTask(task);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /* @GetMapping("/searchGroup")//所有圈子（即搜索圈子）(已完成测试)
    public Map<String,Object> searchGroup(@RequestParam("GroupName")String GroupName,@RequestParam("Tag")String Tag){
        //String GroupName=allGroupMap.get("GroupName");
        //String Tag= allGroupMap.get("Tag");
        Map<String,Object> map=new HashMap<>();
        try {
            List<Group> groups=groupService.searchGroup(GroupName,Tag);
            map.put("group",groups);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

     */

    @GetMapping("/searchGroup")//所有圈子（即搜索圈子）(已完成测试)
    public Map<String,Object> searchGroup(){
        //String GroupName=allGroupMap.get("GroupName");
        //String Tag= allGroupMap.get("Tag");
        Map<String,Object> map=new HashMap<>();
        try {
            List<Group> groups=groupService.searchAllGroup();
            map.put("group",groups);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }
}
