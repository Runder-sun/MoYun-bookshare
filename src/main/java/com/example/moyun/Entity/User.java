package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="user_info")
public class User {
    @Id
    @Column(name="UserID")
    private String UserID;
    private String Password;
    private String Username;
    private boolean isTeacher;
    private boolean Sex;
    private String Email;
    private Date Birthday;
    private String Signature;
    private String HeadImage;
    private String BackgroundImage;

    public User(String userID, String password, String username, boolean isTeacher, boolean sex, String email, Date birthday, String signature, String headImage, String backgroundImage) {
        UserID = userID;
        Password = password;
        Username = username;
        this.isTeacher = isTeacher;
        Sex = sex;
        Email = email;
        Birthday = birthday;
        Signature = signature;
        HeadImage = headImage;
        BackgroundImage = backgroundImage;
    }

    public User() {
    }


    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String headImage) {
        HeadImage = headImage;
    }

    public String getBackgroundImage() {
        return BackgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        BackgroundImage = backgroundImage;
    }


}
